package com.anmi.anime.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Time;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by wangjue on 2017/9/7.
 */
@Entity
@Table(name = "GAFIS_CASE_PALM_MNT")
@DynamicInsert()
@DynamicUpdate()
public class GafisCasePalmMntEntity {
    private String pkId;
    private String palmId;
    private String captureMethod;
    private byte[] palmMnt;
    private byte[] palmRidge;
    private String mainMnt;
    private Date modifiedtime;
    private String modifiedpsn;
    private Date inputtime;
    private String inputpsn;
    private String palmMntNosqlId;
    private String palmRidgeNosqlId;

    @Id
    @Column(name = "PK_ID")
    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    @Basic
    @Column(name = "PALM_ID")
    public String getPalmId() {
        return palmId;
    }

    public void setPalmId(String palmId) {
        this.palmId = palmId;
    }

    @Basic
    @Column(name = "CAPTURE_METHOD")
    public String getCaptureMethod() {
        return captureMethod;
    }

    public void setCaptureMethod(String captureMethod) {
        this.captureMethod = captureMethod;
    }

    @Basic
    @Column(name = "PALM_MNT")
    public byte[] getPalmMnt() {
        return palmMnt;
    }

    public void setPalmMnt(byte[] palmMnt) {
        this.palmMnt = palmMnt;
    }

    @Basic
    @Column(name = "PALM_RIDGE")
    public byte[] getPalmRidge() {
        return palmRidge;
    }

    public void setPalmRidge(byte[] palmRidge) {
        this.palmRidge = palmRidge;
    }


    @Basic
    @Column(name = "IS_MAIN_MNT")
    public String getMainMnt() {
        return mainMnt;
    }

    public void setMainMnt(String mainMnt) {
        this.mainMnt = mainMnt;
    }

    @Basic
    @Column(name = "MODIFIEDTIME")
    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    @Basic
    @Column(name = "MODIFIEDPSN")
    public String getModifiedpsn() {
        return modifiedpsn;
    }

    public void setModifiedpsn(String modifiedpsn) {
        this.modifiedpsn = modifiedpsn;
    }

    @Basic
    @Column(name = "INPUTTIME")
    public Date getInputtime() {
        return inputtime;
    }

    public void setInputtime(Date inputtime) {
        this.inputtime = inputtime;
    }

    @Basic
    @Column(name = "INPUTPSN")
    public String getInputpsn() {
        return inputpsn;
    }

    public void setInputpsn(String inputpsn) {
        this.inputpsn = inputpsn;
    }

    @Basic
    @Column(name = "PALM_MNT_NOSQL_ID")
    public String getPalmMntNosqlId() {
        return palmMntNosqlId;
    }

    public void setPalmMntNosqlId(String palmMntNosqlId) {
        this.palmMntNosqlId = palmMntNosqlId;
    }

    @Basic
    @Column(name = "PALM_RIDGE_NOSQL_ID")
    public String getPalmRidgeNosqlId() {
        return palmRidgeNosqlId;
    }

    public void setPalmRidgeNosqlId(String palmRidgeNosqlId) {
        this.palmRidgeNosqlId = palmRidgeNosqlId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GafisCasePalmMntEntity that = (GafisCasePalmMntEntity) o;

        if (pkId != null ? !pkId.equals(that.pkId) : that.pkId != null) return false;
        if (palmId != null ? !palmId.equals(that.palmId) : that.palmId != null) return false;
        if (captureMethod != null ? !captureMethod.equals(that.captureMethod) : that.captureMethod != null)
            return false;
        if (!Arrays.equals(palmMnt, that.palmMnt)) return false;
        if (!Arrays.equals(palmRidge, that.palmRidge)) return false;
        if (mainMnt != null ? !mainMnt.equals(that.mainMnt) : that.mainMnt != null) return false;
        if (modifiedtime != null ? !modifiedtime.equals(that.modifiedtime) : that.modifiedtime != null) return false;
        if (modifiedpsn != null ? !modifiedpsn.equals(that.modifiedpsn) : that.modifiedpsn != null) return false;
        if (inputtime != null ? !inputtime.equals(that.inputtime) : that.inputtime != null) return false;
        if (inputpsn != null ? !inputpsn.equals(that.inputpsn) : that.inputpsn != null) return false;
        if (palmMntNosqlId != null ? !palmMntNosqlId.equals(that.palmMntNosqlId) : that.palmMntNosqlId != null)
            return false;
        if (palmRidgeNosqlId != null ? !palmRidgeNosqlId.equals(that.palmRidgeNosqlId) : that.palmRidgeNosqlId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pkId != null ? pkId.hashCode() : 0;
        result = 31 * result + (palmId != null ? palmId.hashCode() : 0);
        result = 31 * result + (captureMethod != null ? captureMethod.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(palmMnt);
        result = 31 * result + Arrays.hashCode(palmRidge);
        result = 31 * result + (mainMnt != null ? mainMnt.hashCode() : 0);
        result = 31 * result + (modifiedtime != null ? modifiedtime.hashCode() : 0);
        result = 31 * result + (modifiedpsn != null ? modifiedpsn.hashCode() : 0);
        result = 31 * result + (inputtime != null ? inputtime.hashCode() : 0);
        result = 31 * result + (inputpsn != null ? inputpsn.hashCode() : 0);
        result = 31 * result + (palmMntNosqlId != null ? palmMntNosqlId.hashCode() : 0);
        result = 31 * result + (palmRidgeNosqlId != null ? palmRidgeNosqlId.hashCode() : 0);
        return result;
    }
}
