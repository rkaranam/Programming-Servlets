package org.pluralsight.demos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StatusCodeDemo")
public class StatusCodeDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int unauthorised = 401;
       
    public StatusCodeDemo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String url = request.getParameter("url");
		String siteName;
		
		if( null != url && url.equals("pluralsight")) {
			siteName = "http://www.pluralsight.com";
			
			response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", "http://www.howtogeek.com");
		} 
		else if(null != url && url.equals("udemy")) {
			siteName = "http://www.udemy.com";
			response.sendRedirect(siteName);
		}
		else {
			response.sendError(unauthorised, "Unauthorised Request: Requires login!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}

}
