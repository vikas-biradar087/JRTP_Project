package com.Capagamini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CrroespndenceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrroespndenceApiApplication.class, args);
	}

}
