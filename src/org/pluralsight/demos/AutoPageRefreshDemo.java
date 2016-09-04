package org.pluralsight.demos;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AutoPageRefreshDemo")
public class AutoPageRefreshDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AutoPageRefreshDemo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setIntHeader("Refresh", 3);
		
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("E dd:MM:yyyy 'at' hh:mm:ss a");
		String currentDateAndTime = sdf.format(currentDate);
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("   <head>");
		out.println("       <title>Auto Page Refresh</title>");
		out.println("   </head>");
		out.println("   <body>");
		out.println("		<p>Page Refreshed at : " + currentDateAndTime + ".</p>");
		out.println("   </body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}

}
