package com.details;

public class PatientDetails {

	private static String email;
	private String name;
	private String mobile;
	private String gender;
	private String password;
	private int age;

	public PatientDetails(String Email, String Name, String Mobile, String Gender, String Password,int Age) {

		this.email = Email;
		this.name = Name;
		this.mobile = Mobile;
		this.gender = Gender;
		this.password = Password;
		this.age = Age;

	}
	
	
	public static String getEmail() {
		return email;
	}
	
	

}
