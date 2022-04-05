$(document).ready(function() {

	var table = $('#table_id').DataTable({

		"ajax": {
			"url": "ShowAllUser",
			"type": "GET",
			"datatype": "json"
		},
		"columns": [
			{ "data": "UserId" },
			{ "data": "FiratName" },
			{ "data": "LastName" },
			{ "data": "Dob" },
			{ "data": "MobailNo" },
			{ "data": "Gender" },
			{ "data": "language" },
			{ "data": "Email" },
			{ "defaultContent": "	<a class='btn btn-success' href='index.jsp' id='edit-btn' role='button'>Edit</a>" },
			{ "defaultContent": "	<a class='btn btn-danger' id='delete-btn' role='button'>Delete</a>" }
		]
	});

	$('#table_id').on('click', '#delete-btn', function(event) {
		event.preventDefault();
		var data = table.row($(this).parents('tr')).data();
		var UserId = data.UserId;
		console.log(UserId);

		$.ajax({
			type: "post",
			url: "DeleteUser",
			data: { "UserId": UserId },
			success: function() {
				alert("ok")
				table.ajax.reload();
			},
			error: function(textStatus) {
				alert("not call")
			},
		})

	});

	$('#table_id').on('click', '#edit-btn', function() {
		var data = table.row($(this).parents('tr')).data();
		var Email = data.Email;
		var UserId = data.UserId;
		$.ajax({
			type: "POST",
			url: "GetAllUserDetails",
			data: { Email: Email, UserId: UserId },
			success: function(response) {
				//alert("done");
			},
			error: function() {
				alert("Error")
			}
		});
	})
});

function toggleAlert() {
	$(".alert").toggleClass('in out');
	return false; // Keep close.bs.alert event from removing from DOM
}