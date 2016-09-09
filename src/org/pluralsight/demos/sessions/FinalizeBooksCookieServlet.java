package org.pluralsight.demos.sessions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FinalizeBooksCookieServlet")
public class FinalizeBooksCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FinalizeBooksCookieServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie: cookies) {
			out.println("<p>" + cookie.getName() + " : " + cookie.getValue() + "</p>");
		}
		
		String user = cookies[0].getValue();
		String username = Character.toUpperCase(user.charAt(0)) + user.substring(1);
		String email = cookies[1].getValue();
		String emailId = Character.toUpperCase(email.charAt(0)) + email.substring(1);
		
		out.println("<!DOCTYPE html>");
		out.println("   <head>");
		out.println("       <title>Sending Email..</title>");
		out.println("   </head>");
		out.println("   <body>");
		out.println("		<h2>Email Sent</h2>");
		out.println("		<p>Dear " + username + ",</p>");
		out.println("		<p>Confirmation mail is sent to " + emailId + "</p>");
		out.println("   </body>");
		out.println("</html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
