package com.tss.thradpool.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.tss.thradpoolcom.tasks.MyTask2;
import com.tss.thradpoolcom.tasks.Mytask;

public class Main {
	public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();	
        
        List<MyTask2> tasks = Arrays.asList(new MyTask2() , new MyTask2() , new MyTask2() ,new MyTask2());
        
        
        try {
			List<Future<Integer>> futures = service.invokeAll(tasks);
			
			for(Future<Integer> future : futures)
				System.out.println(future.get());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        service.submit(new Mytask() );
        
        service.shutdown();
	
	}
}
