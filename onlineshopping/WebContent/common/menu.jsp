<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
function logout(){
	if(confirm('Are you sure you wanna quit？')){
		window.location.href="${pageContext.request.contextPath}/user?action=logout";
	}
}
</script>
<div class="list-group">
  
  <a href="#" class="list-group-item active">
    Menu
  </a>
  
  <c:if test="${currentUser.userType=='admin'}">
	  <a href="${pageContext.request.contextPath}/student?action=list" class="list-group-item">Customer Information Management</a>
	  <a href="${pageContext.request.contextPath}/teacher?action=list" class="list-group-item">Seller Information Management</a>
	  
	  <a href="javascript:logout()" class="list-group-item">Safely Logout</a>
  </c:if>
  
  <c:if test="${currentUser.userType=='seller'}">
      
	  <a href="${pageContext.request.contextPath}/course?action=list" class="list-group-item">Goods Information Management</a>
	  <a href="javascript:logout()" class="list-group-item">Safely Logout</a>
  </c:if>
  
  <c:if test="${currentUser.userType=='customer'}">
      <a href="${pageContext.request.contextPath}/student?action=preSelect" class="list-group-item"> Get started Shopping</a>
   
	  <a href="javascript:logout()" class="list-group-item">Safely Logout</a>
  </c:if>
</div>