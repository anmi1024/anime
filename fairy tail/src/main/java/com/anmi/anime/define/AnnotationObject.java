package com.anmi.anime.define;


import com.anmi.anime.fpt.FPTBase;

/**
 * Created by wangjue on 2017/6/22.
 */
public class AnnotationObject {

    @Length(value = 6)
    private String dataLength;//指纹信息长度
    @Length(value = 2)
    private String sendNo;//发送序号
    @Length(value = 2)
    private String fgp;//指位
    @Length(value = 1)
    private String extractMethod;//提取特征方法
    @Length(value = 1)
    private String pattern1;//指纹纹型分类1
    @Length(value = 1)
    private String pattern2;//指纹纹型分类1
    @Length(value = 5)
    private String fingerDirection;//指纹方向
    @Length(value = 14)
    private String centerPoint;//中心点
    @Length(value = 14)
    private String subCenterPoint;//副中心
    @Length(value = 14)
    private String leftTriangle;//左三角
    @Length(value = 14)
    private String rightTriangle;//右三角
    @Length(value = 3)
    private String featureCount;//特征个数
    @Length(value = 1800)
    private String feature;//特征点
    @Length(value = 4)
    private String customInfoLength;//自定义信息长度
    @LengthRef(value = "customInfoLength")
    private byte[] customInfo;// 自定义信息
    @Length(value = 3)
    private String imgHorizontalLength;//图像水平方向长度
    @Length(value = 3)
    private String imgVerticalLength;//图像垂直方向长度
    @Length(value = 3)
    private String dpi;//图像分辨率
    @Length(value = 4)
    private String imgCompressMethod;//图像压缩方法
    @Length(value = 6)
    private String imgDataLenght;//图像长度
    @LengthRef(value = "imgDataLenght")
    private byte[] imgData;//图像数据

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
