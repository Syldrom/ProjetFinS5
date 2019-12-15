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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <script src="https://kit.fontawesome.com/dd6a857052.js" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://kit.fontawesome.com/dd6a857052.js" crossorigin="anonymous"></script>
        <script>
            $( document ).ready(function() {
                console.log( "ready!" );
                $("#ddmenu").load("Menu.html");
                $("#header").load("Header.html");
            });
        </script>
    </head>
    <body>

     
        
        <div class="header" id="header">
        </div>
        <div class="topnav" id="ddmenu">
        </div>
        <c:set var="message" value="Vous avez éffectué un total de " >       
        </c:set>
        <c:set var="emptyMessage" value="Vous n'avez éffectué aucune commande pour le momment" >       
        </c:set>      
        <div class ="container-fluid align-items-center mt-4 p-3"> 
            <label class="h4">
                <c:choose>
                    <c:when test="${nbOrders eq 0 }">
                        ${emptyMessage}
                    </c:when>
                    <c:otherwise>
                        ${message} ${nbOrders} commande(s)
                    </c:otherwise>
                </c:choose >
                </label>
        </div>
        <div align=center">
            <!--list<c:out value="${listOrders}"/>-->
            <table class="table ">
                <tr class="text-center">
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
                    <tr class="text">
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