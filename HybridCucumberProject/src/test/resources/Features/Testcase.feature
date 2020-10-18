Feature: To Verify Orangehrm Application

Scenario Outline: To test the login functionlity of Orangehrm

Given To lunch the browser and navigate to URL
When To enter "<username>" and "<password>"
Then To click the submit button
Then To take the screenshot and close the browser

Examples:
 |username|password|
 |Admin|admine123|
 |Admin|admin|

