package common;

import java.time.Duration;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import reporting.JavaLog;
import base.BaseClass;



public class CommonActions {
	
	WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(20));
	JavascriptExecutor jsExecutor = (JavascriptExecutor)BaseClass.driver;

	public void click(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			JavaLog.log("Element is clicking : " + element + "<br>");
		//	Reporter.log("Element is clicking : " + element + "<br>");
		} catch (Exception e) {
			e.printStackTrace(); // <--same thing as System.out.println():
			JavaLog.log("Element is unable to click: " + element + "\n" + e.getMessage() + "<br>");
		//	Reporter.log("Element is unable to click: " + element + "\n" + e.getMessage() + "<br>");
			Assert.fail();  
		}
	}
	
	
	public void inputText(WebElement element, String text) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(text);
			JavaLog.log(text + " : value passed to element : " + element + "<br>");
		//	Reporter.log(text + " : value passed to element : " + element + "<br>");
		} catch (Exception e) {
			e.printStackTrace();
			JavaLog.log("Element is not found : " + element + "\n" + e.getMessage() + "<br>");
		//	Reporter.log("Element is not found : " + element + "\n" + e.getMessage() + "<br>");
			Assert.fail();
		}
	}		
	
	
	public void inputText(WebElement element, char text) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(String.valueOf(text));
			JavaLog.log(text +" : value passed to element : " + element + "<br>");
		//	Reporter.log(text +" : value passed to element : " + element + "<br>");
		} catch (Exception e) {
			e.printStackTrace();
			JavaLog.log("Element is not found : " + element+"\n" + e.getMessage() + "<br>");
		//	Reporter.log("Element is not found : " + element+"\n" + e.getMessage() + "<br>");
			Assert.fail();
		}
	}
	
	
	public void selectByValue(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByValue(value);
			JavaLog.log(value + " : value has been selected from the element : " + element + "<br>");
		//	Reporter.log(value + " : value has been selected from the element : " + element + "<br>");
		} catch (Throwable e) {
			e.printStackTrace();
			JavaLog.log("Locator doesn't match for : " + element + "\n" + e.getMessage() + "<br>");
		//	Reporter.log("Locator doesn't match for : " + element + "\n" + e.getMessage() + "<br>");
			Assert.fail();
		}
	}
	
	
	public String getText(WebElement element, String expected) {
		try {
			JavaLog.log("Actual value : " + element.getText() + " >>><<< Expected value : " + expected);
		//	Reporter.log("Actual value : " + element.getText() + " >>><<< Expected value : " + expected);
			Assert.assertEquals(element.getText(), expected);
			return element.getText();
		} catch (Exception e) {
			e.printStackTrace();
			JavaLog.log(element + " Element Not Found \n" + e.getLocalizedMessage());
		//	Reporter.log(element + " Element Not Found \n" + e.getLocalizedMessage());
			return element + " : Element Not Found";
		}
	}
	
	
	public void scrollUp() {
		try {
			JavaLog.log("Scrolling up to 250 to 0 pixels");
		//	Reporter.log("Scrolling up to 250 to 0 pixels");
		} catch (JavascriptException e) {
			JavaLog.log("Exception while scrolling up");
		//	Reporter.log("Exception while scrolling up");
		}
	}
	
	
	public boolean isSelected(WebElement element) {
		boolean status = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			status = element.isSelected();
			if(status) {
				//Reporter.log("Element is Cliking : " + element );
				JavaLog.log(element +" : is selected" );
			}else {
				//Reporter.log("Element is Cliking : " + element );
				JavaLog.log(element +" : is Not selected" );
			}
		}catch (TimeoutException e) {
			e.printStackTrace();
			//Reporter.log("Element is Cliking : " + element );
			JavaLog.log("Element Not Found : " + element+"\n" + e.getMessage() );
			Assert.fail();
		}
		return status;
	}

	public String getText(WebElement element) {
		String textString = element.getText();
		JavaLog.log(element+" has text : " +textString );
		return textString;
	}
	
	public void textVerification(String actual, String expected) {
		JavaLog.log("Actual : "+actual+"<<<>>>"+"Expeted : " + expected);
		Assert.assertEquals(actual, expected);
	}
	
	public void logEvent(String eventMsg) {
		//Reporter.log(eventMsg );
		JavaLog.log(eventMsg);
	}
	
	public void logEventAndFail(String eventMsg) {
		//Reporter.log(eventMsg );
		JavaLog.log(eventMsg);
		Assert.fail();
	}
	
	
	
	
	
	
}