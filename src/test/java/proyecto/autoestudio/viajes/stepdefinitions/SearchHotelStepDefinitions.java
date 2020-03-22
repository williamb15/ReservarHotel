package proyecto.autoestudio.viajes.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static proyecto.autoestudio.viajes.questions.ValidateName.*;
import static proyecto.autoestudio.viajes.userinterface.ResultPage.*;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import proyecto.autoestudio.viajes.exceptions.SearchHotelExceptions;
import proyecto.autoestudio.viajes.models.TravelFeatures;
import net.serenitybdd.screenplay.actors.OnStage;
import proyecto.autoestudio.viajes.task.AnalyzeResult;
import proyecto.autoestudio.viajes.task.SearchHotel;

public class SearchHotelStepDefinitions extends GeneralStepDefinitions{

  @Before
  public void config() {
    setUp();
  }

  @Given("^the user is on the main trivago page and enters the data$")
  public void theUserIsOnTheMainTrivagoPageAndEntersTheData(List<TravelFeatures> list) {
    OnStage.theActorInTheSpotlight().wasAbleTo(SearchHotel.withData(list));
  }

  @When("^he analyzes the results and selects the cheapest$")
  public void heAnalyzesTheResultsAndSelectsTheCheapest() {
    OnStage.theActorInTheSpotlight().attemptsTo(AnalyzeResult.ofTheList());
  }

  @Then("^he will be able to see on the page the cheapest hotel$")
  public void heWillBeAbleToSeeOnThePageTheCheapestHotel() {
    OnStage.theActorInTheSpotlight().should(
        seeThat(ofTheHotel(LABEL_NAME_HOTEL, LABEL_NAME_HOTEL_SECOND_OPTION))
            .orComplainWith(SearchHotelExceptions.class));
  }
}