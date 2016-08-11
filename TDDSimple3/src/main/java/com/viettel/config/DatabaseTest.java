package com.viettel.config;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

public class DatabaseTest {

	private static DatabaseTest databaseTest;
	private IDatabaseConnection dbConnection;

	public static DatabaseTest getInstance() {
		databaseTest = new DatabaseTest();
		return databaseTest;
	}

	public IDatabaseConnection connect(HttpServletRequest request)
			throws DatabaseUnitException, IOException {
		Connection conn = DBConnection.getInstance().getConnect(request);
		dbConnection = new DatabaseConnection(conn, "APP");
		return dbConnection;
	}

	public static IDataSet readDataset(String filename)
			throws MalformedURLException, DatabaseUnitException, SQLException {
		return new FlatXmlDataSetBuilder().build(new File(filename));

	}

	public static void insertData(IDatabaseConnection connection,
			IDataSet dataset) throws DatabaseUnitException, SQLException {
		DatabaseOperation.CLEAN_INSERT.execute(connection, dataset);
	}

	public static void clearData(IDatabaseConnection connection,
			IDataSet dataset) throws DatabaseUnitException, SQLException {
		DatabaseOperation.DELETE.execute(connection, dataset);
	}
}
