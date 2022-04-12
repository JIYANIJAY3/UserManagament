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
	submitHandler: function(form,event) {
		form.submit();
	},
})