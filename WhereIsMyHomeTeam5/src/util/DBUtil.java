package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static Connection con;
	static {
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}

	public static Connection getConnection() throws SQLException {
		if (con == null || con.isClosed()) {
			con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/whereismyhome?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
					"ssafy", "ssafy");
		}
		return con;
	}
	
	public static void close(AutoCloseable... closes) throws Exception {

		for (AutoCloseable close : closes) {
			close.close();
		}
	}
	
}
