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
    	
        // Convert ServletRequest and ServletResponse to HttpServletRequest and HttpServletResponse
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Check if a session exists
        HttpSession session = httpRequest.getSession();
        
        // Retrieve Utilisateur object from the session
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        
        if (utilisateur != null) {
            // User is logged in, redirect to the "MonCompte" page
            httpResponse.sendRedirect("MonCompte?id=" + utilisateur.getId());
        } else {
            // User is not logged in, proceed with the request
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
        // Cleanup code if needed
    }
}
