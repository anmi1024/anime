package com.anmi.anime;

import com.anmi.anime.fpt.fpt5.jaxb.FPT5Build;
import com.anmi.anime.fpt.fpt5.jaxb.NYZZW.FPT5FingerPrint;
import com.anmi.anime.fpt.fpt5.jaxb.common.FPT5Common;
import com.anmi.anime.fpt.fpt5.jaxb.NYZZW.FingerPrintPackage;
import com.anmi.anime.fpt.fpt5.jaxb.common.PackageHead;
import com.anmi.anime.fpt.fpt5.jaxb.common.TaskInfo;
import com.anmi.anime.fpt.fpt5.reflect.FPT5Base;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjue on 2017/7/6.
 */
public class JAXB_FPT5Test {
    private static FPT5Common buildFPT5Common(){
        PackageHead head = new PackageHead();
        head.setBbh("FPT05");
        head.setDbsj("20170706");
        head.setXxly(FPT5Base.XXLY.AFIS.name());
        TaskInfo task = new TaskInfo();
        task.setFssj("20170706");
        task.setFsdw_gajgmc("gafis");
        task.setJsdw_gajgmc("afis");
        FPT5Common common = new FPT5Common();
        common.setHead(head);
        common.setTask(task);
        return common;
    }

    private static PackageHead buildPackageHead() {
        PackageHead head = new PackageHead();
        head.setBbh("FPT05");
        //head.setDbsj("20170706");
        head.setXxly(FPT5Base.XXLY.AFIS.name());
        return head;
    }

    private static TaskInfo buildTaskInfo() {
        TaskInfo task = new TaskInfo();
        task.setFssj("20170706");
        task.setFsdw_gajgmc("gafis");
        task.setJsdw_gajgmc("afis");
        return task;
    }

    private static FingerPrintPackage buildFingerPrintPackage(){

        FingerPrintPackage.PeopleMsg peopleMsg = new FingerPrintPackage.PeopleMsg();
        peopleMsg.setBz("ahhahahhahahahha");

        FingerPrintPackage.FingerPrintMsg fingerPrintMsg = new FingerPrintPackage.FingerPrintMsg();
        fingerPrintMsg.setZw_sl(2);

        FingerPrintPackage.FingerMsg fingerMsg1 = new FingerPrintPackage.FingerMsg();
        fingerMsg1.setZwzwdm("1");
        FingerPrintPackage.FingerMsg fingerMsg2 = new FingerPrintPackage.FingerMsg();
        fingerMsg2.setZwzwdm("2");

        FingerPrintPackage.Rolling rolling1 = new FingerPrintPackage.Rolling();
        rolling1.setFingerMsg(fingerMsg1);
        FingerPrintPackage.Rolling rolling2 = new FingerPrintPackage.Rolling();
        rolling2.setFingerMsg(fingerMsg2);

        List<FingerPrintPackage.Rolling> rollingList = new ArrayList<>();
        rollingList.add(rolling1);
        rollingList.add(rolling2);
        FingerPrintPackage.Fingers fingers = new FingerPrintPackage.Fingers();
        fingers.setRolling(rollingList);

        FingerPrintPackage fingerPrintPackage = new FingerPrintPackage();
        fingerPrintPackage.setPeopleMsg(peopleMsg);
        fingerPrintPackage.setFingerPrintMsg(fingerPrintMsg);
        fingerPrintPackage.setFingers(fingers);

        return fingerPrintPackage;
    }

    private static FPT5FingerPrint build_FPT5FingerPrint() {
        FPT5FingerPrint fpt5FingerPrint = new FPT5FingerPrint();
        fpt5FingerPrint.setPackageHead(buildPackageHead());
        fpt5FingerPrint.setTaskInfo(buildTaskInfo());
        fpt5FingerPrint.setFingerPrintPackage(buildFingerPrintPackage());
        return fpt5FingerPrint;
    }
    private InputStream xsd = this.getClass().getResourceAsStream("/fpt5FingerPrint.xsd");

    @Test
    public void test_FPT5CommonToXML() throws Throwable {
        String xml = FPT5Build.toXML(xsd,buildFPT5Common());
        System.out.println(xml);
    }

    @Test
    public void test_FingerPrintToXML() throws Throwable {
        String xml = FPT5Build.toXML(xsd,buildFingerPrintPackage());
        System.out.println(xml);
    }

    @Test
    public void test_NYZZWToXml() throws Throwable {
        String xml = FPT5Build.toXML(xsd,build_FPT5FingerPrint());
        System.out.println(xml);
    }

    @Test
    public void test_NYZZWFromXML() throws Throwable {
        String xml = FPT5Build.toXML(xsd,build_FPT5FingerPrint());
        System.out.println(xml);
        xsd = this.getClass().getResourceAsStream("/fpt5FingerPrint.xsd");
        FPT5FingerPrint fingerPrint = FPT5Build.fromXML(xsd,xml,new FPT5FingerPrint());
        Assert.assertEquals(fingerPrint.getPackageHead().getBbh(),"FPT05");
    }



    @Test
    public void test_headToXML() throws Throwable {
        String xml = FPT5Build.toXML(xsd,buildPackageHead());
        System.out.println(xml);
    }

}
