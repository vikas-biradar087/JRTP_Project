package com.SpanIdea.REST_API.Cient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="API")
public interface ApiClient {
	
	@GetMapping("/api")
	public String InovkeApi();

}
