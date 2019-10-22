package com.example.springboot.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class ScheduledTasks {
    private Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    // cron接受cron表达式，根据cron表达式确定定时规则
    @Scheduled(cron="0/5 * * * * ? ")  //每5秒执行一次
    public void testCron() {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info(sdf.format(new Date())+"*********每5秒执行一次");
    }
}
