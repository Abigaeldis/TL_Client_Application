<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Envoyer un message</title>
</head>
<body>
<%@ include file="/WEB-INF/jspf/navbar.jspf"%>
	<h1>Contacter ${restaurant.nom }</h1>
	
	<form action="contacter" method="POST">
	<div>
	<input type="text" name="titre" placeholder="Objet">
	</div>
	<br>
	<div>
	<input type="text" name="corpsDuMessage" placeholder="Votre message">
	</div>
	<input type="hidden" name="idUtilisateur" value="1">
	<input type="hidden" name="idRestaurant" value="${restaurant.id }">
	<br>
	<button type="submit">Envoyer</button>
	</form>
	
	<!-- A TERMINER si besoin de l'id session/utilisateur-->

</body>
</html>