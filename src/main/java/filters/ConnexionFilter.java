package filters;

import java.io.IOException;

import bo.Utilisateur;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class ConnexionFilter
 */
public class ConnexionFilter implements Filter {

    public ConnexionFilter() {

    }

    public void init(FilterConfig fConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
    	
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession();
        
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        
        if (utilisateur != null) {
            httpResponse.sendRedirect("MonCompte?id=" + utilisateur.getId());
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {

    }
}
