<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #1c4966">
			<div>
				<a href="" class="navbar-brand"> Todo
					App</a>
			</div>
			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="<%=request.getContextPath()%>/login"
					class="nav-link">Login</a></li>
				<li><a href="<%=request.getContextPath()%>/register"
					class="nav-link">Signup</a></li>
			</ul>

		</nav>
	</header>
	<br>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				<form action="insert_employee" method="post">


					<caption>
						<h2>Register</h2>
					</caption>

					

					<fieldset class="form-group">
						<label>First Name</label> <input type="text"
							class="form-control" name="firstName" required="required"
							minlength="5">
					</fieldset>

					<fieldset class="form-group">
						<label>Last Name</label> <input type="text"
							class="form-control" name="lastName" minlength="5">
					</fieldset>

					<fieldset class="form-group">
						<label>Email Id</label> <input type="text"
							class="form-control" name="emailId" minlength="5">
					</fieldset>

					<fieldset class="form-group">
						<label>Password</label> <input type="text"
							class="form-control" name="password" minlength="5">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Role</label> <select name="roleId"
							class="form-control" type="text" required="required">

							<option value="">Select Role</option>
							<c:forEach items="${roleList}" var="role">
								<option value="${role.roleId}">
									${role.roleName}</option>
							</c:forEach>
						</select>
					</fieldset>

					<fieldset class="form-group">
						<label>Mobile Number</label> <input type="text"
							class="form-control" name="mobileNumber" minlength="5">
					</fieldset>

					<fieldset class="form-group">
						<label>Address</label> <input type="text"
							class="form-control" name="address" minlength="5">
					</fieldset>

					<fieldset class="form-group">
						<label>City</label> <input type="text" class="form-control"
							name="city" minlength="5">
					</fieldset>

					<fieldset class="form-group">
						<label>State</label> <input type="text" class="form-control"
							name="state" minlength="5">
					</fieldset>

					<fieldset class="form-group">
						<label>Country</label> <input type="text"
							class="form-control" name="country" minlength="5">
					</fieldset>


					<button type="submit" class="btn btn-success">Register</button>
				</form>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>