package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import common.CommonActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GetAQuotePage;
import pages.LandingPage;
import pages.PolicyHolderDetailsPage;
import pages.VehicleDetailsPages;
import pages.ZipCodePage1;
import pages.ZipCodePage2;

public class BaseClass {
	public static WebDriver driver;
	public LandingPage landingPage;
	public CommonActions commonActions;
	public ZipCodePage1 zipCodePage1;
	public GetAQuotePage getAQuotePage;
	public ZipCodePage2 zipCodePage2;
	public PolicyHolderDetailsPage policyHolderDetailsPage;
	public VehicleDetailsPages vehicleDetailsPages;
	
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amfam.com/");
		initClasses();
	}
	
	@AfterMethod
	public void cleaningUp() {
//		driver.quit();
	}
	
	
	public void initClasses() {
		commonActions = new CommonActions();
		landingPage = new LandingPage(driver);
		zipCodePage1 = new ZipCodePage1(driver);
		getAQuotePage = new GetAQuotePage(driver);
		zipCodePage2 = new ZipCodePage2(driver);
		policyHolderDetailsPage = new PolicyHolderDetailsPage(driver);
		vehicleDetailsPages = new VehicleDetailsPages(driver);
		
		
	}

}
