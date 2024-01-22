package controler;

import java.io.IOException;

import bll.BLLException;
import bll.RestaurantBLL;
import bo.Restaurant;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDetailRestaurant
 */
public class ServletDetailRestaurant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantBLL restaurantBll;
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			restaurantBll = new RestaurantBLL();
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		// 5. Redirection vers la JSP choisie
		request.getRequestDispatcher("/WEB-INF/jsp/detailRestaurant.jsp").forward(request, response);
	}
}
