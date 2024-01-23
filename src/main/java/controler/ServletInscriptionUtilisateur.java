package controler;

import java.io.IOException;

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
            System.out.println("Inserted Utilisateur: " + prenom + " " + mail);

            // request.getSession().setAttribute("name", newUtilisateur);
            HttpSession session = request.getSession();
            session.setAttribute("utilisateur", newUtilisateur);
            int sessionTimeoutInSeconds = 30 * 60;
            session.setMaxInactiveInterval(sessionTimeoutInSeconds);


            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (BLLException e) {

            e.printStackTrace();
            request.setAttribute("errorMessage", "Error inserting utilisateur");
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
