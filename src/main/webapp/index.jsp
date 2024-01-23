<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="style/style.css" />
</head>
<body>
    <%@ include file="/WEB-INF/jspf/navbar.jspf"%>
    <header>
        <div class="overlay">
            <h1>Your Header Title</h1>
            <p>Your header text goes here.</p>
            <button>Click Me</button>

            <c:if test="${not empty sessionScope.utilisateur}">
                <h2>Hello ${sessionScope.utilisateur.nom}</h2>
            </c:if>
        </div>
    </header>
</body>
</html>
