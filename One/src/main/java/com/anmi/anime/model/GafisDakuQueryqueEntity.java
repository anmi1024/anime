package com.anmi.anime.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * Created by wangjue on 2017/10/19.
 */
@Entity
@Table(name = "GAFIS_DAKU_QUERYQUE")
public class GafisDakuQueryqueEntity {
    private String pkid;
    private String filename;
    private Long total;
    private Long statues;
    private Date beginTime;
    private Date finishTime;
    private Long orasidStart;
    private Long orasidEnd;
    private Long querytype;
    private Long priority;
    private Long maxcandnum;
    private Long minscore;
    private String description;
    private String textsql;
    private String queryCandListDir;
    private Long threshold;
    private Long matchStatues;

    private Long recordNumMatched;
    private Date matchBeginTime;
    private Date matchFinishTime;
    private Double algotithmQuerySpeed;

    @Id
    @Column(name = "PKID")
    public String getPkid() {
        return pkid;
    }

    public void setPkid(String pkid) {
        this.pkid = pkid;
    }

    @Basic
    @Column(name = "FILENAME")
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Basic
    @Column(name = "TOTAL")
    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Basic
    @Column(name = "STATUES")
    public Long getStatues() {
        return statues;
    }

    public void setStatues(Long statues) {
        this.statues = statues;
    }

    @Basic
    @Column(name = "BEGIN_TIME")
    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    @Basic
    @Column(name = "FINISH_TIME")
    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    @Basic
    @Column(name = "ORASID_START")
    public Long getOrasidStart() {
        return orasidStart;
    }

    public void setOrasidStart(Long orasidStart) {
        this.orasidStart = orasidStart;
    }

    @Basic
    @Column(name = "ORASID_END")
    public Long getOrasidEnd() {
        return orasidEnd;
    }

    public void setOrasidEnd(Long orasidEnd) {
        this.orasidEnd = orasidEnd;
    }

    @Basic
    @Column(name = "QUERYTYPE")
    public Long getQuerytype() {
        return querytype;
    }

    public void setQuerytype(Long querytype) {
        this.querytype = querytype;
    }

    @Basic
    @Column(name = "PRIORITY")
    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    @Basic
    @Column(name = "MAXCANDNUM")
    public Long getMaxcandnum() {
        return maxcandnum;
    }

    public void setMaxcandnum(Long maxcandnum) {
        this.maxcandnum = maxcandnum;
    }

    @Basic
    @Column(name = "MINSCORE")
    public Long getMinscore() {
        return minscore;
    }

    public void setMinscore(Long minscore) {
        this.minscore = minscore;
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
    @Column(name = "TEXTSQL")
    public String getTextsql() {
        return textsql;
    }

    public void setTextsql(String textsql) {
        this.textsql = textsql;
    }

    @Basic
    @Column(name = "QUERY_CANDLIST_DIR")
    public String getQueryCandListDir() {
        return queryCandListDir;
    }

    public void setQueryCandListDir(String queryCandListDir) {
        this.queryCandListDir = queryCandListDir;
    }

    @Basic
    @Column(name = "THRESHOLD")
    public Long getThreshold() {
        return threshold;
    }

    public void setThreshold(Long threshold) {
        this.threshold = threshold;
    }

    @Basic
    @Column(name = "MATCH_STATUES")
    public Long getMatchStatues() {
        return matchStatues;
    }

    public void setMatchStatues(Long matchStatues) {
        this.matchStatues = matchStatues;
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
    @Column(name = "MATCH_BEGIN_TIME")
    public Date getMatchBeginTime() {
        return matchBeginTime;
    }

    public void setMatchBeginTime(Date matchBeginTime) {
        this.matchBeginTime = matchBeginTime;
    }

    @Basic
    @Column(name = "MATCH_FINISH_TIME")
    public Date getMatchFinishTime() {
        return matchFinishTime;
    }

    public void setMatchFinishTime(Date matchFinishTime) {
        this.matchFinishTime = matchFinishTime;
    }

    @Basic
    @Column(name = "ALGOTITHM_QUERY_SPEED")
    public Double getAlgotithmQuerySpeed() {
        return algotithmQuerySpeed;
    }

    public void setAlgotithmQuerySpeed(Double algotithmQuerySpeed) {
        this.algotithmQuerySpeed = algotithmQuerySpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GafisDakuQueryqueEntity that = (GafisDakuQueryqueEntity) o;

        if (pkid != null ? !pkid.equals(that.pkid) : that.pkid != null) return false;
        if (filename != null ? !filename.equals(that.filename) : that.filename != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (statues != null ? !statues.equals(that.statues) : that.statues != null) return false;
        if (beginTime != null ? !beginTime.equals(that.beginTime) : that.beginTime != null) return false;
        if (finishTime != null ? !finishTime.equals(that.finishTime) : that.finishTime != null) return false;
        if (orasidStart != null ? !orasidStart.equals(that.orasidStart) : that.orasidStart != null) return false;
        if (orasidEnd != null ? !orasidEnd.equals(that.orasidEnd) : that.orasidEnd != null) return false;
        if (querytype != null ? !querytype.equals(that.querytype) : that.querytype != null) return false;
        if (priority != null ? !priority.equals(that.priority) : that.priority != null) return false;
        if (maxcandnum != null ? !maxcandnum.equals(that.maxcandnum) : that.maxcandnum != null) return false;
        if (minscore != null ? !minscore.equals(that.minscore) : that.minscore != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (textsql != null ? !textsql.equals(that.textsql) : that.textsql != null) return false;
        if (queryCandListDir != null ? !queryCandListDir.equals(that.textsql) : that.queryCandListDir != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = pkid != null ? pkid.hashCode() : 0;
        result = 31 * result + (filename != null ? filename.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (statues != null ? statues.hashCode() : 0);
        result = 31 * result + (beginTime != null ? beginTime.hashCode() : 0);
        result = 31 * result + (finishTime != null ? finishTime.hashCode() : 0);
        result = 31 * result + (orasidStart != null ? orasidStart.hashCode() : 0);
        result = 31 * result + (orasidEnd != null ? orasidEnd.hashCode() : 0);
        result = 31 * result + (querytype != null ? querytype.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (maxcandnum != null ? maxcandnum.hashCode() : 0);
        result = 31 * result + (minscore != null ? minscore.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (textsql != null ? textsql.hashCode() : 0);
        return result;
    }
}
