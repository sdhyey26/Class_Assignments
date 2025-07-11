package com.tss.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListTest {
	public static void main(String[] args) {

		ArrayList<String> names = new ArrayList<String>();

		names.add("Vivek");
		names.add("Dhyey");
		names.add("punit");
		names.add("uday");
		
		
		ArrayList<String> namesCopy = new ArrayList<String>(names);
		
		System.out.println("inside names copy : " + namesCopy.reversed());
		
		System.out.println(names);

		names.remove(3);

		System.out.println(names);

		names.add(2, "Dharmik");
		System.out.println(names);

		names.set(1, "Dev");
		System.out.println(names);

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		System.out.println();
		for (String object : names) {
			System.out.println(object);
		}

		Iterator<String> iterator = names.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next());
		}
		System.out.println();

		ListIterator<String> listIterator = names.listIterator();
		while (listIterator.hasNext()) {
			System.out.println(listIterator.next());
		}
		System.out.println();
		while (listIterator.hasPrevious()) {
			System.out.println(listIterator.previous());
		}
	}

}
