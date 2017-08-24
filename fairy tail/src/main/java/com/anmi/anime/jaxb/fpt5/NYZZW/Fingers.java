package com.anmi.anime.jaxb.fpt5.NYZZW;

/**
 * Created by wangjue on 2017/7/6.
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * 指纹信息
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Fingers {
    @XmlElement(name = "planar")
    private List<Planar> planar;
    @XmlElement(name = "rolling")
    private List<Rolling> rolling;

    public List<Planar> getPlanar() {
        return planar;
    }

    public void setPlanar(List<Planar> planar) {
        this.planar = planar;
    }

    public List<Rolling> getRolling() {
        return rolling;
    }

    public void setRolling(List<Rolling> rolling) {
        this.rolling = rolling;
    }
}
