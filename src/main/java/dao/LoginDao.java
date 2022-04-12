package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;

public class LoginDao implements LoginDaoInterface {
	static Logger log = Logger.getLogger(RegistrationDao.class.getName());

	// Login User And User
	public String loginUser(Connection conn, String Email, String password) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		String role = " ";
		try {
			if (conn != null) {
				String sql = "SELECT * FROM user WHERE Email=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, Email);
				rs = ps.executeQuery();
				while (rs.next()) {
					if (BCrypt.checkpw(password, rs.getString(11))) {
						role = rs.getString(5);
					}
				}
				log.info(role);
//					role = rs.getString(1);
//					rs.close();
//					log.info("USER Role");
				return role;
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
		return role;
	}
}
