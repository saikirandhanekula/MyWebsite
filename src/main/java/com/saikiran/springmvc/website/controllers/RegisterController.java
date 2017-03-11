package com.saikiran.springmvc.website.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saikiran.springmvc.website.model.UserInfo;
import com.saikiran.springmvc.website.repository.RepositoryDAO;

@Controller
@RequestMapping(value="/register")
public class RegisterController {
	@RequestMapping(method = RequestMethod.GET)
	public String getDetails(@ModelAttribute UserInfo info, ModelMap model){
		UserInfo ui = new UserInfo();
		model.addAttribute("userInfo", ui);
		return "register";
	}
	
	 @RequestMapping(method=RequestMethod.POST)
	    public String validateDetails(@Valid @ModelAttribute UserInfo user, BindingResult result, HttpServletRequest req, Model model){
		 if(result.hasErrors()){
			 return "register";
		 }
		 ArrayList<UserInfo> userInfo = new ArrayList<UserInfo>();
		 String Firstname = req.getParameter("Firstname");
		 String Lastname = req.getParameter("Lastname");
		 String Maidenname = req.getParameter("Maidenname");
		 String Email = req.getParameter("Email");
		 String Username = req.getParameter("Username");
		 String Password = req.getParameter("Password");
		 double Phone = Double.parseDouble(req.getParameter("Phone"));
		 user.setFirstname(Firstname);
		 user.setLastname(Lastname);
		 user.setMaidenname(Maidenname);
		 user.setEmail(Email);
		 user.setUsername(Username);
		 user.setPassword(Password);
		 user.setPhone(Phone);
		 userInfo.add(user);
		 RepositoryDAO dao = new RepositoryDAO();
		 dao.getConnection();
		 dao.insertUserInfo(userInfo);
		 
		 return "loginpage";
	    }
	 }
