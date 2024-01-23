<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail du restaurant</title>
</head>
<body>
<%@ include file="/WEB-INF/jspf/navbar.jspf" %>
	<h1>Detail du restaurant ${restaurant.id }</h1>

	<p>Nom : ${restaurant.nom }</p>
	<p>Adresse : ${restaurant.adresse }</p>
	<p>Description : ${restaurant.description }</p>
	
	<h2>Horaires</h2>
	<c:forEach var="current" items="${horairesRestaurant }">
		<div class="horaires-container">
	        <p>${current.jour} ${current.heureDeDebut} - ${current.heureDeFin}</p>
	     </div>
	</c:forEach>

	<a href="carte?id=${restaurant.id}"><button>Afficher la carte</button></a>
	
	<a href="reserver?id=${restaurant.id}"><button>Réserver</button></a>
	
	<a href="contacter?id=${restaurant.id}"><button>Contacter</button></a>
	<p>
	<a href="index.jsp">Retour à l'accueil</a>
	</p>

</body>
</html>