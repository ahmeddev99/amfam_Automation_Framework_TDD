package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.AdditionalHttpCommands;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.CommonActions;

public class VehicleDetailsPages {
	
	public VehicleDetailsPages(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "F_year_0") WebElement vehicleYear;
	@FindBy(id = "F_make_0") WebElement vehicleMake;
	@FindBy(id = "F_model_0") WebElement vehicleModel;
	@FindBy(id = "F_subModel_0") WebElement vehicleTrime;
	@FindBy(id = "F_coverage_0") WebElement vehicleCoverage;
	@FindBy(id = "F_ownerTitle_0") WebElement vehicleTitleHolder;
	@FindBy(id = "F_airbags_0") WebElement vehicleAirBags;
	@FindBy(id = "F_alarm_0") WebElement vehicleAntiTheft;
	@FindBy(id = "F_residentialParking_0") WebElement vehicleParked;
	@FindBy(xpath = "//select[@id='F_usage_0']") WebElement vehiclePrimarilyUsed;
	@FindBy(xpath = "//input[@id='F_anotherVehicle_id_0_1']") WebElement AdditionalVehicles;
	@FindBy(id = "F_continue_0") WebElement detailsPagesContinue;
	
	public void vehicleYear(CommonActions commonActions, String year) {
		commonActions.inputText(vehicleYear, year);
	}
	public void vehicleMake(CommonActions commonActions, String make) {
		commonActions.selectByValue(vehicleMake, make);
	}
	public void vehicleModel(CommonActions commonActions, String model) {
		commonActions.selectByValue(vehicleModel, model);
	}
	public void vehicleTrime(CommonActions commonActions, String trim) {
		commonActions.selectByValue(vehicleTrime, trim);
	}
	public void vehicleCoverage(CommonActions commonActions, String vCoverage) {
		commonActions.selectByValue(vehicleCoverage, vCoverage);
	}
	public void vehicleTitleHolder(CommonActions commonActions, String titleHolder) {
		commonActions.selectByValue(vehicleTitleHolder, titleHolder);
	}
	public void vehicleAirBags(CommonActions commonActions, String airBag) {
		commonActions.selectByValue(vehicleAirBags, airBag);
	}
	public void vehicleAntiTheft(CommonActions commonActions, String antiTheft) {
		commonActions.selectByValue(vehicleAntiTheft, antiTheft);
	}
	public void vehicleParked(CommonActions commonActions, String parked) {
		commonActions.selectByValue(vehicleParked, parked);
	}
	public void vehiclePrimarilyUsed(CommonActions commonActions, String primarilyUsed) {
		commonActions.selectByValue(vehiclePrimarilyUsed, primarilyUsed);
	}
	public void AdditionalVehicles(CommonActions commonActions) {
		commonActions.click(AdditionalVehicles);
	}
	public void detailsPagesContinue(CommonActions commonActions) {
		commonActions.click(detailsPagesContinue);
	}



}
