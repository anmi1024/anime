package com.anmi.anime.queryQueue.define;

import com.anmi.anime.annotation.FieldLength;
import com.anmi.anime.annotation.Length;
import com.anmi.anime.exception.StructException;
import com.anmi.anime.queryQueue.struct.MicStruct;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by wangjue on 2017/9/14.
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
    private int $$ItemFlag;//检索标记 1：mnt;8：bin;9：mnt && bin
    @FieldLength
    @Length(value = 1)
    private int $$ItemType;//类型(//仅掌纹或掌纹+文本:2;//仅滚动指纹或拇指+文本:1;//仅平面指纹或平面指纹+文本:8)
    @FieldLength
    @Length(value = 1)
    private int $$ItemData;//指位，现场为0;指位处理,与8.0一致,滚指[1,10];平指[11,20];掌纹[1,2]
    @FieldLength
    @Length(value = 1)
    private int $$IsLatent;//0:template;1:latent
    @FieldLength
    @Length(value = -1) //未知长度，以实际长度为准
    private byte[] $$Mnt;//特征
    @FieldLength
    @Length(value = -1)
    private byte[] $$Img;//原图
    @FieldLength
    @Length(value = -1)
    private byte[] $$Cpr;//压缩图
    @FieldLength
    @Length(value = -1)
    private byte[] $$Bin;//纹线

    public MicAnnotationObject() {
    }

    public MicAnnotationObject(int $$ItemIndex, int $$ItemFlag, int $$ItemType, int $$ItemData, int $$IsLatent, byte[] $$Mnt, byte[] $$Img, byte[] $$Cpr, byte[] $$Bin) {
        this.$$ItemIndex = $$ItemIndex;
        this.$$ItemFlag = $$ItemFlag;
        this.$$ItemType = $$ItemType;
        this.$$ItemData = $$ItemData;
        this.$$IsLatent = $$IsLatent;
        this.$$Mnt = $$Mnt;
        this.$$Img = $$Img;
        this.$$Cpr = $$Cpr;
        this.$$Bin = $$Bin;
    }

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


    public byte[] buildMICByteBuf(int index) throws NoSuchMethodException,InvocationTargetException,IllegalAccessException {
        return super.buildMICByteBuf(this,index);
    }

    public List readMICByteBuf(byte[] byteBuf) throws NoSuchMethodException,InvocationTargetException,IllegalAccessException,InstantiationException {
        return super.readMICByteBuf(byteBuf, this);
    }
}
