package controler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import bll.BLLException;
import bll.HoraireBLL;
import bll.ReservationBLL;
import bll.RestaurantBLL;
import bll.UtilisateurBLL;
import bo.Horaire;
import bo.Restaurant;
import bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ServletReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantBLL restaurantBll;
	private UtilisateurBLL utilisateurBll;
	private ReservationBLL reservationBll;
	private HoraireBLL horaireBll;
	
	public void init() throws ServletException {
		super.init();
		try {
			restaurantBll = new RestaurantBLL();
			utilisateurBll = new UtilisateurBLL();
			reservationBll = new ReservationBLL();
			horaireBll = new HoraireBLL();
			
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idRestaurantStr = request.getParameter("id");
		int idRestaurant = Integer.parseInt(idRestaurantStr);
		
		Restaurant restaurant = null;
		try {
			restaurant = restaurantBll.selectById(idRestaurant);
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
		
		// 4. Ajout des attributs éventuels à ma request
		request.setAttribute("restaurant", restaurant);
		request.setAttribute("horairesRestaurant", horairesRestaurant);
		request.getRequestDispatcher("/WEB-INF/jsp/connected/reservation.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récup des données
		String dateReservationStr = request.getParameter("date");
		String nbPersonneStr = request.getParameter("nbPersonne");
		String idRestaurantStr = request.getParameter("id");
		String idUtilisateurStr = request.getParameter("idUtilisateur");
		//passage des String en int et date en localDateTime
		int idRestaurant = Integer.parseInt(idRestaurantStr);
		int idUtilisateur  = Integer.parseInt(idUtilisateurStr);
		int nbPersonne = Integer.parseInt(nbPersonneStr);
		LocalDateTime dateReservation = LocalDateTime.parse(dateReservationStr);
		
		Restaurant restaurant = null;
		try {
			restaurant = restaurantBll.selectById(idRestaurant);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		Utilisateur utilisateur = null;
		try {
			utilisateur = utilisateurBll.selectById(idUtilisateur);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		//Ajout des horaires du restaurant
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
		
		try {
			reservationBll.insert(dateReservation, nbPersonne, utilisateur, restaurant,horaires);
			request.setAttribute("dateReservation", dateReservation);
			request.setAttribute("nbPersonne", nbPersonne);
			request.setAttribute("restaurant", restaurant);
			request.getRequestDispatcher("/WEB-INF/jsp/connected/demandeResOk.jsp").forward(request, response);
		} catch (BLLException e) {
			e.printStackTrace();
			request.setAttribute("erreurs", e.getErreurs());
			request.setAttribute("restaurant", restaurant);
			request.setAttribute("horairesRestaurant", horairesRestaurant);
			request.getRequestDispatcher("/WEB-INF/jsp/connected/reservation.jsp").forward(request, response);
		}
	}

}
