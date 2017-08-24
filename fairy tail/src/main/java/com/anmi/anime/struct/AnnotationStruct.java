package com.anmi.anime.struct;

import com.anmi.anime.define.AnnotationObject;
import com.anmi.anime.define.Length;
import com.anmi.anime.define.LengthRef;
import com.anmi.anime.fpt.FPTBase;
import com.anmi.anime.fpt.FPTFile;
import org.apache.commons.io.FileUtils;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static com.anmi.anime.ByteUtil.byteToByteForLength;
import static com.anmi.anime.ByteUtil.byteToString;
import static com.anmi.anime.ByteUtil.stringToByte;

/**
 * Created by wangjue on 2017/6/22.
 */
public class AnnotationStruct {

    public static AnnotationObject buildAnnotationObject() throws Throwable{
        AnnotationObject object = new AnnotationObject();
        object.setDataLength("12121");
        object.setSendNo("01");
        object.setFgp("1");
        object.setExtractMethod("2");
        object.setFeatureCount("33");
        object.setFeature("kidsncosnmdiohcusodnmcksdinsnmkqmwiodmiosdjisomciodjcidojscudhscus76csdysdcsdjncuisdncuidsniuncs");
        object.setCustomInfoLength("95");
        object.setCustomInfo(FileUtils.readFileToByteArray(new File("D:\\struct\\cand.cand")));
        object.setDpi("500");
        object.setImgCompressMethod("103");
        object.setImgDataLenght("23752");
        object.setImgData(FileUtils.readFileToByteArray(new File("D:\\struct\\mic.mic")));
        return object;
    }

    public static <T> byte[] buildAnnotationObjectByteBuf(T t) throws Throwable{
        ChannelBuffer buf = ChannelBuffers.dynamicBuffer();
        buf.markWriterIndex();
        Class<?> clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            int fieldLength = CommonStruct.getFieldLength(field,t);
            Method method = clazz.getMethod("get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1));
            Object object = method.invoke(t);
            int objectLength = 0;
            try {
                if (field.getType() == int.class || field.getType() == String.class) {
                    String objectStr = object == null ? "" : object.toString();
                    objectLength = objectStr.length();
                    buf.writeBytes(stringToByte(objectStr, fieldLength, FPTBase.GBK_ENCODEING));
                } else if (field.getType() == byte[].class) {
                    byte[] objectByte = object == null ? "".getBytes() : (byte[]) object;
                    objectLength = objectByte.length;
                    buf.writeBytes(byteToByteForLength(objectByte, fieldLength));
                } else if (field.getType() == byte.class) {
                    buf.writeBytes(new byte[]{(byte)object});
                } else throw new IllegalArgumentException(String.format("invalid Type,%s,%s", field, field.getType()));
            } catch (IllegalArgumentException ie) {
                throw ie;
            } catch (IndexOutOfBoundsException ie1) {
                throw new ArrayIndexOutOfBoundsException(String.format("%s : %s , %s",ie1.getMessage(),field.getName(),"defined length is "+fieldLength+",actual length is "+objectLength));
            }
        }
        int read = buf.readableBytes();
        ChannelBuffer result = buf.copy(0,read);
        return result.array();
    }

    public static <T> T readAnnotationObjectByteBuf(byte[] b,T t) throws Throwable {
        ChannelBuffer byteBuf = ChannelBuffers.wrappedBuffer(b);
        Class<?> clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            int fieldLength = CommonStruct.getFieldLength(field,t);
            byte[] bytes;
            try {
                bytes = byteBuf.readBytes(fieldLength).array();
            } catch (IndexOutOfBoundsException e) {
                throw new ArrayIndexOutOfBoundsException(String.format("%s : %s",e.getMessage(),field.getName()));
            }
            Method method = clazz.getMethod("set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1),field.getType());
            if (field.getType() == String.class) {
                method.invoke(t,byteToString(bytes,fieldLength));
            } else if (field.getType() == byte[].class) {
                method.invoke(t,bytes);
            } else if (field.getType() == byte.class) {
                method.invoke(t,bytes[0]);
            } else throw new IllegalArgumentException(String.format("invalid Type,%s,%s",field,field.getType()));
        }
        return t;
    }


}
