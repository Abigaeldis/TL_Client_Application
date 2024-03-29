package filters;

import java.io.IOException;

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
 * Servlet Filter implementation class SessionFilter
 */

public class SessionFilter implements Filter {

    public SessionFilter() {

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

        if (session != null && session.getAttribute("utilisateur") != null) {
        	//Si utilisateur connecté, on laisse passer.
            chain.doFilter(request, response);
        } else {
        	//si l'utilisateur n'est pas connecté, renvoyer sur la page de connexion
        	//Enregistrer dans la session la page sur laquelle on était
        	session.setAttribute("previousPage", httpRequest.getRequestURI() + "?id=" + httpRequest.getParameter("id"));
            httpResponse.sendRedirect("Connexion ");
        }
    }

    public void destroy() {
        // Cleanup code if needed
    }
}
