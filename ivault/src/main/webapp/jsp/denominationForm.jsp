<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<script src="./js/jquery-3.4.1.min.js"></script>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no" name="viewport">
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<title>Denomination</title>
<script type="text/javascript">
$(document).ready(function(){
	$('.notecount').change(function(){
		var denompar=$(this).parents('tr');
		var bundleval = denompar.children('[data-type="bundleCounts"]').val();
		x = parseFloat((this.value|0)) * parseFloat((denompar.data('denom')|0)) * parseInt((bundleval|0));
		denompar.children('[data-type="grand"]').html(x);
		var sum =0;
		$(denompar.parents('tbody')).children('tr').children('td.grand').each(function(index){
			sum += parseFloat(this.innerHTML|0);
		});	
	var grndttlid=(denompar.data('type')=="notes")?'grandTotal':'grandTotalcoins';
	document.getElementById(grndttlid).innerHTML=sum;
	document.getElementById('itihsValue').innerHTML=(document.getElementById('grandTotal').innerHTML|0)+(document.getElementById('grandTotalcoins').innerHTML|0)
	document.getElementById('hdnitihvalue').value=document.getElementById('itihsValue').innerHTML;
	document.getElementById('imdCalDenoRowValue').value=x;
	});
});
</script>

<style>

	.table-fill{
	background: white;
	border-radius: 3px;
	border-collapse: collapse;
	height: 50px;
	margin: auto;
	padding: 5px;
	width: 100%;
	box-shadow: 0 5px rgba(0, 0, 0,0.1);
	animation: float 5s infinite;
	}
	
	th{
	color: #D5DDE5;
	border-bottom: 4px solid #343a45;
	border-right: 1px solid #34a45;
	font-size: 20px;
	font-weight: 100;
	padding: 24px;
	text-align: left;
	text-shadow: 0 1px 1px rgba(0,0,0,0.1);
	vertical-align: middle;
	}
	
	th:first-child{
	border-top-left-radius: 3px;
	}

	th:last-child {
	border-top-left-radius: 3px;
	border-right: none;
    }
    
    tr{
    border-top: 1px solid #C1C3D1;
    border-bottom: 1px solid #C1C3D1;
    color: #666B85;
    font-size: 16px;
    font-weight: normal;
    text-shadow: 0 1px 1px rgba(256, 256, ,256,0.1);
    }
    
    tr:hover td{
    background: #4E5066;
    color: #FFFFFF;
    border-top: 1px solid #22262e
    }
    
    tr:first-child
    {
      border-top: none;
    }
    
    tr:last-child{
    border-bottom: none;
    }
    
    tr:nth-child(odd) td{
    background: #EBEBEB;
    }
    
    tr:nth-child(odd):hover td{
    background: #4E5066;
    }
    
    tr:last-child td:first-child{
    border-bottom-left-radius: 3px;
    }
    
    tr:last-child td:last-child{
    border-bottom-right-radius: 3px;
    }
    
    td{
    background: #FFFFFF;
    padding: 10px;
    text-align: left;
    vertical-align: middle;
    font-weight: 300;
    font-size: 18px;
    text-shadow: -1px -1px 1px rgba(0, 0, 0, 0.1);
    border-right: 1px solid #C1C3D1;
    }
    
    td:last-child{
    border-right: 0px;
    }
    
    th.text-left{
    text-align: left;
    }
    
    th.text-center{
    text-align: center;
    }
    
    th.text-right{
    text-align: right;
    }
    
    
    td.text-left{
    text-align: left;
    }
    
     td.text-center{
    text-align: center;
    }
    
     td.text-right{
    text-align: right;
    }
    
</style>

<style>

.container{
width: 95%;
padding: 0px 10px;
text-align: center;
}
.row{
margin: 5px 5px;
width: 45%;
display: inline-block;
top: 0;
}
</style>

</head>
<div class="container">
<body>
	<form:form method="POST" action="processPickUpReq" modelAttribute="denominationList">
	<div class="table-fill" align="center">
	<h3>BRANCHINWARD</h3>
	</div>
	
	<div>
	<table align="left">
	<thead>
	<tr>
	<th>NOTE</th>
	<th>NO OF BUNDLE</th>
	<th>VALUE</th>
	</tr>
	</thead>
	
	<tbody class="table-hover">
	<c:forEach items="${denominationList.denominationFormList}" var="denomination" varStatus="status">
	<c:if test="${denomination.imdDenoType==1}">
    <tr data-denom="${denomination.imdDenomination}" data-type="notes"> 
         
		<td>${denomination.imdDenomination}
		<input type="hidden" 
		id="imdDenomination" 
		name="denominationFormList[${status.index}].imdDenomination"
		value="${denomination.imdDenomination}" />
		</td>
								
        <td> <input type="text" 
        class="notecount" 
        id="imdNoOfBundle" 
        name="denominationFormList[${status.index}].imdNoOfBundle">
         </td>
         
        <td data-type="grand" 
        class="grand">
       <input type="hidden"
        id="imdCalDenoRowValue"
        name ="denominationFormList[${status.index}].imdCalDenoRowValue"
        value="${denomination.imdCalDenoRowValue}" />
        </td>
        
        <input type="hidden" 
        data-type="bundleCounts" 
        class="bundleCounts" 
        id="bundleCount${denomination.imdDenomination}" 
        value="${denomination.imdCountInBundle}" />
    </tr>
    </c:if>
</c:forEach>


  <tr align="center">
  <td class="text-left">Total</td>
  <td class="text-left"></td>
  <td class="text-left" contenteditable="false" id="grandTotal" name="total">0</td>
  </tr>
	</tbody>
	</table>
	</div>
	
	
	
	<div class="row">
	<table class="table-fill" align="right">
	<thead>
	<tr>
	<th>COINS</th>
	<th>NO OF BAGS</th>
	<th>VALUE</th>
	</tr>
	</thead>
	
	<tbody class="table-hover">
	<c:forEach items="${denominationList.denominationFormList}" var="denomination" varStatus="status">
	<c:if test="${denomination.imdDenoType==0}">
    <tr data-denom="${denomination.imdDenomination}" data-type="coins">      
       <td>${denomination.imdDenomination}
		<input type="hidden" 
		id="imdDenomination" 
		name="denominationFormList[${status.index}].imdDenomination"
		value="${denomination.imdDenomination}" />
		</td>
		
        <td> <input type="text" 
        class="notecount" 
        id="imdNoOfBundle" 
        name="denominationFormList[${status.index}].imdNoOfBundle"> 
        </td>
        
        <td data-type="grand" 
        class="grand">
     	<input type="hidden"
        id="imdCalDenoRowValue" 
        name="denominationFormList[${status.index}].imdCalDenoRowValue"
        value="${denomination.imdCalDenoRowValue}" /> 
        </td>
         
       <input type="hidden"
        data-type="bundleCounts"
        class="bundleCounts"
        id="bundleCount${denomination.imdDenomination}" 
        value="${denomination.imdCountInBundle}">
    </tr>
    </c:if>
</c:forEach>

  <tr align="center">
  <td class="text-left">Total</td>
  <td class="text-left"></td>
  <td class="text-left" contenteditable="false" id="grandTotalcoins" name="total">0</td>
  </tr>
  </tbody>
	</table>
	</div>
  
  <p align="center">
	<label>Total Value : </label>
	<label id="itihsValue" > 0 </label>
	<input type="hidden" id="hdnitihvalue" name="itihsValue" />
	</p>
	
	<p>
	<label>Seck Lock Number</label>
	<input type="text" id="itihsSeckLockNo" name="itihsSeckLockNo">
	</p>
	
	<P align="center"><button type="submit" name="save"> SUBMIT </button>
	</P>
  
	</form:form>
</body>
</div>
</html>