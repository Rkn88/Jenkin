@Login

Feature: Verifying adactin hotel login details

Background: 
    Given User is on the adactin page

  Scenario Outline: Verifying adactin  hotel login with valid credentials
   
    When User should perform login "<userName>","<passWord>"
    Then User should verify after login success message "Hello Karthikn2022!"

    Examples: 
      | userName     | passWord     |
      | Karthikn2022 | Deepakn@2020 |

  Scenario Outline: Verifying adactin  hotel login using Enter
   
    When User should perform login "<userName>","<passWord>" with Enter key
    Then User should verify after login success message "Hello Karthikn2022!"

    Examples: 
      | userName     | passWord     |
      | Karthikn2022 | Deepakn@2020 |

  Scenario Outline: Verifying adactin  hotel login with invalid credentials
  
    When User should perform login "<userName>","<passWord>"
    Then User should verify after login with invalid credential error message contains "Invalid Login details or Your Password might have expired"

    Examples: 
      | userName        | passWord     |
      | Karthikeyan2022 | Deepakn@1989 |
