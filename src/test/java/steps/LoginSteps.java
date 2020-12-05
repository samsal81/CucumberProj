package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.LoginPage;
import util.BrowserFactory;

public class LoginSteps {
	WebDriver driver;
	LoginPage login;
	BrowserFactory browserfactory;

	@Before
	public void StartBrowser() {
		driver = BrowserFactory.init();
		login = PageFactory.initElements(driver, LoginPage.class);
		browserfactory = PageFactory.initElements(driver, BrowserFactory.class);
	}

	@Given("^User on Techfios login page$")
	public void User_on_Techfios_login_page() throws Throwable {
		driver.get("https://www.techfios.com/billing/?ng=login/");
		Assert.assertEquals(driver.getTitle(), "Login - iBilling");
		
	}

	@When("^User enters username \"([^\"]*)\"$")
	public void user_enters_username(String userName) throws Throwable {

		// String userName = "demo@techfios.com";
		login.enterUserName(userName);
	}

	@When("^User enters password \"([^\"]*)\"$")
	public void user_enters_password(String password) throws Throwable {
		// String password = "abc123";
		login.enterPassword(password);
	}

	@When("^User clicks on sign in button$")
	public void user_clicks_on_sign_in_button() throws Throwable {
		login.clickSigninButton();
	}

	@Then("^User should land on dashboard page$")
	public void user_should_land_on_dashboard_page() throws Throwable {
		Assert.assertEquals(driver.getTitle(), "Dashboard- iBilling");
		browserfactory.takeScreenshotAtEndOfTest(driver);
	}

	@After
	public void closeBrowser() {
		BrowserFactory.tearDown();
	}

}
