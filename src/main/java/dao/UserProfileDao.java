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

import org.apache.log4j.Logger;

import bean.UserProfileBean;

public class UserProfileDao implements UserProfileleDaoInterface {

	static Logger log = Logger.getLogger(UserProfileDao.class.getName());

	// Add User Profile.
	@Override
	public int addUserprofile(Connection conn, UserProfileBean userProfile) {

		PreparedStatement ps = null;
		try {
			if (conn != null) {
				String sql = "INSERT INTO userprofile(ImageId, UserId, Profile) VALUES (null,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, userProfile.getUserId());
				ps.setBlob(2, userProfile.getImage());
				ps.executeUpdate();
				log.info("Profile added successfully");
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

	// Get All User Profile.
	@Override
	public List<UserProfileBean> getUserImg(Connection conn, int userid) {

		List<UserProfileBean> profileList = new ArrayList<UserProfileBean>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			if (conn != null) {
				Blob profile = null;
				String sql = "SELECT * FROM userprofile WHERE UserId = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, userid);
				rs = ps.executeQuery();
				while (rs.next()) {
					profile = rs.getBlob(3);
					InputStream inputStream = profile.getBinaryStream();
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					byte[] buffer = new byte[4096];
					int bytesRead = -1;

					while ((bytesRead = inputStream.read(buffer)) != -1) {
						outputStream.write(buffer, 0, bytesRead);
					}
					byte[] imageBytes = outputStream.toByteArray();

					String base64Image = Base64.getEncoder().encodeToString(imageBytes);
					UserProfileBean userprofile = new UserProfileBean();
					userprofile.setBase64Image(base64Image);
					userprofile.setImageId(rs.getInt(1));
					profileList.add(userprofile);
				}
				log.info("get all profile successfully");
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
		return profileList;
	}

	// Delete User Profile
	@Override
	public int deleteImage(Connection conn, int imageId) {

		PreparedStatement ps = null;
		try {
			if (conn != null) {
				String sql = "DELETE FROM userprofile WHERE ImageId=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, imageId);
				ps.executeUpdate();
				log.info("Delete User Profile successfully");
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
