package dao;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import bean.UserAddressBean;
import bean.UserBean;
import jakarta.servlet.http.Part;

public class RegistrationDao implements RegistrationDaoInterface {

	static Logger log = Logger.getLogger(RegistrationDao.class.getName());

	@Override
	public int addEmployee(Connection conn, UserBean userBean) {

		int result = 0;
		if (conn != null) {
			PreparedStatement ps = null;
			try {

				String sql = "INSERT INTO user(UserId, FirstName, LastName, DOB, Role, Answer, MobailNo, Gender, Hobby, Email, Password, Profile) VALUES(null,?,?,?,?,?,?,?,?,?,?,?)";

//				System.out.println(userBean.getFiratName());
//				System.out.println(userBean.getLastName());
//				System.out.println(userBean.getDob());
//				System.out.println(userBean.getAnswer());
//				System.out.println(userBean.getMobailNo());
//				System.out.println(userBean.getGender());
//				System.out.println(userBean.getEmail());
//				System.out.println(userBean.getPassword());
//				System.out.println(userBean.getProfile());

				ps = conn.prepareStatement(sql);
				InputStream inputStream = null;

				Part part = userBean.getProfile();
				inputStream = part.getInputStream();

				if (inputStream != null) {
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
					ps.setBlob(11, inputStream);
					result = ps.executeUpdate();
					return result;
				} else {
					log.info("Profile Is NULL");
					return result;
				}
			} catch (Exception e) {
				log.error(e);
			}

		} else {
			log.info("Connection Is NULL");
		}
		return result;
	}

	@Override
	public int addEmployeeAddress(Connection conn, UserAddressBean addressBean) {

		PreparedStatement ps = null;

		if (conn != null) {
			try {
				String setAddress = "INSERT INTO address(AddressId, UserId, Country, Address, PinCode, City, State) "
						+ "VALUES (NULL,?,?,?,?,?,?)";
				ps = conn.prepareStatement(setAddress);
				for (int i = 0; i < addressBean.getCountry().length; i++) {
					ps.setInt(1, addressBean.getUserId());
					ps.setString(2, addressBean.getCountry()[i]);
					ps.setString(3, addressBean.getAddress()[i]);
					ps.setString(4, addressBean.getPinCode()[i]);
					ps.setString(5, addressBean.getCity()[i]);
					ps.setString(6, addressBean.getState()[i]);
					ps.addBatch();
				}
				ps.executeBatch();
				log.info("done");
			} catch (Exception e) {
				log.info(e);
			}
		} else {
			log.error("Connection Is Null");
		}

		return 0;
	}

	@Override
	public int getEmployeeId(Connection conn, String Email) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = 0;
		if (conn != null) {
			try {
				String sql = "SELECT UserId From user WHERE Email=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, Email);
				rs = ps.executeQuery();
				rs.next();
				id = rs.getInt(1);

				return id;
			} catch (Exception e) {
				log.error(e);
			}
		} else {
			log.error("Connection Is NULL");
		}
		return id;
	}

	@Override
	public boolean getEmailIsPresent(Connection conn, String Email) {

		if (conn != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				String sql = " SELECT * FROM user WHERE Email=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, Email);
				rs = ps.executeQuery();
				return rs.next();
			} catch (Exception e) {
				log.info(e);
			}
		} else {
			log.error("Connection Is NULL");
		}
		return false;

	}

	public UserBean getEmployeeByEmail(Connection con, String email) {
		UserBean userBean = new UserBean();
		PreparedStatement ps = null;
		ResultSet rs = null;

		if (con != null) {
			try {
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
					userBean.setMobailNo(rs.getString(7));
					userBean.setGender(rs.getString(8));
					userBean.setLanguage(rs.getString(9));
					userBean.setEmail(rs.getString(10));
					userBean.setPassword(rs.getString(11));
					userBean.setProfile((Part) rs.getBlob(12));
				}
			} catch (Exception e) {
				log.info(e);
			}
		} else {
			log.error("Connection is Null");
		}

		return userBean;
	}

}
