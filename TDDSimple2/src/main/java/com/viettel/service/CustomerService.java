package com.viettel.service;

import java.util.List;

import com.viettel.entity.Customer;
import com.viettel.entity.Product;

public interface CustomerService {

	public int add(Customer customer);

	public void edit(int id, Customer customer);

	public boolean delete(int id);

	public List<Customer> getAll();

	public Customer getById(int id);

	public boolean buyProduct(Product product);
}
