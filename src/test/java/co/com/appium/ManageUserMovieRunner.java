package co.com.appium;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/manage_user_movie.feature",
    glue = {"co.com.appium.definitions"},
    snippets = CucumberOptions.SnippetType.CAMELCASE)
public class ManageUserMovieRunner {}
