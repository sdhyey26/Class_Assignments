package com.tss.test;

import com.tss.model.voter;

public class VoterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			voter voter = new voter("user1",210,19);
			
			voter voter2 = new voter("dhyey",310,10);
		}
		catch(Exception exception)
		{
			System.out.println(exception);
		}
	}

}
