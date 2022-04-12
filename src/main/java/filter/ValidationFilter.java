package filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.ServletUtilClass;
import util.Validation;

import java.io.IOException;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

@WebFilter(servletNames = "UpdateUserProfile")
public class ValidationFilter implements Filter {

	static Logger log = Logger.getLogger(ValidationFilter.class.getName());

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		BasicConfigurator.configure();
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String date = request.getParameter("date");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String answer = request.getParameter("answer");
		String mobail = request.getParameter("mobail");
		
		String[] country = request.getParameterValues("country");
		String[] state = request.getParameterValues("state");
		String[] city = request.getParameterValues("city");
		String[] pincode = request.getParameterValues("pincode");
		String[] address = request.getParameterValues("address");

		boolean isError = false;

		if (!Validation.checkNameValidation(firstname)) {
			isError = true;
			ServletUtilClass.setErrorMessage("FirstNameError", "FirstName Is Empty", req);
		}

		if (!Validation.checkNameValidation(lastname)) {
			isError = true;
			ServletUtilClass.setErrorMessage("LastNameError", "lastname Is Empty", req);
		}

		if (!Validation.checkEmailValidation(email)) {
			isError = true;
			ServletUtilClass.setErrorMessage("EmailError", "Email Is Empty", req);
		}

		if (!Validation.checkDobValidation(date)) {
			isError = true;
			ServletUtilClass.setErrorMessage("DobError", "Enter Proper Date", req);
		}

		if (!Validation.checkGenderIsEmpty(gender)) {
			isError = true;
			ServletUtilClass.setErrorMessage("GenderError", "Please Select Any One", req);
		}
		if (!Validation.checkMobailValidation(mobail)) {
			isError = true;
			ServletUtilClass.setErrorMessage("MobailError", "Enter Only Number And Not Empty", req);
		}

		if (!Validation.checkPassowrdValidation(password)) {
			isError = true;
			ServletUtilClass.setErrorMessage("PasswordError", "Enter minimum 8digit and Not empty", req);

		}
		if (!Validation.checkAnswerValidation(answer)) {
			isError = true;
			ServletUtilClass.setErrorMessage("AnserError", "Please Fill Answer", req);
		}

		log.info(country.length);
		int c = 0;
		do {
			if (!Validation.checkCountryValidation(country[c])) {
				isError = true;
				ServletUtilClass.setErrorMessage("CountryError", "Enter valid Country Name And Not Empty Field", req);
			}

			if (!Validation.checkStateValidation(state[c])) {
				isError = true;
				ServletUtilClass.setErrorMessage("StateError", "Enter valid Country Name And Not Empty Field", req);
			}

			if (!Validation.checkCityValidation(city[c])) {
				isError = true;
				ServletUtilClass.setErrorMessage("CityError", "Enter valid City Name And Not Empty Field", req);
			}
			if (!Validation.checkPincodeValidation(pincode[c])) {
				isError = true;
				ServletUtilClass.setErrorMessage("PincodeError", "Enter valid Pincode Name And Not Empty Field", req);
			}
			if (!Validation.checkAddressValidation(address[c])) {
				isError = true;
				ServletUtilClass.setErrorMessage("AddressError", "Enter valid Address Name And Not Empty Field", req);
			}

			c++;
		} while (c < country.length);

		// If All Data Is Validate Move To Registration Servlet else forward index.jsp
		if (isError == true) {
			request.getRequestDispatcher("index.jsp").forward(req, res);
		} else {
			chain.doFilter(req, res);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}

}
