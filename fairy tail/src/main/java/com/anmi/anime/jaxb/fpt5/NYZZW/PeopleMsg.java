package com.anmi.anime.jaxb.fpt5.NYZZW;

/**
 * Created by wangjue on 2017/7/6.
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *人员信息
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PeopleMsg {
    @XmlElement(name = "zwbdxtlxms")
    private String zwbdxtlxms;              //指纹比对系统描述
    @XmlElement(name = "ysxt_asjxgrybh")
    private String ysxt_asjxgrybh;          //原始系统_案事件相关人员编号
    @XmlElement(name = "jzrybh")
    private String jzrybh;                  //警综人员编号
    @XmlElement(name = "asjxgrybh")
    private String asjxgrybh;               //案事件相关人员编号
    @XmlElement(name = "zzwkbh")
    private String zzwkbh;                  //指掌纹卡编号
    @XmlElement(name = "bnyzwrylbdm")
    private String bnyzwrylbdm;             //被捺印指纹人员类别代码
    @XmlElement(name = "xm")
    private String xm;                      //姓名
    @XmlElement(name = "bmch")
    private String bmch;                    //别名/绰号
    @XmlElement(name = "xbdm")
    private String xbdm;                    //性别代码
    @XmlElement(name = "csrq")
    private String csrq;                    //出生日期
    @XmlElement(name = "gjdm")
    private String gjdm;                    //国籍代码
    @XmlElement(name = "mzdm")
    private String mzdm;                    //民族代码
    @XmlElement(name = "cyzjdm")
    private String cyzjdm;                  //常用证件代码
    @XmlElement(name = "zjhm")
    private String zjhm;                    //证件号码
    @XmlElement(name = "hjdz_xzqhdm")
    private String hjdz_xzqhdm;             //户籍地址_行政区划代码
    @XmlElement(name = "hjdz_dzmc")
    private String hjdz_dzmc;               //户籍地址_地址名称
    @XmlElement(name = "xzz_xzqhdm")
    private String xzz_xzqhdm;              //现住址_行政区划代码
    @XmlElement(name = "xzz_dzmc")
    private String xzz_dzmc;                //现住址_地址名称
    @XmlElement(name = "nydw_gajgjgdm")
    private String nydw_gajgjgdm;           //捺印单位_公安机关机构代码
    @XmlElement(name = "nydw_gajgmc")
    private String nydw_gajgmc;             //捺印单位_公安机关名称
    @XmlElement(name = "nyry_xm")
    private String nyry_xm;                 //捺印人员_姓名
    @XmlElement(name = "nyry_gmsfhm")
    private String nyry_gmsfhm;             //捺印人员_公民身份号码
    @XmlElement(name = "nyry_lxdh")
    private String nyry_lxdh;               //捺印人员_联系电话
    @XmlElement(name = "nysj")
    private String nysj;                    //捺印时间
    @XmlElement(name = "bz")
    private String bz;                      //备注

    public String getZwbdxtlxms() {
        return zwbdxtlxms;
    }

    public void setZwbdxtlxms(String zwbdxtlxms) {
        this.zwbdxtlxms = zwbdxtlxms;
    }

    public String getYsxt_asjxgrybh() {
        return ysxt_asjxgrybh;
    }

    public void setYsxt_asjxgrybh(String ysxt_asjxgrybh) {
        this.ysxt_asjxgrybh = ysxt_asjxgrybh;
    }

    public String getJzrybh() {
        return jzrybh;
    }

    public void setJzrybh(String jzrybh) {
        this.jzrybh = jzrybh;
    }

    public String getAsjxgrybh() {
        return asjxgrybh;
    }

    public void setAsjxgrybh(String asjxgrybh) {
        this.asjxgrybh = asjxgrybh;
    }

    public String getZzwkbh() {
        return zzwkbh;
    }

    public void setZzwkbh(String zzwkbh) {
        this.zzwkbh = zzwkbh;
    }

    public String getBnyzwrylbdm() {
        return bnyzwrylbdm;
    }

    public void setBnyzwrylbdm(String bnyzwrylbdm) {
        this.bnyzwrylbdm = bnyzwrylbdm;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getBmch() {
        return bmch;
    }

    public void setBmch(String bmch) {
        this.bmch = bmch;
    }

    public String getXbdm() {
        return xbdm;
    }

    public void setXbdm(String xbdm) {
        this.xbdm = xbdm;
    }

    public String getCsrq() {
        return csrq;
    }

    public void setCsrq(String csrq) {
        this.csrq = csrq;
    }

    public String getGjdm() {
        return gjdm;
    }

    public void setGjdm(String gjdm) {
        this.gjdm = gjdm;
    }

    public String getMzdm() {
        return mzdm;
    }

    public void setMzdm(String mzdm) {
        this.mzdm = mzdm;
    }

    public String getCyzjdm() {
        return cyzjdm;
    }

    public void setCyzjdm(String cyzjdm) {
        this.cyzjdm = cyzjdm;
    }

    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    public String getHjdz_xzqhdm() {
        return hjdz_xzqhdm;
    }

    public void setHjdz_xzqhdm(String hjdz_xzqhdm) {
        this.hjdz_xzqhdm = hjdz_xzqhdm;
    }

    public String getHjdz_dzmc() {
        return hjdz_dzmc;
    }

    public void setHjdz_dzmc(String hjdz_dzmc) {
        this.hjdz_dzmc = hjdz_dzmc;
    }

    public String getXzz_xzqhdm() {
        return xzz_xzqhdm;
    }

    public void setXzz_xzqhdm(String xzz_xzqhdm) {
        this.xzz_xzqhdm = xzz_xzqhdm;
    }

    public String getXzz_dzmc() {
        return xzz_dzmc;
    }

    public void setXzz_dzmc(String xzz_dzmc) {
        this.xzz_dzmc = xzz_dzmc;
    }

    public String getNydw_gajgjgdm() {
        return nydw_gajgjgdm;
    }

    public void setNydw_gajgjgdm(String nydw_gajgjgdm) {
        this.nydw_gajgjgdm = nydw_gajgjgdm;
    }

    public String getNydw_gajgmc() {
        return nydw_gajgmc;
    }

    public void setNydw_gajgmc(String nydw_gajgmc) {
        this.nydw_gajgmc = nydw_gajgmc;
    }

    public String getNyry_xm() {
        return nyry_xm;
    }

    public void setNyry_xm(String nyry_xm) {
        this.nyry_xm = nyry_xm;
    }

    public String getNyry_gmsfhm() {
        return nyry_gmsfhm;
    }

    public void setNyry_gmsfhm(String nyry_gmsfhm) {
        this.nyry_gmsfhm = nyry_gmsfhm;
    }

    public String getNyry_lxdh() {
        return nyry_lxdh;
    }

    public void setNyry_lxdh(String nyry_lxdh) {
        this.nyry_lxdh = nyry_lxdh;
    }

    public String getNysj() {
        return nysj;
    }

    public void setNysj(String nysj) {
        this.nysj = nysj;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }
}
