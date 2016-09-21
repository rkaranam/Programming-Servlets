package org.pluralsight.demos.debugging;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet("/Log4j2DemoServlet")
public class Log4j2DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = null;
       
    public Log4j2DemoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		logger = LogManager.getLogger(Log4j2DemoServlet.class); 
		logger.info("Log Info: Entered into doGet() method for processing the request");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("   <head>");
		out.println("       <title>Log4j Demo</title>");
		out.println("   </head>");
		out.println("   <body>");
		logger.info("Log Info: Started generating the response body");
		out.println("		<p>Logger name: " + logger.getName() + "</p>");
		
		String param = request.getParameter("param");
		if( null == param || param.isEmpty() ) {
			out.println("<p>Error: Please Provide Value to the Parameter</p>");
			logger.error("Log Info: Parameter is missing in request!");
		} else {
			out.println("<p>Page is requested by " + param + "</p>");
			logger.warn("Log Info: Page is requested by " + param);
		}
		
		logger.info("Log Info: Completed generating the response body");
		out.println("   </body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
