package dao;

import java.sql.Connection;
import java.util.List;

import bean.UserAddressBean;

public interface AddressDaoInterface {
	 List<UserAddressBean> getUserAddress(Connection conn, int UserId);
	 int updateUserAddress(Connection conn, List<UserAddressBean> addressList);
	 int addUserAddress(Connection conn, List<UserAddressBean> addressList);
	 List<Integer> getUserAddressId(Connection conn, int UserId);
	 int deleteUserAddress(Connection conn,List<Integer> list,int UserId);
}
