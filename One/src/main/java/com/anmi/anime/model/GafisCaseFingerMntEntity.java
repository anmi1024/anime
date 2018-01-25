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
@Table(name = "GAFIS_CASE_FINGER_MNT")
@DynamicInsert()
@DynamicUpdate()
public class GafisCaseFingerMntEntity {
    private String pkId;
    private String fingerId;
    private String captureMethod;
    private byte[] fingerMnt;
    private byte[] fingerRidge;
    private String mainMnt;
    private Date modifiedtime;
    private String modifiedpsn;
    private Date inputtime;
    private String inputpsn;
    private String deletag;
    private String fingerMntNosqlId;
    private String fingerRidgeNosqlId;

    @Id
    @Column(name = "PK_ID")
    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    @Basic
    @Column(name = "FINGER_ID")
    public String getFingerId() {
        return fingerId;
    }

    public void setFingerId(String fingerId) {
        this.fingerId = fingerId;
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
    @Column(name = "FINGER_MNT")
    public byte[] getFingerMnt() {
        return fingerMnt;
    }

    public void setFingerMnt(byte[] fingerMnt) {
        this.fingerMnt = fingerMnt;
    }

    @Basic
    @Column(name = "FINGER_RIDGE")
    public byte[] getFingerRidge() {
        return fingerRidge;
    }

    public void setFingerRidge(byte[] fingerRidge) {
        this.fingerRidge = fingerRidge;
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
    @Column(name = "DELETAG")
    public String getDeletag() {
        return deletag;
    }

    public void setDeletag(String deletag) {
        this.deletag = deletag;
    }

    @Basic
    @Column(name = "FINGER_MNT_NOSQL_ID")
    public String getFingerMntNosqlId() {
        return fingerMntNosqlId;
    }

    public void setFingerMntNosqlId(String fingerMntNosqlId) {
        this.fingerMntNosqlId = fingerMntNosqlId;
    }

    @Basic
    @Column(name = "FINGER_RIDGE_NOSQL_ID")
    public String getFingerRidgeNosqlId() {
        return fingerRidgeNosqlId;
    }

    public void setFingerRidgeNosqlId(String fingerRidgeNosqlId) {
        this.fingerRidgeNosqlId = fingerRidgeNosqlId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GafisCaseFingerMntEntity that = (GafisCaseFingerMntEntity) o;

        if (pkId != null ? !pkId.equals(that.pkId) : that.pkId != null) return false;
        if (fingerId != null ? !fingerId.equals(that.fingerId) : that.fingerId != null) return false;
        if (captureMethod != null ? !captureMethod.equals(that.captureMethod) : that.captureMethod != null)
            return false;
        if (!Arrays.equals(fingerMnt, that.fingerMnt)) return false;
        if (!Arrays.equals(fingerRidge, that.fingerRidge)) return false;
        if (mainMnt != null ? !mainMnt.equals(that.mainMnt) : that.mainMnt != null) return false;
        if (modifiedtime != null ? !modifiedtime.equals(that.modifiedtime) : that.modifiedtime != null) return false;
        if (modifiedpsn != null ? !modifiedpsn.equals(that.modifiedpsn) : that.modifiedpsn != null) return false;
        if (inputtime != null ? !inputtime.equals(that.inputtime) : that.inputtime != null) return false;
        if (inputpsn != null ? !inputpsn.equals(that.inputpsn) : that.inputpsn != null) return false;
        if (deletag != null ? !deletag.equals(that.deletag) : that.deletag != null) return false;
        if (fingerMntNosqlId != null ? !fingerMntNosqlId.equals(that.fingerMntNosqlId) : that.fingerMntNosqlId != null)
            return false;
        if (fingerRidgeNosqlId != null ? !fingerRidgeNosqlId.equals(that.fingerRidgeNosqlId) : that.fingerRidgeNosqlId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pkId != null ? pkId.hashCode() : 0;
        result = 31 * result + (fingerId != null ? fingerId.hashCode() : 0);
        result = 31 * result + (captureMethod != null ? captureMethod.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(fingerMnt);
        result = 31 * result + Arrays.hashCode(fingerRidge);
        result = 31 * result + (mainMnt != null ? mainMnt.hashCode() : 0);
        result = 31 * result + (modifiedtime != null ? modifiedtime.hashCode() : 0);
        result = 31 * result + (modifiedpsn != null ? modifiedpsn.hashCode() : 0);
        result = 31 * result + (inputtime != null ? inputtime.hashCode() : 0);
        result = 31 * result + (inputpsn != null ? inputpsn.hashCode() : 0);
        result = 31 * result + (deletag != null ? deletag.hashCode() : 0);
        result = 31 * result + (fingerMntNosqlId != null ? fingerMntNosqlId.hashCode() : 0);
        result = 31 * result + (fingerRidgeNosqlId != null ? fingerRidgeNosqlId.hashCode() : 0);
        return result;
    }
}
