@addAccount
Feature: Validate Account Adding Functionality 

Background: 
	Given User on Techfios login page 
	
@Scenario1	
Scenario Outline: User should be able add a customer 
	When User enters username "demo@techfios.com" and password "abc123" and click login
	Then User should land on dashboard page
	Then go to Bank and Cash click on New Account
	Then fill out the new account information and submit "<AccountTitle>" "<Description>" "<InitialBalance>" "<AccountNumber>" "<ContactPerson>" "<Phone>"
	Then validate that the account was created 
	
	Examples:
	| AccountTitle        | Description          | InitialBalance | AccountNumber | ContactPerson | Phone        |
	| SavingsAccount85749 | Where you save money | 6000           | 15618616      | john wick     | 856 488 8476 |