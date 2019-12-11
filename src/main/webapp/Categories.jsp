<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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


                console.log(${categories});
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
            
        
           <!----------SELECTEUR---------->
        <p>
            <form action="CategoryController">
                <select name='categories' id='categories' onchange='this.form.submit()' >
                    <c:forEach var="cat" items="${listCategories}">
                        <option value='${cat.code}'
                            <c:if test="${cat.code eq categorie}">
                                selected
                            </c:if>
                        >${cat.libelle}</option>
                    </c:forEach>
                </select>
            </form>
        </p>
        
            <!----------PRODUITS---------->
        <p>    
            <div align=center">
                <label>Nos produits de la catégorie</label>
                <div id="products" ></div>
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
                                    <td>${prod.name}</td>
                                    <td>${prod.fournisseur}</td>
                                    <td>${prod.quantity}</td>
                                    <td>${prod.price}</td>
                                    <td>${prod.stock}</td>
                                    
                                </tr>
                            </c:forEach>
                                <!--<td>${prod.unites_commandees}</td>
                                    <td>${prod.niveau_de_reappro}</td>
                                    <td>${prod.disponibilite}</td>-->
                        </table>
                </div>
        </p>
    </body>