@login @regression @smoke
Feature: The registered user should be able to login

  @positive
  Scenario: The user should be able to login
    Given The user open the amazon page
    Then Verify the user is on the home page
    And  The user should be able to accept cookies
    When The user click on Merhaba, giris yapin button
    Then Verify the user is on the login page
    When The user enters login email
    And  The user clicks Devam et button
    Then Verify the user is on the password window
    When The user enters password
    And  The user clicks Giris yap button
    Then Verify the user is logged in

  @negative
  Scenario: The user must not be able to login with invalid email
    Given The user open the amazon page
    And  The user should be able to accept cookies
    When The user click on Merhaba, giris yapin button
    When The user enters login invalid email
      |                  |
      | xxxx             |
      | @outlook.com     |
      | fakename@outlook |
    # | negative scenarios can be multiplied |
    Then Verify the user isn't on the password window

  @negative
  Scenario: The user must not be able to login with invalid password
    Given The user open the amazon page
    And  The user should be able to accept cookies
    When The user click on Merhaba, giris yapin button
    When The user enters login email
    And  The user clicks Devam et button
    When The user enters invalid password
      |          |
      | 12234    |
      | harun    |
    # | negative scenarios can be multiplied |
    Then Verify the user isn't logged in