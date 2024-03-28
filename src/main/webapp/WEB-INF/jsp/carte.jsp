<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carte</title>
<link rel="stylesheet" href="style/style.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<%@ include file="/WEB-INF/jspf/navbar.jspf"%>
	<img alt="" class="banner_connexion" src="img/banniere_carte.jpg">

	<form class="backmenu" id="backmenuForm">
		<button class="backmenu-button" type="button">Retour</button>
	</form>
	<div>
		<h1>${carte.nom}</h1>
	</div>
	<div class="container-carte">
		<div class="carte-plats">
			<!-- Affichage des entrées -->
			<div>
				<h2>Entrées</h2>

				<c:forEach var="plat" items="${entrees}">
					<div class="div-plats">
						<div class="plat">
							<ul>
								<h3>${plat.nom}</h3>
								<li>${plat.description}</li>
							</ul>
						</div>
						<p>${plat.prix}</p>
					</div>
				</c:forEach>

			</div>
			<!-- Affichage des plats -->
			<div>
				<h2>Plats</h2>

				<c:forEach var="plat" items="${plats}">
					<div class="div-plats">
						<div class="plat">
							<ul>
								<li><h3>${plat.nom}</h3></li>
								<li>${plat.description}</li>
							</ul>
						</div>
						<p>${plat.prix}</p>
					</div>

				</c:forEach>

			</div>
			<!-- Affichage des desserts -->
			<div>
				<h2>Desserts</h2>

				<c:forEach var="plat" items="${desserts}">
					<div class="div-plats">
						<div class="plat">
							<ul>
								<li><h3>${plat.nom}</h3></li>
								<li>
								<li>${plat.description}</li>
							</ul>
						</div>
						<p>${plat.prix}</p>
					</div>
				</c:forEach>

			</div>
		</div>
		<!-- Affichage des boissons -->
		<div class="carte-boissons">
			<h2>Boissons</h2>
			<ul>
				<c:forEach var="plat" items="${boissons}">
					<div class="div-plats">
						<div class="plat">
							<ul>
								<li><h3>${plat.nom}</h3></li>
								<li>${plat.description}</li>
							</ul>
						</div>
						<p>${plat.prix}</p>
					</div>
				</c:forEach>
			</ul>
		</div>
	</div>


	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
	<script src="script/navbarScript.js"></script>
	<script src="script/retourPage.js"></script>
</body>
</html>
