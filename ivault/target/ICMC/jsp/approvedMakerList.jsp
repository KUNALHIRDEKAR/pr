<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="./js/jquery-1.12.0.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pending for Approval</title>

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
			<form action="approvedReq" method="GET">
				<c:forEach items="${CheckerList}" var="checkerList">
					<table class="table-fill">
						<thead>
							<tr>
								<th class="text-left">ITIHS_SEQ</th>
								<th class="text-left">ITIHS_DEL_FLAG</th>
								<th class="text-left">ITIHS_APPROVED_BY</th>
								<th class="text-left">ITIHS_APPROVED_ON</th>
								<th class="text-left">ITIHS_BRANCH_SOL_ID</th>
								<th class="text-left">ITIHS_CREATED_BY</th>
								<th class="text-left">ITIHS_CREATED_ON</th>
								<th class="text-left">ITIHS_ICMC_ID</th>
								<th class="text-left">ITIHS_INSPECTION_EMP_ID</th>
								<th class="text-left">ITIHS_MODIFIED_BY</th>
								<th class="text-left">ITIHS_MODIFIED_ON</th>
								<th class="text-left">ITIHS_PICKUP_NO</th>
								<th class="text-left">ITIHS_RECEIPT_DATETIME</th>
								<th class="text-left">ITIHS_SECK_LOCK_NUMBER</th>
								<th class="text-left">ITIHS_STATUS</th>
								<th class="text-left">ITIHS_VALUE</th>
								<th class="text-left">ITIHS_VH_BR_OUTIME</th>
								<th class="text-left">ITIHS_VH_HANDOVER_DATETIME</th>
								<th class="text-left">ITIHS_VH_ICMC_INTIME</th>
								<th class="text-left">ITIHS_HANDOVERBY</th>
								<th class="text-left">ITIH_REJECTS_REASON</th>
							</tr>
						</thead>
						<tr>
							<td><c:out value="${checkerList.itihsSeq}" /></td>
							<td><c:out value="${checkerList.itihsDelFlag}" /></td>
							<td><c:out value="${checkerList.itihsApprovedBy}" /></td>
							<td><c:out value="${checkerList.itihsApprovedOn}" /></td>
							<td><c:out value="${checkerList.itihsBranchSolId}" /></td>
							<td><c:out value="${checkerList.itihsCreatedBy}" /></td>
							<td><c:out value="${checkerList.itihsCreatedOn}" /></td>
							<td><c:out value="${checkerList.itihsIcmcId}" /></td>
							<td><c:out value="${checkerList.itihsInspectionEmpId}" /></td>
							<td><c:out value="${checkerList.itihsModifiedBy}" /></td>
							<td><c:out value="${checkerList.itihsModifiedOn}" /></td>
							<td><c:out value="${checkerList.itihsPickUpNo}" /></td>
							<td><c:out value="${checkerList.itihsRecepitDateTime}" /></td>
							<td><c:out value="${checkerList.itihsSeckLockNo}" /></td>
							<td><c:out value="${checkerList.itihsStatus}" /></td>
							<td><c:out value="${checkerList.itihsValue}" /></td>
							<td><c:out value="${checkerList.itihsVhBrOutTime}" /></td>
							<td><c:out value="${checkerList.itihsVhHandoverDateTime}" /></td>
							<td><c:out value="${checkerList.itihsVhIcmcInTime}" /></td>
							<td><c:out value="${checkerList.itihsHandOverBy}" /></td>
							<td><c:out value="${checkerList.itihsRejectReason}" /></td>
						</tr>
					</table>
				</c:forEach>
				<p align="center">
					<button type="submit" name="Approve">Approve</button>
					<button type="submit" name="Reject">Reject</button>
				</p>
				</form>
	</div>

</body>
</html>