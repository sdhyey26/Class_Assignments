package com.tss.model;

public class CustomerModel {
	
	private String name;
	private int age;
	private int income ;
	private int creditScore;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	@Override
	public String toString() {
		return "CustomerModel [name=" + name + ", age=" + age + ", income=" + income + ", creditScore=" + creditScore
				+ "]";
	}
}
