package controler;

import java.io.IOException;
import java.util.List;

import bll.BLLException;
import bll.UtilisateurBLL;
import bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ServletInscriptionUtilisateur extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UtilisateurBLL utilisateurBLL;

    public void init() throws ServletException {
        try {
            utilisateurBLL = new UtilisateurBLL();
        } catch (BLLException e) {
            throw new ServletException("Error initializing ServletInsertUtilisateur", e);
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String motdepasse = request.getParameter("motdepasse");
        String mail = request.getParameter("mail");
        String telephone = request.getParameter("telephone");
        String adresse = request.getParameter("adresse");
        try {
        	Utilisateur newUtilisateur = utilisateurBLL.insert(nom, prenom, mail, motdepasse, telephone,
                    adresse);
            HttpSession session = request.getSession();
            //Connexion automatique à l'issue de l'inscription
            session.setAttribute("utilisateur", newUtilisateur);
            //Si l'utilisateur reste inactif 30min, on le déconnecte.
            int sessionTimeoutInSeconds = 30 * 60;
            session.setMaxInactiveInterval(sessionTimeoutInSeconds);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (BLLException e) {
            e.printStackTrace();
            //Récupération de la liste d'erreurs pour leur affichage
            request.setAttribute("erreurs", e.getErreurs());
            request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
        }
    }
}
