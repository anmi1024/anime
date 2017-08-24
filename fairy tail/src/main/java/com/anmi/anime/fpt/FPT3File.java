package com.anmi.anime.fpt;

import com.anmi.anime.define.Length;
import com.anmi.anime.define.LengthRef;
import com.anmi.anime.define.NoTrim;
import com.anmi.anime.struct.BaseStruct;

import java.util.List;

/**
 * Created by wangjue on 2017/6/26.
 */
public class FPT3File {
    @Length(1)
    private FPTHead head = new FPTHead();
    @Length(12)
    private String fileLength;
    @Length(1)
    private String dataType = FPTBase.LOGIC1REC_DATATYPE;
    @Length(6)
    private String lpCount;
    @Length(6)
    private String tpCount;
    @Length(14)
    private String sendTime;
    @Length(12)
    private String receiveUnitCode;
    @Length(12)
    private String sendUnitCode;
    @Length(70)
    private String sendUnitName;
    @Length(30)
    private String sender;
    /**
     * 发送单位系统类型
     * 1900 东方金指
     * 1300 北大高科
     * 1700 北京海鑫
     * 1800 小日本NEC
     * 1200 北京邮电大学
     * 1100 北京刑科所
     */
    @Length(4)
    private String sendUnitSystemType;
    @Length(10)
    private String sid;
    @Length(512)
    private String remark;
    @Length(1)
    private byte fs = FPTBase.FS;

    @LengthRef("tpCount")
    private List<LogicTPRec> logicTPRec;
    @LengthRef("lpCount")
    private List<LogicLPRec> logicLPRec;

    public FPTHead getHead() {
        return head;
    }

    public void setHead(FPTHead head) {
        this.head = head;
    }

    public String getFileLength() {
        return fileLength;
    }

    public void setFileLength(String fileLength) {
        this.fileLength = fileLength;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getLpCount() {
        return lpCount;
    }

    public void setLpCount(String lpCount) {
        this.lpCount = lpCount;
    }

    public String getTpCount() {
        return tpCount;
    }

    public void setTpCount(String tpCount) {
        this.tpCount = tpCount;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getReceiveUnitCode() {
        return receiveUnitCode;
    }

    public void setReceiveUnitCode(String receiveUnitCode) {
        this.receiveUnitCode = receiveUnitCode;
    }

    public String getSendUnitCode() {
        return sendUnitCode;
    }

    public void setSendUnitCode(String sendUnitCode) {
        this.sendUnitCode = sendUnitCode;
    }

    public String getSendUnitName() {
        return sendUnitName;
    }

    public void setSendUnitName(String sendUnitName) {
        this.sendUnitName = sendUnitName;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSendUnitSystemType() {
        return sendUnitSystemType;
    }

    public void setSendUnitSystemType(String sendUnitSystemType) {
        this.sendUnitSystemType = sendUnitSystemType;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public byte getFs() {
        return fs;
    }

    public void setFs(byte fs) {
        this.fs = fs;
    }

    public List<LogicTPRec> getLogicTPRec() {
        return logicTPRec;
    }

    public void setLogicTPRec(List<LogicTPRec> logicTPRec) {
        this.logicTPRec = logicTPRec;
    }

    public List<LogicLPRec> getLogicLPRec() {
        return logicLPRec;
    }

    public void setLogicLPRec(List<LogicLPRec> logicLPRec) {
        this.logicLPRec = logicLPRec;
    }

    public class FPTHead extends BaseStruct {
        @Length(3)
        private String flag;
        @Length(2)
        private String majorVersion;
        @Length(2)
        private String minorVersion;

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public String getMajorVersion() {
            return majorVersion;
        }

        public void setMajorVersion(String majorVersion) {
            this.majorVersion = majorVersion;
        }

        public String getMinorVersion() {
            return minorVersion;
        }

        public void setMinorVersion(String minorVersion) {
            this.minorVersion = minorVersion;
        }
    }

    public class LogicTPRec extends BaseStruct {
        @Length(8)
        private String length;//本逻辑记录长度
        @Length(1)
        private String dataType = FPTBase.LOGIC2REC_DATATYPE;
        @Length(6)
        private String index;
        @Length(4)
        private String systemType;
        @Length(23)
        private String personId;
        @Length(20)
        private String cardId;
        @Length(30)
        private String personName;
        @Length(30)
        private String alias;
        @Length(1)
        private String gender;
        @Length(8)
        private String birthday;
        @Length(18)
        private String idCardNo;
        @Length(6)
        private String door;
        @Length(70)
        private String doorDetail;
        @Length(6)
        private String address;
        @Length(70)
        private String addressDetail;
        @Length(20)
        private String category;
        @Length(6)
        private String caseClass1Code;
        @Length(6)
        private String caseClass2Code;
        @Length(6)
        private String caseClass3Code;
        @Length(12)
        private String gatherUnitCode;
        @Length(70)
        private String gatherUnitName;
        @Length(30)
        private String gatherName;
        @Length(8)
        private String gatherDate;
        @Length(512)
        private String remark;
        @Length(2)
        private String sendFingerCount;
        @LengthRef("sendFingerCount")
        private List<LogicTPFinger> fingers;

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getSystemType() {
            return systemType;
        }

        public void setSystemType(String systemType) {
            this.systemType = systemType;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }

        public String getPersonName() {
            return personName;
        }

        public void setPersonName(String personName) {
            this.personName = personName;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getIdCardNo() {
            return idCardNo;
        }

        public void setIdCardNo(String idCardNo) {
            this.idCardNo = idCardNo;
        }

        public String getDoor() {
            return door;
        }

        public void setDoor(String door) {
            this.door = door;
        }

        public String getDoorDetail() {
            return doorDetail;
        }

        public void setDoorDetail(String doorDetail) {
            this.doorDetail = doorDetail;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAddressDetail() {
            return addressDetail;
        }

        public void setAddressDetail(String addressDetail) {
            this.addressDetail = addressDetail;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getCaseClass1Code() {
            return caseClass1Code;
        }

        public void setCaseClass1Code(String caseClass1Code) {
            this.caseClass1Code = caseClass1Code;
        }

        public String getCaseClass2Code() {
            return caseClass2Code;
        }

        public void setCaseClass2Code(String caseClass2Code) {
            this.caseClass2Code = caseClass2Code;
        }

        public String getCaseClass3Code() {
            return caseClass3Code;
        }

        public void setCaseClass3Code(String caseClass3Code) {
            this.caseClass3Code = caseClass3Code;
        }

        public String getGatherUnitCode() {
            return gatherUnitCode;
        }

        public void setGatherUnitCode(String gatherUnitCode) {
            this.gatherUnitCode = gatherUnitCode;
        }

        public String getGatherUnitName() {
            return gatherUnitName;
        }

        public void setGatherUnitName(String gatherUnitName) {
            this.gatherUnitName = gatherUnitName;
        }

        public String getGatherName() {
            return gatherName;
        }

        public void setGatherName(String gatherName) {
            this.gatherName = gatherName;
        }

        public String getGatherDate() {
            return gatherDate;
        }

        public void setGatherDate(String gatherDate) {
            this.gatherDate = gatherDate;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getSendFingerCount() {
            return sendFingerCount;
        }

        public void setSendFingerCount(String sendFingerCount) {
            this.sendFingerCount = sendFingerCount;
        }

        public List<LogicTPFinger> getFingers() {
            return fingers;
        }

        public void setFingers(List<LogicTPFinger> fingers) {
            this.fingers = fingers;
        }
    }

    public class LogicTPFinger {
        @Length(6)
        private String dataLength;
        @Length(2)
        private String sendNo;
        @Length(2)
        private String fgp;
        @Length(1)
        private String extractMethod;
        @Length(1)
        private String pattern1;
        @Length(1)
        private String pattern2;
        @Length(5)
        private String fingerDirection;
        @Length(14)
        private String centerPoint;
        @Length(14)
        private String subCenterPoint;
        @Length(14)
        private String leftTriangle;
        @Length(14)
        private String rightTriangle;
        @Length(3)
        private String featureCount;
        @Length(1800)
        private String feature;
        @Length(4)
        private String customInfoLength;
        @LengthRef("customInfoLength")
        private byte[] customInfo;
        @Length(3)
        private String imgHorizontalLength;
        @Length(3)
        private String imgVerticalLength;
        @Length(3)
        private String dpi;
        @Length(4)
        private String imgCompressMethod;
        @Length(6)
        private String imgDataLength;
        @LengthRef("imgDataLength")
        private byte[] imgData;
        @Length(1)
        private byte end = FPTBase.GS;

        public String getDataLength() {
            return dataLength;
        }

        public void setDataLength(String dataLength) {
            this.dataLength = dataLength;
        }

        public String getSendNo() {
            return sendNo;
        }

        public void setSendNo(String sendNo) {
            this.sendNo = sendNo;
        }

        public String getFgp() {
            return fgp;
        }

        public void setFgp(String fgp) {
            this.fgp = fgp;
        }

        public String getExtractMethod() {
            return extractMethod;
        }

        public void setExtractMethod(String extractMethod) {
            this.extractMethod = extractMethod;
        }

        public String getPattern1() {
            return pattern1;
        }

        public void setPattern1(String pattern1) {
            this.pattern1 = pattern1;
        }

        public String getPattern2() {
            return pattern2;
        }

        public void setPattern2(String pattern2) {
            this.pattern2 = pattern2;
        }

        public String getFingerDirection() {
            return fingerDirection;
        }

        public void setFingerDirection(String fingerDirection) {
            this.fingerDirection = fingerDirection;
        }

        public String getCenterPoint() {
            return centerPoint;
        }

        public void setCenterPoint(String centerPoint) {
            this.centerPoint = centerPoint;
        }

        public String getSubCenterPoint() {
            return subCenterPoint;
        }

        public void setSubCenterPoint(String subCenterPoint) {
            this.subCenterPoint = subCenterPoint;
        }

        public String getLeftTriangle() {
            return leftTriangle;
        }

        public void setLeftTriangle(String leftTriangle) {
            this.leftTriangle = leftTriangle;
        }

        public String getRightTriangle() {
            return rightTriangle;
        }

        public void setRightTriangle(String rightTriangle) {
            this.rightTriangle = rightTriangle;
        }

        public String getFeatureCount() {
            return featureCount;
        }

        public void setFeatureCount(String featureCount) {
            this.featureCount = featureCount;
        }

        public String getFeature() {
            return feature;
        }

        public void setFeature(String feature) {
            this.feature = feature;
        }

        public String getCustomInfoLength() {
            return customInfoLength;
        }

        public void setCustomInfoLength(String customInfoLength) {
            this.customInfoLength = customInfoLength;
        }

        public byte[] getCustomInfo() {
            return customInfo;
        }

        public void setCustomInfo(byte[] customInfo) {
            this.customInfo = customInfo;
        }

        public String getImgHorizontalLength() {
            return imgHorizontalLength;
        }

        public void setImgHorizontalLength(String imgHorizontalLength) {
            this.imgHorizontalLength = imgHorizontalLength;
        }

        public String getImgVerticalLength() {
            return imgVerticalLength;
        }

        public void setImgVerticalLength(String imgVerticalLength) {
            this.imgVerticalLength = imgVerticalLength;
        }

        public String getDpi() {
            return dpi;
        }

        public void setDpi(String dpi) {
            this.dpi = dpi;
        }

        public String getImgCompressMethod() {
            return imgCompressMethod;
        }

        public void setImgCompressMethod(String imgCompressMethod) {
            this.imgCompressMethod = imgCompressMethod;
        }

        public String getImgDataLength() {
            return imgDataLength;
        }

        public void setImgDataLength(String imgDataLength) {
            this.imgDataLength = imgDataLength;
        }

        public byte[] getImgData() {
            return imgData;
        }

        public void setImgData(byte[] imgData) {
            this.imgData = imgData;
        }

        public byte getEnd() {
            return end;
        }

        public void setEnd(byte end) {
            this.end = end;
        }
    }

    public class LogicLPRec extends BaseStruct {
        @Length(8)
        private String length;//本逻辑记录长度
        @Length(1)
        private String dataType = FPTBase.LOGIC3REC_DATATYPE;
        @Length(6)
        private String index;
        @Length(4)
        private String systemType;
        @Length(23)
        private String caseId;
        @Length(20)
        private String cardId;
        @Length(6)
        private String caseClass1Code;
        @Length(6)
        private String caseClass2Code;
        @Length(6)
        private String caseClass3Code;
        @Length(8)
        private String occurDate;
        @Length(1)
        private String assistLevel;
        @Length(70)
        private String occurPlace;
        @Length(12)
        private String extractUnitCode;
        @Length(70)
        private String extractUnitName;
        @Length(30)
        private String extractor;
        @Length(6)
        private String suspiciousArea1Code;
        @Length(6)
        private String suspiciousArea2Code;
        @Length(6)
        private String suspiciousArea3Code;
        @Length(10)
        private String amount;
        @Length(512)
        private String remark;
        @Length(2)
        private String fingerCount;
        @Length(2)
        private String sendFingerCount;
        @LengthRef("sendFingerCount")
        private List<LogicLPFinger> fingers;

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getSystemType() {
            return systemType;
        }

        public void setSystemType(String systemType) {
            this.systemType = systemType;
        }

        public String getCaseId() {
            return caseId;
        }

        public void setCaseId(String caseId) {
            this.caseId = caseId;
        }

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }

        public String getCaseClass1Code() {
            return caseClass1Code;
        }

        public void setCaseClass1Code(String caseClass1Code) {
            this.caseClass1Code = caseClass1Code;
        }

        public String getCaseClass2Code() {
            return caseClass2Code;
        }

        public void setCaseClass2Code(String caseClass2Code) {
            this.caseClass2Code = caseClass2Code;
        }

        public String getCaseClass3Code() {
            return caseClass3Code;
        }

        public void setCaseClass3Code(String caseClass3Code) {
            this.caseClass3Code = caseClass3Code;
        }

        public String getOccurDate() {
            return occurDate;
        }

        public void setOccurDate(String occurDate) {
            this.occurDate = occurDate;
        }

        public String getAssistLevel() {
            return assistLevel;
        }

        public void setAssistLevel(String assistLevel) {
            this.assistLevel = assistLevel;
        }

        public String getOccurPlace() {
            return occurPlace;
        }

        public void setOccurPlace(String occurPlace) {
            this.occurPlace = occurPlace;
        }

        public String getExtractUnitCode() {
            return extractUnitCode;
        }

        public void setExtractUnitCode(String extractUnitCode) {
            this.extractUnitCode = extractUnitCode;
        }

        public String getExtractUnitName() {
            return extractUnitName;
        }

        public void setExtractUnitName(String extractUnitName) {
            this.extractUnitName = extractUnitName;
        }

        public String getExtractor() {
            return extractor;
        }

        public void setExtractor(String extractor) {
            this.extractor = extractor;
        }

        public String getSuspiciousArea1Code() {
            return suspiciousArea1Code;
        }

        public void setSuspiciousArea1Code(String suspiciousArea1Code) {
            this.suspiciousArea1Code = suspiciousArea1Code;
        }

        public String getSuspiciousArea2Code() {
            return suspiciousArea2Code;
        }

        public void setSuspiciousArea2Code(String suspiciousArea2Code) {
            this.suspiciousArea2Code = suspiciousArea2Code;
        }

        public String getSuspiciousArea3Code() {
            return suspiciousArea3Code;
        }

        public void setSuspiciousArea3Code(String suspiciousArea3Code) {
            this.suspiciousArea3Code = suspiciousArea3Code;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getFingerCount() {
            return fingerCount;
        }

        public void setFingerCount(String fingerCount) {
            this.fingerCount = fingerCount;
        }

        public String getSendFingerCount() {
            return sendFingerCount;
        }

        public void setSendFingerCount(String sendFingerCount) {
            this.sendFingerCount = sendFingerCount;
        }

        public List<LogicLPFinger> getFingers() {
            return fingers;
        }

        public void setFingers(List<LogicLPFinger> fingers) {
            this.fingers = fingers;
        }
    }

    public class LogicLPFinger {
        @Length(6)
        private String dataLength;
        @Length(2)
        private String sendNo;
        @Length(2)
        private String fingerNo;
        @Length(20)
        private String fingerId;
        @Length(30)
        private String remainPlace;
        @Length(10)
        private String fgp;
        @Length(1)
        private String ridgeColor;
        @Length(2)
        private String mittensBegNo;
        @Length(2)
        private String mittensEndNo;
        @Length(1)
        private String extractMethod;
        @Length(7)
        private String pattern;
        @Length(5)
        private String fingerDirection;
        @Length(14)
        private String centerPoint;
        @Length(14)
        private String subCenterPoint;
        @Length(14)
        private String leftTriangle;
        @Length(14)
        private String rightTriangle;
        @Length(3)
        private String featureCount;
        @NoTrim
        @Length(1800)
        private String feature;
        @Length(4)
        private String customInfoLength;
        @LengthRef("customInfoLength")
        private byte[] customInfo;
        @Length(3)
        private String imgHorizontalLength;
        @Length(3)
        private String imgVerticalLength;
        @Length(3)
        private String dpi;
        @Length(4)
        private String imgCompressMethod;
        @Length(6)
        private String imgDataLength;
        @LengthRef("imgDataLength")
        private byte[] imgData;
        @Length(1)
        private byte end = FPTBase.GS;

        public String getDataLength() {
            return dataLength;
        }

        public void setDataLength(String dataLength) {
            this.dataLength = dataLength;
        }

        public String getSendNo() {
            return sendNo;
        }

        public void setSendNo(String sendNo) {
            this.sendNo = sendNo;
        }

        public String getFingerNo() {
            return fingerNo;
        }

        public void setFingerNo(String fingerNo) {
            this.fingerNo = fingerNo;
        }

        public String getFingerId() {
            return fingerId;
        }

        public void setFingerId(String fingerId) {
            this.fingerId = fingerId;
        }

        public String getRemainPlace() {
            return remainPlace;
        }

        public void setRemainPlace(String remainPlace) {
            this.remainPlace = remainPlace;
        }

        public String getFgp() {
            return fgp;
        }

        public void setFgp(String fgp) {
            this.fgp = fgp;
        }

        public String getRidgeColor() {
            return ridgeColor;
        }

        public void setRidgeColor(String ridgeColor) {
            this.ridgeColor = ridgeColor;
        }

        public String getMittensBegNo() {
            return mittensBegNo;
        }

        public void setMittensBegNo(String mittensBegNo) {
            this.mittensBegNo = mittensBegNo;
        }

        public String getMittensEndNo() {
            return mittensEndNo;
        }

        public void setMittensEndNo(String mittensEndNo) {
            this.mittensEndNo = mittensEndNo;
        }

        public String getExtractMethod() {
            return extractMethod;
        }

        public void setExtractMethod(String extractMethod) {
            this.extractMethod = extractMethod;
        }

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }

        public String getFingerDirection() {
            return fingerDirection;
        }

        public void setFingerDirection(String fingerDirection) {
            this.fingerDirection = fingerDirection;
        }

        public String getCenterPoint() {
            return centerPoint;
        }

        public void setCenterPoint(String centerPoint) {
            this.centerPoint = centerPoint;
        }

        public String getSubCenterPoint() {
            return subCenterPoint;
        }

        public void setSubCenterPoint(String subCenterPoint) {
            this.subCenterPoint = subCenterPoint;
        }

        public String getLeftTriangle() {
            return leftTriangle;
        }

        public void setLeftTriangle(String leftTriangle) {
            this.leftTriangle = leftTriangle;
        }

        public String getRightTriangle() {
            return rightTriangle;
        }

        public void setRightTriangle(String rightTriangle) {
            this.rightTriangle = rightTriangle;
        }

        public String getFeatureCount() {
            return featureCount;
        }

        public void setFeatureCount(String featureCount) {
            this.featureCount = featureCount;
        }

        public String getFeature() {
            return feature;
        }

        public void setFeature(String feature) {
            this.feature = feature;
        }

        public String getCustomInfoLength() {
            return customInfoLength;
        }

        public void setCustomInfoLength(String customInfoLength) {
            this.customInfoLength = customInfoLength;
        }

        public byte[] getCustomInfo() {
            return customInfo;
        }

        public void setCustomInfo(byte[] customInfo) {
            this.customInfo = customInfo;
        }

        public String getImgHorizontalLength() {
            return imgHorizontalLength;
        }

        public void setImgHorizontalLength(String imgHorizontalLength) {
            this.imgHorizontalLength = imgHorizontalLength;
        }

        public String getImgVerticalLength() {
            return imgVerticalLength;
        }

        public void setImgVerticalLength(String imgVerticalLength) {
            this.imgVerticalLength = imgVerticalLength;
        }

        public String getDpi() {
            return dpi;
        }

        public void setDpi(String dpi) {
            this.dpi = dpi;
        }

        public String getImgCompressMethod() {
            return imgCompressMethod;
        }

        public void setImgCompressMethod(String imgCompressMethod) {
            this.imgCompressMethod = imgCompressMethod;
        }

        public String getImgDataLength() {
            return imgDataLength;
        }

        public void setImgDataLength(String imgDataLength) {
            this.imgDataLength = imgDataLength;
        }

        public byte[] getImgData() {
            return imgData;
        }

        public void setImgData(byte[] imgData) {
            this.imgData = imgData;
        }

        public byte getEnd() {
            return end;
        }

        public void setEnd(byte end) {
            this.end = end;
        }
    }
}
