Feature: Login functionality

Scenario: Login with valid credentioals
Given User navigates to Login page 
When User enters valid email address "amit123@gmail.com" into email field
And User enters valid password "12345" into password field
And User click on Login button
Then User should get successfully Logged in 

Scenario: Login with invalid credentioals 
Given User navigates to Login page 
When User enters invalid email address "auotjdjghdfu23432@gmail.com" into email field
And User enters invalid password "1234567890" into password field 
And User click on Login button
Then User shoud get warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given User navigates to Login page 
When User enters valid email address "amit123@gmail.com" into email field
And User enters invalid password "1234567890" into password field 
And User click on Login button
Then User shoud get warning message about credentials mismatch

Scenario: Login with invalid email and valid password
Given User navigates to Login page 
When User enters invalid email address "auotjdjghdfu23432@gmail.com" into email field
And User enters valid password "12345" into password field 
And User click on Login button
Then User shoud get warning message about credentials mismatch

Scenario: Login wittout providing any credentioals
Given User navigates to Login page 
When User do not enters email address into email field 
And User do not enter password into password field
And User click on Login button
Then User shoud get warning message about credentials mismatch