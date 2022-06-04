package com.amfam.test.auto;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseClass;
import utils.ExcelUtils;
import utils.ReadConfigFile;


public class AutoTestExcelDataProvider extends BaseClass {

	@DataProvider(name = "autoData")
	public Object[][] dataObjects(){
		String filePath = ReadConfigFile.getInstance().getExcelPath();
		String sheetName = ReadConfigFile.getInstance().getSheetName();
		ExcelUtils excelUtils = new ExcelUtils(filePath, sheetName);
		System.out.println(excelUtils.dataTable().length);
		return excelUtils.dataTable();
	}
	
	@Test(dataProvider = "autoData", groups = {"excel"})
	public void toyotaTest(String title,String zipCode1, String zipCode2, String typeInsurance, String firstName, String middleName, String lastName, String dob, 
			String email, String city, String streetAddress, String State, String zipcode, String atTheAddress, String vYear, String vMake, String vModel, 
			String vTrim, String vCoverage, String titleHolder, String airBag, String antiTheft, String parked, String primarilyUsed) {
		landingPage.landingPageSteps(commonActions, title);
		zipCodePage1.zipCodePage1Steps(commonActions, zipCode1);
		getAQuotePage.getAQuotePageSteps(commonActions);
		zipCodePage2.zipCodePage2Steps(commonActions, zipCode2, typeInsurance);
		policyHolderDetailsPage.policyHolderDetailsPageSteps(commonActions, firstName, middleName.charAt(0), lastName, dob, email, city, streetAddress, State, 
				zipcode, atTheAddress);
		vehicleDetailsPages.vehicleDetailsPagesSteps(commonActions, vYear, vMake, vModel, vTrim, vCoverage, titleHolder, airBag, antiTheft, parked, primarilyUsed);
	}
	
	
}
