package co.com.appium.definitions;

import co.com.appium.steps.ManageUserMovieStep;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ManageUserMovieDefinition {

  @Steps ManageUserMovieStep manageUserMovieStep;

  @When("user randomly selects a movie from the top rated list and saves it to watchlist")
  public void userRandomlySelectsAMovie() {
    manageUserMovieStep.selectAMovieRandomlyAndSavesIt();
  }

  @Then("the random movie should be added to watchlist in the library section")
  public void theRandomMovieShouldBeAddedToWatchlist() {
    manageUserMovieStep.validateRandomMovieInWatchList();
  }

  @When("user selects the movie: {string} of the year: {string} and add it to favorites")
  public void selectMovieAndAddToFavorites(String movieName, String year) {
    manageUserMovieStep.selectMovieAndAddToFavorites(movieName, year);
  }

  @Then("the movie: {string} should be added to favorites in the library section")
  public void theMovieShouldBeAddedToFavorites(String movieName) {
    manageUserMovieStep.validateMovieInFavorites(movieName);
  }

  @When("user selects a movie with swipe animation in the explore section")
  public void userSelectsMovieWithSwipeAnimation() {
    manageUserMovieStep.selectMovieWithSwipeAnimation();
  }
}
