package co.com.appium.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LogInPage extends PageObjectMobile {

  @FindBy(accessibilityId = "userInput")
  private WebElementFacade textUsername;

  @FindBy(accessibilityId = "passwordInput")
  private WebElementFacade textPassword;

  @FindBy(accessibilityId = "logInButton")
  private WebElementFacade buttonLogIn;

  public LogInPage() {
    super();
  }

  public void enterUsername(String username) {
    typeText(textUsername, username);
  }

  public void enterPassword(String password) {
    typeText(textPassword, password);
  }

  public void selectLogIn() {
    selectWebElement(buttonLogIn);
  }
}
