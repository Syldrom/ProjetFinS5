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
        <title>Edition données personnelles</title>
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
            
        <sql:setDataSource
            var="myDS"
            driver="org.apache.derby.jdbc.ClientDriver"
            url="jdbc:derby://localhost:1527/comptoirs"
            user="app" password="app"
        />
     
        <!-------REQUETE POUR LE SELECTEUR---------->
        
        <sql:query var="selecteur" dataSource="${myDS}">
            SELECT * from CATEGORIE
        </sql:query>
            <div class="header">
                <h1>Bienvenue sur Amatoz</h1>
            </div>
            
        <!----------MENU---------->
            
        <div class="topnav" id="ddmenu">
        </div>     
        
        <p>
            <!-------REQUETE POUR LES INFOS PERSONNELLES---------->
        
            <sql:query var="client"   dataSource="${myDS}">
                SELECT * FROM CLIENT WHERE CLIENT.CODE = '${param.codeClient}'
            </sql:query>
                
            <!----------DONNEES---------->
            
            <div class="contenu">
                <form action="edit">
                    <c:forEach var="record" items="${client.rows}">
                        <label>Société:</label>
                        <input type="text" name="firstname" value="${record.SOCIETE}">
                        </br>
                        <label>Contact:</label>
                        <input type="text" name="lastname" value="${record.CONTACT}">
                        </br>
                        <label>Fonction:</label>
                        <input type="text" name="fonction" value="${record.FONCTION}">
                        </br>
                        <label>Adresse:</label>
                        <input type="text" name="adresse" value="${record.ADRESSE}">
                        </br>
                        <label>Ville:</label>
                        <input type="text" name="ville" value="${record.VILLE}">
                        </br>
                        <label>Région:</label>
                        <input type="text" name="region" value="${record.REGION}">
                        </br>
                        <label>Code Postal:</label>
                        <input type="text" name="code_postal" value="${record.CODE_POSTAL}">
                        </br>
                        <label>Pays:</label>
                        <input type="text" name="pays" value="${record.PAYS}">
                        </br>
                        <label>Téléphone:</label>
                        <input type="text" name="telephone" value="${record.TELEPHONE}">
                        </br>
                        <label>Fax:</label>
                        <input type="text" name="fax" value="${record.FAX}">
                        </br>
                        <br><br>
                    <input type="submit" value="Enregistrer mes informations" action="ediData">
                    </c:forEach>
                </form>
            </div>
        <div>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
        </div>
        </p>
    </body>