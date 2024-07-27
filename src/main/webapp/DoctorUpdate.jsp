<%@page import="com.details.DoctorDetails"%>
<%@page import="com.java.myConn"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Update Page</title>
<link rel="stylesheet" href="css/accountinformation.css" />
<link rel="stylesheet" href="css/index.css" />
<link rel="stylesheet" href="css/votepage.css" />


</head>
<body>

	<img src="css/Images/DoctorDasBackground.png" class="backgroundimg" />
	<div class="hero">



		<div class="page_content">
			<div class="acc_image">
				<p>hello</p>
			</div>


			<%
			ResultSet rs = myConn.execute("SELECT * FROM `doctor` WHERE `email` = '" + DoctorDetails.getDocEmail() + "' ");

			if (rs.next()) {
			%>

			<div class="acc_info">
				<form action="DUPP" method="POST">
					<div class="info_box_details">

						<h1 style="color: aliceblue">Details</h1>
						<div style="display: flex; flex-direction: row; margin-top: 20px">
							<div class="input_box">
								<div style="flex: 0.2; display: flex">
									<label>Email</label>
								</div>
								<div style="flex: 0.8; display: flex">
									<input type="text" style="width: 50%" readonly="readonly"
										name="email" value="<%=rs.getString(1)%>" readonly required />
								</div>
							</div>
							<div class="input_box">
								<div style="flex: 0.2; display: flex">
									<label>Name</label>
								</div>
								<div style="flex: 0.8; display: flex">
									<input type="text" style="width: 50%" name="Name"
										value="<%=rs.getString(2)%>" required />
								</div>
							</div>
						</div>

						<div style="display: flex; flex-direction: row; margin-top: 20px">
							<div class="input_box">
								<div style="flex: 0.2; display: flex">
									<label>Mobile</label>
								</div>
								<div style="flex: 0.8; display: flex">
									<input type="text" style="width: 50%" name="mobile"
										value="<%=rs.getString(3)%>" required />
								</div>
							</div>
							<div class="input_box">
								<div style="flex: 0.2; display: flex">
									<label>Gender</label>
								</div>
								<div style="flex: 0.8; display: flex">
									<input type="text" style="width: 50%" name="gender"
										value="<%=rs.getString(4)%>" required />
								</div>
							</div>
						</div>

						<div style="display: flex; flex-direction: row; margin-top: 20px">
							<div class="input_box">
								<div style="flex: 0.2; display: flex">
									<label>Age</label>
								</div>
								<div style="flex: 0.8; display: flex">
									<input type="text" style="width: 90%" name="age"
										value="<%=rs.getString(5)%>" required />
								</div>
							</div>
							<div class="input_box"></div>
						</div>
						<div style="display: flex; margin-top: 30px; justify-content: end">
							<button type="submit" class="save_button" name="saveChanges">Save
								Changes</button>
						</div>
					</div>
				</form>
				<form action="DPU" method="POST">
					<div class="info_box_pass">
						<h1 style="color: aliceblue">Change password</h1>
						<div
							style="display: flex; flex-direction: column; margin-top: 20px">
							<div class="input_box input_box_password">
								<div style="flex: 0.2; display: flex">
									<label>Current Password</label>
								</div>
								<div style="flex: 0.8; display: flex">
									<input type="password" name="currentPassword"
										style="width: 50%" required />
								</div>
							</div>
							<div class="input_box input_box_password">
								<div style="flex: 0.2; display: flex">
									<label>New Password</label>
								</div>
								<div style="flex: 0.8; display: flex">
									<input type="password" name="newPassword" style="width: 50%"
										required />
								</div>
							</div>
							<div class="input_box input_box_password">
								<div style="flex: 0.2; display: flex">
									<label>Confirm New Password</label>
								</div>
								<div style="flex: 0.8; display: flex">
									<input type="password" name="confirmPassword"
										style="width: 50%" required />
								</div>
							</div>
						</div>
						<div style="display: flex; margin-top: 30px; justify-content: end">
							<button type="submit" class="save_button" name="changePassword">Submit</button>

						</div>
					</div>
				</form>
				<br>

				<form action="DDP" method="post">
					<button type="submit" class="save_button" name="changePassword">Delete
						Account</button>
				</form>


			</div>


			<%
			}
			%>



		</div>
	</div>
	<script src="votepage.js"></script>



</body>
</html>