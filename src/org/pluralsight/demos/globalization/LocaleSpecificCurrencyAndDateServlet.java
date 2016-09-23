package org.pluralsight.demos.globalization;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LocaleSpecificCurrencyAndDateServlet")
public class LocaleSpecificCurrencyAndDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LocaleSpecificCurrencyAndDateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("   <head>");
		out.println("       <title>Currency and Date Settings</title>");
		out.println("   </head>");
		out.println("   <body>");
		out.println("		<h3>Setting Date and Currency based on locale:</h3>");
		
		long number = 5505345L;
		
		NumberFormat numberFormatDefault = NumberFormat.getInstance();
		out.println("<p>Number Format using Default Locale: " + numberFormatDefault.format(number) + "</p>");
		
		NumberFormat numberFormatFrench = NumberFormat.getInstance(Locale.FRANCE);
		out.println("<p>Number Format using French Locale: " + numberFormatFrench.format(number) + "</p>");
		
		NumberFormat numberFormatJapan = NumberFormat.getInstance(Locale.JAPAN);
		out.println("<p>Number Format using Japan Locale: " + numberFormatJapan.format(number) + "</p>");
		
		NumberFormat numberFormatDefaultCurrency = NumberFormat.getCurrencyInstance();
		out.println("<p>Currency Format using Default Locale: " + numberFormatDefaultCurrency.format(number) + "</p>");
		
		NumberFormat numberFormatLocaleCurrency = NumberFormat.getCurrencyInstance(Locale.UK);
		out.println("<p>Currency Format using UK Locale: " + numberFormatLocaleCurrency.format(number) + "</p>");
		
		Currency japanCurrency = Currency.getInstance(Locale.JAPAN);
		out.println("<p>Currency Format using Japan Locale: " + numberFormatDefault.format(number) +
				"<br>Currency Display Name: " + japanCurrency.getDisplayName() +
				"<br>Currency Currency Code: " + japanCurrency.getCurrencyCode() + "</p>");
		
		Date todayDate = new Date();
		
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.FRENCH);
		out.println("<p>Date Format using French Locale: " + dateFormat.format(todayDate) + "</p>");
		
		DateFormat canadaDateFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.CANADA);
		out.println("<p>Date Format using Canada Locale: " + canadaDateFormat.format(todayDate) + "</p>");
		
		DateFormat germanyDateFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.GERMANY);
		out.println("<p>Date Format using Singapore Locale: " + germanyDateFormat.format(todayDate) + "</p>");
		
		out.println("		<p></p>");
		out.println("   </body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
