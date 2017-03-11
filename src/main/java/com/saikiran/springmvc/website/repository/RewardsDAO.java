package com.saikiran.springmvc.website.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.saikiran.springmvc.website.model.UserInfo;

public class RewardsDAO {
	private static final String INSERT_DETAILS = "insert into rewards(username,rewards,balance) values(?,?,?)";
	private static final String GET_DETAILS = "select balance,rewards from rewards where username = ?";
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
	public boolean insertDetails(String Username, long Rewards, long Balance){
		PreparedStatement ps = null;
		boolean result = false;
		try{
			getConnection();
			ps = con.prepareStatement(INSERT_DETAILS);
			ps.setString(1, Username);
			ps.setLong(2, Rewards);
			ps.setLong(3, Balance);
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
	
}
