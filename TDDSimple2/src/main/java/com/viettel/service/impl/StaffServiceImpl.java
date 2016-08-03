package com.viettel.service.impl;

import java.util.Map.Entry;

import com.viettel.entity.Bill;
import com.viettel.entity.Product;
import com.viettel.service.BillService;
import com.viettel.service.StaffService;

public class StaffServiceImpl implements StaffService {

	// caculate cost of bill
	public int calculate(BillService billService, int billId) {
		Bill bill = billService.getById(billId);

		int sum = 0;
		if (bill != null && bill.getProducts() != null) {

			for (Entry<Product, Integer> entry : bill.getProducts().entrySet()) {
				// wrong code
				// sum = sum + entry.getKey().getPrice() + entry.getValue();

				// right code
				sum += entry.getKey().getPrice() * entry.getValue();
			}
		}

		return sum;
	}

	public double calculate(BillService billService, int billId,
			double exchangeRate) {
		return calculate(billService, billId) * exchangeRate;
	}

}
