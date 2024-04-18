Feature: Login feature

  Scenario: Login Success
    Given I open browser
    And I open Login Page
    When I enter email "sanjeela.chitrakar@testpro.io"
    And I enter password "te$t$tudent1"
    And I submit
    Then I should get logged in
