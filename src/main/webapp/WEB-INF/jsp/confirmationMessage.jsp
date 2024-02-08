<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="style/style.css" />
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<title>Message envoyé</title>
</head>
<body>
<%@ include file="/WEB-INF/jspf/navbar.jspf"%>
<img class="img_banniere_messagerie" alt="banniere_messagerie"
		src="img/banniere_messagerie.jpg">
<h1 class="titre_messagerie"><i>Message envoyé avec succès</i></h1>



<div class="container_confirmation_messagerie">
<div class="titre_confirmation_messagerie">
<p><i>${message.titre }</i></p>
</div>
<div class="contenu_confirmation_messagerie">
<p><i>${message.corpsMessage }</i></p>
</div>
</div>

<a href="index.jsp" ><button class="btnOrange btnOrange_confirmation_messagerie">Retourner à l'accueil</button></a>







<%@ include file="/WEB-INF/jspf/footer.jspf"%>
	<script src="script/navbarScript.js"></script>
</body>
</html>