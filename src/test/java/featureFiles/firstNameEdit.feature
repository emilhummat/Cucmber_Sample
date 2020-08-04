Feature: First name editing feature

  Scenario: Successfully edit the first name
    Given Navigate to the website
    When I use legit username and password
    Then I am logged in
    Given I navigate to My personal information page
    When  I edit personal info
    Then The first name is edited successfully
    Given I navigate to My personal information page
    When  I change the first name back to the previous one
    Then The first name is the same as the previous name