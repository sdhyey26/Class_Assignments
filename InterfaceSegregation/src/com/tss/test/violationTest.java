package com.tss.test;

import com.tss.Interface.Iworker;
import com.tss.model.Labour;
import com.tss.model.Robot;

public class violationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Iworker labour = new Labour();
        labour.startWork();
        labour.drink();
        labour.eat();
        labour.stopWork();

        Iworker robot = new Robot();
        robot.startWork(); 
        robot.stopWork();
	}

}
