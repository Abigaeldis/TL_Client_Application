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
    <div class="container">
      <h1>Name of user</h1>
      <form action="ServletInscriptionUtilisateur" method="post">
        <div class="form-control">
          <label for="prenom">Prenom : </label>
          <input type="text" name=prenom required />
        </div>
        
        <div class="form-control">
          <label for="nom">Nom : </label>
          <input type="text" name="nom" required />
        </div>
        
        <div class="form-control">
          <label for="motdepasse">Mot de passe : </label>
          <input type="password" name="motdepasse" value="${motdepasse }" required />
        </div>

        <div class="form-control">        
          <label for="mail">Mail : </label>
          <input type="text" name="mail" value="${mail }" required />
        </div>

        <div class="form-control">
          <label for="telephone">telephone : </label>
          <input type="text" name="telephone" required />
        </div>

        <div class="form-control">
          <label for="adresse">Adresse : </label>
        	<input type="text" name="adresse" required />
        </div>


        <input type="submit" value="Insérer" class="btn" />
      </form>
    </div>

</body>
</html>