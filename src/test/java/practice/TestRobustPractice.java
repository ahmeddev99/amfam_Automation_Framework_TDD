package practice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;

public class TestRobustPractice extends BaseClass {
	
	@Parameters({"zipvalue", "firstname"})
	@Test(enabled = true, groups = {"auto","toyota"})
	public void toyotaTest(String zipValue, String firstName) {
		landingPage.landingPageSteps(commonActions);
		zipCodePage1.zipCodePage1Steps(commonActions, "07457");
		getAQuotePage.getAQuotePageSteps(commonActions);
		zipCodePage2.zipCodePage2Steps(commonActions, "07457", "A");
		policyHolderDetailsPage.policyHolderDetailsPageSteps(commonActions, "Pippen", 'Z', "Jordan", "01231982", "youcanemail@gmail.com", "Riverdale", "1 S Corporate Dr", "NJ", "07457", "2003");
		vehicleDetailsPages.vehicleDetailsPagesSteps(commonActions, "2021", "TYTA", "CAMRY LE AWD", "SEDAN 4D, V4, 2.5L, 4WD", "002", "3", "3", "2", "3", "1");
	}
	
	
	@Test(enabled = true, groups = {"auto","toyota"})
	public void toyotaTestWithoutParam() {
		landingPage.landingPageSteps(commonActions);
		zipCodePage1.zipCodePage1Steps(commonActions, "07457");
		getAQuotePage.getAQuotePageSteps(commonActions);
		zipCodePage2.zipCodePage2Steps(commonActions, "07457", "A");
		policyHolderDetailsPage.policyHolderDetailsPageSteps(commonActions, "Pippen", 'Z', "Jordan", "01231982", "youcanemail@gmail.com", "Riverdale", "1 S Corporate Dr", "NJ", "07457", "2003");
		vehicleDetailsPages.vehicleDetailsPagesSteps(commonActions, "2021", "BMW", "M3", "SEDAN 4D, V4, 2.5L, 4WD", "002", "3", "3", "2", "3", "1");
	}
	
	
	@Test(enabled = true, priority = 1, groups = {"auto","honda"})
	public void hondaTest() {
		landingPage.landingPageSteps(commonActions);
		zipCodePage1.zipCodePage1Steps(commonActions, "07457");
		getAQuotePage.getAQuotePageSteps(commonActions);
		zipCodePage2.zipCodePage2Steps(commonActions, "07457", "A");
		policyHolderDetailsPage.policyHolderDetailsPageSteps(commonActions, "Pippen", 'Z', "Jordan", "01231982", "youcanemail@gmail.com", "Riverdale", "1 S Corporate Dr", "NJ", "07457", "2003");
		vehicleDetailsPages.vehicleDetailsPagesSteps(commonActions, "2021", "HOND", "CIVIC SPORT", "HCHBK 4D, V4, 1.5L, 2WD", "002", "2", "3", "2", "3", "2");
	}
	
	@Test(enabled = false, dependsOnMethods = "hondaTest", ignoreMissingDependencies = true, groups = {"honda"})
	public void dependsOnMethod() {	
	}
	
	@Test(dependsOnGroups = {"toyota"}, ignoreMissingDependencies = true, alwaysRun = true, enabled = false)
	public void dependsOnGroups() {
		
	}
	
	
	
	
}
