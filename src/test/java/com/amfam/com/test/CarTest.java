package com.amfam.com.test;

import org.testng.annotations.Test;

import base.BaseClass;

public class CarTest extends BaseClass {
	
	@Test
	public void carTest() {
		landingPage.clickCar(commonActions);
		zipCodePage1.inputZipCode(commonActions, "07522");
		zipCodePage1.clickOnStartQuoting(commonActions);
		getAQuotePage.clickOnQuote(commonActions);
		zipCodePage2.inputZipcode2(commonActions, "07522");
		zipCodePage2.selectByIndex();
		zipCodePage2.clickonQuote(commonActions);
		
		
		
	}
}
