package com.saikiran.springmvc.website.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saikiran.springmvc.website.model.UserInfo;
import com.saikiran.springmvc.website.repository.RewardsDAO;

@Controller
@RequestMapping("/rewardspage")
public class RewardsController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String rewardsGetmethod(){
		return "rewardspage";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String rewardsPostMethod(HttpServletRequest req){
		String Username = LoginController.m;
		UserInfo info = new UserInfo();
		RewardsDAO dao = new RewardsDAO();
		info = dao.getBalance(Username);
		long rewards = info.getRewards();
		System.out.println("from rewardsPostMethod::"+rewards);
		req.setAttribute("Username", Username);
		req.setAttribute("Rewards", rewards);
		return "rewardspage";
	}
}
