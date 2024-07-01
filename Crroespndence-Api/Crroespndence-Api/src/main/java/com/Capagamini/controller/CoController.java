package com.Capagamini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Capagamini.binding.ElgResponse;
import com.Capagamini.service.CoService;

@RestController
public class CoController {
	
	@Autowired
	private CoService coService;
	
	@GetMapping("/process")
	public ElgResponse processTriggers() throws Exception{
		return coService.processPendingTriggers();
	}

}
