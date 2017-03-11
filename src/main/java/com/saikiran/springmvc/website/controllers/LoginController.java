package com.saikiran.springmvc.website.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saikiran.springmvc.website.model.UserInfo;
import com.saikiran.springmvc.website.repository.RepositoryDAO;



@Controller
@RequestMapping("/")
public class LoginController {
	
	static String m="";
	@RequestMapping(method = RequestMethod.GET)
	public String passwordCheck(){
		return "loginpage";
	}
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String userDetails(UserInfo ui,HttpServletRequest req){
	    String Username = req.getParameter("Username");
		String Password = req.getParameter("Password");
		m=Username;
	    RepositoryDAO dao = new RepositoryDAO();
		dao.getConnection();
	if(dao.getDetails(Username, Password)){
			return "welcome";
			
		}
		else{
			return "loginpage";
	}
	}
	
}