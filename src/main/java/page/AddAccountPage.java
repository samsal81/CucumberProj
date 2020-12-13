package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddAccountPage {

	WebDriver driver;

	public AddAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement AccountTitle;

	@FindBy(how = How.XPATH, using = "//input[@id='description']")
	WebElement Description;

	@FindBy(how = How.XPATH, using = "//input[@id='balance']")
	WebElement InitialBalance;

	@FindBy(how = How.XPATH, using = "//input[@id='account_number']")
	WebElement AccountNumber;

	@FindBy(how = How.XPATH, using = "//input[@id='contact_person']")
	WebElement ContactPerson;

	@FindBy(how = How.XPATH, using = "//input[@id='contact_phone']")
	WebElement Phone;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary']")
	WebElement SubmitButton;

	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-success fade in']")
	WebElement AccountCreatedSuccessfullyAlert;

	// Interactive Methods
	
	String account;
	
	public void InputAccountTitle(String accountTitle) {
		AccountTitle.sendKeys(accountTitle);
		account = accountTitle;
	}

	public void InputDescription(String description) {
		Description.sendKeys(description);
	}

	public void InputInitialBalance(String initialBalance) {
		InitialBalance.sendKeys(initialBalance);
	}

	public void InputAccountNumber(String accountNumber) {
		AccountNumber.sendKeys(accountNumber);
	}

	public void InputContactPerson(String contactPerson) {
		ContactPerson.sendKeys(contactPerson);
	}

	public void InputPhone(String phone) {
		Phone.sendKeys(phone);
	}

	public void SubmitButton() {
		SubmitButton.click();
	}
	
	public void ValidatePageTitle() {
		//Assert.assertEquals(driver.getTitle(), "Accounts- iBilling", "Wrong page!!");
	}

	public void AssertAccountCreatedSuccessfully() {
		
		boolean successAlertDisplayed = AccountCreatedSuccessfullyAlert.isDisplayed();
		
		if (successAlertDisplayed == true) {
			System.out.println("Successfull account creation Alert Displayed");

			int rows = driver.findElements(By.xpath("//tbody/tr")).size();

			for (int i = 2; i <= rows; i++) {
				String AccountName = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]")).getText();
				if (AccountName.equals(account)) {
					System.out.println("Success! The table contains the newly added data.");
				}
			}

		}
	}
}
