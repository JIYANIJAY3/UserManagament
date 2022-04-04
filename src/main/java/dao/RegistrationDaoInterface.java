package dao;

import java.sql.Connection;
import java.util.List;

import bean.UserAddressBean;
import bean.UserBean;

public interface RegistrationDaoInterface {

	public int addEmployee(Connection conn, UserBean userBean);
	public int addEmployeeAddress(Connection conn, List<UserAddressBean> addressList);
	public int getEmployeeId(Connection conn,String Email);
	public boolean getEmailIsPresent(Connection conn,String Email);
	public UserBean getEmployeeByEmail(Connection con, String email);
	public List<UserBean> getAllUser(Connection conn);
	public int deleteUserById(Connection conn,int UserId);
	public int forgetPassword(Connection conn, String email,String answer);
	public int updatePassword(Connection conn,int UserId,String Password);
}
