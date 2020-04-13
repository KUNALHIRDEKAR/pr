<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>

<title>Insert title here</title>
<script type="text/javascript">
	function confirmation() {
		var result = confirm("Are you sure to delete?");
		if (result) {
			// Delete logic goes here
		}
	}
</script>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: black;
	color: white;
}

a:hover {
	font-size: 150%;
}

a:hover .tooltiptext {
	visibility: visible;
}

a .tooltiptext {
	visibility: hidden;
	width: 120px;
	background-color: black;
	color: #fff;
	text-align: center;
	border-radius: 6px;
	padding: 5px 0;
	/* Position the tooltip */
	position: absolute;
	z-index: 1;
}
</style>

</head>


<body>
	<h1 align="center">Welcome to Ivault</h1>


	<table class="w3-table">
		<thead>
			<th>Sr.</th>
			<th>RequestedAmount</th>
			<th>RequestBy</th>
			<th>ReqIcmcId</th>
			<th>Date</th>
			<th>Approved</th>
		</thead>
		<tbody>

			<c:forEach items="${pr_Request_HeaderList}" varStatus="myIndex"
				var="prRequest">
				<tr>
					<td>${myIndex.index +1}</td>
					<td>${prRequest.requestedAmount}</td>
					<td>${prRequest.requestBy}</td>
					<td>${prRequest.reqIcmcId}</td>
					<td>${prRequest.requestOn}</td>
					<td><a
						href="getRequestedDenominations?requestHeaderSeq=${prRequest.requestHeaderSeq}">Process</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>