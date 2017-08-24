package com.anmi.anime.fpt.fpt5.jaxb.common;

import com.anmi.anime.fpt.fpt5.jaxb.common.PackageHead;
import com.anmi.anime.fpt.fpt5.jaxb.common.TaskInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by wangjue on 2017/7/6.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FPT5Common {
    @XmlElement(name = "packageHead")
    private PackageHead head;
    @XmlElement(name = "taskInfo")
    private TaskInfo task;

    public PackageHead getHead() {
        return head;
    }

    public void setHead(PackageHead head) {
        this.head = head;
    }

    public TaskInfo getTask() {
        return task;
    }

    public void setTask(TaskInfo task) {
        this.task = task;
    }
}
