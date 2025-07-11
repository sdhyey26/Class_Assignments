package com.tss.model;

public class BookConstructor {
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private String publication;
	private float price;

	public BookConstructor(int bookId ,String bookName, String bookAuthor , String publication , float price ) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.publication = publication;
		this.price = price;
	}

	public void display() {
		System.out.println("--------------------------------------------------");
		System.out.println("| Field               | Value                    |");
		System.out.println("--------------------------------------------------");
		System.out.println("| Book Name           | " + bookName);
		System.out.println("| Author              | " + bookAuthor);
		System.out.println("| Publication         | " + publication);
		System.out.println("| Price               | " + price);
		System.out.println("| Discounted Price    | " + discountPrice());
		System.out.println("--------------------------------------------------");
	}

	public float discountPrice() {
		float calculatePrice = (float) ((1 - 0.1) * price);
		return calculatePrice;
	}
}
