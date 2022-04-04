package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import service.UserImpl;
import service.UserInterface;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import bean.UserAddressBean;
import bean.UserBean;
import dao.DataBaseConnection;

@MultipartConfig
public class UpdateUserProfile extends HttpServlet {
	static Logger log = Logger.getLogger(UpdateUserProfile.class.getName());
	private static final long serialVersionUID = 1L;

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

//		HttpSession session = request.getSession(false);
//		UserAddressBean useraddress = (UserAddressBean) session.getAttribute("UserAddress");
//		
//		log.info(useraddress.getAddressId());
		
		UserInterface userInterface = new UserImpl();
		String userId = request.getParameter("UserId");
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String date = request.getParameter("date");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		String answer = request.getParameter("answer");
		Part filePart = request.getPart("profile");
		String[] language = request.getParameterValues("language");
		String storelanguage = " ";
		for (int i = 0; i < language.length; i++) {
			storelanguage += language[i] + " ";
		}

		UserBean userBean = new UserBean();
		userBean.setUserId(Integer.parseInt(userId));
		userBean.setFiratName(firstname);
		userBean.setLastName(lastname);
		userBean.setDob(date);
		userBean.setGender(gender);
		userBean.setPassword(password);
		userBean.setAnswer(answer);
		userBean.setProfile(filePart);
		userBean.setLanguage(storelanguage);

		String[] country = request.getParameterValues("country");
		String[] state = request.getParameterValues("state");
		String[] city = request.getParameterValues("city");
		String[] pincode = request.getParameterValues("pincode");
		String[] address = request.getParameterValues("address");
		String[] AddressId = request.getParameterValues("AddressId");
		List<UserAddressBean> addressList = new ArrayList<UserAddressBean>();

		for (int i = 0; i < country.length; i++) {
			log.info(AddressId[i]);
			if (AddressId[i].isEmpty()) {
				log.info("Address Id Is Empty");
				UserAddressBean addressBean = new UserAddressBean();
				addressBean.setUserId(Integer.parseInt(userId));
				addressBean.setCountry(country[i]);
				addressBean.setCity(city[i]);
				addressBean.setPinCode(pincode[i]);
				addressBean.setState(state[i]);
				addressBean.setAddress(address[i]);
				addressList.add(addressBean);
			} else {
				UserAddressBean addressBean = new UserAddressBean();
				addressBean.setAddressId(Integer.parseInt(AddressId[i]));
				addressBean.setCountry(country[i]);
				addressBean.setCity(city[i]);
				addressBean.setPinCode(pincode[i]);
				addressBean.setState(state[i]);
				addressBean.setAddress(address[i]);
				addressList.add(addressBean);
			}

		}

		int status = userInterface.updateUser(conn, userBean);
		int addressStatus = userInterface.updateUserAddress(conn, addressList);
		int addUserAddress = userInterface.addUserAddress(conn, addressList);
		if (status > 0) {
			out.print("Update");
		} else {
			out.print("Not Update");
		}
		log.info("Update User");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

}
