package com.tss.test;

import java.util.Scanner;

class FixedDeposit {
     public static int accountNumber;
    public static String name;
    public static  double principal;
    public static int duration;
    public static String festival;

    public FixedDeposit(int accountNumber, String name, double principal, int duration, String festival) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.principal = principal;
        this.duration = duration;
        this.festival = festival;
    }

    public double calculateSimpleInterest() {
        double rate = 0.0;

        if ("Diwali".equalsIgnoreCase(festival)) {
            rate = 0.08;
        } else if ("Holi".equalsIgnoreCase(festival)) {
            rate = 0.075;
        } else {
            rate = 0.07; 
        }

        return (principal * rate * duration);
    }

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("enter accountNumber : ");
    	accountNumber = sc.nextInt();
    	
    	System.out.println("enter name : ");
    	name = sc.next();
    	
    	System.out.println("enter principal : ");
    	principal = sc.nextDouble();
    	
    	System.out.println("enter duration : ");
    	duration = sc.nextInt();
    	
    	System.out.println("enter festival : ");
    	festival = sc.next();
    	
        FixedDeposit fd1 = new FixedDeposit(accountNumber, name, principal, duration, festival);
        System.out.println("Interest: " + fd1.calculateSimpleInterest());
    }
}
