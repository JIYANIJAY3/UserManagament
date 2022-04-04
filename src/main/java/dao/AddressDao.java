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
			String set = "SELECT AddressId,Country, Address, PinCode, City, State FROM address where UserId=?";

			ps = con.prepareStatement(set);
			ps.setInt(1, UserId);

			rs = ps.executeQuery();
			while (rs.next()) {
				UserAddressBean addressBean = new UserAddressBean();
				addressBean.setAddressId(rs.getInt(1));
				addressBean.setCountry(rs.getString(2));
				addressBean.setAddress(rs.getString(3));
				addressBean.setPinCode(rs.getString(4));
				addressBean.setCity(rs.getString(5));
				addressBean.setState(rs.getString(6));
				list.add(addressBean);
			}
		} catch (Exception e) {
			log.info(e);
		}
		return list;
	}

	@Override
	public int updateUserAddress(Connection conn, List<UserAddressBean> addressList) {
		PreparedStatement ps = null;

		if (conn != null) {
			try {
				String setAddress = "UPDATE address SET Country=?, Address=?, PinCode=?, City=?, State=? where AddressId=?";
				ps = conn.prepareStatement(setAddress);
				
				for (int i = 0; i < addressList.size(); i++) {
					UserAddressBean addressBean = addressList.get(i);
					log.info("AddressID " + addressBean.getAddressId());
					ps.setString(1, addressBean.getCountry());
					ps.setString(2, addressBean.getAddress());
					ps.setString(3, addressBean.getPinCode());
					ps.setString(4, addressBean.getCity());
					ps.setString(5, addressBean.getState());
					ps.setInt(6, addressBean.getAddressId());
					ps.addBatch();
				}
				ps.executeBatch();
				return 1;
			} catch (Exception e) {
				log.info(e);
			}
		} else {
			log.error("Connection Is Null");
		}

		return 0;
	}

	@Override
	public int addUserAddress(Connection conn, List<UserAddressBean> addressList) {
		PreparedStatement ps = null;

		if (conn != null) {
			try {
				String setAddress = "INSERT INTO address(AddressId, UserId, Country, Address, PinCode, City, State) "
						+ "VALUES (NULL,?,?,?,?,?,?)";
				ps = conn.prepareStatement(setAddress);
				log.info("here");
				for (int i = 0; i < addressList.size(); i++) {
					UserAddressBean addressBean = addressList.get(i);
					ps.setInt(1, addressBean.getUserId());
					ps.setString(2, addressBean.getCountry());
					ps.setString(3, addressBean.getAddress());
					ps.setString(4, addressBean.getPinCode());
					ps.setString(5, addressBean.getState());
					ps.setString(6, addressBean.getState());
					ps.addBatch();
				}
				ps.executeBatch();
				log.info("done");
				return 1;
			} catch (Exception e) {
				log.info(e);
			}
		} else {
			log.error("Connection Is Null");
		}

		return 0;
	}

}
