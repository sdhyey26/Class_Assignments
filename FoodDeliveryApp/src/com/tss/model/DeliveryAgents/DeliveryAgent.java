package com.tss.model.DeliveryAgents;

import java.io.Serializable;

public class DeliveryAgent implements Serializable{

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
