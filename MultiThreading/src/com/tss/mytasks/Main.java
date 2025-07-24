package com.tss.mytasks;

public class Main {
	public static void main(String[] args) {
		Thread thread = new Thread(new MyTasks(), "my_Task");
		
		thread.start();
	}
}
