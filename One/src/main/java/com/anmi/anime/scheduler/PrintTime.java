package com.anmi.anime.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangjue on 2017/8/28.
 */
@Component
public class PrintTime {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(cron = "*/5 * * * * ?")
    public void reportCurrentTime(){
        System.out.println("现在时间："+sdf.format(new Date()));
    }
}
