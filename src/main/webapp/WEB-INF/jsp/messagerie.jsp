<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="style/style.css" />
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<title>Envoyer un message</title>
</head>
<body>
	<%@ include file="/WEB-INF/jspf/navbar.jspf"%>
	<img class="img_banniere_messagerie" alt="banniere_messagerie"
		src="img/banniere_messagerie.jpg">

	<h1 class="titre_messagerie">Contacter ${restaurant.nom }</h1>
	<form class="backmenu" id="backmenuForm">
		<button class="backmenu-button" type="button">Retour</button>
	</form>
	<div class="container_messagerie">
		<form class="form_messagerie" action="contacter" method="POST">
			<div class="div_titre_message">
				<input class="titre_message" type="text" name="titre"
					placeholder="Titre">
			</div>

			<div class="div_corps_message">
				<input class="corps_message" name="corpsDuMessage"></input>
			</div>
			<input type="hidden" name="idUtilisateur" value="${utilisateur.id }">
			<input type="hidden" name="idRestaurant" value="${restaurant.id }">


			<c:forEach var="current" items="${erreurs }">
				<p class="erreur">${current}</p>
			</c:forEach>


			<button class="btnOrange btnOrange_messagerie" type="submit">Envoyer</button>
		</form>
	</div>

	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
	<script src="script/navbarScript.js"></script>
	<script src="script/retourPage.js"></script>
</body>
</html>