$(document).ready(function() {


	var UserId = $("#UserId").val();
	$.ajax({
		url: "GetAllUserAddress",
		type: "get",
		dataType: "json",
		data: { UserId: UserId },
		success: function(data) {
			var dataLength = Object.keys(data).length
			for (var i = 0; i < dataLength - 1; i++) {
				$("#add-more").trigger('click');
			}
			for (var i = 0; i <= dataLength; i++) {
				$("#addressId_" + i).val(data[i].addressId);
				$("#country_" + i).val(data[i].country);
				$("#state_" + i).val(data[i].state);
				$("#city_" + i).
					val(data[i].city);
				$("#pincode_" + i).val(data[i].pinCode);
				$("#address_" + i).val(data[i].address);
			}

		},
		error: function() {
			alert("This Is Error from editprofile")
		}
	})



	$('#form').on('click', '.delete-profile', function() {
		Swal.fire({
			title: 'Are you sure?',
			text: "You won't be able to revert this!",
			icon: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: 'Yes, delete it!'
		}).then((result) => {
			if (result.isConfirmed) {
				var UserId = $("#UserId").val();
				var ProfileId = +this.id;
				console.log(ProfileId)
				$.ajax({
					url: "DeleteUserProfile",
					type: "POST",
					data: {
						ProfileId: ProfileId,
						UserId: UserId,
					},
					success: function() {
						$("#" + ProfileId).remove();
						Swal.fire(
							'Deleted!',
							'Your Profile has been deleted.',
							'success'
						)
					}
				});

			}
		})
	});

	$("#submit-btn").attr('id', 'edit-btn-id').val("Edit")
	$("#form-heading").html("Update Profile")



	$("input[type='email']").prop({
		readonly: true
	})
	$("#mobail").prop("readonly", true);

	var count = 0;
	var isError = false;

	$("#edit-btn-id").click(function() {
		count++;
		console.log("count " + count);

		var regexpincode = /(^[0-9]*$)/;
		var regescountry = /^[a-zA-Z\s]+$/;
		var regexstate = /^[a-zA-Z\s]+$/;
		var regexcity = /^[a-zA-Z\s]+$/;
		var regexaddress = /^[a-zA-Z\s]+$/;

		for (let i = 1; i <= count; i++) {


			$("#country_" + i).keyup(function() {
				var country = $(this).val();
				console.log(country)
				if (!country.match(regescountry)) {
					console.log("here");
					isError = true;
					console.log("Error " + isError)
				}
				else {
					isError = false;
					console.log(isError)
				}
			})

			$("#state_" + i).keyup(function() {
				var state = $(this).val();
				console.log(state)
				if (!state.match(regexstate)) {
					console.log("here");
					isError = true;
					console.log("Error " + isError)
				}
				else {
					isError = false;
					console.log(isError)
				}
			})

			$("#city_" + i).keyup(function() {
				var city = $(this).val();
				console.log(city)
				if (!city.match(regexcity)) {
					console.log("here");
					isError = true;
					console.log("Error " + isError)
				}
				else {
					isError = false;
					console.log(isError)
				}
			})

			$("#pincode_" + i).keyup(function() {
				var pincode = $(this).val();
				console.log(pincode)
				if (!pincode.match(regexpincode)) {
					console.log("here");
					isError = true;
					console.log("Error " + isError)
				}
				else {
					isError = false;
					console.log(isError)
				}
			})

			$("#address_" + i).keyup(function() {
				var address = $(this).val();
				console.log(address)
				if (!address.match(regexaddress)) {
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
		$("#form").validate({
			rules: {
				fname: {
					required: true,
					minlength: 2,
					lettersonly: true
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
				'country[0]': {
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
					digits: true
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
				date: "Date Is Requierd",
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
				let formdata = new FormData(form);
				$.ajax({
					type: "post",
					url: "UpdateUserProfile",
					data: formdata,
					enctype: 'multipart/form-data',

					success: function(data) {
						if (data === "Update") {
							swal.fire("Successfully updated", "You clicked the Edit!", "success");
						} else {
							swal.fire("Somthing Went Wrong", "You clicked the Edit! Please Fill The Details", "warning");
						}
					},
					error: function() {
						swal.fire("Somthing Went Wrong", " ", "warning");
					},
					processData: false,
					contentType: false
				});
			},
		})
	})
})