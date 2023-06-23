#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: SalesForce Login Functionality

Scenario: Login with valid username and password
Given Login page is open
When i enter username and password
And login button is clicked
Then Home Page should be displayed

Scenario: Login with valid username and blank password
Given Login page is open
When i enter username and blank password
And login button is clicked
Then Error message should be displayed

Scenario: Remember Me functionality
Given Login page is open
When i enter username and password
And i check remember me checkbox 
And login button is clicked
Then Home Page should be displayed
When click on usermenu dropdown 
And click on logout button
Then Login Salesforce page is displayed 
And Remember Me checkbox is checked
And Valid username present in the username field

Scenario: Forgot Password Test A
Given Login page is open
When i click Forgot Your Password link
Then Forgot Password page is displayed
When i Provide username in salesforce forgot password page and click on contiue button
Then Password reset message page is displayed

Scenario: Forgot Password Test B
Given Login page is open
When i enter wrong username and wrong password
And login button is clicked
Then Error message should be displayed Your login attempt has failed 













