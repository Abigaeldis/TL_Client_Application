<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Details</title>
</head>
<body>
<%@ include file="/WEB-INF/jspf/navbar.jspf" %>
<h1>Voici la carte du restaurant</h1>
    
<div>
    <p>${carte.nom}</p>
</div>

<div>
    <h2>Entrées</h2>
    <ul>
        <c:forEach var="plat" items="${entrees}">
            <li>${plat.nom} - ${plat.description} - ${plat.prix}</li>
        </c:forEach>
    </ul>
</div>

<div>
    <h2>Plats</h2>
    <ul>
        <c:forEach var="plat" items="${plats}">
            <li>${plat.nom} - ${plat.description} - ${plat.prix}</li>
        </c:forEach>
    </ul>
</div>

<div>
    <h2>Desserts</h2>
    <ul>
        <c:forEach var="plat" items="${desserts}">
            <li>${plat.nom} - ${plat.description} - ${plat.prix}</li>
        </c:forEach>
    </ul>
</div>

<div>
    <h2>Boissons</h2>
    <ul>
        <c:forEach var="plat" items="${boissons}">
            <li>${plat.nom} - ${plat.description} - ${plat.prix}</li>
        </c:forEach>
    </ul>
</div>

<form action="ServletRedirectionIndex" method="GET">
    <button class="btn" type="submit">Back to menu</button>
</form>
</body>
</html>
