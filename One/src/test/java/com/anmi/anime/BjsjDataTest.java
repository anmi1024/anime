package com.anmi.anime;

import com.anmi.anime.service.BjsjDataService;
import nirvana.hall.c.AncientConstants;
import nirvana.hall.c.services.gloclib.glocdef;
import nirvana.hall.extractor.internal.FeatureExtractorImpl;
import nirvana.hall.image.config.HallImageConfig;
import nirvana.hall.image.internal.FirmDecoderImpl;
import nirvana.hall.image.internal.ImageEncoderImpl;
import nirvana.hall.protocol.extract.ExtractProto;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

import static com.anmi.anime.utils.ByteUtil.byteArray2Int;
import static com.anmi.anime.utils.ByteUtil.isHead7;

/**
 * Created by wangjue on 2017/11/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BjsjDataTest {
    private FirmDecoderImpl decoder = new FirmDecoderImpl(".",new HallImageConfig());
    private ImageEncoderImpl encoder = new ImageEncoderImpl(decoder);
    private FeatureExtractorImpl extractor = new FeatureExtractorImpl();

    @Autowired
    private BjsjDataService bjsjDataService;

    @Test
    public void test_bjsj() throws IOException {
        List<String> imgUrl1 = new ArrayList<>();
        //imgUrl1.add("P5201133500002014069994");
        //imgUrl1.add("P5201135100002014069998");
        imgUrl1.add("P5201135100002014099959");
        List<String> imgUrl = FileUtils.readLines(new File("C:\\Users\\wangjue\\Desktop\\测试平台\\bjsj_palm\\掌纹人员\\181_gz_palm.txt"));
        bjsjDataService.imageProcess(imgUrl1);
        //bjsjDataService.imagesProcessByGAFIS(imgUrl);
        //bjsjDataService.imagesProcessByGAFISSingle(imgUrl1);
    }

    @Test
    public void test_decoderPalm7() throws IOException{
        nirvana.hall.extractor.jni.JniLoader.loadJniLibrary(".",null);
        nirvana.hall.image.jni.JniLoader.loadJniLibrary(".",null);

        byte[] palmImage = FileUtils.readFileToByteArray(new File("C:\\Users\\wangjue\\Desktop\\测试平台\\bjsj_palm\\掌纹人员\\P5202035000002014089993_11_head7.data"));
        if (isHead7(palmImage)) {
            byte[] blobPalmHead = new byte[128];
            System.arraycopy(palmImage,0,blobPalmHead,0,128);
            int width = byteArray2Int(blobPalmHead,92,4);
            int height = byteArray2Int(blobPalmHead,96,4);
            int dpi = byteArray2Int(blobPalmHead,16,2);

            byte[] blobPalmImage = new byte[palmImage.length-128];
            System.arraycopy(palmImage,128,blobPalmImage,0,blobPalmImage.length);

            glocdef.GAFISIMAGESTRUCT gafisimagestruct = new glocdef.GAFISIMAGESTRUCT();
            gafisimagestruct.stHead().nHeight_$eq((short) height);
            gafisimagestruct.stHead().nWidth_$eq((short) width);
            gafisimagestruct.stHead().nImageType_$eq((byte) 2);
            gafisimagestruct.stHead().bIsCompressed_$eq((byte) 1);
            gafisimagestruct.stHead().nCompressMethod_$eq((byte) glocdef.GAIMG_CPRMETHOD_XGW());
            gafisimagestruct.stHead().nImgSize_$eq(blobPalmImage.length);
            gafisimagestruct.stHead().nCaptureMethod_$eq((byte) 1);
            gafisimagestruct.stHead().nResolution_$eq((short) 500);
            gafisimagestruct.stHead().nBits_$eq((byte) dpi);
            gafisimagestruct.stHead().szName_$eq("CardBinData3");
            gafisimagestruct.bnData_$eq(blobPalmImage);

            glocdef.GAFISIMAGESTRUCT dest = decoder.decodeRawImage(gafisimagestruct);
            FileUtils.writeByteArrayToFile(new File("C:\\Users\\wangjue\\Desktop\\测试平台\\bjsj_palm\\palm_decompress\\decoder_java.data"),dest.toByteArray(AncientConstants.UTF8_ENCODING(),ByteOrder.BIG_ENDIAN));
            InputStream in = new ByteArrayInputStream(dest.toByteArray(AncientConstants.UTF8_ENCODING(), ByteOrder.BIG_ENDIAN));
            byte[] feature = extractor.extractByGAFISIMGBinary(in, ExtractProto.FingerPosition.FINGER_R_THUMB, ExtractProto.ExtractRequest.FeatureType.PalmTemplate, ExtractProto.NewFeatureTry.V1).get()._1();
            FileUtils.writeByteArrayToFile(new File("C:\\Users\\wangjue\\Desktop\\测试平台\\bjsj_palm\\palm_decompress\\mnt_java.mnt"),feature);
            System.out.println("feature length is "+feature.length);
        } else {
            System.out.println("1212121212");
        }

    }

    @Test
    public void test_productPalmBmp() throws IOException {
        byte[] palmImage = FileUtils.readFileToByteArray(new File("D:\\bjsj\\12\\P5200000000002017099991_12.bmp"));
        for (int i=1;i<1000;i++) {
            String bmpName = "";
            if (i < 10) bmpName = "00"+i;
            else if (i >=10 && i < 100) bmpName = "0"+i;
            else if (i >=100 && i < 1000) bmpName = ""+i;
            System.out.println(bmpName);
            FileUtils.writeByteArrayToFile(new File("D:\\bjsj\\12\\P52"+bmpName+"0000002017099991_12.bmp"),palmImage);
        }
    }

}
