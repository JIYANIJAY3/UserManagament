package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import service.UserImpl;
import service.UserInterface;
import service.UserProfileImpl;
import service.UserProfileInterface;
import util.PassWordEncriptionDecription;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import bean.UserAddressBean;
import bean.UserBean;
import bean.UserProfileBean;
import dao.DataBaseConnection;

@MultipartConfig
public class Registration extends HttpServlet {

	static Logger log = Logger.getLogger(Registration.class.getName());
	final static Logger logger = LogManager.getLogger(Registration.class);
	private static final long serialVersionUID = 1L;

	transient Connection conn = null;

	@Override
	public void init() throws ServletException {
		conn = DataBaseConnection.getConnection();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BasicConfigurator.configure();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Get the registration form value one by one
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String date = request.getParameter("date");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String answer = request.getParameter("answer");
		String mobail = request.getParameter("mobail");

		String[] language = request.getParameterValues("language");

		// Store check box value
		String storelanguage = " ";

		StringBuffer buf = new StringBuffer();
		// Store check-box value into storelanguage variable
		for (String lang : language) {
			buf.append(lang);
		}
		storelanguage = buf.toString();
//		for (int i = 0; i < language.length; i++) {
//			storelanguage += language[i] + " ";
//		}

		String encrptPassword = PassWordEncriptionDecription.hashPassword(password);
		log.info("Encription "+encrptPassword);
		
		UserBean userBean = new UserBean();
		userBean.setFiratName(firstname);
		userBean.setLastName(lastname);
		userBean.setDob(date);
		userBean.setGender(gender);
		userBean.setEmail(email);
		userBean.setPassword(encrptPassword);
		userBean.setAnswer(answer);
		userBean.setMobailNo(mobail);
		userBean.setLanguage(storelanguage);

		String[] country = request.getParameterValues("country");
		String[] state = request.getParameterValues("state");
		String[] city = request.getParameterValues("city");
		String[] pincode = request.getParameterValues("pincode");
		String[] address = request.getParameterValues("address");

		// Define Userimpl class object
		UserInterface userInterface = new UserImpl();

		int status = userInterface.getUserStatus(conn, userBean);
		int getUserId = userInterface.getUserId(conn, email);
		
		// Store all address on registration page
		List<UserAddressBean> addressList = new ArrayList<UserAddressBean>();
		for (int i = 0; i < country.length; i++) {
			UserAddressBean addressBean = new UserAddressBean();
			addressBean.setUserId(getUserId);
			addressBean.setCountry(country[i]);
			addressBean.setCity(city[i]);
			addressBean.setPinCode(pincode[i]);
			addressBean.setState(state[i]);
			addressBean.setAddress(address[i]);
			addressList.add(addressBean);
		}

		// User Profile Part
		List<Part> fileParts = (List<Part>) request.getParts().stream().filter(new Predicate<Part>() {
			public boolean test(Part part) {
				return "profiles[]".equals(part.getName()) && part.getSize() > 0;
			}
		}).collect(Collectors.toList());
		
		InputStream inputStream = null;
		
		UserProfileInterface userProfileImpl = new UserProfileImpl();
		UserProfileBean userprofile = null;
		for (Part filePart : fileParts) {
			if (filePart != null && filePart.getSize() != 0) {
				userprofile = new UserProfileBean();
				inputStream = filePart.getInputStream();
				userprofile.setUserId(getUserId);
				userprofile.setImage(inputStream);
				userProfileImpl.addUserprofile(conn,userprofile);
				log.info("image save into list");
			}
		}
		log.debug("User Images Added");

		// Check UserAddress store into database or not.
		int addressStatus = userInterface.getUserAddressStatus(conn, addressList);
		log.info("address add status" + addressStatus);
		
		log.info(status);
		log.info("here");
		if (status > 0) {
			out.print("Successfully Added...");
		} else {
			out.print("Somthing went wrong");
		}

	}
}
