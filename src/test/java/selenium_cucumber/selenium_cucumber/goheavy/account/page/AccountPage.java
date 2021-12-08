package selenium_cucumber.selenium_cucumber.goheavy.account.page;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium_cucumber.selenium_cucumber.general.PageObject;
import selenium_cucumber.selenium_cucumber.general.Setup;

public class AccountPage extends PageObject {

	public AccountPage() {
		super();
		this.urlPath = "accountsettings";
	}

	public WebElement getForm() {
		return this.getWebElement(By.cssSelector("#account-settings"));
	}

	public void getFromElements() {
		// Setting avatar
		WebElement photo = this.getWebElement(By.xpath("//input[@type='file']"));
		String url = (String) Setup.getValueStore("avatar");
		photo.sendKeys(url);

		// Scrolling the page to get the element activated
		String formScroll = "//*[@id=\"account-settings\"]/ancestor::div[@class=\"templateStyles__" +
				"ContentDiv-sc-144t9h2-1 bcVeZj\"]";
		this.scroll(formScroll, By.id("addressStateId"));

		// Getting State
		WebElement stateInput = this.getWebElement(By.id("addressStateId"));
		Setup.getActions().moveToElement(stateInput).click().perform();

		// Getting State menu
		List<WebElement> addressStateId_list = this.getWebElements(By.xpath(
				"//div[@id='addressStateId_list']/ancestor::div[contains(@class,'ant-select-dropdown')]/descendant::" +
						"div[contains(@class,'ant-select-item ant-select-item-option')]/span"));
		int v = addressStateId_list.size();
		WebElement address = addressStateId_list.get(new Random().nextInt(v));
		Setup.getActions().moveToElement(address).click().perform();
	}

	public WebElement getUpdateButton() {
		return this.getWebElement(By.xpath("//*[@id=\"account-settings\"]//button"));
	}

	public WebElement getPopupMessage() {
		Setup.getWait().visibilityOfElement(By.xpath("//div[@class='ant-notification-notice-message']"),
				"Not element message");
		return this.getWebElement(By.xpath("//div[@class='ant-notification-notice-message']"));
	}
}
