package controler;

import java.io.IOException;

import bll.BLLException;
import bll.UtilisateurBLL;
import bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletAfficherUtilisateur
 */
public class ServletAfficherUtilisateur extends HttpServlet {
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
		System.out.println(idStr);

		// 2. Passage des paramètres dans le type voulu
		int id = Integer.parseInt(idStr);

		// 3. Exploitation des paramètres par le bll
		Utilisateur utilisateur = null;
		try {
			utilisateur = utilisateurBll.selectById(id);
		} catch (BLLException e) {
			e.printStackTrace();
		}

		// 4. Ajout des attributs éventuels à ma request
		request.setAttribute("utilisateur", utilisateur);

		// 5. Redirection vers la JSP choisie
		request.getRequestDispatcher("/WEB-INF/jsp/utilisateur.jsp").forward(request, response);
	}

}
