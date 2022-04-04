<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="errorPage.jsp"%>
<%@ page import="util.ServletUtilClass"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->

<link
	href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="CSS/login.css">
<%
response.setHeader("Pragma", "no-cache");

response.setHeader("Cache-Control", "no-store");

response.setHeader("Expires", "0");

response.setDateHeader("Expires", -1);
%>
</head>

<body>
	<div id="login">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<form action="Login" method="post">
						<div class="card">
							<h3 class="text-center  pt-5" style="color: black;">Login
								form</h3>
							<div class="text-center intro">
								<img src="https://i.imgur.com/uNiv4bD.png" width="160">
							</div>
							<div class="mt-4 text-center">
								<span>Login with your credentials</span>
								<div class="mt-3 inputbox">
									<input type="text" class="form-control" name="email"
										placeholder="Email"> <i class="fa fa-user"></i>
								</div>
								<div class="inputbox">
									<input type="password" class="form-control" name="password"
										placeholder="Password"> <i class="fa fa-lock"></i>
								</div>
							</div>
							<div class="d-flex justify-content-between">
								<div>
									<a href="ForgetPassword.jsp" class="forgot">Forgot
										Password?</a>
								</div>
							</div>
							<div class="mt-2">
								<button class="btn btn-primary btn-block">Log In</button>
							</div>
							<div class="col-sm-6">
								<div class="mt-5">
									<a href="index.jsp" class="forgot">Sign Up</a>
								</div>
							</div>
						</div>
					</form>
					<%=ServletUtilClass.getErrorMessage(request)%>
				</div>
			</div>
		</div>
	</div>
</body>

</html>