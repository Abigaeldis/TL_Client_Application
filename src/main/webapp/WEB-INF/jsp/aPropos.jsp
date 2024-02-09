<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Qui sommes-nous?</title>
<link rel="stylesheet" href="style/style.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<%@ include file="/WEB-INF/jspf/navbar.jspf"%>
	<img class="img_banniere_messagerie" alt="banniere_messagerie"
		src="img/banniere_messagerie.jpg">

	<div class="apropos_container">
		<h2 class="apropos_titre">À propos</h2>
		<div class="apropos_intro">Bienvenue sur notre page "À
			Propos", où nous sommes ravis de partager avec vous les détails
			passionnants de notre projet de développement réalisé dans le cadre
			de notre formation. Notre équipe dévouée a travaillé conjointement
			sur le back-end et le front-end pour créer une solution innovante et
			fonctionnelle qui reflète notre engagement envers l'apprentissage et
			l'excellence technologique.</div>

		<div class="apropos_mission"><h3>Notre Mission</h3> Notre mission était
			de concevoir et de mettre en œuvre une application robuste qui répond
			aux besoins modernes du monde numérique. À travers ce projet, nous
			avons cherché à acquérir une compréhension approfondie du
			développement back-end et front-end, en mettant l'accent sur la
			création d'une expérience utilisateur fluide et agréable.</div>
		<div class="apropos_objectif"><h3>Le Défi</h3> Le projet a constitué un
			défi stimulant qui nous a permis d'appliquer nos connaissances
			acquises au cours de notre formation. Du côté back-end, nous avons
			abordé des questions complexes liées à la gestion des données, à la
			sécurité et à la performance, tandis que le front-end nous a amenés à
			explorer la convivialité, le design réactif et l'accessibilité.</div>
		<div class="apropos_tech"><h3>Technologies Utilisées</h3> Nous avons opté
			pour un ensemble de technologies modernes afin de garantir la qualité
			et la pérennité de notre solution. Du côté du back-end, nous avons
			utilisé [Nom de la technologie] pour gérer efficacement les données
			et assurer une communication sécurisée. Sur le front-end, nous avons
			mis en œuvre [Nom de la bibliothèque/framework] pour créer une
			interface utilisateur intuitive et attrayante.</div>
		<div class="apropos_equipe"><h3>Notre Équipe</h3> Notre équipe est composée
			de passionnés de développement, chacun apportant une expertise unique
			au projet. Nous croyons fermement en la collaboration et en la
			diversité des compétences pour aboutir à des résultats exceptionnels.
		</div>
		<div class="apropos_resultat">Ce Que Nous Avons Appris Ce projet
			a été bien plus qu'une simple expérience de développement. Il a été
			une opportunité d'apprendre, de surmonter des obstacles et de grandir
			en tant que professionnels du secteur. Les leçons tirées de ce
			parcours renforcent notre détermination à exceller dans le domaine du
			développement logiciel.</div>

		Contact Si vous avez des questions, des commentaires ou si vous
		souhaitez en savoir plus sur notre projet, n'hésitez pas à nous
		contacter à [adresse e-mail ou lien vers le formulaire de contact].

		Nous vous remercions de prendre le temps de découvrir notre travail et
		sommes impatients de partager davantage sur notre aventure de
		développement. Cordialement, 
		Abigaël, Lauriane, Rodrigue.


	</div>


	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
	<script src="script/navbarScript.js"></script>
	<script src="script/retourPage.js"></script>
</body>
</html>