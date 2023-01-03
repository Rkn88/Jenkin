package com.stepdefinition;

import java.io.FileNotFoundException;

import java.io.IOException;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
/**
 * 
 * @author Administrator
 * @Date 07-12-2022
 * @see These are blocks of code used to run before and after scenario 
 *
 */
public class HooksClass extends BaseClass {
	
	/**
	 * @see used to ger driver set up 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Before
	
	public void beforeScenario() throws FileNotFoundException, IOException {
		
		getDriver(getPropertyFileValue("browser"));
		enterAppUrl(getPropertyFileValue("url"));
		maximizeWindow();

	}
	
	/**
	 * 
	 * @param scenario
	 * @see used to captute screeshots for passed and failed cases
	 */
	@After
	
	
	public void afterScenario(Scenario scenario) {
		
		scenario.attach(screenShot(),"images/png","EveryScenario");
		
//		boolean b = scenario.isFailed();
//		if (b) {
//			
//			scenario.attach(screenShot(),"images/png","EveryScenario");
//			
//		}
		quitWindow();
		 

	}

}
