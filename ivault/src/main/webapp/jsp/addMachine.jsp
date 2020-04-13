<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<form:form action="saveMachine" method="post"
		modelAttribute="machineMaster">
	<table>
  <tr>
    <th>Machine Company</th>
    <th><form:input path="machineCompany"/></th>
  </tr>
  <tr>
    <td>Machine IcmcId</td>
    <td><form:input path="machineIcmcId"/></td>
  </tr>
  <tr>
    <td>Machine Name</td>
    <td><form:input path="machineName"/></td>
  </tr>
</table>
	
<input type="submit">
	</form:form>
</div>
</body>
</html>