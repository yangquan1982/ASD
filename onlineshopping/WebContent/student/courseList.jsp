<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<table class="table table-hover  table-bordered table-striped" style="margin-bottom: 0px;">
		<tr>
		  	<th>Prefix</th>
		  	<th>Goods Name</th>
		  	<th>Price</th>
		  	<th>Quantity</th>
		  </tr>
		  <c:forEach var="course" items="${courseList }" varStatus="status">
		  	<tr>
		  	    <td>${status.index+1 }</td>
		  		<td>${course.courseName }</td>
		  		<td>${course.credit }</td>
		  		<td>${course.score }</td>
		  	</tr>
		  </c:forEach>
		  <tr>
		  	<th>Total Price：  </th>
		  	
		  	<th>  </th>
		  	<th>${total }  </th>
		  </tr>
	</table>
</div>



