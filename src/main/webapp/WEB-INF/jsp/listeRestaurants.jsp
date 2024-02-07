<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Nos restaurants</title>
	<link rel="stylesheet" href="style/style.css" />
</head>
<body>
<%@ include file="/WEB-INF/jspf/navbar.jspf" %>
<div class = "header-restaurant">
</div>
<h1>Nos restaurants</h1>
<div class="container liste-container">
<c:forEach var="current" items="${restaurants }">
	<div class="restaurant-container">
		  <img alt="salle de restaurant" src="img/restaurant${current.id}.png">
          <h2>${current.nom}</h2>
          <p>${current.adresse}</p>
          <p>${current.description}</p>
          <a href="restaurant?id=${current.id}"><button>Détails</button></a>
     </div>
</c:forEach>
</div>
	
<%@ include file="/WEB-INF/jspf/footer.jspf"%>
<script src="script/navbarScript.js"></script>
</body>
</html>