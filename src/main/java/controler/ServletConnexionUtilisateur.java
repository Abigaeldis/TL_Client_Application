package controler;

import java.io.IOException;
import java.util.List;

import bll.BLLException;
import bll.UtilisateurBLL;
import bo.Utilisateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletConnexionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Récupération des paramètres
		String action = request.getParameter("action");
		String mail = request.getParameter("mail");
		String motdepasse = request.getParameter("motdepasse");
		
		//Si on choisit de s'inscrire
		if ("Inscription".equals(action)) {
			UtilisateurBLL utilisateurBLL;
			try {
				utilisateurBLL = new UtilisateurBLL();
				List<Utilisateur> utilisateursExistants = utilisateurBLL.selectAll();
				for (Utilisateur current : utilisateursExistants) {
					if (current.getMail().equals(mail)) {
						//Si le mail est déjà utilisé : erreur
						request.setAttribute("erreurs", "Un compte existe déjà avec cette adresse mail.");
						request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
					}
				}
			} catch (BLLException e) {
				e.printStackTrace();
			}
			//Si pas d'erreur, on récupère le mail et le mot de passe entrés
			request.setAttribute("mail", mail);
			request.setAttribute("motdepasse", motdepasse);
			//Redirection vers le formulaire d'inscription
			request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
		}
		try {
			UtilisateurBLL utilisateurBLL = new UtilisateurBLL();
			Utilisateur utilisateurObj = utilisateurBLL.authenticateUser(mail, motdepasse, request);
			if (utilisateurObj != null) {
				//Si le mdp/mail correspond à un utilisateur dans la bdd, on enregistre l'utilisateur en param de session
				request.getSession().setAttribute("utilisateur", utilisateurObj);

				//Récup de la page précédant la connexion
				String previousPage = (String) request.getSession().getAttribute("previousPage");

				request.getSession().removeAttribute("previousPage");

				// Redirection vers la page précédente s'il y en avait une, sinon vers l'accueil
				if (previousPage != null && !previousPage.isEmpty()) {
					response.sendRedirect(previousPage);
				} else {
					response.sendRedirect("index.jsp");
				}
			} else {
				request.setAttribute("erreurs", "Échec d'authentification");
				request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
			}
		} catch (BLLException e) {
			e.printStackTrace();
			request.setAttribute("erreurs", "Échec d'authentification");
			request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
		}
	}
}