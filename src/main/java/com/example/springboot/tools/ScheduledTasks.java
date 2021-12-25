package com.example.springboot.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@PropertySource("classpath:/application.properties")
@Component
public class ScheduledTasks {
    private Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Scheduled(cron="${cron.time1} ")  //每1秒执行一次
    public void testCron1() {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info(sdf.format(new Date())+"*********每1秒执行一次");
    }

    @Scheduled(cron="${cron.time2} ")  //每2秒执行一次
    public void testCron2() {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info(sdf.format(new Date())+"*********每2秒执行一次");
    }

    @Scheduled(cron="${cron.time3}")  //每3秒执行一次
    public void testCron3() {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info(sdf.format(new Date())+"*********每3秒执行一次");
    }

    // cron接受cron表达式，根据cron表达式确定定时规则
    @Scheduled(cron="${cron.time5}")  //每5秒执行一次
    public void testCron() {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info(sdf.format(new Date())+"*********每5秒执行一次");
    }
}
