package com.wade.spring.examples.springcucumber.bagextra;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/bagextra", plugin = { "pretty",
		"html:target/cucumber/bagextra" }, extraGlue = "com.wade.spring.examples.springcucumber.bagcommons")
public class BagExtraCucumberIntegrationTest {
}
