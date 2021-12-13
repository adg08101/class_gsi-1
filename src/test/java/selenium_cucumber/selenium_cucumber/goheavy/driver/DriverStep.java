package selenium_cucumber.selenium_cucumber.goheavy.driver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium_cucumber.selenium_cucumber.general.PageObject;
import selenium_cucumber.selenium_cucumber.general.Setup;
import selenium_cucumber.selenium_cucumber.general.Steps;
import selenium_cucumber.selenium_cucumber.goheavy.driver.pages.DriverPage;

@SuppressWarnings("unused")
public class DriverStep extends Steps{
	private DriverPage driverListPage;

	public DriverStep() {
		driverListPage = new DriverPage();
	}

	public void checkPage() {
		String path = driverListPage.getPagePath().toLowerCase();
		Assert.assertTrue(" The path provided is not correct in the url. path: " + path,
				driverListPage.getCurrentUrl().toLowerCase().contains(path));
	}

	public void goToView() {
		Assert.assertTrue(driverListPage.goToView());
	}

	public void userClicksOnAddDriverButton() {
		Assert.assertTrue(driverListPage.userClickOnAddDriver());
	}

	public void systemOpensAddDriverView() {
		Assert.assertNotNull(driverListPage.systemOpensAddDriverView());
	}

	public void user_inserts_valid_data_done(boolean update) {
		Assert.assertTrue(driverListPage.userInsertsValidDataDone(update));
	}

	public void system_creates_driver_on_status(String status) {
		Assert.assertNotNull(driverListPage.systemCreatesDriverOnStatus(status));
	}

	public void user_clicks_on_documents_button() {
		Assert.assertTrue(driverListPage.userClicksOnDocumentsButton());
	}

	public void system_displays_documents_for_driver() {
		Assert.assertNotNull(driverListPage.systemDisplaysDocuments());
	}

	public void user_clicks_on_approve_button() {
		Assert.assertTrue(driverListPage.userClicksOnApproveButton());
	}

	public boolean the_system_saves_and_goes() {
		//TODO: Implement this logic
		//this.checkPage();
		return true;
	}

	public void userClickEdit() {
		// TODO Auto-generated method stub
		Assert.assertTrue(driverListPage.userClicksUpdate());
	}

	public void systemOpensEdit() {
		// TODO Auto-generated method stub
		Assert.assertTrue(driverListPage.systemOpensEdit());
	}

	public void user_clicks_on_assign_button() {
		// TODO Auto-generated method stub
		Assert.assertTrue(driverListPage.userClicksOnAssignButton());
	}
}
