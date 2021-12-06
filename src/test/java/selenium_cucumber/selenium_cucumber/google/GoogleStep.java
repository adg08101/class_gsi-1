package selenium_cucumber.selenium_cucumber.google;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.interactions.Actions;
import selenium_cucumber.selenium_cucumber.general.Setup;

public class GoogleStep {

    private GoogleSearchPage googleSearchPage;

    public GoogleStep() {
        googleSearchPage = new GoogleSearchPage();
    }

    public void checkIsGooglePage() {
        googleSearchPage.openURL();
        assertThat(Setup.getDriver().getCurrentUrl(), containsString("google.com"));

    }

    public void typeInSearchfield(String searchcriteria) {
        googleSearchPage.fillInputSerachField(searchcriteria);
        Setup.setKeyValueStore("searchcriteria", searchcriteria);

    }

    public void clicksOnbutton(String string) {
        googleSearchPage.clicksOnButtonSerach();

    }

    public void checkSearching() {
        String criteria = Setup.getValueStore("searchcriteria").toString();
        List<WebElement> list = googleSearchPage.getAllaTag(criteria);
        assertTrue("There is not matches for this criteria: " + criteria, list.size() > 0);

    }

    public void user_clicks_any_result_item() {
        String criteria = Setup.getValueStore("searchcriteria").toString();
        List<WebElement> list = googleSearchPage.getAllaTag(criteria);
        Random r = new Random();
        int value = -1;
        while (value < 0) {
            value = r.nextInt(list.size());
        }
        WebElement aTag = list.get(value);

        String link = aTag.getAttribute("href");
        Setup.setKeyValueStore("linkText", link);
        aTag.click();


    }

    public void url_should_contains_link_reference() {
        String linkText = Setup.getValueStore("linkText").toString();
        String url = Setup.getDriver().getCurrentUrl();
        try {
            Assert.assertTrue(url.contains(linkText) || url.contains(new URL(linkText).getHost()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }
}




