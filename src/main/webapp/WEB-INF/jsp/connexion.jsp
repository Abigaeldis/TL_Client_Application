<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login or Register</title>
</head>
<body>
	<%@ include file="/WEB-INF/jspf/navbar.jspf"%>
    <h1>Connexion ou Inscription</h1>
    
    <form action="Connexion" method="post">
        <label for="mail">Email :</label>
        <input type="text" id="mail" name="mail" required><br>
        
        <label for="motdepasse">Mot de passe :</label>
        <input type="password" id="motdepasse" name="motdepasse" required><br>
        
        <!-- Button to perform "S'inscrire" action -->
        <button type="submit" name="action" value="Inscription">S'inscrire</button>
        
        <!-- Button to perform "Se connecter" action -->
        <button type="submit" name="action" value="Connexion">Se connecter</button>
        <%-- Check for error message and display if present --%>
   		 <% String errorMessage = (String)request.getAttribute("errorMessage"); %>
    	<% if (errorMessage != null && !errorMessage.isEmpty()) { %>
       		<p style="color: red;"><%= errorMessage %></p>
   		 <% } %>
    </form>
</body>
</html>
