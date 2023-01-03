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
 * @see used to perform cancel booking feature
 *
 */
public class TC5_CancelBookingStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();
    /**
     * @see used to cancel generated order id	
     */

	@When("User should cancel the generated order id")
	public void userShouldCancelTheGeneratedOrderId() {
		pom.getCancelBooking().cancelGenOrderId();	  
	}
	/**
	 * 
	 * @param orderId
	 * @see used to cancel existing order id
	 * 
	 */
	
	@When("User should cancel the existing {string}")
	public void userShouldCancelTheExisting(String orderId) {
		pom.getCancelBooking().cancelExistingOrderId(orderId);
		System.out.println(orderId);
		
	}
	
	/**
	 * 
	 * @param txtCancelMsg
	 * @see used to check cancel order id success message
	 */
	@Then("User verify after cancel order id success message {string}")
	public void userVerifyAfterCancelOrderIdSuccessMessage(String txtCancelMsg) {
		WebElement cancelText = pom.getCancelBooking().getCancelText();
		String textCancel = elementGetText(cancelText);
		Assert.assertEquals("Verify first name error msg",txtCancelMsg,textCancel);
	    
	}





}
