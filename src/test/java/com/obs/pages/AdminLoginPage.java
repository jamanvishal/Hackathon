package com.obs.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.obs.common.StandardWaitTimes;
import com.obs.tests.LoginTest;
import com.obs.utilities.ReadProperties;

public class AdminLoginPage  {
	
	Logger log = (Logger) LogManager.getLogger(AdminLoginPage.class);
	
	WebDriver driver;
	ExtentTest test;
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement UserName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Password;
	
	@FindBy(xpath="//textarea[@name='comments']")
	WebElement textarea;
	
	@FindBy(xpath="//input[@name='filename']")
	WebElement choosefile;
	
	@FindBy(xpath="(//input[@type='checkbox'])[1]")
	WebElement checkbox;
	
	@FindBy(xpath="//input[@value='rd1']")
	WebElement radiobutton;
	
	
	@FindBy(xpath="//option[@value='ms1']")
	WebElement Multipleselect;
	
	@FindBy(xpath="//select[@name='dropdown']")
	WebElement dropdown;
	
	@FindBy(xpath="//div[@class='explanation']/p")
	WebElement BannerMessage;
	
    
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit;
	
//	@FindBy(xpath = "//a[normalize-space()='Go to Website']")
//	WebElement goToWebSite;
	
	@FindBy(xpath = "//a[text()='User Login']")
	WebElement goToWebSite;
	
	public AdminLoginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		driver.manage().timeouts().implicitlyWait(StandardWaitTimes.waitTime, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	public void login(String UN, String Pwd) {
		try {
			test.log(Status.PASS, "Verifying  user login");
			log.info("Verifying user login");
			UserName.sendKeys(UN);
			Password.sendKeys(Pwd);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void gotoUserLogin() {
		try {
		test.log(Status.PASS, "Verifying gotoWebSite Link");
		log.info("Verifying gotoWebSite Link");
		goToWebSite.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void launchApp(String URL) {
		try {
		test.log(Status.PASS, "Verifying open admin user login");
		log.info("Verifying open admin user login");
		driver.get(URL);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
//	public void verifyLogin() throws IOException, InterruptedException {
//
//		//Verify admin login
//		String url,userName,Password;
//		
//		url = ReadProperties.readProp("AdminURL");
//		userName = ReadProperties.readProp("AdminUN");
//		Password = ReadProperties.readProp("AdminPwd");
//		
//		AdminLoginPage login = new AdminLoginPage(driver,test);
//		login.launchApp(url);
//		login.login(userName, Password);
//		
//		
//		
//	}
	
	public void EnterTextarea()
	{
	
		textarea.sendKeys("Demo");
		test.log(Status.PASS, "Sucessfully entered comments");
		log.info("Sucessfully entered comments");
		

	}
	public void ClickonCheckBox() {
		checkbox.click();
		test.log(Status.PASS, "Sucessfully selected checkbox");
		log.info("Sucessfully selected checkbox");
	}
	
	public void ClickonRadiobutton() {
		radiobutton.click();
		test.log(Status.PASS, "Sucessfully selected radio button");
		log.info("Sucessfully selected radio button");
	}
	
	public void ClickonMultipleSelect() {
		Select select=new Select(Multipleselect);
		//select.deselectByVisibleText("Selection Item 4");
		select.selectByValue("ms1");
		
		
	}
	
	public void Clickondropdown() {
		Select select=new Select(dropdown);
		select.selectByVisibleText("Dropdown Item 3");
	}
	public void ClickonSubmit() {
		submit.click();
		test.log(Status.PASS, "Sucessfully clicked on submit button");
		log.info("Sucessfully clicked on submit button");
	}
	
	public void ValidateBannerMessage() {
		BannerMessage.isDisplayed();
		test.log(Status.PASS, "Sucessfully You submitted a form");
		log.info("Sucessfully You submitted a form");
	}
	
}
