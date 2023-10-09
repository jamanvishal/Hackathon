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
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.obs.common.StandardWaitTimes;
import com.obs.utilities.ReadProperties;

public class AdminHomePage {

	Logger log = (Logger) LogManager.getLogger(AdminHomePage.class);
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
	
	@FindBy(xpath="(//input[@name='radioval'])[1]]")
	WebElement radiobutton;
	
	
	@FindBy(xpath="//select[@name='multipleselect[]']")
	WebElement Multipleselect;
	
	@FindBy(xpath="//select[@name='dropdown']")
	WebElement dropdown;
	
	@FindBy(xpath = "(//input[@name='submitbutton'])[2]")
	WebElement submit;
	
	
	public AdminHomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		driver.manage().timeouts().implicitlyWait(StandardWaitTimes.waitTime, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}
	
	public void verifyLogin() throws IOException, InterruptedException {

		//Verify admin login
		String url,userName,Password;
		
		url = ReadProperties.readProp("AdminURL");
		userName = ReadProperties.readProp("AdminUN");
		Password = ReadProperties.readProp("AdminPwd");
		
		AdminLoginPage login = new AdminLoginPage(driver,test);
		login.launchApp(url);
		login.login(userName, Password);
		
		
		
	}
	
	//Verify home page text

	
	public void EnterTextarea()
	{
	
		textarea.sendKeys("Demo");
		

	}
	public void ClickonCheckBox() {
		checkbox.click();
	}
	
	public void ClickonRadiobutton() {
		radiobutton.click();
	}
	
	public void ClickonMultipleSelect() {
		Select select=new Select(Multipleselect);
		select.selectByIndex(1);
	}
	
	public void Clickondropdown() {
		Select select=new Select(dropdown);
		select.selectByIndex(1);
	}
	
	public void ClickonSubmit() {
		Select select=new Select(submit);
		select.selectByIndex(1);
	}

	
}
