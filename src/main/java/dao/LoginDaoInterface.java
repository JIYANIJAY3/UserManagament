package dao;

import java.sql.Connection;

public interface LoginDaoInterface {
	 String loginUser(Connection conn,String Email,String password);
}
