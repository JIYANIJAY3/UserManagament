package service;

import java.sql.Connection;
import java.util.List;

import bean.UserAddressBean;
import bean.UserBean;


interface UserInterface {
	public int getUserStatus(Connection conn,UserBean userBean);
	public int getUserId(Connection conn,String email);
	public int getUserAddressStatus(Connection conn,List<UserAddressBean> addressList);
	public List<UserBean> getAllUser(Connection conn);
	public boolean getEmailIsPresent(Connection conn,String Email);
	public int deleteUserById(Connection conn,int UserId);
	public List<UserAddressBean> getUserAddress(Connection conn, int UserId);
}
