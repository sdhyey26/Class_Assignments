package com.tss.test;

public class friends {
	String name;
	friends buddy;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public friends getBuddy() {
		return buddy;
	}
	public void setBuddy(friends buddy) {
		this.buddy = buddy;
	}
	
	
	public friends(String name ) {
		this.name = name;
		
	}
	
}
