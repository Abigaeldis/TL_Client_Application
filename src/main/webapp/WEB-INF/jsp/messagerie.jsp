<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Envoyer un message</title>
</head>
<body>
	<h1>Nous contacter</h1>
	
	<form action="contacter" method="POST">
	<div>
	<input type="text" name="titre">
	</div>
	<br>
	<div>
	<input type="text" name="corpsDuMessage">
	</div>
	<input type="hidden" name="id_utilisateur" value="${utilisateur.id }">
	<br>
	<button type="submit">Envoyer</button>
	</form>
	
	

</body>
</html>