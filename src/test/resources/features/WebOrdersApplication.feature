@regression @smoke @ui @MB2P-116
Feature: Validating WebOrders application login functionality


  # Features -->can understand like a--> Test Class.
  # Scenario --> like a Test Method,Test case description.
  #1)Given --> It is Pre-condition. User need to have something to start test.
  #2)When- it is action.
  #3)Then -->it is validation/output
  #4)Add--> additional pre-condition/action/validation
  #5)But--------#--------------------------------------
  Scenario: Validating login functionality with valid credentials
    Given user navigates to the weborders application
    When  user provides username "Tester" and password "test" and clicks on login
    Then  user validates application is logged in

    Scenario: Validating login functionality with invalid credentials
      Given user navigates to the weborders application
      When  user provides username "Invalid" and password "invalid" and clicks on login
      Then  user validates error message "Invalid Login or Password."
