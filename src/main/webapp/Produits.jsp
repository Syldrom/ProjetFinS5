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
                $("#ddmenu2").load("Unconnected-Menu.html");
                $("#header").load("Header.html");
            });
        </script>
    </head>
    <body>
        
        <div class="header" id="header">
        </div>
        <c:if test="${not empty login}">
            <div class="topnav" id="ddmenu">
            </div>
        </c:if>
        <c:if test="${empty login}">
            <div class="topnav" id="ddmenu2">
            </div>
        </c:if>
        
        
                <div id="products"></div>
                    <table class="table text-center">
                        <thead>
                            <tr>
                                <th scope="col">Référence</th>
                                <th scope="col">Nom</th>
                                <th scope="col">Fournisseur</th>
                                <!--<th>Categorie</th>-->
                                <th scope="col">Quantité par unité</th>
                                <th scope="col">Prix unitaire</th>
                                <c:if test="${login eq 'Admin'}">
                                <th scope="col">Commandées</th>
                                <th scope="col">Stock</th>
                                <th scope="col">Réappro</th>
                                </c:if>
                                <c:if test="${not empty login}">
                                    <c:if test="${login ne 'Admin'}">
                                        <th scope="col">Quantité</th>
                                        <th scope="col">Panier</th>
                                    </c:if>
                                </c:if>
                                <c:if test="${login eq 'Admin'}">
                                    <th scope="col">Supprimer</th>
                                </c:if>
                            </tr>
                        </thead>
                        <c:forEach var="prod" items="${listProducts}">
                            
                            <c:remove var="disabledTable"></c:remove>
                            <c:remove var="disabledItem"></c:remove>
                            <c:set var="addItem" value="Ajouter au Panier"></c:set>
                            <c:if test="${prod.stock eq 0}">
                                <c:set var="disabledTable" value="table-secondary"></c:set>
                                <c:set var="addItem" value="Épuisé"></c:set>
                                <c:set var="disabledItem" value="disabled"></c:set> 
                            </c:if> 
                                <tr class="${disabledTable}">
                                    <td>${prod.ref}</td>
                                    <td>${prod.name}</td>
                                    <td>${prod.fournisseur}</td>
                                    <td>${prod.quantity}</td>
                                    <td>${prod.price}</td>
                                    <c:if test="${login eq 'Admin'}">
                                    <td>${prod.getUC()}</td>
                                    <td>${prod.getStock()}</td>
                                    <td>${prod.getReappro()}</td>
                                    </c:if>
                                    <c:if test="${not empty login}">
                                        <c:if test="${login ne 'Admin'}">
                                            <td><input type="number" name="qte" min="0" max="${prod.stock}" ${disabledItem}></td>
                                            <td><button type="button" ${disabledItem}>${addItem}</button></td>
                                        </c:if>
                                        <c:if test="${login eq 'Admin'}">
                                            <td><form  action="ProductController" id="supress" method="POST" >
                                                <button type="submit" name="supprimer" value="${ref}" >Supprimer définitivement</button>
                                            </form></td>
                                        </c:if>
                                    </c:if>
                                </tr>
                            </c:forEach>


                        </table>
                

    </body>