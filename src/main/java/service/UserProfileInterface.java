package service;

import java.sql.Connection;
import java.util.List;

import bean.UserProfileBean;

public interface UserProfileInterface {
	 int addUserprofile(Connection conn,UserProfileBean userProfile);
	 List<UserProfileBean> getUserImg(Connection conn, int userid);
	 int deleteImage(Connection conn, int imageId);
}
