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
@Table(name = "GAFIS_GATHER_PALM")
@DynamicInsert()
@DynamicUpdate()
public class GafisGatherPalmEntity {
    private String pkId;
    private String personId;
    private long fgp;
    private Integer groupId;
    private Integer lobtype;
    private byte[] gatherData;
    private String inputpsn;
    private Date inputtime;
    private String modifiedpsn;
    private Date modifiedtime;
    private Long seq;
    private String palmDataNosqlId;

    @Id
    @Column(name = "PK_ID")
    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    @Basic
    @Column(name = "PERSON_ID")
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "FGP")
    public long getFgp() {
        return fgp;
    }

    public void setFgp(long fgp) {
        this.fgp = fgp;
    }

    @Basic
    @Column(name = "GROUP_ID")
    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "LOBTYPE")
    public Integer isLobtype() {
        return lobtype;
    }

    public void setLobtype(Integer lobtype) {
        this.lobtype = lobtype;
    }

    @Basic
    @Column(name = "GATHER_DATA")
    public byte[] getGatherData() {
        return gatherData;
    }

    public void setGatherData(byte[] gatherData) {
        this.gatherData = gatherData;
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
    @Column(name = "INPUTTIME")
    public Date getInputtime() {
        return inputtime;
    }

    public void setInputtime(Date inputtime) {
        this.inputtime = inputtime;
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
    @Column(name = "MODIFIEDTIME")
    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    @Basic
    @Column(name = "SEQ")
    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    @Basic
    @Column(name = "PALM_DATA_NOSQL_ID")
    public String getPalmDataNosqlId() {
        return palmDataNosqlId;
    }

    public void setPalmDataNosqlId(String palmDataNosqlId) {
        this.palmDataNosqlId = palmDataNosqlId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GafisGatherPalmEntity that = (GafisGatherPalmEntity) o;

        if (fgp != that.fgp) return false;
        if (lobtype != that.lobtype) return false;
        if (pkId != null ? !pkId.equals(that.pkId) : that.pkId != null) return false;
        if (personId != null ? !personId.equals(that.personId) : that.personId != null) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (!Arrays.equals(gatherData, that.gatherData)) return false;
        if (inputpsn != null ? !inputpsn.equals(that.inputpsn) : that.inputpsn != null) return false;
        if (inputtime != null ? !inputtime.equals(that.inputtime) : that.inputtime != null) return false;
        if (modifiedpsn != null ? !modifiedpsn.equals(that.modifiedpsn) : that.modifiedpsn != null) return false;
        if (modifiedtime != null ? !modifiedtime.equals(that.modifiedtime) : that.modifiedtime != null) return false;
        if (seq != null ? !seq.equals(that.seq) : that.seq != null) return false;
        if (palmDataNosqlId != null ? !palmDataNosqlId.equals(that.palmDataNosqlId) : that.palmDataNosqlId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pkId != null ? pkId.hashCode() : 0;
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        result = 31 * result + (int) (fgp ^ (fgp >>> 32));
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + lobtype ^ (lobtype >>> 32);
        result = 31 * result + Arrays.hashCode(gatherData);
        result = 31 * result + (inputpsn != null ? inputpsn.hashCode() : 0);
        result = 31 * result + (inputtime != null ? inputtime.hashCode() : 0);
        result = 31 * result + (modifiedpsn != null ? modifiedpsn.hashCode() : 0);
        result = 31 * result + (modifiedtime != null ? modifiedtime.hashCode() : 0);
        result = 31 * result + (seq != null ? seq.hashCode() : 0);
        result = 31 * result + (palmDataNosqlId != null ? palmDataNosqlId.hashCode() : 0);
        return result;
    }
}
