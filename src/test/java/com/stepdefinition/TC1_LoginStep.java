package com.stepdefinition;

import java.awt.AWTException;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
/**
 * 
 * @author Administrator
 * @Date 07-12-2022
 * @see used to perform login feature
 *
 */

public class TC1_LoginStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();
	
	/**
	 * @see used to launch adactin page
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	@Given("User is on the adactin page")
	public void userIsOnTheAdactinPage() throws FileNotFoundException, IOException {
		
	}
	/**
	 * 
	 * @param userName
	 * @param passWord
	 * @see used to perform login function
	 */

	@When("User should perform login {string},{string}")
	public void userShouldPerformLogin(String userName, String passWord) {
		pom.getLoginPage().login(userName, passWord);

	}
	/**
	 * 
	 * @param userName
	 * @param passWord
	 * @see used to perform login using enter key
	 * @throws AWTException
	 */

	@When("User should perform login {string},{string} with Enter key")
	public void userShouldPerformLoginWithEnterKey(String userName, String passWord) throws AWTException {
		pom.getLoginPage().loginWithEnterKey(userName, passWord);
	}
	/**
	 * 
	 * @param expLogin
	 * @see used to check invalid login error msg
	 */

	@Then("User should verify after login with invalid credential error message contains {string}")
	public void userShouldVerifyAfterLoginWithInvalidCredentialErrorMessageContains(String expLogin) {

		WebElement txtErrorLogin = pom.getLoginPage().getTxtErrorLogin();
		String elementGetText = elementGetText(txtErrorLogin);
		boolean contains = elementGetText.contains(expLogin);
		Assert.assertTrue("Verify after login with invalid credential error message contains", contains);

	}

}
