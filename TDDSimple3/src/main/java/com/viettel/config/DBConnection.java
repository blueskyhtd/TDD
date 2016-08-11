package com.viettel.config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class DBConnection {
	public static final String DATABASE_DRIVER = "org.h2.Driver";

	public static final String DATABASE_TYPE = "jdbc:h2:file:/";

	public static final String DATABASE_ROOT = "/database/tdd";

	public static final String DATABASE_USERNAME = "sa";
	public static final String DATABASE_PASSWORD = "123456a@";

	private static DBConnection dbConnection;
	private Connection conn;

	public static DBConnection getInstance() {
		dbConnection = new DBConnection();
		return dbConnection;
	}

	public Connection getConnect(HttpServletRequest request) throws IOException {
		try {
			Class.forName(DATABASE_DRIVER);
			String DATABASE_URL = DATABASE_TYPE + request.getRealPath(".")
					+ DATABASE_ROOT;
			System.out.println(DATABASE_URL);

			conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME,
					DATABASE_PASSWORD);

//			conn = DriverManager
//					.getConnection(
//							"jdbc:h2:file:/F:/Tool/apache-tomcat-7.0.70/wtpwebapps/TDDSimple3/database/tdd",
//							DATABASE_USERNAME, DATABASE_PASSWORD);

			DatabaseMetaData md = conn.getMetaData();
			ResultSet rs = md.getTables(null, null, "USER", null);
			while (rs.next()) {
				System.out.println(rs.getString(3));
			}
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
