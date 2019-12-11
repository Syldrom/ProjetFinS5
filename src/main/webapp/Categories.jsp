<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<sql:setDataSource 
        var="myDS"
	driver="org.apache.derby.jdbc.ClientDriver"
	url="jdbc:derby://localhost:1527/comptoirs"
	user="app" password="app"
/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Client.css" />
        <title>Produits par catégories</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/mustache.js/2.1.0/mustache.min.js"></script>
        <script src="https://kit.fontawesome.com/dd6a857052.js" crossorigin="anonymous"></script>
        <script type="text/javascript" src="categories.js"></script>
        <script type="text/javascript" src="produits.js"></script>
    </head>
    <body>   
        <script>
            $( document ).ready(function() {
                console.log( "ready!" );
                
                function getUrlVars() {
                    var vars = {};
                    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
                        vars[key] = value;
                    });
                    return vars;
                }
                function getUrlParam(parameter, defaultvalue){
                    var urlparameter = defaultvalue;
                    if(window.location.href.indexOf(parameter) > -1){
                        urlparameter = getUrlVars()[parameter];
                        }
                    return urlparameter;
                }

                var c = getUrlParam('categories',1);


                
                //showCategories(${categories});
               // showProductsByCategories(c);
            });
        </script>
        <div class="header">
            <h1>Bienvenue sur Amatoz</h1>
        </div>
        <!----------MENU---------->
            
        <div class="topnav">
            <a href="#produits">Produits</a>
            <a class="active" href="#categories">Categories</a>
            <div class="topnav-right">
                <a href="#compte">Mon Compte</a>
                <a href="#commandes">Mes Commandes</a>
                <a href="#panier"><i class="fas fa-shopping-cart"></i></a>
                <a href="#deco" type='submit' name='action' value='Deconnexion'><!--Deconnexion--><i class="fas fa-sign-out-alt"></i></a>
            </div>
        </div> 
            
        <p>
           <!----------SELECTEUR---------->
        <form>
            <select name="categories" id="categories" onchange='this.form.submit()' >
                <c:forEach var="cat" items="${listCategories}">
                    <option value='${cat.code}'
                        <c:if test="${cat.code eq categorie}">
                            selected
                        </c:if>
                    >${cat.libelle}</option>
                </c:forEach>
                <!--<script type="x-tmpl-mustache" id ="CategoryTemplate" >
                    {{#records}}
                        {{#cat}}
                            <option value = {{code}} selected > {{libelle}} </option>
                        {{/cat}}
                        {{^cat}}
                            <option value = {{code}} > {{libelle}} X</option>
                        {{/cat}}
                    {{/records}}
                </script>-->
            </select>    
        </form>
        </p>
        
        <script>
            
            /*document.addEventListener('DOMContentLoaded',function() {
                    document.querySelector('select[name="categories"]').onchange=changeEventHandler;
            },false);
            
            function changeEventHandler(event) {
                // Vous pouvez utiliser “this” pour vous référer à l'élément sélectionné.
                console.log('You like ' + event.target.value + ' ice cream.'); 
                location.reload(true);
                window.location.replace("Categories.jsp?categories="+event.target.value);
                
            }**/
            
        </script>
        
        <p>
                
            <!----------PRODUITS---------->
            
            <div align=center">
                <label>Nos produits de la catégorie</label>
                <div id="products" ></div>
                
                   <!-- <script id ="ProductTemplate" type="text/template">-->
                        <table border="1">
                        <tr>
                            <th>Référence</th>
                            <th>Nom</th>
                            <th>Fournisseur</th>
                            <!--<th>Categorie</th>-->
                            <th>Quantité par unité</th>
                            <th>Prix unitaire</th>
                            <th>Stock</th>
                            <th>Commandées</th>
                            <th>Réappro</th>
                            <th>Indisponible</th>
                            <th>Quantité</th>
                            <th>Panier</th>
                        </tr>   
                        <c:forEach var="prod" items="${listProducts}">
                           <tr>
                           <td>${prod.ref}</td>
                           <td>${prod.nom}</td>
                           <td>${prod.fournisseur}</td>
                           <td>${prod.quantite}</td>
                           <td>${prod.prix_uni}</td>
                           <td>${prod.unites_en_stock}</td>
                           <td>${prod.unites_commandees}</td>
                           <td>${prod.niveau_de_reappro}</td>
                           <td>${prod.disponibilite}</td>
                           <td><input type="number" name="quantity" min="1" max="{{unites_en_stock}}"></td>
                           <!--{% if {{disponibilite}} == 0 %}-->
                                   
                                           <!-- <td><button type="button value="{{ref}}">Ajouter au Panier</button></td>-->
                           <!--{% else %}-->
                           <!--<td><button type="button value="{{ref}}">Indisponible</button></td>-->
                           <!--{% endif %}-->
                           </tr>
                        </c:forEach>
                        </table>
                </script>
                

                        <!--<script>
                        
                            
                            var sel = document.getElementById('categories');
                            console.log(sel);
                            function getSelectedOption(sel) {
                                var opt;
                                for ( var i = 0, len = sel.options.length; i < len; i++ ) {
                                    opt = sel.options[i];
                                    if ( opt.selected === true ) {
                                        break;
                                    }
                                }
                                    return opt;
                            }
                                
                            var x = getSelectedOption(sel);
                            console.log(x);
                            console.log(document.getElementById("item"));
                            
                            var dbConnection = SQL.connect( { Driver: "org.apache.derby.jdbc.ClientDriver",
                                Host: "jdbc:derby://localhost",
                                Port: 1527,
                                Database: "comptoirs",
                                UserName: "APP",
                                Password: "app" } 
                            );
                            
                            if ($record.CATEGORIE==x){
                                console.log(document.getElementById("item"));
                                document.getElementByID("item").append(
                                hello);
                                }
                        
                        </script>-->
                        
                    
                
            </div>
        </p>
    </body>