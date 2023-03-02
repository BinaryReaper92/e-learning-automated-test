Feature: ForgotPassword

  @RegressionTest @ForgotPassword
  Scenario: Successful Send Reminder with valid email
    Given Admin opens forgot password modal
    And Admin enters Email as "admin"
    And Admin click on Send
    Then Success Modal should appear

  @RegressionTest @ForgotPassword
  Scenario: Unsuccessful Send Reminder with missing email
    Given Admin opens forgot password modal
    And Admin click on Send
    Then Email error message should display as "This field is required!"

  @RegressionTest @ForgotPassword
  Scenario: Unsuccessful Send Reminder with wrong email format
    Given Admin opens forgot password modal
    And Admin enters Email as "wrong"
    And Admin click on Send
    Then Email error message should display as "Please provide valid email address!"

  @RegressionTest @ForgotPassword
  Scenario: Click outside of the modal
    Given Admin opens forgot password modal
    And Admin click outside of the modal
    Then Forgot password modal should not disappear

  @RegressionTest @ForgotPassword
  Scenario: Close Popup with X
    Given Admin opens forgot password modal
    And Admin click on X button
    Then Forgot password modal should disappear

  @RegressionTest @ForgotPassword
  Scenario: Close Popup with Close
    Given Admin opens forgot password modal
    And Admin click on Close button
    Then Forgot password modal should disappear

