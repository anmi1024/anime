package com.anmi.anime.fpt;

import java.nio.charset.Charset;

/**
 * Created by wangjue on 2017/6/28.
 */
public class FPTBase {
    public static final Charset UTF8_ENCODEING = Charset.forName("UTF-8");
    public static final Charset GBK_ENCODEING = Charset.forName("GBK");
    public static final Charset GB2312_ENCODEING = Charset.forName("GB2312");

    public static final byte FS = 28;
    public static final byte GS = 29;
    public static final String FPT_FLAG="FPT";
    public static final String  FPT_V3="03";
    public static final String  FPT_V4="04";

    public static final String FILE_LENGTH = "fileLength";
    public static final String LOGIC_LENGTH = "length";
    public static final String DATA_LENGTH = "dataLength";

    //逻辑记录类型 fpt3
    public static final String LOGIC1REC_DATATYPE = "1"; //逻辑记录类型
    public static final String LOGIC2REC_DATATYPE = "2"; //十指指纹信息记录
    public static final String LOGIC3REC_DATATYPE = "3"; //现场指纹信息记录

    //逻辑记录类型 fpt4
    public static final String LOGIC01REC_DATATYPE = "01"; //逻辑记录类型
    public static final String LOGIC02REC_DATATYPE = "02"; //十指指纹信息记录
    public static final String LOGIC03REC_DATATYPE = "03"; //现场指纹信息记录
    public static final String LOGIC04REC_DATATYPE = "04"; //指纹正查及倒查比中信息记录
    public static final String LOGIC05REC_DATATYPE = "05"; //指纹查重比中信息记录
    public static final String LOGIC06REC_DATATYPE = "06"; //指纹串查比中信息记录
    public static final String LOGIC07REC_DATATYPE = "07"; //现场指纹查询请求信息记录
    public static final String LOGIC08REC_DATATYPE = "08"; //十指指纹查询请求信息记录
    public static final String LOGIC09REC_DATATYPE = "09"; //正查比对结果候选信息记录
    public static final String LOGIC10REC_DATATYPE = "10"; //倒查比对结果候选信息记录
    public static final String LOGIC11REC_DATATYPE = "11"; //查重比对结果候选信息记录
    public static final String LOGIC12REC_DATATYPE = "12"; //串查比对结果候选信息记录
    public static final String LOGIC99REC_DATATYPE = "99"; //自定义逻辑记录数量

}
