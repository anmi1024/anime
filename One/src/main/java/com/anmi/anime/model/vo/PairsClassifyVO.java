package com.anmi.anime.model.vo;

import java.util.List;

/**
 * Created by wangjue on 2017/12/7.
 */
public class PairsClassifyVO {
    private Integer page = 1;           //当前页
    private Integer size = 10;           //每页总数
    private String pairType;     //类型
    private Integer mntCount;    //特征点个数
    private Integer mntCountLess;    //特征点个数(小于)
    private Integer imgqlev;     //图像评分
    private Integer imgqlevLess;     //图像评分(小于)
    private Integer rpqlev;      //特征评分
    private Integer rpqlevLess;      //特征评分(小于)
    private Integer coreqlev;    //中心可靠度
    private Integer coreqlevLess;    //中心可靠度(小于)
    private Integer vcoreqlev;   //副中心可靠度
    private Integer vcoreqlevLess;   //副中心可靠度(小于)
    private Integer ldeltaqlev;  //左三角可靠度
    private Integer ldeltaqlevLess;  //左三角可靠度(小于)
    private Integer rdeltaqlev;  //右三角可靠度
    private Integer rdeltaqlevLess;  //右三角可靠度(小于)

    private List<String> sendKeys;

    private Integer rank;           //排名
    private Integer score;          //得分
    private Integer index;          //比中指位

    public String getPairType() {
        return pairType;
    }

    public void setPairType(String pairType) {
        this.pairType = pairType;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getMntCount() {
        return mntCount;
    }

    public void setMntCount(Integer mntCount) {
        this.mntCount = mntCount;
    }

    public Integer getImgqlev() {
        return imgqlev;
    }

    public void setImgqlev(Integer imgqlev) {
        this.imgqlev = imgqlev;
    }

    public Integer getRpqlev() {
        return rpqlev;
    }

    public void setRpqlev(Integer rpqlev) {
        this.rpqlev = rpqlev;
    }

    public Integer getCoreqlev() {
        return coreqlev;
    }

    public void setCoreqlev(Integer coreqlev) {
        this.coreqlev = coreqlev;
    }

    public Integer getVcoreqlev() {
        return vcoreqlev;
    }

    public void setVcoreqlev(Integer vcoreqlev) {
        this.vcoreqlev = vcoreqlev;
    }

    public Integer getLdeltaqlev() {
        return ldeltaqlev;
    }

    public void setLdeltaqlev(Integer ldeltaqlev) {
        this.ldeltaqlev = ldeltaqlev;
    }

    public Integer getRdeltaqlev() {
        return rdeltaqlev;
    }

    public void setRdeltaqlev(Integer rdeltaqlev) {
        this.rdeltaqlev = rdeltaqlev;
    }

    public Integer getMntCountLess() {
        return mntCountLess;
    }

    public void setMntCountLess(Integer mntCountLess) {
        this.mntCountLess = mntCountLess;
    }

    public Integer getImgqlevLess() {
        return imgqlevLess;
    }

    public void setImgqlevLess(Integer imgqlevLess) {
        this.imgqlevLess = imgqlevLess;
    }

    public Integer getRpqlevLess() {
        return rpqlevLess;
    }

    public void setRpqlevLess(Integer rpqlevLess) {
        this.rpqlevLess = rpqlevLess;
    }

    public Integer getCoreqlevLess() {
        return coreqlevLess;
    }

    public void setCoreqlevLess(Integer coreqlevLess) {
        this.coreqlevLess = coreqlevLess;
    }

    public Integer getVcoreqlevLess() {
        return vcoreqlevLess;
    }

    public void setVcoreqlevLess(Integer vcoreqlevLess) {
        this.vcoreqlevLess = vcoreqlevLess;
    }

    public Integer getLdeltaqlevLess() {
        return ldeltaqlevLess;
    }

    public void setLdeltaqlevLess(Integer ldeltaqlevLess) {
        this.ldeltaqlevLess = ldeltaqlevLess;
    }

    public Integer getRdeltaqlevLess() {
        return rdeltaqlevLess;
    }

    public void setRdeltaqlevLess(Integer rdeltaqlevLess) {
        this.rdeltaqlevLess = rdeltaqlevLess;
    }

    public List<String> getSendKeys() {
        return sendKeys;
    }

    public void setSendKeys(List<String> sendKeys) {
        this.sendKeys = sendKeys;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
