package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserImpl;
import service.UserInterface;
import service.UserProfileImpl;
import service.UserProfileInterface;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import bean.UserAddressBean;
import bean.UserBean;
import bean.UserProfileBean;
import dao.DataBaseConnection;

@MultipartConfig
public class GetAllUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(GetAllUserDetails.class.getName());

	transient Connection conn = null;

	@Override
	public void init() throws ServletException {
		conn = DataBaseConnection.getConnection();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		//Define Session For Update Profile
		HttpSession session = request.getSession(false);
		String email = request.getParameter("Email");
		String UserId = request.getParameter("UserId");
		UserInterface userInterface = new UserImpl();
		UserProfileInterface profileInterface = new UserProfileImpl();
		//Get All User Details
		UserBean bean = userInterface.getEmployeeByEmail(conn, email);
		session.setAttribute("User", bean);
		
		//Get All UserAddress
		List<UserAddressBean> list = userInterface.getUserAddress(conn, Integer.parseInt(UserId));
		session.setAttribute("UserAddress", list);
		
		List<UserProfileBean> profilelist = profileInterface.getUserImg(conn, Integer.parseInt(UserId));
		log.info("profile list size "+profilelist.size());
		session.setAttribute("UserProfile", profilelist);
		log.info(bean);
		log.info("Hello " + email);
		out.print("ok");
	}
}
