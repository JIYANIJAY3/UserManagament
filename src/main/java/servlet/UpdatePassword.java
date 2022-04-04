package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserImpl;
import service.UserInterface;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import dao.DataBaseConnection;

public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection conn = null;

	@Override
	public void init() throws ServletException {
		conn = DataBaseConnection.getConnection();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String UserId = request.getParameter("UserId");
		String password = request.getParameter("password");

		UserInterface userInterface = new UserImpl();

		int status = userInterface.updatePassword(conn, Integer.parseInt(UserId), password);

		if (status > 0) {
			request.setAttribute("resetPassword", "Reset Password");
			RequestDispatcher rd = request.getRequestDispatcher("ForgotPassword.jsp");
			rd.include(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}

}
