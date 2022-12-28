package cucumberOptions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Snippet {
	WebDriver driver;
	ExtentReports extent;

	@BeforeMethod
	public void configuration() {

		ExtentSparkReporter reporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "\\reports\\extentReport.html");
		reporter.config().setDocumentTitle("ATW Test");
		reporter.config().setReportName("ATW report");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Operating System", "Windows 11");
		extent.setSystemInfo("Java version", "11.0.16");
		extent.setSystemInfo("Selenium version", "4.7.2");
		extent.setSystemInfo("TestNG version", "7.7.0");
		extent.setSystemInfo("Tested By", "Surendra");
	}

	@Test
	public void mTest() {
		ExtentTest etest = extent.createTest("mTest execution started");
		driver = new ChromeDriver();
		etest.info("Browser got launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://surendrareddy1248.github.io/WebElementsTesting/");
		etest.info("Navigated to WebElements page");
		String expected = "Sample Text for testing123.";

		String actual = driver.findElement(By.id("testtext_1")).getText();
		etest.info("Retrieved actual text and asserting with expected text");
		etest.fail("mTest failed");
		Assert.assertEquals(actual, expected);

	}

	@AfterMethod
	public void closure() {
		driver.quit();
		extent.flush();
	}

}
