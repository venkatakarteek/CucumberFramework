package utils;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {

	public WebDriver driver;
	public String actualProduct;
	public PageObjectManager pageObjectManager;
	
	public TestContextSetup(WebDriver driver) {
		this.driver=driver;
		pageObjectManager=new PageObjectManager(driver);
	}
}
