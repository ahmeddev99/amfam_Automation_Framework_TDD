package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.CommonActions;


public class LandingPage {
	
	public LandingPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//button[@class='LeadRouting__select a'][1]")
	WebElement carElement;
	
	public void clickCar(CommonActions commonActions) {
		commonActions.click(carElement);
	}
	

}
