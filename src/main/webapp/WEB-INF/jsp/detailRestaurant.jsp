<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail du restaurant</title>
<link rel="stylesheet" href="style/styleDetailRestaurant.css" />
<link rel="stylesheet" href="style/style.css" />
</head>

<body>
	<%@ include file="/WEB-INF/jspf/navbar.jspf"%>
	<img class="img_banniere" alt="banniere_detail_restaurant"
		src="img/banniere_detail_restaurant.png">
	<div class="title">
		<h1>${restaurant.nom }</h1>
	</div>
	<div class="container">
		<div class="col_1">
			<img alt="salle de restaurant"
				src="img/restaurant${restaurant.id}.png">
			<p>
				<i>${restaurant.adresse }</i>
			</p>
			<p>${restaurant.description }</p>

			<div class="div_btn_detail_restaurant">
				<a href="carte?id=${restaurant.id}"><button
						class="bouton_afficher_carte">Afficher la carte</button></a> <a
					href="contacter?id=${restaurant.id}"><button>Contacter</button></a>
			</div>
		</div>
		<div class="col_2">
			<h2>Horaires</h2>
			<c:forEach var="current" items="${horairesRestaurant }">
				<div class="horaires-container">
					<p>${current.jour}${current.heureDeDebut}-
						${current.heureDeFin}</p>
				</div>
			</c:forEach>

			<a href="reserver?id=${restaurant.id}"><button
					class="button_reserver">Réserver</button></a>


		</div>
	</div>
	<div class="margin_retour_liste">
		<a href="restaurants"><i>Retourner à la
			liste</i></a>
	</div>

	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
	<script src="script/navbarScript.js"></script>

</body>
</html>