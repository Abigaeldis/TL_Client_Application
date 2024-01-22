<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail du restaurant</title>
</head>
<body>

	<h1>Detail du restaurant ${restaurant.id }</h1>

	<p>Nom : ${restaurant.nom }</p>
	<p>Adresse : ${restaurant.adresse }</p>
	<p>Description : ${restaurant.description }</p>



	<a href="restaurant?id=${restaurant.id}"><button>Afficher la carte</button></a>
	
	<a href="restaurant?id=${restaurant.id}"><button>Réserver</button></a>
	
	<a href="">Contacter</a>




	<%-- 	<a href="modifier?id=${restaurant.id }">Modifier le contact</a> --%>



</body>
</html>