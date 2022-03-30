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
            { "defaultContent": "<button>Delete</button>" }
        ]
    });

    $('#table_id').on('click', 'button', function(event) {
        event.preventDefault();
        var data = table.row($(this).parents('tr')).data();
        var UserId = data.UserId;
        console.log(UserId);
        $.ajax({
            URL: "DeleteUser",
            type: "post",
            data: { "UserId": UserId },
            success: function(data) {
                alert(data.UserId)
            },
            error: function(textStatus) {
                alert("not call")
            },
        })
    });
});