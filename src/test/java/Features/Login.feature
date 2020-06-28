Feature: Login

  Scenario: Successful login with valid credentials

    Given Admin opens URL "https://mtu-cms-dev.attrecto-dev.com/auth/login"
    And Admin enters Email as "admin"
    And Admin enters Password as "admin"
    And Admin click on Login
    Then Page Title should be "????"