package selenium_cucumber.selenium_cucumber.goheavy.account;

import io.cucumber.java.en.*;

public class AccountStepDefinition {

	private final AccountStep accountStep;

	public AccountStepDefinition() {
		accountStep = new AccountStep();
	}

	@Given("The user is in  \"Account Settings\" view")
	public void the_user_is_in_view() {
		accountStep.openAccountSetting();
		accountStep.checkPage();
	}

	@When("User insert valid data")
	public void user_insert_valid_data() {
		accountStep.fillValidData();
	}

	@When("clicks on the \"Update\" button")
	public void clicks_on_the_button() {
		accountStep.clicksUpdate();
	}

	@Then("The system saves the user profile information")
	public void the_system_saves_the_user_profile_information() {
		accountStep.checkSpinningAppears();
	}

	@Then("The system displays popup with success message: {string}")
	public void the_system_displays_popup_with_success_message(String string) {
		accountStep.checkUpdateMessage(string);
	}
}
