package com.anmi.anime.jaxb.fpt5.NYZZW;

/**
 * Created by wangjue on 2017/7/6.
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *单枚指纹信息
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class FingerMsg {
    @XmlElement(name = "zwzwdm")
    private String zwzwdm;                  //指纹指位代码 如果指纹_数量不为零，则必填
    @XmlElement(name = "zzwtztqfsdm")
    private String zzwtztqfsdm;             //指掌纹特征提取方式代码 如果指纹_数量不为零，则必填
    @XmlElement(name = "qzyydm")
    private String qzyydm;                  //缺指原因代码 如果指纹_数量不为零，则必填
    @XmlElement(name = "zwwxzfl_zwwxdm")
    private String zwwxzfl_zwwxdm;          //指纹纹型主分类_指纹纹型代码 如果指纹_数量不为零，则必填
    @XmlElement(name = "zwwxffl_zwwxdm")
    private String zwwxffl_zwwxdm;          //指纹纹型副分类_指纹纹型代码 如果指纹_数量不为零，则必填
    @XmlElement(name = "zwfxms")
    private String zwfxms;                  //指纹方向描述
    @XmlElement(name = "zwzxd")
    private String zwzxd;                   //指纹中心点
    @XmlElement(name = "zwfzx")
    private String zwfzx;                   //指纹副中心
    @XmlElement(name = "zwzsj")
    private String zwzsj;                   //指纹左三角
    @XmlElement(name = "zwysj")
    private String zwysj;                   //指纹右三角
    @XmlElement(name = "zwtzd_sl")
    private int zwtzd_sl;                   //指纹特征点_数量
    @XmlElement(name = "zwtzdxx")
    private String zwtzdxx;                 //指纹特征点信息
    @XmlElement(name = "zw_zdyxx")
    private byte[] zw_zdyxx;                //指纹_自定义信息
    @XmlElement(name = "zw_txspfxcd")
    private int zw_txspfxcd;                //指纹_图像水平方向长度
    @XmlElement(name = "zw_txczfxcd")
    private int zw_txczfxcd;                //指纹_图像垂直方向长度
    @XmlElement(name = "zw_txfbl")
    private int zw_txfbl;                   //指纹_图像分辨率
    @XmlElement(name = "zw_txysffms")
    private String zw_txysffms;             //指纹_图像压缩方法描述  0000表示无压缩，其他值前2个字节数字代表压缩方法代码，后2个字节数字代表系统生产厂商代码
    @XmlElement(name = "zw_txsj")
    private byte[] zw_txsj;                 //指纹_图像数据

    public String getZwzwdm() {
        return zwzwdm;
    }

    public void setZwzwdm(String zwzwdm) {
        this.zwzwdm = zwzwdm;
    }

    public String getZzwtztqfsdm() {
        return zzwtztqfsdm;
    }

    public void setZzwtztqfsdm(String zzwtztqfsdm) {
        this.zzwtztqfsdm = zzwtztqfsdm;
    }

    public String getQzyydm() {
        return qzyydm;
    }

    public void setQzyydm(String qzyydm) {
        this.qzyydm = qzyydm;
    }

    public String getZwwxzfl_zwwxdm() {
        return zwwxzfl_zwwxdm;
    }

    public void setZwwxzfl_zwwxdm(String zwwxzfl_zwwxdm) {
        this.zwwxzfl_zwwxdm = zwwxzfl_zwwxdm;
    }

    public String getZwwxffl_zwwxdm() {
        return zwwxffl_zwwxdm;
    }

    public void setZwwxffl_zwwxdm(String zwwxffl_zwwxdm) {
        this.zwwxffl_zwwxdm = zwwxffl_zwwxdm;
    }

    public String getZwfxms() {
        return zwfxms;
    }

    public void setZwfxms(String zwfxms) {
        this.zwfxms = zwfxms;
    }

    public String getZwzxd() {
        return zwzxd;
    }

    public void setZwzxd(String zwzxd) {
        this.zwzxd = zwzxd;
    }

    public String getZwfzx() {
        return zwfzx;
    }

    public void setZwfzx(String zwfzx) {
        this.zwfzx = zwfzx;
    }

    public String getZwzsj() {
        return zwzsj;
    }

    public void setZwzsj(String zwzsj) {
        this.zwzsj = zwzsj;
    }

    public String getZwysj() {
        return zwysj;
    }

    public void setZwysj(String zwysj) {
        this.zwysj = zwysj;
    }

    public int getZwtzd_sl() {
        return zwtzd_sl;
    }

    public void setZwtzd_sl(int zwtzd_sl) {
        this.zwtzd_sl = zwtzd_sl;
    }

    public String getZwtzdxx() {
        return zwtzdxx;
    }

    public void setZwtzdxx(String zwtzdxx) {
        this.zwtzdxx = zwtzdxx;
    }

    public byte[] getZw_zdyxx() {
        return zw_zdyxx;
    }

    public void setZw_zdyxx(byte[] zw_zdyxx) {
        this.zw_zdyxx = zw_zdyxx;
    }

    public int getZw_txspfxcd() {
        return zw_txspfxcd;
    }

    public void setZw_txspfxcd(int zw_txspfxcd) {
        this.zw_txspfxcd = zw_txspfxcd;
    }

    public int getZw_txczfxcd() {
        return zw_txczfxcd;
    }

    public void setZw_txczfxcd(int zw_txczfxcd) {
        this.zw_txczfxcd = zw_txczfxcd;
    }

    public int getZw_txfbl() {
        return zw_txfbl;
    }

    public void setZw_txfbl(int zw_txfbl) {
        this.zw_txfbl = zw_txfbl;
    }

    public String getZw_txysffms() {
        return zw_txysffms;
    }

    public void setZw_txysffms(String zw_txysffms) {
        this.zw_txysffms = zw_txysffms;
    }

    public byte[] getZw_txsj() {
        return zw_txsj;
    }

    public void setZw_txsj(byte[] zw_txsj) {
        this.zw_txsj = zw_txsj;
    }
}