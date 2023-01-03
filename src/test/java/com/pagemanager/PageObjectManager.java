package com.pagemanager;

import com.pages.BookHotel;
import com.pages.BookingConfirm;
import com.pages.CancelBooking;
import com.pages.LoginPage;
import com.pages.SearchHotel;
import com.pages.SelectHotel;

/**
 * 
 * @author Administrator
 * @Date 07-12-2022
 * @see Contains pojo class that used to access from any where in the project
 *
 */

public class PageObjectManager {

	private LoginPage loginPage;
	private SearchHotel searchHotel;
	private SelectHotel selectHotel;
	private BookHotel bookHotel;
	private BookingConfirm bookingConfirm;
	private CancelBooking cancelBooking;

	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
	}

	public SearchHotel getSearchHotel() {
		return (searchHotel == null) ? searchHotel = new SearchHotel() : searchHotel;
	}

	public SelectHotel getSelectHotel() {
		return (selectHotel == null) ? selectHotel = new SelectHotel() : selectHotel;
	}

	public BookHotel getBookHotel() {
		return (bookHotel == null) ? bookHotel = new BookHotel() : bookHotel;
	}

	public BookingConfirm getBookingConfirm() {
		return (bookingConfirm == null) ? bookingConfirm = new BookingConfirm() : bookingConfirm;
	}

	public CancelBooking getCancelBooking() {
		return (cancelBooking == null) ? cancelBooking = new CancelBooking() : cancelBooking;
	}

}
