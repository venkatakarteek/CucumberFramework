package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
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

	@AfterStep
	public void attachScreenshot(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			WebDriver driver = testContextSetup.testBase.WebDriverManager();
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(screenshotFile);
			scenario.attach(fileContent, "image/png", "image");
			
		}
	}
}
