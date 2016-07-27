package com.viettel.service;

import java.util.List;

import com.viettel.entity.Bill;

public interface BillService {

	public int add(Bill bill);

	public boolean remove(int id);

	public void edit(int id, Bill bill);

	public List<Bill> getAll();

	public Bill getById(int id);
}
