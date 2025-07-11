package com.tss.model;

public class Box {
	public Box(int width, int height, int depth) {
		super();
		this.width = width;
		this.height = height;
		this.depth = depth;
	}
	
	

	private int width;

	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getDepth() {
		return depth;
	}


	public void setDepth(int depth) {
		this.depth = depth;
	}

	private int height;
	private int depth;
	

	public void display() {
		System.out.println("width : " + width);
		System.out.println("height : " + height);
		System.out.println("depth : " + depth);
	}
}
