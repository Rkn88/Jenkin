@Select
Feature: Verifying adactin hotel select hotel page details

  Background: 
    Given User is on the adactin page

  Scenario Outline: Verifying adactin hotel select hotel page details by selecting hotel name
    When User should perform login "<userName>","<passWord>"
    Then User should verify after login success message "Hello Karthikn2022!"
    When User should search hotel "<location>","<hotel>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"
    When User should select the hotel name
    Then User should verify after select hotel success message "Book A Hotel"

    Examples: 
      | userName     | passWord     | location | hotel          | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Karthikn2022 | Deepakn@2020 | Sydney   | Hotel Sunshine | Standard | 1 - One   | 25/11/2022  | 26/11/2022   | 2 - Two       | 3 - Three       |

  Scenario Outline: Verifying adactin hotel select hotel page with out selecting hotel
    When User should perform login "<userName>","<passWord>"
    Then User should verify after login success message "Hello Karthikn2022!"
    When User should search hotel "<location>","<hotel>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"
    When User should click on continue
    Then User should verify the error message "Please Select a Hotel"

    Examples: 
      | userName     | passWord     | location | hotel          | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Karthikn2022 | Deepakn@2020 | Sydney   | Hotel Sunshine | Standard | 1 - One   | 25/11/2022  | 26/11/2022   | 2 - Two       | 3 - Three       |
