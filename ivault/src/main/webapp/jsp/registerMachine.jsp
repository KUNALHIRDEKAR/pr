<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="ISO-8859-1">

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#accordion").accordion();
	});
</script>
<script>
	$(function() {
		$("#tabs").tabs();
	});
</script>
<title>Welcome</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<td>Sr.</td>
				<td>Machine Company</td>
				<td>Machine IcmcId</td>
				<td>Machine Name</td>
				<td>Current Status</td>
				<td>Enable/Disable</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${machineMasterList}" var="machineMaster"
				varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${machineMaster.machineCompany}</td>
					<td>${machineMaster.machineIcmcId}</td>
					<td>${machineMaster.machineName}</td>
					<td>${machineMaster.activeStatus}</td>
					<td><button>
							<a href="enable?machineID=${machineMaster.machineID}">Enable</a>
						</button>
						<button>
							<a href="disable?machineID=${machineMaster.machineID}">Disable</a>
						</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

<h1></h1>
	<div align="center">
		<button>
			<a href="processCash">Process Cash</a>
		</button>
	</div>
</body>
</html>