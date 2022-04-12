package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import bean.UserAddressBean;
import dao.DataBaseConnection;

public class GetAllUserAddress extends HttpServlet {

	static Logger log = Logger.getLogger(GetAllUserAddress.class.getName());

	private static final long serialVersionUID = 1L;
	transient Connection conn = null;

	@Override
	public void init() throws ServletException {
		conn = DataBaseConnection.getConnection();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BasicConfigurator.configure();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String UserId = request.getParameter("UserId");
		log.info("uid "+UserId);
		UserImpl impl = new UserImpl();
		
		//Get All UserAddress List
		List<UserAddressBean> list = impl.getUserAddress(conn, Integer.parseInt(UserId));
		
		log.info(list.size());
		
		//Convert List Data To -> JSON Data 
		Gson gson = new Gson();
		out.print(gson.toJson(list));
	}
}
