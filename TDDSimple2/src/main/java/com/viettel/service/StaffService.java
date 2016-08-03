package com.viettel.service;

public interface StaffService {

	public int calculate(BillService billService, int billId);

	public double calculate(BillService billService, int billId,
			double exchangeRate);
}
