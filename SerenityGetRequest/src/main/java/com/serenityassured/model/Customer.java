package com.serenityassured.model;

public class Customer 
{
	private String FirstName ;
	private String LastName  ;
	private String UserName  ;
	private String Password  ;
	private String Email     ;
	public String getfirstName() {
		return FirstName;
	}
	public void setfirstName(String firstName) {
		this.FirstName = firstName;
	}
	public String getlastName() {
		return LastName;
	}
	public void setlastName(String lastName) {
		this.LastName = lastName;
	}
	public String getuserName() {
		return UserName;
	}
	public void setuserName(String userName) {
		this.UserName = userName;
	}
	public String getpassword() {
		return Password;
	}
	public void setpassword(String password) {
		this.Password = password;
	}
	public String getemail() {
		return Email;
	}
	public void setemail(String email) {
		this.Email = email;
	}
	
	
}

