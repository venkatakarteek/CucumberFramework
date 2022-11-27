package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	public WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	By cartButton = By.cssSelector("img[alt='Cart']");

	By checkOutButton = By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']");

	By promoButton = By.className("promoBtn");
	By placeOrderButton = By.xpath("//button[normalize-space()='Place Order']");
	
	By productName=By.xpath("//tbody//tr//td[2]/p");
	
	public void CheckOutItems() {
		driver.findElement(cartButton).click();
		driver.findElement(checkOutButton).click();
	}

	public boolean verifyPromoBtn() {
		return driver.findElement(promoButton).isDisplayed();
	}
	
	public boolean verifyPlaceOrderBtn() {
		return driver.findElement(placeOrderButton).isDisplayed();
	}
	
	public String getProductName() {
		String name =driver.findElement(productName).getText();
		return name;
	}
}
