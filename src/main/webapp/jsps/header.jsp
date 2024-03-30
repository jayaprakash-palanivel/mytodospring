<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: #1c4966">
		
		<div>
			<a href="" class="navbar-brand"> Todo
				App</a>
		</div>
		<%-- <c:if test="${!empty userId}"> --%>
		<div>
			<a href="listProject" class="navbar-brand"> Projects</a>
		</div>
		<div>
			<a href="listTask" class="navbar-brand"> Tasks</a>
		</div>
		<div>
			<a href="listTodo" class="navbar-brand"> Todos</a>
		</div>
		<div>
			<a href="listEmployee" class="navbar-brand"> Employee</a>
		</div>
		<div>
			<a href="taskSearch" class="navbar-brand"> TaskSearch</a>
		</div>
		<div>
			<a href="todoSearch" class="navbar-brand"> TodoSearch</a>
		</div>
		<div>
			<a href="uploadEmployee" class="navbar-brand"> UploadEmployee</a>
		</div>
		<div>
			<a href="test" class="navbar-brand"> Test</a>
		</div>
		<ul class="navbar-nav navbar-collapse justify-content-end">
			<li><a href="<%=request.getContextPath()%>/home"
				class="nav-link">Home</a></li>
				<li><a href="<%=request.getContextPath()%>/logout"
				class="nav-link">Logout</a></li>
				</ul>
		<%-- </c:if> --%>
		<c:if test="${empty userId }">
		<ul class="navbar-nav navbar-collapse justify-content-end">
			<li><a href="<%=request.getContextPath()%>/login"
				class="nav-link">Login</a></li>
			<li><a href="<%=request.getContextPath()%>/register"
				class="nav-link">Signup</a></li>
		</ul>
		</c:if>
	</nav>
</header>