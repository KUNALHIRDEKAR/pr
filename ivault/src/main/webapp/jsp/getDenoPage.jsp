<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!--
	@author Kunal Hirdekar
	PR Request  Process / Reject
  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 <a href="/getViewDetails">GetAllDenomination</a>
	
	<form:form action="processDenomination" method="post"
		modelAttribute="denominationDTO">
	<table style="width:100%">
    <tr>
			<th>Note Denomination</th>
			<th>Note/Coin</th>
			<th>Series</th>
		</tr>
		<tr>
			<td><form:input path="imdDenomination"/></td>
			<td><form:radiobutton path="imdDenoType" value="1" />Note <form:radiobutton
					path="imdCoinsLowHigh" value="0" />Coin</td>
			<td><form:radiobutton path="imdSeriesId" value="1" />New <form:radiobutton
					path="imdSeriesId" value="0" />Old</td>
		</tr>

		
	</table>
    <input type="submit" value="SUBMIT" />
    </form:form>
   
</body>
</html>