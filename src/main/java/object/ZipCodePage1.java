package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.CommonActions;

public class ZipCodePage1 {
	
	public ZipCodePage1 (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "uid_54")
	WebElement inputZipCodElement;
	@FindBy (xpath = "(//span[@class='LoadingButton__content'])[1]")
	WebElement clickonStartQuotingElement;
	
	public void inputZipCode(CommonActions commonActions, String value) {
		commonActions.inputText(inputZipCodElement, value);
	}
	
	public void clickOnStartQuoting(CommonActions commonActions) {
		commonActions.click(clickonStartQuotingElement);
	}

}



