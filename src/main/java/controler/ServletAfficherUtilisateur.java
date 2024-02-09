package controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bll.BLLException;
import bll.MessageBLL;
import bll.UtilisateurBLL;
import bo.Message;
import bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAfficherUtilisateur
 */
public class ServletAfficherUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurBLL utilisateurBll;
	private MessageBLL messageBll;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			utilisateurBll = new UtilisateurBLL();
			messageBll = new MessageBLL();
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Récupération des paramètres
		String idStr = request.getParameter("id");
//		System.out.println(idStr);

		// 2. Passage des paramètres dans le type voulu
		int id = Integer.parseInt(idStr);

		// 3. Exploitation des paramètres par le bll
		Utilisateur utilisateur = null;
		try {
			utilisateur = utilisateurBll.selectById(id);
			List<Message> messages = messageBll.selectAll();
			List<Message> messagesUtilisateur = new ArrayList<>();
			for (Message current : messages) {
				if (current.getUtilisateur().getId() == id) {
					messagesUtilisateur.add(current);
				}
			}
			// 4. Ajout des attributs éventuels à ma request
			request.setAttribute("utilisateur", utilisateur);
			request.setAttribute("messages", messagesUtilisateur);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		// 5. Redirection vers la JSP choisie
		request.getRequestDispatcher("/WEB-INF/jsp/utilisateur.jsp").forward(request, response);
	}

}
