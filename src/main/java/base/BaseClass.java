package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

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
import utilities.Configurable;


public class BaseClass {
	public static WebDriver driver;
	protected LandingPage landingPage;
	protected CommonActions commonActions;
	protected ZipCodePage1 zipCodePage1;
	protected GetAQuotePage getAQuotePage;
	protected ZipCodePage2 zipCodePage2;
	protected PolicyHolderDetailsPage policyHolderDetailsPage;
	protected VehicleDetailsPages vehicleDetailsPages;
	protected DriverDetailsPage driverDetailsPage;
	
	
	
//	@BeforeTest
//	public void beforeTest() {
//		Reporter.log("This is before Test Annotation");
//		JavaLog.log("This is before Test Annotation");
//	}
	
//	@BeforeClass
//	public void beforeClass() {
//		Reporter.log("Before Class");
//		JavaLog.log("Before Class");
//	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public void setUp(String browser) {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		// replace top 2 lines with settingUpDriver("browser")
		settingUpDriver(browser);
		driver.get(Configurable.getInstance().getUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds((Configurable.getInstance().getPageLoadTime())));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((Configurable.getInstance().getImplicitlyWaitTime())));
		initClasses();
	}
	
	private WebDriver settingUpDriver(String browser) {
		String os = System.getProperty("os.name");
		JavaLog.log("My OS Version is " + os); 
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	
	@AfterMethod
	public void cleaningUp() {
		driver.quit();
	}
	
	/*
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
	*/
	
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
