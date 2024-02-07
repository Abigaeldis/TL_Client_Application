package controler;

import java.io.IOException;

import bll.BLLException;
import bll.UtilisateurBLL;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
			
			utilisateurBll.delete(id);
			System.out.println("utilisateur d'id " + id + "supprimé");
			response.sendRedirect("deconnexion");

		} catch (BLLException e) {
			System.out.println(e.getMessage());
			request.setAttribute("erreur", e);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}

	}
}
