<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function checkForm(){
		var userName=$("#userName").val();
		var password=$("#password").val();
		var trueName=$("#trueName").val();
		var stuNo=$("#stuNo").val();
		var professional=$("#professional").val();
		if(userName==null||userName==""){
			$("#error").html("userName cannot be null！");
			return false;
		}
		if(password==null||password==""){
			$("#error").html("password cannot be null！");
			return false;
		}
		if(trueName==null||trueName==""){
			$("#error").html("truename cannot be null！");
			return false;
		}
		if(stuNo==null||stuNo==""){
			$("#error").html("No. cannot be null！");
			return false;
		}
		if(professional==null||professional==""){
			$("#error").html("sex cannot be null！");
			return false;
		}
		return true;
	}
	
	function resetValue(){
		$("#userName").val("");
		$("#password").val("");
		$("#trueName").val("");
		$("#stuNo").val("");
		$("#professional").val("");
	}
</script>
<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">${actionName }</h3>
  </div>
  <div class="panel-body">
    	<form class="form-horizontal" role="form" method="post"  action="${pageContext.request.contextPath}/student?action=save" onsubmit="return checkForm()" >
		  <div class="form-group">
		    <label  class="col-md-2 control-label">userName：</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control" id="userName"  name="userName" style="width: 300px;"  value="${student.userName }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label  class="col-md-2 control-label">password：</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control" id="password"  name="password" style="width: 300px;"  value="${student.password }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">trueName：</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control" id="trueName"  name="trueName" style="width: 300px;"  value="${student.trueName }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">No.：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="stuNo"  name="stuNo" style="width: 300px;"  value="${student.stuNo }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">Sex：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="professional"  name="professional" style="width: 300px;"  value="${student.professional }">
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <input type="hidden" id="id" name="id" value="${student.id }"/>
		      <button type="submit" class="btn btn-primary">Save</button>&nbsp;&nbsp;
		      <button type="button" class="btn btn-primary" onclick="resetValue()">Reset</button>&nbsp;&nbsp;
		      <font color="red" id="error"></font>
		    </div>
		  </div>
		</form>
  </div>
</div>

