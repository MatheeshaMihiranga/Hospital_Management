<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Home</title>
    <link rel="stylesheet" href="css/index.css"/>
    
    <script>
        function redirectToLoginPage() {
            // Redirect to the login.jsp page
            window.location.href = 'PatientLogin.jsp';
        }
    </script>

</head>

<body>
<video autoplay loop muted plays-inline class="back-video">
    <source src="Images/1234.mp4" type="video/mp4"/>
</video>
<div class="hero">

	<jsp:include page="navigation.jsp" />
    <div class="content">
        <div class="contentView">
            <h5>
                To revolutionize healthcare administration with DocLinkPro,
                <br/>
                by seamlessly connecting patients, healthcare providers, and resources for a healthier,<br/>
                more accessible future.<br/><br/>
                Click the button below
            </h5>
            <br/>
           <button onclick="redirectToLoginPage()" class="votebutton" type="button">Patient Login</button>

        </div>
    </div>
</div>
</body>

</html>