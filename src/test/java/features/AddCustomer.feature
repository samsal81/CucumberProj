@addCustomer 
Feature: Validate Customer Adding Functionality 

Background: 
	Given User on Techfios login page 
	
Scenario Outline: User should be able add a customer 
	When User enters username "<username>" and password "<password>" and click login
	And land on the dashboard 
	Then go to customers to add a new customer 
	Then fill out the new customer information and submit 
	Then validate that the customer was created 

		Examples: 
         | username                  | password   |
         | demo@techfios.com         | abc123     |