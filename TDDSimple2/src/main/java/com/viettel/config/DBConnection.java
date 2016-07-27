package com.viettel.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static final String DATABASE_DRIVER = "org.h2.Driver";

	public static final String DATABASE_PREFIX = "jdbc:h2:file:/F:/Setup/h2/database/tdd";
	public static final String DATABASE_HOST = "";
	public static final String DATABASE_SCHEMA = "";

	public static final String DATABASE_URL = DATABASE_PREFIX + DATABASE_HOST
			+ DATABASE_SCHEMA;

	public static final String DATABASE_USERNAME = "sa";
	public static final String DATABASE_PASSWORD = "123456a@";

	private static DBConnection dbConnection;
	private Connection conn;

	public static DBConnection getInstance() {
		dbConnection = new DBConnection();
		return dbConnection;
	}

	public Connection getConnect() {
		try {
			Class.forName(DATABASE_DRIVER);
			conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME,
					DATABASE_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void close() throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}
}
