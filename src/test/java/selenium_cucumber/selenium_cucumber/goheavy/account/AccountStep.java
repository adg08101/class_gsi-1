package selenium_cucumber.selenium_cucumber.goheavy.account;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium_cucumber.selenium_cucumber.general.Setup;
import selenium_cucumber.selenium_cucumber.general.Steps;
import selenium_cucumber.selenium_cucumber.goheavy.account.page.AccountPage;
import java.util.HashMap;

import static org.junit.Assert.fail;

public class AccountStep extends Steps {

	private final AccountPage accountPage;

	public AccountStep() {
		accountPage = new AccountPage();
	}

	@Override
	public void checkPage() {
		accountPage.waitForSpinningElementDisappear();
		accountPage.waitForElementToBePresent(By.xpath(getHeaderXpath()));
		String path = accountPage.getPagePath().toLowerCase();
		Assert.assertTrue(" The path provided is not correct in the url. path: " + path,
				Setup.getDriverWait().until(ExpectedConditions.urlContains(path)));
		try {
			accountPage.getForm();
		} catch (Exception e) {
			fail("The view do not match with Account page.");
		}
	}

	public void openAccountSetting() {
		By menuItem = By.xpath("//span[@aria-label='setting']/ancestor::span[@class='ant-menu-title-content']/" +
				"span[text()='Settings']");
		By AccountSettingsItem = By.xpath("//span[@aria-label='profile']/ancestor::li[@role='menuitem']/" +
				"descendant::span[text()='Account Settings']");

		accountPage.waitForElementToBePresent(menuItem);
		HashMap<String, WebElement> li = accountPage.getMenu(menuItem);
		WebElement settings = li.get("Settings");
		Setup.getActions().moveToElement(settings).click().perform();
		accountPage.waitForElementToBePresent(AccountSettingsItem);
		WebElement elementTwo = settings.findElement(AccountSettingsItem);
		Setup.getActions().moveToElement(elementTwo).click().perform();
		accountPage.waitForSpinningElementDisappear();
	}

	public void fillValidData() {
		accountPage.getFormElements();
	}

	public void clicksUpdate() {
		Setup.getActions().moveToElement(accountPage.getUpdateButton()).click().perform();
	}

	public void checkSpinningAppears() {
		accountPage.waitForSpinningElementDisappear();
	}

	public void checkUpdateMessage(String string) {
		WebElement notificationEle = accountPage.getPopupMessage();
		Setup.getWait().thread(2);
		WebElement parent = notificationEle
				.findElement(By.xpath("ancestor::div[contains(@class,'ant-notification-topRight')]"));

		// Checking messages match
		Assert.assertEquals("Update notification message was not found.", string.toLowerCase(),
				notificationEle.getText().toLowerCase());
		
		// Checking that popup is in the right
		String style = parent.getAttribute("style");
		Assert.assertTrue("Popup is not in the right corner.", style.contains("right: 0px"));
	}

	public String getHeaderXpath() {
		return accountPage.getHeaderTextXpath();
	}
}
