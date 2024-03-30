<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todo Search List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<br>
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Todos Based On Project and Task</h3>
			<hr>
			<%-- <div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					Todo</a>
			</div> --%>
			
			<c:if test="${!empty errorMessage}">
						<div class="alert alert-success">

							<h4 align="center">${errorMessage}</h4>

						</div>
					</c:if>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Title</th>
						<th>Task Name</th>
						<th>Target Date</th>
						<th>Todo Status</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="todo" items="${listTodo}">

						<tr>
							<td><c:out value="${todo.title}" /></td>
							<td><c:out value="${todo.task.taskName}" /></td>
							<td><c:out value="${todo.targetDate}" /></td>
							<td><c:out value="${todo.status}" /></td>

							<td><a href="edit?id=<c:out value='${todo.id}' />"><i
									class=" fa fa-edit" style="font-size: 20px; color: blue"></i></a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${todo.id}' />"><i
									class="fa fa-trash-o" style="font-size: 20px; color: blue"></i></a></td>

							<!--  <td><button (click)="updateTodo(todo.id)" class="btn btn-success">Update</button>
          							<button (click)="deleteTodo(todo.id)" class="btn btn-warning">Delete</button></td> -->
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>