package com.viettel.dao.impl.test;

import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.viettel.config.DatabaseTest;
import com.viettel.dao.ProductDao;
import com.viettel.dao.impl.ProductDaoImpl;
import com.viettel.entity.Product;

public class ProductDaoImplTest {

	public static final String fileData = "./datatest/products.xml";

	private IDataSet dataset;
	private IDatabaseConnection conn;

	@Before
	public void setup() throws Exception {
		conn = DatabaseTest.getInstance().connect();
		dataset = DatabaseTest.readDataset(fileData);
		DatabaseTest.insertData(conn, dataset);
	}

	@Test
	//Test with DBUnit
	public void testGetById() throws SQLException {
		ProductDao productDao = new ProductDaoImpl();
		Product product = productDao.getById(2);

		Assert.assertEquals("product id = 2", 2, product.getId());
		Assert.assertEquals("product name = Chocolate", "Chocolate",
				product.getName());
		Assert.assertEquals("product  price = 2", 2, product.getPrice());
	}

	@After
	public void tearDown() throws DatabaseUnitException, SQLException {
		DatabaseTest.clearData(conn, dataset);
	}

}
