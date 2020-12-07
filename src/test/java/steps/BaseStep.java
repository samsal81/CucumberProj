package steps;

import org.openqa.selenium.WebDriver;

import util.BrowserFactory;

public class BaseStep {

	protected static WebDriver driver = null;

	protected WebDriver GetDriver() {
		if (driver == null) {
			driver = BrowserFactory.init();
		}
		return driver;

	}

}