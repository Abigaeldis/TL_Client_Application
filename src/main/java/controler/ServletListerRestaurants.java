package controler;

import java.io.IOException;
import java.util.List;

import bll.BLLException;
import bll.RestaurantBLL;
import bo.Restaurant;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletListerRestaurants extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantBLL restaurantBll;
	
	public void init() throws ServletException {
		super.init();
		System.out.println("Initialisation du server");
		try {
			restaurantBll = new RestaurantBLL();
			System.out.println("Connexion réussie");
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 3. Exploitation des paramètres par le bll
		List<Restaurant> restaurants = null;
		try {
			restaurants = restaurantBll.selectAll();
		} catch (BLLException e) {
			e.printStackTrace();
		}

		// 4. Ajout des attributs éventuels à ma request
		request.setAttribute("restaurants", restaurants);

		// 5. Redirection vers la JSP choisie
		request.getRequestDispatcher("/WEB-INF/jsp/listeRestaurants.jsp").forward(request, response);;
	}
}
