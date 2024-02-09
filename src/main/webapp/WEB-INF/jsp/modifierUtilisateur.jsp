<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Modifier mes informations</title>
<link rel="stylesheet" href="style/style.css" />
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<%@ include file="/WEB-INF/jspf/navbar.jspf"%>
	<div class="header-restaurant"></div>
	<h1>Modification des informations</h1>
	<div class="compte-container">
		<form action="modifier" method="POST">
			<input class="input_style" type="hidden" name="id"
				value="${utilisateur.id }" />
			<div>
				<label>Prénom</label> <input class="input_style" type="text"
					name="prenom" value="${utilisateur.prenom }" />
			</div>
			<div>
				<label>Nom</label> <input class="input_style" type="text" name="nom"
					value="${utilisateur.nom }" />
			</div>
			<div>
				<label>Mail</label> <input class="input_style" type="text"
					name="mail" value="${utilisateur.mail }" />
			</div>
			<div>
				<label>Mot de passe</label> <input class="input_style"
					type="password" name="motdepasse"
					value="${utilisateur.motdepasse }" />
			</div>
			<div>
				<label>Téléphone</label> <input class="input_style" type="text"
					name="telephone" value="${utilisateur.telephone }" />
			</div>
			<div>
				<label>Adresse</label> <input class="input_style" type="text"
					name="adresse" value="${utilisateur.adresse }" />
			</div>
			<c:forEach var="current" items="${erreurs }">
				<p class="erreur">${current}</p>
			</c:forEach>
			<div>
				<input class="button_style" type="submit" value="Enregistrer" />
			</div>
		</form>
	</div>
	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
	<script src="script/navbarScript.js"></script>
</body>
</html>