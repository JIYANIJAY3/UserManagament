package util;

import java.io.IOException;

import javax.servlet.ServletException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletUtilClass {

	
	
	// Forward Request
	public static void forward(String msg, String page, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, jakarta.servlet.ServletException {

		request.setAttribute("massage", msg);
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	// Include Request
	public static void include(String msg, String page, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, jakarta.servlet.ServletException {
		
		request.setAttribute("massage", msg);
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.include(request, response);
	}
}
