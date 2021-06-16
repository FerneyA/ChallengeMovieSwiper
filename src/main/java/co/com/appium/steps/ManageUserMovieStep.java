package co.com.appium.steps;

import co.com.appium.pages.BrowsePage;
import co.com.appium.pages.ExplorePage;
import co.com.appium.pages.LibraryPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class ManageUserMovieStep {

  @Page BrowsePage browsePage;

  @Page LibraryPage libraryPage;

  @Page ExplorePage explorePage;

  @Step
  public void selectAMovieRandomlyAndSavesIt() {
    browsePage.waitObjectVisibility();
    browsePage.verticalScrolling();
    browsePage.selectMoreTopRated();
    browsePage.selectRandomMovie();
    browsePage.selectButtonSave();
  }

  @Step
  public void validateRandomMovieInWatchList() {
    libraryPage.selectOptionLibrary();
    libraryPage.selectOptionMyWatchlist();
    MatcherAssert.assertThat(
        "The movie is not contained in the watchlist.", browsePage.isMovieNameContainedInList());
    browsePage.deleteMovieInMyWatchlist();
  }

  @Step
  public void selectMovieAndAddToFavorites(String movieName, String year) {
    browsePage.searchMovie(movieName);
    browsePage.selectMovie(movieName, year);
    browsePage.selectButtonFavorite();
  }

  @Step
  public void validateMovieInFavorites(String movieName) {
    libraryPage.selectOptionLibrary();
    libraryPage.selectOptionMyFavorite();
    MatcherAssert.assertThat(
        "The movie is not contained in the Favorite.",
        browsePage.isMovieNameContainedInListFavorite(movieName));
    browsePage.deleteMovieInFavorite(movieName);
  }

  @Step
  public void selectMovieWithSwipeAnimation() {
    browsePage.waitObjectVisibility();
    explorePage.selectOptionExplore();
    explorePage.horizontalScrolling();
  }
}
