package org.pluralsight.demos.uploads;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/FileUploadServlet")
@MultipartConfig(
		fileSizeThreshold 	= 1024 * 1024 * 2, // 2MB
			  maxFileSize 	= 1024 * 1024 * 10, // 10MB
		   maxRequestSize	= 1024 * 1024 * 50 // 50 MB		
	)
public class FileUploadServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String SAVE_DIR = "UploadedFiles";
       
    public FileUploadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.println("Sorry! GET Method cannot handle this type of request.");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String applicationPath = request.getServletContext().getRealPath("");
		String fileSavePath = applicationPath + File.separator + SAVE_DIR;
		
		File fileSaveDirectory = new File(fileSavePath);
		if( !fileSaveDirectory.exists() ) {
			fileSaveDirectory.mkdir();
		}
		
		for(Part part: request.getParts()) {
			String fileName = extractFileName(part);
			part.write(fileSavePath + File.separator + fileName);
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("   <head>");
		out.println("       <title>File Upload Result</title>");
		out.println("   </head>");
		out.println("   <body>");
		out.println("		<h2>File Uploaded Successfully!</h2>");
		out.println("   </body>");
		out.println("</html>");
	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length()-1);
			}
		}
		return "";
	}

}
