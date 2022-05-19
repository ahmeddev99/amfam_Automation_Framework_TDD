package reporting;

import org.testng.Reporter;

import freemarker.log.Logger;

public class JavaLog {
	
	
	private static final Logger LOGGER = Logger.getLogger(JavaLog.class.getName());
	
	public static void log(String msg) {
		LOGGER.info(msg);
		Reporter.log(msg);
		
	}
	

}
