package dao;

import java.sql.Connection;
import java.util.List;

import bean.UserAddressBean;

public interface AddressDaoInterface {
	public List<UserAddressBean> getUserAddress(Connection conn, int UserId);
	public int updateUserAddress(Connection conn, List<UserAddressBean> addressList);
	public int addUserAddress(Connection conn, List<UserAddressBean> addressList);
}
