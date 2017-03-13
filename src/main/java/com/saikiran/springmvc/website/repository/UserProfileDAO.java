package com.saikiran.springmvc.website.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserProfileDAO {
	private static final String CREATE_USER = "create table if not exists userprofile(id integer default nextval('id_seq3') not null, username text unique not null, foreign key(username) references registration(username), friendemail text unique)";
	private static final String INSERT_FRIEND_EMAIL = "insert into userprofile(username) values(?)";
	private static final String CHECK_EMAIL = "select exists(select friendemail from userprofile where username = ? and friendemail=?)";
	Connection con = null;
	public void getConnection(){
		try{
			//Driver Initialization
			Class.forName("org.postgresql.Driver");
			//Connection Establishment
			con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/website", "postgres", "SaiKiran16");
			
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException s){
			s.printStackTrace();
		}
	}

	public  void createRegistration() {
		Statement stmt = null;
		try{
			getConnection();
			//create connection
			stmt = con.createStatement();
			stmt.execute(CREATE_USER);
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
	public boolean setFriendEmail(String Username){
		PreparedStatement ps = null;
		boolean result = false;
		try{
			getConnection();
			ps = con.prepareStatement(INSERT_FRIEND_EMAIL);
			ps.setString(1, Username);
			result =  ps.execute();
			if(result==false){
				System.out.println("********From UserProfileDAO:::::Values Successfully inserted into database**********");
			}else{
				System.out.println("********From UserProfileDAO:::::Something Went Wrong***********");
			}
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
		return false;
	}
	
	public boolean checkFriendEmail(String Username, String Email){
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		try{
			ps = con.prepareStatement(CHECK_EMAIL);
			ps.setString(1, Username);
			ps.setString(2, Email);
			rs =  ps.executeQuery();
			while(rs.next()){
				result = rs.getBoolean(1);
			}
			if(result){
				System.out.println("********Email Exists**********");
			}else{
				System.out.println("********Doesn't Exist***********");
			}
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
