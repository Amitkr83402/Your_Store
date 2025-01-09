Feature: Search functionality 

Scenario: User searches for a valid product
Given User opens application
When  User enters valid product "Hp" into search box field
And User clicks search button
Then User should get a valid product displayed in the search result

Scenario: User searches for a invalid product
Given User opens application
When  User enters invalid product "Honda" into search box field
And User clicks search button
Then User should get a message about no product matching

Scenario: User searches without any product 
Given User opens application
When User dint enter any product name into Search box field
And User clicks search button 
Then User should get a message about no product matching 