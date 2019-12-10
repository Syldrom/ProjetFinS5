/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function showCategories() {
    $.ajax({
        url: "CategoryController",
        dataType:"json",
        success: 
                function(result) {
                    var template = $('#CategoryTemplate').html();
                    var processedTemplate = Mustache.to_html(template,{records: result.records});
                    $('#categories').html(processedTemplate);
                    
                },
        error: showError
    });
}
function showError(xhr,status, message) {
    alert("Alerte aux gogoles :" + status + ": " + message);
    
}

