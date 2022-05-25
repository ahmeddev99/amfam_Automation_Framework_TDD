package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import reporting.JavaLog;

public class Configurable {
	
	private static Configurable configurable;
	private String path = "./configuration/config.properties";
	
	
	private String url;
	private int pageLoadTime;
	private int implicitlyWaitTime;
	private static String excelPath;
	private static String sheetName;
	private static String titleFilePath;
	
	
	private Configurable() {
		
	}
	
	// singleton Class
	public static Configurable getInstance() {
		if (configurable == null) {
			configurable = new Configurable();
		}
		configurable.loadProperties();
		return configurable;
	}
	
	
	private void loadProperties() {
		try {
			FileReader reader = new FileReader(path);
			Properties properties = new Properties();
			properties.load(reader);
			// ^^ top 3 lines are reading the configure.properties file
			url = properties.getProperty("url");
			implicitlyWaitTime = Integer.parseInt(properties.getProperty("elementImplicitWait"));
			pageLoadTime = Integer.parseInt(properties.getProperty("pageLoadWait"));
			excelPath = properties.getProperty("excelPath");
			sheetName = properties.getProperty("sheetName");
			titleFilePath = properties.getProperty("titleFilePath");
		} catch (IOException e) {
			JavaLog.log("File Not Found \n"+e.getMessage() + "<br>");
			e.printStackTrace();
		} catch(NumberFormatException e) {
			JavaLog.log("Number format in properties not correct \n"+e.getMessage() + "<br>");
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return url;
	}

	public int getPageLoadTime() {
		return pageLoadTime;
	}

	public int getImplicitlyWaitTime() {
		return implicitlyWaitTime;
	}

	public String getExcelPath() {
		return excelPath;
	}
	
	public String getSheetName() {
		return sheetName;
	}
	
	public String getTitleFilePath() {
		return titleFilePath;
	}

	
}
