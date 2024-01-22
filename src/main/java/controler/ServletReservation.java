package controler;

import java.io.IOException;
import java.time.LocalDateTime;

import bll.BLLException;
import bll.ReservationBLL;
import bll.RestaurantBLL;
import bll.UtilisateurBLL;
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
	
	public void init() throws ServletException {
		super.init();
		try {
			restaurantBll = new RestaurantBLL();
			utilisateurBll = new UtilisateurBLL();
			reservationBll = new ReservationBLL();
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
		
		request.setAttribute("restaurant", restaurant);
		request.getRequestDispatcher("/WEB-INF/jsp/connected/reservation.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récup des données
		String dateReservationStr = request.getParameter("date");
		System.out.println(dateReservationStr);
		String nbPersonneStr = request.getParameter("nbPersonne");
		String idRestaurantStr = request.getParameter("id");
		
		//passage des String en int et date en localDateTime
		int idRestaurant = Integer.parseInt(idRestaurantStr);
		int nbPersonne = Integer.parseInt(nbPersonneStr);
		LocalDateTime dateReservation = LocalDateTime.parse(dateReservationStr);
		System.out.println(dateReservation);
		
		Restaurant restaurant = null;
		try {
			restaurant = restaurantBll.selectById(idRestaurant);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		Utilisateur utilisateur = null;
		try {
			utilisateur = utilisateurBll.selectById(1);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		try {
			reservationBll.insert(dateReservation, nbPersonne, utilisateur, restaurant);
			System.out.println("Insertion réussie");
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}

}
