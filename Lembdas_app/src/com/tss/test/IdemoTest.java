package com.tss.test;

import com.tss.model.Idemo;

public class IdemoTest {
	public static void main(String[] args) {
		Idemo demo = ()->System.out.println("Lembda expression done");
		
		demo.display();
	}
}
