package com.amfam.test.home;

import org.testng.annotations.Test;

public class HomeTest {
	
	@Test(groups = {"home"})
	public void homeTest1() {
		System.out.println("Running Home Test One");
	}
	
	@Test(groups = {"home"})
	public void homeTest2() {
		System.out.println("Running Home Test Two");
	}

}
