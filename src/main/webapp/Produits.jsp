<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="ProductController" />
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Client.css" />
        <title>Produits</title>
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
    </head>
    <body>
        
        <div class="header">
            <h1>Bienvenue sur Amatoz</h1>
        </div>
        <div class="topnav" id="ddmenu">
            <a class="active" href="Produits.jsp">Produits</a>
            </div>
        </div> 
        
                <div id="products"></div>
                    <table border="1">
                            <tr>
                                <th>Référence</th>
                                <th>Nom</th>
                                <th>Fournisseur</th>
                                <!--<th>Categorie</th>-->
                                <th>Quantité par unité</th>
                                <th>Prix unitaire</th>
                                <th>Stock</th>
                                <!--<th>Commandées</th>
                                <th>Réappro</th>
                                <th>Indisponible</th>-->
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
                                    <td><input type="number" name="qte" min="1" max="${prod.stock}"></td>
                                    <td><button type="button">Ajouter au panier</button></td>
                                </tr>
                            </c:forEach>
                                <!--<td>${prod.unites_commandees}</td>
                                    <td>${prod.niveau_de_reappro}</td>
                                    <td>${prod.disponibilite}</td>-->
                        </table>
                <!--<script id ="ProductTemplate" type="text/template">
                <table class="table table-hover">
                    {{#records}}
                       <TR><TD> {{nom}}</TD>
                       <TD> {{quantite}}</TD>
                       <TD> {{prix_uni}}</TD>
                       <TD> {{disponibilite}} </TD>
                       <td>
                       <div class="btn-group" role="group">
                        <button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Dropdown
                        </button>
                        <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                        <a class="dropdown-item" >Dropdown link</a>
                        <a class="dropdown-item" >Dropdown link</a>
                        </div>
                        </div></td>
                       </TR>
                    {{/records}}
                    </table>
                </script>-->
                <!--<script type="text/javascript" src="produits.js"></script>-->
                

    </body>