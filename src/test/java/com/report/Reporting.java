package com.report;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * 
 * @author Administrator
 * @Date 07-12-2022
 * @see used to generate report 
 *
 */
public class Reporting extends BaseClass {

public static void generateJVMReport(String jsonFile) throws FileNotFoundException, IOException {
		
		File file = new File(getProjectPath()+getPropertyFileValue("jvmPath"));
	    Configuration configuration = new Configuration(file, "Adactin Hotel Automation");
	    configuration.addClassifications("BrowserName","Chrome");
	    configuration.addClassifications("BrowserVersion","107");
	    configuration.addClassifications("OS","WIN10");
	    configuration.addClassifications("sprint","34");
	    
	    List<String>jsonFiles = new ArrayList<String>();
	    jsonFiles.add(jsonFile);
	    ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
	    builder.generateReports();
		

	}

}
