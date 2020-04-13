<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Cash Allocation</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>
div {
	background-color: #dddddd;
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}
</style>
</head>
<body>
	<%-- Cash Alloactaion ${activeMachineMasterList} --%>
	<c:forEach items="${activeMachineMasterList}" var="activeMachine">
				${activeMachine.machineName}
			<div>
			Denomination:: <input type="text" />
			No.Bundles:: <input type="text">
			<input type="submit" value="Process Cash"/>
			
		</div>
		

	</c:forEach>


</body>
</html>