package application.test;

import org.junit.runner.JUnitCore;

public class JUnitTest {
	public static void main(String[] arg) {
		JUnitCore junit = new JUnitCore();
		junit.run(LoginDaoTest.class);
	}
}
