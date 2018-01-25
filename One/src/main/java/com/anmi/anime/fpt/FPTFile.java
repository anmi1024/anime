package com.anmi.anime.fpt;

import com.anmi.anime.annotation.Length;
import com.anmi.anime.fpt.struct.FPTStruct;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import static com.anmi.anime.fpt.struct.CommonStruct.setObjectFieldValueLength;
import static com.anmi.anime.fpt.struct.FPTStruct.buildFPTStruct;


/**
 * Created by wangjue on 2017/6/22.
 */
public class FPTFile {

    public static Map<String,Object> readFPTByteBuf(byte[] bytes, Charset encoding) throws Throwable {
        Map<String,Object> map = new HashMap<>();
        FPTFile.FPTHead head = new FPTStruct().readFPTByteBuf(bytes, new FPTFile().new FPTHead(), encoding);
        if (!FPTBase.FPT_FLAG.equals(head.getFlag())) throw new IllegalArgumentException(String.format("FPT_FLAG IS NOT FPT , %s",head.getFlag()));
        switch (head.getMajorVersion()) {
            case FPTBase.FPT_V3 : map.put("fpt3",new FPTStruct().readFPTByteBuf(bytes, new FPT3File(),encoding)); break;
            case FPTBase.FPT_V4 : map.put("fpt4",new FPTStruct().readFPTByteBuf(bytes, new FPT4File(),encoding)); break;
            default : throw new IllegalArgumentException(String.format("VALID FPT VERSION , %s",head.getMajorVersion()));
        }
        return map;
    }

    public static <T> byte[] buildFPTByteBuf(T t, Charset encoding) throws Throwable {
        byte[] templateBuild = buildFPTStruct(initialize(t),encoding);
        return templateBuild;
    }

    public static <T> T initialize(T t) throws Throwable{
        if (t instanceof FPT3File) {
            System.out.println("fpt3");
            FPT3File fpt3 = (FPT3File)t;
            FPT3File.FPTHead head = fpt3.getHead();
            head.setFlag("FPT");
            head.setMajorVersion("03");
            head.setMinorVersion("00");
            fpt3.setSendUnitSystemType("1419");
            fpt3.setTpCount(fpt3.getLogicTPRec() == null ? "0" : fpt3.getLogicTPRec().size()+"");
            fpt3.setLpCount(fpt3.getLogicLPRec() == null ? "0" : fpt3.getLogicLPRec().size()+"");

        } else if (t instanceof FPT4File) {
            System.out.println("fpt4");
            FPT4File fpt4 = (FPT4File)t;
            FPT4File.FPTHead head = fpt4.getHead();
            head.setFlag("FPT");
            head.setMajorVersion("04");
            head.setMinorVersion("00");
            fpt4.setSendUnitSystemType("1419");
            fpt4.setTpCount(fpt4.getLogicTPRec() == null ? "0" : fpt4.getLogicTPRec().size()+"");
            fpt4.setLpCount(fpt4.getLogicLPRec() == null ? "0" : fpt4.getLogicLPRec().size()+"");
            //TODO 比中、候选信息
        }
        //TODO 长度设置 反射获取的长度和实际文件长度不等！待调试！！！ ...
        t = setObjectFieldValueLength(t);
        return t;
    }

    public class FPTHead {
        @Length(3)
        private String flag;
        @Length(2)
        private String majorVersion;
        @Length(2)
        private String minorVersion;
        public String getFlag() {
            return flag;
        }
        public void setFlag(String flag) {
            this.flag = flag;
        }
        public String getMajorVersion() {
            return majorVersion;
        }
        public void setMajorVersion(String majorVersion) {
            this.majorVersion = majorVersion;
        }
        public String getMinorVersion() {
            return minorVersion;
        }
        public void setMinorVersion(String minorVersion) {
            this.minorVersion = minorVersion;
        }
    }

}
