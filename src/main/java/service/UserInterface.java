package service;

import java.sql.Connection;
import java.util.List;

import bean.UserAddressBean;
import bean.UserBean;

public interface UserInterface {
	 int getUserStatus(Connection conn,UserBean userBean);
	 int getUserId(Connection conn,String email);
	 int getUserAddressStatus(Connection conn,List<UserAddressBean> addressList);
	 List<UserBean> getAllUser(Connection conn);
	 boolean getEmailIsPresent(Connection conn,String Email);
	 int deleteUserById(Connection conn,int UserId);
	 List<UserAddressBean> getUserAddress(Connection conn, int UserId);
	 int updateUser(Connection conn,UserBean userBean);
	 int forgetPassword(Connection conn,String email,String answer);
	 int updatePassword(Connection conn,int UserId,String Password);
	 int updateUserAddress(Connection conn,List<UserAddressBean> addressList);
	 int addUserAddress(Connection conn,List<UserAddressBean> addressList);
	 List<Integer> getUserAddressId(Connection conn,int UserId);
	 int deleteUserAddress(Connection conn,List<Integer> list,int UserId);
	 UserBean getEmployeeByEmail(Connection con, String email);
}
