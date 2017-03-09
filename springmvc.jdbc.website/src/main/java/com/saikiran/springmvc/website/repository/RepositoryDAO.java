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
	private static final String SEQUENCE = "CREATE SEQUENCE id_seq";
	private static final String CREATE_TABLE = "create table registration (ID integer nextval('id_seq') primary key unique not null,Firstname text not null, Lastname text not null, Email text not null, Username text UNIQUE not null, Password text not null, Maidenname text not null";
	private static final String INSERT_REGISTER = "insert into registration (Firstname,Lastname,Email,Username,Password,Maidenname) values(?,?,?,?,?,?)";
	private static final String GET_DETAILS = "select exists(select Username,Password from registration where Username = ? and Password = ?)";

	public void getConnection(){
		try{
			Class.forName("org.postgresql.Driver");
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
		boolean isSequenceExists = false;
		boolean isTableExists = false;
		Statement stmt = null;
		try{
			getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select exists (select 1 from pg_tables where schemaname = 'public' and tablename = 'registration')");
			ResultSet rs1 = stmt.executeQuery("select * from id_seq");
			while(rs1.next()){
				isSequenceExists = rs1.getBoolean(1);
			}
			if(!isSequenceExists){
				stmt.execute(SEQUENCE);
			}
			while(rs.next()){
				isTableExists = rs.getBoolean(1);
			}
			if(!isTableExists){
				stmt.execute(CREATE_TABLE);
				System.out.println("****************Database Created Successfully***************");
			}
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		finally{
			try{
				stmt.close();
			}
			catch(SQLException sq){
				sq.printStackTrace();
			}
		}
	}
	public boolean insertUserInfo(ArrayList<UserInfo> info){
		PreparedStatement ps = null;
		boolean result = false;
		try{
			getConnection();
			for(int i=0; i<=info.size(); i++){
				getConnection();
				ps = con.prepareStatement(INSERT_REGISTER);
				ps.setString(1, info.get(i).getFirstname());
				ps.setString(2, info.get(i).getLastname());
				ps.setString(3, info.get(i).getEmail());
				ps.setString(4, info.get(i).getUsername());
				ps.setString(5, info.get(i).getPassword());
				ps.setString(6, info.get(i).getMaidenname());
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
		return result;
	}
	public boolean getDetails(ArrayList<UserInfo> userInfo){
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean userExists = false;
		try{
			getConnection();
			for(int i=0; i<=userInfo.size(); i++){
				ps = con.prepareStatement(GET_DETAILS);
				ps.setString(1, userInfo.get(i).getUsername());
				ps.setString(2, userInfo.get(i).getPassword());
				rs = ps.executeQuery();
			}
			while(rs.next()){
				userExists = rs.getBoolean(1);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				ps.close();
			}
			catch(SQLException s){
				s.printStackTrace();
			}
		}
		return userExists;
	}
	
}
