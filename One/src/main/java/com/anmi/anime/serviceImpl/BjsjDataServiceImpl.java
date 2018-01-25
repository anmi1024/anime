package com.anmi.anime.serviceImpl;

import com.anmi.anime.config.FPTConfig;
import com.anmi.anime.model.GafisGatherPalmEntity;
import com.anmi.anime.repository.daku.GatherPalmRepository;
import com.anmi.anime.service.BjsjDataService;
import com.anmi.anime.utils.ProcessImageAndFeatureUtil;
import com.anmi.anime.utils.ProtoHttpClientUtil;
import com.google.protobuf.ByteString;
import nirvana.hall.c.AncientConstants;
import nirvana.hall.c.services.gloclib.glocdef;
import nirvana.hall.extractor.internal.FeatureExtractorImpl;
import nirvana.hall.image.config.HallImageConfig;
import nirvana.hall.image.internal.FirmDecoderImpl;
import nirvana.hall.image.internal.ImageEncoderImpl;
import nirvana.hall.protocol.extract.ExtractProto;
import nirvana.hall.support.services.GAFISImageReaderSpi;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.UnhandledException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.spi.IIORegistry;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static com.anmi.anime.utils.ByteUtil.byteArray2Int;
import static com.anmi.anime.utils.ByteUtil.isHead7;

/**
 * Created by wangjue on 2017/11/29.
 */
@Service("bjsjDataService")
public class BjsjDataServiceImpl implements BjsjDataService{
    private Logger logger = Logger.getLogger(this.getClass());
    private int threadSize = 6;
    private volatile boolean running = true;
    private ExecutorService pool = Executors.newFixedThreadPool(threadSize+1+1);
    private LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(10);

    private synchronized Date getCurrentDate() {
        TimeZone tz = TimeZone.getTimeZone("Etc/GMT-8");
        TimeZone.setDefault(tz);
        return new Date();
    }
    private void registryImage() {
        IIORegistry iioRegistry = IIORegistry.getDefaultInstance();
        iioRegistry.registerServiceProvider(new GAFISImageReaderSpi());
    }
    private void loadJni() {
        nirvana.hall.extractor.jni.JniLoader.loadJniLibrary(".",null);
        nirvana.hall.image.jni.JniLoader.loadJniLibrary(".",null);
    }

    @Autowired
    private FPTConfig fptConfig;

    @Autowired
    private GatherPalmRepository gatherPalmRepository;

    private FirmDecoderImpl decoder = new FirmDecoderImpl(".",new HallImageConfig());
    private ImageEncoderImpl encoder = new ImageEncoderImpl(decoder);
    private FeatureExtractorImpl extractor = new FeatureExtractorImpl();

    @Override
    public void imageProcess(List<String> imageUrl) {
        loadJni();
        registryImage();
        imageUrl.forEach(url -> {
            byte[] data1 = ProtoHttpClientUtil.download(url);
            try {
                byte[] data = FileUtils.readFileToByteArray(new File("C:\\Users\\wangjue\\Desktop\\测试平台\\bjsj_palm\\bmp\\P5200000000002017099991_11.bmp"));
                InputStream in = new ByteArrayInputStream(data);
                byte[] feature = extractor.extractByGAFISIMGBinary(in, ExtractProto.FingerPosition.FINGER_UNDET,ExtractProto.ExtractRequest.FeatureType.PalmTemplate,ExtractProto.NewFeatureTry.V1).get()._1();

                glocdef.GAFISIMAGESTRUCT gafisimagestruct = extractor.readByteArrayAsGAFISIMAGE(new ByteArrayInputStream(data));
                gafisimagestruct.stHead().nImageType_$eq((byte)glocdef.GAIMG_IMAGETYPE_PALM());


                glocdef.GAFISIMAGESTRUCT wsq = encoder.encodeWSQ(gafisimagestruct);

                System.out.println(feature.length);
                System.out.println(wsq.bnData().length);
                FileUtils.writeByteArrayToFile(new File("C:\\Users\\wangjue\\Desktop\\测试平台\\bjsj_palm\\bmp\\P5200000000002017099991_11.mnt"),feature);
                FileUtils.writeByteArrayToFile(new File("C:\\Users\\wangjue\\Desktop\\测试平台\\bjsj_palm\\bmp\\P5200000000002017099991_11.wsq"),wsq.toByteArray(AncientConstants.UTF8_ENCODING(),ByteOrder.BIG_ENDIAN));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void savaPalmFeature(String personId, long fgp, byte[] mnt){
        GafisGatherPalmEntity palmEntity = new GafisGatherPalmEntity();
        palmEntity.setPkId(UUID.randomUUID().toString().replace("-",""));
        palmEntity.setPersonId(personId);
        palmEntity.setFgp(fgp);
        palmEntity.setGroupId(0);
        palmEntity.setLobtype(2);
        palmEntity.setInputpsn("1");
        palmEntity.setInputtime(getCurrentDate());
        palmEntity.setModifiedpsn("1");
        palmEntity.setModifiedtime(getCurrentDate());
        palmEntity.setGatherData(mnt);
        palmEntity.setSeq(gatherPalmRepository.getPalmSeq());
        gatherPalmRepository.save(palmEntity);

    }

    private void process(List<String> imagesUrl) {
        pool.execute(() -> {
            try {
                int total = imagesUrl.size();
                for (int i = 0; i < imagesUrl.size(); i++) {
                    String id = imagesUrl.get(i).trim();
                    if (!id.isEmpty()) {
                        queue.put(total+"-"+(i+1)+"-"+id);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        for (int i=0;i<threadSize;i++) {
            pool.execute(() -> {
                while (running) {
                    try {
                        String ids = queue.poll(2, TimeUnit.SECONDS);
                        if (ids == null || ids.isEmpty()) continue;
                        String[] queuePath = ids.split("-");
                        String total = queuePath[0];
                        String current = queuePath[1];
                        String id = queuePath[2];
                        try {
                            List<GafisGatherPalmEntity> gafisGatherPalmEntities = gatherPalmRepository.findByPersonIdAndFgpInAndGroupIdIn(id);
                            long palmMnt = gafisGatherPalmEntities.stream().filter(palmEntity -> palmEntity.getGroupId()==0).count();
                            if (palmMnt == 0) {
                                gafisGatherPalmEntities.forEach(palmEntity -> {
                                    if (palmEntity.getGroupId() == 1) {
                                        String personId = palmEntity.getPersonId();
                                        long fgp = palmEntity.getFgp();
                                        //System.out.println(total+"-"+current + " : " + personId + "-" + fgp + ", is processing!");
                                        byte[] palmImage = palmEntity.getGatherData();
                                        glocdef.GAFISIMAGESTRUCT gafisImg = new glocdef.GAFISIMAGESTRUCT();
                                        if (!isHead7(palmImage)) {
                                            gafisImg.fromByteArray(palmImage, AncientConstants.UTF8_ENCODING(), ByteOrder.BIG_ENDIAN);
                                        } else {
                                            byte[] blobPalmHead = new byte[128];
                                            System.arraycopy(palmImage,0,blobPalmHead,0,128);
                                            int width = byteArray2Int(blobPalmHead,92,4);
                                            int height = byteArray2Int(blobPalmHead,96,4);
                                            int dpi = byteArray2Int(blobPalmHead,16,2);
                                            byte[] blobPalmImage = new byte[palmImage.length-128];
                                            System.arraycopy(palmImage,128,blobPalmImage,0,blobPalmImage.length);
                                            gafisImg.stHead().nBits_$eq((byte) dpi);
                                            gafisImg.stHead().nResolution_$eq((short) 500);
                                            gafisImg.stHead().nHeight_$eq((short) height);
                                            gafisImg.stHead().nWidth_$eq((short) width);
                                            gafisImg.stHead().nImgSize_$eq(blobPalmImage.length);
                                            gafisImg.stHead().bIsCompressed_$eq((byte) 1);
                                            gafisImg.stHead().nCompressMethod_$eq((byte) glocdef.GAIMG_CPRMETHOD_XGW());
                                            gafisImg.bnData_$eq(blobPalmImage);
                                            gafisImg.stHead().nFingerIndex_$eq((byte) fgp);
                                            gafisImg.stHead().nImageType_$eq((byte) 2);
                                            gafisImg.stHead().szName_$eq("CardBinData3");
                                        }

                                        glocdef.GAFISIMAGESTRUCT dest = decoder.decodeRawImage(gafisImg);
                                        /*
                                        InputStream in = new ByteArrayInputStream(dest.toByteArray(AncientConstants.UTF8_ENCODING(), ByteOrder.BIG_ENDIAN));
                                        byte[] feature = extractor.extractByGAFISIMGBinary(in, ExtractProto.FingerPosition.FINGER_R_THUMB, ExtractProto.ExtractRequest.FeatureType.PalmTemplate, ExtractProto.NewFeatureTry.V1).get()._1();
                                        */
                                        try {
                                            ByteString[] mntAndBin = ProcessImageAndFeatureUtil.extractor(dest, personId, (int) fgp, 2, fptConfig.getExtractorUrl());
                                            ByteString reExtractorFeature = mntAndBin[0];
                                            ByteString reExtractorRidge = mntAndBin[1];
                                            savaPalmFeature(personId, fgp, reExtractorFeature.toByteArray());
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        System.out.println(total+"-"+current + " : " + personId+ "-" + fgp + ", save successful!");
                                    }
                                });
                            }
                        } catch(Exception e) {
                            e.printStackTrace();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public void imagesProcessByGAFIS(List<String> imagesUrl) {
        loadJni();
        process(imagesUrl);
    }


    @Override
    public void imagesProcessByGAFISSingle(List<String> imagesUrl) {
        loadJni();
        imagesUrl.forEach(id -> {
            List<GafisGatherPalmEntity> gafisGatherPalmEntities = gatherPalmRepository.findByPersonIdAndFgpInAndGroupIdIn(id);
            long palmMnt = gafisGatherPalmEntities.stream().filter(palmEntity -> palmEntity.getGroupId()==0).count();
            if (palmMnt == 0) {
                gafisGatherPalmEntities.forEach(palmEntity -> {
                    if (palmEntity.getGroupId() == 1) {
                        byte[] palmImage = palmEntity.getGatherData();
                        if (isHead7(palmImage)) {
                            byte[] blobPalmHead = new byte[128];
                            System.arraycopy(palmImage,0,blobPalmHead,0,128);
                            int width = byteArray2Int(blobPalmHead,92,4);
                            int height = byteArray2Int(blobPalmHead,96,4);
                            int dpi = byteArray2Int(blobPalmHead,16,2);

                            byte[] blobPalmImage = new byte[palmImage.length-128];
                            System.arraycopy(palmImage,128,blobPalmImage,0,blobPalmImage.length);

                            glocdef.GAFISIMAGESTRUCT gafisimagestruct = new glocdef.GAFISIMAGESTRUCT();
                            gafisimagestruct.stHead().nBits_$eq((byte) dpi);
                            gafisimagestruct.stHead().nResolution_$eq((short) 500);
                            gafisimagestruct.stHead().nHeight_$eq((short) height);
                            gafisimagestruct.stHead().nWidth_$eq((short) width);
                            gafisimagestruct.stHead().nImgSize_$eq(blobPalmImage.length);
                            gafisimagestruct.stHead().bIsCompressed_$eq((byte) 1);
                            gafisimagestruct.stHead().nCompressMethod_$eq((byte) glocdef.GAIMG_CPRMETHOD_XGW());
                            gafisimagestruct.bnData_$eq(blobPalmImage);

                            glocdef.GAFISIMAGESTRUCT dest = decoder.decodeRawImage(gafisimagestruct);
                            InputStream in = new ByteArrayInputStream(dest.toByteArray(AncientConstants.UTF8_ENCODING(), ByteOrder.BIG_ENDIAN));
                            byte[] feature = extractor.extractByGAFISIMGBinary(in, ExtractProto.FingerPosition.FINGER_R_THUMB, ExtractProto.ExtractRequest.FeatureType.PalmTemplate, ExtractProto.NewFeatureTry.V1).get()._1();

                            String personId = palmEntity.getPersonId();
                            long fgp = palmEntity.getFgp();
                            System.out.println(personId+"-"+fgp+" ,feature length is "+feature.length);
                        } else {
                            System.out.println(palmEntity.getPersonId()+"-"+palmEntity.getFgp());
                        }
                    }
                });
            }
        });
    }
}
