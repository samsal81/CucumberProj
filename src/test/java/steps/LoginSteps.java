package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.LoginPage;

public class LoginSteps extends BaseStep {

	WebDriver driver;
	LoginPage login;

	@Before
	public void setup() {

	}

	@When("^User on Techfios login page$")
	public void user_on_Techfios_login_page() throws Throwable {
		driver = GetDriver();
		login = PageFactory.initElements(driver, LoginPage.class);
		driver.get("https://www.techfios.com/billing/?ng=login/");
		// Assert.assertEquals(driver.getTitle(), "Login - iBilling");

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

	@When("^User enters username \"([^\"]*)\" and password \"([^\"]*)\" and click login$")
	public void user_enters_username_and_password_and_click_login(String username, String password) throws Throwable {
		login.Login(username, password);

	}

	@When("^User clicks on sign in button$")
	public void user_clicks_on_sign_in_button() throws Throwable {
		login.clickSigninButton();
	}

	@Then("^User should land on dashboard page$")
	public void user_should_land_on_dashboard_page() throws Throwable {
		// Assert.assertEquals(driver.getTitle(), "Dashboard- iBilling");
	}

	@Then("^User closes browser$")
	public void user_closes_browser() throws Throwable {
		driver.close();
		driver.quit();
	}

	/*
	 * @After public void closeBrowser() { driver.close(); driver.quit(); }
	 */

}
