package com.Capgemini.EligibilityDeterminationApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class EligibilityDeterminationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EligibilityDeterminationApiApplication.class, args);
	}

}
