package selenium_cucumber.selenium_cucumber.general;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitingObject {

	private final WebDriver driver;

	public WaitingObject(WebDriver driver) {
		this.driver = driver;
		this.waitForLoading(20);
	}

	/**
	 * @executeExpectedCondition Method to execute the wait statement
	 * @param expected Expected Condition Object
	 * @param message Message to Show
	 */
	@SuppressWarnings("unchecked")
	public void executeExpectedCondition(ExpectedCondition expected, String message) {
		waitMethod().withMessage(message).until(expected);
	}


	/**
	 *
	 * @param time Time to wait for loading
	 */
	public void waitForLoading(long time) {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}

	/**
	 *
	 * @param by By selector
	 */
	public void waitUntilElementAppear(By by) {
		WebElement element1 = driver.findElement(by);
		ExpectedCondition expectedCondition = ExpectedConditions.visibilityOf(element1);
		String mss = "Element " + element1 + " not found";
		executeExpectedCondition(expectedCondition, mss);
	}

	/**
	 *
	 * @param by By selector to use
	 */
	public void waitUntilElementDisappear(By by) {
		WebElement element1;
		try {
			element1 = driver.findElement(by);
		} catch (Exception e) {
			return;
		}
		ExpectedCondition expectedCondition = ExpectedConditions.invisibilityOf(element1);
		String mss = "Element " + element1 + " still in dom ";
		executeExpectedCondition(expectedCondition, mss);

	}

	/**
	 *
	 * @return WebDriver Wait
	 */
	private WebDriverWait waitMethod() {
		return new WebDriverWait(this.driver, 10);
	}

	/**
	 *
	 * @param by By var
	 * @param msg String Message
	 */
	public void visibilityOfElement(By by, String msg) {
		WebDriverWait wait = waitMethod();
		if (!msg.equals("")) {
			wait.withMessage(msg);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	/**
	 *
	 * @param expectedMessage Expected Message
	 */
	@SuppressWarnings("unused")
	public void textAppear(String expectedMessage) {
		visibilityOfElement(By.xpath("//*[contains(text(),'" + expectedMessage + "')]"),
				"Unable to locate text '" + expectedMessage + "'");
	}

	/**
	 *
	 * @param time Time to wait
	 */
	public void thread(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * @param save Save element to be clicked
	 */
	@SuppressWarnings("unused")
	public void waiForElementClick(WebElement save) {
		waitMethod().until(ExpectedConditions.elementToBeClickable(save)).click();
	}
}
