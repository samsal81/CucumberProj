package addAccountSteps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.AddAccountPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddAccountSteps {

	WebDriver driver;
	LoginPage login;
	DashboardPage dash;
	AddAccountPage addacc;

	@Before
	public void setup() throws Throwable {

		driver = BrowserFactory.init();
		login = PageFactory.initElements(driver, LoginPage.class);
		dash = PageFactory.initElements(driver, DashboardPage.class);
		addacc = PageFactory.initElements(driver, AddAccountPage.class);
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

	@Then("^go to Bank and Cash click on New Account$")
	public void go_to_Bank_and_Cash_click_on_New_Account() throws Throwable {
		dash.ClickBankAndCash();
		dash.ClickNewAccount();
	}

	@Then("^fill out the new account information and submit \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void fill_out_the_new_account_information_and_submit(String accountTitle, String description,
			String initialBalance, String accountNumber, String contactPerson, String phone) throws Throwable {
		addacc.InputAccountTitle(accountTitle);
		addacc.InputDescription(description);
		addacc.InputInitialBalance(initialBalance);
		addacc.InputAccountNumber(accountNumber);
		addacc.InputContactPerson(contactPerson);
		addacc.InputPhone(phone);
		addacc.SubmitButton();

	}

	@Then("^validate that the account was created$")
	public void validate_that_the_account_was_created() throws Throwable {
		addacc.AssertAccountCreatedSuccessfully();
	}

	@After
	public void teardown() {
		BrowserFactory.tearDown();
	}

}
