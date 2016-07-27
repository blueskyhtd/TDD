package com.viettel.config;

import java.io.File;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

public class DatabaseTest {

	public static final String DIC_BASE = "F:\\Workspace\\test";

	private static DatabaseTest databaseTest;
	private IDatabaseConnection dbConnection;

	public static DatabaseTest getInstance() {
		databaseTest = new DatabaseTest();
		return databaseTest;
	}

	public IDatabaseConnection connect() throws DatabaseUnitException {
		Connection conn = DBConnection.getInstance().getConnect();
		dbConnection = new DatabaseConnection(conn);
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
