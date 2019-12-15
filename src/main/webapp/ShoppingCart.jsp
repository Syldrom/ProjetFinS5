<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="ShoppingCartController" />
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Client.css" />
        <title>Panier</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://kit.fontawesome.com/dd6a857052.js" crossorigin="anonymous"></script>
        <script>
            $( document ).ready(function() {
                console.log( "ready!" );
                $("#ddmenu").load("Menu.html");
            });
        </script>
        <script>
            $( document ).ready(function() {
            console.log( "ready!" );
            $("#header").load("Header.html");
            });
        </script>
    </head>
    <body>   

     
        <!-------REQUETE POUR LE SELECTEUR---------->
        

        <div class="header">
            <h1>Bienvenue sur Amatoz</h1>
        </div>
        <!----------MENU---------->
        <div class="topnav" id="ddmenu">
        </div> 
        
        <p>
            <!-------REQUETE POUR LE PANIER DU CLIENT---------->
        

                
            <!----------SHOPPING CART DATA---------->
            
            <div align=center">
                
            </div>
        </p>
    </body>
