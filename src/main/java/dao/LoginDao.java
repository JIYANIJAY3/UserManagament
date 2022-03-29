package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

public class LoginDao implements LoginDaoInterface {
	static Logger log = Logger.getLogger(RegistrationDao.class.getName());

	public String loginUser(Connection conn, String Email, String password) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		String role = " ";
		if (conn != null) {
			try {
				String sql = "SELECT Role FROM user WHERE Email=? and Password=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, Email);
				ps.setString(2, password);
				rs = ps.executeQuery();
				rs.next();
				role = rs.getString(1);
				rs.close();
				return role;
			} catch (Exception e) {
				log.info(e);
			}
		} else {
			log.info("Connection Is Null");
		}
		return role;
	}
}
