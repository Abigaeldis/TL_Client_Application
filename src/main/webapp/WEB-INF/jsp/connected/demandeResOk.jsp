<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Demande envoyée</title>
<link rel="stylesheet" href="style/style.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/jspf/navbar.jspf" %>
<div class = "header-restaurant"></div>
<div class="reservation_envoyee">
<h1>Réservation</h1>
<div class="reservation_envoye">
<p>Votre demande de réservation au restaurant ${restaurant.nom }, pour ${nbPersonne } personnes le ${dateReservation.toLocalDate() } à ${dateReservation.toLocalTime() } a été envoyée.</p>
<p>Le restaurant ${restaurant.nom } reviendra rapidement vers vous pour valider votre venue.</p>

<p>
<a href="index.jsp"><button>Retour à l'accueil</button></a>
</p>
</div>
</div>

<%@ include file="/WEB-INF/jspf/footer.jspf"%>
<script src="script/navbarScript.js"></script>
</body>
</html>