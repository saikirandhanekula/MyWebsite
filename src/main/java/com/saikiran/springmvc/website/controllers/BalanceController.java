package com.saikiran.springmvc.website.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saikiran.springmvc.website.model.UserInfo;
import com.saikiran.springmvc.website.repository.RewardsDAO;

@Controller
@RequestMapping("/balancepage")
public class BalanceController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String balanceGetMethod(){
		
		return "balancepage";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String balancePostMethod(HttpServletRequest req){
		String Username = LoginController.m;
		UserInfo user = new UserInfo();
		RewardsDAO dao = new RewardsDAO();
		user = dao.getBalance(Username);
		long balance = user.getBalance();
		long rewards = user.getRewards();
		System.out.println("from balancePostMethod "+balance+rewards);
		
		req.setAttribute("Username", Username);
		req.setAttribute("Balance", balance);
		return "balancepage";
	}
}
