<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message envoyé</title>
</head>
<body>

<p>Le message suivant été envoyé avec succès au restaurant : <i>${restaurant.nom }</i></p>
<br>
<p><i>${message.titre }</i></p>
<p><i>${message.corpsMessage }</i></p>
<a href="accueil"><button>Retourner à l'accueil</button></a>
</body>
</html>