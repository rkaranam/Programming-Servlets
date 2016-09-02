package com.pluralsight.demos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends GenericServlet {
	
	private static final long serialVersionUID = 1L;
       
    public HelloWorldServlet() {
        super();
    }

	public void service(ServletRequest request, ServletResponse response) 
						throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Java EE: Programming Servlets");
	}

}
