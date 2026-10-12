Feature: Super Admin Authentication

Scenario : Admin valid login and OTP validation
Given user launch the application
When user click the admin button
And user enter the "<Email id>"
And user enter the password "<Password>"
And click the authenticate button
And Admin is on the 2FA verification page
And admin enters valid "<otp>"
And admin click the verify button
And admin verify the "<valid>" and "<Message>"
Then admin should be logged in successfully

Examples:
| Email id          | Password  | otp    | valid   | 
| admin@corzaar.com | Admin@123 | 123456 | valid   | 


Scenario : Admin invalid login
Given user launch the application
When user click the admin button
And user enter the "<Email id>"
And user enter the password "<Password>"
And click the authenticate button
Then user verify the "<status>" and "<Message>"

Examples:
| Email id | Password | status | Message |
| admin@corzaar.com | Admin@1234 | failed | Invalid admin credentials |
| admin@2corzaar.com | Admin@123 | failed | Invalid admin credentials |
| admin@corzaar.com | Admin@123 | 098765 | invalid | Invalid admin OTP |