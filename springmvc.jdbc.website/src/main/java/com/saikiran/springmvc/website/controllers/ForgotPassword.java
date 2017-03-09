package com.saikiran.springmvc.website.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saikiran.springmvc.website.model.UserInfo;

@Controller
public class ForgotPassword {
	
	@RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
	public String passwordCheck(ModelMap model){
		UserInfo ui = new UserInfo();
		model.addAttribute("forgot", ui);
		return "forgotpassword";
	}
}
