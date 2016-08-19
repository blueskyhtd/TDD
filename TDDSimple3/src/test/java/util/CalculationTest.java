package util;

import org.junit.Assert;
import org.junit.Test;

public class CalculationTest {

	@Test
	public void testSum() {
		Calculation cal = new Calculation();
		Assert.assertEquals("Check sum 5 + 3 = 8", 8, cal.add(5, 3));
	}

}
