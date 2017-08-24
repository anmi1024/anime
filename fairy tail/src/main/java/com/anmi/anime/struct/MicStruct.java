package com.anmi.anime.struct;

import com.anmi.anime.define.FieldLength;
import com.anmi.anime.define.Length;
import com.anmi.anime.define.MicAnnotationObject;
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
 * Created by wangjue on 2017/6/19.
 */
public class MicStruct {

    public static MicAnnotationObject buildMicAnnotationObject() throws Throwable{
        byte[] mnt = FileUtils.readFileToByteArray(new File("D://mnt.mnt"));
        MicAnnotationObject mic = new MicAnnotationObject();
        mic.set$$ItemIndex(0);
        mic.set$$ItemFlag(1);
        mic.set$$ItemType(1);
        mic.set$$ItemData(9);
        mic.set$$IsLatent(0);
        mic.set$$Mnt(mnt);
        return mic;
    }
    public static MicAnnotationObject buildMicAnnotationObject1() throws Throwable{
        byte[] mnt = FileUtils.readFileToByteArray(new File("D://mnt.mnt"));
        byte[] bin = FileUtils.readFileToByteArray(new File("D://bin.bin"));
        MicAnnotationObject mic = new MicAnnotationObject();
        mic.set$$ItemIndex(1);
        mic.set$$ItemFlag(2);
        mic.set$$ItemType(2);
        mic.set$$ItemData(10);
        mic.set$$IsLatent(1);
        mic.set$$Mnt(mnt);
        mic.set$$Bin(bin);
        return mic;
    }

    public static <T> byte[] buildMICByteBuf(T t,int index) throws Throwable{
        ChannelBuffer buf = ChannelBuffers.dynamicBuffer();
        buf.markWriterIndex();
        Class clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotations().length == 0) throw new IllegalArgumentException(String.format("%s have not annotation!",field));
            if (index == 0 && "$$ItemIndex".equals(field.getName())) continue;

            if (field.isAnnotationPresent(FieldLength.class)) {
                FieldLength fieldLength = field.getAnnotation(FieldLength.class);
                if (fieldLength.has())
                    buf.writeBytes(buf_write_name(field.getName(),fieldLength.value()));//构建结构项名
            }
            Method method = clazz.getMethod("get"+field.getName());
            Object value = method.invoke(t);
            int itemLength = 0;
            if (field.isAnnotationPresent(Length.class)) {
                Length length = field.getAnnotation(Length.class);
                if (length.value() == -1) itemLength = value == null ? 0 : ((byte[])value).length;
                else itemLength = length.value();
            }
            //构建结构项
            if (itemLength == 0) { //结构项开始标记，没有值
                buf.writeBytes(buf_write_4_byte(itemLength));
            } else if (itemLength == 1) { //整型结构项,长度都为1,四个字节存储
                buf.writeBytes(buf_write_4_byte(itemLength));
                buf.writeBytes(buf_write_value(itemLength,intToByteArray((int)value)));
            } else {  //二进制存储,长度以实际为准
                buf.writeBytes(buf_write_4_byte(itemLength));
                buf.writeBytes(buf_write_value(itemLength,(byte[])value));
            }

        }
        int read = buf.readableBytes();
        ChannelBuffer result = buf.copy(0,read);
        return result.array();
    }

    public static <T> List<T> readMICByteBuf(byte[] byteBuf,T t) throws Throwable{
        List<T> list = new ArrayList();
        ChannelBuffer buf = ChannelBuffers.wrappedBuffer(byteBuf);
        int total = buf.writerIndex();
        buf.markReaderIndex();
        int safe = 0;//安全标记，防止死循环
        while (safe < total && buf.readerIndex() < total) {
            t = (T)t.getClass().newInstance();
            Class clazz = t.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.getAnnotations().length == 0) throw new IllegalArgumentException(String.format("%s have not annotation!",field));
                if (buf.readerIndex() < 96 && "$$ItemIndex".equals(field.getName())) continue;
                if (field.isAnnotationPresent(FieldLength.class)) {
                    FieldLength fieldLength = field.getAnnotation(FieldLength.class);
                    if (fieldLength.has()) {
                        String name = byteBufReadName(buf, fieldLength.value());
                        VALID_STRUCT_NAME(name, field.getName());
                    }
                }
                if (field.isAnnotationPresent(Length.class)) {
                    Length length = field.getAnnotation(Length.class);
                    if (length.value() == 0) buf.readBytes(4);
                    else {
                        int itemLength = byteBufReadItemLength(buf);
                        byte[] itemValue;
                        if (itemLength == 0) itemValue = null;
                        else itemValue = byteBufReadItemValue(buf, itemLength);

                        Method method = clazz.getMethod("set"+field.getName(),field.getType());
                        if (field.getType() == int.class) {
                            method.invoke(t,byteToInt4_little(itemValue));
                        }
                        else {
                            method.invoke(t,itemValue);
                        }
                    }
                }
                safe ++;
            }
            list.add(t);
        }
        return list;
    }

}
