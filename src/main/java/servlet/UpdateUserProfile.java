package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
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

		UserInterface userInterface = new UserImpl();
		
		//Get Registration Form value
		String userId = request.getParameter("UserId");
		String firstname = request.getParameter("fname");
		String email = request.getParameter("email");
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

		//Set All User Value into UserBean
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

		//Get All Address Field Value
		String[] country = request.getParameterValues("country");
		String[] state = request.getParameterValues("state");
		String[] city = request.getParameterValues("city");
		String[] pincode = request.getParameterValues("pincode");
		String[] address = request.getParameterValues("address");
		String[] AddressId = request.getParameterValues("AddressId");

		// For New Address
		List<UserAddressBean> addressList1 = new ArrayList<UserAddressBean>();

		// Old Address Update
		List<UserAddressBean> addressList2 = new ArrayList<UserAddressBean>();

		// Delete Address
		List<Integer> addressList3 = new ArrayList<Integer>();

		for (int i = 0; i < country.length; i++) {
			log.info(AddressId[i]);
			if (AddressId[i].isEmpty()) {
				log.info("Address Id Is Empty");
				UserAddressBean addressBean1 = new UserAddressBean();
				addressBean1.setUserId(Integer.parseInt(userId));
				addressBean1.setCountry(country[i]);
				addressBean1.setCity(city[i]);
				addressBean1.setPinCode(pincode[i]);
				addressBean1.setState(state[i]);
				addressBean1.setAddress(address[i]);
				addressList1.add(addressBean1);
			} else {
				UserAddressBean addressBean2 = new UserAddressBean();
				addressBean2.setAddressId(Integer.parseInt(AddressId[i]));
				addressBean2.setCountry(country[i]);
				addressBean2.setCity(city[i]);
				addressBean2.setPinCode(pincode[i]);
				addressBean2.setState(state[i]);
				addressBean2.setAddress(address[i]);
				addressList2.add(addressBean2);
				addressList3.add(addressBean2.getAddressId());
			}
		}

		List<Integer> UserAddtessIdList = userInterface.getUserAddressId(conn, Integer.parseInt(userId));
		for (Integer l : UserAddtessIdList) {
			if (addressList3.contains(l)) {
				addressList3.remove(l);
			} else {
				addressList3.add(l);
			}
		}

		int status = userInterface.updateUser(conn, userBean);
		int addressStatus = userInterface.updateUserAddress(conn, addressList2);
		int addUserAddress = userInterface.addUserAddress(conn, addressList1);
		int deletUserAddress = userInterface.deleteUserAddress(conn, addressList3, Integer.parseInt(userId));

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
