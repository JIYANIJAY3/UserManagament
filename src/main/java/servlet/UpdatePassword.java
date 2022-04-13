package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserImpl;
import service.UserInterface;
import util.PassWordEncriptionDecription;

import java.io.IOException;
import java.sql.Connection;

import org.apache.log4j.Logger;

import dao.DataBaseConnection;

public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(UpdatePassword.class.getName());
	transient Connection conn = null;

	@Override
	public void init() throws ServletException {
		conn = DataBaseConnection.getConnection();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String UserId = request.getParameter("UserId");
		String password = request.getParameter("password");

		UserInterface userInterface = new UserImpl();
		String pass = PassWordEncriptionDecription.hashPassword(password);
		log.info(pass);
		log.info(UserId);
		
		//Check Password are Update or Not
		int status = userInterface.updatePassword(conn, Integer.parseInt(UserId.trim()), pass);
		
		log.info("update password status "+status);
		if (status > 0) {
			request.setAttribute("resetPassword", "Reset Password succsefully");
			RequestDispatcher rd = request.getRequestDispatcher("ForgetPassword.jsp");
			rd.include(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}

}
