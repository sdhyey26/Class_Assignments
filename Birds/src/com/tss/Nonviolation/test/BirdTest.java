package com.tss.Nonviolation.test;

import com.tss.Nonviolation.model.Ostrich;
import com.tss.Nonviolation.model.Sparrow;
import com.tss.Nonviolation.model.pigeon;

public class BirdTest {
	public static void main(String[] args) {
		Ostrich ostrich = new Ostrich();
		pigeon pigeon = new pigeon();
		Sparrow sparrow = new Sparrow();
		
		
		ostrich.cannotFly();
		ostrich.getColor();
		
		pigeon.canFly();
		pigeon.getColor();
		
		sparrow.canFly();
		sparrow.getColor();
	}
}
