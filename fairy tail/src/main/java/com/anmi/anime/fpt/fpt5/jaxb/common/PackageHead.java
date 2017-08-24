package com.anmi.anime.fpt.fpt5.jaxb.common;

import javax.xml.bind.annotation.*;

/**头部信息类
 * Created by wangjue on 2017/7/5.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "packageHead")
@XmlType(name = "packageHead",propOrder = { "bbh","dbsj","xxly" })
public class PackageHead {
    @XmlElement(name = "bbh")
    private String bbh;     //版本包
    @XmlElement(name = "dbsj")
    private String dbsj;      //打包时间
    @XmlElement(name = "xxly")
    private String xxly;    //信息来源

    public String getBbh() {
        return bbh;
    }

    public void setBbh(String bbh) {
        this.bbh = bbh;
    }

    public String getDbsj() {
        return dbsj;
    }

    public void setDbsj(String dbsj) {
        this.dbsj = dbsj;
    }

    public String getXxly() {
        return xxly;
    }

    public void setXxly(String xxly) {
        this.xxly = xxly;
    }
}
