package com.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Administrator
 * @Date 07-12-2022
 * @see Contains pojo class that used to access adactin cancel booking page  
 *
 */

public class CancelBooking extends BaseClass {
	
	public CancelBooking() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//label[contains(text(),'The booking has been')]")
	private WebElement cancelText;
	@FindBy(xpath="//a[contains(text(),'Booked Itinerary')]")
    private WebElement itineraryText;
	@FindBy(id="order_id_text")
	private WebElement txtSearch;
	@FindBy(id="search_hotel_id")
	private WebElement txthotel;
	@FindBy(xpath="(//input[@type='button'])[1]")
	private WebElement linkCancelBook;
	
	
	
	
	public WebElement getCancelText() {
		return cancelText;
	}
	public WebElement getItineraryText() {
		return itineraryText;
	}
	public WebElement getTxtSearch() {
		return txtSearch;
	}
	public WebElement getTxthotel() {
		return txthotel;
	}
	public WebElement getLinkCancelBook() {
		return linkCancelBook;
	}
	
	 /**
	  * @see used to cancel generated order id
	  */
	public void cancelGenOrderId() {
	      BookingConfirm booking = new BookingConfirm();
	      String orderId = booking.getOrderId();

			elementClick(getItineraryText());
			elementSendKeys(getTxtSearch(),orderId);
			elementClick(getTxthotel());
			elementClick(getLinkCancelBook());
	        giveOkToAlert();

	}
	/**
	 * 
	 * @param orderId
	 * @see used to cancel existing order id
	 */
	 public void cancelExistingOrderId(String orderId) {
			
			elementClick(getItineraryText());
			elementSendKeys(getTxtSearch(),orderId);
			elementClick(getTxthotel());
			elementClick(getLinkCancelBook());
	        giveOkToAlert();
	        
	          
		}
		

}
