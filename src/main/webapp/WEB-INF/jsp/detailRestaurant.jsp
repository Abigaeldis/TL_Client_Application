<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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



	<a href="carte?id=${restaurant.id}"><button>Afficher la carte</button></a>
	
	<a href="reserver?id=${restaurant.id}"><button>Réserver</button></a>
	
	<a href="contacter?id=${restaurant.id}"><button>Contacter</button></a>



</body>
</html>