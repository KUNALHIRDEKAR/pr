<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<head>
<meta charset="UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>Denomination</title>
<!-- Favicon-->
<script>
	$(document).ready(function() {
		$('.noteCount').change(function() {
			//alert("Content " +this.id);
			countId = this.id;
			denomination = countId.substring(1, countId.length);
			amountId = "t" + denomination;
			amountEle = document.getElementById(amountId);
			x = parseFloat(this.value) * (parseFloat(denomination) * 1000);
			amountEle.innerHTML = x;
			refreshTotal();
		});

		function refreshTotal() {
			sum = 0;
			$('.grand').each(function(index) {
				sum += parseFloat(this.innerHTML);
			});
			grandTotal = document.getElementById("grandTotal");
			grandTotal.innerHTML = sum;
		}
		;
	});
</script>
<style>
/*** Table Styles **/
.table-fill {
	background: white;
	border-radius: 3px;
	border-collapse: collapse;
	height: 320px;
	margin: auto;
	s max-width: 600px;
	padding: 5px;
	width: 50%;
	box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
	animation: float 5s infinite;
}

th {
	color: #D5DDE5;
	background: #1b1e24;
	border-bottom: 4px solid #9ea7af;
	border-right: 1px solid #343a45;
	font-size: 20px;
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
	background: #EBEBEB;
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
	border-right: 1px solid #C1C3D1;
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

0
td.text-left {
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
	<form:form method="post" action="processRequest" modelAttribute="deno">
		<div class="table-title">
			<h3 align="center">Process Room</h3>
		</div>
		<div align="left">
			<table class="table-fill">
				<thead>
					<tr>
						<th>Sr.</th>
						<th class="text-left">NOTES</th>
						<th class="text-left">Number Of Bundels</th>
						<th class="text-left">Amount</th>
					</tr>
				</thead>
				<tbody class="table-hover">
					<c:forEach items="${deno.denominationFormList}" var="denomination" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td>
							${denomination.imdDenomination}
							<input type="hidden" name="denominationFormList[${status.index}].imdDenoId" value="${denomination.imdDenoId}" />
							<input type="hidden"
								name="denominationFormList[${status.index}].imdDenomination"
								value="${denomination.imdDenomination}"/></td>
							<td><input type="text"
								name="denominationFormList[${status.index}].imdCountInBundle"
								value="" class="noteCount"
								id="x${denomination.imdDenomination}"
								name="INR${denomination.imdDenomination}" /></td>
							<td class="grand" id="t${denomination.imdDenomination}">0</td>

						</tr>
					</c:forEach>
					<tr>
						<td></td>
						<td class="text-left">Total</td>
						<td class="text-left"></td>
						<td class="text-left" contenteditable="false" id="grandTotal"
							name="tatal">0</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!--<input type="checkbox" id="remember_me" class="filled-in">
<label for="remember_me">Remember Me</label>-->
		<br>
		<p align="center">
			<button type="submit" name="save"
				class="btn btn-primary m-t-15 waves-effect">SUBMIT</button>
		</p>
	</form:form>
	<closeform></closeform>

</body>
</html>