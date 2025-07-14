package com.tss.behavioral.observer.model;

public class SmsNotifier implements Inotifier{

	@Override
	public void sendNotification(int amount) {
		// TODO Auto-generated method stub
		System.out.println("Sms notification");
		System.out.println("the updated balance is : " + amount);
	}

}
