package com.tss.test;

import com.tss.model.MyThread;
import com.tss.mytasks.MyTasks;

public class ThreadRun {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread());
		
		Thread.currentThread().setName("Main");
		System.out.println(Thread.currentThread());
		Thread.currentThread().setPriority(9);
		System.out.println(Thread.currentThread());
		
		Thread thread = new Thread(new MyTasks());
		thread.start();
		
		MyThread thread1 = new MyThread("thread 1");
		thread1.start();
		thread1.setPriority(5);
		
		
		try {
			Thread.sleep(10000);
		}
		catch(Exception e)  {
			e.printStackTrace();
		}
		System.out.println("Exiting");
	}
}
