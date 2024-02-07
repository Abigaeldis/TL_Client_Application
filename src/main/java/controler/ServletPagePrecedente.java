package controler;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ServletPagePrecedente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the referrer URL from the request header
        String referer = request.getHeader("referer");

        // Check if the referer is not null and not empty
        if (referer != null && !referer.isEmpty()) {
            // Redirect the user back to the previous page
            response.sendRedirect(referer);
        } else {
            // If the referer is not available, redirect to a default page
            response.sendRedirect("index.jsp");
        }
    }
}
