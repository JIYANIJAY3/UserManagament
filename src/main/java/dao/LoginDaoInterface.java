package dao;

import java.sql.Connection;

public interface LoginDaoInterface {
	public String loginUser(Connection conn,String Email,String password);
}
