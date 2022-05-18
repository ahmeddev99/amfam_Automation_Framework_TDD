package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.CommonActions;


public class PolicyHolderDetailsPage {
	
	public PolicyHolderDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "F_PH_FirstName_0") WebElement firstNameElement;
	@FindBy (id = "F_PH_MiddleInitial_0") WebElement middleInitElement;
	@FindBy (id = "F_PH_LastName_0") WebElement lastNameElement;
	@FindBy (id = "F_PH_DOB_0") WebElement dobElement;
	@FindBy(id = "F_PH_email_0")WebElement emailElement;
	@FindBy (id = "F_street_0") WebElement streetAddressElement;
	@FindBy (id = "F_city_0") WebElement cityElement;
	@FindBy (id = "F_state_0") WebElement stateElement;
	@FindBy (id = "F_zipCode_0") WebElement zipCodeElement;
	@FindBy (id = "F_livingYear_0") WebElement livingyearsElement;
	@FindBy (xpath = "//span[text()='Continue ']") WebElement continueElement;
	

	public void inputFirstName(CommonActions commonActions, String firstName) {
		commonActions.inputText(firstNameElement, firstName);
	}
	public void inputMiddleName(CommonActions commonActions, char middleName) {
		commonActions.inputText(middleInitElement, middleName);
	}
	public void inputLastName(CommonActions commonActions, String lastName) {
		commonActions.inputText(lastNameElement, lastName);
	}
	public void dateOfBirth(CommonActions commonActions, String dob) {
		commonActions.inputText(dobElement, dob);
	}
	public void emailAddress(CommonActions commonActions, String email) {
		commonActions.inputText(emailElement, email);
	}
	public void streetAddress(CommonActions commonActions, String streetAddress) {
		commonActions.inputText(streetAddressElement, streetAddress);
	}
	public void city(CommonActions commonActions, String city) {
		commonActions.inputText(cityElement, city);
	}
	public void pickState(CommonActions commonActions, String State) {
		commonActions.selectByValue(stateElement, State);
	}
	public void zipCode(CommonActions commonActions, String zipcode) {
		commonActions.inputText(zipCodeElement, zipcode);
	}
	public void livingAtTheAddress(CommonActions commonActions, String atTheAddress) {
		commonActions.inputText(livingyearsElement, atTheAddress);
	}
	public void continueNext(CommonActions commonActions) {
		commonActions.click(continueElement);
	}

}
