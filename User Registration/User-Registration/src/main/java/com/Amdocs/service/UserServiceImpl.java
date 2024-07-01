package com.Amdocs.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.Amdocs.Entity.City;
import com.Amdocs.Entity.Country;
import com.Amdocs.Entity.State;
import com.Amdocs.Entity.User;
import com.Amdocs.payload.LoginForm;
import com.Amdocs.payload.UnlockAccountForm;
import com.Amdocs.payload.UserForm;
import com.Amdocs.repositories.CityRepo;
import com.Amdocs.repositories.CountryRepo;
import com.Amdocs.repositories.StateRepo;
import com.Amdocs.repositories.UserRepo;
import com.Amdocs.uitils.Email;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepo userRepo;
	private CountryRepo countryRepo;
	private StateRepo stateRepo;
	private CityRepo cityRepo;
	private Email emails;
	
	
	public UserServiceImpl(UserRepo userRepo, CountryRepo countryRepo, StateRepo stateRepo, CityRepo cityRepo,Email emails) {
		super();
		this.userRepo = userRepo;
		this.countryRepo = countryRepo;
		this.stateRepo = stateRepo;
		this.cityRepo = cityRepo;
		this.emails=emails;
	}

	@Override
	public String checkEmail(String email) {
		User user = userRepo.findByEmail(email);
		if(user==null) {
			return "Unique";
		}
		return "Alredy Email Exit !!";
	}

	@Override
	public Map<Integer, String> getCountries() {
		
		List<Country> countries = countryRepo.findAll();
		
		Map<Integer,String> countryMap=new HashMap<>();
		
		countries.forEach(country ->{
			
			countryMap.put(country.getCountryId(),country.getCountryName());
		});
		return countryMap;
	}

	@Override
	public Map<Integer, String> getStates(long countryId) {
		
		List<State> states = stateRepo.findByCountryId(countryId);
		
		Map<Integer,String> stateMap=new HashMap<>();
		
		states.forEach(state ->{
			stateMap.put(state.getStateId(),state.getStateName());
		});
		
		return stateMap;
	}

	@Override
	public Map<Integer, String> getCities(long stateId) {
		List<City> cities = cityRepo.findByStateId(stateId);
		
		Map<Integer,String> cityMap=new HashMap<>();
		
		cities.forEach(city ->{
			cityMap.put(city.getCityId(), city.getCityName());
		});
		
		return cityMap;
	}

	@Override
	public String Userregister(UserForm userForm) {
		
		//copy data from dto obj to entity obj
		User user=new User();
		
		BeanUtils.copyProperties(userForm, user);
		//Genrate  & set random password
		user.setUserPwd(genrateRandomPwd());
		
		//set account status locked
		user.setAccStatus("LOCKED");
		
	  userRepo.save(user);
	  
	  // TODO : send email to unlock account
	  String to=userForm.getEmail();
	  
	  String subject="Registration Email - Unlock Account";
	  
	  String body=readEmailBody("Emails.txt", user);
	  
	  emails.sendEmail(to, subject, body);
	  
		return "User Account Created";
	}

	@Override
	public String unlockAccount(UnlockAccountForm unlockaccForm) {
		
		String email = unlockaccForm.getEmail();
		
		User user = userRepo.findByEmail(email);
		
		if(user!=null && user.getUserPwd().equals(unlockaccForm.getTempPwd())) {
			user.setUserPwd(unlockaccForm.getNewPwd());
			user.setAccStatus("UNLOCKED !!");
			userRepo.save(user);
			return "Account Unlocked !!";
		}
		
		return "Invalid Temporary Password";
	}

	@Override
	public String login(LoginForm loginForm) {
		
		User user = userRepo.findByEmailAndUserPwd(loginForm.getEmail(),loginForm.getPassword());
		
		if(user==null) {
			
			return "Given Credentials Invalid";
		}
		
		if(user.getAccStatus().equals("LOCKED")) {
			
			return "Account Locked";
		}
		
		return "Success";
	}

	@Override
	public String forgotPwd(String email) {
		
		User user = userRepo.findByEmail(email);
		
		if(user==null) {
			return "No Account Found";
		}
		
		//TODO : send email to unlock account
		String  subject= "Registration Email";
		String body=readEmailBody("forgot.txt", user);
		
		emails.sendEmail(email, subject, body);
		
		return "Password send to the register email";
	}
	
	public String genrateRandomPwd() {
		
		String text="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		
		StringBuilder sb=new StringBuilder();
		
		Random random=new Random();
		
		int pwdLength=6;
		
		for(int i=1;i<=pwdLength;i++) {
			
			int index = random.nextInt(text.length());
			
			sb.append(text.charAt(index));
		}
		
		return sb.toString();
	}
	
	public String readEmailBody(String filename,User user){
		StringBuilder sb=new StringBuilder();
		
		try(Stream<String> lines = Files.lines(Paths.get(filename))) {
			
			lines.forEach(line ->{
				line=line.replace("${FNAME}", user.getFname());
				line=line.replace("${LNAME}", user.getLname());
				line=line.replace("${TEMP_PWD}", user.getUserPwd());
				line=line.replace("${EMAIl}", user.getEmail());
				line=line.replace("${PWD}", user.getUserPwd());
				sb.append(line);
			});
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return sb.toString();
	}

}
