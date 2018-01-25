package com.anmi.anime.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * Created by wangjue on 2017/11/28.
 */
@Entity
@Table(name = "GAFIS_DAKU_TEMPLATE_CLASSIFY")
public class GafisDakuTemplateClassifyEntity {
    private String pkid;
    private String cardid;
    private Long fgp;
    private Long mntcount;          //细节点个数
    private Long imgqlev;           //指纹图像质量，主要反映纹线清晰程度，0－100
    private Long rpqlev;            //形态特征总体质量， 建议80分以下要干预
    private Long coreqlev;          //中心可靠程度，0－100以及255，255代表主纹型下该特征不存在，0代表该特征未被提取（副中心，三角类似）
    private Long vcoreqlev;         //副中心可靠度
    private Long ldeltaqlev;        //左三角可靠度
    private Long rdeltaqlev;        //右三角可靠度
    private Long mainPattern;       //主纹型（0:不确定;1:弓型;2:左箕;3:右箕;4:斗）
    private Long vicePattern;       //副纹型（0:不确定;1:弓型;2:左箕;3:右箕;4:斗）
    private Date createtime;        //创建时间
    private Date modifytime;        //修改时间
    private String firmcode;        //厂商代码
    private String description;

    private Long width;             //宽
    private Long height;            //高
    private Long resolution;        //分辨率

    @Id
    @Column(name = "PKID")
    public String getPkid() {
        return pkid;
    }

    public void setPkid(String pkid) {
        this.pkid = pkid;
    }

    @Basic
    @Column(name = "CARDID")
    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    @Basic
    @Column(name = "FGP")
    public Long getFgp() {
        return fgp;
    }

    public void setFgp(Long fgp) {
        this.fgp = fgp;
    }

    @Basic
    @Column(name = "MNTCOUNT")
    public Long getMntcount() {
        return mntcount;
    }

    public void setMntcount(Long mntcount) {
        this.mntcount = mntcount;
    }

    @Basic
    @Column(name = "IMGQLEV")
    public Long getImgqlev() {
        return imgqlev;
    }

    public void setImgqlev(Long imgqlev) {
        this.imgqlev = imgqlev;
    }

    @Basic
    @Column(name = "RPQLEV")
    public Long getRpqlev() {
        return rpqlev;
    }

    public void setRpqlev(Long rpqlev) {
        this.rpqlev = rpqlev;
    }

    @Basic
    @Column(name = "COREQLEV")
    public Long getCoreqlev() {
        return coreqlev;
    }

    public void setCoreqlev(Long coreqlev) {
        this.coreqlev = coreqlev;
    }

    @Basic
    @Column(name = "VCOREQLEV")
    public Long getVcoreqlev() {
        return vcoreqlev;
    }

    public void setVcoreqlev(Long vcoreqlev) {
        this.vcoreqlev = vcoreqlev;
    }

    @Basic
    @Column(name = "LDELTAQLEV")
    public Long getLdeltaqlev() {
        return ldeltaqlev;
    }

    public void setLdeltaqlev(Long ldeltaqlev) {
        this.ldeltaqlev = ldeltaqlev;
    }

    @Basic
    @Column(name = "RDELTAQLEV")
    public Long getRdeltaqlev() {
        return rdeltaqlev;
    }

    public void setRdeltaqlev(Long rdeltaqlev) {
        this.rdeltaqlev = rdeltaqlev;
    }

    @Basic
    @Column(name = "MAIN_PATTERN")
    public Long getMainPattern() {
        return mainPattern;
    }

    public void setMainPattern(Long mainPattern) {
        this.mainPattern = mainPattern;
    }

    @Basic
    @Column(name = "VICE_PATTERN")
    public Long getVicePattern() {
        return vicePattern;
    }

    public void setVicePattern(Long vicePattern) {
        this.vicePattern = vicePattern;
    }

    @Basic
    @Column(name = "CREATETIME")
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "MODIFYTIME")
    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    @Basic
    @Column(name = "FIRMCODE")
    public String getFirmcode() {
        return firmcode;
    }

    public void setFirmcode(String firmcode) {
        this.firmcode = firmcode;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Basic
    @Column(name = "WIDTH")
    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    @Basic
    @Column(name = "HEIGHT")
    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    @Basic
    @Column(name = "RESOLUTION")
    public Long getResolution() {
        return resolution;
    }

    public void setResolution(Long resolution) {
        this.resolution = resolution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GafisDakuTemplateClassifyEntity that = (GafisDakuTemplateClassifyEntity) o;

        if (pkid != null ? !pkid.equals(that.pkid) : that.pkid != null) return false;
        if (cardid != null ? !cardid.equals(that.cardid) : that.cardid != null) return false;
        if (fgp != null ? !fgp.equals(that.fgp) : that.fgp != null) return false;
        if (mntcount != null ? !mntcount.equals(that.mntcount) : that.mntcount != null) return false;
        if (imgqlev != null ? !imgqlev.equals(that.imgqlev) : that.imgqlev != null) return false;
        if (rpqlev != null ? !rpqlev.equals(that.rpqlev) : that.rpqlev != null) return false;
        if (coreqlev != null ? !coreqlev.equals(that.coreqlev) : that.coreqlev != null) return false;
        if (vcoreqlev != null ? !vcoreqlev.equals(that.vcoreqlev) : that.vcoreqlev != null) return false;
        if (ldeltaqlev != null ? !ldeltaqlev.equals(that.ldeltaqlev) : that.ldeltaqlev != null) return false;
        if (rdeltaqlev != null ? !rdeltaqlev.equals(that.rdeltaqlev) : that.rdeltaqlev != null) return false;
        if (mainPattern != null ? !mainPattern.equals(that.mainPattern) : that.mainPattern != null) return false;
        if (vicePattern != null ? !vicePattern.equals(that.vicePattern) : that.vicePattern != null) return false;
        if (createtime != null ? !createtime.equals(that.createtime) : that.createtime != null) return false;
        if (modifytime != null ? !modifytime.equals(that.modifytime) : that.modifytime != null) return false;
        if (firmcode != null ? !firmcode.equals(that.firmcode) : that.firmcode != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pkid != null ? pkid.hashCode() : 0;
        result = 31 * result + (cardid != null ? cardid.hashCode() : 0);
        result = 31 * result + (fgp != null ? fgp.hashCode() : 0);
        result = 31 * result + (mntcount != null ? mntcount.hashCode() : 0);
        result = 31 * result + (imgqlev != null ? imgqlev.hashCode() : 0);
        result = 31 * result + (rpqlev != null ? rpqlev.hashCode() : 0);
        result = 31 * result + (coreqlev != null ? coreqlev.hashCode() : 0);
        result = 31 * result + (vcoreqlev != null ? vcoreqlev.hashCode() : 0);
        result = 31 * result + (ldeltaqlev != null ? ldeltaqlev.hashCode() : 0);
        result = 31 * result + (rdeltaqlev != null ? rdeltaqlev.hashCode() : 0);
        result = 31 * result + (mainPattern != null ? mainPattern.hashCode() : 0);
        result = 31 * result + (vicePattern != null ? vicePattern.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        result = 31 * result + (modifytime != null ? modifytime.hashCode() : 0);
        result = 31 * result + (firmcode != null ? firmcode.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
