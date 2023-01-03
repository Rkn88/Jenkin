package com.pages;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Administrator
 * @Date 07-12-2022
 * @see Contains pojo class that used to access adactin book hotel page
 *
 */

public class BookHotel extends BaseClass {

	public BookHotel() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[text()='Book A Hotel ']")
	private WebElement txtBookHotel;
	@FindBy(id = "first_name")
	private WebElement txtFirstName;
	@FindBy(name = "last_name")
	private WebElement txtlastName;
	@FindBy(name = "address")
	private WebElement txtAddress;
	@FindBy(name = "cc_num")
	private WebElement txtCardNo;
	@FindBy(name = "cc_type")
	private WebElement cardType;
	@FindBy(name = "cc_exp_month")
	private WebElement expMonth;
	@FindBy(name = "cc_exp_year")
	private WebElement expYear;
	@FindBy(name = "cc_cvv")
	private WebElement cvvNo;
	@FindBy(xpath = "//input[@type='button'][1]")
	private WebElement btnBook;
	@FindBy(xpath = "//label[contains(text(),'First Name')]")
	private WebElement txtFirstNameMsg;
	@FindBy(xpath = "//label[contains(text(),'Last Name')]")
	private WebElement txtLastNameMsg;
	@FindBy(xpath = "//label[contains(text(),'Address')]")
	private WebElement txtAddressMsg;
	@FindBy(xpath = "//label[contains(text(),'Credit Card Number')]")
	private WebElement txtCreditNoMsg;
	@FindBy(xpath = "//label[contains(text(),'Credit Card Type')]")
	private WebElement txtCreditTypeMsg;
	@FindBy(xpath = "//label[contains(text(),'Expiry Month')]")
	private WebElement txtExpiryMsg;
	@FindBy(xpath = "//label[contains(text(),'CVV Number')]")
	private WebElement txtCvvMsg;

	public WebElement getTxtBookHotel() {
		return txtBookHotel;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtlastName() {
		return txtlastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCardNo() {
		return txtCardNo;
	}

	public WebElement getCardType() {
		return cardType;
	}

	public WebElement getExpMonth() {
		return expMonth;
	}

	public WebElement getExpYear() {
		return expYear;
	}

	public WebElement getCvvNo() {
		return cvvNo;
	}

	public WebElement getBtnBook() {
		return btnBook;
	}

	public WebElement getTxtFirstNameMsg() {
		return txtFirstNameMsg;
	}

	public WebElement getTxtLastNameMsg() {
		return txtLastNameMsg;
	}

	public WebElement getTxtAddressMsg() {
		return txtAddressMsg;
	}

	public WebElement getTxtCreditNoMsg() {
		return txtCreditNoMsg;
	}

	public WebElement getTxtCreditTypeMsg() {
		return txtCreditTypeMsg;
	}

	public WebElement getTxtExpiryMsg() {
		return txtExpiryMsg;
	}

	public WebElement getTxtCvvMsg() {
		return txtCvvMsg;
	}
	
	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param billingAddress
	 * @param dataTable
	 * @see used to access adactin book hotel page with valid datas 
	 * @throws InterruptedException
	 */

	public void bookHotel(String firstName, String lastName, String billingAddress,
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		elementSendKeys(getTxtFirstName(), firstName);
		elementSendKeys(getTxtlastName(), lastName);
		elementSendKeys(getTxtAddress(), billingAddress);

		List<Map<String, String>> asMaps = dataTable.asMaps();
		Map<String, String> map = asMaps.get(2);
		String txtCardNo = map.get("creditCardNo");
		elementSendKeys(getTxtCardNo(), txtCardNo);
		String cardType = map.get("creditCardType");
		elementSendKeys(getCardType(), cardType);
		String expMonth = map.get("expiryMonth");
		elementSendKeys(getExpMonth(), expMonth);
		String expYear = map.get("expiryYear");
		elementSendKeys(getExpYear(), expYear);
		String cvvNo = map.get("cvv");
		elementSendKeys(getCvvNo(), cvvNo);
		elementClick(getBtnBook());
		Thread.sleep(10000);
	}
	
	/**
	 * @see used to click book now button in book hotel page 
	 * @throws InterruptedException
	 */

	public void bookhotel() throws InterruptedException {
		elementClick(getBtnBook());
		Thread.sleep(10000);
	}

}
