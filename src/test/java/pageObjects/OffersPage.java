package pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

	public WebDriver driver;

	public OffersPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By search=By.cssSelector("input[id='search-field']");
	private By productName=By.xpath("//tr/td[1]");
	
	public void switchToWindow() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String parentWindow = iterator.next();
		String childWindow = iterator.next();
		driver.switchTo().window(childWindow);
	}
	
	public void searchByName(String name) {
		driver.findElement(search).sendKeys(name);
	}
	
	public String getTextofElement() {
		return driver.findElement(productName).getText();
	}
}
