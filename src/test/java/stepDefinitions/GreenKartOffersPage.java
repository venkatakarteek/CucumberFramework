package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class GreenKartOffersPage {

	public String dealsProductName;
	TestContextSetup testContextSetup;

	public GreenKartOffersPage(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Then("^User searched for \"([^\\\"]*)\" Shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exists(String shortName) {
		OffersPage offersPage = new OffersPage(testContextSetup.driver);
		offersPage.switchToWindow();
		offersPage.searchByName(shortName);
		dealsProductName = offersPage.getTextofElement();

	}

	@And("^validate product name in offers page matches with product name in landing page$")
	public void validate_product_name_in_offers_page_matches_with_product_name_in_landing_page() throws Throwable {
		Assert.assertEquals(testContextSetup.actualProduct, dealsProductName);
	}

}