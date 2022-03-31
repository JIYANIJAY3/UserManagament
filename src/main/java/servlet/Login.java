package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.ServletUtilClass;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import bean.UserAddressBean;
import bean.UserBean;
import dao.AddressDao;
import dao.DataBaseConnection;
import dao.LoginDao;
import dao.RegistrationDao;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(Login.class.getName());
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

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		LoginDao loginDao = new LoginDao();
		RegistrationDao registrationDao = new RegistrationDao();
		AddressDao addressDao = new AddressDao();

		String Role = loginDao.loginUser(conn, email, password);

		System.out.println(Role);
		try {
			if (Role.equals("User")) {
				HttpSession session = request.getSession();
				UserBean bean = registrationDao.getEmployeeByEmail(conn, email);
				session.setAttribute("User", bean);
				int UserId = bean.getUserId();
				List<UserAddressBean> list = addressDao.getUserAddress(conn, UserId);
				session.setAttribute("UserAddress", list);
				response.sendRedirect("UserHome.jsp");
			} else if (Role.equals("Admin")) {
				HttpSession session = request.getSession();
				UserBean bean = registrationDao.getEmployeeByEmail(conn, email);
				session.setAttribute("Admin", bean);
				response.sendRedirect("AdminHome.jsp");
			} else {
				ServletUtilClass.setErrorMessage("Invalid UserName And PassWord", request);
				ServletUtilClass.include("/login.jsp", request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}
