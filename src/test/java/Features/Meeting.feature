Feature:  Ivme meeting test cases for guest login user


  Scenario Outline: I should be able be open device camera and microphone in the meeting page
    Given I open the  browser "<browser>"
    When I  visit ivme web page
    Then I check if the page is correctly opened
    When I open guest login link
    And I enter the valid name in the text box "Mert Mansuroglu"
    And I proceed to sign in Page
    When I click continue on browser to attend to meeting
    Then I check if I have navigated to correct page
    Then I check if I allowed camera and microphone access
    When I open a valid "camera" from the dropdown
    Then I check if "camera" is opened
    When I open a valid "microphone" from the dropdown
    Then I check if "microphone" is opened
    When I click tamam button to close the device settings
    Then I check if the browser has been closed

    Examples:
      | browser |
      | chrome  |
      | firefox |


  Scenario Outline: I should be able to add camera and microphone in the meeting(fake)
    Given I open the  browser "<browser>"
    When I  visit ivme web page
    Then I check if the page is correctly opened
    When I open guest login link
    And I enter the valid name in the text box "Mert Mansuroglu"
    And I proceed to sign in Page
    When I click continue on browser to attend to meeting
    Then I check if I have navigated to correct page
    Then I check if I allowed camera and microphone access
    When I open a fake "camera" from the dropdown
    Then I check if fake "camera" is opened
    When I open a fake "microphone" from the dropdown
    Then I check if fake "microphone" is opened
    When I click tamam button to close the device settings
    Then I check if the browser has been closed

    Examples:
      | browser |
      |ChromeFakeMicAndCam|

