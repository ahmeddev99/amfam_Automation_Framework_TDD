package practice;


/*
 * 
 * INTRO:
 * 
			for this project We are using data driven framework. 
			The design pattern we followed is page object model. 
			We used DataProvider to parameterize testing. to read and write in excel we used apache poi


Base Class: 

		in Baseclass is responsible for initializing the WebDriver, Implicit Waits, pageloadtimeout,                         Extent Reports,  


COMMON ACTIONS:

	Stores and handles all method, actions, capturing screenshots which can be commonly used across the entire framework. 
	The reason behind common actions class is to achieve reusability.



DataProvider Package:

	Where we declared variables, parameterized constructor and generate getter to use for dataprovider.



POM: Pages

	As per the Page Object Model, we have maintained a class for every web page. Each web page has a separate class and 
	that class holds the functionality of that web page. Separate classes for every individual test
	Packages: We have separate packages for Pages and Tests. All the web page related classes come under the Pages package 
	and all the tests related classes come under Tests package




Extent Reports: 

	For the reporting purpose, we are using Extent Reports. It generates beautiful HTML reports. 
	We use the extent reports for maintaining logs and also to include the screenshots of failed test cases in the Extent Report.
	Screenshots will be captured and stored in a separate folder 



Utils:

	Created the object of FileInputStream which is responsible for pointing towards the file from which the data should be read. And which cell to start reading fro.
	Readconfile to from configure.properties


TestNG: 

	Using TestNG for Assertions, Grouping, and Parallel execution


Properties file: 

	This file (config.properties) stores the information that remains static throughout the framework such as application URL, excel sheet path.
	Keeping these details in a separate file makes it easy to maintain.
	
	
	
Maven: 
	
	Using Maven for build, execution, and dependency purpose. Integrating the TestNG dependency in the POM.xml file and running this POM.xml file using Jenkins.


 
*/