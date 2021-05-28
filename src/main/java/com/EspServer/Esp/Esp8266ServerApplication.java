package com.EspServer.Esp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.Esp8266Server")
public class Esp8266ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Esp8266ServerApplication.class, args);
	}

}
