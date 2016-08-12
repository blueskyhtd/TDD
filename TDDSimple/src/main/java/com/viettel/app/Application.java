package com.viettel.app;

import org.junit.runner.JUnitCore;

import com.viettel.app.test.TestSuite;

public class Application {

	public static void main(String[] arg) {
		JUnitCore junit = new JUnitCore();
		junit.run(TestSuite.class);
	}
}
