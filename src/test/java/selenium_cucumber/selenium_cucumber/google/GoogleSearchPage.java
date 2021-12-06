package selenium_cucumber.selenium_cucumber.google;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium_cucumber.selenium_cucumber.general.PageObject;

public class GoogleSearchPage extends PageObject {

    public GoogleSearchPage() {
        super();
        this.urlpath = "";
    }

    public void fillInputSerachField(String searchcriteria) {
        this.getWebElement(By.xpath("//input[@title='Search' and @role='combobox']")).sendKeys(searchcriteria);
    }

    public void clicksOnButtonSerach() {
        cliksOnButton(By.xpath(
                "//div[contains(@class,'FPdoLc')]/descendant::input[@value='Google Search' and @type='submit']"));
    }

    public List<WebElement> getAllaTag(String textcriteria) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return this.getWebElements(By.xpath("//h3[contains(translate(text(),'" + alphabet + "', '"
                + alphabet.toLowerCase() + "'),'" + textcriteria + "')]/ancestor::a"));
    }
}
