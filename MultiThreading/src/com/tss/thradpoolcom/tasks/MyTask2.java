package com.tss.thradpoolcom.tasks;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyTask2 implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		Random random = new Random();
		return random.nextInt();
	}



}
