package com.anmi.anime.fpt.struct;


import com.anmi.anime.fpt.FPTBase;
import com.anmi.anime.annotation.Length;
import com.anmi.anime.annotation.LengthRef;
import com.anmi.anime.exception.StructException;

import java.lang.reflect.*;
import java.util.List;

/**
 * Created by wangjue on 2017/6/26.
 */
public class CommonStruct {
    private static ThreadLocal<Integer> totalFieldLength = new ThreadLocal<>();
    private static ThreadLocal<Integer> logicFieldLength = new ThreadLocal<>();

    public static <T> T getInnerClassInstance(Type type, Class clazz) throws Throwable {
        Class[] classes = clazz.getDeclaredClasses();
        for (Class c : classes) {
            if (type == c) {
                Constructor[] constructor = c.getDeclaredConstructors();
                if (constructor.length>0) {
                    constructor[0].setAccessible(true);
                    return (T)constructor[0].newInstance(clazz.newInstance());
                }
            }
        }
        return null;
    }

    public static <T> Object getFieldValue(String fieldName, T t) throws Throwable {
        Class<?> clazz = t.getClass();
        Method method = clazz.getMethod("get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1));
        return method.invoke(t);
    }

    public static <T> int getFieldLength(Field field, T t) throws Throwable{
        Class<?> clazz = t.getClass();
        int fieldLength=0;
        if (field.isAnnotationPresent(Length.class)) {
            Length length = field.getAnnotation(Length.class);
            fieldLength = length.value();
        } else if (field.isAnnotationPresent(LengthRef.class)) {
            LengthRef lengthRef = field.getAnnotation(LengthRef.class);
            String refField = lengthRef.value();
            Method refMethod = clazz.getMethod("get"+refField.substring(0,1).toUpperCase()+refField.substring(1));
            try {
                Object o = refMethod.invoke(t);
                fieldLength = (o==null || o.toString().isEmpty()) ? 0 : Integer.valueOf(o.toString());
            } catch (NumberFormatException ex) {
                throw new NumberFormatException(String.format("%s , %s",ex.getMessage(),field.getName()));
            }
        }
        return fieldLength;
    }

    public static boolean hasAnnotation(Field field,Class c) throws Throwable {
        boolean bool = false;
        if (field.isAnnotationPresent(c)) bool = true;
        return bool;
    }

    public static <T> int getObjectFieldValueLength(T t) throws Throwable {
        Class<?> clazz = t.getClass();
        int totalFieldLength = 0;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == clazz.getDeclaringClass()) continue;
            Object o = getFieldValue(field.getName(),t);
            int fieldLength = 0;
            if (o != null) {
                if (field.getType() == String.class) fieldLength = ((String)o).length();
                else if (field.getType() == byte.class) fieldLength = 1;
                else if (field.getType() == byte[].class) fieldLength = ((byte[])o).length;
               // else throw new StructException(String.format("VALID TYPE , %s",field.getType()));
            } else new StructException("NOT FOUND VALUE , "+field.getName()).getMessage();
            totalFieldLength += fieldLength;
        }
        return totalFieldLength;
    }

    private static void resetTotalFieldLength() {
        totalFieldLength.set(new Integer(0));
    }
    private static void resetLogicFieldLength() {
        logicFieldLength.set(new Integer(0));
    }

    public static <T> T setObjectFieldValueLength(T t) throws Throwable {
        resetTotalFieldLength();
        resetLogicFieldLength();
        return setObjectFieldValueLength(t,totalFieldLength.get());
    }

    public static <T> T setObjectFieldValueLength(T t,int length) throws Throwable {
        Class<?> clazz = t.getClass();
        int objectFieldLength=0;
        Field[] fields = clazz.getDeclaredFields();
        int fieldLength = 0;
        for (int i = fields.length-1;i >= 0;i--) {
            Field field = fields[i];
            if (field.getType() == clazz.getDeclaringClass()) continue;
            String fieldName = field.getName();
            Object o = getFieldValue(fieldName,t);
            if (o != null) {
                if (field.getType() == byte.class) fieldLength = 1;
                else if (field.getType() == String.class) fieldLength = ((String)o).length();
                else if (field.getType() == byte[].class) fieldLength = ((byte[])o).length;
                else if (field.getType().getSuperclass() == BaseStruct.class) setObjectFieldValueLength(o);
                else if (field.getType() == List.class) {
                    ParameterizedType p = (ParameterizedType) field.getGenericType();//获取泛型类型
                    Type[] types = p.getActualTypeArguments();
                    Type type = types[0];
                    Class<?> declaringClass = clazz.getDeclaringClass() == null ? clazz : clazz.getDeclaringClass();
                    Object innerObject = getInnerClassInstance(type, declaringClass);

                    if (innerObject.getClass().getSuperclass() == BaseStruct.class) {
                        for (Object lo : (List) o) {
                            resetLogicFieldLength();
                            setObjectFieldValueLength(lo, length);
                            objectFieldLength = totalFieldLength.get();
                        }
                    } else {
                        for (Object lo : (List) o) {
                            setObjectFieldValueLength(lo, length);
                        }
                        objectFieldLength = logicFieldLength.get();
                    }
                }
                else new StructException(String.format("VALID TYPE , %s",field.getType())).getMessage();
                objectFieldLength += fieldLength;
                if (fieldName.equals(FPTBase.DATA_LENGTH) || fieldName.equals(FPTBase.LOGIC_LENGTH) || fieldName.equals(FPTBase.FILE_LENGTH)) {
                    if (fieldName.equals(FPTBase.DATA_LENGTH)) logicFieldLength.set(logicFieldLength.get() + objectFieldLength);
                    else totalFieldLength.set(totalFieldLength.get() + logicFieldLength.get());

                    Method method = clazz.getMethod("set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1),field.getType());
                    try {
                        objectFieldLength += (objectFieldLength+"").length(); //加上长度定义字段长度
                        if (fieldName.equals(FPTBase.FILE_LENGTH)) objectFieldLength += 7;//head size
                        method.invoke(t, objectFieldLength + "");
                    } catch (IllegalArgumentException ex) {
                        new StructException(String.format("%s , %s",ex.getMessage(),field.getType())).getMessage();
                    }
                }
            } else new StructException("StructException : NOT FOUND VALUE OR VALUE IS NULL, "+field.getName()).getMessage();

        }
        return t;
    }

}
