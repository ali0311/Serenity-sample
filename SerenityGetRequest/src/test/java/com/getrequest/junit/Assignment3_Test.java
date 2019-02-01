package com.getrequest.junit;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.getrequest.testbase.TestBase;
import com.getrequest.utils.Utility;
import com.serenityassured.model.Customer;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Assignment3_Test extends TestBase
{
	Customer cust = new Customer();
	static int randValue = Utility.generateRandomNumber();
	static String firstName = "FName" + randValue ;
	static String lastName = "LName" + randValue;
	static String userName = "UN0312" + randValue;
	static String password = "UN0312" + randValue;
	static String email = "xyz123" + randValue + "@mindtree.com";
	
	
	//URI :http://restapi.demoqa.com/customer/register
	
	@Title("This will validate new user creation")
	@Test
	public void test01_CreateNewUser()
	{
		System.out.println("This is test case 1-----Started----------");
		cust.setfirstName(firstName);
		cust.setlastName(lastName);
		cust.setuserName(userName);
		cust.setpassword(password);
		cust.setemail(email);
		
		SerenityRest.given()
			.contentType(ContentType.JSON)
			.log()
			.all()
			.when()
			.body(cust)
			.post()
			.then()
			.log()
			.all()
			.statusCode(201)
			.and()
			.body("SuccessCode", containsString("OPERATION_SUCCESS"));
		
		System.out.println("Test case 1-----End----------");
	}
	
	@Title("This will validate existing user exists")
	@Test
	public void test02_ValidateExistingUser()
	{
		System.out.println("This is test case 2-----Started----------");
		cust.setfirstName(firstName);
		cust.setlastName(lastName);
		cust.setuserName(userName);
		cust.setpassword(password);
		cust.setemail(email);
		
		SerenityRest.given()
		.contentType(ContentType.JSON)
		.log()
		.all()
		.when()
		.body(cust)
		.post()
		.then()
		.log()
		.all()
		.statusCode(200)
		.and()
		.body("fault", containsString("FAULT_USER_ALREADY_EXISTS"));
		
		System.out.println("Test case 2-----End----------");
		
	}
}
