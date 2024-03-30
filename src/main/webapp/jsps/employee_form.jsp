<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include><br>
	
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${employee != null}">
					<form action="editEmployee" method="post"
						modelAttribute="employeeBo">
				</c:if>
				<c:if test="${employee == null}">
					<form action="insert_employee" method="post"
						modelAttribute="employeeBo" enctype="multipart/form-data">
				</c:if>

				<c:if test="${!empty errorMessage}">
					<div class="alert alert-success">

						<h4 align="center">${errorMessage}</h4>

					</div>
				</c:if>

				<caption>
					<h2>
						<c:if test="${employee != null}">
            			Edit Employee
            		</c:if>
						<c:if test="${employee == null}">
            			Add New Employee
            		</c:if>
					</h2>
				</caption>



				<c:if test="${employee != null}">
					<input type="hidden" name="employeeId"
						value="<c:out value='${employee.employeeId}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>First Name</label> <input type="text"
						value="<c:out value='${employee.firstName}' />"
						class="form-control" name="firstName" required="required"
						minlength="5">
				</fieldset>

				<fieldset class="form-group">
					<label>Last Name</label> <input type="text"
						value="<c:out value='${employee.lastName}' />"
						class="form-control" name="lastName" minlength="1">
				</fieldset>

				<fieldset class="form-group">
					<label>Email Id</label> <input type="text"
						value="<c:out value='${employee.emailId}' />" class="form-control"
						name="emailId" minlength="5">
				</fieldset>

				<fieldset class="form-group">
					<label>Password</label> <input type="text"
						value="<c:out value='${employee.password}' />"
						class="form-control" name="password" minlength="5">
				</fieldset>

				<fieldset class="form-group">
					<label>Mobile Number</label> <input type="text"
						value="<c:out value='${employee.mobileNumber}' />"
						class="form-control" name="mobileNumber" minlength="5">
				</fieldset>

				<fieldset class="form-group">
					<label>Address</label> <input type="text"
						value="<c:out value='${employee.address}' />" class="form-control"
						name="address" minlength="5">
				</fieldset>

				<fieldset class="form-group">
					<label>City</label> <input type="text"
						value="<c:out value='${employee.city}' />" class="form-control"
						name="city" minlength="5">
				</fieldset>

				<fieldset class="form-group">
					<label>State</label> <input type="text"
						value="<c:out value='${employee.state}' />" class="form-control"
						name="state" minlength="5">
				</fieldset>

				<fieldset class="form-group">
					<label>Country</label> <input type="text"
						value="<c:out value='${employee.country}' />" class="form-control"
						name="country" minlength="5">
				</fieldset>
				
				<fieldset class="form-group">
					<label>ProfileImage</label> <i style="color:red">upload only jpg</i><input type="file" name="profileImage" class="form-control">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Resume Upload:</label> <i style="color:red">upload only pdf</i><input type="file" name="resume" accepct="application/pdf"  class="form-control">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
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