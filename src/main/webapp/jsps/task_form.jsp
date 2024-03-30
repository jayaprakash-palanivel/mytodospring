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
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include><br>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${task != null}">
					<form action="updateTask" method="post" modelAttribute="taskBo">
				</c:if>
				<c:if test="${task == null}">
					<form action="createTask" method="post" modelAttribute="taskBo">
				</c:if>
				<c:if test="${!empty errorMessage}">
					<div class="alert alert-success">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<h4 align="center">${errorMessage}</h4>

					</div>
				</c:if>
				<caption>
					<h2>
						<c:if test="${task != null}">
            			Edit Task
            		</c:if>
						<c:if test="${task == null}">
            			Add New Task
            		</c:if>
					</h2>
				</caption>

				<c:if test="${task != null}">
					<input type="hidden" name="taskId"
						value="<c:out value='${task.taskId}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Project</label> <select name="projectId"
						class="form-control" type="text" required="required">
						<c:if test="${!empty task.project}">
							<option value="${task.project.projectId}">${task.project.projectName}</option>
						</c:if>
						<option value="">Select Project</option>
						<c:forEach items="${projectList}" var="project">
							<option value="${project.projectId}">
								${project.projectName}</option>
						</c:forEach>
					</select>

				</fieldset>

				<fieldset class="form-group">
					<label>Task Name</label> <input type="text"
						value="<c:out value='${task.taskName}' />" class="form-control"
						name="taskName" required="required" minlength="5">
				</fieldset>

				<fieldset class="form-group">
					<label>Task Type</label> <input type="text"
						value="<c:out value='${task.taskType}' />" class="form-control"
						name="taskType" minlength="5">
				</fieldset>

				<fieldset class="form-group">
					<label>Task Owner</label> <select name="employeeId"
						class="form-control" type="text" required="required">
						<c:if test="${!empty task.employee}">
							<option value="${task.employee.employeeId}">${task.employee.firstName}</option>
						</c:if>
						<option value="">Select Employee</option>
						<c:forEach items="${employeeList}" var="employee">
							<option value="${employee.employeeId}">
								${employee.firstName}</option>
						</c:forEach>
					</select>

				</fieldset>


				<fieldset class="form-group">
					<label> Task Start Date</label> <input type="date"
						value="<c:out value='${task.startDate}' />" class="form-control"
						name="startDate" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label> Task End Date</label> <input type="date"
						value="<c:out value='${task.endDate}' />" class="form-control"
						name="endDate" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label> Task Status</label> <select class="form-control"
						name="taskStatus">
						<option value="false">In Progress</option>
						<option value="true">Complete</option>
					</select>
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