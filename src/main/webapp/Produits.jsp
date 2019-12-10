<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        
    </head>
    <body>
        
        <div class="header">
            <h1>Bienvenue sur Amatoz</h1>
        </div>
        <div class="topnav">
            <a class="active" href="#produits">Produits</a>
            <a href="#categories">Categories</a>
            <div class="topnav-right">
                <a href="#compte">Mon Compte</a>
                <a href="#commandes">Mes Commandes</a>
                <a href="#panier"><i class="fas fa-shopping-cart"></i></a>
                <a href="#deco" type='submit' name='action' value='Deconnexion'><!--Deconnexion--><i class="fas fa-sign-out-alt"></i></a>
            </div>
        </div> 
        
                <div id="products"></div>
                <script id ="ProductTemplate" type="text/template">
                <table class="table" border="1">
                    {{#records}}
                       <TR><TD> {{nom}}</TD>
                       <TD> {{categorie}} </TD>
                       <TD> {{quantite}}</TD>
                       <TD> {{prix_uni}}</TD>
                       <TD> {{disponibilite}} </TD>
                       </TR>
                    {{/records}}
                    </table>
                </script>
                <script type="text/javascript" src="produits.js"></script>
                

    </body>