package com.anmi.anime.fpt.fpt5.jaxb;
import com.anmi.anime.fpt.fpt5.jaxb.common.FPT5Exception;
import com.anmi.anime.fpt.fpt5.reflect.FPT5Base;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.bind.util.ValidationEventCollector;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;

/**
 * Created by wangjue on 2017/7/6.
 */
public class FPT5Build {

    public static <T> String toXML(InputStream in, T t) throws Throwable {
        JAXBContext jaxbContext = JAXBContext.newInstance(t.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_ENCODING, FPT5Base.UTF8_ENCODEING);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT,false);//是否省略XML头申明
        ValidationEventCollector validationEventCollector = new ValidationEventCollector();
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            StreamSource streamSource = new StreamSource(in, "xml");
            Schema schema = schemaFactory.newSchema(streamSource);
            marshaller.setSchema(schema);
            marshaller.setEventHandler(validationEventCollector);
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(t, stringWriter);
            return stringWriter.toString();
        } catch (SAXException e) {
            throw new FPT5Exception(e.getMessage());
        } finally {
            in.close();
            printValidationEvent(validationEventCollector);
        }
    }

    public static void printValidationEvent(ValidationEventCollector validationEventCollector) {
        if (validationEventCollector.hasEvents()) {
            for(ValidationEvent ve : validationEventCollector.getEvents()) {
                String msg = ve.getMessage();
                ValidationEventLocator vel = ve.getLocator();
                int line = vel.getLineNumber();
                int column = vel.getColumnNumber();
                System.out.println();
                System.err.println("At line " + line + ", column " + column + ": " + msg);
            }
        }
    }

    public static <T> T fromXML(InputStream in, String xml,T t) throws Throwable {
        JAXBContext jaxbContext = JAXBContext.newInstance(t.getClass());
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        if (in == null) throw new FPT5Exception("xsd is null!");
        if (xml == null || xml.isEmpty()) throw new FPT5Exception("xml is null");
        ValidationEventCollector validationEventCollector = new ValidationEventCollector();
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            StreamSource streamSource = new StreamSource(in,"xml");
            Schema schema = schemaFactory.newSchema(streamSource);
            unmarshaller.setSchema(schema);
            unmarshaller.setEventHandler(validationEventCollector);
            return (T)unmarshaller.unmarshal(new StringReader(xml));
        } catch (SAXException e) {
            throw new FPT5Exception(e.getMessage());
        } finally {
            in.close();
            printValidationEvent(validationEventCollector);
        }
    }
}
