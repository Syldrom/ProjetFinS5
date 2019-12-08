<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<sql:setDataSource 
	driver="org.apache.derby.jdbc.ClientDriver"
	url="jdbc:derby://localhost:1527/comptoirs"
	user="app" password="app"
/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Client.css" />
        <title>Panier</title>
        <script src="https://kit.fontawesome.com/dd6a857052.js" crossorigin="anonymous"></script>
    </head>
    <body>   
            
        <sql:setDataSource
            var="myDS"
            driver="org.apache.derby.jdbc.ClientDriver"
            url="jdbc:derby://localhost:1527/comptoirs"
            user="APP" password="app"
        />
     
        <!-------REQUETE POUR LE SELECTEUR---------->
        
        <sql:query var="selecteur" dataSource="${myDS}">
            SELECT * from CATEGORIE
        </sql:query>
        <div class="header">
            <h1>Bienvenue sur Amatoz</h1>
        </div>
        <!----------MENU---------->
        <div class="topnav">
            <a href="#produits">Produits</a>
            <a href="#categories">Categories</a>
            <div class="topnav-right">
                <a href="#compte">Mon Compte</a>
                <a href="#commandes">Mes Commandes</a>
                <a href="#panier"><i class="fas fa-shopping-cart"></i></a>
                <a href="#deco" type='submit' name='action' value='Deconnexion'><!--Deconnexion--><i class="fas fa-sign-out-alt"></i></a>
            </div>
        </div> 
        
        <p>
            <!-------REQUETE POUR LE PANIER DU CLIENT---------->
        
            <sql:query var="cart"   dataSource="${myDS}">
                
            </sql:query>
                
            <!----------SHOPPING CART DATA---------->
            
            <div align=center">
                
            </div>
        </p>
    </body>