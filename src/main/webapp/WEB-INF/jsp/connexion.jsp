<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login or Register</title>
<link rel="stylesheet" href="style/style.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
	<%@ include file="/WEB-INF/jspf/navbar.jspf"%>

	<img alt="" class="banner_connexion" src="img/banner_connexion.jpg">




	<div class="container_connexion">
		<div class="col_1_connexion">
			<form action="Connexion" method="post">
				<div class="label_connexion">
					<label for="mail">Email :</label> <input class="input_style"
						type="text" id="mail" name="mail" required> <label
						for="motdepasse">Mot de passe :</label> <input type="password"
						id="motdepasse" class="input_style" name="motdepasse" required>
				</div>



				<!-- Button to perform "S'inscrire" action -->
				<div class="container_btn">
					<button type="submit" class="btnOrange" name="action"
						value="Inscription">S'inscrire</button>

					<!-- Button to perform "Se connecter" action -->
					<button class="btnOrange" type="submit" name="action"
						value="Connexion">Se connecter</button>
				</div>

				<%-- Check for error message and display if present --%>
				<%
				String errorMessage = (String) request.getAttribute("errorMessage");
				%>
				<%
				if (errorMessage != null && !errorMessage.isEmpty()) {
				%>
				<p style="color: red;"><%=errorMessage%></p>
				<%
				}
				%>
			</form>
		</div>

		<div class="col_2_connexion">
			<img alt="" src="img/bowl1.png">
		</div>

	</div>


	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
	<script src="script/navbarScript.js"></script>
</body>
</html>
