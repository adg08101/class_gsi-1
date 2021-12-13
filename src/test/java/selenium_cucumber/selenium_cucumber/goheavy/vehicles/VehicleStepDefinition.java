package selenium_cucumber.selenium_cucumber.goheavy.vehicles;

import io.cucumber.java.en.*;
import selenium_cucumber.selenium_cucumber.general.GeneralSteps;

public class VehicleStepDefinition {
	private VehicleStep vehicleStep;
	@SuppressWarnings("unused")
	private GeneralSteps generalSteps;

	public VehicleStepDefinition() {
		vehicleStep = new VehicleStep();
		generalSteps = new GeneralSteps();
	}
	
	@When("User clicks on \"Add Vehicle\" button.")
	public void the_user_clicks_on_add_vehicle_button() {
		try {
			vehicleStep.userClicksOnAddVehicleButton();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Then("The system opens the \"Add Vehicle\" view.")
	public void the_system_opens_the_add_vehicle_view() {
		try {
			vehicleStep.theSystemOpensTheAddVehicleView();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@When("Hover over a Vehicle document image component with an image loaded.")
	public void hover_over_image_component_with_image() {
		try {
			vehicleStep.hoverOverImageComponent();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@When("The user inserts valid data AND clicks on the \"Done\" button.")
	public void the_user_inserts_valid_data_and_clicks_done_button() {
		try {
			vehicleStep.userInsertsValidDataAndClicksDone();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Improve this to meet the other NF requirement
	@Then("The System Creates a new Vehicle in {string} status.")
	public void the_system_creates_vahicle_and_registers_date(String status) {
		try {
			vehicleStep.systemCreatesVehicleOnStatus(status);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@And("The System registers the creation date.")
	public void the_system_registers_the_creation_date() {
		try {
			vehicleStep.systemRegistersCreationDate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Then("Returns to the \"Vehicles & Insurance List\" view and displays {string}.")
	public void returns_to_view_and_displays_message(String message) {
		try {
			vehicleStep.returnToViewAndDisplaysMessage(message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Then("The system displays \"Assign Vehicle\" view.")
	public void system_dsiplays_assign_view() {
		try {
			vehicleStep.systemDisplaysAssignView();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@When("User assigns the vehicle.")
	public void user_assigns_the_vehicle() {
		try {
			vehicleStep.userAssignsTheVehicle();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
