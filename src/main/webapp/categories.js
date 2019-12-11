/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function showCategories(catSelectionnee) {
    $.ajax({
        url: "CategoryController",
        data:{cat:catSelectionnee},
        dataType:"json",
        success: 
                function(result) {
                    var cat = catSelectionnee;
                    var template = $('#CategoryTemplate').html();
                    var processedTemplate = Mustache.to_html(template,{records: result.records, cat:cat});
                    $('#categories').html(processedTemplate);
                    console.log(cat);
                    
                },
        error: showError
    });
}
function showProductsByCategories(cat) {
    $.ajax({
        url: "ProductByCategoryController",
        data: {categories: cat},
        dataType:"json",
        success: 
                function(result) {
                    var template = $('#ProductTemplate').html();
                    var processedTemplate = Mustache.to_html(template,{produits: result.records});
                    $('#products').html(processedTemplate);
                    
                },
        error: showError
    });
}
function showError(xhr,status, message) {
    alert("Alerte aux gogoles lol:" + status + ": " + message);
    
}

