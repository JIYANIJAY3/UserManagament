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
<link rel="stylesheet" href="CSS/UserHome.css">
<%
response.setHeader("Pragma", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Expires", "0");
response.setDateHeader("Expires", -1);
%>
</head>

<body>
	<c:import url="Header.jsp"></c:import>
	<c:choose>
		<c:when test="${!empty sessionScope.User}">
			<div class="section">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<h1 style="color: aliceblue;">
								Welcome
								<c:out value="${User.getFiratName() }"></c:out>
							</h1>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="head-desc">
								<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
									Dolor deleniti corrupti dolore repellat error aliquam eius
									quaerat commodi, rem voluptatum maiores consequatur saepe
									repellendus nulla quam veritatis dicta delectus ea?</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="head-desc">
								<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
									Dolor deleniti corrupti dolore repellat error aliquam eius
									quaerat commodi, rem voluptatum maiores consequatur saepe
									repellendus nulla quam veritatis dicta delectus ea?</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="head-desc">
								<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
									Dolor deleniti corrupti dolore repellat error aliquam eius
									quaerat commodi, rem voluptatum maiores consequatur saepe
									repellendus nulla quam veritatis dicta delectus ea?</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="head-desc">
								<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
									Dolor deleniti corrupti dolore repellat error aliquam eius
									quaerat commodi, rem voluptatum maiores consequatur saepe
									repellendus nulla quam veritatis dicta delectus ea?</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="head-desc">
								<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
									Dolor deleniti corrupti dolore repellat error aliquam eius
									quaerat commodi, rem voluptatum maiores consequatur saepe
									repellendus nulla quam veritatis dicta delectus ea?</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<c:redirect url="login.jsp" />
		</c:otherwise>
	</c:choose>

	<div class="result"></div>
	<script src="JS/getdata.js"></script>

	<c:import url="footer.jsp"></c:import>
</body>

</html>