package com.viettel.dao;

import java.sql.SQLException;

import com.viettel.entity.Product;

public interface ProductDao {

	public Product getById(int id) throws SQLException;

	public int insert(Product product);
}
