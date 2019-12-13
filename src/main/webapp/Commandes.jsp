<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="OrderController" />
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
        <title>${userName}</title>
        <script src="https://kit.fontawesome.com/dd6a857052.js" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
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
        </div> 
        <div>
                <label>Login : <c:out value="${login}"/></label>
                </br>
                <label>Password : <c:out value="${password}"/></label>
        </div>
          
                
        
                </br>
        <div align=center">
            <!--list<c:out value="${listOrders}"/>-->
            <table border="1">
                <tr>
                    <th>Numéro de Commande</th>

                    <th>Client</th>
                    <th>Date de saisie</th>
                    <th>Date d'envoi</th>
                    <th>Port</th>
                    <th>Destinataire</th>
                    <th>Adresse de livraison</th>
                    <th>Ville de livraison</th>
                    <th>Région de livraison</th>
                    <th>Code Postal</th>
                    <th>Pays</th>
                    <th>Remise</th>

                    <c:forEach var="order" items="${listOrders}">
                    <tr>
                        <td>${order.numero}</td>
                        <td>${order.client}</td>
                        <td>${order.saisie}</td>
                        <td>${order.envoi}</td>
                        <td>${order.port}</td>
                        <td>${order.destinataire}</td>
                        <td>${order.adresse_livraison}</td>
                        <td>${order.ville_livraison}</td>
                        <td>${order.region_livraison}</td>
                        <td>${order.code_postal}</td>
                        <td>${order.pays}</td>
                        <td>${order.remise}</td>
                        
                    </tr>
                    </c:forEach>
                </tr>
            </table>
        </div>
        
	</form>
    </body>