package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserImpl;
import service.UserInterface;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import dao.DataBaseConnection;


public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(ForgotPassword.class.getName());
	transient Connection conn = null;

	@Override
	public void init() throws ServletException {
		conn = DataBaseConnection.getConnection();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BasicConfigurator.configure();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String answer = request.getParameter("answer");

		

		UserInterface userInterface = new UserImpl();
		int status = userInterface.forgetPassword(conn, email,answer);
		log.info("status "+status);
		if(status>0)
		{
			request.setAttribute("UserId",status);
			RequestDispatcher rd = request.getRequestDispatcher("ResetPassword.jsp");
			rd.forward(request, response);
		}
		else
		{
			out.print("Try Again Somthing Went To Wrong!");
		}
	}
}
