package com.saikiran.springmvc.jdbc.website.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saikiran.springmvc.jdbc.website.repository.RepositoryDAO;


@Controller
@RequestMapping("/forgotpassword")
public class ForgotPasswordController {

	@RequestMapping( method = RequestMethod.GET)
	public String passwordCheck() {
		return "forgotpassword";
	}
	
	 @Autowired
	    private JavaMailSender mailSender;
	
	@RequestMapping(method = RequestMethod.POST)
	public String sendPasswordEmailLinkMethod(HttpServletRequest req) {
		
		String recipientAddress = req.getParameter("Recipient");
		String Username = LoginController.user;
        String subject = "Forgot Password Link";
        String message = "http://localhost:8080/springmvc.jdbc.website/forgotpassword/resetpassword";
        
        RepositoryDAO dao = new RepositoryDAO();
        dao.getConnection();
        if(dao.usernameEmailCheckMethod(Username, recipientAddress)){
        	  
        	// displaying details in the console
            System.out.println("To: " + recipientAddress);
            System.out.println("Subject: " + subject);
            System.out.println("Message: " + message);
             
            // creates a simple e-mail object
            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(recipientAddress);
            email.setSubject(subject);
            email.setText(message);
             
            // sends the e-mail
            mailSender.send(email);
             req.setAttribute("Email", recipientAddress);
            return "resetPasswordLinkCheck";
        }
        else{
        	return "forgotpassword";
        }
	}
	
	@RequestMapping(value = "/resetpassword",method = RequestMethod.GET)
	public String passwordCheckGetMethod() {
		return "resetpassword";
	}
	
	@RequestMapping(value = "/resetpassword",method = RequestMethod.POST)
	public String resetPasswordConfirmMethod(HttpServletRequest req){
		String newPassword = req.getParameter("NewPassword");
		String confirmPassword = req.getParameter("ConfirmPassword");
		String Username = LoginController.user;
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
