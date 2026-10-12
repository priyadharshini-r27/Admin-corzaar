Feature: Audit Trail Verification

 Scenario: Audit trail log query and status filters
 Given user is on the dashboard page again
 When admin select the audit trail module
 And admin use searchfield and find the details "<SecurityAction>"
 And verify the result "<Status>" with message "<expectedmessage>"
 And admin clear the search field
 And admin use the filter option
 And admin select the course option
 And verify the displayed result details
 And admin select the payouts option
 And verify payout details displayed correctly
 And admin select the batches option
 And verify batches details displayed correctly
 And admin select the institute option
 And verify institute details displayed correctly
 And admin select the coupons option
 And verify coupons details displayed correctly
 And admin select the Certificates option
 Then verify Certificates details displayed correctly

 Examples:
 | SecurityAction   | Status  | expectedmessage             |
 | python           | invalid | No audit logs recorded yet. |
 | Course published | valid   |                             |