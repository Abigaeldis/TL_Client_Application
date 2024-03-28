<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Réservation</title>
<link rel="stylesheet" href="style/style.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<%@ include file="/WEB-INF/jspf/navbar.jspf"%>
	<div class="header-restaurant"></div>


<h1 class="margin_titre_reservation">Réservation</h1>

	<form class="backmenu" id="backmenuForm">
		<button class="backmenu-button" type="button">Retour</button>
	</form>
	
	<!-- Formulaire de réservation -->
	<div class="container-global-reservation">
		<div class="compte-container">
			<form action="reserver" method="POST">
				<p>Vous cherchez à réserver une table dans le restaurant
					${restaurant.nom }</p>
				<div>
					<label>Date et heure</label> <input class="input_style"
						type="datetime-local" placeholder="date" name="date" />
				</div>
				<div>
					<label>Nombre de personnes</label> <input class="input_style"
						type="number" placeholder="nombre de personnes" name="nbPersonne" />
				</div>
				<c:forEach var="current" items="${erreurs }">
					<p class="erreur">${current}</p>
				</c:forEach>
				<input class="button_style" type="submit"
					value="Demande de réservation"> <input type="hidden"
					name="id" value="${restaurant.id}"> <input type="hidden"
					name="idUtilisateur" value="${utilisateur.id }">
			</form>
		</div>
		
		<!-- Affichage des horaires du restaurant -->
		<div class="horaires">
			<h2>Horaires</h2>
			<c:forEach var="current" items="${jours}">
				<div class="horaires-container">
					<p>${current}
						:
						<c:if test="${not empty horairesGroupes[current]}">
							<c:forEach var="horaire" items="${horairesGroupes[current]}">
								<span>${horaire} </span>
							</c:forEach>
						</c:if>
						<c:if test="${empty horairesGroupes[current]}">
							<span>Fermé </span>
						</c:if>
					</p>
				</div>
			</c:forEach>
		</div>
	</div>
	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
	<script src="script/navbarScript.js"></script>
	<script src="script/retourPage.js"></script>
</body>
</html>