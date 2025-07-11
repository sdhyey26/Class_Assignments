package com.tss.test;

import java.util.Scanner;

import com.tss.model.BookConstructor;

public class BookConstructorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BookConstructor book1 = null;
		readValue(sc , book1);
	}
	
	public static void readValue(Scanner scanner , BookConstructor book1) {
		System.out.print("Enter author name : ");
		String name = scanner.next();

		System.out.print("Enter book id : ");
		int bookId = scanner.nextInt();

		System.out.print("Enter Price of the book : ");
		float price = scanner.nextFloat();

		System.out.print("Enter publication of the book : ");
		String publication = scanner.next();  

		System.out.print("Enter book Name : ");
		String bookName = scanner.next();
		
		book1 = new BookConstructor(bookId , bookName , name , publication , price );
		
		book1.display();
	}

}
