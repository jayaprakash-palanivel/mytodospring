<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<!-- <link rel="resources" href="/resources/pagination.less"> -->


<meta charset="ISO-8859-1">
<title>Employee</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include><br>
	<div class="box-list">
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Employees</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/insert_employee"
					class="btn btn-success">Add Employee</a>
			</div>
			
			<br>
			<c:if test="${!empty errorMessage}">
				<div class="alert alert-success">

					<h4 align="center">${errorMessage}</h4>

				</div>
			</c:if>

			<table class="table table-bordered">
				<thead>
					<tr>
						<th>FirstName</th>
						<th>LastName</th>
						<th>EmailId</th>
						<th>MobileNumber</th>
						<th>Address</th>
						<th>City</th>
						<th>State</th>
						<th>Country</th>
						<th>Actions</th>
						<th>Download Resume</th>
						<th>Download Profile Image</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="employee" items="${listEmployee}">

						<tr>
							<td><c:out value="${employee.firstName}" /></td>
							<td><c:out value="${employee.lastName}" /></td>
							<td><c:out value="${employee.emailId}" /></td>
							<td><c:out value="${employee.mobileNumber}" /></td>
							<td><c:out value="${employee.address}" /></td>
							<td><c:out value="${employee.city}" /></td>
							<td><c:out value="${employee.state}" /></td>
							<td><c:out value="${employee.country}" /></td>
							<td><a
								href="editEmployee?employeeId=<c:out value='${employee.employeeId}' />"><i
									class=" fa fa-edit" style="font-size: 20px; color: blue"></i></a>
								&nbsp;&nbsp;<a
								href="deleteEmployee?employeeId=<c:out value='${employee.employeeId}' />"><i
									class="fa fa-trash-o" style="font-size: 20px; color: blue"></i></a></td>
							<td><a
								href="employeeResumeDownload?employeeId=<c:out value='${employee.employeeId}' />"><i
									class="fa fa-download" style="font-size: 20px; color: blue"></i></a>
							</td>
							<td><a
								href="employeeProfileImageDownload?imageId=<c:out value='${employee.profileImage}' />"><i
									class="fa fa-download" style="font-size: 20px; color: blue"></i></a>
							</td>
							<!--  <td><button (click)="updateTodo(todo.id)" class="btn btn-success">Update</button>
          							<button (click)="deleteTodo(todo.id)" class="btn btn-warning">Delete</button></td> -->
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
			
			<nav style="text-align: center; ">
				<ul class="pagination pagination-theme  no-margin center"
					style="margin-left: 700px;">
					<c:if test="${employeeLists.currentPage gt 1}">
						<li><a
							href="view-employees?page=1&&search=${searchEmployees}"><span><i
									class="fa fa-angle-double-left" aria-hidden="true"></i> </span></a></li>
						<li><a
							href="view-employees?page=${employeeLists.currentPage - 1}&&search=${searchEmployees}"><span><i
									class="fa fa-angle-left" aria-hidden="true"></i> </span></a></li>
					</c:if>
					<c:forEach items="${employeeLists.noOfPages}" var="i">
						<c:choose>
							<c:when test="${employeeLists.currentPage == i}">

								<li class="active"><a
									style="color: #fff; background-color: #34495e">${i}</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="view-employees?page=${i}">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${employeeLists.currentPage lt employeeLists.totalPages}">
						<li><a
							href="view-employees?page=${employeeLists.currentPage + 1}"><span><i
									class="fa fa-angle-right" aria-hidden="true"></i> </span></a></li>
						<li><a
							href="view-employees?page=${employeeLists.lastRecordValue}"><span><i
									class="fa fa-angle-double-right" aria-hidden="true"></i> </span></a></li>
					</c:if>
				</ul>
			</nav>

		</div>
	</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>