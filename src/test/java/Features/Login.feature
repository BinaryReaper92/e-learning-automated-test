Feature: Login

  @RegressionTest @SmokeTest
  Scenario: Successful login with valid credentials

    Given Admin opens URL "stage"
    And Admin enters Email as "admin"
    And Admin enters Password as "admin"
    And Admin click on Login
    Then Page Title should be "Dashboard"

  @RegressionTest @ErrorsTest
  Scenario: Unsuccessful login with both credentials missing
    Given Admin opens URL "stage"
    And Admin leaves Email as blank
    And Admin leaves Password as blank
    Then Email and Password error message should display as "This field is required!"

  @RegressionTest
  Scenario: Unsuccessful login with email missing
    Given Admin opens URL "stage"
    And Admin leaves Email as blank
    And Admin enters Password as "admin"
    And Admin click on Login
    Then Email error message should display as "Az e-mail formátuma nem megfelelő!"

  @RegressionTest
  Scenario: Unsuccessful login with password missing
    Given Admin opens URL "stage"
    And Admin enters Email as "admin"
    And Admin leaves Password as blank
    And Admin click on Login
    Then Password error message should display as "A jelszó formátuma nem megfelelő!"

  @RegressionTest
  Scenario: Unsuccessful login with wrong email format
    Given Admin opens URL "stage"
    And Admin enters Email as "wrong"
    And Admin enters Password as "admin"
    And Admin click on Login
    Then Email error message should display as "Az e-mail formátuma nem megfelelő!"

  @RegressionTest
  Scenario: Unsuccessful login with wrong password format
    Given Admin opens URL "stage"
    And Admin enters Email as "admin"
    And Admin enters Password as "wrong"
    And Admin click on Login
    Then Password error message should display as "A jelszó formátuma nem megfelelő!"

  @RegressionTest @ReTest
  Scenario: Unsuccessful login with non-existent credentials
    Given Admin opens URL "stage"
    And Admin enters Email as "notExist"
    And Admin enters Password as "notExist"
    And Admin click on Login
    Then Login error message should display as "Sikertelen bejelentkezés!"

  @RegressionTest
  Scenario: Login Button color change on Hoover
    Given Admin opens URL "stage"
    And Admin Hoover on Login button
    Then Login button's color should change to yellow

  @RegressionTest
  Scenario: Change hidden password characters to visible
    Given Admin opens URL "stage"
    And Admin enters Password as "wrong"
    And Admin click on Eye icon
    Then Password should be visible


  @RegressionTest
  Scenario: Open forgot password modal
    Given Admin opens URL "stage"
    And Admin click on Forgot password
    Then Forgot password modal should appear
