package com.tss.waitNotify;

public class Consumer implements Runnable {

	Q q;

	Consumer(Q q) {
		this.q = q;
		new Thread(this, "Consumer").start();
	}

	public void run() {
		
		for(int i = 0 ; i < 10 ; i++) {
			q.get();
		}

	}
}
