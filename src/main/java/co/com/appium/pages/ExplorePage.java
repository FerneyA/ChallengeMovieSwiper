package co.com.appium.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ExplorePage extends PageObjectMobile {

  @FindBy(xpath = "//android.widget.TextView[contains(@text, 'Explore')]")
  private WebElementFacade buttonExplore;

  @FindBy(xpath = "//android.view.ViewGroup[@index='1']")
  private WebElementFacade movieContainer;

  private static final String XPATH_RANDOM_MOVIE =
      "//android.widget.TextView[@text='Browse']//parent::android.view.ViewGroup[@index='0']//parent::android.view.ViewGroup[@index='0']//parent::android.view.ViewGroup[@index='0']//parent::android.view.ViewGroup[@index='2']//parent::android.view.ViewGroup[@index='0']//*//android.view.ViewGroup[@index='1']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']";

  private static final String XPATH_SELECTED_MOVIE =
      "//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='2']/android.widget.TextView[@index='1']";

  public ExplorePage() {
    super();
  }

  public void selectOptionExplore() {
    selectWebElement(buttonExplore);
    movieContainer.waitUntilVisible().waitUntilEnabled();
  }

  public void selectRandomMovieWithSwipeAnimation() {
    int randomNumbre = generateRandomNumber(10);
    for (int x = 1; x <= randomNumbre; x++) {
      if (x == randomNumbre) {
        movieContainer.waitUntilVisible().waitUntilEnabled();
        getWebElementByXpath(XPATH_RANDOM_MOVIE).click();
        String textMovie = getWebElementByXpath(XPATH_SELECTED_MOVIE).getText();
        Serenity.setSessionVariable("sessionMovieName").to(textMovie);
        horizontalRightScrolling();
      } else {
        horizontalLeftScrolling();
      }
    }
  }
}
