package selenium_cucumber.selenium_cucumber.goheavy.account.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import selenium_cucumber.selenium_cucumber.general.PageObject;
import selenium_cucumber.selenium_cucumber.general.Setup;
import selenium_cucumber.selenium_cucumber.general.testCases;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class AccountPage extends PageObject {
	private String closePopupIconXpath;

	public AccountPage() {
		super();
		this.urlPath = "accountsettings";
		setClosePopupIconXpath("//span[@class='ant-notification-close-x']");
	}

	public WebElement getForm() {
		return this.getWebElement(By.cssSelector("#account-settings"));
	}

	public String getHeaderTextXpath() {
		return "//span[text()='Account Settings']";
	}

	public void setAvatarImage(String fileImage, testCases testCase) {
		WebElement photo = this.getWebElement(By.xpath("//input[@type='file']"));
		photo.sendKeys(fileImage);
		Setup.getWait().thread(3000);
		checkMessageOutput(testCase);
	}

	//TODO: Explain test here
	public void checkMessageOutput(testCases testCase) {
		switch (testCase) {
			case hugeImageFile:
				Assert.assertEquals("The image must be smaller than 5 MB", getPopupMessage().getText());
				clicksOnButton(By.xpath(getClosePopupIconXpath()));
				break;
			case wrongImageFormat:
				Assert.assertEquals("You can only upload JPG/JPEG/PNG files", getPopupMessage().getText());
				clicksOnButton(By.xpath(getClosePopupIconXpath()));
				break;
			default:
		}
	}

	public void testTextInputFields(By by) {
		WebElement element = getWebElement(by);
		Setup.getActions().moveToElement(element).build().perform();
		//TODO: Explain element clear
		clearTextElementText(element);
		Setup.getActions().sendKeys(element, Setup.getFaker().phoneNumber().cellPhone()).build().perform();
		//TODO: Explain element validation
		checkRequiredMessageForTextInput(testCases.invalidFormatTextBoxMessage);
		Setup.getWait().thread(1000);
	}

	public void clearTextElementText(WebElement element) {
		//TODO: Explain this (interesting)
		int length = element.getAttribute("value").length();
		for (int i=0;i < length;i++)
			Setup.getActions().sendKeys(element, Keys.BACK_SPACE).build().perform();
		//TODO: Explain element validation
		checkRequiredMessageForTextInput(testCases.requiredTextBoxMessage);
	}

	public void checkRequiredMessageForTextInput(testCases testCase) {
		By by = By.xpath(
				"//div[contains(@class, 'ant-form-item')]/descendant::div[@role='alert']"
		);

		waitForElementToBePresent(by);

		WebElement element = getWebElement(by);

		switch (testCase) {
			case requiredTextBoxMessage:
				Assert.assertEquals("This field is required", element.getText());
				break;
			case invalidFormatTextBoxMessage:
				Assert.assertEquals(element.getText(), "Only letters and the special characters (' -) are allowed. " +
						"50 characters maximum");
				break;
			default:
		}
	}

	public void getFormElements() {
		//TODO: Explain Setting avatar (Uploading image)
		//TODO: Explain "not really there" DOM items interaction (Not using Actions)
		//TODO: Explain how Selenium helps us to test NFR
		//TODO: Explain correct enums use

		//AVATAR TEST HERE
		//Setting huge avatar
		String avatar = (String) Setup.getValueStore("huge_avatar");
		setAvatarImage(avatar, testCases.hugeImageFile);

		//Setting wrong format avatar
		avatar = (String) Setup.getValueStore("gif_avatar");
		setAvatarImage(avatar, testCases.wrongImageFormat);

		//Setting correct avatar
		avatar = (String) Setup.getValueStore("avatar");
		setAvatarImage(avatar, testCases.happyCase);

		//Check mandatory for avatar
		Assert.assertNotNull(getWebElement(
				By.xpath("//label[text()='Profile photo' and contains(@class, 'ant-form-item-required')]")));
		//AVATAR TEST ENDS HERE

		//FIRST AND LASTNAME TEST HERE
		By by = By.id("firstName");
		testTextInputFields(by);

		//TODO Placeholder here
		checkPlaceholderTextInput(by, testCases.firstNamePlaceholder);

		//TODO: Happy Case here
		Setup.getActions().sendKeys(getWebElement(by), Setup.getFaker().name().firstName());

		//LAST NAME HERE

		by = By.id("lastName");
		testTextInputFields(by);

		//TODO Placeholder here
		checkPlaceholderTextInput(by, testCases.lastNamePlaceholder);

		//TODO: Happy Case here
		Setup.getActions().sendKeys(getWebElement(by), Setup.getFaker().name().lastName());

		//FIRST AND LASTNAME TEST ENDS HERE

		//TODO Happy case for mobile
		by = By.id("mobilePhone");
		clearTextElementText(getWebElement(by));
		Setup.getActions().sendKeys(getWebElement(by), Setup.getFaker().phoneNumber().cellPhone()).
				build().perform();

		//TODO Happy case for email
		by = By.id("email");
		clearTextElementText(getWebElement(by));
		Setup.getActions().sendKeys(getWebElement(by), Setup.getFaker().internet().emailAddress()).
				build().perform();

		//TODO Happy case for address
		by = By.id("address");
		clearTextElementText(getWebElement(by));
		Setup.getActions().sendKeys(getWebElement(by), Setup.getFaker().address().streetAddress()).
				build().perform();

		//TODO Interact and happy case for DropDown Items
		interactWithDropDownElement(By.xpath("//input[@id='addressStateId' and @role='combobox']"),
				true, By.xpath("//div[contains(@class, 'ContentDiv')]"));
	}

	//TODO: Explain check placeholder logic
	private void checkPlaceholderTextInput(By by, testCases testCase) {
		clearTextElementText(getWebElement(by));
		switch (testCase) {
			case firstNamePlaceholder:
				//TODO Explain this (Issue detected)
				//Assert.assertTrue(getWebElement(by).getAttribute("placeholder").equals("Enter First Name"));
				Assert.assertEquals("Enter the first name", getWebElement(by).getAttribute("placeholder"));
				break;
			case lastNamePlaceholder:
				//TODO Explain this (Issue detected)
				//Assert.assertEquals("Enter Last Name", getWebElement(by).getAttribute("placeholder"));
				Assert.assertEquals("Enter the last name", getWebElement(by).getAttribute("placeholder"));
				break;
			default:
				return;
		}
	}

	public WebElement getUpdateButton() {
		return this.getWebElement(By.xpath("//*[@id=\"account-settings\"]//button"));
	}

	public WebElement getPopupMessage() {
		Setup.getWait().visibilityOfElement(By.xpath("//div[@class='ant-notification-notice-message']"),
				"Not element message");
		return this.getWebElement(By.xpath("//div[@class='ant-notification-notice-message']"));
	}

	public String getClosePopupIconXpath() {
		return closePopupIconXpath;
	}

	public void setClosePopupIconXpath(String closePopupIconXpath) {
		this.closePopupIconXpath = closePopupIconXpath;
	}
}
