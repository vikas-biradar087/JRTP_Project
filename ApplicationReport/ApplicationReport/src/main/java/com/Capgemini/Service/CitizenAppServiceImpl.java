package com.Capgemini.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.Capgemini.Binding.CitizenApp;
import com.Capgemini.Entity.CitizenAppEntity;
import com.Capgemini.Repository.CitizenAppRepo;

@Service
public class CitizenAppServiceImpl implements CitizenAppService {

	private static final String REST_URL="http://ssawebapi-env.eba-k88bsahp.ap-south-1.elesticbeanstalk.com/ssn/{ssn}";
	
	@Autowired
	private CitizenAppRepo citiRepo;
	
	@Override
	public String registerCitizenApp(CitizenApp citizenApp) {
		
		Long ssn = citizenApp.getSsn();
		
		WebClient webclient = WebClient.create();
		
							String stateName = webclient.get()
							.uri(REST_URL,ssn) //specify url
							.retrieve() //extract response
							.bodyToMono(String.class) //bind resp
							.block(); //syn call
							
		if("Rhode IsLand".equals(stateName)) {
			
			CitizenAppEntity entity=new CitizenAppEntity();
			
			BeanUtils.copyProperties(citizenApp, entity);
			
			entity=citiRepo.save(entity);
			
			return "Citizen App Created App Id :"+ entity.getAppId();
		}
		
		return "Citizen not belong to rhode island !!";
	}

}
