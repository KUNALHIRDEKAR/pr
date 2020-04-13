<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>vehical details</title>

<style type="text/css">
body {
	margin: 0;
	padding: 0;
	font-family: arial;
	background: #efefe0;
}

.loginheader {
	/* Permalink - use to edit and share this gradient: http://colorzilla.com/gradient-editor/#ea912d+0,ac2534+100 */
	background: #ea912d; /* Old browsers */
	background: -moz-linear-gradient(top, #ea912d 0%, #ac2534 100%);
	/* FF3.6-15 */
	background: -webkit-linear-gradient(top, #ea912d 0%, #ac2534 100%);
	/* Chrome10-25,Safari5.1-6 */
	background: linear-gradient(to bottom, #ea912d 0%, #ac2534 100%);
	/* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ea912d',
		endColorstr='#ac2534', GradientType=0); /* IE6-9 */
	width: 100%;
	float: left;
}

.login_main {
	width: 100%;
	float: left;
}

.loginlogo {
	float: left;
}

.loginmid {
	font-size: 15px;
	color: #fff;
	width: 40%;
	text-align: right;
	padding: 25px 0 0 0;
	float: left;
}

.loginmidn{
    font-size: 15px;
	color: #fff;
	width: 40%;
	text-align: left;
	padding: 25px 0 0 0;
	float: left;
}

.logoutlogo {
	float: right;
	color: #fff;
	font-size: small;
	margin-top: 20px;
	margin-right: 20px;
}

</style>
</head>
<body>
	<div class="loginheader">
		<div class="login_main">
			<div class="loginlogo">
				<img src="./resources/logo/icicibank.gif"> </div>
			<div class="logoutlogo">
				<a href="logout" title="SignOut">
				<img src="./resources/logo/Logout.jfif" height="30" width="30" align="left" /></a>
			</div>
	</div>
	</div>
	<div>
		<H2>Vehicle assigned successfully...</H2> <br> </br> </br>
	</div>
	</body>
</html>