package com.tss.withoutViolation.model;

public class InvoiceModel {
	
	
	public InvoiceModel(int id, String description, double cost, double discountPercent) {
		super();
		this.id = id;
		this.description = description;
		this.cost = cost;
		this.discountPercent = discountPercent;
	}
	private int id;
    public InvoiceModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String description;
    private double cost;
    private double discountPercent;
	private final double tax = 10.0;
        
    public  double getTax() {
		return tax;
	}
	
	public  int getId() {
		return id;
	}
	public  void setId(int id) {
		this.id = id;
	}
	public  String getDescription() {
		return description;
	}
	public  void setDescription(String description) {
		this.description = description;
	}
	public  double getCost() {
		return cost;
	}
	public  void setCost(double cost) {
		this.cost = cost;
	}
	public  double getDiscountPercent() {
		return discountPercent;
	}
	public  void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

}
