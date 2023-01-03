package com.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Administrator
 * @Date 07-12-2022
 * @see Contains pojo class that used to access adactin booking confirm page
 *
 */

public class BookingConfirm extends BaseClass{
	
	public BookingConfirm() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	private WebElement bookConfirm;
	@FindBy(id="order_no")
	private WebElement ordId;
	
	
	
	public WebElement getBookConfirm() {
		return bookConfirm;
	}

	public WebElement getOrdId() {
		return ordId;
	}
    
	/**
	 * 
	 * @return String
	 * @see used to get order id 
	 */
	 public String getOrderId() {
		 String value2 = elementGetAttribute(getOrdId(),"value");
		  return value2;

	}
}
