<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
	<script src="${pageContext.request.contextPath}/bootstrap3/js/jQuery.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css">
<STYLE type=text/css>
	/* Credit to bootsnipp.com for the css for the color graph */
	.colorgraph {
		height: 5px;
		border-top: 0;
		background: #c4e17f;
		border-radius: 5px;
		background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
		background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
		background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
		background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
	}
</STYLE>
</head>
<body>


<div class="container">

	<div class="row" style="margin-top:20px">
		<div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
			<form role="form" id=adminlogin  method=post name=adminlogin action="user?action=login" >
				<fieldset>
					<h2>Please Sign In</h2>
					<hr class="colorgraph">
					<div class="form-group">
						<INPUT type="text" class="form-control input-lg" value="${user.userName }" name="userName" id="userName">
					</div>
					<div class="form-group">
						<INPUT type="password" class="form-control input-lg" value="${user.password }" name="password" id="password"/>
					</div>
					<div class="form-group">
						<select id="userType" name="userType" class="form-control">
							<option value="">Please choose a User Type...</option>
							<option value="admin"  ${'admin'==user.userType?'selected':'' }>admin</option>
							<option value="seller"  ${'seller'==user.userType?'selected':'' }>seller</option>
							<option value="customer"  ${'customer'==user.userType?'selected':'' }>customer</option>
						</select>
					</div>

					<hr class="colorgraph">
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6">
							<input type="submit" class="btn btn-lg btn-success btn-block" value="Sign In" onclick="javascript:adminlogin.submit();return false;">
						</div>

					</div>
				</fieldset>
			</form>
		</div>
	</div>

</div>



</body>
</html>
<script type=text/javascript>
	if('${error}'!=''){
		alert('${error}');
	}
</script>