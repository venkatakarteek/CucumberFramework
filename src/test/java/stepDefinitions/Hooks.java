package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.After;
import utils.TestContextSetup;

public class Hooks {

	public TestContextSetup testContextSetup;

	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@After
	public void CloseBrowser() throws IOException {
		testContextSetup.testBase.WebDriverManager().quit();
	}
}
