<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>Accueil - Poke Now.</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="style/style.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<%@ include file="/WEB-INF/jspf/navbar.jspf"%>
	<header>
		<div class="overlay">
			<c:choose>
				<c:when test="${empty sessionScope.utilisateur}">
					<h1>Retrouvez la fraicheur de nos bowls</h1>
					<p>N'attendez plus et rejoignez nous.</p>
					<a href="Connexion"><button class="btnOrange">Connectez
							vous</button></a>
				</c:when>
				<c:otherwise>
					<c:if test="${not empty sessionScope.utilisateur}">
						<h2>
							Bonjour <span class="userName">${sessionScope.utilisateur.nom}</span>
						</h2>
						<h3>Une petite envie de fraicheur ?</h3>
						<p>N'attendez plus pour réserver</p>
						<a href="restaurants"><button class="btnOrange">Retrouvez
								nos restaurants</button></a>
					</c:if>
				</c:otherwise>
			</c:choose>
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
			<div class="testimonial-carousel">
				<div class="testimonial">
					<img alt="happy customer" src="img/client_satisfait1.jpeg">
					<h2>Jeanne Doe</h2>
					<p>"Je suis un grand amateur de bols de poke, et cet endroit
						est vraiment à la hauteur. La qualité des ingrédients est
						excellente, et la variété des garnitures vous permet de
						personnaliser votre bol selon vos préférences."</p>
				</div>
				<div class="testimonial">
					<img alt="happy customer" src="img/client_satisfait2.png">
					<h2>Etienne Cassin</h2>
					<p>"Le poke est devenu l'une de mes options de repas préférées,
						et cet endroit est l'un des meilleurs que j'ai essayés jusqu'à
						présent. Les portions sont généreuses, les saveurs sont fraîches
						et les prix sont raisonnables. Hautement recommandé!"</p>
				</div>
				<div class="testimonial">
					<img alt="happy customer" src="img/client_satisfait3.jpeg">
					<h2>Homer PeuDargent</h2>
					<p>"Les poke bowls sont devenus l'une de mes options de repas
						préférées, et cet endroit est l'un des meilleurs que j'ai essayés
						jusqu'à présent. Les portions sont généreuses, les saveurs sont
						fraîches, et les prix sont raisonnables."</p>
				</div>
			</div>
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
	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
	<script src="script/navbarScript.js"></script>
	<script src="script/scriptCaroussel.js"></script>
</body>

</html>
