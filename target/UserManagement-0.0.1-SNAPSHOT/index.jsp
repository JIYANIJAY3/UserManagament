<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="util.ServletUtilClass"%>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="image-uploader-master/dist/image-uploader.min.css">
<link rel="stylesheet" href="CSS/index.css">
<link rel="stylesheet" href="CSS/address.css">
<%
response.setHeader("Pragma", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Expires", "0");
response.setDateHeader("Expires", -1);
%>
</head>
<style type="text/css">
ul li {
	float: left;
	list-style: outside none none;
	padding-left: 10px;
}
</style>

<body>
	<jsp:useBean id="test" class="util.ServletUtilClass" />
	<c:if test="${!empty sessionScope.User and empty sessionScope.Admin}">
		<c:import url="Header.jsp"></c:import>
	</c:if>
	<c:if test="${!empty sessionScope.Admin}">
		<c:import url="AdminHeader.jsp"></c:import>
	</c:if>
	<section>
		<div class="container text-center">
			<div class="row">
				<div class="col-md-12">
					<div class="spinner-border loader" style='display: none'></div>
				</div>
			</div>
		</div>
	</section>
	<section class="vh-100 gradient-custom">
		<div class="container py-5 h-100">
			<div class="row justify-content-center align-items-center h-100">
				<div class="col-12 col-lg-9 col-xl-7">
					<div class="card shadow-2-strong card-registration"
						style="border-radius: 15px;">
						<div class="card-body p-4 p-md-5">
							<h3 class="mb-4 pb-2 pb-md-0 mb-md-5 heading" id="form-heading">Registration
								Form</h3>
							<!-- 
							<div class="container text-center">
								<div class="spinner-border loader" role="status" style="display:non">
									
								</div>
								<span class="sr-only">Loading...</span>
							</div> -->
							<div class="container text-center"></div>
							<form action="Registration" method="post" id="form"
								enctype="multipart/form-data">
								<div class="row">
									<div class="col-md-6 mb-4">
										<input type="hidden" id="UserId" name="UserId"
											value="${User.getUserId() }">
										<div class="form-outline">
											<label class="form-label" for="firstName" name="fname">First
												Name</label> <input type="text" id="firstName" required
												class="form-control form-control-lg" name="fname"
												value=<c:out value="${User.getFiratName() }" />> <label
												for="fname" class="error"></label>
										</div>
										<p style="color: red">
											<%=ServletUtilClass.getErrorMessage("FirstNameError", request)%>
										</p>
									</div>
									<div class="col-md-6 mb-4">

										<div class="form-outline">
											<label class="form-label" for="lastName">Last Name</label> <input
												type="text" id="lastName"
												class="form-control
																	form-control-lg"
												name="lname" value=<c:out value="${User.getLastName() }" />>
										</div>
										<p style="color: red">
											<%=ServletUtilClass.getErrorMessage("LastNameError", request)%>
										</p>
									</div>
								</div>

								<div class="row">
									<div class="col-md-6 mb-4 d-flex align-items-center">

										<div class="form-outline datepicker w-100">
											<label for="birthdayDate" class="form-label">Birthday</label>
											<!-- <input type="text" class="form-control form-control-lg"
												id="birthdayDate" name="date" /> -->
											<!-- 				<input type="date" id="birthday" class="form-control name="date"> -->
											<input type="text" name="date" id="datepicker"
												class="form-control" autocomplete="off"
												value=<c:out value="${User.getDob() }" />>
										</div>
										<p style="color: red">
											<%=ServletUtilClass.getErrorMessage("DobError", request)%>
										</p>
									</div>
									<div class="col-md-6 mb-4">

										<h6 class="mb-2 pb-1">Gender:</h6>

										<div class="form-check form-check-inline">
											<label class="form-check-label" for="femaleGender">Female</label>
											<input class="form-check-input" type="radio" name="gender"
												id="femaleGender" value="Female"
												${User.getGender()=='Female' ? 'checked' : ''} />
										</div>

										<div class="form-check form-check-inline">
											<label class="form-check-label" for="maleGender">Male</label>
											<input class="form-check-input" type="radio" name="gender"
												id="maleGender" value="Male"
												${User.getGender()=='Male' ? 'checked' : ''} />
										</div>
										<p style="color: red">
											<%=ServletUtilClass.getErrorMessage("GenderError", request)%>
										</p>
									</div>
								</div>

								<div class="row">
									<div class="col-md-6 mb-4 pb-2">

										<div class="form-outline">
											<label class="form-label" for="emailAddress">Email</label> <input
												type="email" id="emailAddress"
												class="form-control
																	form-control-lg"
												name="email" value=<c:out value="${User.getEmail() }" />>
										</div>
										<p style="color: red">
											<%=ServletUtilClass.getErrorMessage("EmailError", request)%>
										</p>
										<p id="isEmailPresent"></p>
									</div>
									<div class="col-md-6 mb-4 pb-2">

										<div class="form-outline">
											<label class="form-label" for="phoneNumber">password</label>
											<input type="password" id="password"
												class="form-control
																	form-control-lg"
												name="password"
												value=<c:out value="${User.getPassword() }" />>
										</div>
										<p style="color: red">
											<%=ServletUtilClass.getErrorMessage("PasswordError", request)%>
										</p>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6 mb-4 pb-2">

										<div class="form-outline">
											<label class="form-label" for="mobail">MobailNo</label> <input
												type="tel" id="mobail" class="form-control form-control-lg"
												name="mobail" value=<c:out value="${User.getMobailNo() }" />>
										</div>
										<p style="color: red">
											<%=ServletUtilClass.getErrorMessage("MobailError", request)%>
										</p>
									</div>
									<div class="col-md-6 mb-4 pb-2">
										<label class="form-label" for="mobail">Language</label>
										<div class="form-outline">
											<div class="form-check form-check-inline">
												<input class="form-check-input" type="checkbox"
													id="inlineCheckbox1" name="language" value="JAVA"
													${User.getLanguage().toString().trim().contains( 'JAVA') ? 'checked' : ''}>
												<label class="form-check-label" for="inlineCheckbox1">JAVA</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input" type="checkbox"
													id="inlineCheckbox2" name="language" value="JavaScript"
													${User.getLanguage().toString().trim().contains( 'JavaScript') ? 'checked' : ''}>
												<label class="form-check-label" for="inlineCheckbox1">JavaScript</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input" type="checkbox"
													id="inlineCheckbox3" name="language" value="C++"
													${User.getLanguage().toString().trim().contains( 'C++') ? 'checked' : ''}>
												<label class="form-check-label" for="inlineCheckbox1">C++</label>
											</div>
										</div>
										<label class="ferror" for="mobail"></label>
									</div>
								</div>

								<div class="row">
									<!-- <label class="form-label select-label">Security Question</label> -->
									<div class="col-md-6 mb-4 pb-2">
										<label class="form-label select-label">Security
											Question</label> <select class="select form-control-lg"
											name="select-question">
											<option value="1" disabled>Choose option</option>
											<option value="2">Question 1</option>
										</select>
									</div>

									<div class="col-md-6 mb-4 pb-2">
										<div class="form-outline">
											<label class="form-label select-label">answer</label> <input
												type="text" name="answer" id="answer"
												class="form-control
																	form-control-lg"
												value=<c:out value="${User.getAnswer() }" />>
										</div>
										<p style="color: red">
											<%=ServletUtilClass.getErrorMessage("AnserError", request)%>
										</p>
									</div>
								</div>
								<div class="row">

									<div class="col-md-12">
										<!-- <div class="mb-3">
											<label for="formFile" class="form-label">Profile</label> <input
												class="form-control" multiple type="file" id="userProfile"
												name="profile">
										</div> -->
										<div class="form-group">
											<div style="margin-bottom: 47px">
												<label>Profile:</label>
											</div>
											<c:choose>
												<c:when
													test="${!empty sessionScope.User or !empty sessionScope.Admin}">
													<c:forEach items="${UserProfile}" var='userprofile'>
														<span id="${userprofile.imageId}" class="delete-profile">
															<span class="uploadedimage"><img
																src="data:image/jpg;base64,${userprofile.base64Image}"
																class="image" width="100" height="100" /> <span
																class="del-image"><i class="material-icons">clear</i></span></span>
														</span>
													</c:forEach>
													<div class="input-images"></div>
												</c:when>
												<c:otherwise>
													<div class="input-images"></div>
												</c:otherwise>
											</c:choose>
										</div>
										<p style="color: red">
											<%=ServletUtilClass.getErrorMessage("ProfileError", request)%>
										</p>
									</div>
								</div>
								<div class="addressError">
									<p style="color: red">
										<%=ServletUtilClass.getErrorMessage("CountryError", request)%>
									</p>
									<p style="color: red">
										<%=ServletUtilClass.getErrorMessage("CityError", request)%>
									</p>
									<p style="color: red">
										<%=ServletUtilClass.getErrorMessage("PincodeError", request)%>
									</p>
									<p style="color: red">
										<%=ServletUtilClass.getErrorMessage("AddressError", request)%>
									</p>
									<p style="color: red">
										<%=ServletUtilClass.getErrorMessage("StateError", request)%>
									</p>
								</div>
								<div id="main-container">
									<div class="panel card container-item">
										<div class="panel-body">
											<div class="panel-body">

												<div class="row">
													<div class="hello">
														<input type="hidden" class="useraddress" name="AddressId"
															id="addressId_0"
															value=<c:out value="${UserAddress[i].getAddressId() }" />>
													</div>
													<div class="col-sm-6">
														<div class="form-group">
															<label class="control-label" for="address_line_one_0">Country
															</label> <input type="text" id="country_0"
																class="form-control country unique" name="country"
																maxlength="255" required
																value=<c:out value="${UserAddress[i].getCountry() }" />>
														</div>
													</div>
													<div class="col-sm-6">
														<div class="form-group">
															<label class="control-label" for="address_line_two_0">State
															</label> <input type="text" id="state_0"
																class="form-control unique" name="state" maxlength="255"
																value=<c:out value="${UserAddress[i].getState() }" />>
															<p class="help-block help-block-error"></p>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-sm-6">
														<div class="form-group">
															<label class="control-label" for="city_0">City</label> <input
																type="text" id="city_0" class="form-control" name="city"
																maxlength="64"
																value=<c:out value="${UserAddress[i].getCity() }"
                                                                        />>
															<p class="help-block help-block-error"></p>
														</div>
													</div>
													<div class="col-sm-6">
														<div class="form-group">
															<label class="control-label" for="city_0">PinCode</label>
															<input type="text" id="pincode_0"
																class="form-control pincode" name="pincode"
																maxlength="64"
																value=<c:out value="${UserAddress[i].getPinCode() }" />>
															<p class="help-block help-block-error"></p>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-sm-12">
														<div class="form-group">
															<!-- <input type="text" id="city_0" class="form-control" name="Address[0][city] address" maxlength="64"> -->
															<label class="control-label" for="city_0">Address</label>
															<input type="text" id="address_0" class="form-control"
																name="address" maxlength="64"
																value=<c:out value="${UserAddress[i].getAddress() }" />>
															<p class="help-block help-block-error error"></p>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-sm-12">
														<div>
															<a href="javascript:void(0)" id="remove-btn_0"
																class="remove-item btn btn-sm btn-danger
																					remove-social-media remove-btn">Remove</a>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="card">
									<div>
										<a class="btn btn-primary btn-sm add-btn" id="add-more"
											href="javascript:;" role="button"><i class="fa fa-plus"></i>
											Add more address</a>
									</div>
								</div>

								<div class="mt-4 pt-2">
									<input class="btn btn-success btn-lg" id="submit-btn"
										type="submit" value="Submit" />
								</div>
							</form>
							<a href="login.jsp">Login</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
	<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	<script
		src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
	<script
		src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>
	<script src="address-plugin/cloneData.js" type="text/javascript"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="image-uploader-master/dist/image-uploader.min.js"></script>
	<c:choose>
		<c:when test="${!empty sessionScope.UserAddress}">
			<script src="JS/editProfile.js"></script>
		</c:when>
	</c:choose>
	<!-- <script src="JS/custom.js"></script> -->
	<!-- 	<script src="JS/validation.js"></script> -->
	<script src="JS/postdata.js"></script>
	<script src="JS/imagePreview.js"></script>
	<script src="JS/getdata.js"></script>

	<script>
		$('.input-images').imageUploader({
			imagesInputName : 'profiles',
		});
	</script>

	<script>
		$(function() {
			$("#datepicker").datepicker({
				changeMonth : true,
				changeYear : true,
				maxDate : new Date(),
				dateFormat : "yy-mm-dd"
			});
		});
	</script>
	<script>
		$('a#add-more').cloneData({
			mainContainerId : 'main-container', // Main container Should be ID
			cloneContainer : 'container-item', // Which you want to clone
			removeButtonClass : 'remove-item', // Remove button for remove cloned HTML
			removeConfirm : true, // default true confirm before delete clone item
			removeConfirmMessage : 'Are you sure want to delete?', // confirm delete message
			//append: '<a href="javascript:void(0)" class="remove-item btn btn-sm btn-danger remove-social-media">Remove</a>', // Set extra HTML append to clone HTML
			minLimit : 1, // Default 1 set minimum clone HTML required
			maxLimit : 20, // Default unlimited or set maximum limit of clone HTML
			defaultRender : 1,
			init : function() {
				console.info(':: Initialize Plugin ::');
			},
			beforeRender : function() {
				console.info(':: Before rendered callback called');
			},
			afterRender : function() {
				console.info(':: After rendered callback called');
				//$(".selectpicker").selectpicker('refresh');
			},
			afterRemove : function() {
				console.warn(':: After remove callback called');
			},
			beforeRemove : function() {
				console.warn(':: Before remove callback called');
			}

		});
	</script>
</body>

</html>