package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserProfileImpl;
import service.UserProfileInterface;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import bean.UserProfileBean;
import dao.DataBaseConnection;

public class DeleteUserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(DeleteUserProfile.class.getName());

	transient Connection conn = null;
	
	@Override
	public void init() throws ServletException {
		conn = DataBaseConnection.getConnection();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String imageId = request.getParameter("ProfileId");
		String UserId = request.getParameter("UserId");
		
		UserProfileInterface profileInterface = new UserProfileImpl();
		int status = profileInterface.deleteImage(conn, Integer.parseInt(imageId));
		
		if(status>0)
		{
			out.print("Image Delete");
			HttpSession session = request.getSession(false);
			List<UserProfileBean> profilelist = profileInterface.getUserImg(conn, Integer.parseInt(UserId));
			log.info("profile list size "+profilelist.size());
			session.setAttribute("UserProfile", profilelist);
		}
		else
		{
			out.print("Image Not Delete");
		}
	}
}
