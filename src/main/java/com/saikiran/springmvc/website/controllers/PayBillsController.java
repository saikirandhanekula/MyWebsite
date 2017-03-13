package com.saikiran.springmvc.website.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saikiran.springmvc.website.repository.RewardsDAO;

@Controller
@RequestMapping("/paybills")
public class PayBillsController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String payBillsGetMethod(){
		return "paybills";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String payBillsPostMethod(HttpServletRequest req){
		int amount = Integer.parseInt(req.getParameter("Amount"));
		String Username = LoginController.m;
		RewardsDAO dao = new RewardsDAO();
		dao.getConnection();
		if(dao.payBillMethod(amount, Username)==1){
			return "payBillSuccess";
		}
		else{
			return "payBillFailure";
		}
		
	}
}
