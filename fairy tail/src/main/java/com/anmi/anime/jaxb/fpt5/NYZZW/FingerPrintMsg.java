package com.anmi.anime.jaxb.fpt5.NYZZW;

/**
 * Created by wangjue on 2017/7/6.
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 捺印信息
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class FingerPrintMsg {
    @XmlElement(name = "zw_sl")
    private int zw_sl;                      //指纹_数量 包括滚动、平面指纹
    @XmlElement(name = "zhw_sl")
    private int zhw_sl;                     //掌纹_数量 包括平面掌纹、侧掌纹
    @XmlElement(name = "slz_sl")
    private int slz_sl;                     //四连指_数量
    @XmlElement(name = "zjw_sl")
    private int zjw_sl;                     //指节纹_数量
    @XmlElement(name = "qz_sl")
    private int qz_sl;                      //全掌_数量

    public int getZw_sl() {
        return zw_sl;
    }

    public void setZw_sl(int zw_sl) {
        this.zw_sl = zw_sl;
    }

    public int getZhw_sl() {
        return zhw_sl;
    }

    public void setZhw_sl(int zhw_sl) {
        this.zhw_sl = zhw_sl;
    }

    public int getSlz_sl() {
        return slz_sl;
    }

    public void setSlz_sl(int slz_sl) {
        this.slz_sl = slz_sl;
    }

    public int getZjw_sl() {
        return zjw_sl;
    }

    public void setZjw_sl(int zjw_sl) {
        this.zjw_sl = zjw_sl;
    }

    public int getQz_sl() {
        return qz_sl;
    }

    public void setQz_sl(int qz_sl) {
        this.qz_sl = qz_sl;
    }
}