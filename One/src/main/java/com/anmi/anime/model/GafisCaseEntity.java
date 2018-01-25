package com.anmi.anime.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * Created by wangjue on 2017/9/7.
 */
@Entity
@Table(name = "GAFIS_CASE")
@DynamicInsert()
@DynamicUpdate()
public class GafisCaseEntity {
    private String caseId;
    private String cardId;
    private String caseClassCode;
    private Date caseOccurDate;
    private String caseOccurPlaceCode;
    private String caseOccurPlaceDetail;
    private String caseBriefDetail;
    private String isMurder;
    private String amount;
    private String extractUnitCode;
    private String extractUnitName;
    private Date extractDate;
    private String extractor;
    private String suspiciousAreaCode;
    private String caseState;
    private String caseNature;
    private String remark;
    private String inputpsn;
    private Date inputtime;
    private String modifiedpsn;
    private Date modifiedtime;
    private String deletag;
    private Byte brokenStatus;
    private String caseSource;
    private String createUnitCode;
    private String assistLevel;
    private String caseNatureOld;
    private String isChecked;
    private String fptExtractUnitCode;
    private String fptExtractUnitName;
    private Long sid;
    private String assistBonus;
    private String assistDeptCode;
    private String assistDeptName;
    private String assistDate;
    private String assistSign;
    private String assistRevokeSign;
    private String csNo;
    private String psisNo;

    @Id
    @Column(name = "CASE_ID")
    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    @Basic
    @Column(name = "CARD_ID")
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Basic
    @Column(name = "CASE_CLASS_CODE")
    public String getCaseClassCode() {
        return caseClassCode;
    }

    public void setCaseClassCode(String caseClassCode) {
        this.caseClassCode = caseClassCode;
    }

    @Basic
    @Column(name = "CASE_OCCUR_DATE")
    public Date getCaseOccurDate() {
        return caseOccurDate;
    }

    public void setCaseOccurDate(Date caseOccurDate) {
        this.caseOccurDate = caseOccurDate;
    }

    @Basic
    @Column(name = "CASE_OCCUR_PLACE_CODE")
    public String getCaseOccurPlaceCode() {
        return caseOccurPlaceCode;
    }

    public void setCaseOccurPlaceCode(String caseOccurPlaceCode) {
        this.caseOccurPlaceCode = caseOccurPlaceCode;
    }

    @Basic
    @Column(name = "CASE_OCCUR_PLACE_DETAIL")
    public String getCaseOccurPlaceDetail() {
        return caseOccurPlaceDetail;
    }

    public void setCaseOccurPlaceDetail(String caseOccurPlaceDetail) {
        this.caseOccurPlaceDetail = caseOccurPlaceDetail;
    }

    @Basic
    @Column(name = "CASE_BRIEF_DETAIL")
    public String getCaseBriefDetail() {
        return caseBriefDetail;
    }

    public void setCaseBriefDetail(String caseBriefDetail) {
        this.caseBriefDetail = caseBriefDetail;
    }

    @Basic
    @Column(name = "IS_MURDER")
    public String getIsMurder() {
        return isMurder;
    }

    public void setIsMurder(String isMurder) {
        this.isMurder = isMurder;
    }

    @Basic
    @Column(name = "AMOUNT")
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "EXTRACT_UNIT_CODE")
    public String getExtractUnitCode() {
        return extractUnitCode;
    }

    public void setExtractUnitCode(String extractUnitCode) {
        this.extractUnitCode = extractUnitCode;
    }

    @Basic
    @Column(name = "EXTRACT_UNIT_NAME")
    public String getExtractUnitName() {
        return extractUnitName;
    }

    public void setExtractUnitName(String extractUnitName) {
        this.extractUnitName = extractUnitName;
    }

    @Basic
    @Column(name = "EXTRACT_DATE")
    public Date getExtractDate() {
        return extractDate;
    }

    public void setExtractDate(Date extractDate) {
        this.extractDate = extractDate;
    }

    @Basic
    @Column(name = "EXTRACTOR")
    public String getExtractor() {
        return extractor;
    }

    public void setExtractor(String extractor) {
        this.extractor = extractor;
    }

    @Basic
    @Column(name = "SUSPICIOUS_AREA_CODE")
    public String getSuspiciousAreaCode() {
        return suspiciousAreaCode;
    }

    public void setSuspiciousAreaCode(String suspiciousAreaCode) {
        this.suspiciousAreaCode = suspiciousAreaCode;
    }

    @Basic
    @Column(name = "CASE_STATE")
    public String getCaseState() {
        return caseState;
    }

    public void setCaseState(String caseState) {
        this.caseState = caseState;
    }

    @Basic
    @Column(name = "CASE_NATURE")
    public String getCaseNature() {
        return caseNature;
    }

    public void setCaseNature(String caseNature) {
        this.caseNature = caseNature;
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
    @Column(name = "DELETAG")
    public String getDeletag() {
        return deletag;
    }

    public void setDeletag(String deletag) {
        this.deletag = deletag;
    }

    @Basic
    @Column(name = "BROKEN_STATUS")
    public Byte getBrokenStatus() {
        return brokenStatus;
    }

    public void setBrokenStatus(Byte brokenStatus) {
        this.brokenStatus = brokenStatus;
    }

    @Basic
    @Column(name = "CASE_SOURCE")
    public String getCaseSource() {
        return caseSource;
    }

    public void setCaseSource(String caseSource) {
        this.caseSource = caseSource;
    }

    @Basic
    @Column(name = "CREATE_UNIT_CODE")
    public String getCreateUnitCode() {
        return createUnitCode;
    }

    public void setCreateUnitCode(String createUnitCode) {
        this.createUnitCode = createUnitCode;
    }

    @Basic
    @Column(name = "ASSIST_LEVEL")
    public String getAssistLevel() {
        return assistLevel;
    }

    public void setAssistLevel(String assistLevel) {
        this.assistLevel = assistLevel;
    }

    @Basic
    @Column(name = "CASE_NATURE_OLD")
    public String getCaseNatureOld() {
        return caseNatureOld;
    }

    public void setCaseNatureOld(String caseNatureOld) {
        this.caseNatureOld = caseNatureOld;
    }

    @Basic
    @Column(name = "IS_CHECKED")
    public String getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(String isChecked) {
        this.isChecked = isChecked;
    }

    @Basic
    @Column(name = "FPT_EXTRACT_UNIT_CODE")
    public String getFptExtractUnitCode() {
        return fptExtractUnitCode;
    }

    public void setFptExtractUnitCode(String fptExtractUnitCode) {
        this.fptExtractUnitCode = fptExtractUnitCode;
    }

    @Basic
    @Column(name = "FPT_EXTRACT_UNIT_NAME")
    public String getFptExtractUnitName() {
        return fptExtractUnitName;
    }

    public void setFptExtractUnitName(String fptExtractUnitName) {
        this.fptExtractUnitName = fptExtractUnitName;
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
    @Column(name = "ASSIST_BONUS")
    public String getAssistBonus() {
        return assistBonus;
    }

    public void setAssistBonus(String assistBonus) {
        this.assistBonus = assistBonus;
    }

    @Basic
    @Column(name = "ASSIST_DEPT_CODE")
    public String getAssistDeptCode() {
        return assistDeptCode;
    }

    public void setAssistDeptCode(String assistDeptCode) {
        this.assistDeptCode = assistDeptCode;
    }

    @Basic
    @Column(name = "ASSIST_DEPT_NAME")
    public String getAssistDeptName() {
        return assistDeptName;
    }

    public void setAssistDeptName(String assistDeptName) {
        this.assistDeptName = assistDeptName;
    }

    @Basic
    @Column(name = "ASSIST_DATE")
    public String getAssistDate() {
        return assistDate;
    }

    public void setAssistDate(String assistDate) {
        this.assistDate = assistDate;
    }

    @Basic
    @Column(name = "ASSIST_SIGN")
    public String getAssistSign() {
        return assistSign;
    }

    public void setAssistSign(String assistSign) {
        this.assistSign = assistSign;
    }

    @Basic
    @Column(name = "ASSIST_REVOKE_SIGN")
    public String getAssistRevokeSign() {
        return assistRevokeSign;
    }

    public void setAssistRevokeSign(String assistRevokeSign) {
        this.assistRevokeSign = assistRevokeSign;
    }

    @Basic
    @Column(name = "CS_NO")
    public String getCsNo() {
        return csNo;
    }

    public void setCsNo(String csNo) {
        this.csNo = csNo;
    }

    @Basic
    @Column(name = "PSIS_NO")
    public String getPsisNo() {
        return psisNo;
    }

    public void setPsisNo(String psisNo) {
        this.psisNo = psisNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GafisCaseEntity that = (GafisCaseEntity) o;

        if (caseId != null ? !caseId.equals(that.caseId) : that.caseId != null) return false;
        if (cardId != null ? !cardId.equals(that.cardId) : that.cardId != null) return false;
        if (caseClassCode != null ? !caseClassCode.equals(that.caseClassCode) : that.caseClassCode != null)
            return false;
        if (caseOccurDate != null ? !caseOccurDate.equals(that.caseOccurDate) : that.caseOccurDate != null)
            return false;
        if (caseOccurPlaceCode != null ? !caseOccurPlaceCode.equals(that.caseOccurPlaceCode) : that.caseOccurPlaceCode != null)
            return false;
        if (caseOccurPlaceDetail != null ? !caseOccurPlaceDetail.equals(that.caseOccurPlaceDetail) : that.caseOccurPlaceDetail != null)
            return false;
        if (caseBriefDetail != null ? !caseBriefDetail.equals(that.caseBriefDetail) : that.caseBriefDetail != null)
            return false;
        if (isMurder != null ? !isMurder.equals(that.isMurder) : that.isMurder != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (extractUnitCode != null ? !extractUnitCode.equals(that.extractUnitCode) : that.extractUnitCode != null)
            return false;
        if (extractUnitName != null ? !extractUnitName.equals(that.extractUnitName) : that.extractUnitName != null)
            return false;
        if (extractDate != null ? !extractDate.equals(that.extractDate) : that.extractDate != null) return false;
        if (extractor != null ? !extractor.equals(that.extractor) : that.extractor != null) return false;
        if (suspiciousAreaCode != null ? !suspiciousAreaCode.equals(that.suspiciousAreaCode) : that.suspiciousAreaCode != null)
            return false;
        if (caseState != null ? !caseState.equals(that.caseState) : that.caseState != null) return false;
        if (caseNature != null ? !caseNature.equals(that.caseNature) : that.caseNature != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (inputpsn != null ? !inputpsn.equals(that.inputpsn) : that.inputpsn != null) return false;
        if (inputtime != null ? !inputtime.equals(that.inputtime) : that.inputtime != null) return false;
        if (modifiedpsn != null ? !modifiedpsn.equals(that.modifiedpsn) : that.modifiedpsn != null) return false;
        if (modifiedtime != null ? !modifiedtime.equals(that.modifiedtime) : that.modifiedtime != null) return false;
        if (deletag != null ? !deletag.equals(that.deletag) : that.deletag != null) return false;
        if (brokenStatus != null ? !brokenStatus.equals(that.brokenStatus) : that.brokenStatus != null) return false;
        if (caseSource != null ? !caseSource.equals(that.caseSource) : that.caseSource != null) return false;
        if (createUnitCode != null ? !createUnitCode.equals(that.createUnitCode) : that.createUnitCode != null)
            return false;
        if (assistLevel != null ? !assistLevel.equals(that.assistLevel) : that.assistLevel != null) return false;
        if (caseNatureOld != null ? !caseNatureOld.equals(that.caseNatureOld) : that.caseNatureOld != null)
            return false;
        if (isChecked != null ? !isChecked.equals(that.isChecked) : that.isChecked != null) return false;
        if (fptExtractUnitCode != null ? !fptExtractUnitCode.equals(that.fptExtractUnitCode) : that.fptExtractUnitCode != null)
            return false;
        if (fptExtractUnitName != null ? !fptExtractUnitName.equals(that.fptExtractUnitName) : that.fptExtractUnitName != null)
            return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (assistBonus != null ? !assistBonus.equals(that.assistBonus) : that.assistBonus != null) return false;
        if (assistDeptCode != null ? !assistDeptCode.equals(that.assistDeptCode) : that.assistDeptCode != null)
            return false;
        if (assistDeptName != null ? !assistDeptName.equals(that.assistDeptName) : that.assistDeptName != null)
            return false;
        if (assistDate != null ? !assistDate.equals(that.assistDate) : that.assistDate != null) return false;
        if (assistSign != null ? !assistSign.equals(that.assistSign) : that.assistSign != null) return false;
        if (assistRevokeSign != null ? !assistRevokeSign.equals(that.assistRevokeSign) : that.assistRevokeSign != null)
            return false;
        if (csNo != null ? !csNo.equals(that.csNo) : that.csNo != null) return false;
        if (psisNo != null ? !psisNo.equals(that.psisNo) : that.psisNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = caseId != null ? caseId.hashCode() : 0;
        result = 31 * result + (cardId != null ? cardId.hashCode() : 0);
        result = 31 * result + (caseClassCode != null ? caseClassCode.hashCode() : 0);
        result = 31 * result + (caseOccurDate != null ? caseOccurDate.hashCode() : 0);
        result = 31 * result + (caseOccurPlaceCode != null ? caseOccurPlaceCode.hashCode() : 0);
        result = 31 * result + (caseOccurPlaceDetail != null ? caseOccurPlaceDetail.hashCode() : 0);
        result = 31 * result + (caseBriefDetail != null ? caseBriefDetail.hashCode() : 0);
        result = 31 * result + (isMurder != null ? isMurder.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (extractUnitCode != null ? extractUnitCode.hashCode() : 0);
        result = 31 * result + (extractUnitName != null ? extractUnitName.hashCode() : 0);
        result = 31 * result + (extractDate != null ? extractDate.hashCode() : 0);
        result = 31 * result + (extractor != null ? extractor.hashCode() : 0);
        result = 31 * result + (suspiciousAreaCode != null ? suspiciousAreaCode.hashCode() : 0);
        result = 31 * result + (caseState != null ? caseState.hashCode() : 0);
        result = 31 * result + (caseNature != null ? caseNature.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (inputpsn != null ? inputpsn.hashCode() : 0);
        result = 31 * result + (inputtime != null ? inputtime.hashCode() : 0);
        result = 31 * result + (modifiedpsn != null ? modifiedpsn.hashCode() : 0);
        result = 31 * result + (modifiedtime != null ? modifiedtime.hashCode() : 0);
        result = 31 * result + (deletag != null ? deletag.hashCode() : 0);
        result = 31 * result + (brokenStatus != null ? brokenStatus.hashCode() : 0);
        result = 31 * result + (caseSource != null ? caseSource.hashCode() : 0);
        result = 31 * result + (createUnitCode != null ? createUnitCode.hashCode() : 0);
        result = 31 * result + (assistLevel != null ? assistLevel.hashCode() : 0);
        result = 31 * result + (caseNatureOld != null ? caseNatureOld.hashCode() : 0);
        result = 31 * result + (isChecked != null ? isChecked.hashCode() : 0);
        result = 31 * result + (fptExtractUnitCode != null ? fptExtractUnitCode.hashCode() : 0);
        result = 31 * result + (fptExtractUnitName != null ? fptExtractUnitName.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (assistBonus != null ? assistBonus.hashCode() : 0);
        result = 31 * result + (assistDeptCode != null ? assistDeptCode.hashCode() : 0);
        result = 31 * result + (assistDeptName != null ? assistDeptName.hashCode() : 0);
        result = 31 * result + (assistDate != null ? assistDate.hashCode() : 0);
        result = 31 * result + (assistSign != null ? assistSign.hashCode() : 0);
        result = 31 * result + (assistRevokeSign != null ? assistRevokeSign.hashCode() : 0);
        result = 31 * result + (csNo != null ? csNo.hashCode() : 0);
        result = 31 * result + (psisNo != null ? psisNo.hashCode() : 0);
        return result;
    }
}
