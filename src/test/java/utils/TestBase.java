package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {

		Properties properties = new Properties();
		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\GlobalDataProperties";
		FileInputStream fis = new FileInputStream(filePath);
		properties.load(fis);
		String url = properties.getProperty("url");
		if (driver == null) {
			if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {

				driver = new ChromeDriver();

			} else if (properties.getProperty("browser").equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else if (properties.getProperty("browser").equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}
			driver.get(url);

		}

		return driver;
	}
}
