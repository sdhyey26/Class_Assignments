package com.tss.model;

import com.tss.exception.AgeNotValidException;

public class voter {
	private String name;
	private int voterId,age;
	
	public voter(String name, int voterId, int age) throws AgeNotValidException {
		super();
		this.name = name;
		this.voterId = voterId;
		if(age<18)
			throw new AgeNotValidException(age);
		this.age = age;
		System.out.println(toString());;
	}
	
	

	@Override
	public String toString() {
		return "voter [name=" + name + ", voterId=" + voterId + ", age=" + age + "]";
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVoterId() {
		return voterId;
	}

	public void setVoterId(int voterId) {
		this.voterId = voterId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws AgeNotValidException {
		if(age<18)
			throw new AgeNotValidException(age);
		this.age = age;
	}
}
