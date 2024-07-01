package com.Amdocs.service;

import java.util.Map;

import com.Amdocs.Entity.User;
import com.Amdocs.payload.LoginForm;
import com.Amdocs.payload.UnlockAccountForm;
import com.Amdocs.payload.UserForm;

public interface UserService {
	
	public String checkEmail(String email);
	
	public Map<Integer,String> getCountries();
	
	public Map<Integer,String> getStates(long countryId);
	
	public Map<Integer,String> getCities(long stateId);
	
	public String Userregister(UserForm userForm);
	
	public String unlockAccount(UnlockAccountForm accForm);

	public String login(LoginForm loginForm);
	
	public String forgotPwd(String email);
}
