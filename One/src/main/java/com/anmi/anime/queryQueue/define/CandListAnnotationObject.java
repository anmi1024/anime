package com.anmi.anime.queryQueue.define;



import com.anmi.anime.annotation.CutLength;
import com.anmi.anime.queryQueue.struct.CandListStruct;
import com.anmi.anime.utils.AFISDateTime;

import java.util.List;

/**
 * Created by wangjue on 2017/6/21.
 */
public class CandListAnnotationObject extends CandListStruct {
    @CutLength(len = 4)
    private int cbSize;
    @CutLength(offset = 4,len = 4)
    private int nScore;                     //得分
    @CutLength(offset = 8,len = 32)
    private String szKey;                   //编号
    @CutLength(offset = 40,len = 2)
    private short nServerID;
    @CutLength(offset = 42,len = 2)
    private short nDBID;
    @CutLength(offset = 44,len = 2)
    private short nTableID;
    @CutLength(offset = 46,len = 2)
    private short nFileID;
    @CutLength(offset = 48,len = 1)
    private byte checkState;                //比中状态
    @CutLength(offset = 49,len = 3)
    private int bnRes_nRID;
    @CutLength(offset = 52,len = 1)
    private byte nStatus;
    @CutLength(offset = 53,len = 1)
    private byte nGetCandFailCnt;
    @CutLength(offset = 54,len = 1)
    private byte bIsDataCached;
    @CutLength(offset = 55,len = 1)
    private byte nTxPassedCount;
    @CutLength(offset = 56,len = 1)
    private byte nIndex;                    //指位
    @CutLength(offset = 57,len = 1)
    private byte nFlag;
    @CutLength(offset = 58,len = 2)
    private short nFinalServerID;
    @CutLength(offset = 60,len = 1)
    private byte nSrcKeyIndex;              //对应发送卡号的序号
    @CutLength(offset = 61,len = 1)
    private byte nMatchAlgorithm;
    @CutLength(offset = 62,len = 1)
    private byte nGroupid;
    @CutLength(offset = 63,len = 1)
    private byte nDupCardCnt;
    @CutLength(offset = 64,len = 8)
    private AFISDateTime finishTime;        //完成时间
    @CutLength(offset = 72,len = 2)
    private short nServerDBID;
    @CutLength(offset = 74,len = 2)
    private short nServerTableID;
    @CutLength(offset = 76,len = 2)
    private short nXgwRank;
    @CutLength(offset = 78,len = 2)
    private short nWsgRank;
    @CutLength(offset = 80,len = 6)
    private long nSID;
    @CutLength(offset = 86,len = 2)
    private short bnRes_SID;
    @CutLength(offset = 88,len = 2)
    private short nStepOneScore;
    @CutLength(offset = 90,len = 4)
    private int nStepOneRank;               //排名
    @CutLength(offset = 94,len = 2)
    private short bnRes4;

    public int getCbSize() {
        return cbSize;
    }

    public void setCbSize(int cbSize) {
        this.cbSize = cbSize;
    }

    public int getNScore() {
        return nScore;
    }

    public void setNScore(int nScore) {
        this.nScore = nScore;
    }

    public String getSzKey() {
        return szKey;
    }

    public void setSzKey(String szKey) {
        this.szKey = szKey;
    }

    public short getNServerID() {
        return nServerID;
    }

    public void setNServerID(short nServerID) {
        this.nServerID = nServerID;
    }

    public short getNDBID() {
        return nDBID;
    }

    public void setNDBID(short nDBID) {
        this.nDBID = nDBID;
    }

    public short getNTableID() {
        return nTableID;
    }

    public void setNTableID(short nTableID) {
        this.nTableID = nTableID;
    }

    public short getNFileID() {
        return nFileID;
    }

    public void setNFileID(short nFileID) {
        this.nFileID = nFileID;
    }

    public byte getCheckState() {
        return checkState;
    }

    public void setCheckState(byte checkState) {
        this.checkState = checkState;
    }

    public int getBnRes_nRID() {
        return bnRes_nRID;
    }

    public void setBnRes_nRID(int bnRes_nRID) {
        this.bnRes_nRID = bnRes_nRID;
    }

    public byte getNStatus() {
        return nStatus;
    }

    public void setNStatus(byte nStatus) {
        this.nStatus = nStatus;
    }

    public byte getNGetCandFailCnt() {
        return nGetCandFailCnt;
    }

    public void setNGetCandFailCnt(byte nGetCandFailCnt) {
        this.nGetCandFailCnt = nGetCandFailCnt;
    }

    public byte getBIsDataCached() {
        return bIsDataCached;
    }

    public void setBIsDataCached(byte bIsDataCached) {
        this.bIsDataCached = bIsDataCached;
    }

    public byte getNTxPassedCount() {
        return nTxPassedCount;
    }

    public void setNTxPassedCount(byte nTxPassedCount) {
        this.nTxPassedCount = nTxPassedCount;
    }

    public byte getNIndex() {
        return nIndex;
    }

    public void setNIndex(byte nIndex) {
        this.nIndex = nIndex;
    }

    public byte getNFlag() {
        return nFlag;
    }

    public void setNFlag(byte nFlag) {
        this.nFlag = nFlag;
    }

    public short getNFinalServerID() {
        return nFinalServerID;
    }

    public void setNFinalServerID(short nFinalServerID) {
        this.nFinalServerID = nFinalServerID;
    }

    public byte getNSrcKeyIndex() {
        return nSrcKeyIndex;
    }

    public void setNSrcKeyIndex(byte nSrcKeyIndex) {
        this.nSrcKeyIndex = nSrcKeyIndex;
    }

    public byte getNMatchAlgorithm() {
        return nMatchAlgorithm;
    }

    public void setNMatchAlgorithm(byte nMatchAlgorithm) {
        this.nMatchAlgorithm = nMatchAlgorithm;
    }

    public byte getNGroupid() {
        return nGroupid;
    }

    public void setNGroupid(byte nGroupid) {
        this.nGroupid = nGroupid;
    }

    public byte getNDupCardCnt() {
        return nDupCardCnt;
    }

    public void setNDupCardCnt(byte nDupCardCnt) {
        this.nDupCardCnt = nDupCardCnt;
    }

    public AFISDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(AFISDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public short getNServerDBID() {
        return nServerDBID;
    }

    public void setNServerDBID(short nServerDBID) {
        this.nServerDBID = nServerDBID;
    }

    public short getNServerTableID() {
        return nServerTableID;
    }

    public void setNServerTableID(short nServerTableID) {
        this.nServerTableID = nServerTableID;
    }

    public short getNXgwRank() {
        return nXgwRank;
    }

    public void setNXgwRank(short nXgwRank) {
        this.nXgwRank = nXgwRank;
    }

    public short getNWsgRank() {
        return nWsgRank;
    }

    public void setNWsgRank(short nWsgRank) {
        this.nWsgRank = nWsgRank;
    }

    public long getNSID() {
        return nSID;
    }

    public void setNSID(long nSID) {
        this.nSID = nSID;
    }

    public short getBnRes_SID() {
        return bnRes_SID;
    }

    public void setBnRes_SID(short bnRes_SID) {
        this.bnRes_SID = bnRes_SID;
    }

    public short getNStepOneScore() {
        return nStepOneScore;
    }

    public void setNStepOneScore(short nStepOneScore) {
        this.nStepOneScore = nStepOneScore;
    }

    public int getNStepOneRank() {
        return nStepOneRank;
    }

    public void setNStepOneRank(int nStepOneRank) {
        this.nStepOneRank = nStepOneRank;
    }

    public short getBnRes4() {
        return bnRes4;
    }

    public void setBnRes4(short bnRes4) {
        this.bnRes4 = bnRes4;
    }

    public List<CandListAnnotationObject> readCandListByteBuf(byte[] byteBuf) throws Throwable{
        return super.readCandListByteBuf(byteBuf,this);
    }

    public byte[] buildCandListByteBuf() throws Throwable{
        return super.buildCandListByteBuf(this);
    }
}
