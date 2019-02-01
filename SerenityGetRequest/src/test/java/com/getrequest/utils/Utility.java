package com.getrequest.utils;

import java.util.Random;

import com.getrequest.testbase.TestBase;

public class Utility extends TestBase
{
	// Generate random integers in range 0 to 999 
	public static int generateRandomNumber()
	{
		Random rand = new Random(); 
		int value ;
        return value = rand.nextInt(1000); 
       
	}
}
