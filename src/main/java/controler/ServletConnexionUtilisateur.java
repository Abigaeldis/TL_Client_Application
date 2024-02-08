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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
		}
		try {
			UtilisateurBLL utilisateurBLL = new UtilisateurBLL();
			Utilisateur utilisateurObj = utilisateurBLL.authenticateUser(mail, motdepasse, request);
			if (utilisateurObj != null) {

				request.getSession().setAttribute("utilisateur", utilisateurObj);


				String previousPage = (String) request.getSession().getAttribute("previousPage");

			
				request.getSession().removeAttribute("previousPage");

				// Redirect to the previous page
				if (previousPage != null && !previousPage.isEmpty()) {
					response.sendRedirect(previousPage);
				} else {
					// If the user is not valid, handle it accordingly
					request.setAttribute("erreurs", "Échec d'authentification");
					request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
				}
			} 
		} catch (BLLException e) {
				// Handle BLLException, log or redirect as needed
				e.printStackTrace();
				request.setAttribute("erreurs", "Échec d'authentification");

				request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
			}
	}
}
