<%@page import="com.details.DoctorDetails"%>
<%@page import="com.details.PatientDetails"%>
<%@page import="com.java.myConn"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Appoinment</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<style>
body {
        background-image: url('Images/DoctorDasBackground.png');
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
input[type="password"],
select {
    background: transparent;
    border: 2px soild #fff;
    color: white;
}

</style>

</head>
<body>

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
								<th>Patient Email</th>
								<th>Patient Name</th>
								<th>Problem</th>
								<th>Status</th>
								
							</tr>

							<%
							try {

								ResultSet rs = myConn.execute(
								"SELECT * FROM `appoinment` INNER JOIN `patient` ON `patient`.`email` = `appoinment`.`Patient_email` INNER JOIN `doctor` ON `doctor`.`email` = `appoinment`.`Doctor_email` WHERE `Doctor_email` = '" + DoctorDetails.getDocEmail() + "'  ");

								while (rs.next()) {
							%>
							<tr class="p-3">
									<td><%=rs.getString(1)%></td>
									<td><%=rs.getString(2)%></td>
									<td><%=rs.getString(3)%></td>
									<td><%=rs.getString("patient.email")%></td>
									<td><%=rs.getString("patient.Name")%></td>
									<td><%=rs.getString(4)%></td>
									<td><%=rs.getString(7)%></td>
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