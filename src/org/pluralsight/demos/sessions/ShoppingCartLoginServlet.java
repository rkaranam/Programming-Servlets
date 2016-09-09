package org.pluralsight.demos.sessions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ShoppingCartLoginServlet")
public class ShoppingCartLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShoppingCartLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ")
							.append(request.getContextPath())
							.append(request.getServletPath());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String emailId = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		HttpSession loginSession = request.getSession();
		loginSession.setAttribute("Username", username);
		loginSession.setAttribute("Email", emailId);
		loginSession.setAttribute("Mobile", mobile);		
		
		out.println("<p>Hold your horses! Displaying items.. </p>");

		response.setHeader("Refresh", "10; URL=/ServletApplicationsDemo/ShoppingCartDisplayItemsServlet");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
