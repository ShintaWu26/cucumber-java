Feature: Login

	Scenario: Valid Login
		When User go to web demoqa
		And User enter username password
		And User click button login
		Then User valid credentials
		