package org.pluralsight.demos.exceptions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExceptionHandler")
public class ExceptionHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExceptionHandler() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		processError(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void processError(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// Analyze the Servlet Exception
		Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
		String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		
		servletName = (null == servletName) ? "Unknown" : servletName;
		requestUri = (null == requestUri) ? "Unknown" : requestUri;
		
		PrintWriter out = response.getWriter();
		out.write("<html><head><title>Exception/Error Details</title></head><body>");
		if (statusCode != 500) {
			out.write("<h3>Error Details</h3>");
			out.write("<strong>Status Code</strong>:" + statusCode + "<br>");
			out.write("<strong>Requested URI</strong>:" + requestUri);
		} else {
			out.write("<h3>Exception Details</h3>");
			out.write("<ul><li>Servlet Name:" + servletName + "</li>");
			out.write("<li>Exception Name:" + throwable.getClass().getName() + "</li>");
			out.write("<li>Requested URI:" + requestUri + "</li>");
			out.write("<li>Exception Message:" + throwable.getMessage() + "</li>");
			out.write("</ul>");
		}

		out.write("<br><br>");
		out.write("<a href=\"index.html\">Home Page</a>");
		out.write("</body></html>");
		
	}

}
