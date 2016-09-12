package org.pluralsight.demos.sessions;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AccessCountsServlet")
public class AccessCountsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AccessCountsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		String title = "Access Counts";
		
		synchronized(session) {
			String heading;
			Integer accessCount = (Integer) session.getAttribute("accessCount");
			
			if (accessCount == null) {
				heading = "Welcome Newcomer!";
				accessCount = 0;
			} else {
				heading = "Welcome Back!";
				accessCount += 1;
			}
			session.setAttribute("accessCount", accessCount);
		
			PrintWriter out = response.getWriter(); 
			out.println ("<!DOCTYPE HTML>" 
							+ "<HEAD><TITLE>" + title + "</TITLE></HEAD>" 
							+ "<BODY BGCOLOR=\"#FDF5E6\">\n" 
							+ "<CENTER>\n" 
							+ "<H1>" + heading + "</H1>\n" 
							+ "<H2>Information on Your Session:</H2>\n" 
							+ "<TABLE BORDER=1>" 
							+ " <TH>Info Type</TH><TH>Value</TH>" 
							+ " <TR><TD>ID</TD><TD>" + session.getId() + "</TD></TR>"
							+ " <TR><TD>Creation Time</TD><TD>" + getTime(session.getCreationTime()) + "</TD></TR>"
							+ " <TR><TD>Last Accessed Time</TD><TD>" + getTime(session.getLastAccessedTime()) + "</TD></TR>"							
							+ " <TR><TD>Number of Previous Accesses</TD><TD>" + accessCount + "</TD></TR>" 
							+ "</TABLE>" 
							+ "</CENTER></BODY></HTML>");
		}
		
		
	}

	public String getTime(long timeInMillis) {
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSSS");
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(timeInMillis);
		
		System.out.println(formatter.format(calendar.getTime()));
				
		return formatter.format(calendar.getTime());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
