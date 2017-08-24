package com.anmi.anime.fpt.fpt5.jaxb.NYZZW;
import com.anmi.anime.fpt.fpt5.jaxb.common.PackageHead;
import com.anmi.anime.fpt.fpt5.jaxb.common.TaskInfo;

import javax.xml.bind.annotation.*;

/**
 * Created by wangjue on 2017/7/6.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "FPT5")
@XmlType(propOrder = { "packageHead","taskInfo","fingerPrintPackage" })
public class FPT5FingerPrint {
    @XmlElement(name = "packageHead")
    private PackageHead packageHead;
    @XmlElement(name = "taskInfo")
    private TaskInfo taskInfo;
    private FingerPrintPackage fingerPrintPackage;

    public PackageHead getPackageHead() {
        return packageHead;
    }

    public void setPackageHead(PackageHead packageHead) {
        this.packageHead = packageHead;
    }

    public TaskInfo getTaskInfo() {
        return taskInfo;
    }

    public void setTaskInfo(TaskInfo taskInfo) {
        this.taskInfo = taskInfo;
    }

    public FingerPrintPackage getFingerPrintPackage() {
        return fingerPrintPackage;
    }

    public void setFingerPrintPackage(FingerPrintPackage fingerPrintPackage) {
        this.fingerPrintPackage = fingerPrintPackage;
    }
}
