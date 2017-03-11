package com.saikiran.springmvc.website.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/rewardspage")
public class RewardsController {
	@RequestMapping(method = RequestMethod.GET)
	public String rewardsGetmethod(){
		return "rewardspage";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String rewardsPostMethod(){
		
		return "rewardspage";
	}
}
