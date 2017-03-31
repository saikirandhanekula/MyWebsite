package com.saikiran.springmvc.jdbc.website.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saikiran.springmvc.jdbc.website.model.UserInfo;
import com.saikiran.springmvc.jdbc.website.repository.RepositoryDAO;
import com.saikiran.springmvc.jdbc.website.repository.RewardsDAO;
import com.saikiran.springmvc.jdbc.website.repository.UserProfileDAO;

@Controller
@RequestMapping("/")
public class LoginController {
	
	static String m="";
	static int amount = 0;
	static String user="";
	
	@RequestMapping(method = RequestMethod.GET)
	public String passwordCheck(){
		return "loginpage";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String userDetails(HttpServletRequest req){
	    String Username = new String();
	    	Username=req.getParameter("Username");
		String Password = new String();
			Password=req.getParameter("Password");
		m=Username;
	    RepositoryDAO dao = new RepositoryDAO();
		dao.getConnection();
	if(dao.getDetails(Username, Password)){
		UserInfo user = new UserInfo();
		RewardsDAO udao = new RewardsDAO();
		user = udao.getBalance(Username);
		long balance = user.getBalance();
		long rewards = user.getRewards();
		System.out.println("from balancePostMethod "+balance+rewards);
		
		req.setAttribute("Username", Username);
		req.setAttribute("Balance", balance);
			return "welcome";
			
		}
		else{
			return "loginpage";
	}
	}
	
	@RequestMapping(value = "/logout")
	public String logoutPostMethod(){
		return "loginpage";
	}
	
	@RequestMapping(value="/register",method = RequestMethod.GET)
	public String getDetails(@ModelAttribute UserInfo info, ModelMap model){
		UserInfo ui = new UserInfo();
		model.addAttribute("userInfo", ui);
		return "register";
	}
	
	 @RequestMapping(value="/register",method=RequestMethod.POST)
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
		 
		 if(dao.userNameCheckMethod(Username)){
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
	 
	 @RequestMapping(value = "/registrationError",method = RequestMethod.GET)
		public String errorGetMethod(){
			return "registrtionError";
		}
	
	@RequestMapping(value="/balancepage",method = RequestMethod.GET)
	public String balanceGetMethod(){
		
		return "balancepage";
	}
	@RequestMapping(value="/balancepage",method = RequestMethod.POST)
	public String balancePostMethod(HttpServletRequest req){
		String Username = m;
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
	
	@RequestMapping(value="/rewardspage",method = RequestMethod.GET)
	public String rewardsGetmethod(){
		return "rewardspage";
	}
	@RequestMapping(value="/rewardspage",method = RequestMethod.POST)
	public String rewardsPostMethod(HttpServletRequest req){
		String Username = m;
		UserInfo info = new UserInfo();
		RewardsDAO dao = new RewardsDAO();
		info = dao.getBalance(Username);
		long rewards = info.getRewards();
		System.out.println("from rewardsPostMethod::"+rewards);
		req.setAttribute("Username", Username);
		req.setAttribute("Rewards", rewards);
		return "rewardspage";
	}
	
	@RequestMapping(value = "/profile",method = RequestMethod.GET)
	public String displayProfile(ModelMap model){
		System.out.println("from get method");
		return "profile";
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String retrievedDetails(HttpServletRequest req){
		String userName = m;
		System.out.println(m);
		System.out.println("from Profile Controller class retrievedData method "+userName);
		ArrayList<UserInfo> userData = new ArrayList<UserInfo>();
		RepositoryDAO repDao = new RepositoryDAO();
		repDao.getConnection();
		userData = repDao.retrieveData(userName);
		
		String Firstname="",Lastname="",Maidenname="",Email="",Username="";
		long Phone =0;
		  Firstname =userData.get(0).getFirstname();
		  Lastname = userData.get(0).getLastname();
		  Maidenname = userData.get(0).getMaidenname();
		  Email = userData.get(0).getEmail();
		  Username = userData.get(0).getUsername();
		 Phone = (long) userData.get(0).getPhone();
			
		 System.out.println(Firstname);
		 System.out.println(Lastname);
		 System.out.println(Maidenname);
		 System.out.println(Email);
		 System.out.println(Username);
		 System.out.println(Phone);
		 
	     req.setAttribute("Firstname", Firstname);
		 req.setAttribute("Lastname", Lastname);
		 req.setAttribute("Maidenname", Maidenname);
		 req.setAttribute("Email", Email);
		 req.setAttribute("Username", Username);
		 req.setAttribute("Phone", Phone);
		 
		return "profile";
	}

		@RequestMapping(value = "/makepayment" , method = RequestMethod.GET)
		public String makepaymentGetMethod() {
			return "makepayment";
		}

		@RequestMapping(value = "/makepayment" , method = RequestMethod.POST)
		public String makepaymnetPostMethod(HttpServletRequest req) {
			String Email = req.getParameter("email");
			System.out.println(Email);
			int amount = Integer.parseInt(req.getParameter("amount"));
			System.out.println(amount);
			String Username = m;
			System.out.println(Username);
			UserProfileDAO userDAO = new UserProfileDAO();
			userDAO.getConnection();
			if (userDAO.checkFriendEmail(Username, Email)) {
				RewardsDAO rewardsDao = new RewardsDAO();
				rewardsDao.getConnection();
				rewardsDao.makePayment(amount, Username);
				rewardsDao.updatePayment(amount, Email);
				if (amount == 500) {
					rewardsDao.getConnection();
					rewardsDao.updateRewards(30, Username);
					req.setAttribute("Name", Username);
					req.setAttribute("Rewards", "Congrats...You are Earned 30 Rewards...!!!");
					return "paymentsuccess";
				} else if (amount == 1000) {
					rewardsDao.getConnection();
					rewardsDao.updateRewards(100, Username);
					req.setAttribute("Name", Username);
					req.setAttribute("Rewards", "Congrats...You are Earned 100 Rewards...!!!");
					return "paymentsuccess";
				} else if (amount == 1500) {
					rewardsDao.getConnection();
					rewardsDao.updateRewards(150, Username);
					req.setAttribute("Name", Username);
					req.setAttribute("Rewards", "Congrats...You are Earned 150 Rewards...!!!");
					return "paymentsuccess";
				} else {
					req.setAttribute("Name", Username);
					req.setAttribute("Rewards", "Payment Successfully Submitted....");
					return "paymentsuccess";
				}
			} else {
				req.setAttribute("Error", "Email Doesn't Exist....!!!!");
				return "makePaymentError";
			}
		}
		
		@RequestMapping(value = "/addfriendemail", method = RequestMethod.GET)
		public String addFriendEmailGetMethod(HttpServletRequest req){
			return "addFriendEmail";
		}
		
		@RequestMapping(value = "/addfriendemail", method = RequestMethod.POST)
		public String addFriendEmail(HttpServletRequest req){
			String Email = req.getParameter("FriendEmail");
			UserProfileDAO profileDAO = new UserProfileDAO();
			String Username = m;
			profileDAO.getConnection();
			if(!profileDAO.addFriendEmail(Username, Email)){
				return "makepayment";
			}else{
				return "addFriendError";
			}
			
		}
		

		@RequestMapping(value = "/paybills",method = RequestMethod.GET)
		public String payBillsGetMethod(){
			return "paybills";
		}
		
		@RequestMapping(value = "/paybills",method = RequestMethod.POST)
		public String payBillsPostMethod(HttpServletRequest req){
			int amount = Integer.parseInt(req.getParameter("Amount"));
			String Username = m;
			RewardsDAO dao = new RewardsDAO();
			dao.getConnection();
			if(dao.payBillMethod(amount, Username)==1){
				return "payBillSuccess";
			}
			else{
				return "payBillFailure";
			}
			
		}
		
		@RequestMapping(value = "/UsernameValidationPage", method = RequestMethod.GET)
		public String usernameValidationMethod(){
			
			return "UsernameValidationPage";
		}
		
		@RequestMapping(value = "/UsernameValidationPage",method = RequestMethod.POST)
		public String usernameValidationCheckMethod(HttpServletRequest req){
			String Username = req.getParameter("Username");
			user = Username;
			RepositoryDAO dao = new RepositoryDAO();
			dao.getConnection();
			if(dao.userNameCheckMethod(Username)){
				return"forgotpassword";
			}else{
				return "nouserexists";
			}
			
		}
}