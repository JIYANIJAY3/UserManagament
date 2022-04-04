$(document).ready(function() {

    $("#emailAddress").change(function(e) {
        e.preventDefault();

        var email = $("#emailAddress").val();
        console.log(email);

        $.ajax({
            type: "POST",
            url: "CheckEmailIsPresent",
            data: { email: email },

            success: function(data) {
                if (data.trim() === "done") {
                    $("#isEmailPresent").html("Email Already Present").css("color", "red");
                } else {
                    alert("ok");
                    $("#isEmailPresent").html(" ");
                }
            },
            error: function(textStatus) {
                alert("not call")
            }
        });
    });


    $("#profile-link").click(function(e) {

        var id = $("#userid").val();
        console.log(id);

        $.ajax({
            type: "POST",
            url: ""
        });

    })
   
})