/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function showProducts() {
    $.ajax({
        url: "ProductController",
        dataType:"json",
        success: 
                function(result) {
                    var template = $('#ProductTemplate').html();
                    var processedTemplate = Mustache.to_html(template,{records: result.records});
                    $('#products').html(processedTemplate);
                    
                },
        error: showError
    });
}
function showError(xhr,status, message) {
    alert("Alerte aux gogoles x:" + status + ": " + message);
    
}
showProducts();
