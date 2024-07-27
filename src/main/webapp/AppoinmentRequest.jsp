<%@page import="com.details.PatientDetails"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.java.myConn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointment Request Page</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<style>
body {
        background-image: url('Images/hospitalbackground.png');
        background-size: cover; 
        background-repeat: no-repeat; 
        color: white; 
        
    }


table, th, td {
	border: 1px solid white;
	padding: 20px 20px;
	
}
input[type="text"],
input[type="date"],
input[type="time"],
select {
    background: transparent;
    border: 2px soild #fff;
    color: white;
}

</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-12 d-flex justify-content-center">
				<div class="row">

					<div class="col-12 text-center mt-5 mb-5">
						<h1>Appointment Request</h1>
					</div>
					<form action="AppoREQ" method="post">
						<div class="col-8 mt-5">
							<div class="row">
								<!-- ----------------------- -->
								<div class="col-6 text-end">Patient Email</div>
								<div class="col-6">
									<input type="text" name="PatientEmail" class="form-control" /><br>
								</div>

								<!-- ----------------------- -->
								<div class="col-6 text-end">Patient Name</div>
								<div class="col-6">
									<input type="text" name="PatientName" class="form-control" /><br>
								</div>

								<!-- ----------------------- -->
								<div class="col-6 text-end">Date</div>
								<div class="col-6">
									<input type="date" name="Date" class="form-control" /><br>
								</div>

								<!-- ----------------------- -->
								<div class="col-6 text-end">Time</div>
								<div class="col-6">
									<input type="time" name="Time" class="form-control" /><br>
								</div>

								<!-- ----------------------- -->
								<div class="col-6 text-end">Doctor</div>
								<div class="col-6">
									<select name="Docotr_ID" id="" class="d-grid text-select">
										<%
										try {
											ResultSet rs = myConn.execute("SELECT * FROM `doctor`");

											while (rs.next()) {
										%>
										<option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>
										<%
										}

										} catch (Exception e) {
										e.printStackTrace();
										}
										%>
									</select><br>
								</div>

								<!-- ----------------------- -->
								<div class="col-6 text-end">Problem</div>
								<div class="col-6">
									<input type="text" name="Problem" class="form-control" /><br>
								</div>
								<div class="col-12 d-flex justify-content-center">

									<button type="submit" class=" btn btn-outline-danger">Submit</button>


								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!--  Appoinment Table -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-12">
				<div class="row">
					<div class="col-12">
						<h1 class="text-center">Appointment</h1>
					</div>
					<hr />

					<div class="col-12 d-flex justify-content-center">
						<table class="text-center">
							<tr class="p-5 fs-5">
								<th>Appoinemnt Id</th>
								<th>Date</th>
								<th>Time</th>
								<th>Doctor Email</th>
								<th>Doctor Name</th>
								<th>Problem</th>
								<th>Status</th>
								<th>Update</th>
								<th>Delete</th>
							</tr>

							<%
							try {

								ResultSet rs = myConn.execute(
								"SELECT * FROM `appoinment` INNER JOIN `patient` ON `patient`.`email` = `appoinment`.`Patient_email` INNER JOIN `doctor` ON `doctor`.`email` = `appoinment`.`Doctor_email` WHERE `Patient_email` = '"
										+ PatientDetails.getEmail() + "'  ");

								while (rs.next()) {
							%>
							<tr class="p-3">
								<form action="PUAR" method="post">
								<td><%=rs.getString(1)%></td>
								<td><input type="Date" name="Date"
									value="<%=rs.getString(2)%>"></td>
								<td><input type="Time" name="Time"
									value="<%=rs.getString(3)%>"></td>
								<td><%=rs.getString("doctor.email")%></td>
								<td><%=rs.getString("doctor.name")%></td>
								<td><input type="text" name="problem"
									value="<%=rs.getString(4)%>"></td>
								<td><%=rs.getString(7)%></td>



								<td>
									<button value="<%=rs.getString(1)%>" name="UpdateBtn"
										type="submit" class="btn btn-primary">Update</button>
								</td>
								</form>
								<td><form action="PDAR" method="post">
										<button value="<%=rs.getString(1)%>" name="Deletebtn"
											type="submit" class="btn btn-danger">Delete</button>
									</form></td>

							</tr>
							<%
							}

							} catch (Exception e) {
							e.printStackTrace();
							}
							%>


						</table>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>