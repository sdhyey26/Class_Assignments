package com.tss.NonViolation.test;

import com.tss.Interface.Iworker;
import com.tss.model.Labour;
import com.tss.model.Robot;

public class WorkTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Labour labour = new Labour();
        labour.startWork();
        labour.stopWork();
        labour.eat();
        labour.drink();

        Robot robo = new Robot();
        robo.startWork();
        robo.stopWork();
        
        
	}

}
