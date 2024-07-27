<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Register</title>
<link rel="stylesheet" href="css/Doctorinsert.css" />
</head>
<body>
	<div class="logbox">
		<div class="login-box">
			<form action="Dinsert" method="post">
				<div class="signInLogoMain">
					<img class="signInLogo" src="Images/logo2.png">
				</div>
				<br /> <br />
				<h2> Doctor Create an Account</h2>
				<br />
				<div class="input-box">
					<input type="text" name="Email" required /> <label>Email</label>
				</div>
				<div class="input-box">
					<input type="text" name="Name" required /> <label>Name</label>
				</div>
				<div class="input-box">
					<input type="text" name="mobile" required /> <label>Mobile</label>
				</div>
				<div class="input-box">
					<input type="text" name="gender" required /> <label>Gender</label>
				</div>

				<div class="input-box">
					<input type="text" name="age" required /> <label>Age</label>
				</div>
				<div class="input-box">
					<input type="text" name="password" required /> <label>Password</label>
				</div>
				<br /> <br /> <br />
				<button name="submit" type="submit">Sign Up</button>
				<div class="register-link">
					<p>
						Already hava an Account <a href="DoctorLogin.jsp">Sign in </a>
					</p>
				</div>
			</form>
		</div>
	</div>


</body>
</html>