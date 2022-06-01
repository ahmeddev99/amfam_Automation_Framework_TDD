package base;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.CommonActions;
import reporting.JavaLog;

public class Notes {
	
// -------------------------------------------------------------------------------------------------------------
//     you write the in common actions pages     
		public class CommonActions {

			WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(20));
			JavascriptExecutor jsExecutor = (JavascriptExecutor) BaseClass.driver;
	
			public void click(WebElement element) {
				try {
					wait.until(ExpectedConditions.elementToBeClickable(element));
					element.click();
					JavaLog.log("Element is clicking : " + element + "<br>");
				} catch (Exception e) {
					e.printStackTrace(); // <--same thing as System.out.println():
					JavaLog.log("Element is unable to click: " + element + "\n" + e.getMessage() + "<br>");
					Assert.fail();
				}
			}

// -------------------------------------------------------------------------------------------------------------
//      when test a page depends how many elements you in the pages
		public class GetAQuotePage {
			
			public GetAQuotePage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			
			@FindBy (xpath = "//span[text()='Get a Quote']")WebElement getQuotElement;
			
			private void clickOnQuote(CommonActions commonActions) {
				commonActions.click(getQuotElement);
			}
			
			
			public void getAQuotePageSteps(CommonActions commonActions) {
				clickOnQuote(commonActions);
			}
// -------------------------------------------------------------------------------------------------------------
//			you write the in common actions pages	
			public void inputText(WebElement element, String text) {
				try {
					wait.until(ExpectedConditions.visibilityOf(element));
					element.sendKeys(text);
					JavaLog.log(text + " : value passed to element : " + element + "<br>");
				} catch (Exception e) {
					e.printStackTrace();
					JavaLog.log("Element is not found : " + element + "\n" + e.getMessage() + "<br>");
					Assert.fail();
				}
			}	
	
// -------------------------------------------------------------------------------------------------------------
//		public class GetAQuotePage {
			
			public GetAQuotePage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			
			@FindBy (id = "F_PH_FirstName_0") WebElement firstNameElement;
			
			private void inputFirstName(CommonActions commonActions, String firstName) {
				commonActions.inputText(firstNameElement, firstName);
			}
		
			public void policyHolderDetailsPageSteps(CommonActions commonActions, String firstName) {
				inputFirstName(commonActions, firstName);
			}
// -------------------------------------------------------------------------------------------------------------
//	
			@FindBy (id = "F_PH_MiddleInitial_0") WebElement middleInitElement;
			
			private void inputMiddleName(CommonActions commonActions, char middleName) {
				commonActions.inputText(middleInitElement, middleName);
			}
			
			public void policyHolderDetailsPageSteps(CommonActions commonActions, char middleName) {
				inputFirstName(commonActions, firstName);
				inputMiddleName(commonActions, middleName);	
			}
	
	
	
	
	
	
	
	

}
