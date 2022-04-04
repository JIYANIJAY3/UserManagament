$(document).ready(function() {

    var UserId = $("#UserId").val();
    $.ajax({
        url: "GetAllUserAddress",
        type: "get",
        dataType: "json",
        data: { UserId: UserId },
        success: function(data) {
            console.log(data)
            var dataLength = Object.keys(data).length
            alert("This Is Done")
            for (var i = 0; i < dataLength - 1; i++) {
                $("#add-more").trigger('click');
            }
            for (var i = 0; i <= dataLength; i++) {
                $("#country_" + i).val(data[i].country);
                $("#state_" + i).val(data[i].state);
                $("#city_" + i).
                val(data[i].city);
                $("#pincode_" + i).val(data[i].pinCode);
                $("#address_" + i).val(data[i].address);
            }

        },
        error: function() {
            alert("This Is Error")
        }

    })

    $("#submit-btn").attr('id', 'edit-btn-id').val("Edit")
    $("input[type='email']").prop({
        disabled: true
    })
    $("#mobail").prop({
        disabled: true
    })
    $("#edit-btn-id").click(function() {
        alert("this is edit buttton click")
        $("form").submit(function(event) {
            event.preventDefault();
            alert("edit profile");

            let formdata = new FormData(this);
            console.log(formdata)
            var UserId = $("#UserId").val();
            console.log(UserId);
            $.ajax({
                type: "post",
                url: "UpdateUserProfile",
                data: formdata,
                enctype: 'multipart/form-data',

                success: function(data) {
                    if (data === "Update") {
                        alert("done")
                    } else {
                        alert("somthing went wrong")
                    }
                },
                error: function(textStatus) {
                    alert("Not Call")
                },
                processData: false,
                contentType: false
            });
        })
    })

    // $("#edit-btn-id #form").click(function(event) {

    // })
})