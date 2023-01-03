package com.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * 
 * @author Administrator
 * @Date 07-12-2022
 * @see Contains pojo class used to access adactin select hotel page
 *
 */
public class SelectHotel extends BaseClass {
	
	public SelectHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[text()='Select Hotel ']")
	private WebElement txtSelectHotel;
	@FindBy(id="radiobutton_0")
	private WebElement selectButton;
	@FindBy(id="continue")
	private WebElement btnHotel;
	@FindBy(id="radiobutton_span")
	private WebElement txtPleaseSelect;
   
	
	public WebElement getTxtSelectHotel() {
		return txtSelectHotel;
	}
	public WebElement getSelectButton() {
		return selectButton;
	}
	public WebElement getBtnHotel() {
		return btnHotel;
	}
	public WebElement getTxtPleaseSelect() {
		return txtPleaseSelect;
	}
	
	/**
	 * @see used to select hotel
	 */
	public void selectHotel() {
		elementClick(getSelectButton());
    	elementClick(getBtnHotel());
    	
 
	}
	/**
	 * @see used to click continue with out selecting hotel
	 */
	
	public void clickContinue() {
		elementClick(getBtnHotel());		

	}
     

}
