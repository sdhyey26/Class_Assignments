package com.tss.model;

import java.io.Serializable;

public class DeliveryAgents implements Serializable{

	private String name ;
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "DeliveryAgents [name=" + name + "]";
	}
}
