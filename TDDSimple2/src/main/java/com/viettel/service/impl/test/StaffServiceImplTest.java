package com.viettel.service.impl.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.mockito.Mockito;

import com.viettel.entity.Bill;
import com.viettel.entity.Product;
import com.viettel.service.BillService;
import com.viettel.service.StaffService;
import com.viettel.service.impl.StaffServiceImpl;

public class StaffServiceImplTest {

	@Test
	public void testCalculate() {
		// Setup
		Map<Product, Integer> map = new HashMap<Product, Integer>();
		Product product1 = new Product(1, "Snack", 50);
		Product product2 = new Product(2, "Candy", 7);
		Product product3 = new Product(2, "Cream", 3);

		map.put(product1, 3);
		map.put(product2, 200);
		map.put(product3, 60);

		BillService billService = mock(BillService.class);
		Bill tempBill = new Bill();
		tempBill.setProducts(map);

		Mockito.when(billService.getById(1)).thenReturn(tempBill);

		// Execution
		StaffService service = new StaffServiceImpl();
		int sum = service.calculate(billService, 1);

		// Verification
		Mockito.verify(billService, Mockito.times(1)).getById(1);
		assertEquals("Check bill", 150 + 1400 + 180, sum);
		
	}
}
