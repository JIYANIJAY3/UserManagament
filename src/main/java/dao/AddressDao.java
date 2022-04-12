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

	// Get All User Address List
	public List<UserAddressBean> getUserAddress(Connection con, int UserId) {
		List<UserAddressBean> list = new ArrayList<>();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			if (con != null) {
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
				log.info("UserAddress Add In AddressList");
			} else {
				log.info("Connection Is Null");
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				log.info(e2);
			}
		}
		return list;
	}

	// Update User Address
	@Override
	public int updateUserAddress(Connection conn, List<UserAddressBean> addressList) {
		PreparedStatement ps = null;
		try {
			if (conn != null) {
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
				log.info("User Update Succsefully");
				return 1;
			} else {
				log.info("Connection Is Null");
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e2) {
				log.info(e2);
			}
		}
		return 0;
	}

	// Add User Address
	@Override
	public int addUserAddress(Connection conn, List<UserAddressBean> addressList) {
		PreparedStatement ps = null;

		try {
			if (conn != null) {
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
				log.info("Add User Address Successfully");
				return 1;
			} else {
				log.info("Connection Is Null");
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e2) {
				log.info(e2);
			}
		}
		return 0;
	}

	// Get AddressId For Delete And Fetch Particular User Address
	@Override
	public List<Integer> getUserAddressId(Connection conn, int UserId) {
		List<Integer> AddrerssIdList = new ArrayList<Integer>();

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			if (conn != null) {
				String set = "SELECT AddressId from address where UserId=?";

				ps = conn.prepareStatement(set);
				ps.setInt(1, UserId);

				rs = ps.executeQuery();
				while (rs.next()) {
					AddrerssIdList.add(rs.getInt(1));
				}
			} else {
				log.info("Connection Is Null");
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				log.info(e2);
			}
		}
		return AddrerssIdList;
	}

	// Delete Particular UserAdrerss
	@Override
	public int deleteUserAddress(Connection conn, List<Integer> list, int UserId) {

		PreparedStatement ps = null;
		try {
			if (conn != null) {
				String sql = "DELETE FROM address WHERE AddressId=? and UserId=?";
				ps = conn.prepareStatement(sql);

				for (Integer addresslist : list) {
					ps.setInt(1, addresslist);
					ps.setInt(2, UserId);
					ps.addBatch();
				}
				ps.executeBatch();
				System.out.println("ok");
				return 1;
			} else {
				log.info("Connection Is Null");
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e2) {
				log.info(e2);
			}
		}

		return 0;
	}

}
