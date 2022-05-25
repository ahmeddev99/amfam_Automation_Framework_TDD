package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.CommonActions;
import dataProvider.AutoData;
import freemarker.core.Configurable;
import utilities.ReadTxtFile;



public class LandingPage {
	
	public LandingPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@class='LeadRouting__select a'][1]") WebElement carElement;
	@FindBy(xpath = "//h1[text()='Get a Customized Insurance Quote']") WebElement titlElement;
	
	private void clickAuto(CommonActions commonActions) {
		commonActions.click(carElement);
	}
	
	private void checkTitle(CommonActions commonActions) {
		String actualTitle = commonActions.getText(titlElement);
		String expected = "";
		
		String filePath = Configurable.getInstance().getTitleFilePath();
		ReadTxtFile readTxtFile = new ReadTxtFile(filePath);
		
		List<String> titles = readTxtFile.getListData();
		for(String title:titles) {
			if(title.equalsIgnoreCase(actualTitle)) {
				expected = title;
			}
		}
		commonActions.textVerification(actualTitle, expected);
	}
	
	public void landingPageSteps(CommonActions commonActions) {
		clickAuto(commonActions);
		checkTitle(commonActions);
	}
	

}
