<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/jspf/navbar.jspf"%>
	<p>Nom : ${utilisateur.nom }</p>
	<p>Prenom : ${utilisateur.prenom }</p>
	<p>Mail : ${utilisateur.mail }</p>
	<p>Mot de passe : ${utilisateur.motdepasse }</p>
	<p>Telephone : ${utilisateur.telephone }</p>
	<p>Adresse : ${utilisateur.adresse }</p>
	
	

	
	<form action="modifier" method="GET">
	<input type="hidden" name="id" value="${utilisateur.id }" />
	<input type="submit" value="Modifier mes informations" />
	</form>
	
	
</body>
</html>