package com.tss.test;

import java.util.Scanner;

import com.tss.model.Book;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Book book1 = new Book();
		Book book2 = new Book();
		
		readValue(book1 , sc);
		System.out.println();
		readValue(book2 , sc);

		System.out.println();
		book1.display();
		System.out.println();
		book2.display();
	}
	
	public static void readValue(Book a , Scanner b) {
		System.out.print("Enter author name : ");
		a.setBookAuthor(b.nextLine());

		System.out.print("Enter book id : ");
		a.setBookId(b.nextInt());
		b.nextLine();  

		System.out.print("Enter Price of the book : ");
		a.setPrice(b.nextFloat());
		b.nextLine();  

		System.out.print("Enter publication of the book : ");
		a.setPublication(b.next());
		b.nextLine();  

		System.out.print("Enter book Name : ");
		a.setBookName(b.nextLine());
	}
}
