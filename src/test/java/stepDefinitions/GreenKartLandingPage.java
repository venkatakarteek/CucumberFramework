package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class GreenKartLandingPage {

	public WebDriver driver;

	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	LandingPage landingPage;

	public GreenKartLandingPage(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}

	@Given("^User is on Greenkart Landing page$")
	public void user_is_on_greenkart_landing_page() {
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}

	@When("^User searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName)
			throws InterruptedException {

		landingPage.searchWithName(shortName);
		Thread.sleep(2000);
		testContextSetup.productName = landingPage.getProductName();
		testContextSetup.actualProduct = landingPage.getProductName().split("-")[0].trim();

	}

	@And("^Added \"([^\"]*)\" items of the selected product to cart$")
	public void added_something_items_of_the_selected_product_to_cart(String quantity) throws Throwable {
		landingPage.IncrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart(); 

	}
}
