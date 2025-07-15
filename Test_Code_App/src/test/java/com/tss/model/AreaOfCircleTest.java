package com.tss.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AreaOfCircleTest {

	AreaOfCircle circle;
	
	@BeforeEach
	void init() {
		 circle = new AreaOfCircle();
	}
	
	
	@Test
	void test() {
		assertEquals(314, circle.calculateCircleArea(10));
	}

}
