package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserImpl;
import service.UserInterface;
import service.UserProfileImpl;
import service.UserProfileInterface;
import util.ServletUtilClass;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import bean.UserAddressBean;
import bean.UserBean;
import bean.UserProfileBean;
import dao.DataBaseConnection;
import dao.LoginDao;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(Login.class.getName());
	final static Logger logger = LogManager.getLogger(Login.class);
	transient Connection conn = null;

	@Override
	public void init() throws ServletException {
		conn = DataBaseConnection.getConnection();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BasicConfigurator.configure();
		response.setContentType("text/html");

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		LoginDao loginDao = new LoginDao();
		String Role = loginDao.loginUser(conn, email, password);
		
		UserInterface userInterface = new UserImpl();
		UserProfileInterface profileInterface = new UserProfileImpl();
		logger.info(Role);
		try {
			if (Role.equals("User")) {
				HttpSession session = request.getSession();
				UserBean bean = userInterface.getEmployeeByEmail(conn, email);
				session.setAttribute("User", bean);

				int UserId = bean.getUserId();
				String pas  = bean.getPassword();
				log.info("pass"+pas);
				log.info("language " + bean.getLanguage());
				// addressDao.getUserAddress(conn, UserId);
				List<UserAddressBean> list = userInterface.getUserAddress(conn, UserId);   
				session.setAttribute("UserAddress", list);
				log.info(list.size());
				
				List<UserProfileBean> profilelist = profileInterface.getUserImg(conn, UserId);
				log.info("profile list size "+profilelist.size());
				session.setAttribute("UserProfile", profilelist);
				response.sendRedirect("UserHome.jsp");

			} else if (Role.equals("Admin")) {
				HttpSession session = request.getSession();
				UserBean bean = userInterface.getEmployeeByEmail(conn, email);
				session.setAttribute("Admin", bean);
				response.sendRedirect("AdminHome.jsp");
			} else {
				ServletUtilClass.setErrorMessage("LoginError","Invalid UserName And PassWord", request);
				ServletUtilClass.include("/login.jsp", request, response);
			}
		} catch (Exception e) {
			log.info(e);
		}
	}
}
