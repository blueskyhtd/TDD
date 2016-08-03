package com.viettel.service.impl.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.viettel.entity.Bill;
import com.viettel.entity.Product;
import com.viettel.service.BillService;
import com.viettel.service.StaffService;
import com.viettel.service.impl.StaffServiceImpl;

@RunWith(PowerMockRunner.class)
@PrepareForTest(value = { Math.class })
public class StaffServiceImplTest {

	private Bill tempBill;

	@Before
	public void setup() {
		Map<Product, Integer> map = new HashMap<Product, Integer>();
		Product product1 = new Product(1, "Snack", 50);
		Product product2 = new Product(2, "Candy", 7);
		Product product3 = new Product(2, "Cream", 3);

		map.put(product1, 3);
		map.put(product2, 200);
		map.put(product3, 60);
		tempBill = new Bill();
		tempBill.setProducts(map);
	}

	@Test
	// Test with mockito
	public void testCalculate() {
		// Setup
		BillService billService = mock(BillService.class);
		Mockito.when(billService.getById(1)).thenReturn(tempBill);

		// Execution
		StaffService service = new StaffServiceImpl();
		int sum = service.calculate(billService, 1);

		// Verification
		Mockito.verify(billService, Mockito.times(1)).getById(1);
		assertEquals("Check bill", 1730, sum);
	}

	@Test
	public void testCaculateWithRate() {
		// Setup
		BillService billService = mock(BillService.class);
		Mockito.when(billService.getById(1)).thenReturn(tempBill);

		// wrong code
		// Mockito.mock(Math.class);
		// Mockito.when(Math.random()).thenReturn(0.2);

		// right code
		PowerMockito.mockStatic(Math.class);
		PowerMockito.when(Math.random()).thenReturn(0.2d);

		// Execution
		StaffService service = new StaffServiceImpl();
		double sum = service.calculate(billService, 1, Math.random());

		// Verification
		Mockito.verify(billService, Mockito.times(1)).getById(1);
		assertEquals(0.2 * 1730, sum, 0.0);
	}
}
