package com.anmi.anime.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * Created by wangjue on 2017/12/7.
 */
@Entity
@Table(name = "GAFIS_DAKU_PAIRS_CLASSIFY")
public class GafisDakuPairsClassifyEntity {
    private String pkid;
    private String querykey;
    private String matchkey;
    private Long rank;
    private Long score;
    private Long matchindex;
    private String matchType;
    private Date createtime;
    private String description;

    @Id
    @Column(name = "PKID")
    public String getPkid() {
        return pkid;
    }

    public void setPkid(String pkid) {
        this.pkid = pkid;
    }

    @Basic
    @Column(name = "QUERYKEY")
    public String getQuerykey() {
        return querykey;
    }

    public void setQuerykey(String querykey) {
        this.querykey = querykey;
    }

    @Basic
    @Column(name = "MATCHKEY")
    public String getMatchkey() {
        return matchkey;
    }

    public void setMatchkey(String matchkey) {
        this.matchkey = matchkey;
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
    @Column(name = "SCORE")
    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    @Basic
    @Column(name = "MATCHINDEX")
    public Long getMatchindex() {
        return matchindex;
    }

    public void setMatchindex(Long matchindex) {
        this.matchindex = matchindex;
    }

    @Basic
    @Column(name = "MATCHTYPE")
    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
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
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GafisDakuPairsClassifyEntity that = (GafisDakuPairsClassifyEntity) o;

        if (pkid != null ? !pkid.equals(that.pkid) : that.pkid != null) return false;
        if (querykey != null ? !querykey.equals(that.querykey) : that.querykey != null) return false;
        if (matchkey != null ? !matchkey.equals(that.matchkey) : that.matchkey != null) return false;
        if (rank != null ? !rank.equals(that.rank) : that.rank != null) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;
        if (matchindex != null ? !matchindex.equals(that.matchindex) : that.matchindex != null) return false;
        if (matchType != null ? !matchType.equals(that.matchType) : that.matchType != null) return false;
        if (createtime != null ? !createtime.equals(that.createtime) : that.createtime != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pkid != null ? pkid.hashCode() : 0;
        result = 31 * result + (querykey != null ? querykey.hashCode() : 0);
        result = 31 * result + (matchkey != null ? matchkey.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (matchindex != null ? matchindex.hashCode() : 0);
        result = 31 * result + (matchType != null ? matchType.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
