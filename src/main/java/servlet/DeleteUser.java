package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import dao.DataBaseConnection;

public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(DeleteUser.class.getName());
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
		
		String UserId = request.getParameter("UserId");
		UserImpl impl = new UserImpl();
		
		//Delete User By Admin
		int status = impl.deleteUserById(conn, Integer.parseInt(UserId));

		if (status > 0) {
			out.print("delete");
		} else {
			out.print("not delete");
		}
		log.info("User Deleted");
	}

}
