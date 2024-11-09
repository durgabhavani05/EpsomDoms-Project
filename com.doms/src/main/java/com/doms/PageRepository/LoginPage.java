package com.doms.PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//initialization  ==  constructor
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}

}
