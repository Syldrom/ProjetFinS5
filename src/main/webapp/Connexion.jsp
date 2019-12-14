

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page de Connexion</title>
        <link rel="icon" type="image/png" href="Pictures/favicon.png" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/mustache.js/2.1.0/mustache.min.js"></script>
        <script src="https://kit.fontawesome.com/dd6a857052.js" crossorigin="anonymous"></script>
    </head>
    <body class="container-fluid mt-5">
        <h1 class="h3 text-center">Connexion for Amatoz</h1>
        <div class="d-flex justify-content-center align-items-center container text-center mr-ml-4">
        <form action ="ConnectionController" method="POST" class="form-signin col-auto m-4 w-25">
            
            <div class="form-group">
                <input type="text" class="form-control" name="login" placeholder="Login" required autofocus>
                <small id="loginHelp" class="form-text text-muted text-left">Rentrez votre nom complet (contact) </small>
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="password" placeholder="Password" required autofocus>
                <small id="loginHelp" class="form-text text-muted text-left">Saisir votre code associé</small>
            </div>
            <button type="submit" class="btn btn-primary">Connexion</button>
            
        </form>
               
        </div>
        <div class="container-fluid  align-items-center text-center ">
            <p class="font-weight-bold text-danger m-4">${message}</p>
        </div> 
        
    </body>

        <!--<h3>Il y a actuellement ${applicationScope.numberConnected} utilisateurs connectés</h3> -->
    </body>
</html>