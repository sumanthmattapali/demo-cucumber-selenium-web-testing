package es.s2o.selenium.stepsdefs.cucumber;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import es.s2o.selenium.domain.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class MatchingStepsDefinition {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Given("^I have (\\d+) in my account$")
    public void iHave$InMyAccount(int arg0) throws Throwable {
        LOGGER.debug("iHave$InMyAccount");
    }
    

    @Then("^(\\d+) should be dispensed$")
    public void shouldBeDispensed(int arg0) throws Throwable {
        LOGGER.debug("shouldBeDispensed:[{}]", arg0);
    }

    @When("^I demand$")
    public void iDemand(DataTable dataTable) throws Throwable {
        List<Items> items = dataTable.asList(Items.class);
        LOGGER.debug("iRequest: "+ items);
    }

    @When("^I (?:demand|request) (\\d+) pineapple?.$")
    public void iRequestPineapple(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
