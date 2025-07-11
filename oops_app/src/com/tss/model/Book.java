package com.tss.model;

public class Book {
	private int bookId ;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	
	private String bookName ;
	private String bookAuthor ; 
	private String publication ;
	private float price ;
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public void display() {
	    System.out.println("--------------------------------------------------");
	    System.out.println("| Field               | Value                    |");
	    System.out.println("--------------------------------------------------");
	    System.out.println("| Book Name           | " + getBookName());
	    System.out.println("| Author              | " + getBookAuthor());
	    System.out.println("| Publication         | " + getPublication());
	    System.out.println("| Price               | " + getPrice());
	    System.out.println("| Discounted Price    | " + discountPrice());
	    System.out.println("--------------------------------------------------");
	}
	
	public float discountPrice() {
		float calculatePrice = (float) ((1 - 0.1) * price);
		return calculatePrice;
	}
	
}
