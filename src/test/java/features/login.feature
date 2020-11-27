@login 
Feature: validate login functionality 

Background: 
	Given User is on Techfios login page 
	
Scenario: User should be able to login with valid credential 
	When User enters username 
	And User enters password 
	And User clicks on sign in button 
	Then User should land on dashboard page 
