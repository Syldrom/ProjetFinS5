<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="EditionController"/>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Client.css" />
        <title>Edition données personnelles</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
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
            $("#header").load("Header.html");
            });
        </script>
    </head>
    <body>   
            
     
        
        <div class="header" id="header">
        </div>
        <!----------MENU---------->
            
        <div class="topnav" id="ddmenu">
        </div>     
        
        <p>
            <!----------DONNEES---------->
            
            <div class="container ">
                <div  class=" justify-content-center align-items-center m-5 p-auto">
                    <form  class=" form col-auto m-4" action="EditionController" id="edit-form" method="POST" >
                         <div class="form-row ">
                            <div class="form-group col-md-3">
                            <label>Contact</label>
                            <input type="text" class="form-control required" placeholder="Contact"  name="contact" value="${client.getContact()}"/>
                            </div>
                            <div class="form-group col-md-3">
                                <label for="inputPassword4">Mot de Passe</label>
                                <input type="text" class="form-control required" placeholder="Mot de passe"  name="code" value="${client.getCode()}"/>
                            </div>
                         </div>
                        <div class="form-row">
                            <div class="form-group col-md-3">
                            <label >Société</label>
                            <input type="text" class="form-control required" placeholder="Société"  name="societe" value="${client.getSociete()}"/>
                            </div>
                            <div class="form-group col-md-3">
                                <label >Fonction</label>
                                <input type="text" class="form-control " placeholder="Fonction"  name="fonction" value="${client.getFonction()}"/>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label >Adresse</label>
                                <input type="text" class="form-control " placeholder="Adresse"  name="adresse" value="${client.getAdresse()}"/>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-4">
                            <label>Ville</label>
                            <input type="text" class="form-control " placeholder="Ville"  name="ville" value="${client.getVille()}"/>
                            </div>
                            <div class="form-group col-md-auto">
                                <label>Code Postal</label>
                                <input type="text" class="form-control " placeholder="Code Postal"  name="code_postal" value="${client.getRegion()}"/>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label>Pays</label>
                                <input type="text" class="form-control " placeholder="Pays"  name="pays" value="${client.getPays()}"/>
                            </div>
                                <div class="form-group col-md-auto">
                                    <label>Région</label>
                                    <input type="text" class="form-control " placeholder="Région"  name="region" value="${client.getRegion()}"/>
                                </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label>N°téléphone</label>
                                <input type="text" class="form-control " placeholder="N°téléphone"  name="telephone" value="${client.getTelephone()}"/>
                            </div>
                                <div class="form-group col-md-auto">
                                    <label>N°Fax</label>
                                    <input type="text" class="form-control " placeholder="N°Fax"  name="fax" value="${client.getFax()}"/>
                                </div>
                        </div>
                            <input type="submit" value="Enregistrer mes informations" name="submit" class="btn btn-outline-primary mt-3">
                    </form>
                </div>
            </div>
        </p>
    </body>