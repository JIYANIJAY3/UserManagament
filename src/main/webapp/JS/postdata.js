$(document).ready(function() {
    $("#form").on('submit', function(event) {
        event.preventDefault();

        //var formdata = $(this).serialize();

        let formdata = new FormData(this);

        $("#form").hide();
        $(".loader").hide();

        $.ajax({
            type: "POST",
            url: "Registration",
            data: formdata,
            enctype: 'multipart/form-data',

            success: function(response) {
                $("#form").show();
            	console.log(response.trim());

                if (response.trim() === "Successfully Added...") {
                    $("#massage").html("Successfully Added...").css("color", "green");
                } else {
                    $("#massage").html("Somthing Went Wrong... :( ").css("color", "red");
                }
            },
            error: function(textStatus) {
                $("#form").show();
                $("#massage").html("Somthing Went Wrong... :( ").css("color", "red");
            },
            processData: false,
            contentType: false
        });
    })

})