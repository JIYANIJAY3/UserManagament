package util;

import java.io.IOException;

import javax.servlet.ServletException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletUtilClass {

	//static String Error = "Invalid Data";

	// Forward Request
	public static void forward(String page, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, jakarta.servlet.ServletException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	// Include Request
	public static void include(String page, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, jakarta.servlet.ServletException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.include(request, response);
	}

	public static void setErrorMessage(String Error,String msg, HttpServletRequest request) {
		request.setAttribute(Error, msg);
	}

	public static String getErrorMessage(String Error,HttpServletRequest request) {
		String msgValue = (String) request.getAttribute(Error);
		if (msgValue == null) {
			return "";
		} else {
			return msgValue;
		}
	}
}
