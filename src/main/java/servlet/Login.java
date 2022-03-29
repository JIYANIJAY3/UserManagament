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

import bean.UserBean;
import dao.DataBaseConnection;
import dao.LoginDao;
import dao.LoginDaoInterface;
import dao.RegistrationDao;

public class Login extends HttpServlet {
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
		String password = request.getParameter("password");
		
		LoginDao loginDao = new LoginDao();
		RegistrationDao registrationDao = new RegistrationDao();
		
		String Role = loginDao.loginUser(conn, email, password);
		
		System.out.println(Role);
		try {
			if(Role.equals("User"))
			{
				HttpSession session = request.getSession();
				UserBean bean = registrationDao.getEmployeeByEmail(conn, email);
				session.setAttribute("User", bean);
				response.sendRedirect("UserHome.jsp");
			}
			else if(Role.equals("Admin"))
			{
				response.sendRedirect("AdminHome.jsp");
			}
			else
			{
				ServletUtilClass.setErrorMessage("Invalid UserName And PassWord", request);
				ServletUtilClass.include("/login.jsp", request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
}
