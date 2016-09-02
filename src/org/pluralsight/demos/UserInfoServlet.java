package org.pluralsight.demos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public UserInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		response.setContentType("text/html");		
		PrintWriter output = response.getWriter();
		
		// getParameter demo
		output.append("<h3>Reading QueryString data using 'String getParameter(String parameter)' method:</h3>");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		output.append("<div>");
		output.append("<p><b>First Name : " + firstName + "</b></p>");
		output.append("<p><b>Last Name : " + lastName + "</b></p>");
		output.append("</div>");
		
		// getParameterNames demo
		output.append("<h3>Reading QueryString data using 'Enumeration getParameterNames()' method:</h3>");
		Enumeration<String> paramNames = request.getParameterNames();

		output.append("<div>");
		while(paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			String paramValue = request.getParameter(paramName);
			output.append("<p><b>" + paramName + ": " + paramValue + "</b></p>");
		}
		output.append("</div>");
		
		// getParameterMap demo
		output.append("<h3>Reading QueryString data using 'Map getParameterMap()' method:</h3>");
		Map<String, String[]> paramMap = request.getParameterMap();
		Set<String> paramNamesSet = paramMap.keySet();
		
		output.append("<div>");
		for (String paramName : paramNamesSet) {
			String[] paramValues = paramMap.get(paramName);
			output.println("<p><b>" + paramName + ": ");
			for(int i = 0; i < paramValues.length; i++) {
				output.println(paramValues[i]);
			}
			output.println("</b></p>");
		}
		output.append("<div>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
	}

}
