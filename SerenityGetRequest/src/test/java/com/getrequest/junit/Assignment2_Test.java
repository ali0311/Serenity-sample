package com.getrequest.junit;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.getrequest.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Assignment2_Test extends TestBase
{

	String value ;
	String countryCode;
	
	///Summary
	/**URI :http://services.groupkt.com/state/search/{countryCode}?text={text}
	   When countryCode = IND, text = pradesh */
	///</Summary>
	
	@Title("Validate that there are 5 records found")
	@Test
	public void test01_ValidateStateList()
		{
		
		System.out.println("Test case no-1 : \n********Started************\n");
		value = "pradesh";
		countryCode = "IND";
			 
			SerenityRest.given()
			.when()
			.get("/state/search/IND?text="+value)
			.then()
			.log()
			.all()
			.statusCode(200)
			.and()
			.body("RestResponse.result",hasSize(5));
			
		System.out.println("Test case 1-----End----------");
		
		}
	
	/** Note: As per question we need to validate with Visakhapatnam but same is unavailable for mentioned API */
	
	@Title("Validate that largest city is Hyderabad Amaravati")
	@Test
	public void test02_ValidateLargestCity()
		{
		
		System.out.println("Test case no-2 : \n********Started************\n");
		value = "pradesh";
		countryCode = "IND";
		String pathValue = "RestResponse.result.largest_city"; 
		String largest_city = "Hyderabad Amaravati" ;
			
			ArrayList<String> list = SerenityRest.given()
			.when()
			.get("/state/search/IND?text="+value)
			.then()
			.log()
			.all()
			.assertThat()
			.statusCode(200)
			.extract()
			.path(pathValue);
			
			assertThat(list.contains(largest_city));
		
		System.out.println("Test case 2-----End----------");
		
		}
}
