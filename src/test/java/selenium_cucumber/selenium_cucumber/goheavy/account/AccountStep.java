package selenium_cucumber.selenium_cucumber.goheavy.account;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
		String path = accountPage.getPagePath().toLowerCase();
		Assert.assertTrue(" The path provided is not correct in the url. path: " + path,
				accountPage.getCurrentUrl().toLowerCase().contains(path));
		try {
			accountPage.waitForSpinningElementDisappear();
			accountPage.getFrom();
		} catch (Exception e) {
			fail("The view do not match with Account page.");
		}
	}

	public void openAccountSetting() {
		HashMap<String, WebElement> li = accountPage
				.getMenu(By.xpath("//span[@aria-label='setting']/ancestor::span[@class='ant-menu-title-content']"));
		WebElement setting = li.get("Settings");
		Setup.getActions().moveToElement(setting).click().perform();
		Setup.getWait().thread(400);
		accountPage.waitForSpinningElementDisappear();
		WebElement el2 = setting.findElement(By.xpath("//span[@aria-label='profile']/ancestor::li[@role='menuitem']"));
		Setup.getActions().moveToElement(el2).click().perform();
		accountPage.waitForSpinningElementDisappear();
		Setup.getWait().thread(4000);
	}

	public void fillValidData() {
		accountPage.getFromElements();
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
}
