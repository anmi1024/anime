package com.anmi.anime.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * Created by wangjue on 2017/11/28.
 */
@Entity
@Table(name = "GAFIS_DAKU_LATENT_CLASSIFY")
public class GafisDakuLatentClassifyEntity {
    private String pkid;
    private String cardid;
    private Long mntcount;          //细节点个数
    private Long imgqlev;           //指纹图像质量，主要反映纹线清晰程度，0－100
    private Long rpqlev;            //形态特征总体质量， 建议80分以下要干预
    private String pattern;           //纹型（0:不确定;1:弓型;2:左箕;3:右箕;4:斗）
    private String fgp;             //候选指位
    private Date createtime;
    private Date modifytime;
    private String firmcode;
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
    @Column(name = "PATTERN")
    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Basic
    @Column(name = "FGP")
    public String getFgp() {
        return fgp;
    }

    public void setFgp(String fgp) {
        this.fgp = fgp;
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

        GafisDakuLatentClassifyEntity that = (GafisDakuLatentClassifyEntity) o;

        if (pkid != null ? !pkid.equals(that.pkid) : that.pkid != null) return false;
        if (cardid != null ? !cardid.equals(that.cardid) : that.cardid != null) return false;
        if (mntcount != null ? !mntcount.equals(that.mntcount) : that.mntcount != null) return false;
        if (imgqlev != null ? !imgqlev.equals(that.imgqlev) : that.imgqlev != null) return false;
        if (rpqlev != null ? !rpqlev.equals(that.rpqlev) : that.rpqlev != null) return false;
        if (pattern != null ? !pattern.equals(that.pattern) : that.pattern != null) return false;
        if (fgp != null ? !fgp.equals(that.fgp) : that.fgp != null) return false;
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
        result = 31 * result + (mntcount != null ? mntcount.hashCode() : 0);
        result = 31 * result + (imgqlev != null ? imgqlev.hashCode() : 0);
        result = 31 * result + (rpqlev != null ? rpqlev.hashCode() : 0);
        result = 31 * result + (pattern != null ? pattern.hashCode() : 0);
        result = 31 * result + (fgp != null ? fgp.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        result = 31 * result + (modifytime != null ? modifytime.hashCode() : 0);
        result = 31 * result + (firmcode != null ? firmcode.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
