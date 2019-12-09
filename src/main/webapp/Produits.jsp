<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Produits</title>
        <script src="https://kit.fontawesome.com/dd6a857052.js" crossorigin="anonymous"></script>
    </head>
    <body>
        

     
        <sql:query var="produit"   dataSource="${myDS}">
            SELECT * FROM PRODUIT
        </sql:query>
        <div class="header">
            <h1>Bienvenue sur Amatoz</h1>
        </div>
        <div class="topnav">
            <a class="active" href="#produits">Produits</a>
            <a href="#categories">Categories</a>
            <div class="topnav-right">
                <a href="#compte">Mon Compte</a>
                <a href="#commandes">Mes Commandes</a>
                <a href="#panier"><i class="fas fa-shopping-cart"></i></a>
                <a href="#deco" type='submit' name='action' value='Deconnexion'><!--Deconnexion--><i class="fas fa-sign-out-alt"></i></a>
            </div>
        </div> 
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
          
                
        
                </br>
        <div align=center">
            <table border="1">
                <tr>
                    <th>Référence</th>
                    <th>Nom</th>
                    <th>Fournisseur</th>
                    <th>Categorie</th>
                    <th>Quantité par unité</th>
                    <th>Prix unitaire</th>
                    <th>Stock</th>
                    <th>Commandées</th>
                    <th>Réappro</th>
                    <th>Indisponible</th>

                    <c:forEach var="record" items="${produit.rows}">
                    <tr>
                        <td>${record.REFERENCE}</td>
                        <td>${record.NOM}</td>
                        <td>${record.FOURNISSEUR}</td>
                        <td>${record.CATEGORIE}</td>
                        <td>${record.QUANTITE_PAR_UNITE}</td>
                        <td>${record.PRIX_UNITAIRE}</td>
                        <td>${record.UNITES_EN_STOCK}</td>
                        <td>${record.UNITES_COMMANDEES}</td>
                        <td>${record.NIVEAU_DE_REAPPRO}</td>
                        <td>${record.INDISPONIBLE}</td>
                        <td><select name="categories"  >
                                <option value=1 selected>1</option>
                                <% for(int i = 0; i < 10; i+=1)  { %>
                                    <% int v = i;
                                        pageContext.setAttribute("index", new Integer(i));
                                    %>
                                    <option value=${index}>${index}</option>
                                    <% 
                                } %>
                            </select>
                        </td>
                        <td><button value="${record.REFERENCE}" type="button">Ajouter au panier</button></td>
                    </tr>
                    </c:forEach>
                </tr>
            </table>
        </div>
        
	</form>
    </body>