package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.DashboardPage;

public class DashboardSteps extends BaseStep {
	
	WebDriver driver = GetDriver();
	DashboardPage dash = PageFactory.initElements(driver, DashboardPage.class);

	@When("^land on the dashboard$")
	public void land_on_the_dashboard() throws Throwable {

		dash.validateDashboard();

	}
	
	@Then("^go to Bank and Cash click on New Account$")
	public void go_to_Bank_and_Cash_click_on_New_Account() throws Throwable {
		dash.ClickBankAndCash();
		dash.ClickNewAccount();
	}
}
