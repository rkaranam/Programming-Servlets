package org.pluralsight.demos.sessions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GuestDetailsServlet")
public class GuestDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GuestDetailsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ")
							.append(request.getRequestURI());
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("username");
		
		String urlRewritingQueryString = "username=" + userName;

		out.println("<!DOCTYPE html>");
		out.println("   <head>");
		out.println("       <title>Guest Details</title>");
		out.println("   </head>");
		out.println("   <body>");
		out.println("		<h3>Welcome, " + userName + "</h3>");
		out.println("		<form name='guestMoreDetails' method='post' action='PreviewGuestDetailsServlet'>");
		out.println("			<p>We need more details like.. </p>");
		out.println("			<p>Email Id: <input type='text' name='email' /></p>");
		out.println("			<p>Phone: <input type='text' name='phone' /></p>");
		out.println("			<p><input type='hidden' name='username' value='" + userName + "'/></p>");
		out.println("			<p><input type='submit' name='btnSubmit' value='Submit Details' /></p>");
		out.println("		</form>");
		out.println("	<p><a href='PreviewGuestDetailsServlet?" + urlRewritingQueryString + "'>Preview Details</a></p>" );
		out.println("   </body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
