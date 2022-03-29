$(document).ready(function() {

	$("#emailAddress").change(function(e) {
		e.preventDefault();

		var email = $("#emailAddress").val();

		console.log(email);
		$.ajax({
			type: "POST",
			URL: "CheckEmailIsPresent",
			data: { email: email },
			success: function(response) {
				alert("ok")
			},
			error: function(response) {
				alert("not call")
			}
		});
	});
})