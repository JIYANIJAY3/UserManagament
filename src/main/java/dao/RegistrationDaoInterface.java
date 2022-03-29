package dao;

import java.sql.Connection;

import bean.UserAddressBean;
import bean.UserBean;

public interface RegistrationDaoInterface {

	public int addEmployee(Connection conn, UserBean userBean);
	public int addEmployeeAddress(Connection conn, UserAddressBean addressBean);
	public int getEmployeeId(Connection conn,String Email);
	public boolean getEmailIsPresent(Connection conn,String Email);
	public UserBean getEmployeeByEmail(Connection con, String email); 
}
