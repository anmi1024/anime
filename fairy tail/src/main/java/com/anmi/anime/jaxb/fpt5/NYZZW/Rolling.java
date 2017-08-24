package com.anmi.anime.jaxb.fpt5.NYZZW;

/**
 * Created by wangjue on 2017/7/6.
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 滚动指纹
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Rolling {
    @XmlElement(name = "fingerMsg")
    private FingerMsg fingerMsg;

    public FingerMsg getFingerMsg() {
        return fingerMsg;
    }

    public void setFingerMsg(FingerMsg fingerMsg) {
        this.fingerMsg = fingerMsg;
    }
}