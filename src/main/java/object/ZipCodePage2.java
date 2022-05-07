package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import common.CommonActions;

public class ZipCodePage2 {
	
	public ZipCodePage2 (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "uid_34")
	WebElement inputZipCodElement1;
	
	@FindBy (id = "uid_37")
	WebElement dropDownElement;
	
	@FindBy (xpath = "(//button[@type='submit'])[1]")
	WebElement clickonQuoteElement;
	
	public void inputZipcode2(CommonActions commonActions, String value) {
		commonActions.inputText(inputZipCodElement1, value);
	}
	
	public void selectByIndex() {
		Select select = new Select(dropDownElement);
		select.selectByIndex(1);
	}
	
	public void clickonQuote(CommonActions commonActions) {
		commonActions.click(clickonQuoteElement);
	}
	

}
