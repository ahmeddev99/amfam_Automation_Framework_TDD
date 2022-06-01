package base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import common.CommonActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DriverDetailsPage;
import pages.GetAQuotePage;
import pages.LandingPage;
import pages.PolicyHolderDetailsPage;
import pages.VehicleDetailsPages;
import pages.ZipCodePage1;
import pages.ZipCodePage2;
import reporting.ExtentManager;
import reporting.ExtentTestManager;
import utils.ReadConfigFile;


public class BaseClass {
	public static WebDriver driver;
	private ExtentReports extent;
	
	protected LandingPage landingPage;
	protected CommonActions commonActions;
	protected ZipCodePage1 zipCodePage1;
	protected GetAQuotePage getAQuotePage;
	protected ZipCodePage2 zipCodePage2;
	protected PolicyHolderDetailsPage policyHolderDetailsPage;
	protected VehicleDetailsPages vehicleDetailsPages;
	protected DriverDetailsPage driverDetailsPage;
	
	
	@BeforeSuite
	public void reportingInitiating() {
		extent = ExtentManager.getInstance();
	}
	
	
	@Parameters({"browser"})
	@BeforeMethod
	public void setUp(String browser) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// replace top 2 lines with settingUpDriver("browser")
//		settingUpDriver(browser);
		driver.get(ReadConfigFile.getInstance().getUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds((ReadConfigFile.getInstance().getPageLoadTime())));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((ReadConfigFile.getInstance().getImplicitlyWaitTime())));
		initClasses();
	}
	
	private WebDriver settingUpDriver(String browser) {
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
	
	@BeforeMethod
	public void startReport(Method method) {
		String className = method.getDeclaringClass().getSimpleName();
		ExtentTestManager.startTest(method.getName());
		ExtentTestManager.getTest().assignCategory(className);
	}
	
	@AfterMethod
	public void afterEachTestMethod(ITestResult result) {
		for (String groups : result.getMethod().getGroups()) {
			ExtentTestManager.getTest().assignAuthor(groups);
		}

		if (result.getStatus() == ITestResult.SUCCESS) {
			ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
		} else if (result.getStatus() == ITestResult.SKIP) {
			ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed \n" + result.getThrowable());
			String ssLocation = commonActions.getScreenShot();
			ExtentTestManager.getTest().addScreenCaptureFromPath(ssLocation);
		}
	}

	
	@AfterMethod
	public void cleaningUp() {
		driver.quit();
	}
	
	
	@AfterSuite
	public void endReport() {
		extent.flush();
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
