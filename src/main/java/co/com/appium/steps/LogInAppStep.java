package co.com.appium.steps;

import co.com.appium.pages.HomePage;
import co.com.appium.pages.LibraryPage;
import co.com.appium.pages.LogInPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class LogInAppStep {

  @Page HomePage homePage;

  @Page LogInPage logInPage;

  @Page LibraryPage libraryPage;

  @Step
  public void logInApp(String username, String password) {
    homePage.selectLogIn();
    logInPage.enterUsername(username);
    logInPage.enterPassword(password);
    logInPage.selectLogIn();
  }

  @Step
  public void validateMessageUserLoggedLibrarySection(String message) {
    String messageObtained;
    libraryPage.selectOptionLibrary();
    libraryPage.selectButtonConfig();
    messageObtained = libraryPage.getMessageUserLogged();
    MatcherAssert.assertThat(
        "There are differences, expected message: "
            + message
            + " message obtained: "
            + messageObtained,
        messageObtained.contains(message));
  }

  public void validateMessageGuestUser(String message) {
    String messageGuestUser;
    libraryPage.selectOptionLibrary();
    messageGuestUser = libraryPage.getMessageGuestUser();
    MatcherAssert.assertThat(
        "There are differences, expected message: "
            + message
            + " message obtained: "
            + messageGuestUser,
        messageGuestUser.equals(message));
  }

  public void enterAsGuestUser() {
    homePage.selectContinueAsGuest();
  }
}
