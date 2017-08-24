package com.anmi.anime;

import com.anmi.anime.define.*;
import com.anmi.anime.fpt.FPT3File;
import com.anmi.anime.fpt.FPT4File;
import com.anmi.anime.fpt.FPTBase;
import com.anmi.anime.fpt.FPTFile;
import com.anmi.anime.struct.FPTStruct;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.*;
import static com.anmi.anime.ByteUtil.afisDateTimeToString;
import static com.anmi.anime.ByteUtil.byteToString;
import static com.anmi.anime.ByteUtil.concatArray;
import static com.anmi.anime.struct.AnnotationStruct.buildAnnotationObject;
import static com.anmi.anime.struct.AnnotationStruct.buildAnnotationObjectByteBuf;
import static com.anmi.anime.struct.AnnotationStruct.readAnnotationObjectByteBuf;
import static com.anmi.anime.struct.CommonStruct.getObjectFieldValueLength;
import static com.anmi.anime.struct.CommonStruct.setObjectFieldValueLength;
import static com.anmi.anime.struct.FPTStruct.buildFPTStruct;
import static com.anmi.anime.struct.MicStruct.buildMicAnnotationObject;
import static com.anmi.anime.struct.MicStruct.buildMicAnnotationObject1;

/**
 * Created by wangjue on 2017/6/19.
 */
public class StructTest {

    @Test
    public void test_annotation() throws Throwable{
        Class clazz = Class.forName("util.define.MicAnnotationObject");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FieldLength.class)) {
                FieldLength fieldLength = field.getAnnotation(FieldLength.class);
                System.out.println("FieldLength.class,"+fieldLength.has()+","+fieldLength.value());
            }
            if (field.isAnnotationPresent(Length.class)) {
                Length length = field.getAnnotation(Length.class);
                System.out.println("Length.class,"+length.value());
            }
        }
    }



    @Test
    public void test_buildMICByteBuf() throws Throwable{
        //byte[] mic = concatArray(buildMICByteBuf(buildAnnotationObject()),buildByteBuf(buildAnnotationObject1()));
        //byte[] mic2 = buildMICByteBuf(buildObject());
        byte[] mic3 = buildMicAnnotationObject().buildMICByteBuf(0);
        byte[] mic4 = buildMicAnnotationObject1().buildMICByteBuf(1);
        byte[] bytes = concatArray(mic3,mic4);
        FileUtils.writeByteArrayToFile(new File("D:\\struct\\buff_repeat_annotation.dat"),bytes);
    }



    @Test
    public void test_readMICByteBuf() throws Throwable{
        byte[] byteBuf = FileUtils.readFileToByteArray(new File("D:\\struct\\0703_1"));
        List<MicAnnotationObject> list = new MicAnnotationObject().readMICByteBuf(byteBuf);
        Assert.assertEquals(1,list.size());
    }


    @Test
    public void test_cutByteBuf() throws Throwable{
        byte[] candList = FileUtils.readFileToByteArray(new File("D:\\struct\\cand.cand"));
        byte[] dest = ByteBuffer.allocate(32).array();
        System.arraycopy(candList,8,dest,0,32);
        String keyId = byteToString(dest);
        System.out.println(keyId);
    }

    @Test
    public void test_readCandListByteBuf() throws Throwable{
        //byte[] b = FileUtils.readFileToByteArray(new File("D:\\struct\\cand.cand"));
        //byte[] b = FileUtils.readFileToByteArray(new File("D:\\struct\\build_cand.cand"));
        byte[] b = FileUtils.readFileToByteArray(new File("D:\\struct\\0703_1"));
        for (CandListAnnotationObject candList : new CandListAnnotationObject().readCandListByteBuf(b)) {
            System.out.println(candList.getSzKey());
            System.out.println(candList.getNIndex());
            System.out.println(afisDateTimeToString(candList.getFinishTime().toBinary()));
        }
    }

    @Test
    public void test_buildCandListByteBuf() throws Throwable{
        byte[] b = FileUtils.readFileToByteArray(new File("D:\\struct\\cand.cand"));
        CandListAnnotationObject candList = new CandListAnnotationObject().readCandListByteBuf(b).get(0);
        candList.setNIndex((byte)9);
        candList.buildCandListByteBuf();
    }

    @Test
    public void test_buildAnnotationByteBuf() throws Throwable {
        AnnotationObject object = buildAnnotationObject();
        byte[] bytes = buildAnnotationObjectByteBuf(object);
        FileUtils.writeByteArrayToFile(new File("D:\\struct\\fpt_fingerData.fpt"),bytes);
    }

    @Test
    public void test_readAnnotationByteBuf() throws Throwable {
        byte[] bytes = FileUtils.readFileToByteArray(new File("D:\\struct\\fpt_fingerData.fpt"));
        readAnnotationObjectByteBuf(bytes,new AnnotationObject());
    }

    @Test
    public void test_readFPT4ByteBuf() throws Throwable {
        byte[] bytes = IOUtils.toByteArray(this.getClass().getResourceAsStream("/template-fpt-3.fpt"));
        FPT4File fpt = new FPTStruct().readFPTByteBuf(bytes, new FPT4File(),FPTBase.GBK_ENCODEING);
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
        byte[] bytes = IOUtils.toByteArray(this.getClass().getResourceAsStream("/latent-fpt-3.fpt"));
        FPT3File fpt = new FPTStruct().readFPTByteBuf(bytes, new FPT3File(),FPTBase.GBK_ENCODEING);
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
        Collection<File> files = FileUtils.listFiles(new File("C:\\Users\\wangjue\\Desktop\\fail_FPT"),new String[]{"fpt","FPT"},true);
        Iterator<File> it = files.iterator();
        while (it.hasNext()) {
            File fptFile = it.next();
            if (!fptFile.getName().equals("R9999912016101216820255.fpt")) continue;
            System.out.println("processing file : " + fptFile.getName());
            byte[] bytes = FileUtils.readFileToByteArray(fptFile);
            try {
                FPT4File fpt = new FPTStruct().readFPTByteBuf(bytes, new FPT4File(),FPTBase.GBK_ENCODEING);
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
        byte[] bytes = IOUtils.toByteArray(this.getClass().getResourceAsStream("/template-fpt-3.fpt"));
        FPT4File.FPTHead head = new FPTStruct().readFPTByteBuf(bytes, new FPT4File().new FPTHead(), FPTBase.GBK_ENCODEING);
        System.out.println(Thread.currentThread().getName()+","+head.getFlag()+","+head.getMajorVersion());
    }



    @Test
    public void test_buildFPT4Struct() throws Throwable {
        byte[] bytes = IOUtils.toByteArray(this.getClass().getResourceAsStream("/template-fpt-4.fpt"));
        FPT4File fpt = new FPTStruct().readFPTByteBuf(bytes, new FPT4File(),FPTBase.GBK_ENCODEING);
        byte[] templateBuild = buildFPTStruct(fpt,FPTBase.GBK_ENCODEING);
        Assert.assertEquals(Integer.valueOf(fpt.getFileLength()).longValue(),templateBuild.length);    }

    @Test
    public void test_buildFPT3Struct() throws Throwable {
        byte[] bytes = IOUtils.toByteArray(this.getClass().getResourceAsStream("/template-fpt-3.fpt"));
        FPT3File fpt = new FPTStruct().readFPTByteBuf(bytes, new FPT3File(),FPTBase.GBK_ENCODEING);
        byte[] templateBuild = buildFPTStruct(fpt,FPTBase.GBK_ENCODEING);
        Assert.assertEquals(Integer.valueOf(fpt.getFileLength()).longValue(),templateBuild.length);
    }


    @Test
    public void test_readFPT() throws Throwable {
        byte[] bytes = IOUtils.toByteArray(this.getClass().getResourceAsStream("/template-fpt-4.fpt"));
        Map<String,Object> map = FPTFile.readFPTByteBuf(bytes,FPTBase.GBK_ENCODEING);
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
        FPT4File fpt = new FPTStruct().readFPTByteBuf(bytes, new FPT4File(),FPTBase.GBK_ENCODEING);
        byte[] b = FPTFile.buildFPTByteBuf(fpt, FPTBase.GBK_ENCODEING);
        FileUtils.writeByteArrayToFile(new File("E:\\wj-fptFile\\build-fpt\\build_A0003607210002010020002.fpt"),b);
    }

    @Test
    public void test_getTotalFieldLength() throws Throwable {
        byte[] bytes = IOUtils.toByteArray(this.getClass().getResourceAsStream("/R1111111111111111111111.fpt"));
        System.out.println("actul : "+bytes.length);
        FPT4File fpt = new FPTStruct().readFPTByteBuf(bytes, new FPT4File(),FPTBase.GBK_ENCODEING);
        //166922
        int total = getObjectFieldValueLength(fpt.getHead());
        /*int total = getObjectFieldValueLength(fpt);
        System.out.println(" fpt :"+total);
        for (FPT4File.LogicTPRec tp : fpt.getLogicTPRec()) {
            total += getObjectFieldValueLength(tp);
            System.out.println(" tp : "+total);
            for (FPT4File.LogicTPFinger tpFinger : tp.getFingers()) {
                total += getObjectFieldValueLength(tpFinger);
                System.out.println(" tpFinger : "+total);
            }
        }*/

        System.out.println("total : "+total);
    }

    @Test
    public void test_setObjectFieldValueLength() throws Throwable {
        byte[] bytes = IOUtils.toByteArray(this.getClass().getResourceAsStream("/R1111111111111111111111.fpt"));
        System.out.println("raw length : "+bytes.length);
        FPT4File fpt = new FPTStruct().readFPTByteBuf(bytes, new FPT4File(),FPTBase.GBK_ENCODEING);
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
    public void test_() {
        int i=0,j=0;
        do {
            --j;
            i = i-1;
        } while (i>0);
        System.out.println(i + "," + j);
    }

}
