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
	<ul>
	<c:forEach var="current" items="${restaurants }">
		<li>
			<div class="restaurant-container">
	                ${current.nom} ${current.adresse} - ${current.description}
	                <a href="restaurant?id=${current.id}"><button>Détails</button></a>
		     </div>
		</li>
	</c:forEach>
	</ul>
</body>
</html>