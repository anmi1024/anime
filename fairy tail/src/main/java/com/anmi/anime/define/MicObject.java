package com.anmi.anime.define;

/**
 * Created by wangjue on 2017/6/16.
 */
public class MicObject {
    private String $$MIC;
    private int $$ItemIndex;
    private int $$ItemFlag;
    private int $$ItemType;
    private int $$ItemData;
    private int $$IsLatent;
    private byte[] $$Mnt;
    private byte[] $$Img;
    private byte[] $$Cpr;
    private byte[] $$Bin;

    public MicObject() {
    }

    public MicObject(int $$ItemIndex, int $$ItemFlag, int $$ItemType, int $$ItemData, int $$IsLatent, byte[] $$Mnt, byte[] $$Img, byte[] $$Cpr, byte[] $$Bin) {
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
}
