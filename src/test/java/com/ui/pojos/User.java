package com.ui.pojos;

public class User {

	private String emailAddress;
	private String password;
	public String getEmailaddress() {
		return emailAddress;
	}
	public void setEmailaddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String emailAddress, String password) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [emailAddress=" + emailAddress + ", password=" + password + "]";
	}
	
	
}
