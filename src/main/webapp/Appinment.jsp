<%@page import="java.sql.ResultSet"%>
<%@page import="com.java.myConn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Appointment</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<style>
body {
        background-image: url('Images/AdminDasBackground.png');
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
								"SELECT * FROM `appoinment` INNER JOIN `patient` ON `patient`.`email` = `appoinment`.`Patient_email` INNER JOIN `doctor` ON `doctor`.`email` = `appoinment`.`Doctor_email`  ");

								while (rs.next()) {
							%>
							<tr class="p-3">
								<td><%=rs.getString(1)%></td>
								<td><%=rs.getString(2)%></td>
								<td><%=rs.getString(3)%></td>
								<td><%=rs.getString("patient.email")%></td>
								<td><%=rs.getString("patient.name")%></td>
								<td><%=rs.getString("doctor.email")%></td>
								<td><%=rs.getString("doctor.name")%></td>
								<td><%=rs.getString(4)%></td>
								<td><%=rs.getString(7)%></td>



								<td><form action="AAUP" method="post">
										<button value="<%=rs.getString(1)%>" name="UpdateBtn"
											type="submit" class="btn btn-primary">Update</button>
									</form></td>
								<td><form action="AADP" method="post">
										<button value="<%=rs.getString(1)%>" name="Deletebtn" type="submit"
											class="btn btn-danger">Delete</button>
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
