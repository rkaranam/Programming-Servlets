package org.pluralsight.demos.sessions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ShoppingCartDisplayItemsServlet")
public class ShoppingCartDisplayItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShoppingCartDisplayItemsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath()).append(request.getServletPath());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("Username");
		String emailId = (String) session.getAttribute("Email");
		String phoneNumber = (String) session.getAttribute("Mobile");
		
		System.out.println("From ShoppingCartDisplayItemsServlet: Username - " + userName + ", EmailId - " + emailId + ", Mobile - " + phoneNumber);
		
		Map<String, Integer> items = new HashMap<>();
		items.put("Reebok Shoes", 650);
		items.put("Skykar Bag", 780);
		items.put("Lenovo Backpack", 1390);
		items.put("B50-70 Laptop Charger", 2800);
		
		out.println("<!DOCTYPE html>");
		out.println("   <head>");
		out.println("       <title>Items Catalog</title>");
		out.println("   </head>");
		out.println("   <body>");
		out.println("		<h2>Items Catalog</h2>");
		out.println("		<table name='items' cellpadding='5' cellspacing='5'>");
		out.println("			<tr><th>S.No.</th><th>Item</th><th>Price</th><th>Quantity</th></tr>");
		
		int i = 0;
		for (Map.Entry<String, Integer> item : items.entrySet()) {
			out.println("<tr><td>" + (++i) + "</td><td>" + item.getKey() + "</td><td>" + item.getValue() 
						+ "</td><td><input type='button' name='addToCart' value='Add To Cart'/></td></tr></p>");			
		}
		out.println("		</table>");
		out.println("		<p></p>");
		out.println("   </body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
