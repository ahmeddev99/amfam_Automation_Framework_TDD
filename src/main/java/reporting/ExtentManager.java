package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public synchronized static ExtentReports getInstance() {
		if (extent == null) {
			try {
				extent = new ExtentReports();
				ExtentSparkReporter spark = new ExtentSparkReporter("./test-output/Spark.html");
				spark.config().setReportName("A-F-I Automation");
				extent.attachReporter(spark);
				extent.setSystemInfo("Team", "Suicide Squad");
				extent.setSystemInfo("Environment", "QA");
				extent.setSystemInfo("Tester", System.getProperty("user.name"));
				extent.setSystemInfo("OS", System.getProperty("os.name"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return extent;
	}
	

	
	
	
	

}
