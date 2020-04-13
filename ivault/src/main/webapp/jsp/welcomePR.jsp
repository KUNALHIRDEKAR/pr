<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%-- <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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


/* chat to pr */

/* 
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

/* Button used to open the chat form - fixed at the bottom of the page */
.open-button {
  background-color: #555;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  position: fixed;
  bottom: 23px;
  right: 28px;
  width: 280px;
}

/* The popup chat - hidden by default */
.chat-popup {
  display: none;
  position: fixed;
  bottom: 0;
  right: 15px;
  border: 3px solid #f1f1f1;
  z-index: 9;
}

/* Add styles to the form container */
.form-container {
  max-width: 300px;
  padding: 10px;
  background-color: white;
}

/* Full-width textarea */
.form-container textarea {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
  resize: none;
  min-height: 200px;
}

/* When the textarea gets focus, do something */
.form-container textarea:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit/send button */
.form-container .btn {
  background-color: #4CAF50;
  color: white;
  padding: 6px 10px;
  border: none;
  cursor: pointer;
  width: 100%;
  margin-bottom:10px;
  opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
  background-color: red;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
  opacity: 1;
}
 */
</style>
</head>
<body>
	<h1 align="center">Welcome to Process Room</h1>

	<div id="tabs">
		<ul>
			<li><a href="#tabs-1">Pending Request</a></li>
			<li><a href="#tabs-2">Processed Request</a></li>
			<li><a href="#tabs-3">Rejcted Request</a></li>
		</ul>
		<div id="tabs-1">
			<table border="1" id="example">
				<thead>
					<tr>
						<td>Sr no.</td>
						<td>Request HeaderSeq</td>
						<td>Requested Amount</td>
						<td>Request By</td>
						<td>Request On</td>
						<td>ReqIcmcId</td>
						<td>reqStatus</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pr_Request_HeaderDTOList}" var="prStatus"
						varStatus="myIndex">
						<tr>
							<td>${myIndex.index +1}</td>
							<td>${prStatus.requestHeaderSeq}</td>
							<td>${prStatus.requestedAmount}</td>
							<td>${prStatus.requestBy}</td>
							<td>${prStatus.requestOn}</td>
							<td>${prStatus.reqIcmcId}</td>
							<td>${prStatus.reqStatus}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
		<div id="tabs-2">
			<table border="1" id="example">
				<thead>
					<tr>
						<td>Sr no.</td>
						<td>Request HeaderSeq</td>
						<td>Requested Amount</td>
						<td>Request By</td>
						<td>Request On</td>
						<td>ReqIcmcId</td>
						<td>reqStatus</td>
						<td>Acknowledgement</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pr_Request_HeaderDTOPendingList}"
						var="prStatus" varStatus="myIndex">
						<tr>
							<td>${myIndex.index +1}</td>
							<td>${prStatus.requestHeaderSeq}</td>
							<td>${prStatus.requestedAmount}</td>
							<td>${prStatus.requestBy}</td>
							<td>${prStatus.requestOn}</td>
							<td>${prStatus.reqIcmcId}</td>
							<td>${prStatus.reqStatus}</td>
							<td><a href="acknow?flag=${prStatus.requestHeaderSeq}"
								onclick="return confirm('Are you sure to Approve?')">Approve</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div id="tabs-3">
			<p>Rejected Request</p>
		</div>
	</div>
	<div align="center">

		<a href="processRoom">Process Cash</a> <br> <a
			href="getViewDetails">View Denomination</a> <br> <a
			href="machineAllocation">View Machines</a> <br /> <a href="ivalut">Ivault</a>
	</div>
<%-- 	<div align="center">
		<button class="open-button" onclick="openForm()">Chat</button>

		<div class="chat-popup" id="myForm">

			<form:form action="/chatToIvault" modelAttribute="chatMassage"
				method="post" class="form-container">
				<h1>Message To Ivault</h1>

				<label for="msg"><b>Message</b></label>

				<form:input path="listString"  placeholder="Type message.." />
				<form:button type="submit" class="btn">Send</form:button>
				<form:button  type="button" class="btn cancel" onclick="closeForm()">Close</form:button>
				<input type="submit" />
			</form:form>
		</div>
		
<script>
function openForm() {
  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}
</script>
 
	</div>
--%>
</body>
</html>