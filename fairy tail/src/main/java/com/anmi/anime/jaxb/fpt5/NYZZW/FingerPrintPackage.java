package com.anmi.anime.jaxb.fpt5.NYZZW;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by wangjue on 2017/7/6.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "fingerPrintPackage")
public class FingerPrintPackage {
    @XmlElement(name = "peopleMsg")
    private PeopleMsg peopleMsg;
    @XmlElement(name = "fingerPrintMsg")
    private FingerPrintMsg fingerPrintMsg;
    @XmlElement(name = "fingers")
    private Fingers fingers;

    public PeopleMsg getPeopleMsg() {
        return peopleMsg;
    }

    public void setPeopleMsg(PeopleMsg peopleMsg) {
        this.peopleMsg = peopleMsg;
    }

    public FingerPrintMsg getFingerPrintMsg() {
        return fingerPrintMsg;
    }

    public void setFingerPrintMsg(FingerPrintMsg fingerPrintMsg) {
        this.fingerPrintMsg = fingerPrintMsg;
    }

    public Fingers getFingers() {
        return fingers;
    }

    public void setFingers(Fingers fingers) {
        this.fingers = fingers;
    }

}