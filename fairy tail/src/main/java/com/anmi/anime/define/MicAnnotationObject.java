package com.anmi.anime.define;

import com.anmi.anime.struct.MicStruct;

import java.util.List;

/**
 * Created by wangjue on 2017/6/19.
 */
public class MicAnnotationObject extends MicStruct {
    @FieldLength
    @Length(value = 0)//长度为0,即同样存四个字节
    private String $$MIC;
    @FieldLength
    @Length(value = 1)
    private int $$ItemIndex;
    @FieldLength
    @Length(value = 1)
    private int $$ItemFlag;
    @FieldLength
    @Length(value = 1)
    private int $$ItemType;
    @FieldLength
    @Length(value = 1)
    private int $$ItemData;
    @FieldLength
    @Length(value = 1)
    private int $$IsLatent;
    @FieldLength
    @Length(value = -1) //未知长度，以实际长度为准
    private byte[] $$Mnt;
    @FieldLength
    @Length(value = -1)
    private byte[] $$Img;
    @FieldLength
    @Length(value = -1)
    private byte[] $$Cpr;
    @FieldLength
    @Length(value = -1)
    private byte[] $$Bin;

    public String get$$MIC() {
        return $$MIC;
    }

    public void set$$MIC(String $$MIC) {
        this.$$MIC = $$MIC;
    }

    public int get$$ItemIndex() {
        return $$ItemIndex;
    }

    public void set$$ItemIndex(int $$ItemIndex) {
        this.$$ItemIndex = $$ItemIndex;
    }

    public int get$$ItemFlag() {
        return $$ItemFlag;
    }

    public void set$$ItemFlag(int $$ItemFlag) {
        this.$$ItemFlag = $$ItemFlag;
    }

    public int get$$ItemType() {
        return $$ItemType;
    }

    public void set$$ItemType(int $$ItemType) {
        this.$$ItemType = $$ItemType;
    }

    public int get$$ItemData() {
        return $$ItemData;
    }

    public void set$$ItemData(int $$ItemData) {
        this.$$ItemData = $$ItemData;
    }

    public int get$$IsLatent() {
        return $$IsLatent;
    }

    public void set$$IsLatent(int $$IsLatent) {
        this.$$IsLatent = $$IsLatent;
    }

    public byte[] get$$Mnt() {
        return $$Mnt;
    }

    public void set$$Mnt(byte[] $$Mnt) {
        this.$$Mnt = $$Mnt;
    }

    public byte[] get$$Img() {
        return $$Img;
    }

    public void set$$Img(byte[] $$Img) {
        this.$$Img = $$Img;
    }

    public byte[] get$$Cpr() {
        return $$Cpr;
    }

    public void set$$Cpr(byte[] $$Cpr) {
        this.$$Cpr = $$Cpr;
    }

    public byte[] get$$Bin() {
        return $$Bin;
    }

    public void set$$Bin(byte[] $$Bin) {
        this.$$Bin = $$Bin;
    }


    public byte[] buildMICByteBuf(int index){
        try {
            return super.buildMICByteBuf(this,index);
        } catch (Throwable t) {
            throw new IllegalArgumentException(t.getMessage());
        }
    }

    public List readMICByteBuf(byte[] byteBuf){
        try {
            return super.readMICByteBuf(byteBuf, this);
        } catch (Throwable t) {
            throw new IllegalArgumentException(t.getMessage());
        }
    }
}
