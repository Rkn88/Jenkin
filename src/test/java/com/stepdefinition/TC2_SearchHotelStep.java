package com.stepdefinition;

import org.junit.Assert;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Administrator
 * @Date 07-12-2022
 * @see used to perform search hotel feature
 *
 */
public class TC2_SearchHotelStep extends BaseClass{
	
	PageObjectManager pom = new PageObjectManager();
	
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
	 * @see used to perform search hotel fuction with valid datas
	 */
	
	@When("User should search hotel {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldSearchHotelAnd(String location, String hotel, String roomType, String noOfRooms, String checkInDate, String checkOutDate, String adultsPerRoom, String childrenPerRoom) {
	    pom.getSearchHotel().searchHotels(location, hotel, roomType, noOfRooms, checkInDate, checkOutDate, adultsPerRoom, childrenPerRoom);
	}
	
	/**
	 * 
	 * @param expSelectMsg
	 * @see used to check search hotel success message
	 */
	@Then("User should verify after search hotel success message {string}")
	public void userShouldVerifyAfterSearchHotelSuccessMessage(String expSelectMsg) {
		
	    WebElement txtSelectHotel = pom.getSelectHotel().getTxtSelectHotel();
	    String elementGetText = elementGetText(txtSelectHotel);
	    Assert.assertEquals("VerifySelectSuccess",expSelectMsg,elementGetText);
                           	
	}
	
	/**
	 * 
	 * @param location
	 * @param hotel
	 * @param roomType
	 * @param noOfRooms
	 * @see used to perform select hotel with mandatory fields 
	 */

	@When("User should enter only mandatory fields {string},{string},{string} and {string}")
	public void userShouldEnterOnlyMandatoryFieldsAnd(String location, String hotel, String roomType, String noOfRooms) {
		pom.getSearchHotel().searchHotels(location, hotel, roomType, noOfRooms);
	   
	}
	/**
	 * 
	 * @param checkInDateErrorMsg
	 * @param checkOutDateErrorMsg
	 * @see used to check invalid date error message
	 */
	
	@Then("User should verify with invalid date error message {string},{string}")
	public void userShouldVerifyWithInvalidDateErrorMessage(String checkInDateErrorMsg, String checkOutDateErrorMsg) {
		 WebElement checkInErrorMsg = pom.getSearchHotel().getCheckInDateErrorMsg();
		     String elementGetText = elementGetText(checkInErrorMsg);
		     boolean contains = elementGetText.contains(checkInDateErrorMsg);
		     Assert.assertTrue("Verify Check-In Date shall be before than Check-Out Date", contains);
		     
		     WebElement checkOutErrorMsg = pom.getSearchHotel().getCheckOutDateErrorMsg();
		     String elementGetTextOut = elementGetText(checkOutErrorMsg);
		     boolean containsOut = elementGetTextOut.contains(checkOutDateErrorMsg);
		     Assert.assertTrue("Verify Check-Out Date shall be after than Check-In Date", containsOut);
	}
	
	/**
	 * @see used to perform search hotel function with out entering any fields 
	 */
	
	@When("User should search hotel without entering any fields")
	public void userShouldSearchHotelWithoutEnteringAnyFields() {
		pom.getSearchHotel().searchHotels();
	   
	}
	/**
	 * 
	 * @param pleaseSelectLocErrorMsg
	 * @see used to check locatio error message
	 */
	@Then("User should verify suggestion message {string}")
	public void userShouldVerifySuggestionMessage(String pleaseSelectLocErrorMsg) {
		
		WebElement selectLocErrorMsg = pom.getSearchHotel().getPleaseSelectLocErrorMsg();
		String getText = elementGetText(selectLocErrorMsg);
		boolean cont = getText.contains(pleaseSelectLocErrorMsg);
		 Assert.assertTrue("Verify please select a location msg", cont);
	   
	}
	
	}






	
	





