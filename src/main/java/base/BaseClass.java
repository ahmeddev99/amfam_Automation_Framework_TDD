package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import common.CommonActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import object.GetAQuotePage;
import object.LandingPage;
import object.ZipCodePage1;
import object.ZipCodePage2;

public class BaseClass {
	public static WebDriver driver;
	public LandingPage landingPage;
	public CommonActions commonActions;
	public ZipCodePage1 zipCodePage1;
	public GetAQuotePage getAQuotePage;
	public ZipCodePage2 zipCodePage2;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
		
		
		
	}

}
