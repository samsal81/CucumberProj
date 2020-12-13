package page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Liberary
	@FindBy(how = How.XPATH, using = "//H2[contains(text(), ' Dashboard ')]")
	WebElement DASHBOARD_VALIDATION_ELEMENT;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Bank & Cash')]")
	WebElement BankAndCash;

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'New Account')]")
	WebElement NewAccount;
	

	// Interactive Method
	public void validateDashboard() {
		Assert.assertEquals(DASHBOARD_VALIDATION_ELEMENT.getText(), "Dashboard", "Wrong page!!");
	}
	
	public void ClickBankAndCash() {
		BankAndCash.click();
	}

	public void ClickNewAccount() {
		NewAccount.click();
	}

}
