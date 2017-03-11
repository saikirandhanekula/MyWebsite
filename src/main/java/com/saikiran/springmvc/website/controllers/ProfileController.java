package com.saikiran.springmvc.website.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saikiran.springmvc.website.model.UserInfo;
import com.saikiran.springmvc.website.repository.RepositoryDAO;

@Controller
@RequestMapping("/profile")
public class ProfileController{
	
	@RequestMapping(method = RequestMethod.GET)
	public String displayProfile(ModelMap model){
		System.out.println("from get method");
		return "profile";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String retrievedDetails(UserInfo ui,HttpServletRequest req){
		String userName = LoginController.m;
		System.out.println(LoginController.m);
		System.out.println("from Profile Controller class retrievedData method "+userName);
		ArrayList<UserInfo> userData = new ArrayList<UserInfo>();
		RepositoryDAO repDao = new RepositoryDAO();
		repDao.getConnection();
		userData = repDao.retrieveData(userName);
		
		String Firstname="",Lastname="",Maidenname="",Email="",Username="";
		long Phone =0;
		  Firstname =userData.get(0).getFirstname();
		  Lastname = userData.get(0).getLastname();
		  Maidenname = userData.get(0).getMaidenname();
		  Email = userData.get(0).getEmail();
		  Username = userData.get(0).getUsername();
		 Phone = (long) userData.get(0).getPhone();
			
		 System.out.println(Firstname);
		 System.out.println(Lastname);
		 System.out.println(Maidenname);
		 System.out.println(Email);
		 System.out.println(Username);
		 System.out.println(Phone);
		 
	     req.setAttribute("Firstname", Firstname);
		 req.setAttribute("Lastname", Lastname);
		 req.setAttribute("Maidenname", Maidenname);
		 req.setAttribute("Email", Email);
		 req.setAttribute("Username", Username);
		 req.setAttribute("Phone", Phone);
		 
		return "profile";
	}
	
}
