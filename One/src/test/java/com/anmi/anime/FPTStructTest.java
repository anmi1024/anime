package com.anmi.anime;

import com.anmi.anime.config.FPTConfig;
import com.anmi.anime.fpt.*;
import com.anmi.anime.fpt.struct.FPTStruct;
import com.anmi.anime.service.GatherDataService;
import com.anmi.anime.utils.HBaseUtil;
import com.anmi.anime.utils.ProcessImageAndFeatureUtil;
import com.anmi.anime.utils.ProtoHttpClientUtil;
import com.google.protobuf.ByteString;
import nirvana.hall.c.AncientConstants;
import nirvana.hall.c.services.gloclib.glocdef;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.*;

import static com.anmi.anime.fpt.struct.CommonStruct.getObjectFieldValueLength;
import static com.anmi.anime.fpt.struct.CommonStruct.setObjectFieldValueLength;
import static com.anmi.anime.fpt.struct.FPTStruct.buildFPTStruct;

/**
 * Created by wangjue on 2017/6/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FPTStructTest {
    @Autowired
    private FPTConfig fptConfig;

    @Autowired
    private GatherDataService gatherDataService;

    @Test
    public void test_readFPT4ByteBuf() throws Throwable {
        byte[] bytes = IOUtils.toByteArray(this.getClass().getResourceAsStream("/template-fpt-3.fpt"));
        FPT4File fpt = new FPTStruct().readFPTByteBuf(bytes, new FPT4File(), FPTBase.GBK_ENCODEING);
        System.out.println(fpt.getFileLength()+","+fpt.getSendUnitName());
        for (FPT4File.LogicLPRec lp : fpt.getLogicLPRec()) {
            System.out.println(lp.getCaseId()+" , "+lp.getFingers().size());
        }
        for (FPT4File.LogicTPRec tp : fpt.getLogicTPRec()) {
            System.out.println(tp.getPersonId()+" : "+tp.getFingers().size());
        }
    }

    @Test
    public void test_readFPT3ByteBuf() throws Throwable {
        byte[] bytes = IOUtils.toByteArray(this.getClass().getResourceAsStream("/R1624327224111222335245.fpt"));
        FPT3File fpt = new FPTStruct().readFPTByteBuf(bytes, new FPT3File(), FPTBase.GBK_ENCODEING);
        System.out.println(fpt.getFileLength()+","+fpt.getSendUnitName());
        for (FPT3File.LogicTPRec tp : fpt.getLogicTPRec()) {
            System.out.println(tp.getPersonId()+" : "+tp.getFingers().size());
        }
        for (FPT3File.LogicLPRec lp : fpt.getLogicLPRec()) {
            System.out.println(lp.getCaseId()+" , "+lp.getFingers().size());
        }
    }

    @Test
    public void test_batchReadFPTByteBuf() throws Throwable {
        Collection<File> files = FileUtils.listFiles(new File("C:\\Users\\wangjue\\Desktop\\duizi"),new String[]{"fpt","FPT"},true);
        Iterator<File> it = files.iterator();
        while (it.hasNext()) {
            File fptFile = it.next();
            //if (!fptFile.getName().equals("R9999912016101216820255.fpt")) continue;
            System.out.println("processing file : " + fptFile.getName());
            byte[] bytes = FileUtils.readFileToByteArray(fptFile);
            try {
                FPT4File fpt = new FPTStruct().readFPTByteBuf(bytes, new FPT4File(), FPTBase.GBK_ENCODEING);
                System.out.println(fpt.getFileLength() + "," + fpt.getHead().getFlag() + "," + fpt.getHead().getMajorVersion());
                for (FPT4File.LogicTPRec tp : fpt.getLogicTPRec()) {
                    System.out.println("template : ---------------" + tp.getPersonId() + " : " + tp.getFingers().size());
                }
                for (FPT4File.LogicLPRec lp : fpt.getLogicLPRec()) {
                    System.out.println("latent : -----------------" + lp.getCaseId() + " , " + lp.getFingers().size());
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    @Test
    public void test_readInnerClassByteBuf() throws Throwable {
        //template-fpt-4.fpt
        //R1111111111111111111111.fpt
        byte[] bytes = IOUtils.toByteArray(this.getClass().getResourceAsStream("/template-fpt-4.fpt"));
        FPT4File.FPTHead head = new FPTStruct().readFPTByteBuf(bytes, new FPT4File().new FPTHead(), FPTBase.GBK_ENCODEING);
        System.out.println(Thread.currentThread().getName()+","+head.getFlag()+","+head.getMajorVersion());
    }



    @Test
    public void test_buildFPT4Struct() throws Throwable {
        byte[] bytes = IOUtils.toByteArray(this.getClass().getResourceAsStream("/template-fpt-4.fpt"));
        FPT4File fpt = new FPTStruct().readFPTByteBuf(bytes, new FPT4File(), FPTBase.GBK_ENCODEING);
        byte[] templateBuild = buildFPTStruct(fpt, FPTBase.GBK_ENCODEING);
        Assert.assertEquals(Integer.valueOf(fpt.getFileLength()).longValue(),templateBuild.length);    }

    @Test
    public void test_buildFPT3Struct() throws Throwable {
        byte[] bytes = IOUtils.toByteArray(this.getClass().getResourceAsStream("/template-fpt-3.fpt"));
        FPT3File fpt = new FPTStruct().readFPTByteBuf(bytes, new FPT3File(), FPTBase.GBK_ENCODEING);
        byte[] templateBuild = buildFPTStruct(fpt, FPTBase.GBK_ENCODEING);
        Assert.assertEquals(Integer.valueOf(fpt.getFileLength()).longValue(),templateBuild.length);
    }


    @Test
    public void test_readFPT() throws Throwable {
        byte[] bytes = IOUtils.toByteArray(this.getClass().getResourceAsStream("/A0003607210002010020002.fpt"));
        Map<String,Object> map = FPTFile.readFPTByteBuf(bytes, FPTBase.GBK_ENCODEING);
        if (map.containsKey("fpt3")) {
            FPT3File fpt3 = (FPT3File)map.get("fpt3");
            System.out.println("fpt3 : "+fpt3.getFileLength());
        } else if (map.containsKey("fpt4")) {
            FPT4File fpt4 = (FPT4File) map.get("fpt4");
            System.out.println("fpt4 : "+fpt4.getFileLength());
        }
    }

    @Test
    public void test_buildFPT() throws Throwable {
        byte[] bytes = IOUtils.toByteArray(this.getClass().getResourceAsStream("/A0003607210002010020002.fpt"));
        FPT4File fpt = new FPTStruct().readFPTByteBuf(bytes, new FPT4File(), FPTBase.GBK_ENCODEING);
        byte[] b = FPTFile.buildFPTByteBuf(fpt, FPTBase.GBK_ENCODEING);
        FileUtils.writeByteArrayToFile(new File("E:\\wj-fptFile\\build-fpt\\build_A0003607210002010020002.fpt"),b);
    }

    @Test
    public void test_getTotalFieldLength() throws Throwable {
        byte[] bytes = IOUtils.toByteArray(this.getClass().getResourceAsStream("/R1111111111111111111111.fpt"));
        System.out.println("actul : "+bytes.length);
        FPT4File fpt = new FPTStruct().readFPTByteBuf(bytes, new FPT4File(), FPTBase.GBK_ENCODEING);
        //166922
        //int total = getObjectFieldValueLength(fpt.getHead());
        int total = getObjectFieldValueLength(fpt);
        System.out.println(" fpt :"+total);
        for (FPT4File.LogicTPRec tp : fpt.getLogicTPRec()) {
            total += getObjectFieldValueLength(tp);
            System.out.println(" tp : "+total);
            for (FPT4File.LogicTPFinger tpFinger : tp.getFingers()) {
                total += getObjectFieldValueLength(tpFinger);
                System.out.println(" tpFinger : "+total);
            }
        }

        System.out.println("total : "+total);
        System.out.println(bytes.length - total);
    }

    @Test
    public void test_setObjectFieldValueLength() throws Throwable {
        byte[] bytes = IOUtils.toByteArray(this.getClass().getResourceAsStream("/R1111111111111111111111.fpt"));
        System.out.println("raw length : "+bytes.length);
        FPT4File fpt = new FPTStruct().readFPTByteBuf(bytes, new FPT4File(), FPTBase.GBK_ENCODEING);
        System.out.println("--------------------------------------------------------------------------------------------");
        //System.out.println("fpt.getFileLength() : "+fpt.getFileLength());
        fpt.setFileLength("0");
        for (FPT4File.LogicTPRec tp : fpt.getLogicTPRec()) {
            //System.out.println("tp.getLength() : "+tp.getLength());
            tp.setLength("0");
            for (FPT4File.LogicTPFinger tpFinger : tp.getFingers()) {
                //System.out.println("tpFinger.getDataLength() : "+tpFinger.getDataLength());
                tpFinger.setDataLength("0");
            }
        }

        FPT4File newTp = setObjectFieldValueLength(fpt);
        System.out.println("build length : "+newTp.getFileLength());
        System.out.println("--------------------------------------------------------------------------------------------");
        /*System.out.println("fpt.getFileLength() : "+newTp.getFileLength());
        for (FPT4File.LogicTPRec tp : newTp.getLogicTPRec()) {
            System.out.println("tp.getLength() : "+tp.getLength());
            for (FPT4File.LogicTPFinger tpFinger : tp.getFingers()) {
                System.out.println("tpFinger.getDataLength() : "+tpFinger.getDataLength());
            }
        }*/


        System.out.println("-------------------------------------build-------------------------------------------------------");
        int total = getObjectFieldValueLength(newTp);
        System.out.println(" fpt :"+total);
        for (FPT4File.LogicTPRec tp : newTp.getLogicTPRec()) {
            int tpTotal =  getObjectFieldValueLength(tp);
            System.out.println(" tp : "+tp.getIndex() +" , "+tpTotal);
            for (FPT4File.LogicTPFinger tpFinger : tp.getFingers()) {
                int tpFingerTotal = getObjectFieldValueLength(tpFinger);
                System.out.println(" tpFinger : "+tpFinger.getFgp()+" , "+tpFingerTotal);
            }
        }

    }

    @Test
    public void test_processFPTImageAndFeature() throws Throwable {
        //R2242626324224239348273.fpt
        byte[] bytes = IOUtils.toByteArray(this.getClass().getResourceAsStream("/R0442222222111222346248-daoli.FPT"));
        Map<String,Object> map = FPTFile.readFPTByteBuf(bytes, FPTBase.GBK_ENCODEING);
        if (map.containsKey("fpt3")) {
            FPT3File fpt3 = (FPT3File)map.get("fpt3");
            System.out.println("fpt3 : "+fpt3.getFileLength());
        } else if (map.containsKey("fpt4")) {
            FPT4File fpt4 = (FPT4File) map.get("fpt4");
            for (FPT4File.LogicLPRec logicLPRec : fpt4.getLogicLPRec()) {
                System.out.println(logicLPRec.getCaseId());
                for (FPT4File.LogicLPFinger logicLPFinger : logicLPRec.getFingers()) {
                    String fingerId = logicLPRec.getCaseId() + logicLPFinger.getFingerNo();
                    System.out.println(logicLPFinger.getFingerNo()+"-"+logicLPFinger.getImgData().length+"-"+logicLPFinger.getFeature().length());
                    byte[] GAFISIMAGE = ProcessImageAndFeatureUtil.imageWithHead(logicLPFinger.getImgData());
                    ByteString converterFeature = ProcessImageAndFeatureUtil.latentConverterExtractorForFPT4(logicLPFinger,logicLPRec.getCaseId(),fingerId,fptConfig.getExtractorUrl());
                    byte[] GAFISMNT = converterFeature == null ? null : converterFeature.toByteArray();
                    ByteString displayImage = ProcessImageAndFeatureUtil.display(GAFISIMAGE,GAFISMNT,fptConfig.getExtractorUrl());
                    byte[] GAFISDISPLAY = displayImage == null ? null : displayImage.toByteArray();
                    FileUtils.writeByteArrayToFile(new File("C:\\Users\\wangjue\\Desktop\\daoli\\compressImage\\"+fingerId+".img"),GAFISIMAGE);
                    FileUtils.writeByteArrayToFile(new File("C:\\Users\\wangjue\\Desktop\\daoli\\compressImage\\"+fingerId+".mnt"),GAFISMNT);
                    FileUtils.writeByteArrayToFile(new File("C:\\Users\\wangjue\\Desktop\\daoli\\compressImage\\"+fingerId+".jpg"),GAFISDISPLAY);
                }
            }

            for (FPT4File.LogicTPRec logicTPRec : fpt4.getLogicTPRec()) {
                String personId = logicTPRec.getPersonId();
                System.out.println(personId);
                for (FPT4File.LogicTPFinger logicTPFinger :logicTPRec.getFingers()) {
                    FPTProperties properties = new FPTProperties(logicTPFinger.getImgCompressMethod(), logicTPFinger.getImgHorizontalLength(), logicTPFinger.getImgVerticalLength(), logicTPFinger.getDpi(), logicTPFinger.getFgp(), logicTPFinger.getImgData());
                    int fgp = Integer.valueOf(logicTPFinger.getFgp());
                    glocdef.GAFISIMAGESTRUCT gafisImg = ProcessImageAndFeatureUtil.FPTFingerDataToGafisImage(properties);
                    ByteString decompressImage = ProcessImageAndFeatureUtil.decompress(gafisImg,personId,fgp,1,fptConfig.getImageUrl(),(byte)102);
                    ByteString compressWSQImage = ProcessImageAndFeatureUtil.compressWSQ(decompressImage,personId,fgp,fptConfig.getImageUrl());
                    byte[] GAFISIMAGE = compressWSQImage == null ? null : compressWSQImage.toByteArray();

                    glocdef.GAFISIMAGESTRUCT deconpressGafisImage = new glocdef.GAFISIMAGESTRUCT();
                    deconpressGafisImage.fromByteArray(decompressImage.toByteArray(), AncientConstants.UTF8_ENCODING(), ByteOrder.BIG_ENDIAN);
                    ByteString[] mntAndBin = ProcessImageAndFeatureUtil.extractor(deconpressGafisImage,personId,fgp,1,fptConfig.getExtractorUrl());
                    ByteString reExtractorFeature = mntAndBin[0];
                    ByteString reExtractorRidge = mntAndBin[1];
                    byte[] GAFISMNT = reExtractorFeature == null ? null : reExtractorFeature.toByteArray();
                    byte[] GAFISBIN = reExtractorRidge == null ? null : reExtractorRidge.toByteArray();

                    ByteString displayImage = ProcessImageAndFeatureUtil.display(decompressImage.toByteArray(),GAFISMNT,fptConfig.getExtractorUrl());
                    byte[] GAFISDISPLAY = displayImage == null ? null : displayImage.toByteArray();
                    FileUtils.writeByteArrayToFile(new File("C:\\Users\\wangjue\\Desktop\\daoli\\compressImage\\"+personId+"_"+fgp+".img"),GAFISIMAGE);
                    FileUtils.writeByteArrayToFile(new File("C:\\Users\\wangjue\\Desktop\\daoli\\compressImage\\"+personId+"_"+fgp+".mnt"),GAFISMNT);
                    FileUtils.writeByteArrayToFile(new File("C:\\Users\\wangjue\\Desktop\\daoli\\compressImage\\"+personId+"_"+fgp+".jpg"),GAFISDISPLAY);

                }

            }
        }
    }

    @Test
    public void test_processFPT() throws IOException{
        byte[] bytes = IOUtils.toByteArray(this.getClass().getResourceAsStream("/R2100000000002017090799.fpt"));
        gatherDataService.singleProcessFPT("1_1","R2100000000002017090799",bytes,"");
    }

    @Test
    public void test_hbase() throws Throwable{
        HBaseUtil.scanTable();
    }


    @Test
    public void test_downLoadAndProcessFPT() throws Throwable{
        /*String fptPathPrefix = "http://10.1.7.204/fpt/data";
        String fptPath = fptPathPrefix+"/TT/test3/GZZLBH_FPT/B0120161012095328521038.FPT";
        List<String> list = FileUtils.readLines(new File("C:\\Users\\wangjue\\Desktop\\test\\300.txt"));
        for (String s : list) {
            String path = fptPathPrefix+s;
            byte[] fpt = ProtoHttpClientUtil.download(path);
            gatherDataService.singleProcessFPT("1_1",path,fpt);
        }*/
        //http://10.1.7.204/fpt/data/LT/辽宁实验数据1/NEC/十指/R3401225109992012112021.FPT

        //http://10.1.7.204/fpt/data/TT/test3/GZZLBH_FPT/R3338234324111640542346.fpt

        //http://10.1.7.204/fpt/data/LT/辽宁实验数据/海鑫系统/十指/R3502038000002012110563.FPT
        //                          /LT/辽宁实验数据/海鑫系统/十指/R3502038000002012110563.FPT
        String ss = "http://10.1.7.204/fpt/data/LT/辽宁实验数据/海鑫系统/十指/R3502038000002012110563.FPT";
        byte[] fpt = ProtoHttpClientUtil.download(ss);
        gatherDataService.singleProcessFPT("1_1",ss,fpt,"");

    }

}
