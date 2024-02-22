package controler;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ServletPagePrecedente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer l'url du header
        String referer = request.getHeader("referer");

        // Si le referer n'est pas nul
        if (referer != null && !referer.isEmpty()) {
            // Redirection de l'utilisateur vers la page précédente
            response.sendRedirect(referer);
        } else {
            // Sinon, redirection vers l'accueil
            response.sendRedirect("index.jsp");
        }
    }
}
