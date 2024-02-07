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

/**
 * Servlet implementation class ServletInscriptionUtilisateur
 */
public class ServletConnexionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String mail = request.getParameter("mail");
		String motdepasse = request.getParameter("motdepasse");
		if ("Inscription".equals(action)) {
			System.out.println("Inscription en cours");
			UtilisateurBLL utilisateurBLL;
			try {
				utilisateurBLL = new UtilisateurBLL();
				List<Utilisateur> utilisateursExistants = utilisateurBLL.selectAll();
				for (Utilisateur current : utilisateursExistants) {
					System.out.println(current.getMail());
					if (current.getMail().equals(mail)) {
						System.out.println("Mail déjà existant");
						request.setAttribute("erreurs", "Un compte existe déjà avec cette adresse mail.");
						request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
					}
				}
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("mail", mail);
			request.setAttribute("motdepasse", motdepasse);
			request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
		} else if ("Connexion".equals(action)) {

			try {
				UtilisateurBLL utilisateurBLL = new UtilisateurBLL();
				// Validate user credentials and retrieve the user object
				Utilisateur utilisateurObj = utilisateurBLL.authenticateUser(mail, motdepasse, request);
				if (utilisateurObj != null) {
					// If the user is valid, store the user object in the session
					request.getSession().setAttribute("utilisateur", utilisateurObj);
					// Redirect to the index.jsp
					response.sendRedirect("index.jsp");
				} else {
					// If the user is not valid, handle it accordingly
					request.setAttribute("erreurs", "Échec d'authentification");
					request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
				}
			} catch (BLLException e) {
				// Handle BLLException, log or redirect as needed
				e.printStackTrace();
				request.setAttribute("erreurs", "Échec d'authentification");
				request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
			}
		}
	}


}
