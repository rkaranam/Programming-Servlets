package org.pluralsight.utilities;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GzipUtility {
	
	public static boolean isGzipSupported(HttpServletRequest request) {
		String encodings = request.getHeader("Accept-Encoding");
		return (null != encodings) && (encodings.contains("gzip"));
	}
	
	public static boolean isGzipDisabled(HttpServletRequest request) {
		String flag = request.getParameter("disableGzip");
		return (null != flag) && (!flag.equalsIgnoreCase("false")); 
		
	}
	public static PrintWriter getGzipWriter(HttpServletResponse response) throws IOException {
		return new PrintWriter(new GZIPOutputStream(response.getOutputStream()));
	}

}
