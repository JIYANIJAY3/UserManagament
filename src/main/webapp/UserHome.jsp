<%@page import="java.io.InputStream"%>
<%@page import="bean.UserBean"%>
<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="servlet.Login"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>UserHome</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
</head>
<%
response.setHeader("Pragma", "no-cache");

response.setHeader("Cache-Control", "no-store");

response.setHeader("Expires", "0");

response.setDateHeader("Expires", -1);
%>
<body>

	<c:import url="Header.jsp"></c:import>
	<jsp:useBean id="User" scope="session" class="bean.UserBean" />
	<c:if test="${User.getUserId()==0 }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<input type="hidden" id="userid" name="UserId"
		value="${User.getUserId() }">
	<script src="JS/getdata.js"></script>
</body>

</html>