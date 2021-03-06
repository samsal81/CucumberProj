@login @Regression 
Feature: validate login functionality 

@LoginScenario1 
Scenario: User should be able to login with valid credential
	When User on Techfios login page
	When User enters username "demo@techfios.com"
	And User enters password "abc123"
	And User clicks on sign in button
	Then User should land on dashboard page
	#Then User closes browser
	
 	
@LoginScenario2 
Scenario Outline: User should be able to login with valid credential
	When User on Techfios login page
	When User enters username "<username>"
	And User enters password "<password>"
	And User clicks on sign in button
	Then User should land on dashboard page
	#Then User closes browser
	
	
	Examples: 
		| username                  | password   |
		| techfiosdemo@gmail.com    | abc123     |
		| demo@techfios.com         | abc124     |
		| demo@techfios.com         | abc123     |
		
		