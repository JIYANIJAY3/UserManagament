$(document).ready(function() {
    $("#submit-btn").click(function(event) {
            $("form").submit(function(event) {
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
                       
                        if (response.trim() === "Successfully Added...") {
                             swal("Successfully Added","You clicked the submit!", "success");
                        } else {
                            swal("Somthing Went Wrong","You clicked the submit!", "warning");
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
        // $("#form").on('submit', function(event) {

    // })

})