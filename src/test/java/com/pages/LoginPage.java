package com.pages;

import java.awt.AWTException;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * 
 * @author Administrator
 * @Date 07-12-2022
 * @see Contains pojo class that used to access adactin login page
 *
 */
public class LoginPage extends BaseClass {

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement txtUserName;
	@FindBy(id = "password")
	private WebElement txtPassword;
	@FindBy(id = "login")
	private WebElement btnLogin;
	@FindBy(xpath = "//b[contains(text(),'Invalid Login details')]")
	private WebElement txtErrorLogin;

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getTxtErrorLogin() {
		return txtErrorLogin;
	}
	
	/**
	 * 
	 * @param userName
	 * @param passWord
	 * @see used to perform login function
	 */

	public void login(String userName, String passWord) {

		elementSendKeys(getTxtUserName(), userName);
		elementSendKeys(getTxtPassword(), passWord);
		elementClick(getBtnLogin());
	}
	/**
	 * 
	 * @param userName
	 * @param passWord
	 * @see used to perform login function with enter key 
	 * @throws AWTException
	 */

	public void loginWithEnterKey(String userName, String passWord) throws AWTException {
		elementSendKeys(getTxtUserName(), userName);
		elementSendKeys(getTxtPassword(), passWord);
		enterKey();

	}

}
