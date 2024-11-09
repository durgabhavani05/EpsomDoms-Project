package com.doms.WelcomeTest;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import com.doms.GenericLibrary.BaseTest;
import com.doms.JavaLibrary.JavaUtility;
import com.doms.PageRepository.PageManagement;

public class VerifyWelcomePageTest extends BaseTest 
{

    @Test(priority = 1)
    public void verifyWelcomepageWithValidInput() {

        // Create the Test Information
        test = report.createTest("verifyWelcomepageWithValidInput");

        // Steps Information
        test.log(Status.INFO, "----Execution started successfully----");

        // Execute the precondition: Launch browser and navigate to URL
        test.log(Status.INFO, "Launching the browser successfully");

        // Implicit wait (ensure WebDriver object is initialized before this)
        webdriverobj.waitImplicitly(20);

        // Verify the WelcomePage using the title
        Assert.assertEquals("Learning Selenium", webdriverobj.driver.getTitle());
        test.log(Status.PASS, "Title verified");

        // Create an object for page manager
        pageManagementobj = new PageManagement(webdriverobj.driver);

        boolean result = pageManagementobj.initWelcomepage().getName().isDisplayed();
        
        Assert.assertTrue(result);  
        test.log(Status.PASS, "Element Verified - Name text field is displayed");
        
        // Perform Action - Clear the Name field    
        pageManagementobj.initWelcomepage().getName().clear();
        test.log(Status.PASS, "Clear action is done successfully - name text field");


        // Input data into the form fields
        pageManagementobj.initWelcomepage().getName().sendKeys(username);
        test.log(Status.PASS, "Name text field is passed");

        pageManagementobj.initWelcomepage().getEmail().sendKeys("db@gmail.com");
        pageManagementobj.initWelcomepage().getPassword().sendKeys("db@05");
        pageManagementobj.initWelcomepage().getMobileno().sendKeys("9876543210");
        pageManagementobj.initWelcomepage().getPlaces().click();
        pageManagementobj.initWelcomepage().getCountry1();
        pageManagementobj.initWelcomepage().getCountry2();
        pageManagementobj.initWelcomepage().getFeedBack().sendKeys("Hi.. I'm Durga!");
        pageManagementobj.initWelcomepage().getUpload().sendKeys("E:\\photo.jpg");
        pageManagementobj.initWelcomepage().getRegister().click();

        // Wait for 3 seconds to see the execution
        JavaUtility.pause(3000);

        // Soft Assert for verifying the "Contact Us" hyperlink
        SoftAssert softassertobj = new SoftAssert();
        
        
        softassertobj.assertEquals("Contact Us", pageManagementobj.initWelcomepage().getLink().getText());
        test.log(Status.PASS, "Verified text of the contact us hyperlink successfully");

        // Assert all SoftAssert statements
        softassertobj.assertAll();

        //Execution log
        test.log(Status.INFO, "Execution Completed Successfully");
        
    }

    @Test(priority = 2, invocationCount = 2, dependsOnMethods = "verifyWelcomepageWithValidInput")
    public void verifyWelcomepageWithInvalidInput() {

        // Create the Test Information
        test = report.createTest("verify welcomepageWithInvalidInput");

        // Steps Information
        test.log(Status.INFO, "----Execution started successfully----");

        // Implicit wait (ensure WebDriver object is initialized before this)
        webdriverobj.waitImplicitly(20);

        // Verify WelcomePage using title
        String exptitle = "Learning Selenium";
        String acttitle = webdriverobj.driver.getTitle();
        Assert.assertEquals(acttitle, exptitle);
        test.log(Status.PASS, "Title verified: " + acttitle);
        
        // Create an object for page manager
        pageManagementobj = new PageManagement(webdriverobj.driver);

        boolean result = pageManagementobj.initWelcomepage().getName().isDisplayed();
        
        Assert.assertTrue(result);  
        test.log(Status.PASS, "Element Verified - Name text field is displayed");
        
        // Perform Action - Clear the Name field    
        pageManagementobj.initWelcomepage().getName().clear();
        test.log(Status.PASS, "Clear action is done successfully - name text field");


        // Input data into the form fields
        pageManagementobj.initWelcomepage().getName().sendKeys("jdhhdsfghdfhvfdvgfhfvhgfvdhfv");
        test.log(Status.PASS, "Name text field is passed");

        pageManagementobj.initWelcomepage().getEmail().sendKeys("db@gmail.com");
        pageManagementobj.initWelcomepage().getPassword().sendKeys("db@05");
        pageManagementobj.initWelcomepage().getMobileno().sendKeys("9876543210");
        pageManagementobj.initWelcomepage().getPlaces().click();
        pageManagementobj.initWelcomepage().getCountry1();
        pageManagementobj.initWelcomepage().getCountry2();
        pageManagementobj.initWelcomepage().getFeedBack().sendKeys("Hi.. I'm Durga!");
        pageManagementobj.initWelcomepage().getUpload().sendKeys("E:\\photo.jpg");
        pageManagementobj.initWelcomepage().getRegister().click();

        // Wait for 3 seconds to see the execution
        JavaUtility.pause(3000);


        // To simulate failure, you can use Assert.fail()
        // Uncomment this to make the test fail intentionally
        // Assert.fail();

        // Execute the post condition: terminate the browser
        test.log(Status.INFO, "----Execution completed successfully---- Test 2");
    }
}
