package com.saikiran.springmvc.website.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saikiran.springmvc.website.model.UserInfo;
import com.saikiran.springmvc.website.repository.RepositoryDAO;

@Controller
public class RegisterController {
	
	 @RequestMapping(value = "/register", method=RequestMethod.POST)
	    public String validateDetails(@Valid @ModelAttribute UserInfo user, BindingResult result, HttpServletRequest req, Model mod)
	    {
		 if(result.hasErrors()){
			 return "register";
		 }
		 ArrayList<UserInfo> userInfo = new ArrayList<UserInfo>();
		 String Firstname = req.getParameter("Firstname");
		 String Lastname = req.getParameter("Lastname");
		 String Email = req.getParameter("Email");
		 String Username = req.getParameter("Username");
		 String Password = req.getParameter("Password");
		 String Maidenname = req.getParameter("Maidenname");
		 user.setFirstname(Firstname);
		 user.setLastname(Lastname);
		 user.setEmail(Email);
		 user.setUsername(Username);
		 user.setPassword(Password);
		 user.setMaidenname(Maidenname);
		 userInfo.add(user);
		 RepositoryDAO dao = new RepositoryDAO();
		 dao.getConnection();
		 dao.insertUserInfo(userInfo);
		 
		 return "login";
	    }
}
