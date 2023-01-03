@Search
Feature: Verifying adactin hotel search hotel page details

Background: 
    Given User is on the adactin page

  Scenario Outline: Verifying adactin search hotel page with valid credentials
  
    When User should perform login "<userName>","<passWord>"
    Then User should verify after login success message "Hello Karthikn2022!"
    When User should search hotel "<location>","<hotel>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"

    Examples: 
      | userName     | passWord     | location | hotel          | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Karthikn2022 | Deepakn@2020 | Sydney   | Hotel Sunshine | Standard | 1 - One   | 25/11/2022  | 26/11/2022   | 2 - Two       | 3 - Three       |

  Scenario Outline: Verifying adactin search hotel page by entering only mandatory fields
    
    When User should perform login "<userName>","<passWord>"
    Then User should verify after login success message "Hello Karthikn2022!"
    When User should enter only mandatory fields "<location>","<hotel>","<roomType>" and "<noOfRooms>"
    Then User should verify after search hotel success message "Select Hotel"

    Examples: 
      | userName     | passWord     | location | hotel          | roomType | noOfRooms |
      | Karthikn2022 | Deepakn@2020 | Sydney   | Hotel Sunshine | Standard | 1 - One   |

  Scenario Outline: Verifying adactin search hotel page by checking with invalid date details
    
    When User should perform login "<userName>","<passWord>"
    Then User should verify after login success message "Hello Karthikn2022!"
    When User should search hotel "<location>","<hotel>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify with invalid date error message "Check-In Date shall be before than Check-Out Date","Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName     | passWord     | location | hotel          | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Karthikn2022 | Deepakn@2020 | Sydney   | Hotel Sunshine | Standard | 1 - One   | 05/12/2023  | 06/12/2022   | 2 - Two       | 3 - Three       |

  Scenario Outline: Verifying adactin search hotel page without entering any fields
    
    When User should perform login "<userName>","<passWord>"
    Then User should verify after login success message "Hello Karthikn2022!"
    When User should search hotel without entering any fields
    Then User should verify suggestion message "Please Select a Location"

    Examples: 
      | userName     | passWord     |
      | Karthikn2022 | Deepakn@2020 |
