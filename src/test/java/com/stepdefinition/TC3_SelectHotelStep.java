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
 * @see used to perform select hotel feature
 *
 */
public class TC3_SelectHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();
	
	/**
	 * @see used to select hotel name
	 */

	@When("User should select the hotel name")
	public void userShouldSelectTheHotelName() {
		pom.getSelectHotel().selectHotel();
	   
	}
	/**
	 * 
	 * @param txtBookHotel
	 * @see used to check select hotel success message
	 */
	@Then("User should verify after select hotel success message {string}")
	public void userShouldVerifyAfterSelectHotelSuccessMessage(String txtBookHotel) {
	       WebElement bookHotel = pom.getBookHotel().getTxtBookHotel();     
	       String bookText = elementGetText(bookHotel);
	       Assert.assertEquals("verify book hotel success message",txtBookHotel,bookText);
	        
	}
	
	/**
	 * @see used to click continue button
	 */
		
	@When("User should click on continue")
	public void userShouldClickOnContinue() {
		pom.getSelectHotel().clickContinue();
		   
	}
	/**
	 * 
	 * @param txtPleaseSelectHotel
	 * @see used to check please select hotel error message
	 */
		
	@Then("User should verify the error message {string}")
	public void userShouldVerifyTheErrorMessage(String txtPleaseSelectHotel) {
		WebElement pleaseSelect = pom.getSelectHotel().getTxtPleaseSelect();
		String selectText = elementGetText(pleaseSelect);
		Assert.assertEquals("verify please select hotel error message",txtPleaseSelectHotel,selectText);
		
		   
	}
















	










}
