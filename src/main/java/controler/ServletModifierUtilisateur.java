package controler;

import java.io.IOException;

import bll.BLLException;
import bll.UtilisateurBLL;
import bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletModifierUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurBLL utilisateurBll;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			utilisateurBll = new UtilisateurBLL();
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Récupération des paramètres
		String idStr = request.getParameter("id");

		// 2. Passage des paramètres dans le type voulu
		int id = Integer.parseInt(idStr);

		// 3. Exploitation des paramètres par le bll
		Utilisateur utilisateur = null;
		try {
			utilisateur = utilisateurBll.selectById(id);

			// 4. Ajout des attributs éventuels à ma request
			request.setAttribute("utilisateur", utilisateur);
		} catch (BLLException e) {
			e.printStackTrace();
		}

		// 5. Redirection vers la JSP choisie
		request.getRequestDispatcher("/WEB-INF/jsp/modifierUtilisateur.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Etape 1 : recuperer les parametres
		String idStr = request.getParameter("id");
		String nomStr = request.getParameter("nom");
		String prenomStr = request.getParameter("prenom");
		String mailStr = request.getParameter("mail");
		String passStr = request.getParameter("motdepasse");
		String telStr = request.getParameter("telephone");
		String adresseStr = request.getParameter("adresse");
		
		
		// Etape 2 : passage dans le bon type
		int id = Integer.parseInt(idStr);
		Utilisateur utilisateurAModifier = null;
		
		// Etape 3 : exploitation des parametres par le bll
		try {
			// Récupération de l'utilisateur en base de donnees
			utilisateurAModifier = utilisateurBll.selectById(id);
			// Mise à jour de toutes ses informations
			utilisateurAModifier.setNom(nomStr);
			utilisateurAModifier.setPrenom(prenomStr);
			utilisateurAModifier.setMail(mailStr);
			utilisateurAModifier.setMotdepasse(passStr);
			utilisateurAModifier.setTelephone(telStr);
			utilisateurAModifier.setAdresse(adresseStr);
		} catch (BLLException e) {e.printStackTrace();
		}
		try {
			// Enregistrement des modifications auprès de la base de donnees
			utilisateurBll.update(utilisateurAModifier);
			response.sendRedirect("MonCompte?id=" + id);
		} catch (BLLException e) {
			request.setAttribute("erreurs", e.getErreurs());
			request.setAttribute("utilisateur", utilisateurAModifier);
			request.getRequestDispatcher("/WEB-INF/jsp/modifierUtilisateur.jsp").forward(request, response);
		}

	}

}
