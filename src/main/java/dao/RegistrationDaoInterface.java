package dao;

import java.sql.Connection;
import java.util.List;

import bean.UserAddressBean;
import bean.UserBean;

public interface RegistrationDaoInterface {

	 int addEmployee(Connection conn, UserBean userBean);
	 int addEmployeeAddress(Connection conn, List<UserAddressBean> addressList);
	 int getEmployeeId(Connection conn,String Email);
	 boolean getEmailIsPresent(Connection conn,String Email);
	 UserBean getEmployeeByEmail(Connection con, String email);
	 List<UserBean> getAllUser(Connection conn);
	 int deleteUserById(Connection conn,int UserId);
	 int forgetPassword(Connection conn, String email,String answer);
	 int updatePassword(Connection conn,int UserId,String Password);
}
