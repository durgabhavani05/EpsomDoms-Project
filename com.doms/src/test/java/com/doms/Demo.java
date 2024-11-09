package com.doms;


import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Demo {

//	public static void main(String[] args) throws IOException 
//	{
//		//configure the browser
//		WebDriverManager.chromedriver().setup();
//		
//		//launch the browser
//		WebDriver driver = new ChromeDriver();
//		
//		WorkbookFactory.create(false);	
//
//	}

@Test
public void DemoTesting1()
{
	
	// Create the SparkReport 
	ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/report.html");
	
	//Configure the SparkReport Information
	spark.config().setDocumentTitle("Regression Testing For the LearningSeleniumPage");
	spark.config().setReportName("RegressionSuite|Verification of welcome page");
	spark.config().setTheme(Theme.DARK);
	
	//Create the Extent Report
	ExtentReports report = new ExtentReports();
	
	//Attach the SparkReport and ExtentReport
	report.attachReporter(spark);
	
	//Configure the system into in ExtentRport
	report.setSystemInfo("DeviceName :", "Durga");
	report.setSystemInfo("Operating System:", "WINDOWSS 11");
	report.setSystemInfo("BrowserVersion : ", "chrome-128.0.661.85");
	
	//Create the Test Information
	ExtentTest test = report.createTest("Regressiontest");
	
	//Steps Information
	test.log(Status.INFO, "Step1: Launching the browser successfully");
	
	test.log(Status.INFO, "Step2:Navigating To Application via URL Successful");
	
	test.log(Status.PASS, "Step3: Verified the Webpage Successfully");
	
	if("Harry".equals("Harry"))
	{
		test.log(Status.PASS, "Step4: Verified the WebElements Displayed");
	}
	else
	{
		test.log(Status.FAIL, "Step4: Verified the WebElements Not Displayed");
	}
	
	//test.log(Status.SKIP, "Step5: Elements is Hidden");
	
	//Flush the Report Information
	report.flush();
	System.out.println("Execution Done");
	}	
	
@Test
public void DemoTesting2()
{
	
}

@Test
public void DemoTesting3() 
{
	
}

@Test
public void DemoTesting4() 
{
	
}

@Test
public void DemoTesting5() 
{
	
}















}

