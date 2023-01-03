@Cancel
Feature: Verifying adactin hotel cancel booking page details

  Background: 
    Given User is on the adactin page

  Scenario Outline: Verifying adactin hotel cancel booking with generated order id
    When User should perform login "<userName>","<passWord>"
    Then User should verify after login success message "Hello Karthikn2022!"
    When User should search hotel "<location>","<hotel>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"
    When User should select the hotel name
    Then User should verify after select hotel success message "Book A Hotel"
    When User should book a hotel "<firstName>","<lastName>" and "<billingAddress>"
      | creditCardNo     | creditCardType   | expiryMonth | expiryYear | cvv |
      | 2013201220112010 | VISA             | November    |       2022 | 822 |
      | 2013201220112015 | Master Card      | December    |       2022 | 822 |
      | 2013201220112016 | American Express | November    |       2022 | 802 |
    Then User should verify after booking success message "Booking Confirmation" and save the generated order id
    When User should cancel the generated order id
    Then User verify after cancel order id success message "The booking has been cancelled."

    Examples: 
      | userName     | passWord     | location | hotel          | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | firstName | lastName | billingAddress |
      | Karthikn2022 | Deepakn@2020 | Sydney   | Hotel Sunshine | Standard | 1 - One   | 25/11/2022  | 26/11/2022   | 2 - Two       | 3 - Three       | Karthi    | kn       | Tanjore        |

  Scenario Outline: Verifying adactin hotel cancel booking with existing order id
    When User should perform login "<userName>","<passWord>"
    Then User should verify after login success message "Hello Karthikn2022!"
    When User should cancel the existing "<orderId>"
    Then User verify after cancel order id success message "The booking has been cancelled."

    Examples: 
      | userName     | passWord     | orderId     |
      | Karthikn2022 | Deepakn@2020 | WQKM99V375  |
