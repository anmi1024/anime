package com.anmi.anime;

import com.anmi.anime.queryQueue.define.CandListAnnotationObject;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import java.nio.ByteBuffer;

import static com.anmi.anime.utils.ByteUtil.afisDateTimeToString;
import static com.anmi.anime.utils.ByteUtil.byteToString;

/**
 * Created by wangjue on 2017/9/14.
 */
public class CandListStructTest {

    @Test
    public void test_cutByteBuf() throws Throwable{
        byte[] candList = IOUtils.toByteArray(CandListStructTest.class.getResourceAsStream("/candList/tt_candList.cand"));
        byte[] dest = ByteBuffer.allocate(32).array();
        System.arraycopy(candList,8,dest,0,32);
        String keyId = byteToString(dest);
        System.out.println(keyId);
    }

    @Test
    public void test_readCandListByteBuf() throws Throwable{
        byte[] b = IOUtils.toByteArray(CandListStructTest.class.getResourceAsStream("/candList/tt_candList.cand"));
        for (CandListAnnotationObject candList : new CandListAnnotationObject().readCandListByteBuf(b)) {
            System.out.println(candList.getSzKey());
            System.out.println(candList.getNIndex());
            System.out.println(afisDateTimeToString(candList.getFinishTime().toBinary()));
        }
    }



}
