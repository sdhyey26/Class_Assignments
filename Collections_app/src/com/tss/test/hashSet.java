package com.tss.test;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class hashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> s = new HashSet<>();
		
		s.add(10);
		s.add(20);
		s.add(40);
		s.add(30);
		s.add(60);

		System.out.println(s);
		
		Set<Integer> p = new LinkedHashSet<>();
		
		p.add(10);
		p.add(20);
		p.add(40);
		p.add(30);
		p.add(60);
		
		System.out.println(p);
		
		Set<Integer> d = new TreeSet<>();
		
		d.add(10);
		d.add(20);
		d.add(40);
		d.add(30);
		d.add(60);
		
		System.out.println(d);
		
	}	

}
