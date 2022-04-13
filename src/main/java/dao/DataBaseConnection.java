package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class DataBaseConnection {

	private static Connection conn = null;

	private DataBaseConnection() {
	}

	static Logger log = Logger.getLogger(DataBaseConnection.class.getName());
	static {
		BasicConfigurator.configure();
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(
					"\\Users\\ADMIN\\eclipse-workspace\\UserManagement\\src\\main\\webapp\\WEB-INF\\lib\\database.properties");
			prop.load(input);
			String url = "jdbc:mysql://localhost:3306/usermanagment";
			String user = prop.getProperty("User");
			String password = prop.getProperty("Password");

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, user, password);
				log.info("Connection Successful....");
			} catch (ClassNotFoundException | SQLException e) {
				log.error(e);
			}
		} catch (IOException e1) {
			log.info(e1);
		} finally {
			try {
				if (input != null)
					input.close();
			} catch (IOException e) {
				log.info(e);
			}
		}

	}

	public static Connection getConnection() {
		return conn;
	}

	public static Connection closeConnection() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			log.info(e);
		}
		return conn;
	}
}
