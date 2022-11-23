package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	private By search = By.xpath("//input[@type='search']");
	private By produtName = By.cssSelector("h4[class='product-name']");
	private By topDealslink = By.xpath("//a[text()='Top Deals']");

	public void searchWithName(String name) {
		driver.findElement(search).sendKeys(name);
	}

	public String getProductName() {
		return driver.findElement(produtName).getText();
	}
	
	public void clickOnLink() {
		driver.findElement(topDealslink).click();
	}
}
