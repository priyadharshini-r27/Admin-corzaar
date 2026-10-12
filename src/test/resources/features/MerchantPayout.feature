Feature: Merchant Payouts Module

 Scenario: Verify recording and disbursing settlements
 Given admin is on the dashboard page
 When admin click the merchant payment module
 And admin verify the record settlement popup window
 And admin select the institute or merchant recipient "<recipientId>"
 And admin enter the settlement amount "<amount>"
 And admin enter the bank transfer details "<bankreceipt>"
 And admin enter the notes details "<notes>"
 And admin select the log settlement button
 Then verify the settlement details should be added

 Examples:
 | recipientId                          | amount | bankreceipt   | notes        |
 | eb1c121c-9aa3-4a96-a95c-8ceb9f398cb2 | 5000   | NEFT-64451987 | tuition fee  |
 | c3704f77-b57c-4db7-96fa-84c7c5ffe6f2 | 6500   | NEFT-64451992 | Advanced fee |