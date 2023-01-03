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
 * @see used to perform book hotel feature
 */
public class TC4_BookHotelStep extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager();
	
	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param billingAddress
	 * @param dataTable
	 * @see used to perform book hotel function with valid datas
 	 * @throws InterruptedException
	 */
	
	@When("User should book a hotel {string},{string} and {string}")
	public void userShouldBookAHotelAnd(String firstName, String lastName, String billingAddress, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		pom.getBookHotel().bookHotel(firstName, lastName, billingAddress, dataTable);
	
	  
	}
	
	/**
	 * 
	 * @param txtBookconfirm
	 * @see used to check booking success message and save the generated order id
	 * @throws InterruptedException
	 */
	
	@Then("User should verify after booking success message {string} and save the generated order id")
	public void userShouldVerifyAfterBookingSuccessMessageAndSaveTheGeneratedOrderId(String txtBookconfirm) throws InterruptedException {
		     WebElement confirm = pom.getBookingConfirm().getBookConfirm();
		     String textConfirm = elementGetText(confirm);
		     Assert.assertEquals("Verify booking confirm success",txtBookconfirm,textConfirm);
		     String id = pom.getBookingConfirm().getOrderId();
		     System.out.println(id);
		     Thread.sleep(5000);
	}
	
	/**
	 * @see used to click book now button without entering any fields
	 * @throws InterruptedException
	 */

	@When("User Should click book now")
	public void userShouldClickBookNow() throws InterruptedException {
		pom.getBookHotel().bookhotel();
	    
	}
	
	/**
	 * 
	 * @param txtFirstNameMsg
	 * @param txtLastNameMsg
	 * @param txtAddressMsg
	 * @param txtCreditNoMsg
	 * @param txtCreditTypeMsg
	 * @param txtExpiryMsg
	 * @param txtCvvMsg
	 * @see used to check the error messages displayed for not entering fields  
	 */
	@Then("User should verify the error messages {string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyTheErrorMessagesAnd(String txtFirstNameMsg, String txtLastNameMsg, String txtAddressMsg, String txtCreditNoMsg, String txtCreditTypeMsg, String txtExpiryMsg, String txtCvvMsg) {
	  WebElement firstNameMsg = pom.getBookHotel().getTxtFirstNameMsg();
	  String textFName = elementGetText(firstNameMsg);
	  Assert.assertEquals("Verify first name error msg",txtFirstNameMsg,textFName);
	  WebElement lastNameMsg = pom.getBookHotel().getTxtLastNameMsg();
	  String textLName = elementGetText(lastNameMsg);
	  Assert.assertEquals("Verify last name error msg",txtLastNameMsg,textLName);
	  WebElement addressMsg = pom.getBookHotel().getTxtAddressMsg();
	  String textAdd = elementGetText(addressMsg);
	  Assert.assertEquals("Verify address error msg",txtAddressMsg,textAdd);
	  WebElement creditNoMsg = pom.getBookHotel().getTxtCreditNoMsg();
	  String textCreditNo = elementGetText(creditNoMsg);
	  Assert.assertEquals("Verify credit no error msg",txtCreditNoMsg,textCreditNo);
	  WebElement creditTypeMsg = pom.getBookHotel().getTxtCreditTypeMsg();
	  String textCreditType = elementGetText(creditTypeMsg);
	  Assert.assertEquals("Verify credit type error msg",txtCreditTypeMsg,textCreditType);
	  WebElement expiryMsg = pom.getBookHotel().getTxtExpiryMsg();
	  String textExpMsg = elementGetText(expiryMsg);
	  Assert.assertEquals("Verify credit expiry error msg",txtExpiryMsg,textExpMsg);
	  WebElement cvvMsg = pom.getBookHotel().getTxtCvvMsg();
	  String textCvv = elementGetText(cvvMsg);
	  Assert.assertEquals("Verify credit cvv error msg",txtCvvMsg,textCvv);
	  
	  
	  
	  
	  
	}





	
	



	









}
