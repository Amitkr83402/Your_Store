Feature: Register Functionality

Scenario: User creats an account only with mandatory fields 
Given User navigates to Register Account Page
When User enters the details into below fields
|firstName|Amit         |
|LastName|kumar         |
|email|amiyfit128583@gmail.com|
|telephone|1234567890   |
|password|12345         |
And User enter privacy policy
And User clicks on continew button
Then User account should get created sucessfully

Scenario: User creats an account with all fields 
Given User navigates to Register Account Page
When User enters the details into below fields
|firstName|Amit         |
|LastName|kumar         |
|email|amiyfit128583@gmail.com|
|telephone|1234567890   |
|password|12345         |
And User select yes for Newsletter
And User enter privacy policy
And User clicks on continew button
Then User account should get created sucessfully

Scenario: User creats an  Dublicate account 
Given User navigates to Register Account Page
When User enters the details into below fields
|firstName|Amit|
|LastName|kumar|
|email|amit12345@gmail.com|
|telephone|1234567890|
|password|12345|
And User select yes for Newsletter
And User enter privacy policy
And User clicks on continew button
Then User account should get proper warning about dublicate email

Scenario: User creates an acccount without filling any details 
Given User navigates to Register Account Page
When User dont enter any details into field
And User clicks on continew button
Then User should get proper warning message for every mandatory field 
