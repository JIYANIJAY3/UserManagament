<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="CSS/index.css">
<link rel="stylesheet" href="CSS/address.css">

</head>

<body>
	<section class="vh-100 gradient-custom">
		<div class="container py-5 h-100">
			<div class="row justify-content-center align-items-center h-100">
				<div class="col-12 col-lg-9 col-xl-7">
					<div class="card shadow-2-strong card-registration"
						style="border-radius: 15px;">
						<div class="card-body p-4 p-md-5">
							<h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration Form</h3>
							<!-- 
							<div class="container text-center">
								<div class="spinner-border loader" role="status" style="display:non">
									
								</div>
								<span class="sr-only">Loading...</span>
							</div> -->
							<div class="container text-center">
								<h5 id="massage"></h5>
							</div>
							<form action="Registration" method="post" id="form"
								enctype="multipart/form-data">

								<div class="row">
									<div class="col-md-6 mb-4">

										<div class="form-outline">
											<label class="form-label" for="firstName" name="fname">First
												Name</label> <input type="text" id="firstName"
												class="form-control form-control-lg" name="fname" /> <label
												for="fname" class="error"></label>
										</div>
									</div>
									<div class="col-md-6 mb-4">

										<div class="form-outline">
											<label class="form-label" for="lastName">Last Name</label> <input
												type="text" id="lastName"
												class="form-control form-control-lg" name="lname" />

										</div>

									</div>
								</div>

								<div class="row">
									<div class="col-md-6 mb-4 d-flex align-items-center">

										<div class="form-outline datepicker w-100">
											<label for="birthdayDate" class="form-label">Birthday</label>
											<!-- <input type="text" class="form-control form-control-lg"
												id="birthdayDate" name="date" /> -->
											<!-- 				<input type="date" id="birthday" class="form-control name="date"> -->
											<input type="text" id="datepicker" class="form-control"
												autocomplete="off">
										</div>

									</div>
									<div class="col-md-6 mb-4">

										<h6 class="mb-2 pb-1">Gender:</h6>

										<div class="form-check form-check-inline">
											<label class="form-check-label" for="femaleGender">Female</label>
											<input class="form-check-input" type="radio" name="gender"
												id="femaleGender" value="Female" checked />
										</div>

										<div class="form-check form-check-inline">
											<label class="form-check-label" for="maleGender">Male</label>
											<input class="form-check-input" type="radio" name="gender"
												id="maleGender" value="Male" />
										</div>

									</div>
								</div>

								<div class="row">
									<div class="col-md-6 mb-4 pb-2">

										<div class="form-outline">
											<label class="form-label" for="emailAddress">Email</label> <input
												type="email" id="emailAddress"
												class="form-control form-control-lg" name="email" />
										</div>
										<p id="isEmailPresent"></p>
									</div>
									<div class="col-md-6 mb-4 pb-2">

										<div class="form-outline">
											<label class="form-label" for="phoneNumber">password</label>
											<input type="password" id="password"
												class="form-control form-control-lg" name="password" />
										</div>

									</div>
								</div>
								<div class="row">
									<div class="col-md-6 mb-4 pb-2">

										<div class="form-outline">
											<label class="form-label" for="mobail">MobailNo</label> <input
												type="tel" id="mobail" class="form-control form-control-lg"
												name="mobail" />
										</div>

									</div>
									<div class="col-md-6 mb-4 pb-2">
										<label class="form-label" for="mobail">Language</label>
										<div class="form-outline">
											<div class="form-check form-check-inline">
												<input class="form-check-input" type="checkbox"
													id="inlineCheckbox1" name="language" value="JAVA">
												<label class="form-check-label" for="inlineCheckbox1">JAVA</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input" type="checkbox"
													id="inlineCheckbox2" name="language" value="JavaScript">
												<label class="form-check-label" for="inlineCheckbox1">JavaScript</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input" type="checkbox"
													id="inlineCheckbox3" name="language" value="C++"> <label
													class="form-check-label" for="inlineCheckbox1">C++</label>
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
												type="text" id="answer" class="form-control form-control-lg"
												name="answer" />
										</div>

									</div>
								</div>
								<div class="row">

									<div class="col-md-12">
										<div class="mb-3">
											<label for="formFile" class="form-label">Profile</label> <input
												class="form-control" multiple type="file" id="userProfile"
												onchange="document.getElementById('image-preview').src = window.URL.createObjectURL(this.files[0])">
										</div>
										<!-- <div id="image-preview"></div> -->
										<img id="image-preview" width="100" height="100" />
									</div>
								</div>
								<!-- <div class="mt-4 pt-2">
                                    <input class="btn btn-primary btn-lg" type="submit" value="Submit" />
                                </div> -->

								<div id="main-container">
									<div class="panel card container-item">
										<div class="panel-body">
											<div class="panel-body">

												<div class="row">
													<div class="col-sm-6">
														<div class="form-group">
															<label class="control-label" for="address_line_one_0">Country
															</label> <input type="text" id="address_line_one_0"
																class="form-control" name="country" maxlength="255">
															<p class="help-block help-block-error error"></p>
														</div>
													</div>
													<div class="col-sm-6">
														<div class="form-group">
															<label class="control-label" for="address_line_two_0">State
															</label> <input type="text" id="state_0" class="form-control"
																name="state" maxlength="255">
															<p class="help-block help-block-error"></p>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-sm-6">
														<div class="form-group">
															<label class="control-label" for="city_0">City</label> <input
																type="text" id="city_0" class="form-control" name="city"
																maxlength="64">
															<p class="help-block help-block-error"></p>
														</div>
													</div>
													<div class="col-sm-6">
														<div class="form-group">
															<label class="control-label" for="city_0">PinCode</label>
															<input type="text" id="pincode_0" class="form-control"
																name="pincode" maxlength="64">
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
																name="address" maxlength="64">
															<p class="help-block help-block-error error"></p>
														</div>
													</div>

												</div>

												<div class="row">
													<div class="col-sm-12">
														<div>
															<a href="javascript:void(0)"
																class="remove-item btn btn-sm btn-danger remove-social-media">Remove</a>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="card">
									<div>
										<a class="btn btn-success btn-sm" id="add-more"
											href="javascript:;" role="button"><i class="fa fa-plus"></i>
											Add more address</a>
									</div>
								</div>

								<div class="mt-4 pt-2">
									<input class="btn btn-primary btn-lg" type="submit"
										value="Submit" />
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/3.3.2/select2.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/js/bootstrap-select.js"></script>
    <script src="https://cdn.ckeditor.com/4.5.1/standard/ckeditor.js"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js" integrity="sha512-37T7leoNS06R80c8Ulq7cdCDU5MNQBwlYoy1TX/WUsLFC2eYNqtKlV0QjH7r8JpG/S0GUMZwebnVFLPd6SU5yg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script> -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
	<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	<script
		src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
	<script
		src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>
	<script src="address-plugin/cloneData.js" type="text/javascript"></script>

	<!-- <script src="JS/custom.js"></script>
	<script src="JS/validation.js"></script> -->



	<script src="JS/postdata.js"></script>
	<script src="JS/imagePreview.js"></script>
	<script src="JS/getdata.js"></script>
	<script>
		$(function() {
			$("#datepicker").datepicker({
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
			maxLimit : 5, // Default unlimited or set maximum limit of clone HTML
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

		/*$('.select2').select2({
		    placeholder: 'Select a month'
		});*/

		// $(document).ready(function() {
		//     $('.datepicker').datepicker();
		// });
		// Replace the <textarea id="editor1"> with a CKEditor
		// instance, using default configuration.
		/*CKEDITOR.editorConfig = function (config) {
		    config.language = 'es';
		    config.uiColor = '#F7B42C';
		    config.height = 300;
		    config.toolbarCanCollapse = true;
		
		};*/
		//CKEDITOR.replace('editor1');
	</script>
</body>

</html>