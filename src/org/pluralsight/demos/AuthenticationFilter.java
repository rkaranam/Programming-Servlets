package org.pluralsight.demos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(
		filterName = "Authenticate",
		description = "Authenticating SecuredServlet",
		urlPatterns = {"/SecuredServlet"}
	)
public class AuthenticationFilter implements Filter {

    public AuthenticationFilter() {
    }

	public void destroy() {
		System.out.println("destroy() method is called in " + this.getClass().getName());
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		System.out.println("doFilter() method is called in " + this.getClass().getName());
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String ipAddress = request.getRemoteAddr();
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("   <head>");
		out.println("       <title></title>");
		out.println("   </head>");
		out.println("   <body>");
		
		out.println("<h3>Using @WebFilter Annotation: </h3>");
		
		if (username.equals("user") && password.equals("password")) {
			out.println("<p>User logged in " + ipAddress + " at " + new Date().toString() + "</p><hr/>");
			chain.doFilter(request, response);
		} else {
			out.println("<h3>Sorry, You are not authorised to access this resource.</h3>");
		}
		
		out.println("	</body>");
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init() method is called in " + this.getClass().getName());
	}

}
