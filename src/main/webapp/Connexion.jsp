

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page de Connexion</title>
        <link rel="icon" type="image/png" href="Pictures/favicon.png" />
        <link rel="stylesheet" href="Connexion.css" />
    </head>
    <body>
        <center>
        <div style="color:red">${message}</div></br>
        <form action="ConnectionController" method="POST">
            <fieldset>
                <legend>Connexion</legend>
            <label for="log"> Login :<span class="requis">*</span></label>
            <input type="text" name="login"/></br>
            <label for="mdp"> Password :<span class="requis">*</span></label>
            <input type="password" name="password"/></br>         
            </br><input type="submit" value="connexion"/>
            </fieldset>
        </center>
        </form>
        <h3>Il y a actuellement ${applicationScope.numberConnected} utilisateurs connectés</h3>
    </body>
</html>