package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;
import page.AddAccountPage;

public class AddAccountSteps extends BaseStep {
	
	WebDriver driver = GetDriver();
	AddAccountPage addacc = PageFactory.initElements(driver, AddAccountPage.class);

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


}
