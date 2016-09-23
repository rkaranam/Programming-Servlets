package org.pluralsight.demos.globalization;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GlobalizedSearchServlet")
public class GlobalizedSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GlobalizedSearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n.resourceBundle", request.getLocale());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("   <head>");
		out.println("       <title>" + resourceBundle.getString("SearchTitle") + "</title>");
		out.println("   </head>");
		out.println("   <body>");
		out.println("		<img src='" + resourceBundle.getString("Flag") + "'/>");		
		out.println("		<p>" + resourceBundle.getString("PromptLbl") + "</p>");
		out.println("		<form method='get' action='searchResults' name='searchForm'>");		
		out.println("		<p><input name='search' type='text'/></p>");
		out.println("		<p><input type='submit' name='btnSubmit' value='" + resourceBundle.getString("BtnSubmit") +  "'/></p>");
		out.println("		</form>");
		out.println("   </body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
