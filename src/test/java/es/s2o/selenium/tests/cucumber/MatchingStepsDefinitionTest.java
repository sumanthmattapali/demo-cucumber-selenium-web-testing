package es.s2o.selenium.tests.cucumber;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/cucumber/matching_steps.feature",
        glue = "es.s2o.selenium.stepsdefs.cucumber")
public class MatchingStepsDefinitionTest {}
