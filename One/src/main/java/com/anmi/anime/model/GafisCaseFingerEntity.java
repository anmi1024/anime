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
@Table(name = "GAFIS_CASE_FINGER")
@DynamicInsert()
@DynamicUpdate()
public class GafisCaseFingerEntity {
    private String seqNo;
    private String fingerId;
    private String caseId;
    private String isCorpse;
    private String corpseNo;
    private String remainPlace;
    private Byte fgpGroup;
    private String fgp;
    private String ridgeColor;
    private String pattern;
    private String mittensBegNo;
    private String mittensEndNo;
    private String thanStatus;
    private String isAssist;
    private byte[] fingerImg;
    private byte[] fingerCpr;
    private Long ltCount;
    private Long llCount;
    private Long ltCountModMnt;
    private Long llCountModMnt;
    private Long editCount;
    private Date ltDate;
    private Date llDate;
    private String llOperator;
    private String ltStatus;
    private String llStatus;
    private String creatorUnitCode;
    private String updatorUnitCode;
    private Date modifiedtime;
    private String modifiedpsn;
    private Date inputtime;
    private String inputpsn;
    private String deletag;
    private String remark;
    private Long sid;
    private String matchStatus;
    private String developMethod;
    private String fingerCprNosqlId;
    private String fingerImgNosqlId;
    private Long seq;
    private Long mntCount;
    private String dataIn;
    private String dataMatcher;
    private String fptPath;

    @Basic
    @Column(name = "SEQ_NO")
    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    @Id
    @Column(name = "FINGER_ID")
    public String getFingerId() {
        return fingerId;
    }

    public void setFingerId(String fingerId) {
        this.fingerId = fingerId;
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
    @Column(name = "FGP_GROUP")
    public Byte getFgpGroup() {
        return fgpGroup;
    }

    public void setFgpGroup(Byte fgpGroup) {
        this.fgpGroup = fgpGroup;
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
    @Column(name = "RIDGE_COLOR")
    public String getRidgeColor() {
        return ridgeColor;
    }

    public void setRidgeColor(String ridgeColor) {
        this.ridgeColor = ridgeColor;
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
    @Column(name = "MITTENS_BEG_NO")
    public String getMittensBegNo() {
        return mittensBegNo;
    }

    public void setMittensBegNo(String mittensBegNo) {
        this.mittensBegNo = mittensBegNo;
    }

    @Basic
    @Column(name = "MITTENS_END_NO")
    public String getMittensEndNo() {
        return mittensEndNo;
    }

    public void setMittensEndNo(String mittensEndNo) {
        this.mittensEndNo = mittensEndNo;
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
    @Column(name = "FINGER_IMG")
    public byte[] getFingerImg() {
        return fingerImg;
    }

    public void setFingerImg(byte[] fingerImg) {
        this.fingerImg = fingerImg;
    }

    @Basic
    @Column(name = "FINGER_CPR")
    public byte[] getFingerCpr() {
        return fingerCpr;
    }

    public void setFingerCpr(byte[] fingerCpr) {
        this.fingerCpr = fingerCpr;
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
    public Date getLtDate() {
        return ltDate;
    }

    public void setLtDate(Date ltDate) {
        this.ltDate = ltDate;
    }

    @Basic
    @Column(name = "LL_DATE")
    public Date getLlDate() {
        return llDate;
    }

    public void setLlDate(Date llDate) {
        this.llDate = llDate;
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
    @Column(name = "REMARK")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
    @Column(name = "FINGER_CPR_NOSQL_ID")
    public String getFingerCprNosqlId() {
        return fingerCprNosqlId;
    }

    public void setFingerCprNosqlId(String fingerCprNosqlId) {
        this.fingerCprNosqlId = fingerCprNosqlId;
    }

    @Basic
    @Column(name = "FINGER_IMG_NOSQL_ID")
    public String getFingerImgNosqlId() {
        return fingerImgNosqlId;
    }

    public void setFingerImgNosqlId(String fingerImgNosqlId) {
        this.fingerImgNosqlId = fingerImgNosqlId;
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

    @Basic
    @Column(name = "DATA_IN")
    public String getDataIn() {
        return dataIn;
    }

    public void setDataIn(String dataIn) {
        this.dataIn = dataIn;
    }

    @Basic
    @Column(name = "DATA_MATCHER")
    public String getDataMatcher() {
        return dataMatcher;
    }

    public void setDataMatcher(String dataMatcher) {
        this.dataMatcher = dataMatcher;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GafisCaseFingerEntity that = (GafisCaseFingerEntity) o;

        if (seqNo != null ? !seqNo.equals(that.seqNo) : that.seqNo != null) return false;
        if (fingerId != null ? !fingerId.equals(that.fingerId) : that.fingerId != null) return false;
        if (caseId != null ? !caseId.equals(that.caseId) : that.caseId != null) return false;
        if (isCorpse != null ? !isCorpse.equals(that.isCorpse) : that.isCorpse != null) return false;
        if (corpseNo != null ? !corpseNo.equals(that.corpseNo) : that.corpseNo != null) return false;
        if (remainPlace != null ? !remainPlace.equals(that.remainPlace) : that.remainPlace != null) return false;
        if (fgpGroup != null ? !fgpGroup.equals(that.fgpGroup) : that.fgpGroup != null) return false;
        if (fgp != null ? !fgp.equals(that.fgp) : that.fgp != null) return false;
        if (ridgeColor != null ? !ridgeColor.equals(that.ridgeColor) : that.ridgeColor != null) return false;
        if (pattern != null ? !pattern.equals(that.pattern) : that.pattern != null) return false;
        if (mittensBegNo != null ? !mittensBegNo.equals(that.mittensBegNo) : that.mittensBegNo != null) return false;
        if (mittensEndNo != null ? !mittensEndNo.equals(that.mittensEndNo) : that.mittensEndNo != null) return false;
        if (thanStatus != null ? !thanStatus.equals(that.thanStatus) : that.thanStatus != null) return false;
        if (isAssist != null ? !isAssist.equals(that.isAssist) : that.isAssist != null) return false;
        if (!Arrays.equals(fingerImg, that.fingerImg)) return false;
        if (!Arrays.equals(fingerCpr, that.fingerCpr)) return false;
        if (ltCount != null ? !ltCount.equals(that.ltCount) : that.ltCount != null) return false;
        if (llCount != null ? !llCount.equals(that.llCount) : that.llCount != null) return false;
        if (ltCountModMnt != null ? !ltCountModMnt.equals(that.ltCountModMnt) : that.ltCountModMnt != null)
            return false;
        if (llCountModMnt != null ? !llCountModMnt.equals(that.llCountModMnt) : that.llCountModMnt != null)
            return false;
        if (editCount != null ? !editCount.equals(that.editCount) : that.editCount != null) return false;
        if (ltDate != null ? !ltDate.equals(that.ltDate) : that.ltDate != null) return false;
        if (llDate != null ? !llDate.equals(that.llDate) : that.llDate != null) return false;
        if (llOperator != null ? !llOperator.equals(that.llOperator) : that.llOperator != null) return false;
        if (ltStatus != null ? !ltStatus.equals(that.ltStatus) : that.ltStatus != null) return false;
        if (llStatus != null ? !llStatus.equals(that.llStatus) : that.llStatus != null) return false;
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
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (matchStatus != null ? !matchStatus.equals(that.matchStatus) : that.matchStatus != null) return false;
        if (developMethod != null ? !developMethod.equals(that.developMethod) : that.developMethod != null)
            return false;
        if (fingerCprNosqlId != null ? !fingerCprNosqlId.equals(that.fingerCprNosqlId) : that.fingerCprNosqlId != null)
            return false;
        if (fingerImgNosqlId != null ? !fingerImgNosqlId.equals(that.fingerImgNosqlId) : that.fingerImgNosqlId != null)
            return false;
        if (seq != null ? !seq.equals(that.seq) : that.seq != null) return false;
        if (mntCount != null ? !mntCount.equals(that.mntCount) : that.mntCount != null) return false;
        if (dataIn != null ? !dataIn.equals(that.dataIn) : that.dataIn != null) return false;
        if (dataMatcher != null ? !dataMatcher.equals(that.dataMatcher) : that.dataMatcher != null) return false;
        if (fptPath != null ? !fptPath.equals(that.fptPath) : that.fptPath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = seqNo != null ? seqNo.hashCode() : 0;
        result = 31 * result + (fingerId != null ? fingerId.hashCode() : 0);
        result = 31 * result + (caseId != null ? caseId.hashCode() : 0);
        result = 31 * result + (isCorpse != null ? isCorpse.hashCode() : 0);
        result = 31 * result + (corpseNo != null ? corpseNo.hashCode() : 0);
        result = 31 * result + (remainPlace != null ? remainPlace.hashCode() : 0);
        result = 31 * result + (fgpGroup != null ? fgpGroup.hashCode() : 0);
        result = 31 * result + (fgp != null ? fgp.hashCode() : 0);
        result = 31 * result + (ridgeColor != null ? ridgeColor.hashCode() : 0);
        result = 31 * result + (pattern != null ? pattern.hashCode() : 0);
        result = 31 * result + (mittensBegNo != null ? mittensBegNo.hashCode() : 0);
        result = 31 * result + (mittensEndNo != null ? mittensEndNo.hashCode() : 0);
        result = 31 * result + (thanStatus != null ? thanStatus.hashCode() : 0);
        result = 31 * result + (isAssist != null ? isAssist.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(fingerImg);
        result = 31 * result + Arrays.hashCode(fingerCpr);
        result = 31 * result + (ltCount != null ? ltCount.hashCode() : 0);
        result = 31 * result + (llCount != null ? llCount.hashCode() : 0);
        result = 31 * result + (ltCountModMnt != null ? ltCountModMnt.hashCode() : 0);
        result = 31 * result + (llCountModMnt != null ? llCountModMnt.hashCode() : 0);
        result = 31 * result + (editCount != null ? editCount.hashCode() : 0);
        result = 31 * result + (ltDate != null ? ltDate.hashCode() : 0);
        result = 31 * result + (llDate != null ? llDate.hashCode() : 0);
        result = 31 * result + (llOperator != null ? llOperator.hashCode() : 0);
        result = 31 * result + (ltStatus != null ? ltStatus.hashCode() : 0);
        result = 31 * result + (llStatus != null ? llStatus.hashCode() : 0);
        result = 31 * result + (creatorUnitCode != null ? creatorUnitCode.hashCode() : 0);
        result = 31 * result + (updatorUnitCode != null ? updatorUnitCode.hashCode() : 0);
        result = 31 * result + (modifiedtime != null ? modifiedtime.hashCode() : 0);
        result = 31 * result + (modifiedpsn != null ? modifiedpsn.hashCode() : 0);
        result = 31 * result + (inputtime != null ? inputtime.hashCode() : 0);
        result = 31 * result + (inputpsn != null ? inputpsn.hashCode() : 0);
        result = 31 * result + (deletag != null ? deletag.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (matchStatus != null ? matchStatus.hashCode() : 0);
        result = 31 * result + (developMethod != null ? developMethod.hashCode() : 0);
        result = 31 * result + (fingerCprNosqlId != null ? fingerCprNosqlId.hashCode() : 0);
        result = 31 * result + (fingerImgNosqlId != null ? fingerImgNosqlId.hashCode() : 0);
        result = 31 * result + (seq != null ? seq.hashCode() : 0);
        result = 31 * result + (mntCount != null ? mntCount.hashCode() : 0);
        result = 31 * result + (dataIn != null ? dataIn.hashCode() : 0);
        result = 31 * result + (dataMatcher != null ? dataMatcher.hashCode() : 0);
        result = 31 * result + (fptPath != null ? fptPath.hashCode() : 0);
        return result;
    }
}
