package com.anmi.anime.model.vo;

import java.util.List;
import java.util.Map;

/**
 * Created by wangjue on 2017/11/6.
 */
public class AnalyzeVO {
    private long queryType;                 //任务分析类型
    private long total;                     //任务总数
    private long matchCount;                //比中总数
    private List<AnalyzeResultVO> matchList;         //比中列表
    private String matchFilePath;           //比中列表文件路径
    private long missCount;                 //错比总数
    private List<String> missList;          //错比列表
    private String missFilePath;            //错比列表文件路径
    private long lostCount;                 //漏比总数
    private List<String> lostList;          //漏比列表
    private String lostFilePath;            //漏比列表文件路径
    private Map<Integer,String> rankMap;   //排名分布
    private Map<Double,String> scoreMap;   //得分分布
    private Map<String,String> theTopRate;//排前率


    public long getQueryType() {
        return queryType;
    }

    public void setQueryType(long queryType) {
        this.queryType = queryType;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(long matchCount) {
        this.matchCount = matchCount;
    }

    public long getMissCount() {
        return missCount;
    }

    public void setMissCount(long missCount) {
        this.missCount = missCount;
    }

    public List<String> getMissList() {
        return missList;
    }

    public void setMissList(List<String> missList) {
        this.missList = missList;
    }

    public long getLostCount() {
        return lostCount;
    }

    public void setLostCount(long lostCount) {
        this.lostCount = lostCount;
    }

    public List<String> getLostList() {
        return lostList;
    }

    public void setLostList(List<String> lostList) {
        this.lostList = lostList;
    }

    public List<AnalyzeResultVO> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<AnalyzeResultVO> matchList) {
        this.matchList = matchList;
    }

    public Map<Integer, String> getRankMap() {
        return rankMap;
    }

    public void setRankMap(Map<Integer, String> rankMap) {
        this.rankMap = rankMap;
    }

    public Map<Double, String> getScoreMap() {
        return scoreMap;
    }

    public void setScoreMap(Map<Double, String> scoreMap) {
        this.scoreMap = scoreMap;
    }

    public Map<String, String> getTheTopRate() {
        return theTopRate;
    }

    public void setTheTopRate(Map<String, String> theTopRate) {
        this.theTopRate = theTopRate;
    }

    public String getMatchFilePath() {
        return matchFilePath;
    }

    public void setMatchFilePath(String matchFilePath) {
        this.matchFilePath = matchFilePath;
    }

    public String getMissFilePath() {
        return missFilePath;
    }

    public void setMissFilePath(String missFilePath) {
        this.missFilePath = missFilePath;
    }

    public String getLostFilePath() {
        return lostFilePath;
    }

    public void setLostFilePath(String lostFilePath) {
        this.lostFilePath = lostFilePath;
    }
}
