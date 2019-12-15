<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="CategoryController" />
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Client.css" />
        <title>Produits par catégories</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/mustache.js/2.1.0/mustache.min.js"></script>
        <script src="https://kit.fontawesome.com/dd6a857052.js" crossorigin="anonymous"></script>
        <script>
            $( document ).ready(function() {
                console.log( "ready!" );
                $("#ddmenu").load("Menu.html");
            });
        </script>
        <script>
            $( document ).ready(function() {
            $("#header").load("Header.html");
            });
        </script>
    </head>
    <body>   
        
        <div class="header" id="header">
        </div>
        <!----------MENU---------->
            
        <div class="topnav" id="ddmenu">
        </div> 
            
        
           <!----------SELECTEUR---------->
        <div class="container-fluid text-center  ">      
            <form action="CategoryController" class="form col-auto mt-4 w-25">
                <div class="d-flex justify-content-center  container">
                    <select class="custom-select" name='categorie' id='categorie' onchange='this.form.submit()' >
                        <c:forEach var="cat" items="${listCategories}">
                            <option value='${cat.code}'
                                <c:if test="${cat.code eq categorie}">
                                    selected <c:set var="categorieDesc" value="${cat.description}"></c:set>
                                </c:if>
                            >${cat.libelle}</option>                                                
                        </c:forEach>
                                
                    </select>   
                </div>
            </form>
            <label class="h3  mb-4 mt-auto">${categorieDesc}</label> 
    
        </div>
        
            <!----------PRODUITS---------->
        <p>    
            <div align=center">
                
                <div id="products" ></div>
                        <table class="table text-center">
                            <thead>
                                <tr>
                                    <th scope="col">Référence</th>
                                    <th scope="col">Nom</th>
                                    <th scope="col">Fournisseur</th>
                                    <!--<th>Categorie</th>-->
                                    <th scope="col">Quantité par unité</th>
                                    <th scope="col">Prix unitaire</th>
                                    <th scope="col">Stock</th>
                                    <!--<th scope="col">Commandées</th>
                                    <th scope="col">Réappro</th>
                                    <th scope="col">Indisponible</th>-->
                                    <th scope="col">Quantité</th>
                                    <th scope="col">Panier</th>
                                </tr>
                            </thead>
                            <c:forEach var="prod" items="${listProducts}">
                                <tr>
                                    <td>${prod.ref}</td>
                                    <td>${prod.name}</td>
                                    <td>${prod.fournisseur}</td>
                                    <td>${prod.quantity}</td>
                                    <td>${prod.price}</td>
                                    <td>${prod.stock}</td>
                                    <td><input type="number" name="qte" min="1" max="${prod.stock}"></td>
                                    <td><button type="button">Ajouter au panier</button></td>
                                </tr>
                            </c:forEach>
                                <!--<td>${prod.unites_commandees}</td>
                                    <td>${prod.niveau_de_reappro}</td>
                                    <td>${prod.disponibilite}</td>-->
                        </table>
                </div>
        </p>
    </body>