package com.anmi.anime.fpt;

import com.anmi.anime.define.Length;
import com.anmi.anime.define.LengthRef;
import com.anmi.anime.define.NoTrim;
import com.anmi.anime.struct.BaseStruct;
import java.util.List;

/**
 * Created by wangjue on 2017/6/26.
 */
public class FPT4File {
    @Length(1)
    private FPTHead head = new FPTHead();
    @Length(12)
    private String fileLength;//文件长度
    @Length(2)
    private String dataType = FPTBase.LOGIC01REC_DATATYPE;//逻辑记录类型
    @Length(6)
    private String tpCount;//十指指纹信息记录数量
    @Length(6)
    private String lpCount;//现场指纹信息记录数量
    @Length(6)
    private String tl_ltCount;//指纹正查及倒查比中信息记录数量
    @Length(6)
    private String ttCount;//指纹查重比中信息记录数量
    @Length(6)
    private String llCount;//指纹串查比中信息记录数量
    @Length(6)
    private String lpRequestCount;//现场指纹查询请求信息记录数量
    @Length(6)
    private String tpRequestCount;//十指指纹查询请求信息记录数量
    @Length(6)
    private String ltCandidateCount;//正查比对结果候选信息记录数量
    @Length(6)
    private String tlCandidateCount;//倒查比对结果候选信息记录数量
    @Length(6)
    private String ttCandidateCount;//查重比对结果候选信息记录数量
    @Length(6)
    private String llCandidateCount;//串查比对结果候选信息记录数量
    @Length(6)
    private String customCandidateCount;//自定义逻辑记录数量
    @Length(14)
    private String sendTime;//发送时间yyyyMMddhhmmss
    @Length(12)
    private String receiveUnitCode;//接收单位代码
    @Length(12)
    private String sendUnitCode;//发送单位代码
    @Length(70)
    private String sendUnitName;//发送单位名称
    @Length(30)
    private String sender;//发送人
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
    private String sid;//任务控制号
    @Length(512)
    private String remark;//备注
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

    public String getTpCount() {
        return tpCount;
    }

    public void setTpCount(String tpCount) {
        this.tpCount = tpCount;
    }

    public String getLpCount() {
        return lpCount;
    }

    public void setLpCount(String lpCount) {
        this.lpCount = lpCount;
    }

    public String getTl_ltCount() {
        return tl_ltCount;
    }

    public void setTl_ltCount(String tl_ltCount) {
        this.tl_ltCount = tl_ltCount;
    }

    public String getTtCount() {
        return ttCount;
    }

    public void setTtCount(String ttCount) {
        this.ttCount = ttCount;
    }

    public String getLlCount() {
        return llCount;
    }

    public void setLlCount(String llCount) {
        this.llCount = llCount;
    }

    public String getLpRequestCount() {
        return lpRequestCount;
    }

    public void setLpRequestCount(String lpRequestCount) {
        this.lpRequestCount = lpRequestCount;
    }

    public String getTpRequestCount() {
        return tpRequestCount;
    }

    public void setTpRequestCount(String tpRequestCount) {
        this.tpRequestCount = tpRequestCount;
    }

    public String getLtCandidateCount() {
        return ltCandidateCount;
    }

    public void setLtCandidateCount(String ltCandidateCount) {
        this.ltCandidateCount = ltCandidateCount;
    }

    public String getTlCandidateCount() {
        return tlCandidateCount;
    }

    public void setTlCandidateCount(String tlCandidateCount) {
        this.tlCandidateCount = tlCandidateCount;
    }

    public String getTtCandidateCount() {
        return ttCandidateCount;
    }

    public void setTtCandidateCount(String ttCandidateCount) {
        this.ttCandidateCount = ttCandidateCount;
    }

    public String getLlCandidateCount() {
        return llCandidateCount;
    }

    public void setLlCandidateCount(String llCandidateCount) {
        this.llCandidateCount = llCandidateCount;
    }

    public String getCustomCandidateCount() {
        return customCandidateCount;
    }

    public void setCustomCandidateCount(String customCandidateCount) {
        this.customCandidateCount = customCandidateCount;
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

    /**-------------------------------------------------------------------------------------------------------------------------------------------------------**/

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
        @Length(2)
        private String dataType = FPTBase.LOGIC02REC_DATATYPE;//记录类型
        @Length(6)
        private String index;//序号
        @Length(4)
        private String systemType;//系统类型
        @Length(23)
        private String personId;//人员编号
        @Length(23)
        private String cardId;//卡号
        @Length(30)
        private String personName;//姓名
        @Length(30)
        private String alias;//别名
        @Length(1)
        private String gender;//性别
        @Length(8)
        private String birthday;//出生日期
        @Length(3)
        private String nativeplace;//国籍
        @Length(2)
        private String nation;//民族
        @Length(18)
        private String idCardNo;//身份证
        @Length(3)
        private String certificateType;//证件类型
        @Length(20)
        private String certificateNo;//证件号码
        @Length(6)
        private String door;//户籍地行政区划
        @Length(70)
        private String doorDetail;//户籍地祥址
        @Length(6)
        private String address;//现住址行政区划
        @Length(70)
        private String addressDetail;//现住址祥址
        @Length(2)
        private String category;//人员类别
        @Length(6)
        private String caseClass1Code;//案件类别1
        @Length(6)
        private String caseClass2Code;//案件类别2
        @Length(6)
        private String caseClass3Code;//案件类别3
        @Length(1)
        private String isCriminal;//前科标识
        @Length(1024)
        private String criminalInfo;//前科情况
        @Length(12)
        private String gatherUnitCode;//捺印单位代码
        @Length(70)
        private String gatherUnitName;//捺印单位名称
        @Length(30)
        private String gatherName;//捺印人姓名
        @Length(8)
        private String gatherDate;//捺印日期
        @Length(1)
        private String assistLevel;//协查级别
        @Length(6)
        private String bonus;//奖金
        @Length(5)
        private String assistPurpose;//协查目的
        @Length(23)
        private String relatedPersonId;//相关捺印卡号
        @Length(23)
        private String relatedCaseId;//相关指纹编号
        @Length(1)
        private String assistTimeLimit;//协查有效时限
        @Length(512)
        private String assistAskingInfo;//协查请求说明
        @Length(12)
        private String assistUnitCode;//协查单位代码
        @Length(70)
        private String assistUnitName;//协查单位名称
        @Length(8)
        private String assistDate;//协查日期
        @Length(30)
        private String contact;//联系人
        @Length(40)
        private String contactPhone;//联系人电话
        @Length(30)
        private String approver;//审批人
        @Length(512)
        private String remark;//备注
        @Length(1)
        private String isAssist;//协查标识
        @Length(6)
        private String portraitDataLength;//人像图像数据长度
        @LengthRef("portraitDataLength")
        private byte[] portraitData;//人像图像数据
        @Length(2)
        private String sendFingerCount;//发送指纹个数
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

        public String getNativeplace() {
            return nativeplace;
        }

        public void setNativeplace(String nativeplace) {
            this.nativeplace = nativeplace;
        }

        public String getNation() {
            return nation;
        }

        public void setNation(String nation) {
            this.nation = nation;
        }

        public String getIdCardNo() {
            return idCardNo;
        }

        public void setIdCardNo(String idCardNo) {
            this.idCardNo = idCardNo;
        }

        public String getCertificateType() {
            return certificateType;
        }

        public void setCertificateType(String certificateType) {
            this.certificateType = certificateType;
        }

        public String getCertificateNo() {
            return certificateNo;
        }

        public void setCertificateNo(String certificateNo) {
            this.certificateNo = certificateNo;
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

        public String getIsCriminal() {
            return isCriminal;
        }

        public void setIsCriminal(String isCriminal) {
            this.isCriminal = isCriminal;
        }

        public String getCriminalInfo() {
            return criminalInfo;
        }

        public void setCriminalInfo(String criminalInfo) {
            this.criminalInfo = criminalInfo;
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

        public String getAssistLevel() {
            return assistLevel;
        }

        public void setAssistLevel(String assistLevel) {
            this.assistLevel = assistLevel;
        }

        public String getBonus() {
            return bonus;
        }

        public void setBonus(String bonus) {
            this.bonus = bonus;
        }

        public String getAssistPurpose() {
            return assistPurpose;
        }

        public void setAssistPurpose(String assistPurpose) {
            this.assistPurpose = assistPurpose;
        }

        public String getRelatedPersonId() {
            return relatedPersonId;
        }

        public void setRelatedPersonId(String relatedPersonId) {
            this.relatedPersonId = relatedPersonId;
        }

        public String getRelatedCaseId() {
            return relatedCaseId;
        }

        public void setRelatedCaseId(String relatedCaseId) {
            this.relatedCaseId = relatedCaseId;
        }

        public String getAssistTimeLimit() {
            return assistTimeLimit;
        }

        public void setAssistTimeLimit(String assistTimeLimit) {
            this.assistTimeLimit = assistTimeLimit;
        }

        public String getAssistAskingInfo() {
            return assistAskingInfo;
        }

        public void setAssistAskingInfo(String assistAskingInfo) {
            this.assistAskingInfo = assistAskingInfo;
        }

        public String getAssistUnitCode() {
            return assistUnitCode;
        }

        public void setAssistUnitCode(String assistUnitCode) {
            this.assistUnitCode = assistUnitCode;
        }

        public String getAssistUnitName() {
            return assistUnitName;
        }

        public void setAssistUnitName(String assistUnitName) {
            this.assistUnitName = assistUnitName;
        }

        public String getAssistDate() {
            return assistDate;
        }

        public void setAssistDate(String assistDate) {
            this.assistDate = assistDate;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getContactPhone() {
            return contactPhone;
        }

        public void setContactPhone(String contactPhone) {
            this.contactPhone = contactPhone;
        }

        public String getApprover() {
            return approver;
        }

        public void setApprover(String approver) {
            this.approver = approver;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getIsAssist() {
            return isAssist;
        }

        public void setIsAssist(String isAssist) {
            this.isAssist = isAssist;
        }

        public String getPortraitDataLength() {
            return portraitDataLength;
        }

        public void setPortraitDataLength(String portraitDataLength) {
            this.portraitDataLength = portraitDataLength;
        }

        public byte[] getPortraitData() {
            return portraitData;
        }

        public void setPortraitData(byte[] portraitData) {
            this.portraitData = portraitData;
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
        @Length(7)
        private String dataLength;//指纹信息长度
        @Length(2)
        private String sendNo;//发送序号
        @Length(2)
        private String fgp;//指位
        @Length(1)
        private String extractMethod;//提取特征方法
        @Length(1)
        private String pattern1;//指纹纹型分类1
        @Length(1)
        private String pattern2;//指纹纹型分类1
        @Length(5)
        private String fingerDirection;//指纹方向
        @Length(14)
        private String centerPoint;//中心点
        @Length(14)
        private String subCenterPoint;//副中心
        @Length(14)
        private String leftTriangle;//左三角
        @Length(14)
        private String rightTriangle;//右三角
        @Length(3)
        private String featureCount;//特征个数
        @NoTrim
        @Length(1800)
        private String feature;//特征点
        @Length(6)
        private String customInfoLength;//自定义信息长度
        @LengthRef("customInfoLength")
        private byte[] customInfo;// 自定义信息
        @Length(3)
        private String imgHorizontalLength;//图像水平方向长度
        @Length(3)
        private String imgVerticalLength;//图像垂直方向长度
        @Length(3)
        private String dpi;//图像分辨率
        @Length(4)
        private String imgCompressMethod;//图像压缩方法
        @Length(6)
        private String imgDataLenght;//图像长度
        @LengthRef("imgDataLenght")
        private byte[] imgData;//图像数据
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

        public String getImgDataLenght() {
            return imgDataLenght;
        }

        public void setImgDataLenght(String imgDataLenght) {
            this.imgDataLenght = imgDataLenght;
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
        private String length;   //逻辑记录长度
        @Length(2)
        private String dataType = FPTBase.LOGIC03REC_DATATYPE;
        @Length(6)
        private String index;   //序号
        @Length(4)
        private String systemType;    //系统类型
        @Length(23)
        private String caseId;    //案件编号
        @Length(23)
        private String cardId;     //卡号
        @Length(6)
        private String caseClass1Code;    //案件类别1
        @Length(6)
        private String caseClass2Code;    //案件类别2
        @Length(6)
        private String caseClass3Code;    //案件类别3
        @Length(8)
        private String occurDate;   //发案日期
        @Length(6)
        private String occurPlaceCode;    //发案地点代码
        @Length(70)
        private String occurPlace;    //发案地点
        @Length(512)
        private String caseBriefDetail;   //简要案情
        @Length(1)
        private String isMurder;    //命案标识
        @Length(10)
        private String amount;    //涉案金额
        @Length(12)
        private String extractUnitCode;   //提取单位代码
        @Length(70)
        private String extractUnitName;   //提取单位名称
        @Length(8)
        private String extractDate;   //提取日期
        @Length(30)
        private String extractor;   //提取人
        @Length(6)
        private String suspiciousArea1Code;   //可疑地区线索1
        @Length(6)
        private String suspiciousArea2Code;   //可疑地区线索2
        @Length(6)
        private String suspiciousArea3Code;   //可疑地区线索3
        @Length(1)
        private String assistLevel;   //协查级别
        @Length(6)
        private String bonus;   //奖金
        @Length(12)
        private String assistUnitCode;    //协查单位代码
        @Length(70)
        private String assistUnitName;    //协查单位名称
        @Length(8)
        private String assistDate;    //协查日期
        @Length(1)
        private String isCaseAssist;    //案件协查标识
        @Length(1)
        private String isRevoke;    //部撤销标识
        @Length(1)
        private String caseStatus;    //案件状态
        @Length(2)
        private String fingerCount;   //本案现场指纹个数
        @Length(2)
        private String sendFingerCount;   //发送现场指纹个数
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

        public String getOccurPlaceCode() {
            return occurPlaceCode;
        }

        public void setOccurPlaceCode(String occurPlaceCode) {
            this.occurPlaceCode = occurPlaceCode;
        }

        public String getOccurPlace() {
            return occurPlace;
        }

        public void setOccurPlace(String occurPlace) {
            this.occurPlace = occurPlace;
        }

        public String getCaseBriefDetail() {
            return caseBriefDetail;
        }

        public void setCaseBriefDetail(String caseBriefDetail) {
            this.caseBriefDetail = caseBriefDetail;
        }

        public String getIsMurder() {
            return isMurder;
        }

        public void setIsMurder(String isMurder) {
            this.isMurder = isMurder;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
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

        public String getExtractDate() {
            return extractDate;
        }

        public void setExtractDate(String extractDate) {
            this.extractDate = extractDate;
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

        public String getAssistLevel() {
            return assistLevel;
        }

        public void setAssistLevel(String assistLevel) {
            this.assistLevel = assistLevel;
        }

        public String getBonus() {
            return bonus;
        }

        public void setBonus(String bonus) {
            this.bonus = bonus;
        }

        public String getAssistUnitCode() {
            return assistUnitCode;
        }

        public void setAssistUnitCode(String assistUnitCode) {
            this.assistUnitCode = assistUnitCode;
        }

        public String getAssistUnitName() {
            return assistUnitName;
        }

        public void setAssistUnitName(String assistUnitName) {
            this.assistUnitName = assistUnitName;
        }

        public String getAssistDate() {
            return assistDate;
        }

        public void setAssistDate(String assistDate) {
            this.assistDate = assistDate;
        }

        public String getIsCaseAssist() {
            return isCaseAssist;
        }

        public void setIsCaseAssist(String isCaseAssist) {
            this.isCaseAssist = isCaseAssist;
        }

        public String getIsRevoke() {
            return isRevoke;
        }

        public void setIsRevoke(String isRevoke) {
            this.isRevoke = isRevoke;
        }

        public String getCaseStatus() {
            return caseStatus;
        }

        public void setCaseStatus(String caseStatus) {
            this.caseStatus = caseStatus;
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
        @Length(7)
        private String dataLength;    //指纹信息长度
        @Length(2)
        private String sendNo;    //发送序号
        @Length(2)
        private String fingerNo;    //指纹序号
        @Length(25)
        private String fingerId;    //指纹编号
        @Length(1)
        private String isCorpse;    //是否为尸体指纹
        @Length(23)
        private String corpseNo;    //未知名尸体编号
        @Length(30)
        private String remainPlace;   //遗留部位
        @Length(10)
        private String fgp;   //分析指位
        @Length(1)
        private String ridgeColor;    //乳突线颜色
        @Length(2)
        private String mittensBegNo;    //连指开始序号
        @Length(2)
        private String mittensEndNo;    //连指结束序号
        @Length(1)
        private String isFingerAssist;    //指纹协查标识
        @Length(1)
        private String matchStatus;   //指纹比对状态
        @Length(1)
        private String extractMethod;   //特征提取方式
        @Length(7)
        private String pattern;   //指纹纹型分类
        @Length(5)
        private String fingerDirection;   //指纹方向
        @Length(14)
        private String centerPoint;   //中心点
        @Length(14)
        private String subCenterPoint;    //副中心
        @Length(14)
        private String leftTriangle;    //左三角
        @Length(14)
        private String rightTriangle;   //右三角
        @Length(3)
        private String featureCount;    //特征点个数
        @NoTrim
        @Length(1800)
        private String feature;   //特征点
        @Length(6)
        private String customInfoLength;    //自定义信息长度
        @LengthRef("customInfoLength")
        private byte[] customInfo;   //自定义信息
        @Length(3)
        private String imgHorizontalLength;   //图像水平方向长度
        @Length(3)
        private String imgVerticalLength;   //图像垂直方向长度
        @Length(3)
        private String dpi;   //图像分辨率
        @Length(4)
        private String imgCompressMethod;   //图像压缩方法代码
        @Length(6)
        private String imgDataLength;   //图像长度
        @LengthRef("imgDataLength")
        private byte[] imgData;    //图像数据
        @Length(1)
        private byte end = FPTBase.GS;   //分隔符或结束符

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

        public String getIsCorpse() {
            return isCorpse;
        }

        public void setIsCorpse(String isCorpse) {
            this.isCorpse = isCorpse;
        }

        public String getCorpseNo() {
            return corpseNo;
        }

        public void setCorpseNo(String corpseNo) {
            this.corpseNo = corpseNo;
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

        public String getIsFingerAssist() {
            return isFingerAssist;
        }

        public void setIsFingerAssist(String isFingerAssist) {
            this.isFingerAssist = isFingerAssist;
        }

        public String getMatchStatus() {
            return matchStatus;
        }

        public void setMatchStatus(String matchStatus) {
            this.matchStatus = matchStatus;
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
