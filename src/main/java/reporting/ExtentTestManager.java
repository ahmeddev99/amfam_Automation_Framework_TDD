package reporting;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
	
	static Map<Integer, ExtentTest> extentMap = new HashedMap<Integer, ExtentTest>();
	private static ExtentReports extentReorts = ExtentManager.getInstance();
	
	public static synchronized ExtentTest getTest() {
		return extentMap.get((int)(long)Thread.currentThread().getId());
	}

	public static synchronized ExtentTest starTest(String testName, String desc) {
		ExtentTest test = extentReorts.createTest(testName, desc);
		extentMap.put((int) (long) Thread.currentThread().getId(), test);
		return test;
	}
	
	public static synchronized ExtentTest startTest(String testName) {
		return starTest(testName, "");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
