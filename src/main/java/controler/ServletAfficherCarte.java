package controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bll.BLLException;
import bll.CarteBLL;
import bll.PlatBLL;
import bo.Carte;
import bo.Plat;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class ServletAfficherCarte extends HttpServlet {	
	private static final long serialVersionUID = 1L;
	private CarteBLL carteBll;
	private static PlatBLL platBll;
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			carteBll = new CarteBLL();
			platBll = new PlatBLL();
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Récupération des paramètres
//		String idStr = request.getParameter("id");
		String idStr = "1";
		
		// 2. Passage des paramètres dans le type voulu
		int id = Integer.parseInt(idStr);
		
		// 3. Exploitation des paramètres par le bll
		Carte carte = null;
		
		
		try {
			carte = carteBll.selectById(id);
		} catch (BLLException e) {
			e.printStackTrace();
		}

		List<Plat> items;
		List<Plat> entrees = new ArrayList<>();
		List<Plat> plats = new ArrayList<>();
		List<Plat> desserts = new ArrayList<>();
		List<Plat> boissons = new ArrayList<>();
		try {
			items = platBll.selectAll();
			for (Plat current : items) {
				if (current.getCarte().getId()==carte.getId()) {
					switch (current.getType()) {
					case "entrée" :
						entrees.add(current);
					
						break;
					case "plat" :
						plats.add(current);
				
						break;
					case "dessert" :
						desserts.add(current);
					
						break;
					case "boisson" :
						boissons.add(current);
					
						break;
					default :
//						System.out.println(current);
						break;
					}
				}
			}
			
		} catch (BLLException e) {
			System.out.println("Une erreur est survenue :");
			e.printStackTrace();
		}
	
		// 4. Ajout des attributs éventuels à ma request
		request.setAttribute("carte", carte);
		request.setAttribute("entrees", entrees);
		request.setAttribute("plats", plats);
		request.setAttribute("desserts", desserts);
		request.setAttribute("boissons", boissons);
		
		// 5. Redirection vers la JSP choisie
		request.getRequestDispatcher("/WEB-INF/jsp/carte.jsp").forward(request, response);
	}
}




