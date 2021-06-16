package co.com.appium.pages;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class BrowsePage extends PageObjectMobile {

  @FindBy(xpath = "//android.widget.TextView[contains(@text, 'Browse')]")
  private WebElementFacade labelBrowse;

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

  private static final String SESSION_MOVIE_NAME = "SessionMovieName";

  public BrowsePage() {
    super();
  }

  public void selectMoreTopRated() {
    selectWebElement(linkMoreTopRated);
  }

  public void waitObjectVisibility() {
    labelBrowse.waitUntilVisible();
  }

  public void selectRandomMovie() {
    String movieName = super.generateRandomMovie();
    Serenity.setSessionVariable(SESSION_MOVIE_NAME).to(movieName);
    getWebElementWithText(movieName).click();
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
