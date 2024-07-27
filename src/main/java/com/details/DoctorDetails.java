package com.details;

public class DoctorDetails {
	
	private static String email;
	private static String Name;
	private static String mobile;
	private static String age;
	private static String gender;
	
	
	public DoctorDetails(String email,String Name,String mobile,String age,String gender) {
	
		this.email = email;
		this.Name = Name;
		this.mobile = mobile;
		this.age = age;
		this.gender = gender;
		
		
		
	}
	
	public static String getDocEmail() {
		return email;
	}
	

}
