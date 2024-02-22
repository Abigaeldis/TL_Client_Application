package controler;

import java.io.IOException;

import bll.BLLException;
import bll.MessageBLL;
import bll.RestaurantBLL;
import bll.UtilisateurBLL;
import bo.Message;
import bo.Restaurant;
import bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletContacter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantBLL restaurantBll;
	private MessageBLL messageBll;
	private UtilisateurBLL utilisateurBll;
	
	public void init() throws ServletException {
		super.init();
		try {
			restaurantBll = new RestaurantBLL();
			utilisateurBll = new UtilisateurBLL();
			messageBll = new MessageBLL();
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
		request.getRequestDispatcher("/WEB-INF/jsp/messagerie.jsp").forward(request, response);
			}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("passage dans le POST du ServletContacter");
		
		// Etape 1 : Recuperer toutes les infos necessaires
		String idRestaurantStr = request.getParameter("idRestaurant");
		String titre = request.getParameter("titre");
		String corpsDuMessage = request.getParameter("corpsDuMessage");
		String idUtilisateurStr = request.getParameter("idUtilisateur");
				
		// Etape 2 : Passer les infos dans les types apropriés
		int idRestaurant  = Integer.parseInt(idRestaurantStr);
		int idUtilisateur  = Integer.parseInt(idUtilisateurStr);
		
		//Recuperer le restaurant puis l'utilisateur pour le constructeur message
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
		
		// Etape 3 : Realiser le traitement associé a ces infos
		Message messageCree = new Message(titre, corpsDuMessage, restaurant, utilisateur);
		
		try {
			messageCree = messageBll.insert(messageCree);
			
			// Etape 4 : Ajout des attributs eventuels a la requete
			request.setAttribute("restaurant", restaurant);
			request.setAttribute("message", messageCree);
			
			// 5. Redirection vers la JSP choisie
			request.getRequestDispatcher("/WEB-INF/jsp/confirmationMessage.jsp").forward(request, response);
			
		} catch (BLLException e) {
			//Récupération de la liste d'erreur s'il y en a pour affichage
			request.setAttribute("erreurs", e.getErreurs());
			request.setAttribute("restaurant", restaurant);
			request.getRequestDispatcher("/WEB-INF/jsp/messagerie.jsp").forward(request, response);
		}
		
	}

}
