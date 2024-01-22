package controler;

import java.io.IOException;

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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getParameter("action");
	    String utilisateur = request.getParameter("utilisateur");
	    String motdepasse = request.getParameter("motdepasse");
	    if ("Inscription".equals(action)) {
	        request.setAttribute("utilisateur", utilisateur);
	        request.setAttribute("motdepasse", motdepasse);
	        request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
	    } else if ("Connexion".equals(action)) {
	        // faire la connexion
	    }
	   
	}


}
