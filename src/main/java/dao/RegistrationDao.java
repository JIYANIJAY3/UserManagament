package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import bean.UserAddressBean;
import bean.UserBean;

public class RegistrationDao implements RegistrationDaoInterface {

	static Logger log = Logger.getLogger(RegistrationDao.class.getName());

	// Add User
	@Override
	public int addEmployee(Connection conn, UserBean userBean) {
		BasicConfigurator.configure();

		int result = 0;
		PreparedStatement ps = null;
		try {

			if (conn != null) {
				String sql = "INSERT INTO user(UserId, FirstName, LastName, DOB, Role, Answer, MobailNo, Gender, Hobby, Email, Password) VALUES(null,?,?,?,?,?,?,?,?,?,?)";
				ps = conn.prepareStatement(sql);

				ps.setString(1, userBean.getFiratName());
				ps.setString(2, userBean.getLastName());
				ps.setString(3, userBean.getDob());
				ps.setString(4, "User");
				ps.setString(5, userBean.getAnswer());
				ps.setString(6, userBean.getMobailNo());
				ps.setString(7, userBean.getGender());
				ps.setString(8, userBean.getLanguage());
				ps.setString(9, userBean.getEmail());
				ps.setString(10, userBean.getPassword());
				result = ps.executeUpdate();

				log.info("User Add successfully");
				return result;
			} else {
				log.info("Connection Is Null");
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e2) {
				log.info(e2);
			}
		}
		return result;
	}

	// Add User Address
	@Override
	public int addEmployeeAddress(Connection conn, List<UserAddressBean> addressList) {

		PreparedStatement ps = null;
		try {
			if (conn != null) {
				String setAddress = "INSERT INTO address(AddressId, UserId, Country, Address, PinCode, City, State) "
						+ "VALUES (NULL,?,?,?,?,?,?)";
				ps = conn.prepareStatement(setAddress);
				for (int i = 0; i < addressList.size(); i++) {
					UserAddressBean userAddressBean = addressList.get(i);
					
					ps.setInt(1, userAddressBean.getUserId());
					ps.setString(2, userAddressBean.getCountry());
					ps.setString(3, userAddressBean.getAddress());
					ps.setString(4, userAddressBean.getPinCode());
					ps.setString(5, userAddressBean.getState());
					ps.setString(6, userAddressBean.getState());
					ps.addBatch();
				}
				log.info("Add User Address successfully");
				ps.executeBatch();
				log.info("done");
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

	// Get User Id For Fetch UserAddress and Profile Details.
	@Override
	public int getEmployeeId(Connection conn, String Email) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = 0;
		try {
			if (conn != null) {
				String sql = "SELECT UserId From user WHERE Email=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, Email);
				rs = ps.executeQuery();
				rs.next();
				id = rs.getInt(1);
				return id;
			} else {
				log.info("Connection Is Null");
			}
		} catch (Exception e) {
			log.error(e);
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
		return id;
	}

	// Check Email Address Is Present Or Not.
	@Override
	public boolean getEmailIsPresent(Connection conn, String Email) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			if (conn != null) {
				String sql = " SELECT * FROM user WHERE Email=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, Email);
				rs = ps.executeQuery();
				return rs.next();
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
		return false;

	}

	// Get User By It's Email.
	public UserBean getEmployeeByEmail(Connection con, String email) {
		UserBean userBean = new UserBean();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			if (con != null) {
				String sql = "SELECT * FROM user WHERE Email=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, email);
				rs = ps.executeQuery();
				if (rs.next()) {
					userBean.setUserId(rs.getInt(1));
					userBean.setFiratName(rs.getString(2));
					userBean.setLastName(rs.getString(3));
					userBean.setDob(rs.getString(4));
					userBean.setRole(rs.getString(5));
					userBean.setAnswer(rs.getString(6));
					userBean.setMobailNo(rs.getString(7));
					userBean.setGender(rs.getString(8));
					userBean.setLanguage(rs.getString(9));
					userBean.setEmail(rs.getString(10));
					userBean.setPassword(rs.getString(11));
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
		return userBean;
	}

	// Get All User Details
	@Override
	public List<UserBean> getAllUser(Connection conn) {

		List<UserBean> list = new ArrayList<UserBean>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			if (conn != null) {
				String sql = "SELECT * FROM user where Role=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "User");
//					ps.executeQuery();
				rs = ps.executeQuery();
				while (rs.next()) {
					UserBean userBean = new UserBean();
					userBean.setUserId(rs.getInt(1));
					userBean.setFiratName(rs.getString(2));
					userBean.setLastName(rs.getString(3));
					userBean.setDob(rs.getString(4));
					userBean.setMobailNo(rs.getString(7));
					userBean.setGender(rs.getString(8));
					userBean.setLanguage(rs.getString(9));
					userBean.setEmail(rs.getString(10));
					list.add(userBean);
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

		return list;
	}

	// Delete User.
	@Override
	public int deleteUserById(Connection conn, int UserId) {
		BasicConfigurator.configure();

		PreparedStatement ps = null;
		try {
			if (conn != null) {
				String sql = "DELETE FROM user WHERE UserId=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, UserId);
				ps.executeUpdate();
				log.info("Delete User successfully");
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

	// Update User Details.
	public int updateEmployeeDetails(Connection con, UserBean userBean) {

		PreparedStatement ps = null;
		int status = 0;
		try {
			if (con != null) {
				String sql = "update user set FirstName=?, LastName=?, DOB=?, Gender=?, Hobby=?, Password=? where UserId=?";
				ps = con.prepareStatement(sql);

				ps.setString(1, userBean.getFiratName());
				ps.setString(2, userBean.getLastName());
				ps.setString(3, userBean.getDob());
				ps.setString(4, userBean.getGender());
				ps.setString(5, userBean.getLanguage());
				ps.setString(6, userBean.getPassword());
				ps.setInt(7, userBean.getUserId());
				status = ps.executeUpdate();
				log.info("Update User successfully");
				return status;
			} else {
				log.info("Connection Is Null");
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e2) {
				log.info(e2);
			}
		}
		return status;
	}

	// Forgot Password.
	@Override
	public int forgetPassword(Connection conn, String email, String answer) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		int Id = 0;
		try {
			if (conn != null) {
				log.info("forget password");
				String sql = "SELECT * FROM user WHERE Email=? and Answer=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, email);
				ps.setString(2, answer);
				rs = ps.executeQuery();
				rs.next();
				Id = rs.getInt(1);
				rs.close();
				return Id;
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
		return Id;
	}

	// Update Password.
	@Override
	public int updatePassword(Connection conn, int UserId, String Password) {
		PreparedStatement ps = null;
		int status = 0;
		try {
			if (conn != null) {
				String sql = "update user set Password=? where UserId=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, Password);
				ps.setInt(2, UserId);
				status = ps.executeUpdate();
				log.info("Update Password successfully");
				return status;
			} else {
				log.info("Connection Is Null");
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e2) {
				log.info(e2);
			}
		}
		return status;
	}
}
