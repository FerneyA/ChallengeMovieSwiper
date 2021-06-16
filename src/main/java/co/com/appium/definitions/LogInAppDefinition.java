package co.com.appium.definitions;

import co.com.appium.steps.LogInAppStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LogInAppDefinition {

  @Steps LogInAppStep logInAppStep;

  @Given("user with username: {string} and password: {string} is logged into the movieSwiper app")
  @When("user enter username: {string} and password: {string}")
  public void userEnterUsernameAndPassword(String username, String password) {
    logInAppStep.logInApp(username, password);
  }

  @Then("the library section should contain the message: {string}")
  public void theLibrarySectionShouldContainTheMessage(String message) {
    logInAppStep.validateMessageUserLoggedLibrarySection(message);
  }

  @When("user enters as guest")
  public void userEntersAsGuest() {
    logInAppStep.enterAsGuestUser();
  }

  @Then("the guest user should see the message: {string}")
  public void guestUserShouldSeeMessage(String message) {
    logInAppStep.validateMessageGuestUser(message);
  }
}
