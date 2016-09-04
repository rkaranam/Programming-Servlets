package org.pluralsight.demos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContentTypeDemo")
public class ContentTypeDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContentTypeDemo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("application/vnd.ms-excel");
		
		PrintWriter out = response.getWriter();

		out.println("S.No\tName\tMonth\tRent\tFood\tGroceries\tSavings\tTotal");
		out.println("101\tRajasekhar\tAug\t8000\t5000\t1000\t1000\t=SUM(D2:G2)");
		out.println("102\tHariharin\tJul\t6000\t4000\t3000\t2400\t=SUM(D3:G3)");
		out.println("103\tRajasekhar\tSep\t10500\t5000\t2000\t5000\t=SUM(D4:G4)");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}

}
