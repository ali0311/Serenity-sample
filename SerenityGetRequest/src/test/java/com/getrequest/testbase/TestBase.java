package com.getrequest.testbase;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class TestBase 
{

	@BeforeClass
	public static void initilize()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/customer/register";
	}
	
}
