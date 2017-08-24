package com.anmi.anime.fpt.fpt5.reflect;

import com.anmi.anime.StructException;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wangjue on 2017/7/5.
 */
public class FPT5Build {

    public static packageHead buildPackageHead(){
        packageHead head = new packageHead();
        head.setBbh("FPT5");
        head.setDbsj("20170705");
        head.setXxly(FPT5Base.XXLY.AFIS.name());
        return head;
    }

    public static String buildFingerPrintFPT5() {
        Document requestDoc = DocumentHelper.createDocument();
        Element root = requestDoc.addElement("xml");

        addElement(root,buildPackageHead());
        addElement(root,new taskInfo());

        return root.asXML();
    }

    public static <T> Element addElement(Element root,T t) {
        Class<?> clazz = t.getClass();
        String className = clazz.getSimpleName();
        Element head = root.addElement(className);
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            try {
                Method method = clazz.getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
                Object value = method.invoke(t);
                if (field.getType() == int.class) {
                    int v = value==null ? 0 : (int)value;
                    head.addAttribute(fieldName,v+"");
                } else if (field.getType() == String.class) {
                    String v = value == null ? "" : (String)value;
                    head.addAttribute(fieldName,v);
                }

            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                new StructException(String.format("%s , %s",e.getMessage(),fieldName)).getMessage();
            }
        }
        return head;
    }

    public static void writeXML(Document xml) throws Throwable{
        OutputFormat format = OutputFormat.createCompactFormat();
        format.setEncoding(FPT5Base.UTF8_ENCODEING);
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("E:\\wj-fptFile\\fpt5\\fpt5.xml"),format);
        xmlWriter.write(xml);
        xmlWriter.close();
    }

    public static void main(String[] args) {
        String xml = buildFingerPrintFPT5();
        try {
            Document document = DocumentHelper.parseText(xml);
            writeXML(document);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        System.out.println(xml);
    }
}
