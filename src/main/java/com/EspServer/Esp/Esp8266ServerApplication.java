package com.EspServer.Esp;

import com.EspServer.Esp.email_service.EmailConfig;
import com.EspServer.Esp.scheduler.ScheduleTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
public class Esp8266ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(Esp8266ServerApplication.class, args);
    }
}
