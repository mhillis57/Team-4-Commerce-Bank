$( document ).ready(function() {

    // SUBMIT FORM
    $("#customerForm").submit(function(event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPost();
    });


    function ajaxPost(){

        var textToUse = $("#textToUse").val();

        // DO POST
        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "/api/customerall/",//*********something is wrong here************
            data : JSON.stringify(textToUse),
            dataType : "json",
            success : function(response) {

                $("getResultDiv").val(response);
            },
            error : function(e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });

        // Reset FormData after Posting
        resetData();

    }

    function resetData(){
        $("#textToUse").val("");
    }
})