package com.tss.model;

public class UserModel {
    private String username;
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	private String password;
    private String role;
    private String theme;
	public UserModel(String username, String password, String role, String theme) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.theme = theme;
	}
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
