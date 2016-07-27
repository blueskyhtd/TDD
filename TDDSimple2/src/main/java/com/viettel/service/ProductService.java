package com.viettel.service;

import java.util.List;

import com.viettel.entity.Product;

public interface ProductService {

	public int add(Product product);

	public boolean remove(int id);

	public void edit(int id, Product product);

	public List<Product> getAll();

	public Product getById(int id);
}
