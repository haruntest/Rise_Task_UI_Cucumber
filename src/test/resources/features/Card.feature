@card @regression @smoke
Feature: Amazon webpage customer step

  Background:
    Given The user open the amazon page
    And  The user should be able to accept cookies
    When The user click on Merhaba, giris yapin button
    When The user enters login email
    And  The user clicks Devam et button
    When The user enters password
    And  The user clicks Giris yap button


  @addToCard
  Scenario Outline: "<product>" add to favorite list and cart
    When The user selects "<products>" from the Tum kategoriler
    Then Verify the user can see the "<products>" on categories
    When The user enters "<productType>" in search box
    And  The user clicks search button
    Then Verify the user can search "<productType>"
    When The user clicks page "<pageNumber>" button
    Then Verify the user can see page "<pageNumber>"
    When The user clicks product "<orderProduct>"
    Then Verify the user is on selected product page
    And  The user should be able to add selected product in Favorilerim list
    And  The user should be able to close the list page
    When The user navigates to Hesabim and Favorilerim list
    Then Verify the user can see selected product in Favorilerim list
    When The user click on "Sepete Ekle" button
    And  The user clicks Alisveris Sepetini Goruntule button
    Then The user can delete selected product in Alisveris Sepeti
    When The user navigates to Hesabim and Favorilerim list
    When The user deletes selected product in Favorilerim list
    Then Verify the user can delete selected product in Favorilerim list
    When The user logs out
    Then Verify the user can be logged out

    Examples:
      | products      | productType | pageNumber | orderProduct |
      | Bilgisayarlar | casper      | 5          | 3            |
    # | Bilgisayarlar | dell        | 3          | 8            |
     #| Elektronik     | pil         | 2          | 2           |
     #| Moda           | triko       | 2          | 2           |

     # scenarios can be multiplied


