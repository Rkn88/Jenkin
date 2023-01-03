package com.stepdefinition;


import org.junit.Assert;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
/**
 * 
 * @author Administrator
 * @Date 07-12-2022
 * @see used to check common success message in all feature files
 *
 */



public class CommonStep extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager();
	
	@Then("User should verify after login success message {string}")
	public void userShouldVerifyAfterLoginSuccessMessage(String expLoginMsg){
		WebElement txtWelcomeMsg = pom.getSearchHotel().getTxtWelcomeMsg();
		String actLoginSuccessmsg = elementGetAttribute(txtWelcomeMsg);
		Assert.assertEquals("verify after login success message",expLoginMsg,actLoginSuccessmsg);
	
		
		
	   
	}

}
