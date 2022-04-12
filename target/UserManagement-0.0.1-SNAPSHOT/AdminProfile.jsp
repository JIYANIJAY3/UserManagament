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
<title>Insert title here</title>
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
<%
response.setHeader("Pragma", "no-cache");

response.setHeader("Cache-Control", "no-store");

response.setHeader("Expires", "0");

response.setDateHeader("Expires", -1);
%>
</head>
<body>

	<c:import url="AdminHeader.jsp"></c:import>
	<jsp:useBean id="Admin" scope="session" class="bean.UserBean" />
	<c:choose>
		<c:when test="${Admin.getUserId()!=0 }">
			<section style="background-color: #eee;">
				<div class="container py-5">
					<div class="row">
						<div class="col-lg-8">
							<div class="card mb-4">
								<div class="card-body">
									<div class="row">
										<div class="col-sm-3">
											<p class="mb-0">FirstName</p>
										</div>
										<div class="col-sm-9">
											<p class="text-muted mb-0">
												<c:out value="${Admin.getFiratName() }"></c:out>
											</p>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-3">
											<p class="mb-0">LastName</p>
										</div>
										<div class="col-sm-9">
											<p class="text-muted mb-0">
												<c:out value="${Admin.getLastName() }"></c:out>
											</p>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-3">
											<p class="mb-0">Dob</p>
										</div>
										<div class="col-sm-9">
											<p class="text-muted mb-0">
												<c:out value="${Admin.getDob() }"></c:out>
											</p>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-3">
											<p class="mb-0">Gender</p>
										</div>
										<div class="col-sm-9">
											<p class="text-muted mb-0">
												<c:out value="${Admin.getGender() }"></c:out>
											</p>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-3">
											<p class="mb-0">Email</p>
										</div>
										<div class="col-sm-9">
											<p class="text-muted mb-0">
												<c:out value="${Admin.getEmail() }"></c:out>
											</p>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-3">
											<p class="mb-0">Password</p>
										</div>
										<div class="col-sm-9">
											<p class="text-muted mb-0">
												<c:out value="${Admin.getPassword() }"></c:out>
											</p>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-3">
											<p class="mb-0">Mobail No</p>
										</div>
										<div class="col-sm-9">
											<p class="text-muted mb-0">
												<c:out value="${Admin.getMobailNo() }"></c:out>
											</p>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-3">
											<p class="mb-0">Language</p>
										</div>
										<div class="col-sm-9">
											<p class="text-muted mb-0">
												<c:out value="${Admin.getLanguage() }"></c:out>
											</p>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-sm-3">
											<p class="mb-0">Profile</p>
										</div>
										<div class="col-sm-9">
											<p class="text-muted mb-0">
												<img src="data:image/jpg;base64,${Admin.getBase64Image()}"
													width="240" height="200" />
											</p>
										</div>
									</div>
									<hr>
									<a class="btn btn-primary" href="AdminHome.jsp" role="button">Back</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</c:when>
		<c:otherwise>
			<c:redirect url="login.jsp" />
		</c:otherwise>
	</c:choose>
	<c:import url="footer.jsp"></c:import>

</body>
</html>