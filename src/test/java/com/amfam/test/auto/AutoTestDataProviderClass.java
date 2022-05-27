package com.amfam.test.auto;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.AutoData;

public class AutoTestDataProviderClass extends BaseClass{
	
	@DataProvider(name = "autoData")
	public Iterator<AutoData> autoData() {
		ArrayList<AutoData> list = new ArrayList<AutoData>();
		AutoData toyotaData = new AutoData("07424", "07424", "A", "Palace", 'Z', "Laundromat", "01231982", "youcanemail@gmail.com", "Woodland Park", "1116 McBride Ave", 
				"NJ", "07424", "2003", "2021", "TYTA", "CAMRY LE AWD", "SEDAN 4D, V4, 2.5L, 4WD", "002", "3", "3", "2", "3", "1");
		AutoData hondaData = new AutoData("07508", "07508", "A", "Jimmy", 'Z', "Butler", "12251988", "reachme@gmail.com", "Haledon", "373 Hobart Ave", 
				"NJ", "07508", "2003", "2021", "HOND", "CIVIC SPORT", "HCHBK 4D, V4, 1.5L, 2WD", "002", "2", "3", "2", "3", "2");
		list.add(toyotaData);
		list.add(hondaData);
		return list.iterator();
	}
		 
			
	
	@Test(enabled = true, priority = 1, groups = {"externalData, auto"}, dataProvider = "autoData")
	public void autoTestWithDataProviderClass(AutoData autoData) {
		landingPage.landingPageSteps(commonActions);
		zipCodePage1.zipCodePage1Steps(commonActions, autoData);
		getAQuotePage.getAQuotePageSteps(commonActions);
		zipCodePage2.zipCodePage2Steps(commonActions, autoData);
		policyHolderDetailsPage.policyHolderDetailsPageSteps(commonActions, autoData);
		vehicleDetailsPages.vehicleDetailsPagesSteps(commonActions, autoData);
	}
	

}
