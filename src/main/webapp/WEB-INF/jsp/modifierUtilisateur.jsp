<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier mes informations</title>
</head>
<body>
	<%@ include file="/WEB-INF/jspf/navbar.jspf"%>
	<h2>Bonjour ${utilisateur.prenom }, quelle information souhaitez-vous modifier?</h2>
	<br>
	<form action="modifier" method="POST">
		<input type="hidden" name="id" value="${utilisateur.id }" />
		<div>
			<input type="text" name="nom" value="${utilisateur.nom }" />
		</div>
		<div>
			<input type="text" name="prenom" value="${utilisateur.prenom }" />
		</div>
		<div>
			<input type="text" name="mail" value="${utilisateur.mail }" />
		</div>
		<div>
			<input type="password" name="motdepasse" value="${utilisateur.motdepasse }" />
		</div>
		<div>
			<input type="text" name="telephone" value="${utilisateur.telephone }" />
		</div>
		<div>
			<input type="text" name="adresse" value="${utilisateur.adresse }" />
		</div>
		<div>
			<input type="submit" value="Enregistrer" />
		</div>
	</form>

</body>
</html>