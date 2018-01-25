package com.anmi.anime.fpt;

/**
 * Created by wangjue on 2017/10/11.
 */
public class FPTProperties {
    private String imgCompressMethod;
    private String imgHorizontalLength;
    private String imgVerticalLength;
    private String dpi;
    private String fgp;
    private byte[] imgData;

    public FPTProperties() {
    }

    public FPTProperties(String imgCompressMethod, String imgHorizontalLength, String imgVerticalLength, String dpi, String fgp, byte[] imgData) {
        this.imgCompressMethod = imgCompressMethod;
        this.imgHorizontalLength = imgHorizontalLength;
        this.imgVerticalLength = imgVerticalLength;
        this.dpi = dpi;
        this.fgp = fgp;
        this.imgData = imgData;
    }

    public String getImgCompressMethod() {
        return imgCompressMethod;
    }

    public void setImgCompressMethod(String imgCompressMethod) {
        this.imgCompressMethod = imgCompressMethod;
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

    public String getFgp() {
        return fgp;
    }

    public void setFgp(String fgp) {
        this.fgp = fgp;
    }

    public byte[] getImgData() {
        return imgData;
    }

    public void setImgData(byte[] imgData) {
        this.imgData = imgData;
    }
}
