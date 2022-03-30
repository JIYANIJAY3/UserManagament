package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import dao.DataBaseConnection;
import dao.RegistrationDao;

public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(DeleteUser.class.getName());
	Connection conn = null;

	@Override
	public void init() throws ServletException {
		conn = DataBaseConnection.getConnection();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BasicConfigurator.configure();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		log.info("hello");
		String UserId = request.getParameter("UserId");
		RegistrationDao registrationDao = new RegistrationDao();
		int status = registrationDao.deleteUserById(conn, Integer.parseInt(UserId));

		if (status > 0) {
			out.print("delete");
		} else {
			out.print("not delete");
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
}
