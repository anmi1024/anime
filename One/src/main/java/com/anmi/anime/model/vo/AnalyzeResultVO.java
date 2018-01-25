package com.anmi.anime.model.vo;

/**
 * Created by wangjue on 2017/11/9.
 */
public class AnalyzeResultVO {

    private String queryKey;
    private String matchKey;
    private Integer matchKeyFgp;
    private Integer rank;
    private Double score;

    public AnalyzeResultVO(String queryKey, String matchKey) {
        this.queryKey = queryKey;
        this.matchKey = matchKey;
    }

    public AnalyzeResultVO(String queryKey, String matchKey, Double score) {
        this.queryKey = queryKey;
        this.matchKey = matchKey;
        this.score = score;
    }

    public AnalyzeResultVO(String queryKey, String matchKey, Integer matchKeyFgp, Integer rank, Double score) {
        this.queryKey = queryKey;
        this.matchKey = matchKey;
        this.matchKeyFgp = matchKeyFgp;
        this.rank = rank;
        this.score = score;
    }

    public String getQueryKey() {
        return queryKey;
    }

    public void setQueryKey(String queryKey) {
        this.queryKey = queryKey;
    }

    public String getMatchKey() {
        return matchKey;
    }

    public void setMatchKey(String matchKey) {
        this.matchKey = matchKey;
    }

    public Integer getMatchKeyFgp() {
        return matchKeyFgp;
    }

    public void setMatchKeyFgp(Integer matchKeyFgp) {
        this.matchKeyFgp = matchKeyFgp;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
