package org.pluralsight.demos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowRequestHeaders")
public class ShowRequestHeaders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowRequestHeaders() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("	<head>");
		out.println("		<title>All Request Headers</title>");
		out.println("	</head>");
		out.println("	<body>");
		out.println("		<h3>All Request Headers</h3>");
		out.println("		<p><b>Request Method: </b>" + request.getMethod() + "</p>");
		out.println("		<p><b>Request URI: </b>" + request.getRequestURI() + "</p>");
		out.println("		<p><b>Request Protocol: </b>" + request.getProtocol() + "</p>");
		
		Enumeration<String> headers = request.getHeaderNames();
		while(headers.hasMoreElements()) {
			String headerName = headers.nextElement();
			out.println("<p><b>" + headerName + "</b>: " + request.getHeader(headerName) + "</p>");
		}
		
		out.println("	</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
