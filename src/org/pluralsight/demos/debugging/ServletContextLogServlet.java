package org.pluralsight.demos.debugging;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletContextLogServlet")
public class ServletContextLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletContextLogServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ServletContext context = getServletContext();
		String param = request.getParameter("param");
		
		if (null != param && param.equals("") ) {
			context.log("No Message Received!", new IllegalStateException("Missing Parameter"));
		} else {
			context.log("Receieved message: " + param);
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("   <head>");
		out.println("       <title>Debugging Servlets using ServletContext</title>");
		out.println("   </head>");
		out.println("   <body>");
		context.log("Generating body for the response");
		out.println("		<h3>ServletContext Logging Demo</h3>");
		out.println("		<p>Message Logged: " + param + "</p>");
		context.log("Completed generating the response");
		out.println("   </body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
