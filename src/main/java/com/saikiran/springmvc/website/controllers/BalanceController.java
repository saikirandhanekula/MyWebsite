package com.saikiran.springmvc.website.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/balancepage")
public class BalanceController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String balanceGetMethod(){
		
		return "balancepage";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String balancePostMethod(){
		
		String Username = LoginController.m;
		
		return "balancepage";
	}
}
