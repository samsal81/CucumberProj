package util;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
			
	}
	
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
	
	public void takeScreenshotAtEndOfTest (WebDriver driver) throws IOException {
		  TakesScreenshot ts = ((TakesScreenshot) driver);
		  File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(sourceFile, new File("./target/cucumber/screenshots/" + System.currentTimeMillis() + ".png"));
		 }

}
