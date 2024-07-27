<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>patient Login</title>
<link rel="stylesheet" href="css/Adminlogin.css" />
</head>
<body>
	<div class="logbox">
		<div class="login-box">
			<form action="Alogin" method="post">
				<div class="signInLogoMain">
					<img class="signInLogo" src="Images/logo2.png" />
				</div>
				<br /> <br />
				<h2>Admin Sign in to Online Hospital Management</h2>


				<div class="input-box">
		
						<input name="email" type="text"  required /> <label>Email</label>
				</div>
				<div class="input-box">

						<input name="password" type="password" required /> <label>Password</label>
				</div>
				<br /> <br />
				<button name="submit" type="submit">Login</button>

				<<!-- div class="register-link">
					<p>
						Don't have an account <a href="signup.php">Register</a>
					</p>
				</div> -->
			</form>
		</div>
	</div>

</body>
</html>