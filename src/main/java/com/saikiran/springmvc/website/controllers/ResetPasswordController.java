package com.saikiran.springmvc.website.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saikiran.springmvc.website.repository.RepositoryDAO;

@Controller
@RequestMapping("/resetpassword")
public class ResetPasswordController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String passwordCheck() {
		return "resetpassword";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String resetPasswordConfirmMethod(HttpServletRequest req){
		String newPassword = req.getParameter("NewPassword");
		String confirmPassword = req.getParameter("ConfirmPassword");
		String Username = UsernameValidationPageController.user;
		System.out.println(newPassword+confirmPassword);
		System.out.println("From resetPasswordConfirmMethod"+Username);
		System.out.println("newPassword"+newPassword.length()+"ConfirmPassword"+confirmPassword.length());
		RepositoryDAO dao = new RepositoryDAO();
		if(newPassword.length() !=0 && confirmPassword.length() !=0 && newPassword.equals(confirmPassword)){
			dao.getConnection();
			dao.resetPassword(newPassword, Username);
			System.out.println("from resetPasswordConfirmMethod Loop");
			return "loginpage";
		}else{
			return "resetpassword";
		}
	}
}