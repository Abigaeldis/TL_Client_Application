package filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Error404Filter
 */
public class Error404Filter extends HttpFilter implements Filter {
	
	private static final long serialVersionUID = 1L;

	public void init(FilterConfig fConfig) throws ServletException {
	        // Initialization code, if needed
	    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	        throws IOException, ServletException {
	    System.out.println("entrer filtre 404");
	    HttpServletRequest httpRequest = (HttpServletRequest) request;
	    HttpServletResponse httpResponse = (HttpServletResponse) response;

	    System.out.println(httpResponse.getStatus());
	    
	    if (httpResponse.getStatus() == HttpServletResponse.SC_NOT_FOUND) {
	        // Forward the request to the custom 404 page
	        httpRequest.getRequestDispatcher("/error404.jsp").forward(httpRequest, httpResponse);
	    } else {
	        // Continue with the request chain
	        chain.doFilter(request, response);
	    }
	}


	}


