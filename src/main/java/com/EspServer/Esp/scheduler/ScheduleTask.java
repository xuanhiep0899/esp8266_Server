package com.EspServer.Esp.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduleTask {
    private final Logger logger = LoggerFactory.getLogger(ScheduleTask.class);

    //Fixed Delay
    @Scheduled(fixedDelay = 5000)
    public void scheduleFixedDelay() {
        logger.info(String.valueOf("Fixed Delay " + LocalDateTime.now()));
    }

    //Fixed Rate
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRate(){
        logger.info("Fixed Rate " + LocalDateTime.now());
    }

    //In ra man hinh giay 15 moi phut
    @Scheduled(cron = "15 * * * * ?")
    public void scheduleWithCron(){
        logger.info("Schedule with cron " + LocalDateTime.now());
    }
}
