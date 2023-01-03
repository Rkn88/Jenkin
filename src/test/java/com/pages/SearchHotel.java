package com.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * 
 * @author Administrator
 * @Date 07-12-2022
 * @see Contains pojo class that used to access adactin search hotel page
 *
 */
public class SearchHotel extends BaseClass {
	
	public SearchHotel() {
		PageFactory.initElements(driver, this);
	}
   @FindBy(id="location")
   private WebElement location;
   @FindBy(id="username_show")
   private WebElement txtWelcomeMsg;
   @FindBy(id="hotels")
   private WebElement adnHotels;
   @FindBy(id="room_type")
   private WebElement adnRoomType;
   @FindBy(id="room_nos")
   private WebElement adnRoomNo;
   @FindBy(id="datepick_in")
   private WebElement txtCheckInDate;
   @FindBy(id="datepick_out")
   private WebElement txtCheckOutDate;
   @FindBy(id="adult_room")
   private WebElement adnAdultRoom;
   @FindBy(id="child_room")
   private WebElement adnChildRoom;
   @FindBy(id="Submit")
   private WebElement btnSearch;
   @FindBy(id="checkin_span")
   private WebElement checkInDateErrorMsg;
   @FindBy(id="checkout_span")
   private WebElement checkOutDateErrorMsg;
   @FindBy(id="location_span")
   private WebElement pleaseSelectLocErrorMsg;
   
public WebElement getLocation() {
	return location;
}
public WebElement getTxtWelcomeMsg() {
	return txtWelcomeMsg;
}

public WebElement getAdnHotels() {
	return adnHotels;
}
public WebElement getAdnRoomType() {
	return adnRoomType;
}
public WebElement getAdnRoomNo() {
	return adnRoomNo;
}
public WebElement getTxtCheckInDate() {
	return txtCheckInDate;
}
public WebElement getTxtCheckOutDate() {
	return txtCheckOutDate;
}
public WebElement getAdnAdultRoom() {
	return adnAdultRoom;
}
public WebElement getAdnChildRoom() {
	return adnChildRoom;
}
public WebElement getBtnSearch() {
	return btnSearch;
}
public WebElement getCheckInDateErrorMsg() {
	return checkInDateErrorMsg;
}
public WebElement getCheckOutDateErrorMsg() {
	return checkOutDateErrorMsg;
}
public WebElement getPleaseSelectLocErrorMsg() {
	return pleaseSelectLocErrorMsg;
}

/**
 * 
 * @param location
 * @param hotel
 * @param roomType
 * @param noOfRooms
 * @param checkInDate
 * @param checkOutDate
 * @param adultsPerRoom
 * @param childrenPerRoom
 * @see used to access search hotel page with valid data
 */
public void searchHotels(String location,String hotel,String roomType,String noOfRooms,String checkInDate,String checkOutDate,String adultsPerRoom,String childrenPerRoom) {
	
	selectOptionByAttribute(getLocation(), location);
	selectOptionByAttribute(getAdnHotels(), hotel);
	selectOptionByAttribute(getAdnRoomType(), roomType);
	selectOptionByText(getAdnRoomNo(), noOfRooms);
	clearTextBox(getTxtCheckInDate());
	elementSendKeys(getTxtCheckInDate(), checkInDate);
	clearTextBox(getTxtCheckOutDate());
	elementSendKeys(getTxtCheckOutDate(), checkOutDate);
	selectOptionByText(getAdnAdultRoom(), adultsPerRoom);
	selectOptionByText(getAdnChildRoom(), childrenPerRoom);
	elementClick(getBtnSearch());
}

/**
 * 
 * @param location
 * @param hotel
 * @param roomType
 * @param noOfRooms
 * @see used to access search hotel page with mandatory fields 
 */
public void searchHotels(String location,String hotel,String roomType,String noOfRooms) {
	
	selectOptionByAttribute(getLocation(), location);
	selectOptionByAttribute(getAdnHotels(), hotel);
	selectOptionByAttribute(getAdnRoomType(), roomType);
	selectOptionByText(getAdnRoomNo(), noOfRooms);
	elementClick(getBtnSearch());	
		
} 

/**
 * @see used to access search hotel page  by clicking continue button
 */
public void searchHotels() {
	elementClick(getBtnSearch());	
	

}



}
