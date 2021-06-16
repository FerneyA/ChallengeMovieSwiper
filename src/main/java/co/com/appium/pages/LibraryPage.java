package co.com.appium.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LibraryPage extends PageObjectMobile {

  @FindBy(xpath = "//android.widget.TextView[contains(@text, 'Library')]")
  private WebElementFacade buttonLibrary;

  @FindBy(xpath = "//android.widget.TextView[contains(@text, 'You are logged in as farroyave')]")
  private WebElementFacade labelMessageUserLogged;

  @FindBy(
      xpath =
          "//android.widget.TextView[contains(@text, 'Library')]//parent::android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='3']/android.view.ViewGroup[@index='0']")
  private WebElementFacade buttonConfig;

  @FindBy(xpath = "//android.widget.TextView[@text='My Watchlist']")
  private WebElementFacade linkMyWatchlist;

  @FindBy(xpath = "//android.widget.TextView[@text='My Favorite']")
  private WebElementFacade linkMyFavorite;

  @FindBy(
      xpath =
          "//android.view.ViewGroup[@index='4']/android.view.ViewGroup[@index='0']/android.widget.ScrollView[@index='0']/android.view.ViewGroup[@index='0']")
  private WebElementFacade viewMovie;

  @FindBy(xpath = "//android.widget.TextView[@text='Only for authenticated users']")
  private WebElementFacade labelGuestUserMessage;

  public LibraryPage() {
    super();
  }

  public void selectOptionLibrary() {
    selectWebElement(buttonLibrary);
  }

  public void selectButtonConfig() {
    selectWebElement(buttonConfig);
  }

  public String getMessageUserLogged() {
    return getTextWebElement(labelMessageUserLogged);
  }

  public void selectOptionMyWatchlist() {
    selectWebElement(linkMyWatchlist);
  }

  public void selectOptionMyFavorite() {
    selectWebElement(linkMyFavorite);
  }

  public String getMessageGuestUser() {
    return getTextWebElement(labelGuestUserMessage);
  }
}
