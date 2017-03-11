package com.saikiran.springmvc.website.model;

public class UserInfo {
	
	private String Firstname;
	private String Lastname;
	private String Email;
	private String Username;
	private String Password;
	private String Maidenname;
	private double Phone;
	private long balance;
	private long rewards;
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getMaidenname() {
		return Maidenname;
	}
	public void setMaidenname(String maidenname) {
		Maidenname = maidenname;
	}
	public double getPhone() {
		return Phone;
	}
	public void setPhone(double phone) {
		Phone = phone;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public long getRewards() {
		return rewards;
	}
	public void setRewards(long rewards) {
		this.rewards = rewards;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((Firstname == null) ? 0 : Firstname.hashCode());
		result = prime * result + ((Lastname == null) ? 0 : Lastname.hashCode());
		result = prime * result + ((Maidenname == null) ? 0 : Maidenname.hashCode());
		result = prime * result + ((Password == null) ? 0 : Password.hashCode());
		long temp;
		temp = Double.doubleToLongBits(Phone);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((Username == null) ? 0 : Username.hashCode());
		result = prime * result + (int) (balance ^ (balance >>> 32));
		result = prime * result + (int) (rewards ^ (rewards >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo other = (UserInfo) obj;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (Firstname == null) {
			if (other.Firstname != null)
				return false;
		} else if (!Firstname.equals(other.Firstname))
			return false;
		if (Lastname == null) {
			if (other.Lastname != null)
				return false;
		} else if (!Lastname.equals(other.Lastname))
			return false;
		if (Maidenname == null) {
			if (other.Maidenname != null)
				return false;
		} else if (!Maidenname.equals(other.Maidenname))
			return false;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (Double.doubleToLongBits(Phone) != Double.doubleToLongBits(other.Phone))
			return false;
		if (Username == null) {
			if (other.Username != null)
				return false;
		} else if (!Username.equals(other.Username))
			return false;
		if (balance != other.balance)
			return false;
		if (rewards != other.rewards)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserInfo [Firstname=" + Firstname + ", Lastname=" + Lastname + ", Email=" + Email + ", Username="
				+ Username + ", Password=" + Password + ", Maidenname=" + Maidenname + ", Phone=" + Phone + ", balance="
				+ balance + ", rewards=" + rewards + "]";
	}
	
}
