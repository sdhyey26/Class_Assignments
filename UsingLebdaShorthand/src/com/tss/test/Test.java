package com.tss.test;

import com.tss.model.Demo;
import com.tss.model.Idemo;

public class Test {
	public static void main(String[] args) {
		
		Idemo demo = Demo :: display;
		show(demo);
		Demo d1 = new Demo();

		Idemo demo1 = d1 :: show  ;
		show(demo1);
		
	}
	private static void show(Idemo demo)
	{
		demo.accept();
	}
}
