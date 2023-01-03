package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Administrator
 * @Date 07-12-2022
 * @see Maintains reusable methods
 *
 */
public class BaseClass {
	

	public static WebDriver driver;
	/**
	 * 
	 * @param browser
	 * @see used for driver set up
	 */

	public static void getDriver(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			break;

		}

	}
	
	/**
	 * 
	 * @return byte[]
	 * @see used to take screeshots
	 */
	public byte[] screenShot() {
		TakesScreenshot shot = (TakesScreenshot)driver;
		byte[] bs = shot.getScreenshotAs(OutputType.BYTES);
		return bs;

	}
	
	/**
	 * 
	 * @return String
	 * @see used to get project path
	 */

	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;

	}
	
	/**
	 * 
	 * @param key
	 * @return String
	 * @see used to get property file path
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	

	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "\\Config\\Config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;

	}
	
   /**
    * 
    * @return Keys
    * @see used to press enter key
    */

	public Keys enter() {
		Keys ent = Keys.ENTER;
		return ent;
	}
	
	/**
	 * 
	 * @param url
	 * @see used to get url
	 */

	public static void enterAppUrl(String url) {
		driver.get(url);
	}
	
	/**
	 * @see used to maximize the window
	 */

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	/**
	 * 
	 * @param element
	 * @param data
	 * @see used to insert values
	 * 
	 */

	public void elementSendKeys(WebElement element, String data) {
		element.sendKeys(data);
	}
	
	/**
	 * 
	 * @param element
	 * @param data
	 * @see used to insert values by javascript executor
	 */

	public void elementSendKeysjs(WebElement element, String data) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}
	
	/**
	 * 
	 * @param element
	 * @see used to click partcular button
	 */

	public void elementClick(WebElement element) {
		element.click();
	}
	
	/**
	 * 
	 * @return String
	 * @see used to get title of the application
	 */

	public String getApplnTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	/**
	 * 
	 * @param attributevalue
	 * @return WebElement
	 * @see used to find the element in dom by id
	 */

	public WebElement findElementById(String attributevalue) {
		WebElement element = driver.findElement(By.id(attributevalue));
		return element;
	}
	
	/**
	 * 
	 * @param attributevalue
	 * @return WebElementzzzz
	 * @see used to find the element by name 
	 */

	public WebElement findElementByName(String attributevalue) {
		WebElement element = driver.findElement(By.name(attributevalue));
		return element;
	}
	
	/**
	 * 
	 * @param attributevalue
	 * @return WebElement
	 * @see used to find the element by classname
	 */

	public WebElement findElementByClassName(String attributevalue) {
		WebElement element = driver.findElement(By.className(attributevalue));
		return element;
	}
   
	/**
	 * 
	 * @param expression
	 * @return WebElement
	 * @see used to find the element by xpath 
	 */
	public WebElement findElementByXpath(String expression) {
		WebElement element = driver.findElement(By.xpath(expression));
		return element;
	}
   
	/**
	 * 
	 * @return String
	 * @see used get respective url
	 */
	public String getApplnUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}
	/**
	 * 
	 * @param element
	 * @return String
	 * @see used to get text in webpage
	 */

	public String elementGetText(WebElement element) {
		String text = element.getText();
		return text;
	}
	/**
	 * @see used to close current windoe
	 */

	public void closeWindow() {
		driver.close();
	}
	
	/**
	 * @see used to close all windows
	 */

	public static void quitWindow() {
		driver.quit();
	}
	/**
	 * 
	 * @param element
	 * @return String
	 * @see used to get attribute value
	 */

	public String elementGetAttribute(WebElement element) {
		String attribute = element.getAttribute("Value");
		return attribute;
	}
	/**
	 * 
	 * @param element
	 * @param attributevalue
	 * @return String
	 * @see used to get attribute value
	 */

	public String elementGetAttribute(WebElement element, String attributevalue) {
		String attribute = element.getAttribute("Value");
		return attribute;
	}
	/**
	 * 
	 * @param element
	 * @param text
	 * @see used to select option by text in dropdown
	 */

	public void selectOptionByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
    
	/**
	 * 
	 * @param element
	 * @param value
	 * @see used to select option by value in dropdown
	 */
	public void selectOptionByAttribute(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	/**
	 * 
	 * @param element
	 * @param index
	 * @see used to select option by index in dropdown
	 */

	public void selectOptionByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	/**
	 * 
	 * @param element
	 * @param text
	 * @see used to deselect option by text in dropdown
	 */

	public void deselectOptionByText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}
	/**
	 * 
	 * @param element
	 * @param value
	 * @see used to deselect option by value in dropdown
	 */

	public void deselectOptionByAttribute(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}
	
	/**
	 * 
	 * @param element
	 * @param index
	 * @see used to deselect option by index in dropdown
	 */

	public void deselectOptionByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}
	
	/**
	 * 
	 * @param element
	 * @see used to deselect all selected options
	 */

	public void deselectAllx(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}
	
	/**
	 * 
	 * @param url
	 * @see used to navigate to webpage
	 */

	public void navigateTo(String url) {
		driver.navigate().to(url);
	}
	
	/**
	 * @see used to go navigate backward
	 */

	public void navigateBack() {
		driver.navigate().back();
	}
	
	/**
	 * @see used to navigate forward 
	 */

	public void navigateForward() {
		driver.navigate().forward();
	}
	
	/**
	 * @see used to refresh the page
	 */

	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	/**
	 * 
	 * @param id
	 * @return WebDriver
	 * @see used to switch to frame by id in webpage
	 */

	public WebDriver switchToFrameById(String id) {
		WebDriver frame = driver.switchTo().frame(id);
		return frame;
	}
	/**
	 * 
	 * @param name
	 * @return WebDriver
	 * @see used to switch to frame by name in webpage
 	 */

	public WebDriver switchToFrameByName(String name) {
		WebDriver frame = driver.switchTo().frame(name);
		return frame;
	}
	/**
	 * 
	 * @param index
	 * @return WebDriver
	 * @see used to switch to frame by index in webpage
	 * 
	 */

	public WebDriver switchToFrameByIndex(int index) {
		WebDriver frame = driver.switchTo().frame(index);
		return frame;
	}
	/**
	 * 
	 * @param element
	 * @return WebDriver
	 * @see used to switch to frame by web element in webpage
	 */
	

	public WebDriver switchToFrameByWebEle(WebElement element) {
		WebDriver frame = driver.switchTo().frame(element);
		return frame;
	}
	/**
	 * @see used to switch to parent frame
	 */

	public void switchToParFrame() {
		driver.switchTo().parentFrame();
	}
	/**
	 * @see used to switch to webpage
	 */

	public void switchToWebPage() {
		driver.switchTo().defaultContent();
	}
    
	/**
	 * 
	 * @param element
	 * @return boolean
	 * @see used to check multiple options
	 */
	public boolean isMultiple(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}
	/**
	 * 
	 * @param element
	 * @return boolean
	 * @see used to check textbox and button is selected
	 */
	

	public boolean isSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}
	/**
	 * 
	 * @param element
	 * @return boolean
	 * @see used to check textbox and button is displayed
	 */

	public boolean isDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}
	/**
	 * 
	 * @param element
	 * @return boolean
	 * @see used to check and radio button is enabled
	 */

	public boolean isEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}
	/**
	 * 
	 * @return String
	 * @see used to get parent window
	 */

	public String getWindowHandle() {
		String handle = driver.getWindowHandle();
		return handle;
	}
	
	/**
	 * 
	 * @return Set<string>
	 * @see used to get child window
	 */

	public Set<String> getWindowHandles() {
		Set<String> handles = driver.getWindowHandles();
		return handles;
	}
	/**
	 * 
	 * @param id
	 * @return WebDriver
	 * @see used to switch to respective window
	 */

	public WebDriver getWindow(String id) {
		WebDriver window = driver.switchTo().window(id);
		return window;
	}
	/**
	 * 
	 * @param element
	 * @see used to clear textbox
	 */

	public void clearTextBox(WebElement element) {
		element.clear();
	}
	/**
	 * 
	 * @return File
	 * @see used to capture screeshot for web page 
	 */

	public File takeScreenShot() {
		TakesScreenshot sc = (TakesScreenshot) driver;
		File file = sc.getScreenshotAs(OutputType.FILE);
		return file;
	}
	/**
	 * 
	 * @param element
	 * @return file'
	 * @see used to capture screeshot for web element
	 */

	public File takeScShotForEle(WebElement element) {
		TakesScreenshot sc = (TakesScreenshot) element;
		File file = sc.getScreenshotAs(OutputType.FILE);
		return file;
	}
	/**
	 * 
	 * @param element
	 * @see used for mouseover action
	 */

	public void moveToElement(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * 
	 * @param element
	 * @see used for drag and drop action
	 */

	public void dragAndDrop(WebElement element) {
		Actions a = new Actions(driver);
		a.dragAndDrop(element, element).perform();
	}
	/**
	 * 
	 * @param element
	 * @see used for double click
	 */

	public void doubleClick(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	/**
	 * 
	 * @param element
	 * @see used for right click
	 */

	public void rightClick(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * @see used to accept the alert
	 */

	public void giveOkToAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}
	/**
	 * @see used to dismiss the alert
	 */

	public void cancelAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
    /**
     * 
     * @param alert
     * @return Alert
     * @see used to switch to respective alert
     */
	public Alert switchToAlert(Alert alert) {
		Alert alt = driver.switchTo().alert();
		return alt;
	}
	/**
	 * 
	 * @param element
	 * @return List<WebElement>
	 * @see used to get options in dropdown
	 */

	public List<WebElement> getOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		return options;
	}
	/**
	 * 
	 * @param element
	 * @param jpg
	 * @return File
	 * @see used to copy file to a location
	 * @throws IOException
	 * 
	 */

	public File copyFile(WebElement element, String jpg) throws IOException {
		TakesScreenshot sc = (TakesScreenshot) element;
		File file = sc.getScreenshotAs(OutputType.FILE);
		File loc = new File("jpg");
		FileUtils.copyFile(file, loc);
		return file;
	}
	/**
	 * 
	 * @param element
	 * @param tagname
	 * @return List<Webelement>
	 * @see used to get frame count
	 */

	public List<WebElement> getNoOfFrames(WebElement element, String tagname) {
		List<WebElement> findElements = driver.findElements(By.tagName("tagName"));
		return findElements;
	}
	/**
	 * 
	 * @param element
	 * @return List<WebElement>
	 * @see used to get selected options in dropdown
	 */

	public List<WebElement> getAllSelectedOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getAllSelectedOptions();
		return options;
	}
	 /**
	  * 
	  * @param element
	  * @see used to scroll down by javascript executor
	  */

	public void scrollDown(WebElement element) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	/**
	 * 
	 * @param element
	 * @see used to scroll up by javascript executor
	 */

	public void scrollUp(WebElement element) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	/**
	 * 
	 * @param element
	 * @see used to click any button by javascript executor
	 */

	public void jsexeClick(WebElement element) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript("arguments[0].click()", element);
	}
	/**
	 * 
	 * @param element
	 * @return Object
	 * @see used to get value by javascript executor
	 */

	public Object jsGetattribute(WebElement element) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Object obj = exe.executeScript("return arguments[0].getAttribute('value')", element);
		return obj;
	}
	/**
	 * @see used to press any key 
	 * @throws AWTException
	 */

	public void keyPress() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.KEY_PRESSED);
	}
	/**
	 * @see used to release any key
	 * @throws AWTException
	 */

	public void keyRelease() throws AWTException {
		Robot r = new Robot();
		r.keyRelease(KeyEvent.KEY_RELEASED);
	}
	/**
	 * @see used to press and release enter key
	 * @throws AWTException
	 */

	public void enterKey() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}
    /**
     * 
     * @param seconds
     * @see used to perform wait function for all locators 
     */
	public void implicityWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(30));
	}

}