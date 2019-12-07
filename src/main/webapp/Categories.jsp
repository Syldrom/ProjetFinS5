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
        <title>Produits par catégories</title>
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
            <!--<label for="qnt"> Quantite :</label>
            <input name="quantite" /></br>
            <label for="fdp"> Frais de port :</label>
            <input name="fraisport" /></br>
            <label for="dateA"> Date d'achat</label>
            <input type="date" name="dateAchat" /></br>
            <label for="dateL"> Date de livraison</label>
            <input type="date" name="dateLivraison" /></br>
            
            </br><input type="submit" name="action" value="Commander"/>
            </fieldset>-->
          
            <!----------SELECTEUR---------->
            <select name="categories" id="cate" >
                <!--<option value="rien" selected>Veuillez choisir une catégorie</option>-->
                <!--<option value="${param.categories}" selected> ${param.categories}</option>-->
                <c:if test="${empty param.categories}">
                    <script>
                        console.log("fail");
                        return window.location.replace("Categories.jsp?categories=1");
                    </script>
                </c:if>
                <c:forEach var="row" items="${selecteur.rows}">
                    <option value=${row.CODE} <c:if test="${param.categories eq row.CODE}" > selected</c:if> >${row.LIBELLE}</option>
                </c:forEach> 
            </select>        
        </p>
        
        <script>
            
            document.addEventListener('DOMContentLoaded',function() {
                    document.querySelector('select[name="categories"]').onchange=changeEventHandler;
            },false);
            
            function changeEventHandler(event) {
                // Vous pouvez utiliser “this” pour vous référer à l'élément sélectionné.
                console.log('You like ' + event.target.value + ' ice cream.'); 
                location.reload(true);
                window.location.replace("Categories.jsp?categories="+event.target.value);
            }
            
        </script>
        
        <p>
            <!-------REQUETE POUR LE PEUPLEMENT DE PRODUITS---------->
        
            <sql:query var="produit"   dataSource="${myDS}">
                SELECT * FROM PRODUIT WHERE CATEGORIE=${param.categories}
            </sql:query>
                
            <!----------PRODUITS---------->
            
            <div align=center">
                <label>Nos produits de la catégorie</label>
                <table id="item" border="1">
                    <tr>
                        <th>Référence</th>
                        <th>Nom</th>
                        <th>Fournisseur</th>
                        <!--<th>Categorie</th>-->
                        <th>Quantité par unité</th>
                        <th>Prix unitaire</th>
                        <th>Stock</th>
                        <th>Commandées</th>
                        <th>Réappro</th>
                        <th>Indisponible</th>

                        <c:if test="${param.categories gt 0}">
                            <c:if test="${param.categories lt 9}">
                                <c:forEach var="record" items="${produit.rows}">

                                    <tr>
                                        <td>${record.REFERENCE}</td>
                                        <td>${record.NOM}</td>
                                        <td>${record.FOURNISSEUR}</td>
                                        <td>${record.QUANTITE_PAR_UNITE}</td>
                                        <td>${record.PRIX_UNITAIRE}</td>
                                        <td>${record.UNITES_EN_STOCK}</td>
                                        <td>${record.UNITES_COMMANDEES}</td>
                                        <td>${record.NIVEAU_DE_REAPPRO}</td>
                                        <td>${record.INDISPONIBLE}</td>
                                        <td><button value="${record.REFERENCE}" type="button">Ajouter au panier</button></td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                        </c:if>
                            
                            
                            
                            
                            
                            
                        <!--<script>
                        
                            
                            var sel = document.getElementById('categories');
                            console.log(sel);
                            function getSelectedOption(sel) {
                                var opt;
                                for ( var i = 0, len = sel.options.length; i < len; i++ ) {
                                    opt = sel.options[i];
                                    if ( opt.selected === true ) {
                                        break;
                                    }
                                }
                                    return opt;
                            }
                                
                            var x = getSelectedOption(sel);
                            console.log(x);
                            console.log(document.getElementById("item"));
                            
                            var dbConnection = SQL.connect( { Driver: "org.apache.derby.jdbc.ClientDriver",
                                Host: "jdbc:derby://localhost",
                                Port: 1527,
                                Database: "comptoirs",
                                UserName: "APP",
                                Password: "app" } 
                            );
                            
                            if ($record.CATEGORIE==x){
                                console.log(document.getElementById("item"));
                                document.getElementByID("item").append(
                                hello);
                                }
                        
                        </script>-->
                        
                    </tr>
                </table>
            </div>
        </p>
    </body>