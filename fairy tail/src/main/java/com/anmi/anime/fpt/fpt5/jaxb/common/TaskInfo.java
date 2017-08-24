package com.anmi.anime.fpt.fpt5.jaxb.common;

import javax.xml.bind.annotation.*;

/**任务描述信息类
 * Created by wangjue on 2017/7/5.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "taskInfo")
@XmlType(propOrder = {"fingerprintNum","LatentNum","LTHitResultNum","TTHitResultNum","LLHitResultNum","latentTaskNum","printTaskNum","LTResultNum","TLResultNum",
        "TTResultNum","LLResultNum","CancelLatentNum","fssj","fsdw_gajgjgdm","fsdw_gajgmc","fsdw_xtlx","fsr_xm","fsr_gmsfhm","fsr_lxdm","jsdw_gajgjgdm","jsdw_gajgmc"})
public class TaskInfo {
    @XmlElement(name = "fingerprintNum")
    private int fingerprintNum;             //捺印指掌纹信息数量
    @XmlElement(name = "LatentNum")
    private int LatentNum;                  //现场指掌纹信息数量
    @XmlElement(name = "LTHitResultNum")
    private int LTHitResultNum;             //正查及倒查比中信息数量
    @XmlElement(name = "TTHitResultNum")
    private int TTHitResultNum;             //查重比中信息数量
    @XmlElement(name = "LLHitResultNum")
    private int LLHitResultNum;             //串查比中信息数量
    @XmlElement(name = "latentTaskNum")
    private int latentTaskNum;              //现场指掌纹查询请求信息数量
    @XmlElement(name = "printTaskNum")
    private int printTaskNum;               //现场指掌纹查询请求信息数量
    @XmlElement(name = "LTResultNum")
    private int LTResultNum;                //正查比对结果信息数量
    @XmlElement(name = "TLResultNum")
    private int TLResultNum;                //倒查比对结果信息数量
    @XmlElement(name = "TTResultNum")
    private int TTResultNum;                //查重比对结果信息数量
    @XmlElement(name = "LLResultNum")
    private int LLResultNum;                //查重比对结果信息数量
    @XmlElement(name = "CancelLatentNum")
    private int CancelLatentNum;            //撤销现场指纹信息数量
    @XmlElement(name = "fssj")
    private String fssj;                   //发送时间
    @XmlElement(name = "fsdw_gajgjgdm")
    private String fsdw_gajgjgdm;           //发送单位代码 12
    @XmlElement(name = "fsdw_gajgmc")
    private String fsdw_gajgmc;             //接收单位名称 < 100
    @XmlElement(name = "fsdw_xtlx")
    private String fsdw_xtlx;               //发送单位系统类型 4
    @XmlElement(name = "fsr_xm")
    private String fsr_xm;                  //发送单位系统类型 < 50
    @XmlElement(name = "fsr_gmsfhm")
    private String fsr_gmsfhm;              //发送人身份证号 18
    @XmlElement(name = "fsr_lxdm")
    private String fsr_lxdm;                //发送人联系电话 < 30
    @XmlElement(name = "jsdw_gajgjgdm")
    private String jsdw_gajgjgdm;           //接收单位代码 12
    @XmlElement(name = "jsdw_gajgmc")
    private String jsdw_gajgmc;             //接收单位名称 ， 100

    public int getFingerprintNum() {
        return fingerprintNum;
    }

    public void setFingerprintNum(int fingerprintNum) {
        this.fingerprintNum = fingerprintNum;
    }

    public int getLatentNum() {
        return LatentNum;
    }

    public void setLatentNum(int latentNum) {
        LatentNum = latentNum;
    }

    public int getLTHitResultNum() {
        return LTHitResultNum;
    }

    public void setLTHitResultNum(int LTHitResultNum) {
        this.LTHitResultNum = LTHitResultNum;
    }

    public int getTTHitResultNum() {
        return TTHitResultNum;
    }

    public void setTTHitResultNum(int TTHitResultNum) {
        this.TTHitResultNum = TTHitResultNum;
    }

    public int getLLHitResultNum() {
        return LLHitResultNum;
    }

    public void setLLHitResultNum(int LLHitResultNum) {
        this.LLHitResultNum = LLHitResultNum;
    }

    public int getLatentTaskNum() {
        return latentTaskNum;
    }

    public void setLatentTaskNum(int latentTaskNum) {
        this.latentTaskNum = latentTaskNum;
    }

    public int getPrintTaskNum() {
        return printTaskNum;
    }

    public void setPrintTaskNum(int printTaskNum) {
        this.printTaskNum = printTaskNum;
    }

    public int getLTResultNum() {
        return LTResultNum;
    }

    public void setLTResultNum(int LTResultNum) {
        this.LTResultNum = LTResultNum;
    }

    public int getTLResultNum() {
        return TLResultNum;
    }

    public void setTLResultNum(int TLResultNum) {
        this.TLResultNum = TLResultNum;
    }

    public int getTTResultNum() {
        return TTResultNum;
    }

    public void setTTResultNum(int TTResultNum) {
        this.TTResultNum = TTResultNum;
    }

    public int getLLResultNum() {
        return LLResultNum;
    }

    public void setLLResultNum(int LLResultNum) {
        this.LLResultNum = LLResultNum;
    }

    public int getCancelLatentNum() {
        return CancelLatentNum;
    }

    public void setCancelLatentNum(int cancelLatentNum) {
        CancelLatentNum = cancelLatentNum;
    }

    public String getFssj() {
        return fssj;
    }

    public void setFssj(String fssj) {
        this.fssj = fssj;
    }

    public String getFsdw_gajgjgdm() {
        return fsdw_gajgjgdm;
    }

    public void setFsdw_gajgjgdm(String fsdw_gajgjgdm) {
        this.fsdw_gajgjgdm = fsdw_gajgjgdm;
    }

    public String getFsdw_gajgmc() {
        return fsdw_gajgmc;
    }

    public void setFsdw_gajgmc(String fsdw_gajgmc) {
        this.fsdw_gajgmc = fsdw_gajgmc;
    }

    public String getFsdw_xtlx() {
        return fsdw_xtlx;
    }

    public void setFsdw_xtlx(String fsdw_xtlx) {
        this.fsdw_xtlx = fsdw_xtlx;
    }

    public String getFsr_xm() {
        return fsr_xm;
    }

    public void setFsr_xm(String fsr_xm) {
        this.fsr_xm = fsr_xm;
    }

    public String getFsr_gmsfhm() {
        return fsr_gmsfhm;
    }

    public void setFsr_gmsfhm(String fsr_gmsfhm) {
        this.fsr_gmsfhm = fsr_gmsfhm;
    }

    public String getFsr_lxdm() {
        return fsr_lxdm;
    }

    public void setFsr_lxdm(String fsr_lxdm) {
        this.fsr_lxdm = fsr_lxdm;
    }

    public String getJsdw_gajgjgdm() {
        return jsdw_gajgjgdm;
    }

    public void setJsdw_gajgjgdm(String jsdw_gajgjgdm) {
        this.jsdw_gajgjgdm = jsdw_gajgjgdm;
    }

    public String getJsdw_gajgmc() {
        return jsdw_gajgmc;
    }

    public void setJsdw_gajgmc(String jsdw_gajgmc) {
        this.jsdw_gajgmc = jsdw_gajgmc;
    }
}
