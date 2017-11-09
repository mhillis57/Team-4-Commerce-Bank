$( document ).ready(function() {

    // GET REQUEST
    $("#customerForm").submit(function(event){
        event.preventDefault();
        ajaxGet();
    });

    // DO GET
    function ajaxGet(){
        $.ajax({
            type : "GET",
            url : window.location + "api/customer/all",
            success: function(result){
                if(result.status == "Done"){
                    $('#getResultDiv ul').empty();
                  //  var text = "";
                    $.each(result.data, function(customer){
                        var customer = customer.usedText;
                        $('#getResultDiv .list-group').append(customer)
                    });
                    console.log("Success: ", result);
                }else{
                    $("#getResultDiv").html("<strong>Error</strong>");
                    console.log("Fail: ", result);
                }
            },
            error : function(e) {
                $("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        });
    }
})