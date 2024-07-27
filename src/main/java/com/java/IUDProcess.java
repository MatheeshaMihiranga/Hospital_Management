package com.java;

import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;

import com.details.AdminDetails;
import com.details.DoctorDetails;
import com.details.PatientDetails;
import com.mysql.cj.xdevapi.Result;

public class IUDProcess {

	public static boolean PatientAppoinmentRequest(String Email, String Name, String Date, String Time,
			String DoctorEmail, String problem) {

		boolean status = true;

		try {
			myConn.execute("INSERT INTO `appoinment` (`Date`,`Time`,`problem`,`Patient_email`,`Doctor_email`) VALUES ('"
					+ Date + "','" + Time + "','" + problem + "','" + Email + "','" + DoctorEmail + "') ");

		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}

		return status;

	}

	public static boolean PatientRegisterProcess(String Email, String Name, String mobile, String gender, String age,
			String password) {
		boolean status = true;

		try {
			myConn.execute("INSERT INTO `patient` (`email`,`name`,`mobile`,`gender`,`age`,`password`) VALUES ('" + Email
					+ "','" + Name + "','" + mobile + "','" + gender + "','" + age + "','" + password + "') ");

		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}

		return status;
	}

	public static boolean PatientLogin(String email, String password) {
		boolean status = true;
		try {

			ResultSet rs = myConn.execute(
					"SELECT * FROM `patient` WHERE `email` = '" + email + "' AND `password` = '" + password + "' ");

			if (rs.next()) {
				String Email = rs.getString(1);
				String Name = rs.getString(2);
				String mobile = rs.getString(3);
				String Gender = rs.getString(4);
				int Age = rs.getInt(5);
				String Password = rs.getString(6);

				PatientDetails pd = new PatientDetails(Email, Name, mobile, Gender, Password, Age);

				status = true;
			} else {
				status = false;
			}

		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;

	}

	public static boolean PateintUpdateProfileProcess(String Name, String mobile, String Gender, String Age) {

		boolean status = true;
		try {

			int NewAge = Integer.parseInt(Age);

			ResultSet rs = myConn.execute(
					"UPDATE `patient` SET `Name`= '" + Name + "' ,`mobile` = '" + mobile + "' ,`gender` = '" + Gender
							+ "',`age` = '" + NewAge + "' WHERE `email` = '" + PatientDetails.getEmail() + "'  ");

		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;
	}

	public static boolean PatientUpdatePasswordProcess(String newPassword) {
		boolean status = true;
		try {

			myConn.execute("UPDATE `patient` SET `password` = '" + newPassword + "' WHERE `email` = '"
					+ PatientDetails.getEmail() + "'  ");

		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;

	}

	public static boolean PatientDeleteProfileProcess(String email) {
		boolean status = true;
		try {

			ResultSet rs = myConn
					.execute("SELECT * FROM `appoinment` WHERE `Patient_email` = '" + PatientDetails.getEmail() + "'");

			if (rs.next()) {
				myConn.execute("DELETE FROM `appoinment` WHERE `Patient_email` = '" + PatientDetails.getEmail() + "' ");
				myConn.execute("DELETE FROM `patient` WHERE `email` = '" + PatientDetails.getEmail() + "' ");
			} else {
				myConn.execute("DELETE FROM `patient` WHERE `email` = '" + PatientDetails.getEmail() + "' ");
			}

		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;
	}

	public static boolean PatientUpdateAppoinent(String APPO_ID, String Date, String Time, String Problem) {

		boolean status = true;
		try {
			myConn.execute(" UPDATE `appoinment` SET `Date` = '" + Date + "' , `time` = '" + Time + "' , `Problem` = '"
					+ Problem + "' WHERE `Appoinemnt_id` = '" + APPO_ID + "' ");

		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;

	}

	public static boolean PatientDeleteAppoinmentRaw(String APPO_ID) {

		boolean status = true;
		try {
			myConn.execute(" DELETE FROM  `appoinment`  WHERE `Appoinemnt_id` = '" + APPO_ID + "' ");

		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;

	}

//	//////////////////////////////////////////////// ADMIN
	public static boolean AdminLoginProcess(String email, String password) {
		boolean status = true;

		try {

			ResultSet rs = myConn.execute(
					"SELECT * FROM `admin` WHERE `Aemail` = '" + email + "' AND `password` = '" + password + "'");

			if (rs.next()) {
				String Email = rs.getString(1);
				String Name = rs.getString(2);
				String Mobile = rs.getString(5);
				String Gender = rs.getString(3);

				AdminDetails ad = new AdminDetails(Email, Name, Gender, Mobile);

			} else {
				status = false;
			}

		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;

	}

	public static boolean AddNewAdminProcess(String email, String Name, String gender, String password, String mobile) {
		boolean status = true;
		try {
			myConn.execute("INSERT INTO `admin` (`Aemail`,`Name`,`gender`,`password`,`mobile`) VALUES ('" + email
					+ "','" + Name + "','" + gender + "','" + password + "','" + mobile + "')");

		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;
	}

	public static boolean AdminUpdateAppoinmentStatusProcess(String Appo_ID) {
		boolean status = true;

		try {

			ResultSet status_rs = myConn
					.execute("SELECT * FROM `appoinment` WHERE `Appoinemnt_id` = '" + Appo_ID + "' ");

			if (status_rs.next()) {

				String AppStatus = status_rs.getString(7);

				if (AppStatus.equals("active")) {
					myConn.execute("UPDATE `appoinment`  SET `status` =  'Deactive'  WHERE `Appoinemnt_id` = '"
							+ Appo_ID + "' ");

				} else if (AppStatus.equals("Deactive")) {
					myConn.execute("UPDATE `appoinment`  SET `status` =  'active'  WHERE `Appoinemnt_id` = '" + Appo_ID
							+ "' ");
				}

			}

		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;
	}

	public static boolean AdminDeleteappoinemnt(String Appo_id) {

		Boolean status = true;

		try {

			myConn.execute("DELETE FROM `appoinment` WHERE `Appoinemnt_id` = '" + Appo_id + "' ");

		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;
	}

	// //////////////////////////////////////DOCTOR
	public static boolean DoctorLoginProcess(String Email, String Password) {
		Boolean status = true;

		try {

			ResultSet rs = myConn.execute(
					"SELECT * FROM `doctor` WHERE `email` = '" + Email + "' AND password = '" + Password + "' ");

			if (rs.next()) {
				status = true;
				String email = rs.getString(1);
				String Name = rs.getString(2);
				String mobile = rs.getString(3);
				String Gender = rs.getString(4);
				String age = rs.getString(5);

				DoctorDetails d = new DoctorDetails(email, Name, mobile, age, Gender);

			}

		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;

	}

	public static boolean DoctorRegisterProcess(String Email, String Name, String mobile, String age, String password) {

		Boolean status = true;

		try {

			myConn.execute("INSERT INTO `doctor` (`email`,`Name`,`mobile`,`age`,`password`) VALUES('" + Email + "','"
					+ Name + "','" + mobile + "','" + age + "','" + password + "') ");

		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;

	}

	public static boolean DoctorUpdateProfile(String email, String Name, String mobile, String gender, String age) {

		System.out.println(email + " " + Name + " " + mobile + " " + gender + " " + age);

		Boolean status = true;

		try {

			int NewAge = Integer.parseInt(age);

			myConn.execute("UPDATE `doctor` SET  `Name` = '" + Name + "' , `mobile` = '" + mobile + "', `gender` = '"
					+ gender + "', `age` = '" + NewAge + "' WHERE `email` = '" + DoctorDetails.getDocEmail() + "' ");

		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;

	}

	public static boolean DoctorChangePassword(String newPassword) {
		boolean status = true;
		try {

			myConn.execute("UPDATE `doctor` SET `password` = '" + newPassword + "' WHERE `email` = '"
					+ DoctorDetails.getDocEmail() + "'  ");

		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;
	}

	public static boolean DoctorDeleteProfile(String Email) {
		boolean status = true;
		try {

			ResultSet rs = myConn
					.execute("SELECT * FROM `appoinment` WHERE `Doctor_email` = '" + DoctorDetails.getDocEmail() + "'");

			
			if(rs.next()) {
				System.out.println("Yess");
				myConn.execute("DELETE FROM  `appoinment`  WHERE `Doctor_email` = '" + DoctorDetails.getDocEmail() + "'  ");
				myConn.execute("DELETE FROM  `doctor`  WHERE `email` = '" + DoctorDetails.getDocEmail() + "'  ");
			}else {
				System.out.println("NOO");
				myConn.execute("DELETE FROM  `doctor`  WHERE `email` = '" + DoctorDetails.getDocEmail() + "'  ");
			}
			
			
			

		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;

	}

}
