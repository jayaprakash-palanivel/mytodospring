<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task Search</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				<form action="task_search_list" method="post">

					<caption>
						<h1>Task Search</h1>
					</caption>
					<c:if test="${!empty errorMessage}">
						<div class="alert alert-success">

							<h4 align="center">${errorMessage}</h4>

						</div>
					</c:if>

					<fieldset class="form-group">
						<label>Project</label> <select name="projectId"
							class="form-control" type="text" required="required">

							<option value="">Select Project</option>
							<c:forEach items="${projectList}" var="project">
								<option value="${project.projectId}">
									${project.projectName}</option>
							</c:forEach>
						</select>
					</fieldset>


					<button type="submit" class="btn btn-success">Search</button>
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