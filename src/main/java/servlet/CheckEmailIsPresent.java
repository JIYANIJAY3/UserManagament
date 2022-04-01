package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import dao.DataBaseConnection;
import dao.RegistrationDao;

public class CheckEmailIsPresent extends HttpServlet {
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
		
		String email = request.getParameter("email");
		UserImpl impl = new UserImpl();
		boolean status = impl.getEmailIsPresent(conn, email);

		if(status)
		{
			out.print("done");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

}
