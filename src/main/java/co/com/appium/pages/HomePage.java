package co.com.appium.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePage extends PageObjectMobile {

  @FindBy(xpath = "//android.widget.TextView[contains(@text, 'Log In')]")
  private WebElementFacade buttonLogIn;

  @FindBy(xpath = "//android.view.ViewGroup[@content-desc='continueAsGuest']")
  private WebElementFacade buttonContinueAsGuest;

  public HomePage() {
    super();
  }

  public void selectLogIn() {
    selectWebElement(buttonLogIn);
  }

  public void selectContinueAsGuest() {
    selectWebElement(buttonContinueAsGuest);
  }
}
