package controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import bll.BLLException;
import bll.UtilisateurBLL;
import bo.Utilisateur;

/**
 * Servlet implementation class ServletSupprimerUtilisateur
 */
public class ServletSupprimerUtilisateur extends HttpServlet {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String idStr = request.getParameter("id");

		int id = Integer.parseInt(idStr);
		System.out.println(id);

		try {
			System.out.println("passage dans le try supp");
			utilisateurBll.delete(id);

			// REFAIRE CREATION TABLE AVEC ON DELETE CASCADE
		} catch (BLLException e) {
			System.out.println(e.getMessage());
			request.setAttribute("erreur", e);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}

	}
}
