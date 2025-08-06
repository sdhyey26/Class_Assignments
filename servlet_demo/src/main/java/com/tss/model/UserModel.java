package com.tss.model;

public class UserModel {
	
	private String password;
	private String userName;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserModel(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
}
