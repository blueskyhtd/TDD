package com.viettel.app.test;

import org.junit.Assert;
import org.junit.Test;

import com.viettel.app.Calculation;

public class CalculationTest {

	@Test
	public void testSum() {
		Calculation cal = new Calculation();
		Assert.assertEquals("Check sum 5 + 3 = 8", 8, cal.add(5, 3));
	}

}
