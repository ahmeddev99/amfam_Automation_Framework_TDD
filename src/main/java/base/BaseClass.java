package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import common.CommonActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DriverDetailsPage;
import pages.GetAQuotePage;
import pages.LandingPage;
import pages.PolicyHolderDetailsPage;
import pages.VehicleDetailsPages;
import pages.ZipCodePage1;
import pages.ZipCodePage2;
import reporting.JavaLog;

public class BaseClass {
	public static WebDriver driver;
	public LandingPage landingPage;
	public CommonActions commonActions;
	public ZipCodePage1 zipCodePage1;
	public GetAQuotePage getAQuotePage;
	public ZipCodePage2 zipCodePage2;
	public PolicyHolderDetailsPage policyHolderDetailsPage;
	public VehicleDetailsPages vehicleDetailsPages;
	public DriverDetailsPage driverDetailsPage;
	
	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("Running our Framework");
		JavaLog.log("Running our Framework");
	}
	
	@BeforeTest
	public void beforeTest() {
		Reporter.log("This is before Test Annotation");
		JavaLog.log("This is before Test Annotation");
	}
	
	@BeforeClass
	public void beforeClass() {
		Reporter.log("Before Class");
		JavaLog.log("Before Class");
	}
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amfam.com/");
		initClasses();
	}
	
	@AfterMethod
	public void cleaningUp() {
		driver.quit();
		Reporter.log("cleanUp");
		JavaLog.log("cleanUp");
	}
	
	@AfterClass
	public void afterClass() {
		Reporter.log("After Class");
		JavaLog.log("After Class");
	}
	
	@AfterTest
	public void afterTest() {
		Reporter.log("After Test");
		JavaLog.log("After Test");
	}
	
	@AfterSuite
	public void afterSuite() {
		Reporter.log("Closing Framework execution");
		JavaLog.log("Closing Framework execution");
	}
	
	public void initClasses() {
		commonActions = new CommonActions();
		landingPage = new LandingPage(driver);
		zipCodePage1 = new ZipCodePage1(driver);
		getAQuotePage = new GetAQuotePage(driver);
		zipCodePage2 = new ZipCodePage2(driver);
		policyHolderDetailsPage = new PolicyHolderDetailsPage(driver);
		vehicleDetailsPages = new VehicleDetailsPages(driver);
		driverDetailsPage = new DriverDetailsPage(driver);	
	}

}
