<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/jspf/navbar.jspf" %>
<h1>Réservation</h1>
<p>Votre demande de réservation au restaurant ${restaurant.nom }, pour ${nbPersonne } personnes le ${dateReservation.toLocalDate() } à ${dateReservation.toLocalTime() } a été envoyée.</p>
<p>Le restaurant ${restaurant.nom } reviendra rapidement vers vous pour valider votre venue.</p>

<p>
<a href="index.jsp">Retour à l'accueil</a>
</p>
</body>
</html>