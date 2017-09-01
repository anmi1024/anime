package com.anmi.anime;

import com.anmi.anime.scheduler.PrintTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by wangjue on 2017/8/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SchedulerTest {
    @Autowired
    public PrintTime printTime;

    @Test
    public void printTimeTest() {
        printTime.reportCurrentTime();
    }
}
