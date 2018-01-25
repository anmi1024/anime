package com.anmi.anime.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wangjue on 2017/9/7.
 */
@Entity
@Table(name = "GAFIS_GATHER_FINGER")
@DynamicInsert()
@DynamicUpdate()
public class GafisGatherFingerEntity {
    private String pkId;
    private String personId;
    private Integer fgp;
    private Integer groupId;
    private Integer lobtype;
    private String inputpsn;
    private Date inputtime;
    private String modifiedpsn;
    private Date modifiedtime;
    private String fgpCase;
    private Boolean auditStatus;
    private String description;
    private Boolean mainPattern;
    private Boolean vicePattern;
    private byte[] gatherData;
    private Long seq;
    private String fingerDataNosqlId;
    private String fptPath;

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
    public Integer getFgp() {
        return fgp;
    }

    public void setFgp(Integer fgp) {
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
    @Column(name = "FGP_CASE")
    public String getFgpCase() {
        return fgpCase;
    }

    public void setFgpCase(String fgpCase) {
        this.fgpCase = fgpCase;
    }

    @Basic
    @Column(name = "AUDIT_STATUS")
    public Boolean getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Boolean auditStatus) {
        this.auditStatus = auditStatus;
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
    @Column(name = "MAIN_PATTERN")
    public Boolean getMainPattern() {
        return mainPattern;
    }

    public void setMainPattern(Boolean mainPattern) {
        this.mainPattern = mainPattern;
    }

    @Basic
    @Column(name = "VICE_PATTERN")
    public Boolean getVicePattern() {
        return vicePattern;
    }

    public void setVicePattern(Boolean vicePattern) {
        this.vicePattern = vicePattern;
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
    @Column(name = "SEQ")
    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    @Basic
    @Column(name = "FINGER_DATA_NOSQL_ID")
    public String getFingerDataNosqlId() {
        return fingerDataNosqlId;
    }

    public void setFingerDataNosqlId(String fingerDataNosqlId) {
        this.fingerDataNosqlId = fingerDataNosqlId;
    }

    @Basic
    @Column(name = "FPT_PATH")
    public String getFptPath() {
        return fptPath;
    }

    public void setFptPath(String fptPath) {
        this.fptPath = fptPath;
    }

    @Override
    public int hashCode() {
        return personId.hashCode()+groupId+(Integer.valueOf(fgpCase)+fgp);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof GafisGatherFingerEntity)) return false;
        if (this == obj ) return true;
        if (obj.getClass() == GafisGatherFingerEntity.class) {
            GafisGatherFingerEntity finger = (GafisGatherFingerEntity)obj;
            return personId.equals(finger.getPersonId()) &&
                    groupId == finger.getGroupId() &&
                    fgpCase.equals(finger.getFgpCase()) &&
                    fgp == finger.getFgp();
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
