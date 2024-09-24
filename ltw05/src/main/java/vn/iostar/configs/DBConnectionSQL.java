package vn.iostar.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionSQL {
	private final String serverName = "localhost";
	private final String dbName = "ltw04";
	private final String portNumber = "1433";
	private final String userID = "sa";
	private final String password = "123";

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		// Load SQL Server JDBC driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		// Build connection string
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;

		// Return connection object
		return DriverManager.getConnection(url, userID, password);
	}

	public static void main(String[] args) {
		try {
			System.out.println(new DBConnectionSQL().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
