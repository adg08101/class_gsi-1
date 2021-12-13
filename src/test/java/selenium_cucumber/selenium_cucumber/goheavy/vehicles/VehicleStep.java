package selenium_cucumber.selenium_cucumber.goheavy.vehicles;

import org.junit.Assert;

import selenium_cucumber.selenium_cucumber.general.Setup;
import selenium_cucumber.selenium_cucumber.general.Steps;
import selenium_cucumber.selenium_cucumber.goheavy.driver.pages.DriverPage;
import selenium_cucumber.selenium_cucumber.goheavy.vehicles.page.VehiclePage;

@SuppressWarnings("unused")
public class VehicleStep extends Steps{
	public VehiclePage vehiclePage;

	public VehicleStep() {
		vehiclePage = new VehiclePage();
	}

	public void checkPage() {
		String path = vehiclePage.getPagePath().toLowerCase();
		Assert.assertTrue(" The path provided is not correct in the url. path: " + path,
				vehiclePage.getCurrentUrl().toLowerCase().contains(path));
	}

	public void goToAccountSettingsView() {
		try {
			Setup.getWait().thread(2500);
			Assert.assertTrue(vehiclePage.goToVehiclesAndInsuranceListView());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void userClicksOnAddVehicleButton() {
		try {
			Assert.assertTrue(vehiclePage.clickOnAddVehicleButton());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void theSystemOpensTheAddVehicleView() {
		try {
			Assert.assertTrue(vehiclePage.systemOpensAddVehicleView());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void hoverOverImageComponent() {
		try {
			Assert.assertTrue(vehiclePage.hoverOverImageComponent());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void userInsertsValidDataAndClicksDone() {
		try {
			Assert.assertTrue(vehiclePage.userInsertsValisDataAndClicksDone());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void systemCreatesVehicleOnStatus(String status) {
		try {
			Assert.assertNotNull(vehiclePage.systemCreatesVehicleOnStatus(status));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void systemRegistersCreationDate() {
		try {
			Assert.assertNotNull(vehiclePage.systemsRegistersCreationDate());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void returnToViewAndDisplaysMessage(String message) {
		try {
			checkPage();
			Assert.assertTrue(vehiclePage.returnsToViewAndDisplaysMessage(message));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void systemDisplaysAssignView() {
		try {
			Assert.assertTrue(vehiclePage.systemDisplaysAssignView());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void userAssignsTheVehicle() {
		try {
			Assert.assertTrue(vehiclePage.userAssignsTheVehicle());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
