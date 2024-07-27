package com.details;

public class AdminDetails {
	
	private static String email;
	private static String name;
	private static String gender;
	private static String mobile;
	
	
	public AdminDetails(String Email,String Name,String Gender,String Mobile) {
		this.email = Email;
		this.name = Name;
		this.gender = Gender;
		this.mobile = Mobile;
	}
	
	
	public static String AdminGetEmail() {
		return email;
	}

}
