package com.saikiran.springmvc.website.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saikiran.springmvc.website.repository.RewardsDAO;

@Controller
@RequestMapping("/makepayment")
public class MakePayment {
	
	static int amount = 0;
	
	@RequestMapping(method = RequestMethod.GET)
	public String makepaymentGetMethod(){
		return "makepayment";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String makepaymnetPostMethod(HttpServletRequest req){
		String Email = req.getParameter("email");
		System.out.println(Email);
		int amount = Integer.parseInt(req.getParameter("amount"));
		System.out.println(amount);
		String Username = LoginController.m;
		System.out.println(Username);
		RewardsDAO rewardsDao = new RewardsDAO();
		rewardsDao.getConnection();
		rewardsDao.makePayment(amount, Username);
		rewardsDao.updatePayment(amount, Email);
		if(amount==500){
			rewardsDao.getConnection();
			rewardsDao.updateRewards(30, Username);
			req.setAttribute("Name", Username);
			req.setAttribute("Rewards", "Congrats...You are Earned 30 Rewards...!!!");
			return "paymentsuccess";
		}
		else if(amount==1000){
			rewardsDao.getConnection();
			rewardsDao.updateRewards(100, Username);
			req.setAttribute("Name", Username);
			req.setAttribute("Rewards", "Congrats...You are Earned 100 Rewards...!!!");
			return "paymentsuccess";
		}
		else if(amount==1500){
			rewardsDao.getConnection();
			rewardsDao.updateRewards(150, Username);
			req.setAttribute("Name", Username);
			req.setAttribute("Rewards", "Congrats...You are Earned 150 Rewards...!!!");
			return "paymentsuccess";
		}
		else{
			req.setAttribute("Name", Username);
			req.setAttribute("Rewards", "Payment Successfully Submitted....");
			return "paymentsuccess";
		}
	}
}
