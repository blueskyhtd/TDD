package com.viettel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.viettel.config.DBConnection;
import com.viettel.dao.ProductDao;
import com.viettel.entity.Product;

public class ProductDaoImpl implements ProductDao {

	private Connection connection;

	public ProductDaoImpl() {
		connection = DBConnection.getInstance().getConnect();
	}

	public Product getById(int id) throws SQLException {
		String sql = "SELECT * FROM PRODUCT WHERE ID = ?";
		PreparedStatement state = connection.prepareStatement(sql);
		state.setInt(1, id);
		ResultSet result = state.executeQuery();

		if (result != null && result.next()) {
			Product product = new Product(result.getInt("ID"),
					result.getString("NAME"), result.getInt("PRICE"));
			return product;
		}

		return null;

	}

	public int insert(Product product) {
		String sql = "INSERT INTO PRODUCT VALUES(ID,NAME,PRICE) AS (?,?,?)";

		return 0;
	}

}
