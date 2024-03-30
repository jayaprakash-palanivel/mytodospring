<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include><br>
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Tasks</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/createTask" class="btn btn-success">Add
					Task</a>
			</div>
			<br>
				<c:if test="${!empty errorMessage}">
					<div class="alert alert-success">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<h4 align="center">${errorMessage}</h4>

					</div>
				</c:if>

			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Task Name</th>
						<th>Task Type</th>
						<th>Task Owner</th>
						<th>Assigned Project</th>
						<th>Start Date</th>
						<th>End Date</th>
						<th>Task Status</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="task" items="${listTask}">

						<tr>
							<td><c:out value="${task.taskName}" /></td>
							<td><c:out value="${task.taskType}" /></td>
							<td><c:out value="${task.employee.firstName}" /></td>
							<td><c:out value="${task.project.projectName}" /></td>
							<td><c:out value="${task.startDate}" /></td>
							<td><c:out value="${task.endDate}" /></td>
							<td><c:out value="${task.taskStatus}" /></td>
							<td><a href="editTask?taskId=<c:out value='${task.taskId}' />"><i
									class=" fa fa-edit" style="font-size:20px;color:blue"></i></a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteTask?taskId=<c:out value='${task.taskId}' />"><i
									class="fa fa-trash-o" style="font-size:20px;color:blue"></i></a></td>

							<!--  <td><button (click)="updateTodo(todo.id)" class="btn btn-success">Update</button>
          							<button (click)="deleteTodo(todo.id)" class="btn btn-warning">Delete</button></td> -->
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
<br><br><br><br><br><br><br><br>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>