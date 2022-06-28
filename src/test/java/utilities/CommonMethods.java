package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends PageInitializer {
	
	private static WebDriver driver = BaseClass.getDriver();

	// send text to webElement
	public static void sendText(WebElement element, String text) {

		element.clear();
		element.sendKeys(text);

	}

	// click the Radio button or Static checkBox
	public static void clickRadioOrCheckbox(List<WebElement> radioOrCheckbox, String value) {

		String actualValue;

		for (WebElement el : radioOrCheckbox) {
			actualValue = el.getAttribute("value").trim();
			if (el.isEnabled() && actualValue.equals(value)) {
				el.click();
				break;
			}
		}
	}

	// select StaticdropDown value
	public static void selectDropDownValue(WebElement element, String textToSelect) {

		try {
			Select select = new Select(element);

			List<WebElement> options = select.getOptions();

			for (WebElement el : options) {
				if (el.getText().equals(textToSelect)) {
					select.selectByVisibleText(textToSelect);
					break;
				}
			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	// select Static drop Down by index
	public static void selectDropDownIndex(WebElement element, int indexValue) {

		try {
			Select select = new Select(element);

			int size = select.getOptions().size();

			if (size > indexValue) {
				select.selectByIndex(indexValue);
			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	// Dismisses alerts and catches exception if alert is not present
	public static void dismissAlert() {

		try {

			Alert alert = driver.switchTo().alert();
			alert.dismiss();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	// Capture text of alert and catches exception if alert is not present
	// return type has to be String
	public static String getAlertText() {

		String alertText = null;

		try {

			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

		return alertText;
	}

	// Accept Alert
	public static void acceptAlert() {

		try {

			Alert alert = driver.switchTo().alert();
			alert.accept();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	// Sends text to alertBox then accept
	public static void sendAlertText(String str) {

		try {

			Alert alert = driver.switchTo().alert();
			alert.sendKeys(str);
			alert.accept();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	// iFrame switch to frame
	public static void switchToFrame(String nameOrIDofFrame) {

		try {
			driver.switchTo().frame(nameOrIDofFrame);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}

	// iFrame switch to frame by WebElement
	public static void switchToFrame(WebElement element) {

		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}

	// iFrame switch to frame by index
	public static void switchToFrame(int index) {

		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}

	// Handle windows by switching to child Window
	public static void switchToChildWindow() {

		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();

		for (String eachWindow : windows) {

			if (!eachWindow.equals(mainWindow)) {
				driver.switchTo().window(eachWindow);
				break;
			}

		}

	}

	// Wait
	public static WebDriverWait getWaitObject() {

		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);

		return wait;
	}

	// waitForClickability
	public static WebElement waitForClickability(WebElement element) {

		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	// waitForVisibility
	public static WebElement waitForVisibility(WebElement element) {

		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	// click
	public static void click(WebElement element) {
		waitForVisibility(element).click();
	}

	// JS executer
	public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}

	// jsClick
	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click();", element);
	}

	// JS scrollToElement
	public static void scrollToElement(WebElement element) {
		getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// JS scrollToElement by pixel
	public static void ScrollByPixel(int pixel) {
		// scroll down positive
		// scroll up negative

		getJSObject().executeScript("window.scrollBy(0," + pixel + ")");

	}

	// time stamp
	public static String getTimeStamp() {

		Date date = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

		return sdf.format(date.getTime());
	}

	// ScreenShot
	public static byte[] takeScreenshot(String filename) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

		File file = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = Constants.SCREENSHOT_FILEPATH + filename + getTimeStamp()
				+ BaseClass.getPropertyString("screenShotsFileType");

		try {
			FileUtils.copyFile(file, new File(destinationFile));
		} catch (Exception ex) {
			System.out.println("Cannot take screenshot!");
		}

		return picBytes;
	}

	// Thread sleep wait
	public static void wait(int second) {

		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// selectCalendarDate
	public static void selectCalendarDate(List<WebElement> element, String text) {
		for (WebElement pickDate : element) {
			if (pickDate.isEnabled()) {
				if (pickDate.getText().equals(text)) {
					pickDate.click();
					break;
				}
			}
		}
	}

	// hover over
	public static void hover(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	// dragAndDrop
	public static void dragAndDrop(WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}

	// doubleClick
	public static void doubleClick(WebElement source) {
		Actions actions = new Actions(driver);
		actions.doubleClick(source).perform();
	}

	/**
	 * return a list of string from a list of elements ignores any element with no
	 * text
	 * 
	 * @param list
	 * @return
	 */
	public static List<String> getElementsText(List<WebElement> list) {
		List<String> elemTexts = new ArrayList<String>();
		for (WebElement el : list) {
			if (!el.getText().isEmpty()) {
				elemTexts.add(el.getText());
			}
		}
		return elemTexts;
	}

	// Created by Pawitri 06/19/2022
	public static void dismissNonJsPopUp(WebElement nonJsPopUpDissButton) {

		try {

			nonJsPopUpDissButton.click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Created by Pawitri 06/19/2022
	public static void assertCheckIsNavigateURL(List<WebElement> listOfWebElement) {

		String homePageURL = driver.getCurrentUrl();

		for (int i = 0; i < listOfWebElement.size(); i++) {

			listOfWebElement.get(i).click();
			String clickedPageURL = driver.getCurrentUrl();

			// check if it navigated to different page after click
			Assert.assertFalse(homePageURL.equals(clickedPageURL));

		}
	}

	// Created by Pawitri 06/19/2022
	public static void clickSpecificElementInListByText(List<WebElement> listOfWebElement,
			String textOfSpecificElement) {

		String text;

		for (int i = 0; i < listOfWebElement.size(); i++) {

			text = listOfWebElement.get(i).getText();
			if (text.contains(textOfSpecificElement)) {
				listOfWebElement.get(i).click();
			}
		}

	}

	// Created by Pawitri 06/19/2022
	// ScreenShot for Pass test
	public static byte[] takeScreenshot_pass(String filename) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

		File file = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = Constants.SCREENSHOT_FILEPATH_PASS + filename + getTimeStamp()
				+ BaseClass.getPropertyString("screenShotsFileType");

		try {
			FileUtils.copyFile(file, new File(destinationFile));
		} catch (Exception ex) {
			System.out.println("Cannot take screenshot!");
		}

		return picBytes;
	}

	// Created by Pawitri 06/19/2022
	// ScreenShot for fail test
	public static byte[] takeScreenshot_fail(String filename) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

		File file = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = Constants.SCREENSHOT_FILEPATH_FAIL + filename + getTimeStamp()
				+ BaseClass.getPropertyString("screenShotsFileType");

		try {
			FileUtils.copyFile(file, new File(destinationFile));
		} catch (Exception ex) {
			System.out.println("Cannot take screenshot!");
		}

		return picBytes;
	}

	// Created by Alip 06/21/2022
	// select value from list

	public static void clickValueFromListByText(List<WebElement> element, String text) {
		for (WebElement value : element) {
			if (value.isDisplayed()) {
				if (value.getText().contains(text)) {
					value.click();
					break;
				}
			}
		}
	}

	// Created by Alip 06/21/2022
	// select value from list
	public static void doubleClickValueFromListByText(List<WebElement> element, String text) {
		for (WebElement value : element) {
			if (value.isDisplayed()) {
				if (value.getText().contains(text)) {
					doubleClick(value);
					break;
				}
			}
		}
	}

	// Created by Alip 06/21/2022
	// select value from list
	public static void jsClickValueFromListByIndex(List<WebElement> elements, int index) {
		try {
			for (int i = 0; i < elements.size(); i++) {
				if (index <= elements.size()) {
					WebElement element = elements.get(index);
					CommonMethods.jsClick(element);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Created by Alip 06/21/2022
	// select value from list
	public static void jsClickEveryValueFromList(List<WebElement> elements) {
		try {
			for (WebElement value : elements) {
				if (value.isDisplayed()) {
					jsClick(value);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Created by Pawitri 06/21/22
	public static void waitVisibilityOfList(List<WebElement> listOfElement) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElements(listOfElement));

	}

	// Created by Pawitri 06/21/22
	public static void pickDateMonthYear(List<WebElement> DateList, WebElement calenderMonth, WebElement calenderYear,
			WebElement calendernextMonthButton, String date, String month, String year) {

		while (true) {

			String currentMonth = calenderMonth.getText();
			String currentYear = calenderYear.getText();

			if (currentMonth.equalsIgnoreCase(month) && currentYear.equalsIgnoreCase(year)) {
				CommonMethods.selectCalendarDate(DateList, date);
				break;
			}

			calendernextMonthButton.click();
		}

	}
	
	// Created by Pawitri 06/21/22
		public static void pickMonthYear(WebElement calenderMonth, WebElement calenderYear,
				WebElement calendernextMonthButton,String month, String year) {

			while (true) {

				String currentMonth = calenderMonth.getText();
				String currentYear = calenderYear.getText();

				if (currentMonth.equalsIgnoreCase(month) && currentYear.equalsIgnoreCase(year)) {
					break;
				}

				calendernextMonthButton.click();
			}

		}

	// Created by Pawitri 06/21/22
	public static void pickRadioButton(List<WebElement> radioButtonList, String textOfRadio) {

		for (int i = 0; i < radioButtonList.size(); i++) {
			if (radioButtonList.get(i).getText().contains(textOfRadio)) {
				radioButtonList.get(i).click();
			}
		}

	}

	// Created by Pawitri 06/21/22
	public static void pickDynamicList(List <WebElement> list, String text) {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().contains(text)) {
				list.get(i).click();
				break;
			}
		}
	}
	
	// Created by Pawitri 06/28/22
	public static void clickValueFromListByIndex(List<WebElement> elements, int index) {

					elements.get(index).click();			
					
	}
	
	
	
	

}//class
