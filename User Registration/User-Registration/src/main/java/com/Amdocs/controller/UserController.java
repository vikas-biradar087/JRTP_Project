package com.Amdocs.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Amdocs.payload.LoginForm;
import com.Amdocs.payload.UnlockAccountForm;
import com.Amdocs.payload.UserForm;
import com.Amdocs.service.UserService;
@RestController
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginForm(@RequestBody LoginForm loginForm){
		String loginStatus = userService.login(loginForm);
		return new ResponseEntity<String>(loginStatus,HttpStatus.OK);
	}
	
	@GetMapping("/countries")
	public Map<Integer,String> loadCountry(){
		return userService.getCountries();
		
	}
	
	@GetMapping("/states/{countryId}")
	public Map<Integer,String> loadStates(@PathVariable("countryId") long countryId){
		return userService.getStates(countryId);
	}
	
	@GetMapping("/cities/{stateId}")
	public Map<Integer,String> loadCities(@PathVariable("stateId") long stateId){
		return userService.getStates(stateId);
	}
	
	@GetMapping("email/{email}")
	public String checkEmail(@PathVariable("email") String email){
		return userService.checkEmail(email);
	}
	
	@PostMapping("/user")
	public ResponseEntity<String> userRegistration(@RequestBody UserForm userForm){
		String userregister = userService.Userregister(userForm);
		return new ResponseEntity<String>(userregister,HttpStatus.CREATED);
	}
	
	@PostMapping("/unlock")
	public ResponseEntity<String> unlockAccount(@RequestBody UnlockAccountForm unlockAccountForm){
		String status = userService.unlockAccount(unlockAccountForm);
		return new ResponseEntity<String>(status,HttpStatus.OK);
	}
	
	@GetMapping("/forgotPwd/{email}")
	public ResponseEntity<String> forgotPwd(@PathVariable("email") String email){
		String forgotPwd = userService.forgotPwd(email);
		return new ResponseEntity<>(forgotPwd,HttpStatus.OK);
	}

}
