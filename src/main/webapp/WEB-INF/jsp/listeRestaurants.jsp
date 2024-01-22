<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="style/styleListeContacts.css" />
</head>
<body>
	<c:forEach var="current" items="${restaurants }">
		<div class="restaurant-container">
	          <p>${current.nom} ${current.adresse} - ${current.description}</p>
	          <a href="restaurant?id=${current.id}"><button>Détails</button></a>
	     </div>
	</c:forEach>
</body>
</html>