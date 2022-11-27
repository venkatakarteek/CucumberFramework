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
	By addButton = By.cssSelector("a.increment");
	By addToCart = By.cssSelector("div[class='product-action'] button[type='button']");

	public void searchWithName(String name) {
		driver.findElement(search).sendKeys(name);
	}

	public String getProductName() {
		return driver.findElement(produtName).getText();
	}

	public void selectTopDealsLink() {
		driver.findElement(topDealslink).click();
	}

	public String getTitleLandingPage() {
		return driver.getTitle();
	}

	public void IncrementQuantity(int quantity) {
		int i = quantity;
		while (i > 1) {
			driver.findElement(addButton).click();
			i--;
		}
	}

	public void addToCart() {
		driver.findElement(addToCart).click();
	}
}
