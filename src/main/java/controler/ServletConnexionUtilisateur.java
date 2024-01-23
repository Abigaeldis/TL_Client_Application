package controler;

import java.io.IOException;

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
	    String utilisateur = request.getParameter("utilisateur");
	    String motdepasse = request.getParameter("motdepasse");
	    if ("Inscription".equals(action)) {
	        request.setAttribute("utilisateur", utilisateur);
	        request.setAttribute("motdepasse", motdepasse);
	        request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
	    } else if ("Connexion".equals(action)) {
	 
	        try {
	            UtilisateurBLL utilisateurBLL = new UtilisateurBLL();
	            // Validate user credentials and retrieve the user object
	            Utilisateur utilisateurObj = utilisateurBLL.authenticateUser(utilisateur, motdepasse, request);
	            if (utilisateurObj != null) {
	                // If the user is valid, store the user object in the session
	                request.getSession().setAttribute("utilisateur", utilisateurObj);
	                // Redirect to the index.jsp
	                response.sendRedirect("index.jsp");
	            } else {
	                // If the user is not valid, handle it accordingly
	                request.setAttribute("errorMessage", "Invalid credentials. Please try again.");
	                request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
	            }
	        } catch (BLLException e) {
	            // Handle BLLException, log or redirect as needed
	            e.printStackTrace();
	            response.sendRedirect("error.jsp"); // Redirect to an error page
	        }
	    }
	}


}
