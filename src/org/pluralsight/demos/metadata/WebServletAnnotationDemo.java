package org.pluralsight.demos.metadata;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name = "WebServletDemo",
		description = "Web Servlet Annotation Demo",
		initParams = {
				@WebInitParam(name = "user", value = "Raja Sekhar"), 
				@WebInitParam(name = "email", value = "raj@gmail.com")
			},
		urlPatterns = {"/WebServletAnnotationDemo", "/WebServletDemo", "/helloAnnotations"}
	)
public class WebServletAnnotationDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WebServletAnnotationDemo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("   <head>");
		out.println("       <title>WebServlet Annotation Demo</title>");
		out.println("   </head>");
		out.println("   <body>");
		out.println("		<h2>WebServlet Annotation Demo.</h2>");
		String user = getServletConfig().getInitParameter("user");
		String email = getServletConfig().getInitParameter("email");
		out.println("		<p>Initial User: " + user + " </p>");
		out.println("		<p>Initial Email: " + email + " </p>");
		out.println("   </body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
