package com.doms.PageRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WelcomePage 
{
	
	//initialization  ==  constructor
	public WelcomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//declaration
	@FindBy(id="name")
	private WebElement Name;
	
	@FindBy(id="email")
	private WebElement Email;
	
	@FindBy(id="password")
	private WebElement Password;
	
	@FindBy(id="mobile")
	private WebElement Mobileno;
	
	@FindBy(xpath="//input[@name='dob']")
	private WebElement Dob;
	
	@FindBy(xpath="//input[@id='female']")
	private WebElement Gender;
	
	@FindBy(xpath="//input[@id='bangalore']")
	private WebElement Places;
	
	@FindBy(xpath="//select[@name='country1']")
	private WebElement Country1;
	
	@FindBy(xpath="//select[@name='country2']")
	private WebElement Country2;
	
	@FindBy(xpath="//textarea[@id='feedback']")
	private WebElement FeedBack;
	
	@FindBy(xpath="//input[@name='photo']")
	private WebElement Upload;
	
	@FindBy(xpath="//input[@id='reg']")
	private WebElement Register;
	
	@FindBy(partialLinkText = "Contact Us")
	private WebElement link;

	
	
	//implementation

	public WebElement getName() {
		return Name;
	}

	public WebElement getEmail() {
		return Email;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getMobileno() {
		return Mobileno;
	}
	
	public WebElement getDob() {
		return Dob;
	}

	public WebElement getGender() {
		return Gender;
	}

	public WebElement getPlaces() {
		return Places;
	}

	public WebElement getCountry1() {
		return Country1;
	}

	public WebElement getCountry2() {
		return Country2;
	}

	public WebElement getFeedBack() {
		return FeedBack;
	}

	public WebElement getUpload() {
		return Upload;
	}

	public WebElement getRegister() {
		return Register;
	}

	public WebElement getLink() {
		return link;
	}
	
	
//	public void setLink(WebElement link) {
//		this.link = link;
//	}
	
	
}
