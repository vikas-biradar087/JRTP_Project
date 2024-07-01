package com.SpanIdea.REST_API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpanIdea.REST_API.Cient.ApiClient;

@SpringBootApplication
@RestController
@EnableFeignClients
public class RestApiApplication {

	@Autowired
	private ApiClient apiClient;
	
	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}
	
	@GetMapping("/RestApi")
	public String getRestApi() {
	String inovkeApi = apiClient.InovkeApi();
		
	String RestApiResponce="Hey I am fine nd You";
		
		return inovkeApi + RestApiResponce;
	}

}
