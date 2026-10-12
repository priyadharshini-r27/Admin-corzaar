Feature: Coupon Approval Module

 Scenario: Verify coupon code search and filtering
 Given admin is on the coupon dashboard page
 When admin click the coupon approval module
 And admin search the coupon code in search field "<Couponcode>"
 And the displayed message depends on search code
 And admin verify the details "<Status>" and "<Displayedmessage>"
 And admin clear the couponapproval search field
 And admin verify filter option is displayed
 And admin select the pending option
 And admin select the approved button
 And the approved button displayed correct details
 And admin select the rejected button
 Then the reject button should be displayed correct details

 Examples:
 | Couponcode | Status  | Displayedmessage  |
 | FAST20     | invalid | No coupons found. |
 | FESTIVE25  | valid   |                   |