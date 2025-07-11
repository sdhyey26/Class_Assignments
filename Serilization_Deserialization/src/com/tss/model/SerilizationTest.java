package com.tss.model;

import java.io.Serializable;

public class SerilizationTest implements Serializable {
	public int id;
	public String name;

	public SerilizationTest(int id, String name) {
		this.id = id;
		this.name = name;
	}
}