package com.SpanIdea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerrrApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerrrApplication.class, args);
	}

}
