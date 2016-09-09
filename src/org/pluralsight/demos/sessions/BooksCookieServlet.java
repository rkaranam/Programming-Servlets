package org.pluralsight.demos.sessions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BooksCookieServlet")
public class BooksCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BooksCookieServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// response.getWriter().append("Served at: ").append(request.getContextPath()).append("\n");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String user = request.getParameter("user");
		String email = request.getParameter("email");
		
		Cookie userData = new Cookie("user", user);
		Cookie emailData = new Cookie("email", email);		
		
		String[] requestedBooks = request.getParameterValues("requestedBooks");
		// out.println("<p>Requested Books : " + String.join(", ", requestedBooks) + "</p>");
		
		
		List<String> availableRequestedBooks = new ArrayList<>();
		List<String> unAvailableRequestedBooks = new ArrayList<>();
		
		for(AvailableBooks book : AvailableBooks.values()) {
			for(int i = 0; i < requestedBooks.length; i++) {
				if(requestedBooks[i].equalsIgnoreCase(book.toString())){
					availableRequestedBooks.add(book.bookName());
				} else {
					unAvailableRequestedBooks.add(book.bookName());
				}
			}
		}
		Cookie requestedBooksData = new Cookie("requestedBooks", availableRequestedBooks.toString());
		
		out.println("<!DOCTYPE html>");
		out.println("   <head>");
		out.println("       <title>Available Books</title>");
		out.println("   </head>");
		out.println("   <body>");
		out.println("		<h4>Only these books are available: </h4>");
		for (String book : availableRequestedBooks) {
			out.println("		<p>" + book + "</p>");
		}
		
		response.addCookie(userData);
		response.addCookie(emailData);
		response.addCookie(requestedBooksData);
		
		out.println("		<form name='finalizeBooks' method='post' action='FinalizeBooksCookieServlet'>");
		out.println("			<p><input type='submit' value='Finalize Books'/></p>");
		out.println("		</form>");
		out.println("   </body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
