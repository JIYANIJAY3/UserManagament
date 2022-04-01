$(document).ready(function() {

    $("#edit-btn").click(function() {
        $.ajax({
            url: "GetAllUserAddress",
            type: "get",
            dataType: "json",
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
                    $("#city_" + i).val(data[i].city);
                    $("#pincode_" + i).val(data[i].pinCode);
                    $("#address_" + i).val(data[i].address);
                }

            },
            error: function() {
                alert("This Is Error")
            }

        })
    })

})