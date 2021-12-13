package selenium_cucumber.selenium_cucumber.goheavy.driver;

//import java.io.InputStream;
import java.util.Properties;
import io.cucumber.java.en.*;
import selenium_cucumber.selenium_cucumber.general.*;
import selenium_cucumber.selenium_cucumber.goheavy.dashboard.DashboardStep;
import selenium_cucumber.selenium_cucumber.goheavy.driver.DriverStep;
import selenium_cucumber.selenium_cucumber.goheavy.fleetowners.FleetStep;

@SuppressWarnings("unused")
public class DriverStepDefinition {
	private GeneralSteps generalSteps;
	private DriverStep driverSteps;

	public DriverStepDefinition() {
		generalSteps = new GeneralSteps();
		driverSteps = new DriverStep();
	}
	
	@When("User clicks on \"Add Driver\" button.")
	public void user_cilcks_on_add_driver_button() {
		driverSteps.userClicksOnAddDriverButton();
	}
	
	@Then("The system opens the \"Add Driver\" view.")
	public void the_system_opens_the_add_driver_view() {
		driverSteps.systemOpensAddDriverView();
	}
	
	@When("The user inserts valid driver data AND clicks on the {string} button.")
	public void user_inserts_valid_data_done(String update) {
		boolean is_update = false;
		if (update.equals("Update"))
			is_update = true;
		driverSteps.user_inserts_valid_data_done(is_update);
	}
	
	@Then("The System Creates a new Driver in {string} status.")
	public void system_creates_driver_on_status(String status) {
		driverSteps.system_creates_driver_on_status(status);
	}
	
	@When("User clicks on Documents button that belong to a {string}.")
	public void user_clicks_on_documents_button(String goheavy_object) {
		driverSteps.user_clicks_on_documents_button();
	}
	
	@Then("The system displays the {string} view.")
	public void system_displays_documents_for_driver(String goheavy_view) {
		driverSteps.system_displays_documents_for_driver();
	}
	
	@When("User clicks on \"Approve\" button.")
	public void user_clicks_on_approve_button() {
		driverSteps.user_clicks_on_approve_button();
	}
	
	@Then("The system Saves Changes and goes back to the {string} view.")
	public void the_system_saves_and_goes(String goheavy_view) {
		driverSteps.the_system_saves_and_goes();
	}
	
	@When("User clicks on \"Edit Driver\" button.")
	public void user_click_edit() {
		driverSteps.userClickEdit();
	}
	
	@Then("The system opens the \"Edit Driver\" view.")
	public void system_opens_edit() {
		driverSteps.systemOpensEdit();
	}
	
	@When("User clicks on Assign button that belong to a \"Vehicle\".")
	public void user_clicks_on_assign_button() {
		driverSteps.user_clicks_on_assign_button();
	}
}
