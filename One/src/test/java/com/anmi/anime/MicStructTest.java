package com.anmi.anime;

import com.anmi.anime.queryQueue.define.MicAnnotationObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static com.anmi.anime.utils.ByteUtil.concatArray;

/**
 * Created by wangjue on 2017/9/14.
 */
public class MicStructTest {


    public static MicAnnotationObject buildMicAnnotationObject() throws Throwable{
        byte[] mnt = IOUtils.toByteArray(MicStructTest.class.getResourceAsStream("/mic/0_1_0.mic"));
        MicAnnotationObject mic = new MicAnnotationObject();
        mic.set$$ItemIndex(0);
        mic.set$$ItemFlag(1);
        mic.set$$ItemType(1);
        mic.set$$ItemData(1);
        mic.set$$IsLatent(0);
        mic.set$$Mnt(mnt);
        return mic;
    }
    public static MicAnnotationObject buildMicAnnotationObject1() throws Throwable{
        byte[] mnt = IOUtils.toByteArray(MicStructTest.class.getResourceAsStream("/mic/0_1_0.mic"));
        byte[] bin = IOUtils.toByteArray(MicStructTest.class.getResourceAsStream("/mic/4_1_0.mic"));
        MicAnnotationObject mic = new MicAnnotationObject();
        mic.set$$ItemIndex(1);
        mic.set$$ItemFlag(9);
        mic.set$$ItemType(1);
        mic.set$$ItemData(1);
        mic.set$$IsLatent(0);
        mic.set$$Mnt(mnt);
        mic.set$$Bin(bin);
        return mic;
    }

    @Test
    public void test_buildMICByteBuf() throws Throwable{
        byte[] mic1 = buildMicAnnotationObject().buildMICByteBuf(0);
        byte[] mic2 = buildMicAnnotationObject1().buildMICByteBuf(1);
        byte[] bytes = concatArray(mic1,mic2);
        FileUtils.writeByteArrayToFile(new File("/mic/buff_repeat_annotation.dat"),bytes);
    }



    @Test
    public void test_readMICByteBuf() throws Throwable{
        ///mic/group.mic
        ///mic/buff_repeat_annotation.dat
        //palm_from_database.mic
        byte[] byteBuf = IOUtils.toByteArray(MicStructTest.class.getResourceAsStream("/mic/ridge"));
        List<MicAnnotationObject> list = new MicAnnotationObject().readMICByteBuf(byteBuf);
        Assert.assertTrue(list.size()>0);
    }
}
