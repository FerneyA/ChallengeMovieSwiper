package co.com.appium.pages;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import java.util.Random;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class PageObjectMobile extends PageObject {

  protected MobileDriver mobileDriver;
  protected AndroidDriver androidDriver;
  protected TouchAction touchAction;
  protected Dimension dimensions;

  public PageObjectMobile() {
    mobileDriver = getProxiedDriver();
    androidDriver = getProxiedDriver();
    touchAction = new TouchAction(mobileDriver);
    dimensions = mobileDriver.manage().window().getSize();
  }

  public void typeText(WebElementFacade webElementFacade, String text) {
    webElementFacade.type(text);
  }

  public void selectWebElement(WebElementFacade webElementFacade) {
    webElementFacade.waitUntilClickable().click();
  }

  public String getTextWebElement(WebElementFacade webElementFacade) {
    return webElementFacade.getText();
  }

  public void waitObjectVisibility(WebElementFacade webElementFacade) {
    webElementFacade.waitUntilVisible();
  }

  public WebElement getWebElementWithText(String text) {
    return getDriver()
        .findElement(
            By.xpath(
                "//android.view.ViewGroup[@index='0']/android.widget.TextView[@text='"
                    + text
                    + "']"));
  }

  public WebElement getWebElementByXpath(String xpath) {
    return getDriver().findElement(By.xpath(xpath));
  }

  public void selectWebElementWithTwoTexts(String text1, String text2) {
    getDriver()
        .findElement(
            By.xpath(
                "//android.view.ViewGroup[@content-desc='"
                    + text1
                    + "']/android.widget.TextView[@text='"
                    + text2
                    + "']"))
        .click();
  }

  public void verticalScrolling() {
    int width = dimensions.width;
    int height = dimensions.height;
    int middleOfX = width / 2;
    int startYCoordinate = (int) (height * .9);
    int endYCoordinate = (int) (height * .2);
    touchAction
        .press(point(middleOfX, startYCoordinate))
        .waitAction(waitOptions(ofSeconds(2)))
        .moveTo(point(middleOfX, endYCoordinate))
        .release()
        .perform();
  }

  public void horizontalRightScrolling() {
    int width = dimensions.width;
    int height = dimensions.height;
    int middleOfY = height / 2;
    int startXCoordinate = (int) (width * .2);
    int endXCoordinate = (int) (width * .9);
    touchAction
        .press(point(startXCoordinate, middleOfY))
        .waitAction(waitOptions(ofSeconds(2)))
        .moveTo(point(endXCoordinate, middleOfY))
        .release()
        .perform();
  }

  public void horizontalLeftScrolling() {
    int width = dimensions.width;
    int height = dimensions.height;
    int middleOfY = height / 2;
    int startXCoordinate = (int) (width * .9);
    int endXCoordinate = (int) (width * .2);
    touchAction
        .press(point(startXCoordinate, middleOfY))
        .waitAction(waitOptions(ofSeconds(2)))
        .moveTo(point(endXCoordinate, middleOfY))
        .release()
        .perform();
  }

  public int generateRandomNumber(int number) {
    return new Random().nextInt(number) + 1;
  }
}
