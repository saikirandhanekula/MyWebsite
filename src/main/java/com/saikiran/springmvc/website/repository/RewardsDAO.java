package com.saikiran.springmvc.website.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RewardsDAO {
	private static final String GET_DETAILS = "select rewards from rewards where username = ?";
	
	Connection con = null;
	PreparedStatement ps = null;
	
	public void getConnection(){
		try {
			Class.forName("org.postgres.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/website", "postgres", "SaiKiran16");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	public long getDetails(String Username){
		PreparedStatement ps = null;
		ResultSet rs = null;
		long rewards=0;
		try{
			getConnection();
			ps = con.prepareStatement(GET_DETAILS);
			ps.setString(1, Username);
			rs = ps.executeQuery();
			while(rs.next()){
			   rewards = rs.getLong(1); 
			}
			System.out.println("From RepositoryDAO class getDetails method"+rewards);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return rewards;
	}
}
