package com.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(tags = (" "), dryRun = false, publish = true, stepNotifications = true, snippets = SnippetType.CAMELCASE, plugin = {
		"usage", "json:target\\Output.json" }, features = "src\\test\\resources\\Features", glue = "com.stepdefinition")

/**
 * 
 * @author Administrator
 * @Date 07-12-2022
 * @see Used to run all feature files
 *
 */
public class TestRunnerClass extends BaseClass {
	
	/**
	 * @see used to generate jvm report
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
		Reporting.generateJVMReport(getProjectPath() + getPropertyFileValue("jsonPath"));

	}

}