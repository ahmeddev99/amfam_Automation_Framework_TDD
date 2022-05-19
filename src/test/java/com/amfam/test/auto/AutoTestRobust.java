package com.amfam.test.auto;

import org.testng.annotations.Test;

import base.BaseClass;

public class AutoTestRobust extends BaseClass {
	
	@Test(enabled = true, groups = {"auto","honda"})
	public void hondaTest() {
		landingPage.landingPageSteps(commonActions);
		zipCodePage1.zipCodePage1Steps(commonActions, "07457");
		getAQuotePage.getAQuotePageSteps(commonActions);
		zipCodePage2.zipCodePage2Steps(commonActions, "07457", "A");
		policyHolderDetailsPage.policyHolderDetailsPageSteps(commonActions, "Pippen", 'Z', "Jordan", "01231982", "youcanemail@gmail.com", "Riverdale", "1 S Corporate Dr", "NJ", "07457", "2003");
		vehicleDetailsPages.vehicleDetailsPagesSteps(commonActions, "2021", "HOND", "CIVIC SPORT", "HCHBK 4D, V4, 1.5L, 2WD", "002", "2", "3", "2", "3", "2");
	}
	
	
	@Test(enabled = true, groups = {"auto","bmw"})
	public void bmwTest() {
		landingPage.landingPageSteps(commonActions);
		zipCodePage1.zipCodePage1Steps(commonActions, "07457");
		getAQuotePage.getAQuotePageSteps(commonActions);
		zipCodePage2.zipCodePage2Steps(commonActions, "07457", "A");
		policyHolderDetailsPage.policyHolderDetailsPageSteps(commonActions, "Pippen", 'Z', "Jordan", "01231982", "youcanemail@gmail.com", "Riverdale", "1 S Corporate Dr", "NJ", "07457", "2003");
		vehicleDetailsPages.vehicleDetailsPagesSteps(commonActions, "2021", "BMW", "M340I XDRIVE", "SEDAN 4D, V6, 3L, 4WD", "002", "2", "3", "2", "3", "2");
	}
	
	@Test(dependsOnMethods = "hondaTest")
	public void autoTest1() {
		
	}
}
