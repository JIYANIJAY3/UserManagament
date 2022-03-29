<%@page import="java.io.InputStream"%>
<%@page import="bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="servlet.Login"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="Header.jsp"></c:import>

	<%
	UserBean bean = (UserBean) session.getAttribute("User");
	%>

	<%=bean.getUserId() %>
	<%=bean.getFiratName()%>
	<%=bean.getEmail()%>
</body>
</html>