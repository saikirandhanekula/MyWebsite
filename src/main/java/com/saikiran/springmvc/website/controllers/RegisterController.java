package com.saikiran.springmvc.website.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saikiran.springmvc.website.model.UserInfo;
import com.saikiran.springmvc.website.repository.RepositoryDAO;
import com.saikiran.springmvc.website.repository.RewardsDAO;
import com.saikiran.springmvc.website.repository.UserProfileDAO;

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
	    public String validateDetails(UserInfo user, HttpServletRequest req){
		 
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
		 user.setBalance(1500);
		 user.setRewards(50);
		 userInfo.add(user);
		 UserProfileDAO userDAO = new UserProfileDAO();
		 RepositoryDAO dao = new RepositoryDAO();
		 RewardsDAO reDao = new RewardsDAO();
		 
		 if(dao.getDetails(Username, Password)){
			 return "registrationError";
			}
		 else{
			 dao.getConnection();
			 dao.createRegistration();
			 dao.insertUserInfo(userInfo);
			 reDao.getConnection();
			 reDao.createRegistration();
			 reDao.insertDetails(Username, Email, user.getRewards(), user.getBalance());
			 userDAO.getConnection();
			 userDAO.createRegistration();
			 userDAO.setFriendEmail(Username);
			 return "loginpage";
		 }
		 
	    }
	 }
