<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="EditionController" />
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
        <meta charset="utf-8">
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
     
        
            <div class="header">
                <h1>Bienvenue sur Amatoz</h1>
            </div>
            
        <!----------MENU---------->
            
        <div class="topnav" id="ddmenu">
        </div>     
        
        <p>
            <!----------DONNEES---------->
            
            <div class="contenu">
                <form action="EditionController" id="edit-form" method="POST" >
                        
                        
                        <label>Code :</label>
                        <input type="text" name="code" value="${client.getCode()}"/>
                        </br>
                        <label>Société:</label>
                        <input type="text" name="societe" value="${client.getSociete()}"/>
                        </br>
                        <label>Contact:</label>
                        <input type="text" name="contact" value="${client.getContact()}"/>
                        </br>
                        <label>Fonction:</label>
                        <input type="text" name="fonction" value="${client.getFonction()}"/>
                        </br>
                        <label>Adresse:</label>
                        <input type="text" name="adresse" value="${client.getAdresse()}"/>
                        </br>
                        <label>Ville:</label>
                        <input type="text" name="ville" value="${client.getVille()}"/>
                        </br>
                        <label>Région:</label>
                        <input type="text" name="region" value="${client.getRegion()}"/>
                        </br>
                        <label>Code Postal:</label>
                        <input type="text" name="code_postal" value="${client.getCode_postal()}"/>
                        </br>
                        <label>Pays:</label>
                        <input type="text" name="pays" value="${client.getPays()}"/>
                        </br>
                        <label>Téléphone:</label>
                        <input type="text" name="telephone" value="${client.getTelephone()}"/>
                        </br>
                        <label>Fax:</label>
                        <input type="text" name="fax" value="${client.getFax()}"/>
                        </br>
                        <br><br>
                        <input type="submit" value="Enregistrer mes informations" name="submit">
                </form>
            </div>
        </p>
    </body>