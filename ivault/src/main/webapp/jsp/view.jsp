<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
    $('#example').DataTable( {
        "order": [[ 3, "desc" ]]
    } );
} );
</script>
</head>
<body>

	<table border="1" id="example">
		<thead>
			<tr>
				<th>Sr.</th>
				<th>DenoID</th>
				<th>Denomination</th>
				<th>denoFlag</th>
				<th>denoSeries</th>
				<th>Update</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${denoList}" var="user" varStatus="myIndex">
				<tr>
					<td>${myIndex.index +1}</td>
					<td>${user.imdSeq}</td>
					<td>${user.imdDenomination}</td>
					<td>${user.imdPrFlag}</td>
					<td>${user.imdSeriesId}</td>
					<td><a href="editUser?uid=${user.imdDenoId}"><i class='fas fa-edit'
							style='color: red'><span class="tooltiptext">Edit</span></i></a>
						&nbsp;&nbsp; <a href="deleteUser?uid=${user.imdDenoId}"
						onclick="return confirm('Are you sure to Delete?')"><i
							class='fas fa-trash-alt'><span class="tooltiptext">Delete</span></i></a></td>
				</tr>
			</c:forEach>

		</tbody>


	</table>
</body>
</html>