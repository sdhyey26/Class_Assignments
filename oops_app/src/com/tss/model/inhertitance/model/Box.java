package com.tss.model.inhertitance.model;

public class Box {
	public Box(int weight, int depth, int height) {
		super();
		this.weight = weight;
		this.depth = depth;
		this.height = height;
	}
	public Box() {
		super();
	}
	
	private int depth;
	private int height;
	private int weight;

	public void display() {
		System.out.println("weight : " + weight);
		System.out.println("height : " + height);
		System.out.println("depth : " + depth);
	}
	
}
