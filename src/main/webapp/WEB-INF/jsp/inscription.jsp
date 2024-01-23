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
          <input type="text" name=prenom required />
          <label for="prenom">Prenom : </label>
        </div>
        
        <div class="form-control">
          <input type="text" name="nom" required />
          <label for="nom">Nom : </label>
        </div>
        
        <div class="form-control">
          <input type="password" name="motdepasse" value="${motdepasse }" required />
          <label for="motdepasse">Mot de passe : </label>
        </div>

        <div class="form-control">        
          <input type="text" name="mail" value="${mail }" required />
          <label for="mail">Mail : </label>
        </div>

        <div class="form-control">
          <input type="text" name="telephone" required />
          <label for="telephone">telephone : </label>
        </div>

        <div class="form-control">
        <input type="text" name="adresse" required />
          <label for="adresse">Adresse : </label>
        </div>


        <input type="submit" value="Insérer" class="btn" />
      </form>
    </div>

</body>
</html>