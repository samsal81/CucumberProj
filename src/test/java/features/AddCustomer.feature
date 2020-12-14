@addCustomer @Regression
Feature: Validate Customer Adding Functionality

Background: 
	Given User on Techfios login page
	
@Scenario1
Scenario Outline: User should be able add a customer
	When User enters username "<username>" and password "<password>" and click login
	And land on the dashboard
	Then go to customers to add a new customer
	Then fill out the new customer information and submit "<name>" "<company>" "<group>" "<email>" "<phoneNum>" "<address>" "<city>" "<state>" "<zip>" "<country>" "<password>"
	Then validate that the customer was created
	Then User closes browser

		Examples: 
         | username          | password | name | company  | group    | email             | phoneNum  | address         | city        | state    | zip   | country       | password|
         | demo@techfios.com | abc123   | John | Techfios | June2020 | john@techfios.com | 235 468 6 | 22 robinhood rd | Springfield | Illinois | 62704 | United States | abc12300|
         