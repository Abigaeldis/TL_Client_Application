<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
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
			<h1>Retrouvez la fraicheur de nos bowls</h1>
			<p>N'attendez plus et rejoignez nous.</p>
			<a href="Connexion"><button class="btnOrange">Connectez
					vous</button></a>

			<c:if test="${not empty sessionScope.utilisateur}">
				<h2>Hello ${sessionScope.utilisateur.nom}</h2>
			</c:if>
		</div>
	</header>

	<div class="presentation">
		<h2>Qu'est ce qu'un Poke ?</h2>
		<p>Le poke est un plat traditionnel hawaïen qui se compose
			généralement de poisson cru coupé en dés (comme du thon ou du saumon)
			mariné dans de la sauce soja et d'autres ingrédients savoureux. Il
			est souvent servi sur un lit de riz et garni de divers
			accompagnements tels que des algues, du concombre, de l'avocat et des
			graines de sésame. Le poke a gagné en popularité dans le monde entier
			et est désormais apprécié sous de nombreuses variations et saveurs
			différentes.</p>
	</div>

	<div class="client">
		<div class="col1">
			<h2>Nos clients sont ravis</h2>
			<p>Je suis un grand amateur de bols de poke, et cet endroit est
				vraiment à la hauteur. La qualité des ingrédients est excellente, et
				la variété des garnitures vous permet de personnaliser votre bol
				selon vos préférences.</p>
			<strong>Laurent Martinez</strong> <img alt="happy customer"
				src="img/EC.png">
		</div>
		<div class="col2">
			<img alt="homme tenant un poke bowl" src="img/bowl1.png">
		</div>
	</div>

	<div class="restaurants">
		<div class="col1">
			<h2>Trouvez nous</h2>
			<p>Nous servons de délicieux et frais plats dans toute la France</p>
			<a href="restaurants"><button type="button" class="btnOrange">Découvrez
					nos Restaurants</button></a>
		</div>
		<div class="col2">
			<img alt="delicieux petit bowl" class="petitbowl" src="img/bowl3.png">
			<img alt="delicieux bowl" class="cutbowl" src="img/bowl2.png">
		</div>
	</div>
	<script src="script/navbarScript.js"></script>
</body>

</html>
