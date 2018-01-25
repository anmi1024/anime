package com.anmi.anime.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wangjue on 2017/9/7.
 */
@Entity
@Table(name = "GAFIS_PERSON")
@DynamicInsert()
@DynamicUpdate()
public class GafisPersonEntity {
    private String personid;
    private String idcardno;
    private String name;
    private String spellname;
    private String usedname;
    private String usedspell;
    private String aliasname;
    private String aliasspell;
    private String sexCode;
    private String nativeplaceCode;
    private String nationCode;
    private String ifmarryCode;
    private String toneCode;
    private String tone;
    private Date birthdayst;
    private Date birthdayed;
    private String birthCode;
    private String birthStreet;
    private String birthdetail;
    private String door;
    private String doorStreet;
    private String doordetail;
    private String address;
    private String addressStreet;
    private String addressdetail;
    private String cultureCode;
    private String sourceincomeCode;
    private String faithCode;
    private String haveemployment;
    private String jobCode;
    private String headship;
    private String employunit;
    private String employaddress;
    private String otherspecialty;
    private String specialidentityCode;
    private String politicsCode;
    private String istransientpop;
    private String istempregist;
    private String havepermit;
    private String haveresidence;
    private String isservice;
    private String specialgroupCode;
    private String haveseparation;
    private String ismigrantworker;
    private String nameofschool;
    private String istraining;
    private String havecertificate;
    private Byte staturest;
    private Long avoirdupois;
    private Long footsize;
    private Long shoelength;
    private String bodilyformCode;
    private String faceformCode;
    private String iseyeglass;
    private Byte shoesize;
    private String bloodtypeCode;
    private String gatherOrgCode;
    private String ipaddress;
    private String gathererId;
    private Date gatherDate;
    private String gatherTypeId;
    private String status;
    private String isfingerrepeat;
    private String fingerrepeatno;
    private String taskSource;
    private Date receiveDate;
    private String isreturn;
    private Date returnDate;
    private String annex;
    private String inputpsn;
    private Date inputDate;
    private String modifiedpsn;
    private Date modifiedDate;
    private String deletag;
    private String schedule;
    private String approval;
    private String dnaCode;
    private String gatherCategory;
    private String personCategory;
    private String auditor;
    private Date auditedDate;
    private String isregather;
    private String gatherFingerMode;
    private String caseName;
    private String caseClasses;
    private String reason;
    private Long gatherFingerNum;
    private String fingerRemark;
    private String deprtmac;
    private String gatherdepartcode;
    private String gatheruserid;
    private Date gatherFingerDate;
    private Long isSendTl;
    private String caseBriefContents;
    private String pushStatus;
    private Date pushDate;
    private String remark;
    private Integer dataSources;
    private Integer fingershowStatus;
    private String cityCode;
    private Date delayDeadline;
    private String fptGatherDepartCode;
    private String fptGatherDepartName;
    private Long sid;
    private String blowCode;
    private String blowStreet;
    private String blowDetail;
    private String blowLongitude;
    private String blowLatitude;
    private String blowEastwest;
    private String blowNorthsouth;
    private Long seq;
    private String cardid;
    private String recordmark;
    private String recordsituation;
    private Date validDate;
    private Date arriveLocalDate;
    private Date leaveLocalDate;
    private String dbSource;
    private String dbSourceDis;
    private String jobDes;
    private String isXjssmz;
    private String passportNum;
    private String countryCode;
    private String foreignName;
    private Date passportValidDate;
    private String visaPlace;
    private String passportType;
    private Date visaDate;
    private String assistLevel;
    private String assistBonus;
    private String assistPurpose;
    private String assistRefPerson;
    private String assistRefCase;
    private String assistValidDate;
    private String assistExplain;
    private String assistDeptCode;
    private String assistDeptName;
    private String assistDate;
    private String assistContacts;
    private String assistNumber;
    private String assistApproval;
    private String assistSign;
    private String gatherdepartname;
    private String gatherusername;
    private String contrcaptureCode;
    private String smuggling;
    private String certificatetype;
    private String certificateid;
    private String personType;
    private String caseClasses2;
    private String caseClasses3;
    private String caseNumber;
    private String fptPath;
    private String dataIn;
    private String dataType;

    @Id
    @Column(name = "PERSONID")
    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    @Basic
    @Column(name = "IDCARDNO")
    public String getIdcardno() {
        return idcardno;
    }

    public void setIdcardno(String idcardno) {
        this.idcardno = idcardno;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "SPELLNAME")
    public String getSpellname() {
        return spellname;
    }

    public void setSpellname(String spellname) {
        this.spellname = spellname;
    }

    @Basic
    @Column(name = "USEDNAME")
    public String getUsedname() {
        return usedname;
    }

    public void setUsedname(String usedname) {
        this.usedname = usedname;
    }

    @Basic
    @Column(name = "USEDSPELL")
    public String getUsedspell() {
        return usedspell;
    }

    public void setUsedspell(String usedspell) {
        this.usedspell = usedspell;
    }

    @Basic
    @Column(name = "ALIASNAME")
    public String getAliasname() {
        return aliasname;
    }

    public void setAliasname(String aliasname) {
        this.aliasname = aliasname;
    }

    @Basic
    @Column(name = "ALIASSPELL")
    public String getAliasspell() {
        return aliasspell;
    }

    public void setAliasspell(String aliasspell) {
        this.aliasspell = aliasspell;
    }

    @Basic
    @Column(name = "SEX_CODE")
    public String getSexCode() {
        return sexCode;
    }

    public void setSexCode(String sexCode) {
        this.sexCode = sexCode;
    }

    @Basic
    @Column(name = "NATIVEPLACE_CODE")
    public String getNativeplaceCode() {
        return nativeplaceCode;
    }

    public void setNativeplaceCode(String nativeplaceCode) {
        this.nativeplaceCode = nativeplaceCode;
    }

    @Basic
    @Column(name = "NATION_CODE")
    public String getNationCode() {
        return nationCode;
    }

    public void setNationCode(String nationCode) {
        this.nationCode = nationCode;
    }

    @Basic
    @Column(name = "IFMARRY_CODE")
    public String getIfmarryCode() {
        return ifmarryCode;
    }

    public void setIfmarryCode(String ifmarryCode) {
        this.ifmarryCode = ifmarryCode;
    }

    @Basic
    @Column(name = "TONE_CODE")
    public String getToneCode() {
        return toneCode;
    }

    public void setToneCode(String toneCode) {
        this.toneCode = toneCode;
    }

    @Basic
    @Column(name = "TONE")
    public String getTone() {
        return tone;
    }

    public void setTone(String tone) {
        this.tone = tone;
    }

    @Basic
    @Column(name = "BIRTHDAYST")
    public Date getBirthdayst() {
        return birthdayst;
    }

    public void setBirthdayst(Date birthdayst) {
        this.birthdayst = birthdayst;
    }

    @Basic
    @Column(name = "BIRTHDAYED")
    public Date getBirthdayed() {
        return birthdayed;
    }

    public void setBirthdayed(Date birthdayed) {
        this.birthdayed = birthdayed;
    }

    @Basic
    @Column(name = "BIRTH_CODE")
    public String getBirthCode() {
        return birthCode;
    }

    public void setBirthCode(String birthCode) {
        this.birthCode = birthCode;
    }

    @Basic
    @Column(name = "BIRTH_STREET")
    public String getBirthStreet() {
        return birthStreet;
    }

    public void setBirthStreet(String birthStreet) {
        this.birthStreet = birthStreet;
    }

    @Basic
    @Column(name = "BIRTHDETAIL")
    public String getBirthdetail() {
        return birthdetail;
    }

    public void setBirthdetail(String birthdetail) {
        this.birthdetail = birthdetail;
    }

    @Basic
    @Column(name = "DOOR")
    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    @Basic
    @Column(name = "DOOR_STREET")
    public String getDoorStreet() {
        return doorStreet;
    }

    public void setDoorStreet(String doorStreet) {
        this.doorStreet = doorStreet;
    }

    @Basic
    @Column(name = "DOORDETAIL")
    public String getDoordetail() {
        return doordetail;
    }

    public void setDoordetail(String doordetail) {
        this.doordetail = doordetail;
    }

    @Basic
    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "ADDRESS_STREET")
    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    @Basic
    @Column(name = "ADDRESSDETAIL")
    public String getAddressdetail() {
        return addressdetail;
    }

    public void setAddressdetail(String addressdetail) {
        this.addressdetail = addressdetail;
    }

    @Basic
    @Column(name = "CULTURE_CODE")
    public String getCultureCode() {
        return cultureCode;
    }

    public void setCultureCode(String cultureCode) {
        this.cultureCode = cultureCode;
    }

    @Basic
    @Column(name = "SOURCEINCOME_CODE")
    public String getSourceincomeCode() {
        return sourceincomeCode;
    }

    public void setSourceincomeCode(String sourceincomeCode) {
        this.sourceincomeCode = sourceincomeCode;
    }

    @Basic
    @Column(name = "FAITH_CODE")
    public String getFaithCode() {
        return faithCode;
    }

    public void setFaithCode(String faithCode) {
        this.faithCode = faithCode;
    }

    @Basic
    @Column(name = "HAVEEMPLOYMENT")
    public String getHaveemployment() {
        return haveemployment;
    }

    public void setHaveemployment(String haveemployment) {
        this.haveemployment = haveemployment;
    }

    @Basic
    @Column(name = "JOB_CODE")
    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    @Basic
    @Column(name = "HEADSHIP")
    public String getHeadship() {
        return headship;
    }

    public void setHeadship(String headship) {
        this.headship = headship;
    }

    @Basic
    @Column(name = "EMPLOYUNIT")
    public String getEmployunit() {
        return employunit;
    }

    public void setEmployunit(String employunit) {
        this.employunit = employunit;
    }

    @Basic
    @Column(name = "EMPLOYADDRESS")
    public String getEmployaddress() {
        return employaddress;
    }

    public void setEmployaddress(String employaddress) {
        this.employaddress = employaddress;
    }

    @Basic
    @Column(name = "OTHERSPECIALTY")
    public String getOtherspecialty() {
        return otherspecialty;
    }

    public void setOtherspecialty(String otherspecialty) {
        this.otherspecialty = otherspecialty;
    }

    @Basic
    @Column(name = "SPECIALIDENTITY_CODE")
    public String getSpecialidentityCode() {
        return specialidentityCode;
    }

    public void setSpecialidentityCode(String specialidentityCode) {
        this.specialidentityCode = specialidentityCode;
    }

    @Basic
    @Column(name = "POLITICS_CODE")
    public String getPoliticsCode() {
        return politicsCode;
    }

    public void setPoliticsCode(String politicsCode) {
        this.politicsCode = politicsCode;
    }

    @Basic
    @Column(name = "ISTRANSIENTPOP")
    public String getIstransientpop() {
        return istransientpop;
    }

    public void setIstransientpop(String istransientpop) {
        this.istransientpop = istransientpop;
    }

    @Basic
    @Column(name = "ISTEMPREGIST")
    public String getIstempregist() {
        return istempregist;
    }

    public void setIstempregist(String istempregist) {
        this.istempregist = istempregist;
    }

    @Basic
    @Column(name = "HAVEPERMIT")
    public String getHavepermit() {
        return havepermit;
    }

    public void setHavepermit(String havepermit) {
        this.havepermit = havepermit;
    }

    @Basic
    @Column(name = "HAVERESIDENCE")
    public String getHaveresidence() {
        return haveresidence;
    }

    public void setHaveresidence(String haveresidence) {
        this.haveresidence = haveresidence;
    }

    @Basic
    @Column(name = "ISSERVICE")
    public String getIsservice() {
        return isservice;
    }

    public void setIsservice(String isservice) {
        this.isservice = isservice;
    }

    @Basic
    @Column(name = "SPECIALGROUP_CODE")
    public String getSpecialgroupCode() {
        return specialgroupCode;
    }

    public void setSpecialgroupCode(String specialgroupCode) {
        this.specialgroupCode = specialgroupCode;
    }

    @Basic
    @Column(name = "HAVESEPARATION")
    public String getHaveseparation() {
        return haveseparation;
    }

    public void setHaveseparation(String haveseparation) {
        this.haveseparation = haveseparation;
    }

    @Basic
    @Column(name = "ISMIGRANTWORKER")
    public String getIsmigrantworker() {
        return ismigrantworker;
    }

    public void setIsmigrantworker(String ismigrantworker) {
        this.ismigrantworker = ismigrantworker;
    }

    @Basic
    @Column(name = "NAMEOFSCHOOL")
    public String getNameofschool() {
        return nameofschool;
    }

    public void setNameofschool(String nameofschool) {
        this.nameofschool = nameofschool;
    }

    @Basic
    @Column(name = "ISTRAINING")
    public String getIstraining() {
        return istraining;
    }

    public void setIstraining(String istraining) {
        this.istraining = istraining;
    }

    @Basic
    @Column(name = "HAVECERTIFICATE")
    public String getHavecertificate() {
        return havecertificate;
    }

    public void setHavecertificate(String havecertificate) {
        this.havecertificate = havecertificate;
    }

    @Basic
    @Column(name = "STATUREST")
    public Byte getStaturest() {
        return staturest;
    }

    public void setStaturest(Byte staturest) {
        this.staturest = staturest;
    }

    @Basic
    @Column(name = "AVOIRDUPOIS")
    public Long getAvoirdupois() {
        return avoirdupois;
    }

    public void setAvoirdupois(Long avoirdupois) {
        this.avoirdupois = avoirdupois;
    }

    @Basic
    @Column(name = "FOOTSIZE")
    public Long getFootsize() {
        return footsize;
    }

    public void setFootsize(Long footsize) {
        this.footsize = footsize;
    }

    @Basic
    @Column(name = "SHOELENGTH")
    public Long getShoelength() {
        return shoelength;
    }

    public void setShoelength(Long shoelength) {
        this.shoelength = shoelength;
    }

    @Basic
    @Column(name = "BODILYFORM_CODE")
    public String getBodilyformCode() {
        return bodilyformCode;
    }

    public void setBodilyformCode(String bodilyformCode) {
        this.bodilyformCode = bodilyformCode;
    }

    @Basic
    @Column(name = "FACEFORM_CODE")
    public String getFaceformCode() {
        return faceformCode;
    }

    public void setFaceformCode(String faceformCode) {
        this.faceformCode = faceformCode;
    }

    @Basic
    @Column(name = "ISEYEGLASS")
    public String getIseyeglass() {
        return iseyeglass;
    }

    public void setIseyeglass(String iseyeglass) {
        this.iseyeglass = iseyeglass;
    }

    @Basic
    @Column(name = "SHOESIZE")
    public Byte getShoesize() {
        return shoesize;
    }

    public void setShoesize(Byte shoesize) {
        this.shoesize = shoesize;
    }

    @Basic
    @Column(name = "BLOODTYPE_CODE")
    public String getBloodtypeCode() {
        return bloodtypeCode;
    }

    public void setBloodtypeCode(String bloodtypeCode) {
        this.bloodtypeCode = bloodtypeCode;
    }

    @Basic
    @Column(name = "GATHER_ORG_CODE")
    public String getGatherOrgCode() {
        return gatherOrgCode;
    }

    public void setGatherOrgCode(String gatherOrgCode) {
        this.gatherOrgCode = gatherOrgCode;
    }

    @Basic
    @Column(name = "IPADDRESS")
    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    @Basic
    @Column(name = "GATHERER_ID")
    public String getGathererId() {
        return gathererId;
    }

    public void setGathererId(String gathererId) {
        this.gathererId = gathererId;
    }

    @Basic
    @Column(name = "GATHER_DATE")
    public Date getGatherDate() {
        return gatherDate;
    }

    public void setGatherDate(Date gatherDate) {
        this.gatherDate = gatherDate;
    }

    @Basic
    @Column(name = "GATHER_TYPE_ID")
    public String getGatherTypeId() {
        return gatherTypeId;
    }

    public void setGatherTypeId(String gatherTypeId) {
        this.gatherTypeId = gatherTypeId;
    }

    @Basic
    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "ISFINGERREPEAT")
    public String getIsfingerrepeat() {
        return isfingerrepeat;
    }

    public void setIsfingerrepeat(String isfingerrepeat) {
        this.isfingerrepeat = isfingerrepeat;
    }

    @Basic
    @Column(name = "FINGERREPEATNO")
    public String getFingerrepeatno() {
        return fingerrepeatno;
    }

    public void setFingerrepeatno(String fingerrepeatno) {
        this.fingerrepeatno = fingerrepeatno;
    }

    @Basic
    @Column(name = "TASK_SOURCE")
    public String getTaskSource() {
        return taskSource;
    }

    public void setTaskSource(String taskSource) {
        this.taskSource = taskSource;
    }

    @Basic
    @Column(name = "RECEIVE_TIME")
    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    @Basic
    @Column(name = "ISRETURN")
    public String getIsreturn() {
        return isreturn;
    }

    public void setIsreturn(String isreturn) {
        this.isreturn = isreturn;
    }

    @Basic
    @Column(name = "RETURN_TIME")
    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Basic
    @Column(name = "ANNEX")
    public String getAnnex() {
        return annex;
    }

    public void setAnnex(String annex) {
        this.annex = annex;
    }

    @Basic
    @Column(name = "INPUTPSN")
    public String getInputpsn() {
        return inputpsn;
    }

    public void setInputpsn(String inputpsn) {
        this.inputpsn = inputpsn;
    }

    @Basic
    @Column(name = "INPUTTIME")
    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    @Basic
    @Column(name = "MODIFIEDPSN")
    public String getModifiedpsn() {
        return modifiedpsn;
    }

    public void setModifiedpsn(String modifiedpsn) {
        this.modifiedpsn = modifiedpsn;
    }

    @Basic
    @Column(name = "MODIFIEDTIME")
    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
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
    @Column(name = "SCHEDULE")
    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @Basic
    @Column(name = "APPROVAL")
    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    @Basic
    @Column(name = "DNA_CODE")
    public String getDnaCode() {
        return dnaCode;
    }

    public void setDnaCode(String dnaCode) {
        this.dnaCode = dnaCode;
    }

    @Basic
    @Column(name = "GATHER_CATEGORY")
    public String getGatherCategory() {
        return gatherCategory;
    }

    public void setGatherCategory(String gatherCategory) {
        this.gatherCategory = gatherCategory;
    }

    @Basic
    @Column(name = "PERSON_CATEGORY")
    public String getPersonCategory() {
        return personCategory;
    }

    public void setPersonCategory(String personCategory) {
        this.personCategory = personCategory;
    }

    @Basic
    @Column(name = "AUDITOR")
    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    @Basic
    @Column(name = "AUDITEDTIME")
    public Date getAuditedDate() {
        return auditedDate;
    }

    public void setAuditedDate(Date auditedDate) {
        this.auditedDate = auditedDate;
    }

    @Basic
    @Column(name = "ISREGATHER")
    public String getIsregather() {
        return isregather;
    }

    public void setIsregather(String isregather) {
        this.isregather = isregather;
    }

    @Basic
    @Column(name = "GATHER_FINGER_MODE")
    public String getGatherFingerMode() {
        return gatherFingerMode;
    }

    public void setGatherFingerMode(String gatherFingerMode) {
        this.gatherFingerMode = gatherFingerMode;
    }

    @Basic
    @Column(name = "CASE_NAME")
    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    @Basic
    @Column(name = "CASE_CLASSES")
    public String getCaseClasses() {
        return caseClasses;
    }

    public void setCaseClasses(String caseClasses) {
        this.caseClasses = caseClasses;
    }

    @Basic
    @Column(name = "REASON")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Basic
    @Column(name = "GATHER_FINGER_NUM")
    public Long getGatherFingerNum() {
        return gatherFingerNum;
    }

    public void setGatherFingerNum(Long gatherFingerNum) {
        this.gatherFingerNum = gatherFingerNum;
    }

    @Basic
    @Column(name = "FINGER_REMARK")
    public String getFingerRemark() {
        return fingerRemark;
    }

    public void setFingerRemark(String fingerRemark) {
        this.fingerRemark = fingerRemark;
    }

    @Basic
    @Column(name = "DEPRTMAC")
    public String getDeprtmac() {
        return deprtmac;
    }

    public void setDeprtmac(String deprtmac) {
        this.deprtmac = deprtmac;
    }

    @Basic
    @Column(name = "GATHERDEPARTCODE")
    public String getGatherdepartcode() {
        return gatherdepartcode;
    }

    public void setGatherdepartcode(String gatherdepartcode) {
        this.gatherdepartcode = gatherdepartcode;
    }

    @Basic
    @Column(name = "GATHERUSERID")
    public String getGatheruserid() {
        return gatheruserid;
    }

    public void setGatheruserid(String gatheruserid) {
        this.gatheruserid = gatheruserid;
    }

    @Basic
    @Column(name = "GATHER_FINGER_TIME")
    public Date getGatherFingerDate() {
        return gatherFingerDate;
    }

    public void setGatherFingerDate(Date gatherFingerDate) {
        this.gatherFingerDate = gatherFingerDate;
    }

    @Basic
    @Column(name = "IS_SEND_TL")
    public Long getIsSendTl() {
        return isSendTl;
    }

    public void setIsSendTl(Long isSendTl) {
        this.isSendTl = isSendTl;
    }

    @Basic
    @Column(name = "CASE_BRIEF_CONTENTS")
    public String getCaseBriefContents() {
        return caseBriefContents;
    }

    public void setCaseBriefContents(String caseBriefContents) {
        this.caseBriefContents = caseBriefContents;
    }

    @Basic
    @Column(name = "PUSH_STATUS")
    public String getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(String pushStatus) {
        this.pushStatus = pushStatus;
    }

    @Basic
    @Column(name = "PUSH_DATE")
    public Date getPushDate() {
        return pushDate;
    }

    public void setPushDate(Date pushDate) {
        this.pushDate = pushDate;
    }

    @Basic
    @Column(name = "REMARK")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "DATA_SOURCES")
    public Integer getDataSources() {
        return dataSources;
    }

    public void setDataSources(Integer dataSources) {
        this.dataSources = dataSources;
    }

    @Basic
    @Column(name = "FINGERSHOW_STATUS")
    public Integer getFingershowStatus() {
        return fingershowStatus;
    }

    public void setFingershowStatus(Integer fingershowStatus) {
        this.fingershowStatus = fingershowStatus;
    }

    @Basic
    @Column(name = "CITY_CODE")
    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @Basic
    @Column(name = "DELAY_DEADLINE")
    public Date getDelayDeadline() {
        return delayDeadline;
    }

    public void setDelayDeadline(Date delayDeadline) {
        this.delayDeadline = delayDeadline;
    }

    @Basic
    @Column(name = "FPT_GATHER_DEPART_CODE")
    public String getFptGatherDepartCode() {
        return fptGatherDepartCode;
    }

    public void setFptGatherDepartCode(String fptGatherDepartCode) {
        this.fptGatherDepartCode = fptGatherDepartCode;
    }

    @Basic
    @Column(name = "FPT_GATHER_DEPART_NAME")
    public String getFptGatherDepartName() {
        return fptGatherDepartName;
    }

    public void setFptGatherDepartName(String fptGatherDepartName) {
        this.fptGatherDepartName = fptGatherDepartName;
    }

    @Basic
    @Column(name = "SID")
    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "BLOW_CODE")
    public String getBlowCode() {
        return blowCode;
    }

    public void setBlowCode(String blowCode) {
        this.blowCode = blowCode;
    }

    @Basic
    @Column(name = "BLOW_STREET")
    public String getBlowStreet() {
        return blowStreet;
    }

    public void setBlowStreet(String blowStreet) {
        this.blowStreet = blowStreet;
    }

    @Basic
    @Column(name = "BLOW_DETAIL")
    public String getBlowDetail() {
        return blowDetail;
    }

    public void setBlowDetail(String blowDetail) {
        this.blowDetail = blowDetail;
    }

    @Basic
    @Column(name = "BLOW_LONGITUDE")
    public String getBlowLongitude() {
        return blowLongitude;
    }

    public void setBlowLongitude(String blowLongitude) {
        this.blowLongitude = blowLongitude;
    }

    @Basic
    @Column(name = "BLOW_LATITUDE")
    public String getBlowLatitude() {
        return blowLatitude;
    }

    public void setBlowLatitude(String blowLatitude) {
        this.blowLatitude = blowLatitude;
    }

    @Basic
    @Column(name = "BLOW_EASTWEST")
    public String getBlowEastwest() {
        return blowEastwest;
    }

    public void setBlowEastwest(String blowEastwest) {
        this.blowEastwest = blowEastwest;
    }

    @Basic
    @Column(name = "BLOW_NORTHSOUTH")
    public String getBlowNorthsouth() {
        return blowNorthsouth;
    }

    public void setBlowNorthsouth(String blowNorthsouth) {
        this.blowNorthsouth = blowNorthsouth;
    }

    @Basic
    @Column(name = "SEQ")
    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    @Basic
    @Column(name = "CARDID")
    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    @Basic
    @Column(name = "RECORDMARK")
    public String getRecordmark() {
        return recordmark;
    }

    public void setRecordmark(String recordmark) {
        this.recordmark = recordmark;
    }

    @Basic
    @Column(name = "RECORDSITUATION")
    public String getRecordsituation() {
        return recordsituation;
    }

    public void setRecordsituation(String recordsituation) {
        this.recordsituation = recordsituation;
    }

    @Basic
    @Column(name = "VALID_DATE")
    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    @Basic
    @Column(name = "ARRIVE_LOCAL_DATE")
    public Date getArriveLocalDate() {
        return arriveLocalDate;
    }

    public void setArriveLocalDate(Date arriveLocalDate) {
        this.arriveLocalDate = arriveLocalDate;
    }

    @Basic
    @Column(name = "LEAVE_LOCAL_DATE")
    public Date getLeaveLocalDate() {
        return leaveLocalDate;
    }

    public void setLeaveLocalDate(Date leaveLocalDate) {
        this.leaveLocalDate = leaveLocalDate;
    }

    @Basic
    @Column(name = "DB_SOURCE")
    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }

    @Basic
    @Column(name = "DB_SOURCE_DIS")
    public String getDbSourceDis() {
        return dbSourceDis;
    }

    public void setDbSourceDis(String dbSourceDis) {
        this.dbSourceDis = dbSourceDis;
    }

    @Basic
    @Column(name = "JOB_DES")
    public String getJobDes() {
        return jobDes;
    }

    public void setJobDes(String jobDes) {
        this.jobDes = jobDes;
    }

    @Basic
    @Column(name = "IS_XJSSMZ")
    public String getIsXjssmz() {
        return isXjssmz;
    }

    public void setIsXjssmz(String isXjssmz) {
        this.isXjssmz = isXjssmz;
    }

    @Basic
    @Column(name = "PASSPORT_NUM")
    public String getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(String passportNum) {
        this.passportNum = passportNum;
    }

    @Basic
    @Column(name = "COUNTRY_CODE")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Basic
    @Column(name = "FOREIGN_NAME")
    public String getForeignName() {
        return foreignName;
    }

    public void setForeignName(String foreignName) {
        this.foreignName = foreignName;
    }

    @Basic
    @Column(name = "PASSPORT_VALID_DATE")
    public Date getPassportValidDate() {
        return passportValidDate;
    }

    public void setPassportValidDate(Date passportValidDate) {
        this.passportValidDate = passportValidDate;
    }

    @Basic
    @Column(name = "VISA_PLACE")
    public String getVisaPlace() {
        return visaPlace;
    }

    public void setVisaPlace(String visaPlace) {
        this.visaPlace = visaPlace;
    }

    @Basic
    @Column(name = "PASSPORT_TYPE")
    public String getPassportType() {
        return passportType;
    }

    public void setPassportType(String passportType) {
        this.passportType = passportType;
    }

    @Basic
    @Column(name = "VISA_DATE")
    public Date getVisaDate() {
        return visaDate;
    }

    public void setVisaDate(Date visaDate) {
        this.visaDate = visaDate;
    }

    @Basic
    @Column(name = "ASSIST_LEVEL")
    public String getAssistLevel() {
        return assistLevel;
    }

    public void setAssistLevel(String assistLevel) {
        this.assistLevel = assistLevel;
    }

    @Basic
    @Column(name = "ASSIST_BONUS")
    public String getAssistBonus() {
        return assistBonus;
    }

    public void setAssistBonus(String assistBonus) {
        this.assistBonus = assistBonus;
    }

    @Basic
    @Column(name = "ASSIST_PURPOSE")
    public String getAssistPurpose() {
        return assistPurpose;
    }

    public void setAssistPurpose(String assistPurpose) {
        this.assistPurpose = assistPurpose;
    }

    @Basic
    @Column(name = "ASSIST_REF_PERSON")
    public String getAssistRefPerson() {
        return assistRefPerson;
    }

    public void setAssistRefPerson(String assistRefPerson) {
        this.assistRefPerson = assistRefPerson;
    }

    @Basic
    @Column(name = "ASSIST_REF_CASE")
    public String getAssistRefCase() {
        return assistRefCase;
    }

    public void setAssistRefCase(String assistRefCase) {
        this.assistRefCase = assistRefCase;
    }

    @Basic
    @Column(name = "ASSIST_VALID_DATE")
    public String getAssistValidDate() {
        return assistValidDate;
    }

    public void setAssistValidDate(String assistValidDate) {
        this.assistValidDate = assistValidDate;
    }

    @Basic
    @Column(name = "ASSIST_EXPLAIN")
    public String getAssistExplain() {
        return assistExplain;
    }

    public void setAssistExplain(String assistExplain) {
        this.assistExplain = assistExplain;
    }

    @Basic
    @Column(name = "ASSIST_DEPT_CODE")
    public String getAssistDeptCode() {
        return assistDeptCode;
    }

    public void setAssistDeptCode(String assistDeptCode) {
        this.assistDeptCode = assistDeptCode;
    }

    @Basic
    @Column(name = "ASSIST_DEPT_NAME")
    public String getAssistDeptName() {
        return assistDeptName;
    }

    public void setAssistDeptName(String assistDeptName) {
        this.assistDeptName = assistDeptName;
    }

    @Basic
    @Column(name = "ASSIST_DATE")
    public String getAssistDate() {
        return assistDate;
    }

    public void setAssistDate(String assistDate) {
        this.assistDate = assistDate;
    }

    @Basic
    @Column(name = "ASSIST_CONTACTS")
    public String getAssistContacts() {
        return assistContacts;
    }

    public void setAssistContacts(String assistContacts) {
        this.assistContacts = assistContacts;
    }

    @Basic
    @Column(name = "ASSIST_NUMBER")
    public String getAssistNumber() {
        return assistNumber;
    }

    public void setAssistNumber(String assistNumber) {
        this.assistNumber = assistNumber;
    }

    @Basic
    @Column(name = "ASSIST_APPROVAL")
    public String getAssistApproval() {
        return assistApproval;
    }

    public void setAssistApproval(String assistApproval) {
        this.assistApproval = assistApproval;
    }

    @Basic
    @Column(name = "ASSIST_SIGN")
    public String getAssistSign() {
        return assistSign;
    }

    public void setAssistSign(String assistSign) {
        this.assistSign = assistSign;
    }

    @Basic
    @Column(name = "GATHERDEPARTNAME")
    public String getGatherdepartname() {
        return gatherdepartname;
    }

    public void setGatherdepartname(String gatherdepartname) {
        this.gatherdepartname = gatherdepartname;
    }

    @Basic
    @Column(name = "GATHERUSERNAME")
    public String getGatherusername() {
        return gatherusername;
    }

    public void setGatherusername(String gatherusername) {
        this.gatherusername = gatherusername;
    }

    @Basic
    @Column(name = "CONTRCAPTURE_CODE")
    public String getContrcaptureCode() {
        return contrcaptureCode;
    }

    public void setContrcaptureCode(String contrcaptureCode) {
        this.contrcaptureCode = contrcaptureCode;
    }

    @Basic
    @Column(name = "SMUGGLING")
    public String getSmuggling() {
        return smuggling;
    }

    public void setSmuggling(String smuggling) {
        this.smuggling = smuggling;
    }

    @Basic
    @Column(name = "CERTIFICATETYPE")
    public String getCertificatetype() {
        return certificatetype;
    }

    public void setCertificatetype(String certificatetype) {
        this.certificatetype = certificatetype;
    }

    @Basic
    @Column(name = "CERTIFICATEID")
    public String getCertificateid() {
        return certificateid;
    }

    public void setCertificateid(String certificateid) {
        this.certificateid = certificateid;
    }

    @Basic
    @Column(name = "PERSON_TYPE")
    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    @Basic
    @Column(name = "CASE_CLASSES2")
    public String getCaseClasses2() {
        return caseClasses2;
    }

    public void setCaseClasses2(String caseClasses2) {
        this.caseClasses2 = caseClasses2;
    }

    @Basic
    @Column(name = "CASE_CLASSES3")
    public String getCaseClasses3() {
        return caseClasses3;
    }

    public void setCaseClasses3(String caseClasses3) {
        this.caseClasses3 = caseClasses3;
    }

    @Basic
    @Column(name = "CASE_NUMBER")
    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    @Basic
    @Column(name = "FPT_PATH")
    public String getFptPath() {
        return fptPath;
    }

    public void setFptPath(String fptPath) {
        this.fptPath = fptPath;
    }

    @Basic
    @Column(name = "DATA_IN")
    public String getDataIn() {
        return dataIn;
    }

    public void setDataIn(String dataIn) {
        this.dataIn = dataIn;
    }

    @Basic
    @Column(name = "DATA_TYPE")
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GafisPersonEntity that = (GafisPersonEntity) o;

        if (personid != null ? !personid.equals(that.personid) : that.personid != null) return false;
        if (idcardno != null ? !idcardno.equals(that.idcardno) : that.idcardno != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (spellname != null ? !spellname.equals(that.spellname) : that.spellname != null) return false;
        if (usedname != null ? !usedname.equals(that.usedname) : that.usedname != null) return false;
        if (usedspell != null ? !usedspell.equals(that.usedspell) : that.usedspell != null) return false;
        if (aliasname != null ? !aliasname.equals(that.aliasname) : that.aliasname != null) return false;
        if (aliasspell != null ? !aliasspell.equals(that.aliasspell) : that.aliasspell != null) return false;
        if (sexCode != null ? !sexCode.equals(that.sexCode) : that.sexCode != null) return false;
        if (nativeplaceCode != null ? !nativeplaceCode.equals(that.nativeplaceCode) : that.nativeplaceCode != null)
            return false;
        if (nationCode != null ? !nationCode.equals(that.nationCode) : that.nationCode != null) return false;
        if (ifmarryCode != null ? !ifmarryCode.equals(that.ifmarryCode) : that.ifmarryCode != null) return false;
        if (toneCode != null ? !toneCode.equals(that.toneCode) : that.toneCode != null) return false;
        if (tone != null ? !tone.equals(that.tone) : that.tone != null) return false;
        if (birthdayst != null ? !birthdayst.equals(that.birthdayst) : that.birthdayst != null) return false;
        if (birthdayed != null ? !birthdayed.equals(that.birthdayed) : that.birthdayed != null) return false;
        if (birthCode != null ? !birthCode.equals(that.birthCode) : that.birthCode != null) return false;
        if (birthStreet != null ? !birthStreet.equals(that.birthStreet) : that.birthStreet != null) return false;
        if (birthdetail != null ? !birthdetail.equals(that.birthdetail) : that.birthdetail != null) return false;
        if (door != null ? !door.equals(that.door) : that.door != null) return false;
        if (doorStreet != null ? !doorStreet.equals(that.doorStreet) : that.doorStreet != null) return false;
        if (doordetail != null ? !doordetail.equals(that.doordetail) : that.doordetail != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (addressStreet != null ? !addressStreet.equals(that.addressStreet) : that.addressStreet != null)
            return false;
        if (addressdetail != null ? !addressdetail.equals(that.addressdetail) : that.addressdetail != null)
            return false;
        if (cultureCode != null ? !cultureCode.equals(that.cultureCode) : that.cultureCode != null) return false;
        if (sourceincomeCode != null ? !sourceincomeCode.equals(that.sourceincomeCode) : that.sourceincomeCode != null)
            return false;
        if (faithCode != null ? !faithCode.equals(that.faithCode) : that.faithCode != null) return false;
        if (haveemployment != null ? !haveemployment.equals(that.haveemployment) : that.haveemployment != null)
            return false;
        if (jobCode != null ? !jobCode.equals(that.jobCode) : that.jobCode != null) return false;
        if (headship != null ? !headship.equals(that.headship) : that.headship != null) return false;
        if (employunit != null ? !employunit.equals(that.employunit) : that.employunit != null) return false;
        if (employaddress != null ? !employaddress.equals(that.employaddress) : that.employaddress != null)
            return false;
        if (otherspecialty != null ? !otherspecialty.equals(that.otherspecialty) : that.otherspecialty != null)
            return false;
        if (specialidentityCode != null ? !specialidentityCode.equals(that.specialidentityCode) : that.specialidentityCode != null)
            return false;
        if (politicsCode != null ? !politicsCode.equals(that.politicsCode) : that.politicsCode != null) return false;
        if (istransientpop != null ? !istransientpop.equals(that.istransientpop) : that.istransientpop != null)
            return false;
        if (istempregist != null ? !istempregist.equals(that.istempregist) : that.istempregist != null) return false;
        if (havepermit != null ? !havepermit.equals(that.havepermit) : that.havepermit != null) return false;
        if (haveresidence != null ? !haveresidence.equals(that.haveresidence) : that.haveresidence != null)
            return false;
        if (isservice != null ? !isservice.equals(that.isservice) : that.isservice != null) return false;
        if (specialgroupCode != null ? !specialgroupCode.equals(that.specialgroupCode) : that.specialgroupCode != null)
            return false;
        if (haveseparation != null ? !haveseparation.equals(that.haveseparation) : that.haveseparation != null)
            return false;
        if (ismigrantworker != null ? !ismigrantworker.equals(that.ismigrantworker) : that.ismigrantworker != null)
            return false;
        if (nameofschool != null ? !nameofschool.equals(that.nameofschool) : that.nameofschool != null) return false;
        if (istraining != null ? !istraining.equals(that.istraining) : that.istraining != null) return false;
        if (havecertificate != null ? !havecertificate.equals(that.havecertificate) : that.havecertificate != null)
            return false;
        if (staturest != null ? !staturest.equals(that.staturest) : that.staturest != null) return false;
        if (avoirdupois != null ? !avoirdupois.equals(that.avoirdupois) : that.avoirdupois != null) return false;
        if (footsize != null ? !footsize.equals(that.footsize) : that.footsize != null) return false;
        if (shoelength != null ? !shoelength.equals(that.shoelength) : that.shoelength != null) return false;
        if (bodilyformCode != null ? !bodilyformCode.equals(that.bodilyformCode) : that.bodilyformCode != null)
            return false;
        if (faceformCode != null ? !faceformCode.equals(that.faceformCode) : that.faceformCode != null) return false;
        if (iseyeglass != null ? !iseyeglass.equals(that.iseyeglass) : that.iseyeglass != null) return false;
        if (shoesize != null ? !shoesize.equals(that.shoesize) : that.shoesize != null) return false;
        if (bloodtypeCode != null ? !bloodtypeCode.equals(that.bloodtypeCode) : that.bloodtypeCode != null)
            return false;
        if (gatherOrgCode != null ? !gatherOrgCode.equals(that.gatherOrgCode) : that.gatherOrgCode != null)
            return false;
        if (ipaddress != null ? !ipaddress.equals(that.ipaddress) : that.ipaddress != null) return false;
        if (gathererId != null ? !gathererId.equals(that.gathererId) : that.gathererId != null) return false;
        if (gatherDate != null ? !gatherDate.equals(that.gatherDate) : that.gatherDate != null) return false;
        if (gatherTypeId != null ? !gatherTypeId.equals(that.gatherTypeId) : that.gatherTypeId != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (isfingerrepeat != null ? !isfingerrepeat.equals(that.isfingerrepeat) : that.isfingerrepeat != null)
            return false;
        if (fingerrepeatno != null ? !fingerrepeatno.equals(that.fingerrepeatno) : that.fingerrepeatno != null)
            return false;
        if (taskSource != null ? !taskSource.equals(that.taskSource) : that.taskSource != null) return false;
        if (receiveDate != null ? !receiveDate.equals(that.receiveDate) : that.receiveDate != null) return false;
        if (isreturn != null ? !isreturn.equals(that.isreturn) : that.isreturn != null) return false;
        if (returnDate != null ? !returnDate.equals(that.returnDate) : that.returnDate != null) return false;
        if (annex != null ? !annex.equals(that.annex) : that.annex != null) return false;
        if (inputpsn != null ? !inputpsn.equals(that.inputpsn) : that.inputpsn != null) return false;
        if (inputDate != null ? !inputDate.equals(that.inputDate) : that.inputDate != null) return false;
        if (modifiedpsn != null ? !modifiedpsn.equals(that.modifiedpsn) : that.modifiedpsn != null) return false;
        if (modifiedDate != null ? !modifiedDate.equals(that.modifiedDate) : that.modifiedDate != null) return false;
        if (deletag != null ? !deletag.equals(that.deletag) : that.deletag != null) return false;
        if (schedule != null ? !schedule.equals(that.schedule) : that.schedule != null) return false;
        if (approval != null ? !approval.equals(that.approval) : that.approval != null) return false;
        if (dnaCode != null ? !dnaCode.equals(that.dnaCode) : that.dnaCode != null) return false;
        if (gatherCategory != null ? !gatherCategory.equals(that.gatherCategory) : that.gatherCategory != null)
            return false;
        if (personCategory != null ? !personCategory.equals(that.personCategory) : that.personCategory != null)
            return false;
        if (auditor != null ? !auditor.equals(that.auditor) : that.auditor != null) return false;
        if (auditedDate != null ? !auditedDate.equals(that.auditedDate) : that.auditedDate != null) return false;
        if (isregather != null ? !isregather.equals(that.isregather) : that.isregather != null) return false;
        if (gatherFingerMode != null ? !gatherFingerMode.equals(that.gatherFingerMode) : that.gatherFingerMode != null)
            return false;
        if (caseName != null ? !caseName.equals(that.caseName) : that.caseName != null) return false;
        if (caseClasses != null ? !caseClasses.equals(that.caseClasses) : that.caseClasses != null) return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;
        if (gatherFingerNum != null ? !gatherFingerNum.equals(that.gatherFingerNum) : that.gatherFingerNum != null)
            return false;
        if (fingerRemark != null ? !fingerRemark.equals(that.fingerRemark) : that.fingerRemark != null) return false;
        if (deprtmac != null ? !deprtmac.equals(that.deprtmac) : that.deprtmac != null) return false;
        if (gatherdepartcode != null ? !gatherdepartcode.equals(that.gatherdepartcode) : that.gatherdepartcode != null)
            return false;
        if (gatheruserid != null ? !gatheruserid.equals(that.gatheruserid) : that.gatheruserid != null) return false;
        if (gatherFingerDate != null ? !gatherFingerDate.equals(that.gatherFingerDate) : that.gatherFingerDate != null)
            return false;
        if (isSendTl != null ? !isSendTl.equals(that.isSendTl) : that.isSendTl != null) return false;
        if (caseBriefContents != null ? !caseBriefContents.equals(that.caseBriefContents) : that.caseBriefContents != null)
            return false;
        if (pushStatus != null ? !pushStatus.equals(that.pushStatus) : that.pushStatus != null) return false;
        if (pushDate != null ? !pushDate.equals(that.pushDate) : that.pushDate != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (dataSources != null ? !dataSources.equals(that.dataSources) : that.dataSources != null) return false;
        if (fingershowStatus != null ? !fingershowStatus.equals(that.fingershowStatus) : that.fingershowStatus != null)
            return false;
        if (cityCode != null ? !cityCode.equals(that.cityCode) : that.cityCode != null) return false;
        if (delayDeadline != null ? !delayDeadline.equals(that.delayDeadline) : that.delayDeadline != null)
            return false;
        if (fptGatherDepartCode != null ? !fptGatherDepartCode.equals(that.fptGatherDepartCode) : that.fptGatherDepartCode != null)
            return false;
        if (fptGatherDepartName != null ? !fptGatherDepartName.equals(that.fptGatherDepartName) : that.fptGatherDepartName != null)
            return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (blowCode != null ? !blowCode.equals(that.blowCode) : that.blowCode != null) return false;
        if (blowStreet != null ? !blowStreet.equals(that.blowStreet) : that.blowStreet != null) return false;
        if (blowDetail != null ? !blowDetail.equals(that.blowDetail) : that.blowDetail != null) return false;
        if (blowLongitude != null ? !blowLongitude.equals(that.blowLongitude) : that.blowLongitude != null)
            return false;
        if (blowLatitude != null ? !blowLatitude.equals(that.blowLatitude) : that.blowLatitude != null) return false;
        if (blowEastwest != null ? !blowEastwest.equals(that.blowEastwest) : that.blowEastwest != null) return false;
        if (blowNorthsouth != null ? !blowNorthsouth.equals(that.blowNorthsouth) : that.blowNorthsouth != null)
            return false;
        if (seq != null ? !seq.equals(that.seq) : that.seq != null) return false;
        if (cardid != null ? !cardid.equals(that.cardid) : that.cardid != null) return false;
        if (recordmark != null ? !recordmark.equals(that.recordmark) : that.recordmark != null) return false;
        if (recordsituation != null ? !recordsituation.equals(that.recordsituation) : that.recordsituation != null)
            return false;
        if (validDate != null ? !validDate.equals(that.validDate) : that.validDate != null) return false;
        if (arriveLocalDate != null ? !arriveLocalDate.equals(that.arriveLocalDate) : that.arriveLocalDate != null)
            return false;
        if (leaveLocalDate != null ? !leaveLocalDate.equals(that.leaveLocalDate) : that.leaveLocalDate != null)
            return false;
        if (dbSource != null ? !dbSource.equals(that.dbSource) : that.dbSource != null) return false;
        if (dbSourceDis != null ? !dbSourceDis.equals(that.dbSourceDis) : that.dbSourceDis != null) return false;
        if (jobDes != null ? !jobDes.equals(that.jobDes) : that.jobDes != null) return false;
        if (isXjssmz != null ? !isXjssmz.equals(that.isXjssmz) : that.isXjssmz != null) return false;
        if (passportNum != null ? !passportNum.equals(that.passportNum) : that.passportNum != null) return false;
        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) return false;
        if (foreignName != null ? !foreignName.equals(that.foreignName) : that.foreignName != null) return false;
        if (passportValidDate != null ? !passportValidDate.equals(that.passportValidDate) : that.passportValidDate != null)
            return false;
        if (visaPlace != null ? !visaPlace.equals(that.visaPlace) : that.visaPlace != null) return false;
        if (passportType != null ? !passportType.equals(that.passportType) : that.passportType != null) return false;
        if (visaDate != null ? !visaDate.equals(that.visaDate) : that.visaDate != null) return false;
        if (assistLevel != null ? !assistLevel.equals(that.assistLevel) : that.assistLevel != null) return false;
        if (assistBonus != null ? !assistBonus.equals(that.assistBonus) : that.assistBonus != null) return false;
        if (assistPurpose != null ? !assistPurpose.equals(that.assistPurpose) : that.assistPurpose != null)
            return false;
        if (assistRefPerson != null ? !assistRefPerson.equals(that.assistRefPerson) : that.assistRefPerson != null)
            return false;
        if (assistRefCase != null ? !assistRefCase.equals(that.assistRefCase) : that.assistRefCase != null)
            return false;
        if (assistValidDate != null ? !assistValidDate.equals(that.assistValidDate) : that.assistValidDate != null)
            return false;
        if (assistExplain != null ? !assistExplain.equals(that.assistExplain) : that.assistExplain != null)
            return false;
        if (assistDeptCode != null ? !assistDeptCode.equals(that.assistDeptCode) : that.assistDeptCode != null)
            return false;
        if (assistDeptName != null ? !assistDeptName.equals(that.assistDeptName) : that.assistDeptName != null)
            return false;
        if (assistDate != null ? !assistDate.equals(that.assistDate) : that.assistDate != null) return false;
        if (assistContacts != null ? !assistContacts.equals(that.assistContacts) : that.assistContacts != null)
            return false;
        if (assistNumber != null ? !assistNumber.equals(that.assistNumber) : that.assistNumber != null) return false;
        if (assistApproval != null ? !assistApproval.equals(that.assistApproval) : that.assistApproval != null)
            return false;
        if (assistSign != null ? !assistSign.equals(that.assistSign) : that.assistSign != null) return false;
        if (gatherdepartname != null ? !gatherdepartname.equals(that.gatherdepartname) : that.gatherdepartname != null)
            return false;
        if (gatherusername != null ? !gatherusername.equals(that.gatherusername) : that.gatherusername != null)
            return false;
        if (contrcaptureCode != null ? !contrcaptureCode.equals(that.contrcaptureCode) : that.contrcaptureCode != null)
            return false;
        if (smuggling != null ? !smuggling.equals(that.smuggling) : that.smuggling != null) return false;
        if (certificatetype != null ? !certificatetype.equals(that.certificatetype) : that.certificatetype != null)
            return false;
        if (certificateid != null ? !certificateid.equals(that.certificateid) : that.certificateid != null)
            return false;
        if (personType != null ? !personType.equals(that.personType) : that.personType != null) return false;
        if (caseClasses2 != null ? !caseClasses2.equals(that.caseClasses2) : that.caseClasses2 != null) return false;
        if (caseClasses3 != null ? !caseClasses3.equals(that.caseClasses3) : that.caseClasses3 != null) return false;
        if (caseNumber != null ? !caseNumber.equals(that.caseNumber) : that.caseNumber != null) return false;
        if (fptPath != null ? !fptPath.equals(that.fptPath) : that.fptPath != null) return false;
        if (dataIn != null ? !dataIn.equals(that.dataIn) : that.dataIn != null) return false;
        if (dataType != null ? !dataType.equals(that.dataType) : that.dataType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personid != null ? personid.hashCode() : 0;
        result = 31 * result + (idcardno != null ? idcardno.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (spellname != null ? spellname.hashCode() : 0);
        result = 31 * result + (usedname != null ? usedname.hashCode() : 0);
        result = 31 * result + (usedspell != null ? usedspell.hashCode() : 0);
        result = 31 * result + (aliasname != null ? aliasname.hashCode() : 0);
        result = 31 * result + (aliasspell != null ? aliasspell.hashCode() : 0);
        result = 31 * result + (sexCode != null ? sexCode.hashCode() : 0);
        result = 31 * result + (nativeplaceCode != null ? nativeplaceCode.hashCode() : 0);
        result = 31 * result + (nationCode != null ? nationCode.hashCode() : 0);
        result = 31 * result + (ifmarryCode != null ? ifmarryCode.hashCode() : 0);
        result = 31 * result + (toneCode != null ? toneCode.hashCode() : 0);
        result = 31 * result + (tone != null ? tone.hashCode() : 0);
        result = 31 * result + (birthdayst != null ? birthdayst.hashCode() : 0);
        result = 31 * result + (birthdayed != null ? birthdayed.hashCode() : 0);
        result = 31 * result + (birthCode != null ? birthCode.hashCode() : 0);
        result = 31 * result + (birthStreet != null ? birthStreet.hashCode() : 0);
        result = 31 * result + (birthdetail != null ? birthdetail.hashCode() : 0);
        result = 31 * result + (door != null ? door.hashCode() : 0);
        result = 31 * result + (doorStreet != null ? doorStreet.hashCode() : 0);
        result = 31 * result + (doordetail != null ? doordetail.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (addressStreet != null ? addressStreet.hashCode() : 0);
        result = 31 * result + (addressdetail != null ? addressdetail.hashCode() : 0);
        result = 31 * result + (cultureCode != null ? cultureCode.hashCode() : 0);
        result = 31 * result + (sourceincomeCode != null ? sourceincomeCode.hashCode() : 0);
        result = 31 * result + (faithCode != null ? faithCode.hashCode() : 0);
        result = 31 * result + (haveemployment != null ? haveemployment.hashCode() : 0);
        result = 31 * result + (jobCode != null ? jobCode.hashCode() : 0);
        result = 31 * result + (headship != null ? headship.hashCode() : 0);
        result = 31 * result + (employunit != null ? employunit.hashCode() : 0);
        result = 31 * result + (employaddress != null ? employaddress.hashCode() : 0);
        result = 31 * result + (otherspecialty != null ? otherspecialty.hashCode() : 0);
        result = 31 * result + (specialidentityCode != null ? specialidentityCode.hashCode() : 0);
        result = 31 * result + (politicsCode != null ? politicsCode.hashCode() : 0);
        result = 31 * result + (istransientpop != null ? istransientpop.hashCode() : 0);
        result = 31 * result + (istempregist != null ? istempregist.hashCode() : 0);
        result = 31 * result + (havepermit != null ? havepermit.hashCode() : 0);
        result = 31 * result + (haveresidence != null ? haveresidence.hashCode() : 0);
        result = 31 * result + (isservice != null ? isservice.hashCode() : 0);
        result = 31 * result + (specialgroupCode != null ? specialgroupCode.hashCode() : 0);
        result = 31 * result + (haveseparation != null ? haveseparation.hashCode() : 0);
        result = 31 * result + (ismigrantworker != null ? ismigrantworker.hashCode() : 0);
        result = 31 * result + (nameofschool != null ? nameofschool.hashCode() : 0);
        result = 31 * result + (istraining != null ? istraining.hashCode() : 0);
        result = 31 * result + (havecertificate != null ? havecertificate.hashCode() : 0);
        result = 31 * result + (staturest != null ? staturest.hashCode() : 0);
        result = 31 * result + (avoirdupois != null ? avoirdupois.hashCode() : 0);
        result = 31 * result + (footsize != null ? footsize.hashCode() : 0);
        result = 31 * result + (shoelength != null ? shoelength.hashCode() : 0);
        result = 31 * result + (bodilyformCode != null ? bodilyformCode.hashCode() : 0);
        result = 31 * result + (faceformCode != null ? faceformCode.hashCode() : 0);
        result = 31 * result + (iseyeglass != null ? iseyeglass.hashCode() : 0);
        result = 31 * result + (shoesize != null ? shoesize.hashCode() : 0);
        result = 31 * result + (bloodtypeCode != null ? bloodtypeCode.hashCode() : 0);
        result = 31 * result + (gatherOrgCode != null ? gatherOrgCode.hashCode() : 0);
        result = 31 * result + (ipaddress != null ? ipaddress.hashCode() : 0);
        result = 31 * result + (gathererId != null ? gathererId.hashCode() : 0);
        result = 31 * result + (gatherDate != null ? gatherDate.hashCode() : 0);
        result = 31 * result + (gatherTypeId != null ? gatherTypeId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (isfingerrepeat != null ? isfingerrepeat.hashCode() : 0);
        result = 31 * result + (fingerrepeatno != null ? fingerrepeatno.hashCode() : 0);
        result = 31 * result + (taskSource != null ? taskSource.hashCode() : 0);
        result = 31 * result + (receiveDate != null ? receiveDate.hashCode() : 0);
        result = 31 * result + (isreturn != null ? isreturn.hashCode() : 0);
        result = 31 * result + (returnDate != null ? returnDate.hashCode() : 0);
        result = 31 * result + (annex != null ? annex.hashCode() : 0);
        result = 31 * result + (inputpsn != null ? inputpsn.hashCode() : 0);
        result = 31 * result + (inputDate != null ? inputDate.hashCode() : 0);
        result = 31 * result + (modifiedpsn != null ? modifiedpsn.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        result = 31 * result + (deletag != null ? deletag.hashCode() : 0);
        result = 31 * result + (schedule != null ? schedule.hashCode() : 0);
        result = 31 * result + (approval != null ? approval.hashCode() : 0);
        result = 31 * result + (dnaCode != null ? dnaCode.hashCode() : 0);
        result = 31 * result + (gatherCategory != null ? gatherCategory.hashCode() : 0);
        result = 31 * result + (personCategory != null ? personCategory.hashCode() : 0);
        result = 31 * result + (auditor != null ? auditor.hashCode() : 0);
        result = 31 * result + (auditedDate != null ? auditedDate.hashCode() : 0);
        result = 31 * result + (isregather != null ? isregather.hashCode() : 0);
        result = 31 * result + (gatherFingerMode != null ? gatherFingerMode.hashCode() : 0);
        result = 31 * result + (caseName != null ? caseName.hashCode() : 0);
        result = 31 * result + (caseClasses != null ? caseClasses.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (gatherFingerNum != null ? gatherFingerNum.hashCode() : 0);
        result = 31 * result + (fingerRemark != null ? fingerRemark.hashCode() : 0);
        result = 31 * result + (deprtmac != null ? deprtmac.hashCode() : 0);
        result = 31 * result + (gatherdepartcode != null ? gatherdepartcode.hashCode() : 0);
        result = 31 * result + (gatheruserid != null ? gatheruserid.hashCode() : 0);
        result = 31 * result + (gatherFingerDate != null ? gatherFingerDate.hashCode() : 0);
        result = 31 * result + (isSendTl != null ? isSendTl.hashCode() : 0);
        result = 31 * result + (caseBriefContents != null ? caseBriefContents.hashCode() : 0);
        result = 31 * result + (pushStatus != null ? pushStatus.hashCode() : 0);
        result = 31 * result + (pushDate != null ? pushDate.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (dataSources != null ? dataSources.hashCode() : 0);
        result = 31 * result + (fingershowStatus != null ? fingershowStatus.hashCode() : 0);
        result = 31 * result + (cityCode != null ? cityCode.hashCode() : 0);
        result = 31 * result + (delayDeadline != null ? delayDeadline.hashCode() : 0);
        result = 31 * result + (fptGatherDepartCode != null ? fptGatherDepartCode.hashCode() : 0);
        result = 31 * result + (fptGatherDepartName != null ? fptGatherDepartName.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (blowCode != null ? blowCode.hashCode() : 0);
        result = 31 * result + (blowStreet != null ? blowStreet.hashCode() : 0);
        result = 31 * result + (blowDetail != null ? blowDetail.hashCode() : 0);
        result = 31 * result + (blowLongitude != null ? blowLongitude.hashCode() : 0);
        result = 31 * result + (blowLatitude != null ? blowLatitude.hashCode() : 0);
        result = 31 * result + (blowEastwest != null ? blowEastwest.hashCode() : 0);
        result = 31 * result + (blowNorthsouth != null ? blowNorthsouth.hashCode() : 0);
        result = 31 * result + (seq != null ? seq.hashCode() : 0);
        result = 31 * result + (cardid != null ? cardid.hashCode() : 0);
        result = 31 * result + (recordmark != null ? recordmark.hashCode() : 0);
        result = 31 * result + (recordsituation != null ? recordsituation.hashCode() : 0);
        result = 31 * result + (validDate != null ? validDate.hashCode() : 0);
        result = 31 * result + (arriveLocalDate != null ? arriveLocalDate.hashCode() : 0);
        result = 31 * result + (leaveLocalDate != null ? leaveLocalDate.hashCode() : 0);
        result = 31 * result + (dbSource != null ? dbSource.hashCode() : 0);
        result = 31 * result + (dbSourceDis != null ? dbSourceDis.hashCode() : 0);
        result = 31 * result + (jobDes != null ? jobDes.hashCode() : 0);
        result = 31 * result + (isXjssmz != null ? isXjssmz.hashCode() : 0);
        result = 31 * result + (passportNum != null ? passportNum.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (foreignName != null ? foreignName.hashCode() : 0);
        result = 31 * result + (passportValidDate != null ? passportValidDate.hashCode() : 0);
        result = 31 * result + (visaPlace != null ? visaPlace.hashCode() : 0);
        result = 31 * result + (passportType != null ? passportType.hashCode() : 0);
        result = 31 * result + (visaDate != null ? visaDate.hashCode() : 0);
        result = 31 * result + (assistLevel != null ? assistLevel.hashCode() : 0);
        result = 31 * result + (assistBonus != null ? assistBonus.hashCode() : 0);
        result = 31 * result + (assistPurpose != null ? assistPurpose.hashCode() : 0);
        result = 31 * result + (assistRefPerson != null ? assistRefPerson.hashCode() : 0);
        result = 31 * result + (assistRefCase != null ? assistRefCase.hashCode() : 0);
        result = 31 * result + (assistValidDate != null ? assistValidDate.hashCode() : 0);
        result = 31 * result + (assistExplain != null ? assistExplain.hashCode() : 0);
        result = 31 * result + (assistDeptCode != null ? assistDeptCode.hashCode() : 0);
        result = 31 * result + (assistDeptName != null ? assistDeptName.hashCode() : 0);
        result = 31 * result + (assistDate != null ? assistDate.hashCode() : 0);
        result = 31 * result + (assistContacts != null ? assistContacts.hashCode() : 0);
        result = 31 * result + (assistNumber != null ? assistNumber.hashCode() : 0);
        result = 31 * result + (assistApproval != null ? assistApproval.hashCode() : 0);
        result = 31 * result + (assistSign != null ? assistSign.hashCode() : 0);
        result = 31 * result + (gatherdepartname != null ? gatherdepartname.hashCode() : 0);
        result = 31 * result + (gatherusername != null ? gatherusername.hashCode() : 0);
        result = 31 * result + (contrcaptureCode != null ? contrcaptureCode.hashCode() : 0);
        result = 31 * result + (smuggling != null ? smuggling.hashCode() : 0);
        result = 31 * result + (certificatetype != null ? certificatetype.hashCode() : 0);
        result = 31 * result + (certificateid != null ? certificateid.hashCode() : 0);
        result = 31 * result + (personType != null ? personType.hashCode() : 0);
        result = 31 * result + (caseClasses2 != null ? caseClasses2.hashCode() : 0);
        result = 31 * result + (caseClasses3 != null ? caseClasses3.hashCode() : 0);
        result = 31 * result + (caseNumber != null ? caseNumber.hashCode() : 0);
        result = 31 * result + (fptPath != null ? fptPath.hashCode() : 0);
        result = 31 * result + (dataIn != null ? dataIn.hashCode() : 0);
        result = 31 * result + (dataType != null ? dataType.hashCode() : 0);
        return result;
    }
}
