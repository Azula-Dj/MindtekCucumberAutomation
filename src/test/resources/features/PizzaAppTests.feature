@OMT-7932 @regression
Feature: Validating pizza application functionalities

  Scenario: Validating place order functionality
    Given user navigates to pizza application
    When  user creates pizza orders with data
      | Pizza        | Small 6 Slices - no toppings |
      | Toppings 1   | Mushrooms                    |
      | Toppings 2   | Mushrooms                    |
      | Quantity     | 1                            |
      | Name         | Patel Harsh                  |
      | Email        | patel@gmail.com              |
      | Phone        | 123456789                    |
      | Payment Type | Credit Card                  |
    Then user validates then order is created with success message "Thank you for your order! TOTAL: " "Small 6 Slices - no toppings"

    #Map<String,Object>map=new HashMap():
  #map.put("PIzza","Small 6 Slice - no toppings");
  #map.put("Toppings 1,Mushrooms)


