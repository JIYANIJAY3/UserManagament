package dao;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import bean.UserAddressBean;
import bean.UserBean;
import jakarta.servlet.http.Part;

public class RegistrationDao implements RegistrationDaoInterface {

	static Logger log = Logger.getLogger(RegistrationDao.class.getName());

	@Override
	public int addEmployee(Connection conn, UserBean userBean) {
		BasicConfigurator.configure();
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
	public int addEmployeeAddress(Connection conn, List<UserAddressBean> addressList) {

		PreparedStatement ps = null;

		if (conn != null) {
			try {
				String setAddress = "INSERT INTO address(AddressId, UserId, Country, Address, PinCode, City, State) "
						+ "VALUES (NULL,?,?,?,?,?,?)";
				ps = conn.prepareStatement(setAddress);
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
					Blob blob = rs.getBlob(12);

					InputStream inputStream = blob.getBinaryStream();
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					byte[] buffer = new byte[4096];
					int bytesRead = -1;

					while ((bytesRead = inputStream.read(buffer)) != -1) {
						outputStream.write(buffer, 0, bytesRead);
					}

					byte[] imageBytes = outputStream.toByteArray();
					String base64Image = Base64.getEncoder().encodeToString(imageBytes);

					inputStream.close();
					outputStream.close();
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
					userBean.setBase64Image(base64Image);
				}
			} catch (Exception e) {
				log.info(e);
			}
		} else {
			log.error("Connection is Null");
		}

		return userBean;
	}

	@Override
	public List<UserBean> getAllUser(Connection conn) {

		List<UserBean> list = new ArrayList<UserBean>();
		if (conn != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				String sql = "SELECT * FROM user where Role=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "User");
				ps.executeQuery();
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

			} catch (Exception e) {
				log.info(e);
			}
		} else {
			log.info("Connection Is Null");
		}

		return list;
	}

	@Override
	public int deleteUserById(Connection conn, int UserId) {
		BasicConfigurator.configure();
		if (conn != null) {
			PreparedStatement ps = null;
			;
			try {
				String sql = "DELETE FROM user WHERE UserId=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, UserId);
				ps.executeUpdate();
				System.out.println("done");
				return 1;
			} catch (Exception e) {
				log.info(e);
			}
		} else {
			log.info("In UserDao DeleteUserById Method Connection is null");
		}

		return 0;
	}


}
