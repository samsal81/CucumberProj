package addCustomerSteps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerSteps {
	WebDriver driver;
	LoginPage login;
	DashboardPage dash;
	AddCustomerPage addcus;

	@Before
	public void User_is_on_Techfios_login_page() throws Throwable {

		driver = BrowserFactory.init();
		login = PageFactory.initElements(driver, LoginPage.class);
		dash = PageFactory.initElements(driver, DashboardPage.class);
		addcus = PageFactory.initElements(driver, AddCustomerPage.class);
	}

	@Given("^User on Techfios login page$")
	public void user_on_Techfios_login_page() throws Throwable {
		driver.get("https://www.techfios.com/billing/?ng=login/");
		Assert.assertEquals(driver.getTitle(), "Login - iBilling");
	}

	@When("^User enters username \"([^\"]*)\" and password \"([^\"]*)\" and click login$")
	public void user_enters_username_and_password_and_click_login(String username, String password) throws Throwable {
		login.Login(username, password);
	   
	}

	@When("^land on the dashboard$")
	public void land_on_the_dashboard() throws Throwable {

		dash.validateDashboard();

	}

	@Then("^go to customers to add a new customer$")
	public void go_to_customers_to_add_a_new_customer() throws Throwable {

		addcus.clickOnCustomerButton();
		addcus.clickOnAddCustomerButton();

	}

	@Then("^fill out the new customer information and submit$")
	public void fill_out_the_new_customer_information_and_submit() throws Throwable {

		/*
		 * addcus.enterName(name); addcus.enterCompanyName(company);
		 * addcus.enterGroupName(group); addcus.enterEmail(email);
		 * addcus.enterPhoneNumber(phoneNum); addcus.enterAddress(address);
		 * addcus.enterCity(city); addcus.enterZip(zip);
		 * addcus.enterCountryName(country); addcus.enterPassword(password);
		 * addcus.enterCPassword(cpassword); addcus.clickSubmitButton();
		 */

	}

	@Then("^validate that the customer was created$")
	public void validate_that_the_customer_was_created() throws Throwable {

	}
}
