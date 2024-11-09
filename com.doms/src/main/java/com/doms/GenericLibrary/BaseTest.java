package com.doms.GenericLibrary;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.doms.ExcelLibrary.ReadExcelFile;
import com.doms.PageRepository.PageManagement;
import com.doms.PropertyFileLibrary.ReadPropertyFile;
import com.doms.WebDriverLibrary.WebDriverUtility;

/**
 * This Class is Used For Configure All The PreCondition And Post Condition For TestScript
 * And Also Initializing All the Library Utility Libraries
 * @author bhavani
 */

public class BaseTest 
{
	public PageManagement pageManagementobj;
	public WebDriverUtility webdriverobj;
	public ReadExcelFile excelutilityobj;
	public ReadPropertyFile propertyfileobj;
	public String username;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	
	@BeforeSuite
	public void suiteSetup()
	{
		//cREATE THE SPARKREPORT
		spark = new ExtentSparkReporter("./AdvanceReports/report.html");
		
		//Configure the SparkReport Information
		spark.config().setDocumentTitle("Regression Testing For the LearningSeleniumPage");
		spark.config().setReportName("RegressionSuite|Verification of welcome page");
		spark.config().setTheme(Theme.STANDARD);
		
		//Create the Extent Report
		report = new ExtentReports();
		
		//Attach the SparkReport and ExtentReport
		report.attachReporter(spark);
		
		//Configure the system into in ExtentRport
		report.setSystemInfo("DeviceName :", "Durga");
		report.setSystemInfo("OperatingSystem:", "WINDOWSS 11");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("BrowserVersion: ", "chrome-128.0.661.85");
	}
	
	@AfterSuite
	public void suiteTerminateSetup()
	{
		//Flush the Report Information
		report.flush();
	}
	
	
	@Parameters({"browsername","weburl"})
	@BeforeClass
    
    public void browserSetup(String browser, String url) 
    {
		//create oBject for all utility/repository
		createObjects();
		
		//fetch the user name from excel file
		username = excelutilityobj.readSingleData("RegisterData",1,1);
		
		//step 1: launch the browser
		webdriverobj.launchBrowser(browser);
	    Reporter.log("launch the browser success",true);

	  		
	    //maximize the browser
	    webdriverobj.maximizeTheBrowser();
	    Reporter.log("maximize browser success",true);
	    
		//step 2: Navigating to the application via URL
	    webdriverobj.NavigateToApplication(url);
	    Reporter.log("Navigating to the application via URL Sucess",true);
			
    }
	
	@AfterClass
	public void terminateBrowser() 
	{
		webdriverobj.closeAllBrowser();
		Reporter.log("Close the Browser",true);	
	}
	
	public void createObjects()
	{
	  webdriverobj = new WebDriverUtility();
	  excelutilityobj = new ReadExcelFile();
	  propertyfileobj = new ReadPropertyFile();

	  
	}
	
	
	
	
	
}
