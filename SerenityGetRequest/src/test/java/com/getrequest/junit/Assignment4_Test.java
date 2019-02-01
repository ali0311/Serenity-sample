package com.getrequest.junit;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import com.getrequest.testbase.TestBase;


@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Assignment4_Test extends TestBase
{
	String username;
	String password;
	
	@Title("Validate that user is successfully able to login")
	@Test
	public void test01_LoginWithValidCred()
	{
		
		System.out.println("Test case no-1 : \n********Started************\n");
		
		username = "ToolsQA";
		password = "TestPassword";
		
		SerenityRest.given()
		 .auth()
	     .basic(username,password)
         .contentType("application/json")
         .when()
	     .get("/authentication/CheckForAuthentication")
		 .then()
		 .statusCode(200)
		 .log()
		 .all()
		 .body("FaultId", containsString("OPERATION_SUCCESS"));
		
		System.out.println("Test case 1-----End----------");
		
	}
	
	@Title("Validate the response in case of invalid credentials")
	@Test
	public void test02_LoginWithInvalidCred()
	{
		System.out.println("Test case no-2 : \n********Started************\n");
		
		username = "ToolsQA"+"123";
		password = "TestPassword" +"123";
		
		SerenityRest.given()
		 .auth()
	     .basic(username,password)
         .contentType("application/json")
         .when()
	     .get("/authentication/CheckForAuthentication")
		 .then()
		 .statusCode(401)
		 .log()
		 .all()
		 .body("FaultId", containsString("FAULT_USER_INVALID_USER_PASSWORD"));
		
		System.out.println("Test case 2-----End----------");
		
	}
	
	
}
