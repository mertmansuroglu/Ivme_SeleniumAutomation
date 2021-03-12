Feature:  Ivme Guest Login Test Cases


  Scenario Outline: I should be able navigate to Ivme Login page
    Given I open the  browser "<browser>"
    When I  visit ivme web page
    Then I check if the page is correctly opened
    Then I check if the browser has been closed
    Examples:
      | browser |
      | chrome  |
      | firefox |

  Scenario Outline: I should be able navigate to guest login page
    Given I open the  browser "<browser>"
    When I  visit ivme web page
    Then I check if the page is correctly opened
    When I open guest login link
    Then I check if the guest login page is correctly opened
    Then I check if the browser has been closed
    Examples:
      | browser |
      | chrome  |
      | firefox |

  Scenario Outline: I should be able sign in to the system by guest
    Given I open the  browser "<browser>"
    When I  visit ivme web page
    Then I check if the page is correctly opened
    When I open guest login link
    Then I check if the guest login page is correctly opened
    When I enter the valid name in the text box "Mert Mansuroglu"
    And I proceed to sign in Page
    Then I check If the login is successful
    Then I check if the browser has been closed
    Examples:
      | browser |
      | chrome  |
      | firefox |

  Scenario Outline: I should be able see the validation error in case of entering invalid data
    Given I open the  browser "<browser>"
    When I  visit ivme web page
    Then I check if the page is correctly opened
    When I open guest login link
    Then I check if the guest login page is correctly opened
    When I enter the valid name in the text box "<name>"
    And I proceed to sign in Page
    Then I check if the validation error appeared
    Then I check if the browser has been closed
    Examples:
      | browser |  | name |
      | chrome  |  | mert |
      | firefox |  |      |
      | chrome  |  | 100  |


  Scenario Outline: I should be able arrange english localization in the sign in page
    Given I open the  browser "<browser>"
    When I  visit ivme web page
    Then I check if the page is correctly opened
    When I open guest login link
    Then I check if the guest login page is correctly opened
    When I change the language as English
    Then I should be able to be redirected to main login page
    Then I check the login language as english
    Then I check if the browser has been closed
    Examples:
      | browser |
      | chrome  |
      | firefox |

  Scenario Outline: I should be able arrange turkish localization in the sign in page
    Given I open the  browser "<browser>"
    When I  visit ivme web page
    Then I check if the page is correctly opened
    When I open guest login link
    Then I check if the guest login page is correctly opened
    When I change the language as turkish
    Then I check the login language as turkish
    Then I check if the browser has been closed
    Examples:
      | browser |
      | chrome  |
      | firefox |

  Scenario Outline: I should be able be navigated to meeting page from login page
    Given I open the  browser "<browser>"
    When I  visit ivme web page
    Then I check if the page is correctly opened
    When I open guest login link
    Then I check if the guest login page is correctly opened
    When I enter the valid name in the text box "Mert Mansuroglu"
    And I proceed to sign in Page
    Then I check If the login is successful
    When I click continue on browser to attend to meeting
    Then I check if I have navigated to correct page
    Examples:
      | browser |
      | chrome  |
      | firefox |