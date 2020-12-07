package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;
import page.AddCustomerPage;
import util.BrowserFactory;

public class AddCustomerSteps extends BaseStep {

	WebDriver driver = GetDriver();
	AddCustomerPage addcus = PageFactory.initElements(driver, AddCustomerPage.class);
	BrowserFactory browserfactory;

	@Then("^go to customers to add a new customer$")
	public void go_to_customers_to_add_a_new_customer() throws Throwable {

		addcus.clickOnCustomerButton();
		addcus.clickOnAddCustomerButton();

	}

	@Then("^fill out the new customer information and submit \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void fill_out_the_new_customer_information_and_submit(String name, String company, String group,
			String email, String phoneNum, String address, String city, String state, String zip, String country,
			String password) throws Throwable {

		addcus.enterName(name);
		addcus.enterCompanyName(company);
		addcus.enterGroupName(group);
		addcus.enterEmail(email);
		addcus.enterPhoneNumber(phoneNum);
		addcus.enterAddress(address);
		addcus.enterCity(city);
		addcus.enterState(state);
		addcus.enterZip(zip);
		addcus.enterCountryName(country);
		addcus.enterPassword(password);
		addcus.enterCPassword(password);
		addcus.clickSubmitButton();

	}

	@Then("^validate that the customer was created$")
	public void validate_that_the_customer_was_created() throws Throwable {
		addcus.clickListCustomersButton();
		browserfactory.takeScreenshotAtEndOfTest(driver);
		addcus.verifyEnteredNameAndCheckView();
		Thread.sleep(3000);
	}

}
