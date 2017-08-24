package com.anmi.anime;

import com.anmi.anime.define.MicObject;
import org.apache.commons.io.FileUtils;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static com.anmi.anime.ByteUtil.*;

/**
 * Created by wangjue on 2017/6/15.
 */
public class NettyUtil {

    public static MicObject buildObject() throws Throwable{
        byte[] mnt = FileUtils.readFileToByteArray(new File("D://mnt.mnt"));
        MicObject mic = new MicObject();
        mic.set$$ItemIndex(1);
        mic.set$$ItemFlag(1);
        mic.set$$ItemType(1);
        mic.set$$ItemData(9);
        mic.set$$IsLatent(0);
        mic.set$$Mnt(mnt);
        return mic;
    }

    private static void byteBufRead(byte[] byteBuf) throws Throwable{
        List<Object> list = new ArrayList();
        ChannelBuffer buf = ChannelBuffers.wrappedBuffer(byteBuf);
        int total = buf.writerIndex();
        buf.markReaderIndex();
        while (buf.readerIndex() < total){
            Class clazz = MicObject.class;
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                String name = byteBufReadName(buf,32);
                System.out.println(name);
                VALID_STRUCT_NAME(name, field.getName());
                if (field.getType() == String.class) buf.readBytes(4);
                else {
                    int itemLength = byteBufReadItemLength(buf);
                    byte[] itemValue;
                    if (itemLength == 0) itemValue = null;
                    else itemValue = byteBufReadItemValue(buf, itemLength);
                    Method method = clazz.getMethod("set"+name,field.getType());
                    if (field.getType() == int.class) {
                        System.out.println(name + "," + itemLength + "," + byteToInt4_little(itemValue));
                        method.invoke(clazz.newInstance(),byteToInt4_little(itemValue));
                    }
                    else {
                        System.out.println(name + "," + itemLength + "," + itemValue);
                        method.invoke(clazz.newInstance(),itemValue);
                    }
                    Method method2 = clazz.getMethod("get"+name);
                    Object value = method2.invoke(clazz.newInstance());
                    System.out.println(value);
                }
            }
            //list.add(clazz.cast(MicObject.class));
        }
        System.out.println(list.size());
    }



    private static byte[] byteBufBuildByObject(MicObject mic) throws Throwable{
        ChannelBuffer buf = ChannelBuffers.dynamicBuffer();
        buf.markWriterIndex();
        Class clazz = mic.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            Class fieldType = field.getType();
            Method method = clazz.getMethod("get"+fieldName);
            Object value = method.invoke(mic);
            buf.writeBytes(buf_write_name(fieldName,32));
            if (fieldType == String.class) {
                buf.writeBytes(buf_write_4_byte(0));
            }
            else if (fieldType == int.class) {
                buf.writeBytes(buf_write_4_byte(1));
                buf.writeBytes(buf_write_value(1,intToByteArray((int)value)));
            }
            else if (fieldType == byte[].class) {
                int length = value == null ? 0 : ((byte[])value).length;
                buf.writeBytes(buf_write_4_byte(length));
                buf.writeBytes(buf_write_value(length,(byte[])value));
            }
            else System.out.println("unkonm----------------"+fieldName);

        }
        int read = buf.readableBytes();
        ChannelBuffer result = buf.copy(0,read);
        FileUtils.writeByteArrayToFile(new File("D://buff.dat"),result.array());
        return result.array();
    }

    @Deprecated
    private static byte[] byteBufBuild() throws Throwable{
        ChannelBuffer buf = ChannelBuffers.dynamicBuffer();
        buf.markWriterIndex();
        buf.writeBytes(buf_write_name("$$MIC",32));
        buf.writeBytes(buf_write_4_byte(0));

        buf.writeBytes(buf_write_name("$$ItemIndex",32));
        buf.writeBytes(buf_write_4_byte(1));
        buf.writeBytes(buf_write_value(1,intToByteArray(1)));

        buf.writeBytes(buf_write_name("$$ItemFlag",32));
        buf.writeBytes(buf_write_4_byte(1));
        buf.writeBytes(buf_write_value(1,intToByteArray(1)));

        buf.writeBytes(buf_write_name("$$ItemType",32));
        buf.writeBytes(buf_write_4_byte(1));
        buf.writeBytes(buf_write_value(1,intToByteArray(1)));

        buf.writeBytes(buf_write_name("$$ItemData",32));
        buf.writeBytes(buf_write_4_byte(1));
        buf.writeBytes(buf_write_value(1,intToByteArray(1)));

        buf.writeBytes(buf_write_name("$$IsLatent",32));
        buf.writeBytes(buf_write_4_byte(1));
        buf.writeBytes(buf_write_value(1,intToByteArray(0)));

        byte[] mnt = FileUtils.readFileToByteArray(new File("D://mnt.mnt"));
        buf.writeBytes(buf_write_name("$$Mnt",32));
        buf.writeBytes(buf_write_4_byte(mnt.length));
        buf.writeBytes(buf_write_value(mnt.length,mnt));

        buf.writeBytes(buf_write_name("$$Img",32));
        buf.writeBytes(buf_write_4_byte(0));
        buf.writeBytes(buf_write_value(0, intToByteArray(1)));

        buf.writeBytes(buf_write_name("$$Cpr",32));
        buf.writeBytes(buf_write_4_byte(0));
        buf.writeBytes(buf_write_value(0, intToByteArray(1)));

        buf.writeBytes(buf_write_name("$$Bin",32));
        buf.writeBytes(buf_write_4_byte(0));
        buf.writeBytes(buf_write_value(0, intToByteArray(1)));

        int read = buf.readableBytes();
        ChannelBuffer result = buf.copy(0,read);
        FileUtils.writeByteArrayToFile(new File("D://buf.dat"),result.array());
        return result.array();
    }



    public static void main(String[] args) {
        try {
            byte[] mnt = FileUtils.readFileToByteArray(new File("D://mnt.mnt"));
            byte[] bin = FileUtils.readFileToByteArray(new File("D://bin.bin"));
            MicObject mic = new MicObject(2,1,1,1,1,mnt,null,null,bin);
            byte[] byteBuf = byteBufBuildByObject(buildObject());
            byte[] byteBuf2 = byteBufBuildByObject(mic);
            byteBufRead(ByteUtil.concatArray(byteBuf,byteBuf2));

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
