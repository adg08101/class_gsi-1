package selenium_cucumber.selenium_cucumber.general;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageObject {
	private final WebDriver driver;
	protected String urlPath = "";
	private final String spinningElement = "//div[contains(@class,'ant-spin-spinning')]";
	private double waitTimeFactor;

	public PageObject() {
		setWaitTimeFactor(10);
		this.driver = Setup.getDriver();
		//TODO: Study https://www.browserstack.com/guide/page-object-model-in-selenium
		PageFactory.initElements(this.driver, this);
	}

	public void openURL() {
		String url = ((Properties) Setup.getValueStore("defaultProperties")).getProperty("default.URL");
		Setup.openUrl(url.concat("/").concat(urlPath));
	}

	protected WebElement getWebElement(By by) {
		return this.driver.findElement(by);
	}

	protected List<WebElement> getWebElements(By by) {
		return this.driver.findElements(by);
	}

	@SuppressWarnings("unused")
	protected void clicksOnButton(By by) {
		getWebElement(by).click();
	}

	@SuppressWarnings("unused")
	public void print(String message) {
		System.out.println(message);
	}

	public String getCurrentUrl() {
		return this.driver.getCurrentUrl();
	}

	public String getPagePath() {
		return this.urlPath;
	}

	public void checkSpinningAppears() {
		Setup.getWait().waitUntilElementAppear(By.xpath(spinningElement), 10);
	}

	public void waitForSpinningElementDisappear() {
		try {
			checkSpinningAppears();
			Setup.getWait().waitUntilElementDisappear(By.xpath(spinningElement), 10);
		} catch (Exception ignored) {	}
	}

	public void scroll(String scrollElementXpath, By targetElementXpath) {
		WebElement el = this.getWebElement(targetElementXpath);
		int desired_y = el.getSize().height / 2 + el.getLocation().y;

		int current_y = (Integer.parseInt(String.valueOf(Setup.executeScript("return window.innerHeight"))) / 2)
				+ Integer.parseInt(String.valueOf(Setup.executeScript("return window.pageYOffset")));
		int scroll_y_by = desired_y + current_y;

		Setup.executeScript("var el=" + "document.evaluate('" + scrollElementXpath + "',"
				+ " document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;"
				+ " el.scrollTo(0, arguments[0]);", scroll_y_by);
	}

	public HashMap<String, WebElement> getMenu(By by) {
		waitForSpinningElementDisappear();
		waitForElementToBePresent(by);
		HashMap<String, WebElement> list = new HashMap<>();
		if (!Objects.isNull(by)) {
			WebElement element = this.getWebElement(by);
			list.put(element.getText(), element);
		}
		return list;
	}

	public void waitForElementToBePresent(By by) {
		waitFactorTime(0);
		Setup.getDriverWait().until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void waitFactorTime(double extraFactor) {
		Setup.getWait().thread((long) ((long) Setup.getWaitTime() * getWaitTimeFactor() * extraFactor));
	}

	public double getWaitTimeFactor() {
		return waitTimeFactor;
	}

	public void setWaitTimeFactor(double waitTimeFactor) {
		this.waitTimeFactor = waitTimeFactor;
	}
}
