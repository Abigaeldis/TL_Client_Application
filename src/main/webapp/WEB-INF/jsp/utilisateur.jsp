<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon compte</title>
<link rel="stylesheet" href="style/style.css" />
</head>
<body>
	<%@ include file="/WEB-INF/jspf/navbar.jspf"%>
	<div class="header-restaurant"></div>
	<div class="compte-container">
		<h1>Mes informations</h1>
		<div class="infos-container">
			<p>Nom : ${utilisateur.nom }</p>
			<p>Prenom : ${utilisateur.prenom }</p>
			<p>Mail : ${utilisateur.mail }</p>
			<p>Mot de passe : ${utilisateur.motdepasse }</p>
			<p>Telephone : ${utilisateur.telephone }</p>
			<p>Adresse : ${utilisateur.adresse }</p>
		</div>

		<a href="modifier?id=${utilisateur.id }"><button>Modifier
				mes informations</button></a>

		<button class="btn_supp_user" onclick="confirmDelete()" type="submit">Supprimer
			mon compte</button>
		<form id="deleteForm" action="supprimer?id=${utilisateur.id}"
			method="POST"></form>


	</div>

	<div class="messages-container">
		<h1>Messages envoyés</h1>
		<c:forEach var="current" items="${messages }">
			<div class="message-container">
				<h3>${current.titre}-${current.restaurant.nom}</h3>
				<p>${current.corpsMessage}</p>
			</div>
		</c:forEach>
	</div>

	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
	<script src="script/navbarScript.js"></script>
	<script src="script/confirmationSuppressionUtilisateur.js"></script>
</body>
</html>