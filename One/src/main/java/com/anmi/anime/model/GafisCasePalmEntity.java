package com.anmi.anime.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Time;
import java.util.Arrays;

/**
 * Created by wangjue on 2017/9/7.
 */
@Entity
@Table(name = "GAFIS_CASE_PALM")
@DynamicInsert()
@DynamicUpdate()
public class GafisCasePalmEntity {
    private String seqNo;
    private String palmId;
    private String caseId;
    private String isCorpse;
    private String corpseNo;
    private String remainPlace;
    private String fgp;
    private String pattern;
    private String ridgeColor;
    private String thanStatus;
    private String isAssist;
    private byte[] palmImg;
    private byte[] palmCpr;
    private Long ltCount;
    private Long llCount;
    private Long ltCountModMnt;
    private Long llCountModMnt;
    private Long editCount;
    private Time ltDate;
    private Time llDate;
    private String ltOperator;
    private String llOperator;
    private String creatorUnitCode;
    private String updatorUnitCode;
    private Time modifiedtime;
    private String modifiedpsn;
    private Time inputtime;
    private String inputpsn;
    private String deletag;
    private String remark;
    private String ltStatus;
    private String llStatus;
    private Long sid;
    private String matchStatus;
    private String developMethod;
    private String palmImgNosqlId;
    private String palmCprNosqlId;
    private Long seq;
    private Long mntCount;

    @Basic
    @Column(name = "SEQ_NO")
    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    @Id
    @Column(name = "PALM_ID")
    public String getPalmId() {
        return palmId;
    }

    public void setPalmId(String palmId) {
        this.palmId = palmId;
    }

    @Basic
    @Column(name = "CASE_ID")
    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    @Basic
    @Column(name = "IS_CORPSE")
    public String getIsCorpse() {
        return isCorpse;
    }

    public void setIsCorpse(String isCorpse) {
        this.isCorpse = isCorpse;
    }

    @Basic
    @Column(name = "CORPSE_NO")
    public String getCorpseNo() {
        return corpseNo;
    }

    public void setCorpseNo(String corpseNo) {
        this.corpseNo = corpseNo;
    }

    @Basic
    @Column(name = "REMAIN_PLACE")
    public String getRemainPlace() {
        return remainPlace;
    }

    public void setRemainPlace(String remainPlace) {
        this.remainPlace = remainPlace;
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
    @Column(name = "PATTERN")
    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Basic
    @Column(name = "RIDGE_COLOR")
    public String getRidgeColor() {
        return ridgeColor;
    }

    public void setRidgeColor(String ridgeColor) {
        this.ridgeColor = ridgeColor;
    }

    @Basic
    @Column(name = "THAN_STATUS")
    public String getThanStatus() {
        return thanStatus;
    }

    public void setThanStatus(String thanStatus) {
        this.thanStatus = thanStatus;
    }

    @Basic
    @Column(name = "IS_ASSIST")
    public String getIsAssist() {
        return isAssist;
    }

    public void setIsAssist(String isAssist) {
        this.isAssist = isAssist;
    }

    @Basic
    @Column(name = "PALM_IMG")
    public byte[] getPalmImg() {
        return palmImg;
    }

    public void setPalmImg(byte[] palmImg) {
        this.palmImg = palmImg;
    }

    @Basic
    @Column(name = "PALM_CPR")
    public byte[] getPalmCpr() {
        return palmCpr;
    }

    public void setPalmCpr(byte[] palmCpr) {
        this.palmCpr = palmCpr;
    }

    @Basic
    @Column(name = "LT_COUNT")
    public Long getLtCount() {
        return ltCount;
    }

    public void setLtCount(Long ltCount) {
        this.ltCount = ltCount;
    }

    @Basic
    @Column(name = "LL_COUNT")
    public Long getLlCount() {
        return llCount;
    }

    public void setLlCount(Long llCount) {
        this.llCount = llCount;
    }

    @Basic
    @Column(name = "LT_COUNT_MOD_MNT")
    public Long getLtCountModMnt() {
        return ltCountModMnt;
    }

    public void setLtCountModMnt(Long ltCountModMnt) {
        this.ltCountModMnt = ltCountModMnt;
    }

    @Basic
    @Column(name = "LL_COUNT_MOD_MNT")
    public Long getLlCountModMnt() {
        return llCountModMnt;
    }

    public void setLlCountModMnt(Long llCountModMnt) {
        this.llCountModMnt = llCountModMnt;
    }

    @Basic
    @Column(name = "EDIT_COUNT")
    public Long getEditCount() {
        return editCount;
    }

    public void setEditCount(Long editCount) {
        this.editCount = editCount;
    }

    @Basic
    @Column(name = "LT_DATE")
    public Time getLtDate() {
        return ltDate;
    }

    public void setLtDate(Time ltDate) {
        this.ltDate = ltDate;
    }

    @Basic
    @Column(name = "LL_DATE")
    public Time getLlDate() {
        return llDate;
    }

    public void setLlDate(Time llDate) {
        this.llDate = llDate;
    }

    @Basic
    @Column(name = "LT_OPERATOR")
    public String getLtOperator() {
        return ltOperator;
    }

    public void setLtOperator(String ltOperator) {
        this.ltOperator = ltOperator;
    }

    @Basic
    @Column(name = "LL_OPERATOR")
    public String getLlOperator() {
        return llOperator;
    }

    public void setLlOperator(String llOperator) {
        this.llOperator = llOperator;
    }

    @Basic
    @Column(name = "CREATOR_UNIT_CODE")
    public String getCreatorUnitCode() {
        return creatorUnitCode;
    }

    public void setCreatorUnitCode(String creatorUnitCode) {
        this.creatorUnitCode = creatorUnitCode;
    }

    @Basic
    @Column(name = "UPDATOR_UNIT_CODE")
    public String getUpdatorUnitCode() {
        return updatorUnitCode;
    }

    public void setUpdatorUnitCode(String updatorUnitCode) {
        this.updatorUnitCode = updatorUnitCode;
    }

    @Basic
    @Column(name = "MODIFIEDTIME")
    public Time getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Time modifiedtime) {
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
    public Time getInputtime() {
        return inputtime;
    }

    public void setInputtime(Time inputtime) {
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
    @Column(name = "REMARK")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "LT_STATUS")
    public String getLtStatus() {
        return ltStatus;
    }

    public void setLtStatus(String ltStatus) {
        this.ltStatus = ltStatus;
    }

    @Basic
    @Column(name = "LL_STATUS")
    public String getLlStatus() {
        return llStatus;
    }

    public void setLlStatus(String llStatus) {
        this.llStatus = llStatus;
    }

    @Basic
    @Column(name = "SID")
    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "MATCH_STATUS")
    public String getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }

    @Basic
    @Column(name = "DEVELOP_METHOD")
    public String getDevelopMethod() {
        return developMethod;
    }

    public void setDevelopMethod(String developMethod) {
        this.developMethod = developMethod;
    }

    @Basic
    @Column(name = "PALM_IMG_NOSQL_ID")
    public String getPalmImgNosqlId() {
        return palmImgNosqlId;
    }

    public void setPalmImgNosqlId(String palmImgNosqlId) {
        this.palmImgNosqlId = palmImgNosqlId;
    }

    @Basic
    @Column(name = "PALM_CPR_NOSQL_ID")
    public String getPalmCprNosqlId() {
        return palmCprNosqlId;
    }

    public void setPalmCprNosqlId(String palmCprNosqlId) {
        this.palmCprNosqlId = palmCprNosqlId;
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
    @Column(name = "MNT_COUNT")
    public Long getMntCount() {
        return mntCount;
    }

    public void setMntCount(Long mntCount) {
        this.mntCount = mntCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GafisCasePalmEntity that = (GafisCasePalmEntity) o;

        if (seqNo != null ? !seqNo.equals(that.seqNo) : that.seqNo != null) return false;
        if (palmId != null ? !palmId.equals(that.palmId) : that.palmId != null) return false;
        if (caseId != null ? !caseId.equals(that.caseId) : that.caseId != null) return false;
        if (isCorpse != null ? !isCorpse.equals(that.isCorpse) : that.isCorpse != null) return false;
        if (corpseNo != null ? !corpseNo.equals(that.corpseNo) : that.corpseNo != null) return false;
        if (remainPlace != null ? !remainPlace.equals(that.remainPlace) : that.remainPlace != null) return false;
        if (fgp != null ? !fgp.equals(that.fgp) : that.fgp != null) return false;
        if (pattern != null ? !pattern.equals(that.pattern) : that.pattern != null) return false;
        if (ridgeColor != null ? !ridgeColor.equals(that.ridgeColor) : that.ridgeColor != null) return false;
        if (thanStatus != null ? !thanStatus.equals(that.thanStatus) : that.thanStatus != null) return false;
        if (isAssist != null ? !isAssist.equals(that.isAssist) : that.isAssist != null) return false;
        if (!Arrays.equals(palmImg, that.palmImg)) return false;
        if (!Arrays.equals(palmCpr, that.palmCpr)) return false;
        if (ltCount != null ? !ltCount.equals(that.ltCount) : that.ltCount != null) return false;
        if (llCount != null ? !llCount.equals(that.llCount) : that.llCount != null) return false;
        if (ltCountModMnt != null ? !ltCountModMnt.equals(that.ltCountModMnt) : that.ltCountModMnt != null)
            return false;
        if (llCountModMnt != null ? !llCountModMnt.equals(that.llCountModMnt) : that.llCountModMnt != null)
            return false;
        if (editCount != null ? !editCount.equals(that.editCount) : that.editCount != null) return false;
        if (ltDate != null ? !ltDate.equals(that.ltDate) : that.ltDate != null) return false;
        if (llDate != null ? !llDate.equals(that.llDate) : that.llDate != null) return false;
        if (ltOperator != null ? !ltOperator.equals(that.ltOperator) : that.ltOperator != null) return false;
        if (llOperator != null ? !llOperator.equals(that.llOperator) : that.llOperator != null) return false;
        if (creatorUnitCode != null ? !creatorUnitCode.equals(that.creatorUnitCode) : that.creatorUnitCode != null)
            return false;
        if (updatorUnitCode != null ? !updatorUnitCode.equals(that.updatorUnitCode) : that.updatorUnitCode != null)
            return false;
        if (modifiedtime != null ? !modifiedtime.equals(that.modifiedtime) : that.modifiedtime != null) return false;
        if (modifiedpsn != null ? !modifiedpsn.equals(that.modifiedpsn) : that.modifiedpsn != null) return false;
        if (inputtime != null ? !inputtime.equals(that.inputtime) : that.inputtime != null) return false;
        if (inputpsn != null ? !inputpsn.equals(that.inputpsn) : that.inputpsn != null) return false;
        if (deletag != null ? !deletag.equals(that.deletag) : that.deletag != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (ltStatus != null ? !ltStatus.equals(that.ltStatus) : that.ltStatus != null) return false;
        if (llStatus != null ? !llStatus.equals(that.llStatus) : that.llStatus != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (matchStatus != null ? !matchStatus.equals(that.matchStatus) : that.matchStatus != null) return false;
        if (developMethod != null ? !developMethod.equals(that.developMethod) : that.developMethod != null)
            return false;
        if (palmImgNosqlId != null ? !palmImgNosqlId.equals(that.palmImgNosqlId) : that.palmImgNosqlId != null)
            return false;
        if (palmCprNosqlId != null ? !palmCprNosqlId.equals(that.palmCprNosqlId) : that.palmCprNosqlId != null)
            return false;
        if (seq != null ? !seq.equals(that.seq) : that.seq != null) return false;
        if (mntCount != null ? !mntCount.equals(that.mntCount) : that.mntCount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = seqNo != null ? seqNo.hashCode() : 0;
        result = 31 * result + (palmId != null ? palmId.hashCode() : 0);
        result = 31 * result + (caseId != null ? caseId.hashCode() : 0);
        result = 31 * result + (isCorpse != null ? isCorpse.hashCode() : 0);
        result = 31 * result + (corpseNo != null ? corpseNo.hashCode() : 0);
        result = 31 * result + (remainPlace != null ? remainPlace.hashCode() : 0);
        result = 31 * result + (fgp != null ? fgp.hashCode() : 0);
        result = 31 * result + (pattern != null ? pattern.hashCode() : 0);
        result = 31 * result + (ridgeColor != null ? ridgeColor.hashCode() : 0);
        result = 31 * result + (thanStatus != null ? thanStatus.hashCode() : 0);
        result = 31 * result + (isAssist != null ? isAssist.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(palmImg);
        result = 31 * result + Arrays.hashCode(palmCpr);
        result = 31 * result + (ltCount != null ? ltCount.hashCode() : 0);
        result = 31 * result + (llCount != null ? llCount.hashCode() : 0);
        result = 31 * result + (ltCountModMnt != null ? ltCountModMnt.hashCode() : 0);
        result = 31 * result + (llCountModMnt != null ? llCountModMnt.hashCode() : 0);
        result = 31 * result + (editCount != null ? editCount.hashCode() : 0);
        result = 31 * result + (ltDate != null ? ltDate.hashCode() : 0);
        result = 31 * result + (llDate != null ? llDate.hashCode() : 0);
        result = 31 * result + (ltOperator != null ? ltOperator.hashCode() : 0);
        result = 31 * result + (llOperator != null ? llOperator.hashCode() : 0);
        result = 31 * result + (creatorUnitCode != null ? creatorUnitCode.hashCode() : 0);
        result = 31 * result + (updatorUnitCode != null ? updatorUnitCode.hashCode() : 0);
        result = 31 * result + (modifiedtime != null ? modifiedtime.hashCode() : 0);
        result = 31 * result + (modifiedpsn != null ? modifiedpsn.hashCode() : 0);
        result = 31 * result + (inputtime != null ? inputtime.hashCode() : 0);
        result = 31 * result + (inputpsn != null ? inputpsn.hashCode() : 0);
        result = 31 * result + (deletag != null ? deletag.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (ltStatus != null ? ltStatus.hashCode() : 0);
        result = 31 * result + (llStatus != null ? llStatus.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (matchStatus != null ? matchStatus.hashCode() : 0);
        result = 31 * result + (developMethod != null ? developMethod.hashCode() : 0);
        result = 31 * result + (palmImgNosqlId != null ? palmImgNosqlId.hashCode() : 0);
        result = 31 * result + (palmCprNosqlId != null ? palmCprNosqlId.hashCode() : 0);
        result = 31 * result + (seq != null ? seq.hashCode() : 0);
        result = 31 * result + (mntCount != null ? mntCount.hashCode() : 0);
        return result;
    }
}
