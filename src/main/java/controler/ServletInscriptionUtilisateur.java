package controler;

import java.io.IOException;

import bll.BLLException;
import bll.UtilisateurBLL;
import bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletInscriptionUtilisateur
 */
public class ServletInscriptionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurBLL utilisateurBLL;
	
	public void init() throws ServletException {
		try {
			utilisateurBLL = new UtilisateurBLL();
		} catch (BLLException e) {
			throw new ServletException("Error initializing ServletInsertUtilisateur", e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String utilisateur = request.getParameter("utilisateur");
		String nomdefamille = request.getParameter("nomdefamille");
		String motdepasse = request.getParameter("motdepasse");
		String mail = request.getParameter("mail");
		String telephone = request.getParameter("telephone");
		String adresse = request.getParameter("adresse");


		try {
		    Utilisateur newUtilisateur = utilisateurBLL.insert(utilisateur,nomdefamille, motdepasse, mail, telephone, adresse);
		    System.out.println("Inserted Utilisateur: " + utilisateur + " " + mail);

		    // Set a success message in the request attribute
		    request.setAttribute("utilisateur", newUtilisateur);

		    // Forward to the success JSP page
		    request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (BLLException e) {
		    // Handle exception
		    e.printStackTrace(); // You might want to log this to a proper logging framework

		    // Set an error message in the request attribute
		    request.setAttribute("errorMessage", "Error inserting utilisateur");

		    // Forward to the error JSP page
		    request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		}

	}

}
