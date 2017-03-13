package com.saikiran.springmvc.website.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saikiran.springmvc.website.repository.RepositoryDAO;

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
		String Username = UsernameValidationPageController.user;
        String subject = "Forgot Password Link";
        String message = "http://localhost:8080/springmvc.jdbc.website/resetpassword";
        
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
	
}
