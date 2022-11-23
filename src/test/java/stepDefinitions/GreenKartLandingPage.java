package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class GreenKartLandingPage {

	public WebDriver driver;

	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;

	public GreenKartLandingPage(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Given("^User is on Greenkart Landing page$")
	public void user_is_on_greenkart_landing_page() {
		testContextSetup.driver = new ChromeDriver();
		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

	}

	@When("^User searched with Shortname \"([^\\\"]*)\" and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName)
			throws InterruptedException {

		
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.searchWithName(shortName);
		Thread.sleep(2000);
		testContextSetup.actualProduct = landingPage.getProductName().split("-")[0].trim();
		landingPage.clickOnLink();

	}

}
