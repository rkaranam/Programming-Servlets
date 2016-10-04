package org.pluralsight.demos.async;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TraditionalProgressServlet")
public class TraditionalProgressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TraditionalProgressServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("   <head>");
		out.println("       <title>Traditional Progress Servlet</title>");
		out.println("   </head>");
		out.println("   <body>");
		out.println("		<p>Entering doGet() method, Thread Name: " + Thread.currentThread().getName() + "</p>");
		out.println("<progress id='progress' max='100'></progress>");
		int i = 0;
		while(i <= 100) {
			out.println("<script>document.getElementById('progress').value = '" + i++ + "';</script>");
			out.flush();
			try {
				Thread.sleep(100);
			} catch(InterruptedException ex) {

			}
		}
		out.println("<p>Completed the long running task!</p>");
		out.println("		<p>Exiting doGet() method, Thread Name: " + Thread.currentThread().getName() + "</p>");
		out.println("   </body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
