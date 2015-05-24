/**
 * Created by wfleming on 5/22/15.
 */


function onAddSubmitHandler(e) {
    var dataName = this.dataname.value;

    var urlForm = page_ajaxmapping + "/add?name=" + dataName;

    if(dataName != '') {
        $.ajax({
            type: "PUT",
            url: urlForm,
            context: this
        }).done(function(msg) {
            var dataName = this.dataname.value;
            this.dataname.value = "";

            var htmlItems = [];
            var htmlResults = [];

            if(msg.status == 'added') {
                htmlItems.push("<ul>");
                htmlItems.push("<li>");
                htmlItems.push(msg.data.name);
                htmlItems.push(" was added successfully</li>");
                htmlItems.push("<ul>");

                htmlResults.push("<tr><td>");
                htmlResults.push(msg.data.name);
                htmlResults.push("</td><td><form class='deleteForm'>");
                htmlResults.push("<input type='hidden' name='dataid' value='");
                htmlResults.push(msg.data.id);
                htmlResults.push("'/><input type='hidden' name='dataname' value='");
                htmlResults.push(msg.data.name);
                htmlResults.push("'/><input type='submit' value='Delete'/></form>");
                htmlResults.push("</td></tr>");

                $('#ajaxMessage').html(htmlItems.join(''));
                $("#results").append(htmlResults.join(''));
            }
            else {
                $("#ajaxError").html("Error occured.  " + dataName +  " was not added.");
            }
        }).fail(function( jqXHR, textStatus ) {
            alert( "Request failed: Error code = " + jqXHR.status);
        });
    }

    e.preventDefault();
};




function onDeleteSubmitHandler(e) {
    var dataid = this.dataid.value;
    var dataName = this.dataname.value;

    var urlForm = page_ajaxmapping + "/delete/" + dataid;

    $.ajax({
        type: "DELETE",
        url: urlForm,
        context: this
    }).done(function(msg) {
        var dataName = this.dataname.value;

        if(msg.status == 'deleted') {
            $("#ajaxMessage").html(dataName + " was successfully deleted.");
            var currentTR = $(this).closest("tr");
            currentTR.remove();
        }
        else {
            $("#ajaxError").html("Error occured.  " + dataName +  " was not deleted.");
        }
    }).fail(function( jqXHR, textStatus ) {
        alert( "Request failed: Error code = " + jqXHR.status);
    });

    e.preventDefault();
};



$(document).ready(function() {
    $('#dynamicForms').on('submit', 'form.addForm', onAddSubmitHandler);
    $('#dynamicForms').on('submit', 'form.deleteForm', onDeleteSubmitHandler);

});
