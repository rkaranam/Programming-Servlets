package org.pluralsight.demos.globalization;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LanguageSettingsDemoServlet")
public class LanguageSettingsDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LanguageSettingsDemoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("   <head>");
		out.println("       <title></title>");
		out.println("   </head>");
		out.println("   <body>");
		out.println("		<h3>Different ways of setting language:</h3>");
		
		// Method 1: Using Single Parameter Constructor
		Locale locale1 = new Locale("fr");
		out.println("<p>Language Set using Single parameter Constructor: " + locale1 + "</p>");
		
		// Method 2: Using Two Parameters Constructor
		Locale locale2 = new Locale("fr", "CANADA");
		out.println("<p>Language Set using Two parameters Constructor: " + locale2 + "</p>");
		
		// Method 3: Using Three Parameters Constructor
		Locale locale3 = new Locale("no", "NORWAY", "NY");
		out.println("<p>Language Set using Three parameters Constructor: " + locale3 + "</p>");
		
		// Method 4: Using Builder
		Locale locale4 = new Locale.Builder().setLanguage("en").setRegion("GB").build();
		out.println("<p>Language Set using Locale Builder: " + locale4 + "</p>");
		
		// Method 5: Using Language Tag
		Locale locale5 = Locale.forLanguageTag("en-GB");
		out.println("<p>Language Set using Language Tag: " + locale5 + "</p>");
		
		// Method 6: Using Locale Constants
		Locale locale6 = Locale.FRANCE;
		out.println("<p>Language Set using Locale Constants: " + locale6 + "</p>");
		
		out.println("   </body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
