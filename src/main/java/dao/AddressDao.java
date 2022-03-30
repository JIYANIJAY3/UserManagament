package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import bean.UserAddressBean;

public class AddressDao implements AddressDaoInterface {
	
	static Logger log = Logger.getLogger(AddressDao.class.getName());

	public List<UserAddressBean> getUserAddress(Connection con, int UserId) {
		List<UserAddressBean> list = new ArrayList<>();

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String set = "SELECT Country, Address, PinCode, City, State FROM address where UserId=?";

			ps = con.prepareStatement(set);
			ps.setInt(1, UserId);

			rs = ps.executeQuery();
			while (rs.next()) {
				UserAddressBean addressBean = new UserAddressBean();
				addressBean.setCountry(rs.getString(1));
				addressBean.setAddress(rs.getString(2));
				addressBean.setPinCode(rs.getString(3));
				addressBean.setCity(rs.getString(4));
				addressBean.setState(rs.getString(5));
				list.add(addressBean);
			}
		} catch (Exception e) {
			log.info(e);
		}
		return list;
	}

}
