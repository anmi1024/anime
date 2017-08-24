package com.anmi.anime.struct;

import com.anmi.anime.define.AFISDateTime;
import com.anmi.anime.define.CutLength;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static com.anmi.anime.ByteUtil.*;

/**
 * Created by wangjue on 2017/6/21.
 */
public class CandListStruct {

    public static <T> byte[] buildCandListByteBuf(T t) throws Throwable{
        ChannelBuffer byteBuf = ChannelBuffers.dynamicBuffer();
        byteBuf.markWriterIndex();
        Class<?> clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAnnotationPresent(CutLength.class)) throw new IllegalArgumentException(String.format("%s,have not annotation CutLength",field));
            else {
                CutLength cutLength = field.getAnnotation(CutLength.class);
                int len = cutLength.len();
                String fieldName = field.getName();
                Method method = clazz.getMethod("get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1));
                Object value = method.invoke(t);
                if (field.getType() == int.class) byteBuf.writeBytes(intToByteArray(Integer.valueOf((int)value),len));
                else if (field.getType() == long.class) byteBuf.writeBytes(longToByteArray((long)value,len));
                else if (field.getType() == short.class) byteBuf.writeBytes(shortToByteArray((short)value,len));
                else if (field.getType() == byte.class) byteBuf.writeBytes(new byte[]{(byte)value});
                else if (field.getType() == String.class) byteBuf.writeBytes(stringToByte(value.toString(),len));
                else if (field.getType() == AFISDateTime.class) byteBuf.writeBytes(((AFISDateTime)value).toBinary());
                else throw new IllegalArgumentException(String.format("undefined type,%s,%s",field.getType().toString(),field.toString()));
            }
        }
        int read = byteBuf.readableBytes();
        ChannelBuffer result = byteBuf.copy(0,read);
        return result.array();
    }

    public static <T> List<T> readCandListByteBuf(byte[] bytes ,T t) throws Throwable{
        List<T> list = new ArrayList();
        int actualSize = bytes.length;
        int readSize=0;
        int structFlag = 0;//一个结构长度为96
        do {
            t = (T)t.getClass().newInstance();
            Class<?> clazz = t.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAnnotationPresent(CutLength.class))
                    throw new IllegalArgumentException(String.format("%s,have not annotation CutLength", field));
                else {
                    CutLength cutLength = field.getAnnotation(CutLength.class);
                    int offset = cutLength.offset()+structFlag;
                    int len = cutLength.len();
                    readSize += len;
                    String fieldName = field.getName();
                    byte[] desc;
                    try {
                        desc = cutByteArray(bytes, offset, len);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        throw new ArrayIndexOutOfBoundsException(String.format("%s , %s",e.getMessage(),fieldName));
                    }
                    Method method = clazz.getMethod("set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), field.getType());
                    if (field.getType() == int.class) method.invoke(t, byteArrayToInt(desc, len));
                    else if (field.getType() == long.class) method.invoke(t, (long) byteArrayToInt(desc, len));
                    else if (field.getType() == short.class) method.invoke(t, (short) byteArrayToInt(desc, len));
                    else if (field.getType() == byte.class) method.invoke(t, (byte) byteArrayToInt(desc, len));
                    else if (field.getType() == String.class) method.invoke(t, byteToString(desc));
                    else if (field.getType() == AFISDateTime.class) method.invoke(t, new AFISDateTime(desc));
                    else throw new IllegalArgumentException(String.format("undefined type,%s,%s", field.getType().toString(), field.toString()));
                }
            }
            list.add(t);
            structFlag += 96;
        } while (readSize < actualSize);
        return list;
    }
}
