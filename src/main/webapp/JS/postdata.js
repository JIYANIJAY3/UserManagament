$(document).ready(function() {

	var count = 0;
	var isError = false;
	
	/*$(".add-btn").click(function() {
	count++;
	console.log("count " + count);
	var regexname = /(^[0-9]*$)/;
	for (let i = 1; i <= count; i++) {
		$("#pincode_" + i).keyup(function(e) {
			var pincode = $("#pincode_" + i).val();
			console.log(pincode)
			if (!pincode.match(regexname)) {
				console.log("here");
				isError = true;
				console.log("Error " + isError)
			}
			else {
				isError = false;
				console.log(isError)
			}
		})
	}
	for (let i = 1; i <= count; i++) {
		$("#city" + i).keyup(function(e) {
			console.log("#city" + i)
			var pincode = $("#city" + i).val();
			if (pincode.match("/^[0-9]/")) {
				isError = true;
			}
		})
	}*/


	$("#submit-btn").click(function() {
		$("#form").validate({
			onfocusout: function(e) {
				this.element(e);
			},
			rules: {
				fname: {
					required: true,
					minlength: 2,
					lettersonly: true,
				},
				lname: {
					required: true,
					minlength: 2,
					lettersonly: true
				},
				date: "required",
				gender: "required",
				email: {
					required: true,
					email: true
				},
				password: {
					required: true,
					minlength: 8
				},
				mobail: {
					required: true,
					digits: true
				},
				language: {
					required: true
				},
				profile: {
					required: true
				},
				country: {
					required: true,
					lettersonly: true
				},
				state: {
					required: true,
					lettersonly: true
				},
				city: {
					required: true,
					lettersonly: true
				},
				pincode: {
					required: true,
					digits: true,
				},
				address: {
					required: true
				}
			},
			messages: {
				fname: {
					required: "* FirstName Is Required",
					minlength: "Minimun length is 2",
					lettersonly: "* Enter Only Character"
				},
				lname: {
					required: "* LastName Is Required",
					minlength: "Minimun length is 2",
					lettersonly: "* Enter Only Character"
				},
				gender: "* Plese Select One",
				email: {
					required: "* Email Is Required",
					email: "* Enter Valide Email"
				},
				password: {
					required: "* Password Is Required",
					minlength: "* Minimum Length Is 8"
				},
				mobail: {
					required: "* Mobail Number Is Required",
					digits: "* Enter Only Digits"
				},
				language: {
					required: "* Select atleast One"
				},
				profile: {
					required: "*Please Choose Profile"
				},
				country: {
					required: "* Enter Country Name",
					lettersonly: "* Enter Only Character"
				},
				state: {
					required: "* Enter State Name",
					lettersonly: "* Enter Only Character"
				},
				city: {
					required: "* Enter City Name",
					lettersonly: "* Enter Only Character"
				},
				pincode: {
					required: "* PinCode Is Required",
					digits: "* Enter Only Digits"
				},
				address: {
					required: "* Enter Address"
				}
			},
			submitHandler: function(form, event) {
				event.preventDefault();
				if (isError == true) {
					swal.fire("Somthing Went Wrong please fill the all details", "You clicked the submit!", "warning");
				} else {
					let formdata = new FormData(form);
					$("#form").hide();
					$(".loader").show();

					$.ajax({
						type: "POST",
						url: "Registration",
						data: formdata,
						enctype: 'multipart/form-data',

						success: function(response) {
							$("#form").show();
							$(".loader").hide();
							if (response.trim() === "Successfully Added...") {
								swal.fire("Successfully Added", "You clicked the submit!", "success");
							} else {
								swal.fire("Somthing Went Wrong please fill the all details", "You clicked the submit!", "warning");
							}
						},
						error: function() {
							$("#form").show();
							$(".loader").hide();
							$("#massage").html("Somthing Went Wrong... :( ").css("color", "red");
						},
						processData: false,
						contentType: false
					});
				}
			},
		})
	})
});
