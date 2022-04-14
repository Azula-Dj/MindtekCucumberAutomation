@regression @ui @MB2P-120
Feature: Validating calculate abd order creation functionalities

  Scenario Outline: Validating calculate functionality
    Given user navigates to the weborders application
    When  user provides username "Tester" and password "test" and clicks on login
    And user clicks on Order module
    And user selects "<product>" product with <quantity> quantity
    Then user validates total is calculated correctly for quantity <quantity>
    Examples:
      | product     | quantity |
      | MyMoney     | 1        |
      | FamilyAlbum | 100      |
      | ScreenSaver | 55       |
      | MyMoney     | 20       |



  Scenario: Validating create order functionality
    Given user navigates to the weborders application
    When  user provides username "Tester" and password "test" and clicks on login
    And user clicks on Order module
    And user creates order with data
       |MyMoney|1 |John Doe|123 My Road| Chicago| Illinois| 12345| 123456789| 12/21|

    Then  user validates succsess message "Now order has been successfully added."
    And  user validates order added to List Of Orders




