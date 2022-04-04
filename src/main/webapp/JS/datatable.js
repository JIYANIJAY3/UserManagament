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
	
	$('#table_id').on('click', '#edit-btn', function(event) {
	//	event.preventDefault();
		
        $.ajax({
            url: "GetAllUserAddress",
            type: "get",
            dataType: "json",
            success: function(data) {
                console.log(data)
                location.href = "index.jsp"
              /*  var dataLength = Object.keys(data).length
                alert("This Is Done")
                for (var i = 0; i < dataLength - 1; i++) {
                    $("#add-more").trigger('click');
                }
                for (var i = 0; i <= dataLength; i++) {
                    $("#country_" + i).val(data[i].country);
                    $("#state_" + i).val(data[i].state);
                    $("#city_" + i).val(data[i].city);
                    $("#pincode_" + i).val(data[i].pinCode);
                    $("#address_" + i).val(data[i].address);
                }*/

            },
            error: function() {
                alert("This Is Error")
            }
        })
    })
});