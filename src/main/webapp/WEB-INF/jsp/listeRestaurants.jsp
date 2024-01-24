<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="style/styleListeRestaurant.css" />
</head>
<body>
<%@ include file="/WEB-INF/jspf/navbar.jspf" %>
<h1>Nos restaurants</h1>

<c:forEach var="current" items="${restaurants }">
	<div class="restaurant-container">
          <h2>${current.nom}</h2>
          <p>${current.adresse}</p>
          <p>${current.description}</p>
          <a href="restaurant?id=${current.id}"><button>Détails</button></a>
     </div>
</c:forEach>

<script src="script/navbarScript.js"></script>
</body>
</html>