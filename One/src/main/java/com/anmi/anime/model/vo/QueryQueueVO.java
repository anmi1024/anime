package com.anmi.anime.model.vo;

import java.util.List;

/**
 * Created by wangjue on 2017/9/14.
 */
public class QueryQueueVO {
    private List<String> keyId;
    private Integer queryType;  //比对类型
    private Integer priority = 3;   //比对优先级
    private String unitcode = "310000000000";    //发送单位
    private Integer minCandNum; //最小候选个数
    private Integer maxCandNum = 50; //最大候选个数
    private Integer minScore = 0;   //最小分数
    private Integer maxScore;   //最大分数
    private String rollIndex;
    private String flatIndex;
    private Integer flag = 129;//查询标记(掌纹查询:2;滚动指纹查询:1;平面指纹查询:128;滚动指纹+平面指纹查询:129)
    private String textSql;//文本查询条件
    private String description; //描述
    private String fileName; //文件名
    private Integer validKeyType;
    private Integer oraSidS;
    private Integer oraSidE;
    private Integer candMinScore;
    private Integer candMaxScore;
    private String matchResultSavePath;
    private Integer threshold; //TT比对阀值



    public QueryQueueVO() {
    }

    public QueryQueueVO(List<String> keyId, Integer queryType) {
        this.keyId = keyId;
        this.queryType = queryType;
    }

    public QueryQueueVO(List<String> keyId, Integer queryType, Integer priority, String unitcode) {
        this.keyId = keyId;
        this.queryType = queryType;
        this.priority = priority;
        this.unitcode = unitcode;
    }

    public List<String> getKeyId() {
        return keyId;
    }

    public void setKeyId(List<String> keyId) {
        this.keyId = keyId;
    }

    public Integer getQueryType() {
        return queryType;
    }

    public void setQueryType(Integer queryType) {
        this.queryType = queryType;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }

    public Integer getMinCandNum() {
        return minCandNum;
    }

    public void setMinCandNum(Integer minCandNum) {
        this.minCandNum = minCandNum;
    }

    public Integer getMaxCandNum() {
        return maxCandNum;
    }

    public void setMaxCandNum(Integer maxCandNum) {
        this.maxCandNum = maxCandNum;
    }

    public String getRollIndex() {
        return rollIndex;
    }

    public void setRollIndex(String rollIndex) {
        this.rollIndex = rollIndex;
    }

    public String getFlatIndex() {
        return flatIndex;
    }

    public void setFlatIndex(String flatIndex) {
        this.flatIndex = flatIndex;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getTextSql() {
        return textSql;
    }

    public void setTextSql(String textSql) {
        this.textSql = textSql;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getMinScore() {
        return minScore;
    }

    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }

    public Integer getOraSidS() {
        return oraSidS;
    }

    public void setOraSidS(Integer oraSidS) {
        this.oraSidS = oraSidS;
    }

    public Integer getOraSidE() {
        return oraSidE;
    }

    public void setOraSidE(Integer oraSidE) {
        this.oraSidE = oraSidE;
    }

    public Integer getCandMinScore() {
        return candMinScore;
    }

    public void setCandMinScore(Integer candMinScore) {
        this.candMinScore = candMinScore;
    }

    public Integer getCandMaxScore() {
        return candMaxScore;
    }

    public void setCandMaxScore(Integer candMaxScore) {
        this.candMaxScore = candMaxScore;
    }

    public String getMatchResultSavePath() {
        return matchResultSavePath;
    }

    public void setMatchResultSavePath(String matchResultSavePath) {
        this.matchResultSavePath = matchResultSavePath;
    }

    public Integer getValidKeyType() {
        return validKeyType;
    }

    public void setValidKeyType(Integer validKeyType) {
        this.validKeyType = validKeyType;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

}
