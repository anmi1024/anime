package com.anmi.anime.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by wangjue on 2017/9/7.
 */
@Entity
@Table(name = "GAFIS_CHECKIN_INFO")
@DynamicInsert()
@DynamicUpdate()
public class GafisCheckinInfoEntity {
    private String pkId;
    private String code;
    private String tcode;
    private Boolean querytype;
    private Time registerTime;
    private String registerUser;
    private String registerOrg;
    private Byte hitpossibility;
    private Byte priority;
    private Long reviewStatus;
    private Boolean reviewBout;
    private Boolean appealStatus;
    private Byte confirmStatus;
    private String confirmUser;
    private Time confirmTime;
    private String queryUuid;
    private String reviewOrg;
    private Long rank;
    private Long fraction;
    private String fgp;
    private String confirmOpinion;
    private Long cardType1;
    private Long cardType2;
    private Time lastHandleDate;
    private Long operatetype;
    private String ckSource;
    private Boolean passStatus;

    @Id
    @Column(name = "PK_ID")
    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    @Basic
    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "TCODE")
    public String getTcode() {
        return tcode;
    }

    public void setTcode(String tcode) {
        this.tcode = tcode;
    }

    @Basic
    @Column(name = "QUERYTYPE")
    public Boolean getQuerytype() {
        return querytype;
    }

    public void setQuerytype(Boolean querytype) {
        this.querytype = querytype;
    }

    @Basic
    @Column(name = "REGISTER_TIME")
    public Time getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Time registerTime) {
        this.registerTime = registerTime;
    }

    @Basic
    @Column(name = "REGISTER_USER")
    public String getRegisterUser() {
        return registerUser;
    }

    public void setRegisterUser(String registerUser) {
        this.registerUser = registerUser;
    }

    @Basic
    @Column(name = "REGISTER_ORG")
    public String getRegisterOrg() {
        return registerOrg;
    }

    public void setRegisterOrg(String registerOrg) {
        this.registerOrg = registerOrg;
    }

    @Basic
    @Column(name = "HITPOSSIBILITY")
    public Byte getHitpossibility() {
        return hitpossibility;
    }

    public void setHitpossibility(Byte hitpossibility) {
        this.hitpossibility = hitpossibility;
    }

    @Basic
    @Column(name = "PRIORITY")
    public Byte getPriority() {
        return priority;
    }

    public void setPriority(Byte priority) {
        this.priority = priority;
    }

    @Basic
    @Column(name = "REVIEW_STATUS")
    public Long getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(Long reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    @Basic
    @Column(name = "REVIEW_BOUT")
    public Boolean getReviewBout() {
        return reviewBout;
    }

    public void setReviewBout(Boolean reviewBout) {
        this.reviewBout = reviewBout;
    }

    @Basic
    @Column(name = "APPEAL_STATUS")
    public Boolean getAppealStatus() {
        return appealStatus;
    }

    public void setAppealStatus(Boolean appealStatus) {
        this.appealStatus = appealStatus;
    }

    @Basic
    @Column(name = "CONFIRM_STATUS")
    public Byte getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(Byte confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    @Basic
    @Column(name = "CONFIRM_USER")
    public String getConfirmUser() {
        return confirmUser;
    }

    public void setConfirmUser(String confirmUser) {
        this.confirmUser = confirmUser;
    }

    @Basic
    @Column(name = "CONFIRM_TIME")
    public Time getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Time confirmTime) {
        this.confirmTime = confirmTime;
    }

    @Basic
    @Column(name = "QUERY_UUID")
    public String getQueryUuid() {
        return queryUuid;
    }

    public void setQueryUuid(String queryUuid) {
        this.queryUuid = queryUuid;
    }

    @Basic
    @Column(name = "REVIEW_ORG")
    public String getReviewOrg() {
        return reviewOrg;
    }

    public void setReviewOrg(String reviewOrg) {
        this.reviewOrg = reviewOrg;
    }

    @Basic
    @Column(name = "RANK")
    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    @Basic
    @Column(name = "FRACTION")
    public Long getFraction() {
        return fraction;
    }

    public void setFraction(Long fraction) {
        this.fraction = fraction;
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
    @Column(name = "CONFIRM_OPINION")
    public String getConfirmOpinion() {
        return confirmOpinion;
    }

    public void setConfirmOpinion(String confirmOpinion) {
        this.confirmOpinion = confirmOpinion;
    }

    @Basic
    @Column(name = "CARD_TYPE1")
    public Long getCardType1() {
        return cardType1;
    }

    public void setCardType1(Long cardType1) {
        this.cardType1 = cardType1;
    }

    @Basic
    @Column(name = "CARD_TYPE2")
    public Long getCardType2() {
        return cardType2;
    }

    public void setCardType2(Long cardType2) {
        this.cardType2 = cardType2;
    }

    @Basic
    @Column(name = "LAST_HANDLE_DATE")
    public Time getLastHandleDate() {
        return lastHandleDate;
    }

    public void setLastHandleDate(Time lastHandleDate) {
        this.lastHandleDate = lastHandleDate;
    }

    @Basic
    @Column(name = "OPERATETYPE")
    public Long getOperatetype() {
        return operatetype;
    }

    public void setOperatetype(Long operatetype) {
        this.operatetype = operatetype;
    }

    @Basic
    @Column(name = "CK_SOURCE")
    public String getCkSource() {
        return ckSource;
    }

    public void setCkSource(String ckSource) {
        this.ckSource = ckSource;
    }

    @Basic
    @Column(name = "PASS_STATUS")
    public Boolean getPassStatus() {
        return passStatus;
    }

    public void setPassStatus(Boolean passStatus) {
        this.passStatus = passStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GafisCheckinInfoEntity that = (GafisCheckinInfoEntity) o;

        if (pkId != null ? !pkId.equals(that.pkId) : that.pkId != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (tcode != null ? !tcode.equals(that.tcode) : that.tcode != null) return false;
        if (querytype != null ? !querytype.equals(that.querytype) : that.querytype != null) return false;
        if (registerTime != null ? !registerTime.equals(that.registerTime) : that.registerTime != null) return false;
        if (registerUser != null ? !registerUser.equals(that.registerUser) : that.registerUser != null) return false;
        if (registerOrg != null ? !registerOrg.equals(that.registerOrg) : that.registerOrg != null) return false;
        if (hitpossibility != null ? !hitpossibility.equals(that.hitpossibility) : that.hitpossibility != null)
            return false;
        if (priority != null ? !priority.equals(that.priority) : that.priority != null) return false;
        if (reviewStatus != null ? !reviewStatus.equals(that.reviewStatus) : that.reviewStatus != null) return false;
        if (reviewBout != null ? !reviewBout.equals(that.reviewBout) : that.reviewBout != null) return false;
        if (appealStatus != null ? !appealStatus.equals(that.appealStatus) : that.appealStatus != null) return false;
        if (confirmStatus != null ? !confirmStatus.equals(that.confirmStatus) : that.confirmStatus != null)
            return false;
        if (confirmUser != null ? !confirmUser.equals(that.confirmUser) : that.confirmUser != null) return false;
        if (confirmTime != null ? !confirmTime.equals(that.confirmTime) : that.confirmTime != null) return false;
        if (queryUuid != null ? !queryUuid.equals(that.queryUuid) : that.queryUuid != null) return false;
        if (reviewOrg != null ? !reviewOrg.equals(that.reviewOrg) : that.reviewOrg != null) return false;
        if (rank != null ? !rank.equals(that.rank) : that.rank != null) return false;
        if (fraction != null ? !fraction.equals(that.fraction) : that.fraction != null) return false;
        if (fgp != null ? !fgp.equals(that.fgp) : that.fgp != null) return false;
        if (confirmOpinion != null ? !confirmOpinion.equals(that.confirmOpinion) : that.confirmOpinion != null)
            return false;
        if (cardType1 != null ? !cardType1.equals(that.cardType1) : that.cardType1 != null) return false;
        if (cardType2 != null ? !cardType2.equals(that.cardType2) : that.cardType2 != null) return false;
        if (lastHandleDate != null ? !lastHandleDate.equals(that.lastHandleDate) : that.lastHandleDate != null)
            return false;
        if (operatetype != null ? !operatetype.equals(that.operatetype) : that.operatetype != null) return false;
        if (ckSource != null ? !ckSource.equals(that.ckSource) : that.ckSource != null) return false;
        if (passStatus != null ? !passStatus.equals(that.passStatus) : that.passStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pkId != null ? pkId.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (tcode != null ? tcode.hashCode() : 0);
        result = 31 * result + (querytype != null ? querytype.hashCode() : 0);
        result = 31 * result + (registerTime != null ? registerTime.hashCode() : 0);
        result = 31 * result + (registerUser != null ? registerUser.hashCode() : 0);
        result = 31 * result + (registerOrg != null ? registerOrg.hashCode() : 0);
        result = 31 * result + (hitpossibility != null ? hitpossibility.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (reviewStatus != null ? reviewStatus.hashCode() : 0);
        result = 31 * result + (reviewBout != null ? reviewBout.hashCode() : 0);
        result = 31 * result + (appealStatus != null ? appealStatus.hashCode() : 0);
        result = 31 * result + (confirmStatus != null ? confirmStatus.hashCode() : 0);
        result = 31 * result + (confirmUser != null ? confirmUser.hashCode() : 0);
        result = 31 * result + (confirmTime != null ? confirmTime.hashCode() : 0);
        result = 31 * result + (queryUuid != null ? queryUuid.hashCode() : 0);
        result = 31 * result + (reviewOrg != null ? reviewOrg.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + (fraction != null ? fraction.hashCode() : 0);
        result = 31 * result + (fgp != null ? fgp.hashCode() : 0);
        result = 31 * result + (confirmOpinion != null ? confirmOpinion.hashCode() : 0);
        result = 31 * result + (cardType1 != null ? cardType1.hashCode() : 0);
        result = 31 * result + (cardType2 != null ? cardType2.hashCode() : 0);
        result = 31 * result + (lastHandleDate != null ? lastHandleDate.hashCode() : 0);
        result = 31 * result + (operatetype != null ? operatetype.hashCode() : 0);
        result = 31 * result + (ckSource != null ? ckSource.hashCode() : 0);
        result = 31 * result + (passStatus != null ? passStatus.hashCode() : 0);
        return result;
    }
}
