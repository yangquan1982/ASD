<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	
	// 选择课程
	function selectCourse(){
		var chk_value=[];
		$('input[name="s_courseIds"]:checked').each(function(){
			chk_value.push($(this).val());
		});
		if(chk_value.length==0){
			alert("Please choose at least one!");
			return;
		}
		var courseIds=chk_value.join(",");
		if(confirm("Are you sure your wannna choose this item？")){
			$.post("student?action=selectCourse",{courseIds:courseIds},
				function(result){
					var result=eval('('+result+')');
					if(result.success){
						alert("Execute Successfully!");
						window.location.href="${pageContext.request.contextPath}/student?action=preSelect";
					}else{
						alert(result.errorMsg);
					}
				}
			);
		}
	}
	
	// 退选课程
	function unselectCourse(){
		var chk_value=[];
		$('input[name="scIds"]:checked').each(function(){
			chk_value.push($(this).val());
		});
		if(chk_value.length==0){
			alert("Please choose at least one unselected item!");
			return;
		}
		var scIds=chk_value.join(",");
		if(confirm("Are you sure your wannna choose this item？")){
			$.post("student?action=unSelectCourse",{scIds:scIds},
				function(result){
					var result=eval('('+result+')');
					if(result.success){
						alert("Execute Successfully!");
						window.location.href="${pageContext.request.contextPath}/student?action=preSelect";
					}else{
						alert("Can not be unselected!");
					}
				}
			);
		}
	}

</script>
<div class="panel panel-default">
  <div class="panel-heading">Goods List</div>
      <table class="table table-hover  table-bordered table-striped">
        <thead>
        	<tr>
        	    <th>&nbsp;</th>
        		<th>Prefix</th>
			  	<th>Goods Name</th>
			  	<th>Price</th>
			  	<th>Seller Name</th>
        	</tr>
          <c:forEach var="selectCourse" items="${selectCourseList }" varStatus="status">
		  	<tr>
		  		<td><input type="checkbox" name="s_courseIds" value="${selectCourse.id}"/></td>
		  	    <td>${status.index+1 }</td>
		  		<td>${selectCourse.courseName }</td>
		  		<td>${selectCourse.credit }</td>
		  		<td>${selectCourse.tearchName }</td>
		  	</tr>
		  </c:forEach>
        </tbody>
      </table>
      <button type="button" class="btn btn-success" style="margin: 5px" onclick="selectCourse()">Add to Shopping Cart</button>
</div>
<hr/>
<div class="panel panel-default">
  <div class="panel-heading">Shopping Cart</div>
      <table class="table table-hover  table-bordered table-striped">
        <thead>
        	<tr>
        	    <th>&nbsp;</th>
        		<th>Prefix</th>
			  	<th>GoodsName</th>
			  	<th>Price</th>
			  	<th>Quantity</th>
        	</tr>
          <c:forEach var="course" items="${myCourseList }" varStatus="status">
		  	<tr>
		  		<td><input type="checkbox" name="scIds" value="${course.id }"/></td>
		  	    <td>${status.index+1 }</td>
		  		<td>${course.courseName }</td>
		  		<td>${course.credit }</td>
		  		<td>${course.score }</td>
		  	</tr>
		  </c:forEach>
        </tbody>
      </table>
      <button type="button" class="btn btn-danger" style="margin: 5px" onclick="unselectCourse()">Delete</button>
      <button type="button" class="btn btn-danger" style="margin: 5px" onclick="javascript:window.location.href='${pageContext.request.contextPath}/student?action=courseList'"> Proceed to Check Out</button>
                                                                                                        
</div>





