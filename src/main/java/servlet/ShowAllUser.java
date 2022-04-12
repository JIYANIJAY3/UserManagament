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

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import org.apache.log4j.BasicConfigurator;

import bean.UserBean;
import dao.DataBaseConnection;

public class ShowAllUser extends HttpServlet {
	
	static Logger log = Logger.getLogger(ShowAllUser.class.getName());
	
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
		
		//Define UserImpl class object for  
		UserImpl impl = new UserImpl();
		
		//Get AllUser For show AdminPage 
		List<UserBean> list = impl.getAllUser(conn);
		
		//Convert list To->JSON DATA
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonObject json = new JsonObject();
		json.add("data", gson.toJsonTree(list));
		out.print(json);
	}
}
