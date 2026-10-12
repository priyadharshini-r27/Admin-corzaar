Feature: Institute Moderation

@institute
Scenario: Search institute by institute name
Given user is on the institutes moderation page
When admin click the institutes moderation module
And admin enters "<Institute Name>" in institute search field
Then and verify the "<status>" valid "<expected>" details
When admin clear the search field in institute module

Examples:
| Institute Name               | status  | expected                     |
| Vels                         | invalid | No matching institutes found.|
| Apex Institute of Technology | valid   | Apex Institute of Technology |

@place
Scenario: Search institute by place
Given user is on the institutes moderation page
When admin click the institutes moderation module
And admin enters the in institute place "<Place>" search field
Then admin should see institutes from place "<Place>" with "<Status>" and expected "<expected>"
When admin clear the search field in institute module

Examples:
| Place      | Status  | expected                      |
| Chennai    | invalid | No matching institutes found. |
| Bengaluru  | valid   | Bengaluru                   |