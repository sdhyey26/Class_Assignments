package com.tss.behavioral.observer.model;

public class WhatsappNotifier implements Inotifier{

	@Override
	public void sendNotification(int amount) {
		// TODO Auto-generated method stub
		System.out.println("Whatspp notification");
		System.out.println("the updated balance is : " + amount);
		
	}

}
