package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserImpl;
import service.UserInterface;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import dao.DataBaseConnection;

public class CheckEmailIsPresent extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	transient Connection conn = null;

	@Override
	public void init() throws ServletException {
		conn = DataBaseConnection.getConnection();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		UserInterface userInterface = new UserImpl();
		
		//Check Email Is Present In DataBase Or Not On User Registration Time
		boolean status = userInterface.getEmailIsPresent(conn, email);

		if(status)
		{
			out.print("done");
		}
	}

}
