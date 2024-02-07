package controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bll.BLLException;
import bll.HoraireBLL;
import bll.RestaurantBLL;
import bo.Horaire;
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
	private HoraireBLL horaireBll;
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			restaurantBll = new RestaurantBLL();
			horaireBll = new HoraireBLL();
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
		
		List<Horaire> horaires = new ArrayList<>();
		List<Horaire> horairesRestaurant = new ArrayList<>();
		
		try {
			horaires = horaireBll.selectAll();
			for (Horaire current : horaires) {
				
				if (current.getRestaurant().getNom().equals(restaurant.getNom())) {
					horairesRestaurant.add(current);
				}
			}
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		Map<String, List<String>> horairesGroupes = new HashMap<>();
		String[] jours = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
        // Parcourir la liste des horaires
        for (Horaire current : horairesRestaurant) {
            String jour = current.getJour(); // Jour de la semaine

            // Construire la plage horaire
            String plageHoraire = current.getHeureDeDebut().toString() + "-" + current.getHeureDeFin().toString();
            
            // Vérifier si le jour existe déjà dans la map
            if (horairesGroupes.containsKey(jour)) {
                // Ajouter la plage horaire à la liste existante
                horairesGroupes.get(jour).add(plageHoraire);
            } else {
                // Créer une nouvelle liste et ajouter la plage horaire
                List<String> nouvellesHoraires = new ArrayList<>();
                nouvellesHoraires.add(plageHoraire);
                horairesGroupes.put(jour, nouvellesHoraires);
            }
        }
		
		// 4. Ajout des attributs éventuels à ma request
		request.setAttribute("restaurant", restaurant);
		request.setAttribute("jours", jours);
		request.setAttribute("horairesGroupes", horairesGroupes);
		request.setAttribute("horairesRestaurant", horairesRestaurant);
		
		// 5. Redirection vers la JSP choisie
		request.getRequestDispatcher("/WEB-INF/jsp/detailRestaurant.jsp").forward(request, response);
	}
}
