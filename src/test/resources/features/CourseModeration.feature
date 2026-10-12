Feature: Course Moderation Module

 Scenario: Course moderation invalid course search
 Given user is on the dashboard page
 When admin click the course moderation module
 And admin search the topic in search field "Oracle SQL"
 Then admin verify the course "Oracle SQL" as "Invalid" with "No courses found in this category."

 Scenario: Verify course moderation status and filter
 Given user is on the dashboard page
 When admin click the course moderation module
 And admin search the course topic in search field "<course>"
 And admin clear the search field in coursemoderation module
 And admin verify course moderation filter option is displayed
 And admin select the published option
 And the option filter the details and should be displayed correctly for "published"
 And admin select the underreview option
 And the option filter the details and should be displayed correctly for "under_review"
 And admin select the rejected option
 Then the option filter the details and should be displayed correctly for "rejected"

 Examples:
 | course          | Status |
 | Playwright      | valid  |
 | java selenium   | valid  |