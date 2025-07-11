package com.tss.model;

public class Product{
	   private int id;
	    private String name;
	    private double price;
	    private double discountPercent;

	    /**
	     * Constructs a new Product.
	     *
	     * @param id The product ID.
	     * @param name The product name.
	     * @param price The product price.
	     * @param discountPercent The discount percentage for the product.
	     */
	    public Product(int id, String name, double price, double discountPercent) {
	        this.id = id;
	        this.name = name;
	        this.price = price;
	        this.discountPercent = discountPercent;
	    }

	    // Getters and Setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }

	    public double getDiscountPercent() {
	        return discountPercent;
	    }

	    public void setDiscountPercent(double discountPercent) {
	        this.discountPercent = discountPercent;
	    }

	    /**
	     * Calculates the discounted price of the product.
	     *
	     * @return The price after applying the discount.
	     */
	    public double calculateDiscountedPrice() {
	        return price -= (price * discountPercent / 100);
	        
	    }
}
