<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Saisie d'un taux de remise</title>
			<!-- Formatage d'une table par des CSS, inspiré de : https://stackoverflow.com/questions/5967564/form-inside-a-table -->
			<style>
				.table
				{
					display:table;
					border-collapse:separate;
					border-spacing:2px;
				}
				.thead
				{
					display:table-header-group;
					color:white;
					font-weight:bold;
					background-color:grey;
				}
				.tbody
				{
					display:table-row-group;
				}
				.tr
				{
					display:table-row;
				}
				.td
				{
					display:table-cell;
					border:1px solid black;
					padding:1px;
				}			
		</style>		
	</head>
	<body>
		<!-- On montre le formulaire de saisie -->
		<h1>Edition des taux de remise</h1>
		<%--  On montre un éventuel message d'erreur --%>
		<div><h4>${message}</h4></div>
		<%-- On on montre la liste des discount codes --%>
		<div class="table">
			<div class="thead"><div class="td">Numero</div></div>
			<div class="tbody">
			<c:forEach var="record" items="${numeros}">
				<form class="tr" method="get">
					<div class="td"><input type="text" name="code" value="${record}" readonly/></div>
					<div class="td"><input type="submit" name="action" value="DELETE"/></div>
				</form>	  		    
			</c:forEach>  
			</div>
		</div>
	</body>        
</html>
