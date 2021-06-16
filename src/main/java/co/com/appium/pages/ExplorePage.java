package co.com.appium.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ExplorePage extends PageObjectMobile {

  @FindBy(xpath = "//android.widget.TextView[contains(@text, 'Explore')]")
  private WebElementFacade buttonExplore;

  @FindBy(xpath = "//android.view.ViewGroup[@index='1']")
  private WebElementFacade movieContainer;

  @FindBy(
      xpath =
          "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout[@index='0']//*//android.view.ViewGroup[@index='1']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']")
  private WebElementFacade swipeContainer;

  public ExplorePage() {
    super();
  }

  public void selectOptionExplore() {
    selectWebElement(buttonExplore);
    movieContainer.waitUntilVisible().waitUntilEnabled();
    Serenity.setSessionVariable("SessionMovieName").to(swipeContainer.getAttribute("content-desc"));
  }
}
