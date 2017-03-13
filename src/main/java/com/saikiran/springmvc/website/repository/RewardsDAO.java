package com.saikiran.springmvc.website.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.saikiran.springmvc.website.model.UserInfo;

public class RewardsDAO {
	private static final String CREATE_TABLE = "create table if not exists rewards(id integer default nextval('id_seq2') primary key unique not null, username text unique not null, foreign key(username) references registration(username),email text unique not null, foreign key(email) references registration(email), rewards integer not null, balance integer not null)";
	private static final String INSERT_DETAILS = "insert into rewards(username,email,rewards,balance) values(?,?,?,?)";
	private static final String GET_DETAILS = "select balance,rewards from rewards where username = ?";
	private static final String MAKE_PAYMENT = "update rewards set balance = balance-? where username = ?";
	private static final String UPDATE_PAYMENT = "update rewards set balance = balance+? where email=?";
	private static final String UPDATE_REWARDS = "update rewards set rewards = rewards+? where username = ?";
	private static final String PAY_BILL = "update rewards set balance = balance+? where username = ?";
	Connection con = null;
	PreparedStatement ps = null;
	
	public void getConnection(){
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/website", "postgres", "SaiKiran16");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public  void createRegistration() {
		Statement stmt = null;
		try{
			getConnection();
			//create connection
			stmt = con.createStatement();
			stmt.execute(CREATE_TABLE);
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		finally{
			try{
				stmt.close();
				con.close();
			}
			catch(SQLException sq){
				sq.printStackTrace();
			}
		}
	}
	
	public boolean insertDetails(String Username,String Email, long Rewards, long Balance){
		PreparedStatement ps = null;
		boolean result = false;
		try{
			getConnection();
			ps = con.prepareStatement(INSERT_DETAILS);
			ps.setString(1, Username);
			ps.setString(2, Email);
			ps.setLong(3, Rewards);
			ps.setLong(4, Balance);
			result = ps.execute();
			System.out.println("From RewardsDAO class getDetails method"+result);
			if(result==false){
				System.out.println("**********Values successfully inserted into Rewards table************");
			}else{
				System.out.println("**********Something went wrong***********");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				ps.close();
				con.close();
			}
			catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		return result;
	}
	//Getting User Balance from database
	public UserInfo getBalance(String Username){
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserInfo userInfo = new UserInfo();
		
		try{
			getConnection();
			ps = con.prepareStatement(GET_DETAILS);
			ps.setString(1, Username);
			rs = ps.executeQuery();
			while(rs.next()){
				userInfo.setBalance(rs.getLong(1));
				userInfo.setRewards(rs.getLong(2));
			}
			System.out.println("From getBalance method"+userInfo.getBalance()+userInfo.getRewards());
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				ps.close();
				con.close();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		return userInfo;
	}
	
	
	public int makePayment(int amount, String username){
		PreparedStatement ps = null;
		int result = 0;
		try{
			getConnection();
			ps = con.prepareStatement(MAKE_PAYMENT);
			ps.setInt(1, amount);
			ps.setString(2, username);
			result = ps.executeUpdate();
			if(result == 1){
				System.out.println("***********Updated Successfully to the database**********");
			}
			else
				System.out.println("*************Something went wrong*******************");
			System.out.println("from RewardsDAO Class makePaymentMethod::"+result);
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				ps.close();
				con.close();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		return result;
	}
	public int updatePayment(int amount, String email){
		PreparedStatement ps = null;
		int result = 0;
		try{
			getConnection();
			ps = con.prepareStatement(UPDATE_PAYMENT);
			ps.setInt(1, amount);
			ps.setString(2, email);
			result = ps.executeUpdate();
			if(result == 1){
				System.out.println("***********Updated Successfully to the database**********");
			}
			else
				System.out.println("*************Something went wrong*******************");
			System.out.println("from RewardsDAO Class makePaymentMethod::"+result);
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				ps.close();
				con.close();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int updateRewards(int amount, String username){
		PreparedStatement ps = null;
		int result = 0;
		try{
			getConnection();
			ps = con.prepareStatement(UPDATE_REWARDS);
			ps.setInt(1, amount);
			ps.setString(2, username);
			result = ps.executeUpdate();
			if(result == 1){
				System.out.println("***********Updated Successfully to the database**********");
			}
			else
				System.out.println("*************Something went wrong*******************");
			System.out.println("from RewardsDAO Class makePaymentMethod::"+result);
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				ps.close();
				con.close();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int payBillMethod(int amount, String username){
		PreparedStatement ps = null;
		int result = 0;
		try{
			getConnection();
			ps = con.prepareStatement(PAY_BILL);
			ps.setInt(1, amount);
			ps.setString(2, username);
			result = ps.executeUpdate();
			if(result == 1){
				System.out.println("***********Updated Successfully to the database**********");
			}
			else
				System.out.println("*************Something went wrong*******************");
			System.out.println("from RewardsDAO Class payBillMethod::"+result);
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				ps.close();
				con.close();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		return result;
	}
}
