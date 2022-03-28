package filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.ServletUtilClass;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.log4j.Logger;

public class ValidationFilter implements Filter {

	static Logger log = Logger.getLogger(ValidationFilter.class.getName());

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String date = request.getParameter("date");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String answer = request.getParameter("answer");
		String mobail = request.getParameter("mobail");

		if (firstname.isEmpty()) {
			/*
			 * req.setAttribute("msg", "enter name"); RequestDispatcher rd =
			 * request.getRequestDispatcher("index.jsp"); rd.include(req, res);
			 */	
			try {
				ServletUtilClass.include("Enter Your FirstName", "index.jsp", req, res);
			} catch (IOException | javax.servlet.ServletException | ServletException e) {
				log.info(e);
				e.printStackTrace();
			}
		} else {
			log.info("Do Filter Call");
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}

}
