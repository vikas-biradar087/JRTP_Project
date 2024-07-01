package com.Capgemini.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Capgemini.Binding.CitizenApp;
import com.Capgemini.Service.CitizenAppService;

@RestController
public class CitizenAppController {
	
	@Autowired
	private CitizenAppService citizenAppService;
	
	@PostMapping("/citizenApp")
	public ResponseEntity<String> registerCitizen(@RequestBody CitizenApp citizenApp){
		String response = citizenAppService.registerCitizenApp(citizenApp);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}

}
