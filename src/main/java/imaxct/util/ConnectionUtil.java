package imaxct.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static String DB_CLASS_NAME = "com.mysql.jdbc.Driver";
	private static String DB_USERNAME = "root";
	private static String DB_PASSWORD = "1234";
	private static String DB_NAME = "test";
	private static String DB_HOST = "127.0.0.1";
	private static String DB_PORT = "3306";
	private static String url = null;
	private static Connection connection = null;

	static {
		try {
			Class.forName(DB_CLASS_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		url = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME
				+ "?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull";
	}

	public static Connection getConnection() {
		try {
			if (connection == null || connection.isClosed())
				connection = (Connection) DriverManager.getConnection(url, DB_USERNAME, DB_PASSWORD);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void close(Connection conn) {
		try {
			if (conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
