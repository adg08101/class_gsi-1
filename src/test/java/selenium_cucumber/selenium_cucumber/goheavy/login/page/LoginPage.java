package selenium_cucumber.selenium_cucumber.goheavy.login.page;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium_cucumber.selenium_cucumber.general.PageObject;
import selenium_cucumber.selenium_cucumber.general.Setup;

public class LoginPage extends PageObject {
	String password_id="password";
	String user_id="email";
	String LogingxpathText="//h1[text()='Login']";

	public LoginPage() {
		super();
		this.urlPath = "login";

	}
	
	public WebElement getLogingTextElemnt() throws Exception{
		return getWebElement(By.xpath(LogingxpathText));
	}

	public HashMap<String, WebElement> fillCredentials(String email, String password) {
		WebElement pass_element = getWebElement(By.id(user_id));
		pass_element.sendKeys(email);
		WebElement email_element = getWebElement(By.id(password_id));
		email_element.sendKeys(password);

		HashMap<String, WebElement> eles = new HashMap<String, WebElement>();
		eles.put("email", email_element);
		eles.put("password", pass_element);
		return eles;
	}

	public void clickOnButtons() {
		getWebElement(By.xpath("//*[@id=\"admin-form-session\"]/button")).click();

	}
	
	public void waitForElelemtDisappear() throws Exception{		
		Setup.getWait().waitUntilElementDisappear(By.id(password_id));
		Setup.getWait().waitUntilElementDisappear(By.id(user_id));
	}

}
