package org.pluralsight.demos.sessions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PreviewGuestDetailsServlet")
public class PreviewGuestDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PreviewGuestDetailsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getRequestURI());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		out.println("<!DOCTYPE html>");
		out.println("   <head>");
		out.println("       <title>Preview Details</title>");
		out.println("   </head>");
		out.println("   <body>");
		out.println("		<h3>Your details: </h3>");
		out.println("		<form name='saveGuestDetails' method='post' action='saveGuestDetailsServlet'>");
		out.println("			<p>Username : " + userName + "</p>");
		out.println("			<p>Email Id : " + email + "</p>");
		out.println("			<p>Phone No. : " + phone + "</p>");
		out.println("			<input type='hidden' name='username' value='" + userName + "' />");
		out.println("			<input type='hidden' name='email' value='" + email + "' />");
		out.println("			<input type='hidden' name='phone' value='" + phone + "' />");
		out.println("		</form>");
		out.println("   </body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
