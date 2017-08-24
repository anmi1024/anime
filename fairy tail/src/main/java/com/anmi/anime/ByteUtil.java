package com.anmi.anime;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * Created by wangjue on 2017/6/19.
 */
public class ByteUtil {

    //定义结构类型名称
    public static byte[] buf_write_name(String itemName,int length) {
        ByteBuffer bfName = ByteBuffer.allocate(length);
        bfName.put(itemName.getBytes());
        return bfName.array();
    }
    //结构子项长度，4字节 高位
    public static byte[] buf_write_4_byte(int value) {
        ByteBuffer bfName = ByteBuffer.allocate(4);
        bfName.put(intToByteArray(value));
        return bfName.array();
    }

    //结构子项长度，4字节 低位
    public static byte[] buf_write_4_byte_LITTLE(int value) {
        ByteBuffer bfName = ByteBuffer.allocate(4);
        bfName.put(intToByteArray_LITTLE(value));
        return bfName.array();
    }
    //结构子项，长度为1 则存四字节 低位，实际长度不变
    public static byte[] buf_write_value(int length,byte[] itemValue) {
        if (length == 0) return ByteBuffer.allocate(0).array();
        length = length == 1 ? 4 : length;
        ByteBuffer bfValue = ByteBuffer.allocate(length);
        if (length == 4) bfValue.put(buf_write_4_byte_LITTLE(byteArrayToInt(itemValue)));
        else bfValue.put(itemValue);
        return bfValue.array();
    }

    //验证类型名
    public static void VALID_STRUCT_NAME(String currentName,String expectedName) throws Throwable{
        if(!currentName.startsWith(expectedName))
            throw new IllegalAccessException(String.format("expectName=%s actual =%s",expectedName,currentName));
    }

    //读取结构类型名
    public static String byteBufReadName(ChannelBuffer buf,int len){
        byte[] name = buf.readBytes(len).array();
        return new String(name).trim();
    }
    //读取结构项长度
    public static int byteBufReadItemLength(ChannelBuffer buf){
        byte[] itemLength = buf.readBytes(4).array();
        return byteArrayToInt(itemLength);
    }
    //读取结构项
    public static byte[] byteBufReadItemValue(ChannelBuffer buf,int itemLength){
        itemLength = itemLength == 1 ? 4 : itemLength;
        byte[] itemValue = buf.readBytes(itemLength).array();
        return itemValue;
    }

    /**
     * int to byte[] high - little
     * @param i
     * @return
     */
    public static byte[] intToByteArray(int i) {
        byte[] result = new byte[4];
        //由高位到低位
        result[0] = (byte)((i >> 24) & 0xFF);
        result[1] = (byte)((i >> 16) & 0xFF);
        result[2] = (byte)((i >> 8) & 0xFF);
        result[3] = (byte)(i & 0xFF);
        return result;
    }

    /**
     * int to byte[] little - high
     * @param i
     * @return
     */
    public static byte[] intToByteArray_LITTLE(int i) {
        byte[] result = new byte[4];
        //由低位到高位
        result[3] = (byte)((i >> 24) & 0xFF);
        result[2] = (byte)((i >> 16) & 0xFF);
        result[1] = (byte)((i >> 8) & 0xFF);
        result[0] = (byte)(i & 0xFF);
        return result;
    }
    public static int byteArray2Int(byte[] b, int start, int len){
        if(b.length < start || len > 4){
            return 0;
        }
        int value = 0;
        int end = start + len;
        for (int i = start; i < end; i++) {
            value = value << 8 | (b[i] & 0xff) ;
        }
        return value;
    }
    /**
     * byte[]转int
     * @param bytes
     * @return
     */
    public static int byteArrayToInt(byte[] bytes) {
        int value= 0;
        //由高位到低位
        for (int i = 0; i < 4; i++) {
            int shift= (4 - 1 - i) * 8;
            value +=(bytes[i] & 0x000000FF) << shift;//往高位游
        }
        return value;
    }
    public static int byteArrayToInt(byte[] arrByte,int len){
        if (len < 0) return 0;
        else {
            int value= 0;
            //由高位到低位
            for (int i = 0; i < len; i++) {
                int shift= (len - 1 - i) * 8;
                value +=(arrByte[i] & 0x000000FF) << shift;//往高位游
            }
            return value;
        }
    }
    public static byte[] intToByteArray(int value,int len) {
        byte[] targets = new byte[len];
        for (int i = 0; i < len; i++) {
            int offset = (targets.length - 1 - i) * 8;
            targets[i] = (byte) ((value >>> offset) & 0xff);
        }
        return targets;
    }
    public static byte[] longToByteArray(long value,int len) {
        byte[] targets = new byte[len];
        for (int i = 0; i < len; i++) {
            int offset = (targets.length - 1 - i) * 8;
            targets[i] = (byte) ((value >>> offset) & 0xff);
        }
        return targets;
    }
    public static byte[] shortToByteArray(short value,int len) {
        byte[] targets = new byte[len];
        for (int i = 0; i < len; i++) {
            int offset = (targets.length - 1 - i) * 8;
            targets[i] = (byte) ((value >>> offset) & 0xff);
        }
        return targets;
    }


    public static int byteToInt4_hight(byte[] arrByte){

        return ((arrByte[0]*256 + arrByte[1])*256 + arrByte[2])*256 + arrByte[3] ;
    }
    public static int byteToInt4_little(byte[] arrByte){

        return ((arrByte[3]*256 + arrByte[2])*256 + arrByte[1])*256 + arrByte[0] ;
    }
    /**
     * 字节数组转字符串
     * @param b
     * @return
     */
    public static String byteToString(byte[] b) {
        String key = "";
        char[] c = new char[32];
        for (int i = 0;i<b.length;i++) {
            if (b[i]==0)
                break;
            c[i] = (char) (((c[i] & 0xFF) << 8) | (b[i] & 0xFF));
            key += c[i];
        }
        return key;
    }
    public static String byteToString(byte[] b,int len) {
        String key = "";
        char[] c = new char[len];
        for (int i = 0;i<b.length;i++) {
            if (b[i]==0)
                break;
            c[i] = (char) (((c[i] & 0xFF) << 8) | (b[i] & 0xFF));
            key += c[i];
        }
        return key.trim();
    }

    public static String byteToString(byte[] b,Charset encoding,boolean noTrim) {
        if (noTrim) return new String(b,encoding);
        return new String(b,encoding).trim();
    }

    /**
     * string to byte[]
     * @param value
     * @param len
     * @return
     */
    public static byte[] stringToByte(String value, int len) {
        byte[] bytes = new byte[len];
        byte[] vBytes = value.getBytes();
        System.arraycopy(vBytes,0,bytes,0,vBytes.length);
        return bytes;
    }
    public static byte[] stringToByte(String value, int len, Charset encode) {
        byte[] bytes = new byte[len];
        byte[] vBytes = value.getBytes(encode);
        System.arraycopy(vBytes,0,bytes,0,vBytes.length);
        return bytes;
    }
    //指定长度byte
    public static byte[] byteToByteForLength(byte[] value, int len){
        byte[] bytes = new byte[len];
        System.arraycopy(value,0,bytes,0,value.length);
        return bytes;
    }


    public static byte[] concatArray(byte[] ... args) {
        int totalLength = 0;
        for (byte[] arg : args) {
            totalLength += arg.length;
        }
        ChannelBuffer buf = ChannelBuffers.buffer(totalLength);
        for (byte[] arg : args) {
            buf.writeBytes(arg);
        }
        return buf.array();
    }

    public static byte[] cutByteArray(byte[] src,int offset,int len) {
        byte[] dest = ByteBuffer.allocate(len).array();
        System.arraycopy(src,offset,dest,0,len);
        return dest;
    }
    public static String afisDateTimeToString(byte[] b) {
        String date = "";
        int ny = (int)((char)(b[7] & 0xFF) * 256 + (char)(b[6] & 0xFF));
        int nM = (int)(char)(b[5] & 0xFF) + 1;
        int nd = (int)(char)(b[4] & 0xFF);
        int nh = (int)(char)(b[3] & 0xFF);
        int nm = (int)(char)(b[2] & 0xFF);
        int ns = (int)((char)(b[1]&0xFF) * 256 + (char)(b[0]&0xFF)) / 1000;
        String nMs = nM < 10 ? "0"+nM : String.valueOf(nM);
        String nds = nd < 10 ? "0"+nd : String.valueOf(nd);
        String nhs = nh < 10 ? "0"+nh : String.valueOf(nh);
        String nms = nm < 10 ? "0"+nm : String.valueOf(nm);
        String sns = ns < 10 ? "0"+ns : String.valueOf(ns);

        date = ny + "-" + nMs + "-" + nds + " " + nhs + ":" + nms + ":" + sns;
        return date;
    }

    public static short ubyteToShort(byte n)
    {
        return (short)(n & 0xFF);
    }
    public static short char2ToInt2(byte[] b, int startidx)
    {
        return (short)(b[startidx] << 8 | ubyteToShort(b[(startidx + 1)]));
    }
    public static void int2ToChar2(short a, byte[] b, int startidx)
    {
        b[startidx] = (byte)(a >> 8 & 0xFF);
        b[(startidx + 1)] = (byte)(a & 0xFF);
    }

    public static byte[] getBytesFromFile(String filePath){
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
}
