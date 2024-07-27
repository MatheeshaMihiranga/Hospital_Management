<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Add New</title>
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
			<div class="col-12 d-flex justify-content-center">
				<div class="row">

					<div class="col-12 text-center mt-5 mb-5">
						<h1>Add New Admin</h1>
					</div>
					<form action="ANAP" method="post">
						<div class="col-8 mt-5">
							<div class="row">
								<!-- ----------------------- -->
								<div class="col-6 text-end">Admin Email</div>
								<div class="col-6">
									<input type="text" name="Email" class="form-control" /><br>
								</div>
									
								<!-- ----------------------- -->
								<div class="col-6 text-end">Admin Name</div>
								<div class="col-6">
									<input type="text" name="Name" class="form-control" /><br>
								</div>

								<!-- ----------------------- -->
								<div class="col-6 text-end">Gender</div>
								<div class="col-6">
									<select name="Gender"  class="d-grid text-select">
										<option value="male">Male</option>
										<option value="male">Female</option>
									</select>
									<br>
								</div>
								<!-- ----------------------- -->
								<div class="col-6 text-end">password</div>
								<div class="col-6">
									<input type="password" name="Password" class="form-control" /><br>
								</div>
								<!-- ----------------------- -->
								<div class="col-6 text-end">mobile</div>
								<div class="col-6">
									<input type="text" name="Mobile" class="form-control" /><br>
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




</body>
</html>