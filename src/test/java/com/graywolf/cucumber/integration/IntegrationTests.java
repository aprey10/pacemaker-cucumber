package com.graywolf.cucumber.integration;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by graywolf on 8/8/16.
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = "html:output", features = "src/test/resources")
public class IntegrationTests {
}
