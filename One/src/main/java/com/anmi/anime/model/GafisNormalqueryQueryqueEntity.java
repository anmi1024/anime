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
@Table(name = "GAFIS_NORMALQUERY_QUERYQUE")
@DynamicInsert()
@DynamicUpdate()
public class GafisNormalqueryQueryqueEntity {
    private String pkId;
    private Integer oraSid;
    private String keyid;
    private Integer querytype;
    private Integer status;
    private Integer priority;
    private Integer hitpossibility;
    private Integer verifyresult;
    private Integer flag;
    private Integer flagc;
    private Integer flagd;
    private Integer flage;
    private Integer flagg;
    private byte[] qrycondition;
    private byte[] mic;
    private String textsql;
    private byte[] candhead;
    private byte[] candlist;
    private Integer timeused;
    private Integer maxcandnum;
    private Integer curcandnum;
    private Integer minscore;
    private String startkey1;
    private String endkey1;
    private String startkey2;
    private String endkey2;
    private String username;
    private String userunitcode;
    private Date finishtime;
    private String computerip;
    private String computername;
    private String oracomment;
    private Long maxscore;
    private Date createtime;
    private Date begintime;
    private String deletag;
    private String userid;
    private String submittsystem;
    private Integer prioritynew;
    private Integer handleresult;
    private String qryconditionNosqlId;
    private String micNosqlId;
    private String candheadNosqlId;
    private String candlistNosqlId;
    private Long timeElapsed;
    private Long recordNumMatched;
    private Integer matchProgress;
    private String syncTargetSid;
    private Boolean overtimetag;
    private Boolean messagetag;
    private String isReport;
    private String gzzlbh;
    private Date reportTime;

    @Id
    @Column(name = "PK_ID")
    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    @Basic
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence")
    @SequenceGenerator(name="sequence", sequenceName="SEQ_ORASID", allocationSize=1)
    @Column(name = "ORA_SID")
    public Integer getOraSid() {
        return oraSid;
    }

    public void setOraSid(Integer oraSid) {
        this.oraSid = oraSid;
    }

    @Basic
    @Column(name = "KEYID")
    public String getKeyid() {
        return keyid;
    }

    public void setKeyid(String keyid) {
        this.keyid = keyid;
    }

    @Basic
    @Column(name = "QUERYTYPE")
    public Integer getQuerytype() {
        return querytype;
    }

    public void setQuerytype(Integer querytype) {
        this.querytype = querytype;
    }

    @Basic
    @Column(name = "STATUS")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "PRIORITY")
    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Basic
    @Column(name = "HITPOSSIBILITY")
    public Integer getHitpossibility() {
        return hitpossibility;
    }

    public void setHitpossibility(Integer hitpossibility) {
        this.hitpossibility = hitpossibility;
    }

    @Basic
    @Column(name = "VERIFYRESULT")
    public Integer getVerifyresult() {
        return verifyresult;
    }

    public void setVerifyresult(Integer verifyresult) {
        this.verifyresult = verifyresult;
    }

    @Basic
    @Column(name = "FLAG")
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "FLAGC")
    public Integer getFlagc() {
        return flagc;
    }

    public void setFlagc(Integer flagc) {
        this.flagc = flagc;
    }

    @Basic
    @Column(name = "FLAGD")
    public Integer getFlagd() {
        return flagd;
    }

    public void setFlagd(Integer flagd) {
        this.flagd = flagd;
    }

    @Basic
    @Column(name = "FLAGE")
    public Integer getFlage() {
        return flage;
    }

    public void setFlage(Integer flage) {
        this.flage = flage;
    }

    @Basic
    @Column(name = "FLAGG")
    public Integer getFlagg() {
        return flagg;
    }

    public void setFlagg(Integer flagg) {
        this.flagg = flagg;
    }

    @Basic
    @Column(name = "QRYCONDITION")
    public byte[] getQrycondition() {
        return qrycondition;
    }

    public void setQrycondition(byte[] qrycondition) {
        this.qrycondition = qrycondition;
    }

    @Basic
    @Column(name = "MIC")
    public byte[] getMic() {
        return mic;
    }

    public void setMic(byte[] mic) {
        this.mic = mic;
    }

    @Basic
    @Column(name = "TEXTSQL")
    public String getTextsql() {
        return textsql;
    }

    public void setTextsql(String textsql) {
        this.textsql = textsql;
    }

    @Basic
    @Column(name = "CANDHEAD")
    public byte[] getCandhead() {
        return candhead;
    }

    public void setCandhead(byte[] candhead) {
        this.candhead = candhead;
    }

    @Basic
    @Column(name = "CANDLIST")
    public byte[] getCandlist() {
        return candlist;
    }

    public void setCandlist(byte[] candlist) {
        this.candlist = candlist;
    }

    @Basic
    @Column(name = "TIMEUSED")
    public Integer getTimeused() {
        return timeused;
    }

    public void setTimeused(Integer timeused) {
        this.timeused = timeused;
    }

    @Basic
    @Column(name = "MAXCANDNUM")
    public Integer getMaxcandnum() {
        return maxcandnum;
    }

    public void setMaxcandnum(Integer maxcandnum) {
        this.maxcandnum = maxcandnum;
    }

    @Basic
    @Column(name = "CURCANDNUM")
    public Integer getCurcandnum() {
        return curcandnum;
    }

    public void setCurcandnum(Integer curcandnum) {
        this.curcandnum = curcandnum;
    }

    @Basic
    @Column(name = "MINSCORE")
    public Integer getMinscore() {
        return minscore;
    }

    public void setMinscore(Integer minscore) {
        this.minscore = minscore;
    }

    @Basic
    @Column(name = "STARTKEY1")
    public String getStartkey1() {
        return startkey1;
    }

    public void setStartkey1(String startkey1) {
        this.startkey1 = startkey1;
    }

    @Basic
    @Column(name = "ENDKEY1")
    public String getEndkey1() {
        return endkey1;
    }

    public void setEndkey1(String endkey1) {
        this.endkey1 = endkey1;
    }

    @Basic
    @Column(name = "STARTKEY2")
    public String getStartkey2() {
        return startkey2;
    }

    public void setStartkey2(String startkey2) {
        this.startkey2 = startkey2;
    }

    @Basic
    @Column(name = "ENDKEY2")
    public String getEndkey2() {
        return endkey2;
    }

    public void setEndkey2(String endkey2) {
        this.endkey2 = endkey2;
    }

    @Basic
    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "USERUNITCODE")
    public String getUserunitcode() {
        return userunitcode;
    }

    public void setUserunitcode(String userunitcode) {
        this.userunitcode = userunitcode;
    }

    @Basic
    @Column(name = "FINISHTIME")
    public Date getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Date finishtime) {
        this.finishtime = finishtime;
    }

    @Basic
    @Column(name = "COMPUTERIP")
    public String getComputerip() {
        return computerip;
    }

    public void setComputerip(String computerip) {
        this.computerip = computerip;
    }

    @Basic
    @Column(name = "COMPUTERNAME")
    public String getComputername() {
        return computername;
    }

    public void setComputername(String computername) {
        this.computername = computername;
    }

    @Basic
    @Column(name = "ORACOMMENT")
    public String getOracomment() {
        return oracomment;
    }

    public void setOracomment(String oracomment) {
        this.oracomment = oracomment;
    }

    @Basic
    @Column(name = "MAXSCORE")
    public Long getMaxscore() {
        return maxscore;
    }

    public void setMaxscore(Long maxscore) {
        this.maxscore = maxscore;
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
    @Column(name = "BEGINTIME")
    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
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
    @Column(name = "USERID")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "SUBMITTSYSTEM")
    public String getSubmittsystem() {
        return submittsystem;
    }

    public void setSubmittsystem(String submittsystem) {
        this.submittsystem = submittsystem;
    }

    @Basic
    @Column(name = "PRIORITYNEW")
    public Integer getPrioritynew() {
        return prioritynew;
    }

    public void setPrioritynew(Integer prioritynew) {
        this.prioritynew = prioritynew;
    }

    @Basic
    @Column(name = "HANDLERESULT")
    public Integer getHandleresult() {
        return handleresult;
    }

    public void setHandleresult(Integer handleresult) {
        this.handleresult = handleresult;
    }

    @Basic
    @Column(name = "QRYCONDITION_NOSQL_ID")
    public String getQryconditionNosqlId() {
        return qryconditionNosqlId;
    }

    public void setQryconditionNosqlId(String qryconditionNosqlId) {
        this.qryconditionNosqlId = qryconditionNosqlId;
    }

    @Basic
    @Column(name = "MIC_NOSQL_ID")
    public String getMicNosqlId() {
        return micNosqlId;
    }

    public void setMicNosqlId(String micNosqlId) {
        this.micNosqlId = micNosqlId;
    }

    @Basic
    @Column(name = "CANDHEAD_NOSQL_ID")
    public String getCandheadNosqlId() {
        return candheadNosqlId;
    }

    public void setCandheadNosqlId(String candheadNosqlId) {
        this.candheadNosqlId = candheadNosqlId;
    }

    @Basic
    @Column(name = "CANDLIST_NOSQL_ID")
    public String getCandlistNosqlId() {
        return candlistNosqlId;
    }

    public void setCandlistNosqlId(String candlistNosqlId) {
        this.candlistNosqlId = candlistNosqlId;
    }

    @Basic
    @Column(name = "TIME_ELAPSED")
    public Long getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(Long timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    @Basic
    @Column(name = "RECORD_NUM_MATCHED")
    public Long getRecordNumMatched() {
        return recordNumMatched;
    }

    public void setRecordNumMatched(Long recordNumMatched) {
        this.recordNumMatched = recordNumMatched;
    }

    @Basic
    @Column(name = "MATCH_PROGRESS")
    public Integer getMatchProgress() {
        return matchProgress;
    }

    public void setMatchProgress(Integer matchProgress) {
        this.matchProgress = matchProgress;
    }

    @Basic
    @Column(name = "SYNC_TARGET_SID")
    public String getSyncTargetSid() {
        return syncTargetSid;
    }

    public void setSyncTargetSid(String syncTargetSid) {
        this.syncTargetSid = syncTargetSid;
    }

    @Basic
    @Column(name = "OVERTIMETAG")
    public Boolean getOvertimetag() {
        return overtimetag;
    }

    public void setOvertimetag(Boolean overtimetag) {
        this.overtimetag = overtimetag;
    }

    @Basic
    @Column(name = "MESSAGETAG")
    public Boolean getMessagetag() {
        return messagetag;
    }

    public void setMessagetag(Boolean messagetag) {
        this.messagetag = messagetag;
    }

    @Basic
    @Column(name = "IS_REPORT")
    public String getIsReport() {
        return isReport;
    }

    public void setIsReport(String isReport) {
        this.isReport = isReport;
    }

    @Basic
    @Column(name = "GZZLBH")
    public String getGzzlbh() {
        return gzzlbh;
    }

    public void setGzzlbh(String gzzlbh) {
        this.gzzlbh = gzzlbh;
    }

    @Basic
    @Column(name = "REPORT_TIME")
    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GafisNormalqueryQueryqueEntity that = (GafisNormalqueryQueryqueEntity) o;

        if (pkId != null ? !pkId.equals(that.pkId) : that.pkId != null) return false;
        if (oraSid != null ? !oraSid.equals(that.oraSid) : that.oraSid != null) return false;
        if (keyid != null ? !keyid.equals(that.keyid) : that.keyid != null) return false;
        if (querytype != null ? !querytype.equals(that.querytype) : that.querytype != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (priority != null ? !priority.equals(that.priority) : that.priority != null) return false;
        if (hitpossibility != null ? !hitpossibility.equals(that.hitpossibility) : that.hitpossibility != null)
            return false;
        if (verifyresult != null ? !verifyresult.equals(that.verifyresult) : that.verifyresult != null) return false;
        if (flag != null ? !flag.equals(that.flag) : that.flag != null) return false;
        if (flagc != null ? !flagc.equals(that.flagc) : that.flagc != null) return false;
        if (flagd != null ? !flagd.equals(that.flagd) : that.flagd != null) return false;
        if (flage != null ? !flage.equals(that.flage) : that.flage != null) return false;
        if (flagg != null ? !flagg.equals(that.flagg) : that.flagg != null) return false;
        if (!Arrays.equals(qrycondition, that.qrycondition)) return false;
        if (!Arrays.equals(mic, that.mic)) return false;
        if (textsql != null ? !textsql.equals(that.textsql) : that.textsql != null) return false;
        if (!Arrays.equals(candhead, that.candhead)) return false;
        if (!Arrays.equals(candlist, that.candlist)) return false;
        if (timeused != null ? !timeused.equals(that.timeused) : that.timeused != null) return false;
        if (maxcandnum != null ? !maxcandnum.equals(that.maxcandnum) : that.maxcandnum != null) return false;
        if (curcandnum != null ? !curcandnum.equals(that.curcandnum) : that.curcandnum != null) return false;
        if (minscore != null ? !minscore.equals(that.minscore) : that.minscore != null) return false;
        if (startkey1 != null ? !startkey1.equals(that.startkey1) : that.startkey1 != null) return false;
        if (endkey1 != null ? !endkey1.equals(that.endkey1) : that.endkey1 != null) return false;
        if (startkey2 != null ? !startkey2.equals(that.startkey2) : that.startkey2 != null) return false;
        if (endkey2 != null ? !endkey2.equals(that.endkey2) : that.endkey2 != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (userunitcode != null ? !userunitcode.equals(that.userunitcode) : that.userunitcode != null) return false;
        if (finishtime != null ? !finishtime.equals(that.finishtime) : that.finishtime != null) return false;
        if (computerip != null ? !computerip.equals(that.computerip) : that.computerip != null) return false;
        if (computername != null ? !computername.equals(that.computername) : that.computername != null) return false;
        if (oracomment != null ? !oracomment.equals(that.oracomment) : that.oracomment != null) return false;
        if (maxscore != null ? !maxscore.equals(that.maxscore) : that.maxscore != null) return false;
        if (createtime != null ? !createtime.equals(that.createtime) : that.createtime != null) return false;
        if (begintime != null ? !begintime.equals(that.begintime) : that.begintime != null) return false;
        if (deletag != null ? !deletag.equals(that.deletag) : that.deletag != null) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (submittsystem != null ? !submittsystem.equals(that.submittsystem) : that.submittsystem != null)
            return false;
        if (prioritynew != null ? !prioritynew.equals(that.prioritynew) : that.prioritynew != null) return false;
        if (handleresult != null ? !handleresult.equals(that.handleresult) : that.handleresult != null) return false;
        if (qryconditionNosqlId != null ? !qryconditionNosqlId.equals(that.qryconditionNosqlId) : that.qryconditionNosqlId != null)
            return false;
        if (micNosqlId != null ? !micNosqlId.equals(that.micNosqlId) : that.micNosqlId != null) return false;
        if (candheadNosqlId != null ? !candheadNosqlId.equals(that.candheadNosqlId) : that.candheadNosqlId != null)
            return false;
        if (candlistNosqlId != null ? !candlistNosqlId.equals(that.candlistNosqlId) : that.candlistNosqlId != null)
            return false;
        if (timeElapsed != null ? !timeElapsed.equals(that.timeElapsed) : that.timeElapsed != null) return false;
        if (recordNumMatched != null ? !recordNumMatched.equals(that.recordNumMatched) : that.recordNumMatched != null)
            return false;
        if (matchProgress != null ? !matchProgress.equals(that.matchProgress) : that.matchProgress != null)
            return false;
        if (syncTargetSid != null ? !syncTargetSid.equals(that.syncTargetSid) : that.syncTargetSid != null)
            return false;
        if (overtimetag != null ? !overtimetag.equals(that.overtimetag) : that.overtimetag != null) return false;
        if (messagetag != null ? !messagetag.equals(that.messagetag) : that.messagetag != null) return false;
        if (isReport != null ? !isReport.equals(that.isReport) : that.isReport != null) return false;
        if (gzzlbh != null ? !gzzlbh.equals(that.gzzlbh) : that.gzzlbh != null) return false;
        if (reportTime != null ? !reportTime.equals(that.reportTime) : that.reportTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pkId != null ? pkId.hashCode() : 0;
        result = 31 * result + (oraSid != null ? oraSid.hashCode() : 0);
        result = 31 * result + (keyid != null ? keyid.hashCode() : 0);
        result = 31 * result + (querytype != null ? querytype.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (hitpossibility != null ? hitpossibility.hashCode() : 0);
        result = 31 * result + (verifyresult != null ? verifyresult.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (flagc != null ? flagc.hashCode() : 0);
        result = 31 * result + (flagd != null ? flagd.hashCode() : 0);
        result = 31 * result + (flage != null ? flage.hashCode() : 0);
        result = 31 * result + (flagg != null ? flagg.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(qrycondition);
        result = 31 * result + Arrays.hashCode(mic);
        result = 31 * result + (textsql != null ? textsql.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(candhead);
        result = 31 * result + Arrays.hashCode(candlist);
        result = 31 * result + (timeused != null ? timeused.hashCode() : 0);
        result = 31 * result + (maxcandnum != null ? maxcandnum.hashCode() : 0);
        result = 31 * result + (curcandnum != null ? curcandnum.hashCode() : 0);
        result = 31 * result + (minscore != null ? minscore.hashCode() : 0);
        result = 31 * result + (startkey1 != null ? startkey1.hashCode() : 0);
        result = 31 * result + (endkey1 != null ? endkey1.hashCode() : 0);
        result = 31 * result + (startkey2 != null ? startkey2.hashCode() : 0);
        result = 31 * result + (endkey2 != null ? endkey2.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (userunitcode != null ? userunitcode.hashCode() : 0);
        result = 31 * result + (finishtime != null ? finishtime.hashCode() : 0);
        result = 31 * result + (computerip != null ? computerip.hashCode() : 0);
        result = 31 * result + (computername != null ? computername.hashCode() : 0);
        result = 31 * result + (oracomment != null ? oracomment.hashCode() : 0);
        result = 31 * result + (maxscore != null ? maxscore.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        result = 31 * result + (begintime != null ? begintime.hashCode() : 0);
        result = 31 * result + (deletag != null ? deletag.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (submittsystem != null ? submittsystem.hashCode() : 0);
        result = 31 * result + (prioritynew != null ? prioritynew.hashCode() : 0);
        result = 31 * result + (handleresult != null ? handleresult.hashCode() : 0);
        result = 31 * result + (qryconditionNosqlId != null ? qryconditionNosqlId.hashCode() : 0);
        result = 31 * result + (micNosqlId != null ? micNosqlId.hashCode() : 0);
        result = 31 * result + (candheadNosqlId != null ? candheadNosqlId.hashCode() : 0);
        result = 31 * result + (candlistNosqlId != null ? candlistNosqlId.hashCode() : 0);
        result = 31 * result + (timeElapsed != null ? timeElapsed.hashCode() : 0);
        result = 31 * result + (recordNumMatched != null ? recordNumMatched.hashCode() : 0);
        result = 31 * result + (matchProgress != null ? matchProgress.hashCode() : 0);
        result = 31 * result + (syncTargetSid != null ? syncTargetSid.hashCode() : 0);
        result = 31 * result + (overtimetag != null ? overtimetag.hashCode() : 0);
        result = 31 * result + (messagetag != null ? messagetag.hashCode() : 0);
        result = 31 * result + (isReport != null ? isReport.hashCode() : 0);
        result = 31 * result + (gzzlbh != null ? gzzlbh.hashCode() : 0);
        result = 31 * result + (reportTime != null ? reportTime.hashCode() : 0);
        return result;
    }
}
