<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

				<form action="uploadEmployee" method="post"
					enctype="multipart/form-data">


					<caption>
						<h2>Upload Employee</h2>
					</caption>

					<fieldset class="form-group">
						<label>Upload Employee</label> <i style="color: red">upload
							only excel</i><input type="file" name="employeeFile"
							class="form-control">
					</fieldset>


					<button type="submit" class="btn btn-success">Upload</button>
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