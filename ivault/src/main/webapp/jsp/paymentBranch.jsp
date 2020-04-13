<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="./js/jquery-1.12.0.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>vehical details</title>

<script type="text/javascript"> 
function directPaymentAlertMsg() {
	var r = confirm("Pickup request is already pending. Do you want to cancel that?");
	if(r == true)
	{
		confirm_value.value = "Yes";
	}
	else
	{
		confirm_value.value = "No";
	}
}
</script>

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

.loginmidn {
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

.table-fill {
	background: white;
	border-radius: 3px;
	border-collapse: collapse;
	height: 320px;
	margin: auto;
	/*max-width: 600px;*/
	padding: 5px;
	/*width: 50%;*/
	width: 100%;
	box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
	animation: float 5s infinite;
}

th {
	color: #D5DDE5;
	background: #ea912d;
	border-bottom: 4px solid #9ea7af;
	border-right: 1px solid #343a45;
	font-size: small;
	font-weight: 100;
	padding: 24px;
	text-align: left;
	text-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
	vertical-align: middle;
}

th:first-child {
	border-top-left-radius: 3px;
}

th:last-child {
	border-top-right-radius: 3px;
	border-right: none;
}

tr {
	border-top: 1px solid #C1C3D1;
	border-bottom-: 1px solid #C1C3D1;
	color: #666B85;
	font-size: 16px;
	font-weight: normal;
	text-shadow: 0 1px 1px rgba(256, 256, 256, 0.1);
}

tr:hover td {
	background: #4E5066;
	color: #FFFFFF;
	border-top: 1px solid #22262e;
}

tr:first-child {
	border-top: none;
}

tr:last-child {
	border-bottom: none;
}

tr:nth-child(odd) td {
	background: #ea912d73;
}

tr:nth-child(odd):hover td {
	background: #4E5066;
}

tr:last-child td:first-child {
	border-bottom-left-radius: 3px;
}

tr:last-child td:last-child {
	border-bottom-right-radius: 3px;
}

td {
	background: #FFFFFF;
	padding: 10px;
	text-align: left;
	vertical-align: middle;
	font-weight: 300;
	font-size: 18px;
	text-shadow: -1px -1px 1px rgba(0, 0, 0, 0.1);
	border-right: 2px solid #C1C3D1;
}

td:last-child {
	border-right: 0px;
}

th.text-left {
	text-align: left;
}

th.text-center {
	text-align: center;
}

th.text-right {
	text-align: right;
}

td.text-left {''
	text-align: left;
}

td.text-center {
	text-align: center;
}

td.text-right {
	text-align: right;
}
</style>
</head>
<body>
	<div class="loginheader">
		<div class="login_main">
			<div class="loginlogo">
				<img src="./resources/logo/icicibank.gif">
			</div>
			<div class="logoutlogo">
				<a href="logout" title="SignOut"> <img
					src="./resources/logo/Logout.jfif" height="30" width="30"
					align="left" /></a>
			</div>
		</div>
	</div>
	<div>
		<c:choose>
			<c:when test="${pickup[0].iprdStatus==0}">
				<h1>PickUp request is in pending</h1> </br></br></br>
				<a href="denomination" onclick="return directPaymentAlertMsg();" class="noteCount"> DIRECT PICKUP REQUEST </a>
				 <input type="hidden" name="Yes" id="Yes" value="Yes">
				 <input type="hidden" name="No" id="No" value="No">
			</c:when>

			<c:when test="${pickup[0].iprdStatus==1}">
			<form action="denomination" method="GET">
				<c:forEach items="${pickup}" var="pickuplist">
					<table class="table-fill">
						<thead>
							<tr>
								<th class="text-left">IPRD_SEQ</th>
								<th class="text-left">IPRD_ACK_BY</th>
								<th class="text-left">IPRD_ACK_ON</th>
								<th class="text-left">IPRD_BRANCH</th>
								<th class="text-left">IPRD_CREW_ID</th>
								<th class="text-left">IPRD_ICMC_ID</th>
								<th class="text-left">IPRD_PROCESS_BY</th>
								<th class="text-left">IPRD_PROCESS_ON</th>
								<th class="text-left">IPRD_REQ_BY</th>
								<th class="text-left">IPRD_REQ_ON</th>
								<th class="text-left">IPRD_IBM_SOL_ID</th>
								<th class="text-left">IPRD_STATUS</th>
								<th class="text-left">IPRD_CANCEL_BY</th>
								<th class="text-left">IPRD_DIRECT_REQ_FLAG</th>
							</tr>
						</thead>
						<tr>
							<td><c:out value="${pickuplist.iprdSeq}" /></td>
							<td><c:out value="${pickuplist.iprdAckBy}" /></td>
							<td><c:out value="${pickuplist.iprdAckOn}" /></td>
							<td><c:out value="${pickuplist.iprdBranchName}" /></td>
							<td><c:out value="${pickuplist.iprdCrewId}" /></td>
							<td><c:out value="${pickuplist.iprdIcmcId}" /></td>
							<td><c:out value="${pickuplist.iprdProcessBy}" /></td>
							<td><c:out value="${pickuplist.iprdProcessOn}" /></td>
							<td><c:out value="${pickuplist.iprdReqBy}" /></td>
							<td><c:out value="${pickuplist.iprdReqOn}" /></td>
							<td><c:out value="${pickuplist.iprdIbmSolId}" /></td>
							<td><c:out value="${pickuplist.iprdStatus}" /></td>
							<td><c:out value="${pickuplist.iprdCancelBy}" /></td>
							<td><c:out value="${pickuplist.iprdDirectReqFlag}" /></td>
						</tr>
					</table>
				</c:forEach>
				<p align="center">
					<button type="submit" name="Process" id="Process" value="ProcessPickUpReq">PROCESS</button>
				</p>
				</form>
			</c:when>
			
			<c:when test="${pickup[0].iprdStatus==2}">
				<h1>Pending for checker approval</h1>
			</c:when>
			
			<c:otherwise>
				<a href="brpickuprequest"> PICKUP REQUEST </a> </br> </br> </br>
				<a href="denomination"> DIRECT PICKUP REQUEST </a>
				<br />
				<br />
			</c:otherwise>
		</c:choose>
	</div>

</body>
</html>