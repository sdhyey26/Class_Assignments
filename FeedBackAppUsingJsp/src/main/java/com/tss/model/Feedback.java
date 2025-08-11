package com.tss.model;

public class Feedback {
	private String name;
	private String sessionDate;
    private int sessionContent, queryFeedback, interactivity, impactfulLearning, deliverySkills;
	
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSessionDate() {
		return sessionDate;
	}
	public void setSessionDate(String sessionDate) {
		this.sessionDate = sessionDate;
	}
	public int getSessionContent() {
		return sessionContent;
	}
	public void setSessionContent(int sessionContent) {
		this.sessionContent = sessionContent;
	}
	public int getQueryFeedback() {
		return queryFeedback;
	}
	public void setQueryFeedback(int queryFeedback) {
		this.queryFeedback = queryFeedback;
	}
	public int getInteractivity() {
		return interactivity;
	}
	public void setInteractivity(int interactivity) {
		this.interactivity = interactivity;
	}
	public int getImpactfulLearning() {
		return impactfulLearning;
	}
	public void setImpactfulLearning(int impactfulLearning) {
		this.impactfulLearning = impactfulLearning;
	}
	public int getDeliverySkills() {
		return deliverySkills;
	}
	public void setDeliverySkills(int deliverySkills) {
		this.deliverySkills = deliverySkills;
	}
	
}
