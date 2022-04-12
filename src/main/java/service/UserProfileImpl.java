package service;

import java.sql.Connection;
import java.util.List;

import bean.UserProfileBean;
import dao.UserProfileDao;

public class UserProfileImpl implements UserProfileInterface {

	UserProfileDao profiledao = new UserProfileDao();
	@Override
	public int addUserprofile(Connection conn,UserProfileBean userProfile) {
		
		return profiledao.addUserprofile(conn, userProfile);
	}
	@Override
	public List<UserProfileBean> getUserImg(Connection conn, int userid) {
		
		return profiledao.getUserImg(conn, userid);
	}
	@Override
	public int deleteImage(Connection conn, int imageId) {
		
		return profiledao.deleteImage(conn, imageId);
	}

}
