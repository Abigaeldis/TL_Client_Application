<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style/style.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
	<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Inscription</title>
</head>
<body>
	<%@ include file="/WEB-INF/jspf/navbar.jspf"%>
	<img alt="" class="banner_connexion" src="img/banner_connexion.jpg">

	<h1>Création de votre compte</h1>
	<div class="container_inscription">
		<div class="col_1_inscription">
<!-- 			<div class="inscription_form"> -->
			<div class= "compte-container">
				<form action="ServletInscriptionUtilisateur" method="post">
					<div>
						<label for="prenom">Prenom : </label> 
						<input class="input_style extra_margin"
							type="text" name=prenom required />
					</div>

					<div>
						<label for="nom">Nom : </label> <input class="input_style extra_margin"
							type="text" name="nom" required />
					</div>

					<div>
						<label for="motdepasse">Mot de passe : </label> <input
							class="input_style" type="password" name="motdepasse"
							value="${motdepasse }" required />
					</div>

					<div>
						<label for="mail">Mail : </label> <input class="input_style extra_margin"
							type="text" name="mail" value="${mail }" required />
					</div>

					<div>
						<label for="telephone">telephone : </label> <input
							class="input_style extra_margin" type="text" name="telephone" required />
					</div>

					<div>
						<label for="adresse">Adresse : </label> <input class="input_style extra_margin"
							type="text" name="adresse" required />
					</div>
				<c:forEach var="current" items="${erreurs }">
					<p class="erreur">${current}</p>
				</c:forEach>
				
				<input type="submit" value="Inscription" class="btnOrange inscription_btn" />
					
				</form>

			</div>
		</div>
		<div class="col_2_inscription">
			<img alt="" src="img/bowl1.png">
		</div>
	</div>
	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
	<script src="script/navbarScript.js"></script>
</body>
</html>