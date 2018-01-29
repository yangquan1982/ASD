<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function courseDelete(id){
		if(confirm("Are you sure you wanna delete?")){
			$.post("${pageContext.request.contextPath}/course?action=delete",{id:id},
				function(result){
					var result=eval('('+result+')');
					if(result.success){
						alert("delete Successfully!");
						window.location.href="${pageContext.request.contextPath}/course?action=list";
					}else{
						alert("Delete fail!");
					}
				}
			);
		}
	}
</script>
<div class="row search" >
  <div class="col-md-6">
	<form action="${pageContext.request.contextPath}/course?action=list" method="post">
	    <div class="input-group" style="width: 300px">
		      <input type="text" class="form-control" name="s_courseName"  value="${s_course.courseName }" placeholder="pls input goods name...">
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span>&nbsp;Search</button>
		      </span>
	    </div>
    </form>
  </div>
  <div class="col-md-6" >
    <button type="button"  style="float: right;" class="btn btn-primary" onclick="javascript:window.location.href='${pageContext.request.contextPath}/course?action=preSave'">Add</button>
  </div>
</div>
<div>
	<table class="table table-hover  table-bordered table-striped" style="margin-bottom: 0px;">
		<tr>
		  	<th>Prefix</th>
		  	<th>Goods Name</th>
		  	<th>Price(USD)</th>
		  	<th>Seller Name</th>
		  	<th>Operation</th>
		  </tr>
		  <c:forEach var="course" items="${courseList }" varStatus="status">
		  	<tr>
		  	    <td>${status.index+1 }</td>
		  		<td>${course.courseName }</td>
		  		<td>${course.credit }</td>
		  		<td>${course.tearchName }</td>
		  		<td><button type="button" class="btn btn-info btn-xs" onclick="javascript:window.location.href='${pageContext.request.contextPath}/course?action=preSave&id=${course.id }'">Modify</button>&nbsp;
		    <button type="button" class="btn btn-danger btn-xs" onclick="courseDelete(${course.id })">Delete</button></td>
		  	</tr>
		  </c:forEach>
	</table>
	<nav >
		<ul class="pagination">
			${pageCode }
		</ul>
	</nav>
</div>



