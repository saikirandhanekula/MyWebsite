package com.saikiran.springmvc.website.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saikiran.springmvc.website.repository.RepositoryDAO;

@Controller
@RequestMapping("/UsernameValidationPage")
public class UsernameValidationPageController {
	
	static String user="";

	@RequestMapping(method = RequestMethod.GET)
	public String usernameValidationMethod(){
		
		return "UsernameValidationPage";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String usernameValidationCheckMethod(HttpServletRequest req){
		String Username = req.getParameter("Username");
		user = Username;
		RepositoryDAO dao = new RepositoryDAO();
		dao.getConnection();
		if(dao.userNameCheckMethod(Username)){
			return"forgotpassword";
		}else{
			return "nouserexists";
		}
		
	}
}
