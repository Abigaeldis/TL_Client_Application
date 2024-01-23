<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Réservation</title>
</head>
<body>
<%@ include file="/WEB-INF/jspf/navbar.jspf" %>
<h1>Réservation</h1>
<p>Vous cherchez à réserver une table dans le restaurant ${restaurant.nom }</p>

<form action="reserver" method="POST">
	<div>
		<input type="datetime-local" placeholder="date" name="date" />
	</div>
	<div>
		<input type="number"  placeholder="nombre de personnes" name="nbPersonne" />
	</div>
	<c:forEach var="current" items="${erreurs }">
		<p class="erreur">${current}</p>
	</c:forEach>
	<input type = "submit" value = "Demande de réservation">
	<input type = "hidden" name = "id" value = "${restaurant.id}">
</form>

<h2>Horaires</h2>
	<c:forEach var="current" items="${horairesRestaurant }">
		<div class="horaires-container">
	        <p>${current.jour} ${current.heureDeDebut} - ${current.heureDeFin}</p>
	     </div>
	</c:forEach>
</body>
</html>