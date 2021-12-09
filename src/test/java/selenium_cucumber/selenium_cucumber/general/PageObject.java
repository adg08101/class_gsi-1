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
	private HashMap<String, WebElement> choiceItems;

	public PageObject() {
		setWaitTimeFactor(50);
		this.driver = Setup.getDriver();
		//TODO: Study https://www.browserstack.com/guide/page-object-model-in-selenium
		PageFactory.initElements(this.driver, this);
		setChoiceItems(new HashMap<>());
	}

	public void openURL() {
		String url = ((Properties) Setup.getValueStore("defaultProperties")).getProperty("default.URL");
		Setup.openUrl(url.concat("/").concat(urlPath));
	}

	//TODO Develop new logic to interact with DropDown

	public void interactWithDropDownElement(By dropDown, Boolean scrollRequired, By dropDownContainer) {
		int index = 0;
		waitForWebElement(dropDown);
		WebElement element = getWebElement(dropDown);
		if (scrollRequired && dropDownContainer != null)
			scroll(getWebElement(dropDownContainer), element);
		moveToWebElement(element);
		clickOnWebElement(element);
		WebElement optionElementsContainer = getWebElement(By.xpath("//div[@role='listbox' and @id='" +
				element.getAttribute("id") + "_list']"));
		waitForWebElement(By.xpath("//div[@role='option' and @aria-label]"));
		WebElement choiceElement = optionElementsContainer.findElement(By.xpath
				("//div[@role='option' and @aria-label]"));
		moveToWebElement(choiceElement);
		moveToWebElement(getWebElement(By.xpath("//div[@class='rc-virtual-list-holder']")));
		scrollVerticalDown(10, getWebElement(By.xpath("//div[@class='rc-virtual-list-holder']")), false,
				null);

		HashMap<Integer, String> choiceElementsIndexes = new HashMap<>();

		for (Map.Entry<String, WebElement> choiceItem: getChoiceItems().entrySet())
			choiceElementsIndexes.put(index++, choiceItem.getKey());

		int randomIndexToSelect = (int) Math.floor(Math.random() * index + 1);
		String elementToSelect = choiceElementsIndexes.get(randomIndexToSelect);

		scrollVerticalDown(10, getWebElement(By.xpath("//div[@class='rc-virtual-list-holder']")), true,
				elementToSelect);
	}

	public void scroll(WebElement containerElement, WebElement targetElement) {
		if (targetElement.getLocation().getY() > 45) {
			String script = "arguments[0].scrollTo(" + targetElement.getLocation().getX() + ", " +
					(targetElement.getLocation().getY() - 45) + ");";
			Setup.getJsExecutor().executeScript(script, containerElement);
		}
	}

	public void scrollVerticalDown(int times, WebElement element, boolean select, String selectItem) {
		int defaultSize = 200;

		for (int i = 0;i < times;i++) {
			Setup.getWait().thread(defaultSize);
			Setup.getJsExecutor().executeScript("arguments[0].scrollBy(0, " + defaultSize + ");", element);
			fillChoiceItems(getWebElements(By.xpath("//div[@class='ant-select-item-option-content']")));
			if (select) {
				try {
					Setup.getActions().click(getWebElement(By.xpath("//div[text()='" + selectItem + "']"))).
							build().perform();
					return;
				} catch (Exception ignored) { }
			}
		}

		for (int i = 0;i < times;i++) {
			Setup.getWait().thread(defaultSize);
			Setup.getJsExecutor().executeScript("arguments[0].scrollBy(0, " +
					defaultSize * -1 + ");", element);
		}
	}

	private void fillChoiceItems(List<WebElement> elements) {
		try {
			for (WebElement element: elements) {
				if (!getChoiceItems().containsKey(element.getText())) {
					getChoiceItems().put(element.getText(), element);
				}
			}
		} catch (Exception ignored) { }
	}

	public void clickOnWebElement(WebElement element) {
		Setup.getActions().click(element).build().perform();
	}

	public void moveToWebElement(WebElement element) {
		Setup.getActions().moveToElement(element).build().perform();
	}

	public void waitForWebElement(By by) {
		Setup.getDriverWait().until(ExpectedConditions.presenceOfElementLocated(by));
	}

	//TODO End Here

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
		Setup.getWait().waitUntilElementAppear(By.xpath(spinningElement));
	}

	//TODO: Explain wait for disappear spinning element strategy
	public void waitForSpinningElementDisappear() {
		try {
			checkSpinningAppears();
			Setup.getWait().waitUntilElementDisappear(By.xpath(spinningElement));
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

	//TODO: Explain extra wait factor
	public void waitForElementToBePresent(By by) {
		waitFactorTime(0.01);
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

	public HashMap<String, WebElement> getChoiceItems() {
		return choiceItems;
	}

	public void setChoiceItems(HashMap<String, WebElement> choiceItems) {
		this.choiceItems = choiceItems;
	}
}
