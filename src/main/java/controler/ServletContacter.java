package controler;

import java.io.IOException;

import bll.BLLException;
import bll.RestaurantBLL;
import bo.Restaurant;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletContacter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantBLL restaurantBll;
	
	public void init() throws ServletException {
		super.init();
		try {
			restaurantBll = new RestaurantBLL();
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// A placer sur la carte du restaurant (accueil), lorsque l'utilisateur souhaite contacter le restaurant selectionné
		
		// 1 ---- Je dois pouvoir récupérer l'id de l'utilisateur ou session ->
		
		// 2 ---- Je dois pouvoir récupérer l'id du restaurant depuis lequel je souhaite accéder au formulaire de contact
		
		
		
		// 1. Récupération des paramètres
		String idStr = request.getParameter("id");
		
		// 2. Passage des paramètres dans le type voulu
		int id = Integer.parseInt(idStr);
		
		// 3. Exploitation des paramètres par le bll
		Restaurant restaurant = null;
		try {
			restaurant = restaurantBll.selectById(id);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		// 4. Ajout des attributs éventuels à ma request
		request.setAttribute("restaurant", restaurant);
		
		System.out.println("passage dans le GET du ServletContacter puis direction messagerie.jsp");
		
		// 5. Redirection vers la JSP choisie
		request.getRequestDispatcher("/WEB-INF/jsp/messagerie.jsp").forward(request, response);
			}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Post de l'envoi du message dans "messagerie.jsp"
		
		
	
	
	}

}
