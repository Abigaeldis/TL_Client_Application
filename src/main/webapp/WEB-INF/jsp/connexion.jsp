<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <label for="utilisateur">Utilisateur:</label>
        <input type="text" id="utilisateur" name="utilisateur" required><br>
        
        <label for=""motdepasse"">"Mot de passe":</label>
        <input type="password" id="motdepasse" name="motdepasse" required><br>
        
        <!-- Button to perform "S'inscrire" action -->
        <button type="submit" name="action" value="Inscription">S'inscrire</button>
        
        <!-- Button to perform "Se connecter" action -->
        <button type="submit" name="action" value="Connexion">Se connecter</button>
    </form>
</body>
</html>
