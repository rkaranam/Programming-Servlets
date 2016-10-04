package org.pluralsight.demos.async;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = {"/AsyncProgressServlet"},
		asyncSupported = true
	)
public class AsyncProgressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AsyncProgressServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("   <head>");
		out.println("       <title>Async Progress Servlet</title>");
		out.println("   </head>");
		out.println("   <body>");
		out.println("		<p>Entering doGet() method, Thread Name: " + Thread.currentThread().getName() + "</p>");
		out.println("<progress id='progress' max='100'></progress>");
		
		try {
			AsyncContext asyncContext = request.startAsync();
			asyncContext.start(() -> {
				out.println("<p>Executing long running task using Thread: " + Thread.currentThread().getName() + "</p>");
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
				asyncContext.complete();
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		out.println("		<p>Exiting doGet() method, Thread Name: " + Thread.currentThread().getName() + "</p>");
		out.println("   </body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
