package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class GreenKartCheckoutPage {
	public TestContextSetup testContextSetup;
	public CheckoutPage checkoutPage;

	public GreenKartCheckoutPage(TestContextSetup testContextSetup) {

		this.testContextSetup = testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckOutPage();
	}

	@Then("^User proceeds to Checkout and validate the (.+) items in Checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String vegname) throws Throwable {

		checkoutPage.CheckOutItems();
		
		Assert.assertEquals(testContextSetup.productName, checkoutPage.getProductName());
	}

	@And("^Verify User has ability to enter promo code and place the order$")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() throws Throwable {

		Assert.assertTrue(checkoutPage.verifyPromoBtn());
		Assert.assertTrue(checkoutPage.verifyPlaceOrderBtn());
	}

}
