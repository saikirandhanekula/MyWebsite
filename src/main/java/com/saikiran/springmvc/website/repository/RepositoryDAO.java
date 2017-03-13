package com.saikiran.springmvc.website.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.saikiran.springmvc.website.model.UserInfo;

public class RepositoryDAO {
	Connection con;
	private static final String CREATE_TABLE = "create table if not exists registration (id integer default nextval('id_seq1') primary key unique not null,firstname text not null, lastname text not null, maidenname text not null, email text unique not null, username text UNIQUE not null, password text not null, phone double precision not null)";
	private static final String INSERT_REGISTER = "insert into registration (firstname,lastname,maidenname,email,username,password,phone) values(?,?,?,?,?,?,?)";
	private static final String GET_DETAILS = "select exists(select username,password from registration where username = ? and password = ?)";
	private static final String PRINT_DETAILS = "select firstname,lastname,maidenname,email,username,phone from registration where username = ?";
	private static final String USERNAME_MAIL_CHECK = "select exists(select username,email from registration where username = ? and email = ?)";
	private static final String REPLACE_PASSWORD = "update registration set password = ? where username = ?";
	private static final String USER_CHECK = "select exists(select username from registration where username = ?)";
	
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
	//Passing arraylist to database
	public boolean insertUserInfo(ArrayList<UserInfo> info){ 
		PreparedStatement ps = null;
		boolean result = false;
		try{
			getConnection();
			for(int i=0; i<info.size(); i++){
				getConnection();
				ps = con.prepareStatement(INSERT_REGISTER);
				ps.setString(1, info.get(i).getFirstname());
				ps.setString(2, info.get(i).getLastname());
				ps.setString(3, info.get(i).getMaidenname());
				ps.setString(4, info.get(i).getEmail());
				ps.setString(5, info.get(i).getUsername());
				ps.setString(6, info.get(i).getPassword());
				ps.setDouble(7, info.get(i).getPhone());
				result = ps.execute();
				ps.close();
			}
			if(result == false){
				System.out.println("****************Values Inserted Successfully***************");
			}
			else{
				System.out.println("Something Went Wrong Please Try Again!!!");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}
			catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		return result;
	}
	//collecting the results from database and returning the results
	public boolean getDetails(String Username, String Password){
		PreparedStatement ps = null;
		boolean isUserExists = false;
		ResultSet rs = null;
		try{
			getConnection();
			ps = con.prepareStatement(GET_DETAILS);
			ps.setString(1, Username);
			ps.setString(2, Password);
			rs = ps.executeQuery();
			while(rs.next()){
				 isUserExists = rs.getBoolean(1); 
			}
			System.out.println("From RepositoryDAO class getDetails method"+isUserExists);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
				ps.close();
			}
			catch(SQLException s){
				s.printStackTrace();
			}
		}
		return isUserExists;
	}
	public ArrayList<UserInfo> retrieveData(String Username){
		getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<UserInfo> userInfo = new ArrayList<UserInfo>(); 
		UserInfo info = new UserInfo();
		try{
			ps = con.prepareStatement(PRINT_DETAILS);
			ps.setString(1, Username);
			rs = ps.executeQuery();
			while(rs.next()){
				String Firstname = rs.getString(1);
				String Lastname = rs.getString(2);
				String MaidenName = rs.getString(3);
				String Email = rs.getString(4);
				String userName = rs.getString(5);
				double Phone = rs.getDouble(6);
				info.setFirstname(Firstname);
				info.setLastname(Lastname);
				info.setMaidenname(MaidenName);
				info.setEmail(Email);
				info.setUsername(userName);
				info.setPhone(Phone);
				System.out.println("From RepositoryDAO class retrievedData method"+Firstname);
				userInfo.add(info);
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
		return userInfo;
	}
	
	public boolean usernameEmailCheckMethod(String Username,String Email){
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		try{
			getConnection();
			ps = con.prepareStatement(USERNAME_MAIL_CHECK);
			ps.setString(1, Username);
			ps.setString(2, Email);
			rs = ps.executeQuery();
			while(rs.next()){
				result = rs.getBoolean(1);
			}
			System.out.println("From RepositoryDAO class UsernameEmailCheck method"+result);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
				ps.close();
			}
			catch(SQLException s){
				s.printStackTrace();
			}
		}
		return result;
	}
	
	public boolean userNameCheckMethod(String Username){
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		try{
			getConnection();
			ps = con.prepareStatement(USER_CHECK);
			ps.setString(1, Username);
			rs = ps.executeQuery();
			while(rs.next()){
				result = rs.getBoolean(1);
			}
			System.out.println("From RepositoryDAO class UsernameCheck method"+result);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
				ps.close();
			}
			catch(SQLException s){
				s.printStackTrace();
			}
		}
		return result;
	}
	
	public int resetPassword(String NewPassword, String Username){
		PreparedStatement ps = null;
		int result = 0;
		try{
			getConnection();
			ps = con.prepareStatement(REPLACE_PASSWORD);
			ps.setString(1, NewPassword);
			ps.setString(2, Username);
			result = ps.executeUpdate();
			if(result == 1){
				
				System.out.println("From RepositoryDAO class resetPassword method"+result);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
				ps.close();
			}
			catch(SQLException s){
				s.printStackTrace();
			}
		}
		return result;
	}
}
