package util;

import org.junit.Assert;
import org.junit.Test;

public class Calculation2Test {

	@Test
	public void test() {
		Calculation2 cal = new Calculation2();
		Assert.assertEquals("Sub of 5-3=2", 2 , cal.sub(5, 3));
	}

}
