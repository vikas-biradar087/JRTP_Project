package com.Amdocs.uitils;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class Email {
	
	@Autowired
	private JavaMailSender emailSender;
	
	 public boolean sendEmail(String to, String subject, String body) {
	 
		 boolean isSent=false;
		 
		 try {
			 //
			 MimeMessage message = emailSender.createMimeMessage();
			 
			 MimeMessageHelper helper = new MimeMessageHelper(message);
			 
			    helper.setTo(to);
			    helper.setSubject(subject);
			    helper.setText(body,true);
			
			 emailSender.send(message);
			 
			 isSent=true;
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 return isSent;
	 }
}
