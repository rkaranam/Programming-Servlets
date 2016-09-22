package org.pluralsight.demos.globalization;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DetectLocaleServlet")
public class DetectLocaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DetectLocaleServlet() {
        super();
    }

	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Locale locale = request.getLocale();
		
		String language = locale.getLanguage();
		String country = locale.getCountry();
		String displayLanguage = locale.getDisplayLanguage();
		String displayCountry = locale.getDisplayCountry();
		String displayName = locale.getDisplayName();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("   <head>");
		out.println("       <title>Detecting Locale</title>");
		out.println("   </head>");
		out.println("   <body>");
		out.println("		<h2>Locale Details:</h2>");
		out.println("		<p>Language: " + language + "</p>");
		out.println("		<p>Country: " + country + "</p>");
		out.println("		<p>Display Language: " + displayLanguage + "</p>");
		out.println("		<p>Display Country: " + displayCountry + "</p>");
		out.println("		<p>Display Name: " + displayName + "</p>");
		out.println("		<hr>");
		Locale[] availableLocales = locale.getAvailableLocales();
		for(Locale otherLocale: availableLocales) {
			out.println("<p>" + "Display Name: "  + otherLocale.getDisplayName() + "</p>");
			out.println("<p>" + "Language Code: "  + otherLocale.getLanguage() + " and Language: " + otherLocale.getDisplayLanguage() + "</p>");
			out.println("<p>" + "Country Code: "  + otherLocale.getCountry() + " and Country: " + otherLocale.getDisplayCountry() + "</p>");
			if(!otherLocale.getScript().isEmpty()) {
				out.println("<p>" + "Script Code: "  + otherLocale.getScript() + " and Script Name: " + otherLocale.getDisplayScript() + "</p>");				
			}
			if(!otherLocale.getVariant().isEmpty()) {
				out.println("<p>" + "Variant Code: "  + otherLocale.getVariant() + " and Variant Name: " + otherLocale.getDisplayVariant() + "</p>");				
			}
			out.println("<hr>");
		}
		out.println("   </body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
