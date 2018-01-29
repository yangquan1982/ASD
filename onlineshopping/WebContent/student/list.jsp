<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function studentDelete(id){
		if(confirm("Are you sure you wanna delete？")){
			$.post("${pageContext.request.contextPath}/student?action=delete",{id:id},
				function(result){
					var result=eval('('+result+')');
					if(result.success){
						alert("Delete Successfully!");
						window.location.href="${pageContext.request.contextPath}/student?action=list";
					}else{
						alert("Delete Fail！Maybe this guy had already buy something and haven't checkek out...");
					}
				}
			);
		}
	}
</script>
<div class="row search" >
  <div class="col-md-6">
	<form action="${pageContext.request.contextPath}/student?action=list" method="post">
	    <div class="input-group" style="width: 300px">
		      <input type="text" class="form-control" name="s_userName"  value="${s_student.userName }" placeholder="pls input user name...">
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span>&nbsp;Search</button>
		      </span>
	    </div>
    </form>
  </div>
  <div class="col-md-6" >
    <button type="button"  style="float: right;" class="btn btn-primary" onclick="javascript:window.location.href='${pageContext.request.contextPath}/student?action=preSave'">Add</button>
  </div>
</div>
<div>
	<table class="table table-hover  table-bordered table-striped" style="margin-bottom: 0px;">
		<tr>
		  	<th>Prefix</th>
		  	<th>UserName</th>
		  	<th>Password</th>
		  	<th>TrueName</th>
		  	<th>No</th>
		  	<th>Sex</th>
		  	<th>Operation</th>
		  </tr>
		  <c:forEach var="student" items="${studentList }" varStatus="status">
		  	<tr>
		  	    <td>${status.index+1 }</td>
		  		<td>${student.userName }</td>
		  		<td>${student.password }</td>
		  		<td>${student.trueName }</td>
		  		<td>${student.stuNo }</td>
		  		<td>${student.professional }</td>
		  		<td><button type="button" class="btn btn-info btn-xs" onclick="javascript:window.location.href='${pageContext.request.contextPath}/student?action=preSave&id=${student.id }'">Modify</button>&nbsp;
		  				<button type="button" class="btn btn-danger btn-xs" onclick="studentDelete(${student.id })">Delete</button></td>
		  	</tr>
		  </c:forEach>
	</table>
	<nav >
		<ul class="pagination">
			${pageCode }
		</ul>
	</nav>
</div>



