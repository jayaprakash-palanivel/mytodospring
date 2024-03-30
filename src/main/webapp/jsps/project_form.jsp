<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Create</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<br>

	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${!empty errorMessage}">
					<div class="alert alert-success">

						<h4 align="center">${errorMessage}</h4>

					</div>
				</c:if>

				<c:if test="${project != null}">

					<form action="editProject" method="post" modelAttribute="projectBo">
				</c:if>
				<c:if test="${project == null}">
					<form action="createProject" method="post"
						modelAttribute="projectBo">
				</c:if>

				<caption>
					<h2>
						<c:if test="${project != null}">
            			Edit Project
            		</c:if>
						<c:if test="${project == null}">
            			Add New Project
            		</c:if>
					</h2>
				</caption>

				<c:if test="${project != null}">
					<input type="hidden" name="projectId"
						value="<c:out value='${project.projectId}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Project Name</label> <input type="text"
						value="<c:out value='${project.projectName}' />"
						class="form-control" name="projectName" required="required"
						minlength="5">
				</fieldset>

				<fieldset class="form-group">
					<label>Project Manager</label> <input type="text"
						value="<c:out value='${project.projectManager}' />"
						class="form-control" name="projectManager" minlength="5">
				</fieldset>

				<fieldset class="form-group">
					<label>Start Date</label> <input type="date"
						value="<c:out value='${project.startDate}' />"
						class="form-control" name="startDate" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>End Date</label> <input type="date"
						value="<c:out value='${project.endDate}' />" class="form-control"
						name="endDate" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>