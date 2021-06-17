package co.com.appium.pages;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

public class BrowsePage extends PageObjectMobile {

  @FindBy(xpath = "//android.widget.TextView[contains(@text, 'Browse')]")
  private WebElementFacade labelBrowse;

  @FindBy(xpath = "//android.widget.TextView[contains(@text, 'Top Rated')]")
  private WebElementFacade labelTopRated;

  @FindBy(
      xpath =
          "//android.view.ViewGroup[@content-desc='Top_Rated_section']/android.view.ViewGroup[1]")
  private WebElementFacade linkMoreTopRated;

  @FindBy(xpath = "//android.widget.TextView[@text='Save']")
  private WebElementFacade buttonSave;

  @FindBy(xpath = "//android.widget.EditText[@content-desc='search']")
  private WebElementFacade textSearchMovie;

  @FindBy(xpath = "//android.widget.TextView[@text='Favorite']")
  private WebElementFacade buttonFavorite;

  private static final String SESSION_MOVIE_NAME = "sessionMovieName";
  private static final String XPATH_RANDOM_MOVIE =
      "//android.widget.ScrollView[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='1']";

  public BrowsePage() {
    super();
  }

  public void selectMoreTopRated() {
    selectWebElement(linkMoreTopRated);
  }

  public void waitVisibilityLabelBrowse() {
    waitObjectVisibility(labelBrowse);
  }

  public void waitVisibilityLabelTopRated() {
    waitObjectVisibility(labelTopRated);
  }

  public void selectRandomMovie() {
    for (int x = 1; x <= generateRandomNumber(10); x++) {
      verticalScrolling();
    }
    WebElement webElement = getWebElementByXpath(XPATH_RANDOM_MOVIE);
    Serenity.setSessionVariable(SESSION_MOVIE_NAME).to(webElement.getText());
    webElement.click();
  }

  public void selectButtonSave() {
    selectWebElement(buttonSave);
  }

  public void selectButtonFavorite() {
    selectWebElement(buttonFavorite);
  }

  public boolean isMovieNameContainedInList() {
    String movieName = Serenity.sessionVariableCalled(SESSION_MOVIE_NAME).toString();
    return getWebElementWithText(movieName).isDisplayed();
  }

  public void deleteMovieInMyWatchlist() {
    String movieName = Serenity.sessionVariableCalled(SESSION_MOVIE_NAME).toString();
    getWebElementWithText(movieName).click();
    selectWebElement(buttonSave);
  }

  public void searchMovie(String movieName) {
    selectWebElement(textSearchMovie);
    typeText(textSearchMovie, movieName);
    androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
  }

  public void selectMovie(String movieName, String year) {
    selectWebElementWithTwoTexts(movieName, year);
  }

  public boolean isMovieNameContainedInListFavorite(String movieName) {
    return getWebElementWithText(movieName).isDisplayed();
  }

  public void deleteMovieInFavorite(String movieName) {
    getWebElementWithText(movieName).click();
    selectWebElement(buttonFavorite);
  }
}
