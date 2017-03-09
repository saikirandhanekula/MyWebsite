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
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String passwordCheck(@ModelAttribute UserInfo info, ModelMap model){
		UserInfo ui = new UserInfo();
		model.addAttribute("user", ui);
		return "loginpage";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String userDetails(@Valid @ModelAttribute UserInfo info, BindingResult result, HttpServletRequest req, Model model){
		
		String Username = req.getParameter("Username");
		String Password = req.getParameter("Password");
		UserInfo ui = new UserInfo();
		ui.setUsername(Username);
		ui.setPassword(Password);
		ArrayList<UserInfo> userData = new ArrayList<UserInfo>();
		userData.add(ui);
		RepositoryDAO dao = new RepositoryDAO();
		dao.getConnection();
		if(!dao.getDetails(userData)){
			return "welcome";
		}
		else{
			return "loginpage";
		}
	}
	
}