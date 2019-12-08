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
        
        <!----------MENU---------->
            
        <div id="menu">
            </br><form action="<c:url value="/" />" method="POST" id="deco">
            <input type='submit' name='action' value='Deconnexion'>
            </form>  
        </div>        
        
        <p>
            <!-------REQUETE POUR LES INFOS PERSONNELLES---------->
        
            <sql:query var="produit"   dataSource="${myDS}">
                SELECT * FROM CLIENT WHERE CODE=${param.code}
            </sql:query>
                
            <!----------DONNEES---------->
            
            <div align=center">
                
            </div>
        </p>
    </body>